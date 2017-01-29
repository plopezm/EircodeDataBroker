package eu.pablo.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import eu.pablo.converter.IrelandAddressConverter;
import eu.pablo.entity.IrelandAddress;
import eu.pablo.model.IrelandAddressModel;
import eu.pablo.model.IrelandAddressCoordinateLookupModel;
import eu.pablo.model.IrelandAddressWhat3WordsModel;
import eu.pablo.repository.IrelandAddressJpaRepository;
import eu.pablo.service.IrelandAddressService;

@Service("irelandAddressServiceImpl")
public class IrelandAddressServiceImpl implements IrelandAddressService {
	
	//private static final Log LOG = LogFactory.getLog(IrelandAddressServiceImpl.class);

	@Autowired
	private IrelandAddressJpaRepository irelandAddressJpaRepository;
	
	@Autowired
	@Qualifier("irelandAddressConverter")
	private IrelandAddressConverter irelandAddressConverter;
	
	public IrelandAddressServiceImpl() {
	}

	@Override
	public IrelandAddressModel findByPostcode(String postcode) {
		IrelandAddress ia = irelandAddressJpaRepository.findByPostcode(postcode);
		if(ia == null)
			return null;
		return irelandAddressConverter.entity2model(ia);
	}

	@Override
	public IrelandAddressCoordinateLookupModel findCoordinateLookupByPostcode(String postcode) {
		IrelandAddress ia = irelandAddressJpaRepository.findByPostcode(postcode);
		if(ia == null || !ia.isGeoValid())
			return null;
		return irelandAddressConverter.entity2CoordModel(ia);
	}

	@Override
	public IrelandAddressWhat3WordsModel findWhat3WordsByPostcode(String postcode) {
		IrelandAddress ia = irelandAddressJpaRepository.findByPostcode(postcode);
		if(ia == null || !ia.isW3WValid())
			return null;
		return irelandAddressConverter.entity2WWmodel(ia);
	}

	@Override
	public IrelandAddressModel insertIrelandAddress(IrelandAddressModel am) {
		if(am == null)
			return null;
		IrelandAddress ia = irelandAddressJpaRepository.save(irelandAddressConverter.model2entity(am));
		return irelandAddressConverter.entity2model(ia);
	}

	@Override
	public IrelandAddressCoordinateLookupModel insertIrelandAddress(IrelandAddressCoordinateLookupModel am) {
		if(am == null)
			return null;
		IrelandAddress ia = irelandAddressJpaRepository.save(irelandAddressConverter.model2entity(am));
		return irelandAddressConverter.entity2CoordModel(ia);
	}

	@Override
	public IrelandAddressWhat3WordsModel insertIrelandAddress(IrelandAddressWhat3WordsModel am) {
		if(am == null)
			return null;
		IrelandAddress ia = irelandAddressJpaRepository.save(irelandAddressConverter.model2entity(am));
		return irelandAddressConverter.entity2WWmodel(ia);
	}

	@Override
	public IrelandAddressModel removeIrelandAddress(IrelandAddressModel am) {
		if(am == null)
			return null;
		int res = irelandAddressJpaRepository.deleteByPostcode(am.getPostcode());
		if(res>0)
			return am;
		return null;
	}
	
}
