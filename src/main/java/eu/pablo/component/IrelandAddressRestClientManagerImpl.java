package eu.pablo.component;

import java.util.HashMap;
import java.util.Map;

import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

import eu.pablo.model.IrelandAddressCoordinateLookupModel;
import eu.pablo.model.IrelandAddressModel;

@Component("irelandAddressRestClientManager")
public class IrelandAddressRestClientManagerImpl implements IrelandAddressRestClientManager{
	//MY API KEY
	//private static final String IRELAND_API_KEY = "PCWR4-5BCKC-9SDCS-3YK23";
	//DEMO API KEY
	private static final String IRELAND_API_KEY = "PCW45-12345-12345-1234X";
	
	private static final String IRELAND_ADDRESS_URL = "http://ws.postcoder.com/pcw/{api_key}/address/ie/{eircode}?format={format}";
	private static final String IRELAND_ADDRESSGEO_URL = "http://ws.postcoder.com/pcw/{api_key}/addressgeo/ie/{eircode}?format={format}";

	//http://ws.postcoder.com/pcw/[api-key]/address/ie/[eircode-or-address-fragment]
	//http://ws.postcoder.com/pcw/PCW45-12345-12345-1234X/address/ie/D02X285?lines=3&format=json
	//http://ws.postcoder.com/pcw/PCW45-12345-12345-1234X/addressgeo/ie/Adelaide%20Road?format=json
	//http://ws.postcoder.com/pcw/PCW45-12345-12345-1234X/addressgeo/ie/D02X285?format=json&addtags=w3w
	
	private RestTemplate rt;
	
	public IrelandAddressRestClientManagerImpl(){
		rt = new RestTemplate();
	}
	
	@Override
	public ResponseEntity<IrelandAddressModel[]> getIrlandAddressModel(String api_key, String postcode, String format){
		Map<String, String> variables = new HashMap<String, String>(3);
        variables.put("api_key", api_key);
        variables.put("eircode", postcode);
        variables.put("format", format);
        return rt.getForEntity(IRELAND_ADDRESS_URL, IrelandAddressModel[].class, variables);
	}
	
	@Override
	public ResponseEntity<IrelandAddressCoordinateLookupModel[]> getIrlandCoordinateAddressModel(String api_key, String postcode, String format){
		Map<String, String> variables = new HashMap<String, String>(3);
        variables.put("api_key", api_key);
        variables.put("eircode", postcode);
        variables.put("format", format);
		return rt.getForEntity(IRELAND_ADDRESSGEO_URL, IrelandAddressCoordinateLookupModel[].class, variables);
	}

}
