package com.u14n.sandbox.model.geography;

import java.io.Serializable;

import javax.xml.bind.annotation.XmlRootElement;

import javax.persistence.Entity;

import com.u14n.sandbox.model.Constants;

/**
 * @author Klaus Wenger
 *
 */
@XmlRootElement
@Entity
public class Address
		extends Object
		implements Serializable, Located, Addressed {
	/**
	 * 
	 */
	//                                           major minor micro build
	private static final long serialVersionUID = 0x0001_0000_0000_0000L;

	public Address(
			String countryCode,
			String regionCode,
			String postalCode,
			String city,
			String street,
			String number,
			String additional) {
		super();
		location = new Location(
				countryCode,
				regionCode,
				postalCode,
				city,
				street,
				number);
		this.additional = additional;
	}

	public Address() {
		this(Constants.STRING_EMPTY,
			Constants.STRING_EMPTY,
			Constants.STRING_EMPTY,
			Constants.STRING_EMPTY,
			Constants.STRING_EMPTY,
			Constants.STRING_EMPTY,
			Constants.STRING_EMPTY);
	}

	public String getCountryCode() {
		return this.location.getCountryCode();
	}

	public void setCountryCode(String newCountryCode) {
		this.location.setCountryCode(newCountryCode);
	}

	public String getRegionCode() {
		return this.location.getRegionCode();
	}

	public void setRegionCode(String newRegionCode) {
		this.location.setRegionCode(newRegionCode);
	}

	public String getPostalCode() {
		return this.location.getPostalCode();
	}

	public void setPostalCode(String newPostalCode) {
		this.location.setPostalCode(newPostalCode);
	}

	public String getCity() {
		return this.location.getCity();
	}

	public void setCity(String newCity) {
		this.location.setCity(newCity);
	}

	public String getStreet() {
		return this.location.getStreet();
	}

	public void setStreet(String newStreet) {
		this.location.setStreet(newStreet);
	}

	public String getNumber() {
		return this.location.getNumber();
	}

	public void setNumber(String newNumber) {
		this.location.setNumber(newNumber);
	}

	public String getAdditional() {
		return additional;
	}

	public void setAdditional(String newAdditional) {
		this.additional = newAdditional;
	}

	/**
	 * 
	 */
	private Location location;
	/**
	 * 
	 */
	private String additional;
}
