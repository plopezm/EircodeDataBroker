package eu.pablo.service;

import eu.pablo.model.UkAddressModel;

public interface UKAddressService {
	public UkAddressModel findByPostcode(String postcode);
	public UkAddressModel insertUkAddress(UkAddressModel ia);
	public UkAddressModel removeUkAddress(UkAddressModel ia);
}
