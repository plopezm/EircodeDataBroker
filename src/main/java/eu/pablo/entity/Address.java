package eu.pablo.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
public class Address {

	@Id
	@GeneratedValue
	private long id;

	private String addressline1;
	private String addressline2;
	private String summaryline;
	private String organisation;
	private String street;
	private String posttown;
	private String county;
	private String postcode;
	
	public Address(){
	}

	public Address(int id, String addressline1, String addressline2, String summaryline, String organisation,
			String street, String posttown, String county, String postcode) {
		super();
		this.id = id;
		this.addressline1 = addressline1;
		this.addressline2 = addressline2;
		this.summaryline = summaryline;
		this.organisation = organisation;
		this.street = street;
		this.posttown = posttown;
		this.county = county;
		this.postcode = postcode;
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
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
		return postcode;
	}

	public void setPostcode(String postcode) {
		this.postcode = postcode;
	}

	@Override
	public String toString() {
		return "Address [id=" + id + ", addressline1=" + addressline1 + ", addressline2=" + addressline2
				+ ", summaryline=" + summaryline + ", organisation=" + organisation + ", street=" + street
				+ ", posttown=" + posttown + ", county=" + county + ", postcode=" + postcode + "]";
	}

}
