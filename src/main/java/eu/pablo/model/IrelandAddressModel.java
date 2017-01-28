package eu.pablo.model;

import org.springframework.stereotype.Component;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@Component
@JsonIgnoreProperties(ignoreUnknown = true)
public class IrelandAddressModel {

	private String addressline1;
	private String addressline2;
	private String summaryline;
	private String organisation;
	private String street;
	private String posttown;
	private String county;
	private String postcode;
	
	public IrelandAddressModel() {
	}

	public IrelandAddressModel(String addressline1, String addressline2, String summaryline, String organisation,
			String street, String posttown, String county, String postcode) {
		super();
		this.addressline1 = addressline1;
		this.addressline2 = addressline2;
		this.summaryline = summaryline;
		this.organisation = organisation;
		this.street = street;
		this.posttown = posttown;
		this.county = county;
		if(postcode != null)
			this.postcode = postcode.replaceAll("\\s","");
	}

	public String getAddressline1() {
		return addressline1;
	}

	public void setAddressline1(String addressline1) {
		this.addressline1 = addressline1;
	}

	public String getAddressline2() {
		return addressline2;
	}

	public void setAddressline2(String addressline2) {
		this.addressline2 = addressline2;
	}

	public String getSummaryline() {
		return summaryline;
	}

	public void setSummaryline(String summaryline) {
		this.summaryline = summaryline;
	}

	public String getOrganisation() {
		return organisation;
	}

	public void setOrganisation(String organisation) {
		this.organisation = organisation;
	}

	public String getStreet() {
		return street;
	}

	public void setStreet(String street) {
		this.street = street;
	}

	public String getPosttown() {
		return posttown;
	}

	public void setPosttown(String posttown) {
		this.posttown = posttown;
	}

	public String getCounty() {
		return county;
	}

	public void setCounty(String county) {
		this.county = county;
	}

	public String getPostcode() {
		if(this.postcode == null)
			return null;
		return postcode.replaceAll("\\s","");
	}

	public void setPostcode(String postcode) {
		this.postcode = postcode;
	}

	@Override
	public String toString() {
		return "AddressModel [addressline1=" + addressline1 + ", addressline2=" + addressline2
				+ ", summaryline=" + summaryline + ", organisation=" + organisation + ", street=" + street
				+ ", posttown=" + posttown + ", county=" + county + ", postcode=" + postcode + "]";
	}

}
