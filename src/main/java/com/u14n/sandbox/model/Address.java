package com.u14n.sandbox.model;

import java.io.Serializable;

import javax.xml.bind.annotation.XmlRootElement;

/**
 * @author Klaus Wenger
 *
 */
@XmlRootElement
public class Address extends Location implements Serializable {
	/**
	 * 
	 */
	//                                           major minor micro build
	private static final long serialVersionUID = 0x0001_0000_0000_0000L;

	public Address(
			String countryCode,
			String regionCode,
			String zipCode,
			String city,
			String street,
			String additional) {
		super(countryCode, regionCode, zipCode, city, street);
		this.additional = additional;
	}

	public Address() {
		this("", "", "", "", "", "");
	}

	public String getAdditional() {
		return additional;
	}

	public void setAdditional(String additional) {
		this.additional = additional;
	}

	private String additional;
}
