package com.u14n.sandbox.model;

/**
 * @author Klaus Wenger
 *
 */
public class Address extends Location {

	public Address(String zipCode,
			String additional) {
		super(zipCode);
		this.additional = additional;
	}

	public Address() {
		this("", "");
	}

	public String getAdditional() {
		return additional;
	}

	public void setAdditional(String additional) {
		this.additional = additional;
	}

	private String additional;
}
