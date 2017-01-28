package eu.pablo.converter;

import org.springframework.stereotype.Controller;

import eu.pablo.entity.UKAddress;
import eu.pablo.model.UkAddressModel;

@Controller("ukAddressConverter")
public class UkAddressConverter {

	public UkAddressModel entity2model(UKAddress addr){
		return new UkAddressModel(addr.getAddressline1(),
				addr.getAddressline2(),
				addr.getSummaryline(),
				addr.getOrganisation(),
				addr.getStreet(),
				addr.getPosttown(),
				addr.getCounty(),
				addr.getPostcode(),
				addr.getAddressline3(),
				addr.getBuildingname(),
				addr.getPremise(),
				addr.getDependentlocality());
	}
	
	public UKAddress model2entity(UkAddressModel addrModel){
		return new UKAddress(0, addrModel.getAddressline1(),
				addrModel.getAddressline2(),
				addrModel.getSummaryline(),
				addrModel.getOrganisation(),
				addrModel.getStreet(),
				addrModel.getPosttown(),
				addrModel.getCounty(),
				addrModel.getPostcode(),
				addrModel.getAddressline3(),
				addrModel.getBuildingname(),
				addrModel.getPremise(),
				addrModel.getDependentlocality());
	}
}
