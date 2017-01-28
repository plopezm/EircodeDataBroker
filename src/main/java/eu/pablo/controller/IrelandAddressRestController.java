package eu.pablo.controller;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import eu.pablo.converter.IrelandAddressConverter;
import eu.pablo.model.IrelandAddressCoordinateLookupModel;
import eu.pablo.model.IrelandAddressModel;
import eu.pablo.service.IrelandAddressService;

@RestController
@RequestMapping("/pcw")
public class IrelandAddressRestController {
	
	private static Log LOGGER = LogFactory.getLog(IrelandAddressRestController.class);
	
	@Autowired
	@Qualifier("irelandAddressServiceImpl")
	private IrelandAddressService irelandAddressService;
	
	@GetMapping("/{api_key}/address/ie/{postcode}")
	public ResponseEntity<IrelandAddressModel> fetchIrelandAddressModel(
			@PathVariable("api_key") String apiKey,
			@PathVariable("postcode") String postcode,
			@RequestParam(name="format") String format){
		LOGGER.info("apiKey = "+apiKey+", postcode = "+postcode+" format="+format);
		IrelandAddressModel iam = irelandAddressService.findByPostcode(postcode);
		LOGGER.info("Address found: "+iam);
		if (iam == null)
			return new ResponseEntity<IrelandAddressModel>(HttpStatus.NOT_FOUND);
		return new ResponseEntity<IrelandAddressModel>(iam, HttpStatus.OK);
	}
	
	@GetMapping("/{api_key}/addressgeo/ie/{postcode}")
	public IrelandAddressCoordinateLookupModel fetchIrelandAddressCoordinateLookupModel(
			@PathVariable("api_key") String apiKey,
			@PathVariable("postcode") String postcode,
			@RequestParam(name="format") String format){
		return irelandAddressService.findCoordinateLookupByPostcode(postcode);
	}
}
