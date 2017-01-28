package eu.pablo.model;

public class IrelandAddressCoordinateLookupModel extends AddressModel {
	
	private String latitude;
	private String longitude;
	
	public IrelandAddressCoordinateLookupModel(){
	}

	public IrelandAddressCoordinateLookupModel(String addressline1, String addressline2, String summaryline,
			String organisation, String street, String posttown, String county, String postcode, String latitude,
			String longitude) {
		super(addressline1, addressline2, summaryline, organisation, street, posttown, county, postcode);
		this.latitude = latitude;
		this.longitude = longitude;
	}

	public String getLatitude() {
		return latitude;
	}

	public void setLatitude(String latitude) {
		this.latitude = latitude;
	}

	public String getLongitude() {
		return longitude;
	}

	public void setLongitude(String longitude) {
		this.longitude = longitude;
	}

	@Override
	public String toString() {
		return "IrelandAddressCoordinateLookupModel [latitude=" + latitude + ", longitude=" + longitude
				+ ", getAddressline1()=" + getAddressline1() + ", getAddressline2()=" + getAddressline2()
				+ ", getSummaryline()=" + getSummaryline() + ", getOrganisation()=" + getOrganisation()
				+ ", getStreet()=" + getStreet() + ", getPosttown()=" + getPosttown() + ", getCounty()=" + getCounty()
				+ ", getPostcode()=" + getPostcode() + ", toString()=" + super.toString() + ", getClass()=" + getClass()
				+ ", hashCode()=" + hashCode() + "]";
	}
	
}
