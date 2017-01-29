package eu.pablo.entity;

import javax.persistence.Entity;

@Entity
public class IrelandAddress extends Address {

	private String latitude;
	private String longitude;
	private String what3words;

	public IrelandAddress() {
	}

	public IrelandAddress(int id, String addressline1, String addressline2, String summaryline, String organisation,
			String street, String posttown, String county, String postcode, String latitude, String longitude,
			String what3words) {
		super(id, addressline1, addressline2, summaryline, organisation, street, posttown, county, postcode);
		this.latitude = latitude;
		this.longitude = longitude;
		this.what3words = what3words;
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

	public String getWhat3words() {
		return what3words;
	}

	public void setWhat3words(String what3words) {
		this.what3words = what3words;
	}

	@Override
	public String toString() {
		return "IrelandAddress [latitude=" + latitude + ", longitude=" + longitude + ", what3words=" + what3words
				+ ", getId()=" + getId() + ", getAddressline1()=" + getAddressline1() + ", getAddressline2()="
				+ getAddressline2() + ", getSummaryline()=" + getSummaryline() + ", getOrganisation()="
				+ getOrganisation() + ", getStreet()=" + getStreet() + ", getPosttown()=" + getPosttown()
				+ ", getCounty()=" + getCounty() + ", getPostcode()=" + getPostcode() + ", toString()="
				+ super.toString() + ", getClass()=" + getClass() + ", hashCode()=" + hashCode() + "]";
	}
	
	public boolean isGeoValid(){
		return this.getLatitude() != null 
				&& this.getLatitude().length()>0
				&& this.getLongitude() != null
				&& this.getLongitude().length()>0;
	}
	
	public boolean isW3WValid(){
		return this.getWhat3words() != null &&
				this.getWhat3words().length()>0;
	}

}
