package eu.pablo.component;

import org.springframework.http.ResponseEntity;

import eu.pablo.model.IrelandAddressCoordinateLookupModel;
import eu.pablo.model.IrelandAddressModel;

public interface IrelandAddressRestClientManager {
	public ResponseEntity<IrelandAddressModel[]> getIrlandAddressModel(String postcode, String format);
	public ResponseEntity<IrelandAddressCoordinateLookupModel[]> getIrlandCoordinateAddressModel(String postcode, String format);
}
