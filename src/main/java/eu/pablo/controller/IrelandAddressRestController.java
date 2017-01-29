package eu.pablo.controller;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import eu.pablo.component.IrelandAddressRestClientManager;
import eu.pablo.model.IrelandAddressCoordinateLookupModel;
import eu.pablo.model.IrelandAddressModel;
import eu.pablo.service.IrelandAddressService;

@RestController
@RequestMapping("/pcw/{api_key}")
public class IrelandAddressRestController {
	
	private static Log LOGGER = LogFactory.getLog(IrelandAddressRestController.class);
	
	@Autowired
	@Qualifier("irelandAddressServiceImpl")
	private IrelandAddressService irelandAddressService;
	
	@Autowired
	@Qualifier("irelandAddressRestClientManager")
	private IrelandAddressRestClientManager irelandAddressRestClientManager;
	
	private ResponseEntity<IrelandAddressModel> searchMainRepositoryIrlandAddress(String apiKey, String postcode, String format){
		ResponseEntity<IrelandAddressModel[]> reiam = irelandAddressRestClientManager.getIrelandAddressModel(apiKey, postcode, format);
		if(reiam == null || reiam.getBody() == null || reiam.getBody().length == 0)
			return new ResponseEntity<IrelandAddressModel>(HttpStatus.NOT_FOUND);
			
		IrelandAddressModel iam = irelandAddressService.insertIrelandAddress(reiam.getBody()[0]);
		if (iam ==  null)
			return new ResponseEntity<IrelandAddressModel>(HttpStatus.INTERNAL_SERVER_ERROR);
		
		return new ResponseEntity<IrelandAddressModel>(iam, HttpStatus.OK);
	}
	
	private ResponseEntity<IrelandAddressCoordinateLookupModel> searchMainRepositoryIrlandCoordinateAddressMode(String apiKey, String postcode, String format){
		ResponseEntity<IrelandAddressCoordinateLookupModel[]> reiam = irelandAddressRestClientManager.getIrelandCoordinateAddressModel(apiKey, postcode, format);
		if(reiam == null || reiam.getBody() == null || reiam.getBody().length == 0)
			return new ResponseEntity<IrelandAddressCoordinateLookupModel>(HttpStatus.NOT_FOUND);
			
		IrelandAddressCoordinateLookupModel iam = irelandAddressService.insertIrelandAddress(reiam.getBody()[0]);
		if (iam ==  null)
			return new ResponseEntity<IrelandAddressCoordinateLookupModel>(HttpStatus.INTERNAL_SERVER_ERROR);
		
		return new ResponseEntity<IrelandAddressCoordinateLookupModel>(iam, HttpStatus.OK);
	}
	
    @CrossOrigin(origins = "http://localhost:9000")
	@GetMapping("/address/ie/{postcode}")
	public ResponseEntity<IrelandAddressModel> fetchIrelandAddressModel(
			@PathVariable("api_key") String apiKey,
			@PathVariable("postcode") String postcode,
			@RequestParam(name="format") String format){
		IrelandAddressModel iam = irelandAddressService.findByPostcode(postcode);
		if (iam == null){
			return searchMainRepositoryIrlandAddress(apiKey, postcode, format);
		}
		return new ResponseEntity<IrelandAddressModel>(iam, HttpStatus.OK);
	}
	
    @CrossOrigin(origins = "http://localhost:9000")
	@GetMapping("/addressgeo/ie/{postcode}")
	public ResponseEntity<IrelandAddressCoordinateLookupModel> fetchIrelandAddressCoordinateLookupModel(
			@PathVariable("api_key") String apiKey,
			@PathVariable("postcode") String postcode,
			@RequestParam(name="format") String format){
		IrelandAddressCoordinateLookupModel iam = irelandAddressService.findCoordinateLookupByPostcode(postcode);
		if (iam == null){
			return searchMainRepositoryIrlandCoordinateAddressMode(apiKey, postcode, format);
		}
		return new ResponseEntity<IrelandAddressCoordinateLookupModel>(iam, HttpStatus.OK);
	}
}
