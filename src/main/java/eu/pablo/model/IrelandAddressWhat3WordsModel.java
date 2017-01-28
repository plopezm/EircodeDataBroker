package eu.pablo.model;

public class IrelandAddressWhat3WordsModel extends AddressModel {

	private String what3words;
	
	public IrelandAddressWhat3WordsModel(){
	}

	public IrelandAddressWhat3WordsModel(String addressline1, String addressline2, String summaryline,
			String organisation, String street, String posttown, String county, String postcode, String what3words) {
		super(addressline1, addressline2, summaryline, organisation, street, posttown, county, postcode);
		this.what3words = what3words;
	}

	public String getWhat3words() {
		return what3words;
	}

	public void setWhat3words(String what3words) {
		this.what3words = what3words;
	}

	@Override
	public String toString() {
		return "IrelandAddressWhat3WordsModel [what3words=" + what3words + ", getAddressline1()=" + getAddressline1()
				+ ", getAddressline2()=" + getAddressline2() + ", getSummaryline()=" + getSummaryline()
				+ ", getOrganisation()=" + getOrganisation() + ", getStreet()=" + getStreet() + ", getPosttown()="
				+ getPosttown() + ", getCounty()=" + getCounty() + ", getPostcode()=" + getPostcode() + ", toString()="
				+ super.toString() + ", getClass()=" + getClass() + ", hashCode()=" + hashCode() + "]";
	}
}
