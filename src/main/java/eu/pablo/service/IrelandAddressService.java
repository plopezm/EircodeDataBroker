package eu.pablo.service;

import eu.pablo.model.AddressModel;
import eu.pablo.model.IrelandAddressCoordinateLookupModel;
import eu.pablo.model.IrelandAddressWhat3WordsModel;

public interface IrelandAddressService {
	
	public AddressModel findByPostcode(String postcode);
	public IrelandAddressCoordinateLookupModel findCoordinateLookupByPostcode(String postcode);
	public IrelandAddressWhat3WordsModel findWhat3WordsByPostcode(String postcode);

	public AddressModel insertIrelandAddress(AddressModel ia);
	public IrelandAddressCoordinateLookupModel insertIrelandAddress(IrelandAddressCoordinateLookupModel ia);
	public IrelandAddressWhat3WordsModel insertIrelandAddress(IrelandAddressWhat3WordsModel ia);

	public AddressModel removeIrelandAddress(AddressModel ia);
}
