package eu.pablo.model;

public class UkAddressModel extends IrelandAddressModel {

	private String addressline3;
	private String buildingname;
	private String premise;
	private String dependentlocality;

	public UkAddressModel(){}
	
	public UkAddressModel(String addressline1, String addressline2, String summaryline, String organisation,
			String street, String posttown, String county, String postcode, String addressline3, String buildingname,
			String premise, String dependentlocality) {
		super(addressline1, addressline2, summaryline, organisation, street, posttown, county, postcode);
		this.addressline3 = addressline3;
		this.buildingname = buildingname;
		this.premise = premise;
		this.dependentlocality = dependentlocality;
	}

	public String getAddressline3() {
		return addressline3;
	}

	public void setAddressline3(String addressline3) {
		this.addressline3 = addressline3;
	}

	public String getBuildingname() {
		return buildingname;
	}

	public void setBuildingname(String buildingname) {
		this.buildingname = buildingname;
	}

	public String getPremise() {
		return premise;
	}

	public void setPremise(String premise) {
		this.premise = premise;
	}

	public String getDependentlocality() {
		return dependentlocality;
	}

	public void setDependentlocality(String dependentlocality) {
		this.dependentlocality = dependentlocality;
	}

	@Override
	public String toString() {
		return "UkAddressModel [addressline3=" + addressline3 + ", buildingname=" + buildingname + ", premise="
				+ premise + ", dependentlocality=" + dependentlocality + ", getAddressline1()=" + getAddressline1()
				+ ", getAddressline2()=" + getAddressline2() + ", getSummaryline()=" + getSummaryline()
				+ ", getOrganisation()=" + getOrganisation() + ", getStreet()=" + getStreet() + ", getPosttown()="
				+ getPosttown() + ", getCounty()=" + getCounty() + ", getPostcode()=" + getPostcode() + ", toString()="
				+ super.toString() + ", getClass()=" + getClass() + ", hashCode()=" + hashCode() + "]";
	}

}
