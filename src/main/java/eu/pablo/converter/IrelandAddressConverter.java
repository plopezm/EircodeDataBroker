package eu.pablo.converter;

import org.springframework.stereotype.Component;

import eu.pablo.entity.Address;
import eu.pablo.entity.IrelandAddress;
import eu.pablo.model.AddressModel;
import eu.pablo.model.IrelandAddressCoordinateLookupModel;
import eu.pablo.model.IrelandAddressWhat3WordsModel;

@Component("irelandAddressConverter")
public class IrelandAddressConverter {

	public AddressModel entity2model(Address addr){
		return new AddressModel(addr.getAddressline1(),
				addr.getAddressline2(),
				addr.getSummaryline(),
				addr.getOrganisation(),
				addr.getStreet(),
				addr.getPosttown(),
				addr.getCounty(),
				addr.getPostcode());
	}
	
	public IrelandAddressCoordinateLookupModel entity2CoordModel(IrelandAddress addr){
		return new IrelandAddressCoordinateLookupModel(addr.getAddressline1(),
				addr.getAddressline2(),
				addr.getSummaryline(),
				addr.getOrganisation(),
				addr.getStreet(),
				addr.getPosttown(),
				addr.getCounty(),
				addr.getPostcode(),
				addr.getLatitude(),
				addr.getLongitude());
	}
	
	public IrelandAddressWhat3WordsModel entity2WWmodel(IrelandAddress addr){
		return new IrelandAddressWhat3WordsModel(addr.getAddressline1(),
				addr.getAddressline2(),
				addr.getSummaryline(),
				addr.getOrganisation(),
				addr.getStreet(),
				addr.getPosttown(),
				addr.getCounty(),
				addr.getPostcode(),
				addr.getWhat3words());
	}
	
	public IrelandAddress model2entity(AddressModel addrModel){
		return new IrelandAddress(0, addrModel.getAddressline1(),
				addrModel.getAddressline2(),
				addrModel.getSummaryline(),
				addrModel.getOrganisation(),
				addrModel.getStreet(),
				addrModel.getPosttown(),
				addrModel.getCounty(),
				addrModel.getPostcode(),
				"",
				"",
				"");
	}
	
	public IrelandAddress model2entity(IrelandAddressCoordinateLookupModel addrModel){
		return new IrelandAddress(0, addrModel.getAddressline1(),
				addrModel.getAddressline2(),
				addrModel.getSummaryline(),
				addrModel.getOrganisation(),
				addrModel.getStreet(),
				addrModel.getPosttown(),
				addrModel.getCounty(),
				addrModel.getPostcode(),
				addrModel.getLatitude(),
				addrModel.getLongitude(),
				"");
	}
	
	public IrelandAddress model2entity(IrelandAddressWhat3WordsModel addrModel){
		return new IrelandAddress(0, addrModel.getAddressline1(),
				addrModel.getAddressline2(),
				addrModel.getSummaryline(),
				addrModel.getOrganisation(),
				addrModel.getStreet(),
				addrModel.getPosttown(),
				addrModel.getCounty(),
				addrModel.getPostcode(),
				"",
				"",
				addrModel.getWhat3words());
	}
	
}
