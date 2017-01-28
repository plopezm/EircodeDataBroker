package eu.pablo.service;

import eu.pablo.model.IrelandAddressModel;
import eu.pablo.model.IrelandAddressCoordinateLookupModel;
import eu.pablo.model.IrelandAddressWhat3WordsModel;

public interface IrelandAddressService {
	
	public IrelandAddressModel findByPostcode(String postcode);
	public IrelandAddressCoordinateLookupModel findCoordinateLookupByPostcode(String postcode);
	public IrelandAddressWhat3WordsModel findWhat3WordsByPostcode(String postcode);

	public IrelandAddressModel insertIrelandAddress(IrelandAddressModel ia);
	public IrelandAddressCoordinateLookupModel insertIrelandAddress(IrelandAddressCoordinateLookupModel ia);
	public IrelandAddressWhat3WordsModel insertIrelandAddress(IrelandAddressWhat3WordsModel ia);

	public IrelandAddressModel removeIrelandAddress(IrelandAddressModel ia);
}
