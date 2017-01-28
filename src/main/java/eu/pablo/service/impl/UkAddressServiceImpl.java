package eu.pablo.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import eu.pablo.converter.UkAddressConverter;
import eu.pablo.entity.UKAddress;
import eu.pablo.model.UkAddressModel;
import eu.pablo.repository.UKAddressJpaRepository;
import eu.pablo.service.UKAddressService;

@Service("ukAddressServiceImpl")
public class UkAddressServiceImpl implements UKAddressService {

	@Autowired
	private UKAddressJpaRepository ukAddressJpaRepository;
	
	@Autowired
	@Qualifier("ukAddressConverter")
	private UkAddressConverter ukAddressConverter;
	
	@Override
	public UkAddressModel findByPostcode(String postcode) {
		UKAddress uka = ukAddressJpaRepository.findByPostcode(postcode);
		if(uka == null)
			return null;
		return ukAddressConverter.entity2model(uka);
	}

	@Override
	public UkAddressModel insertUkAddress(UkAddressModel ukam) {
		if(ukam == null)
			return null;
		UKAddress uka = ukAddressJpaRepository.save(ukAddressConverter.model2entity(ukam));
		return ukAddressConverter.entity2model(uka);
	}

	@Override
	public UkAddressModel removeUkAddress(UkAddressModel ukam) {
		if(ukam == null)
			return null;
		int res = ukAddressJpaRepository.deleteByPostcode(ukam.getPostcode());
		if(res>0)
			return ukam;
		return null;
	}

}
