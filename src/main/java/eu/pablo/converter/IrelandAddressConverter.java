package eu.pablo.converter;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Component;

import eu.pablo.entity.Address;
import eu.pablo.entity.IrelandAddress;
import eu.pablo.model.IrelandAddressCoordinateLookupModel;
import eu.pablo.model.IrelandAddressModel;
import eu.pablo.model.IrelandAddressWhat3WordsModel;

@Component("irelandAddressConverter")
public class IrelandAddressConverter {

	public IrelandAddressModel entity2model(Address addr){
		return new IrelandAddressModel(addr.getAddressline1(),
				addr.getAddressline2(),
				addr.getSummaryline(),
				addr.getOrganisation(),
				addr.getStreet(),
				addr.getPosttown(),
				addr.getCounty(),
				addr.getPostcode());
	}
	
	public List<IrelandAddressModel> entities2models(List<IrelandAddress> addrs){
		ArrayList<IrelandAddressModel> addressesRes = new ArrayList<>();
		if(addrs == null || addrs.size() ==0)
			return addressesRes;
	
		for(Address addr : addrs){
			addressesRes.add(entity2model(addr));
		}
		return addressesRes;
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
	
	public List<IrelandAddressCoordinateLookupModel> entities2CoordModels(List<IrelandAddress> addrs){
		ArrayList<IrelandAddressCoordinateLookupModel> addressesRes = new ArrayList<>();
		if(addrs == null || addrs.size() ==0)
			return addressesRes;
	
		for(IrelandAddress addr : addrs){
			if(addr.isGeoValid())
				addressesRes.add(entity2CoordModel(addr));
		}
		return addressesRes;
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
	
	public List<IrelandAddressWhat3WordsModel> entities2WWmodels(List<IrelandAddress> addrs){
		ArrayList<IrelandAddressWhat3WordsModel> addressesRes = new ArrayList<>();
		if(addrs == null || addrs.size() ==0)
			return addressesRes;
	
		for(IrelandAddress addr : addrs){
			if(addr.isW3WValid())
				addressesRes.add(entity2WWmodel(addr));
		}
		return addressesRes;
	}
	
	public IrelandAddress model2entity(IrelandAddressModel addrModel){
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
