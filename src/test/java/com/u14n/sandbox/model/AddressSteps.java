package com.u14n.sandbox.model;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

/**
 * @author Klaus Wenger
 *
 */
public class AddressSteps {
	private Address address;

	@Given("^I have a new address$")
	public void i_have_a_new_address() throws Throwable {
		address = new Address();
		assertNotNull(address);
	}

	@When("^I get the additional$")
	public void i_get_the_additional() throws Throwable {
		address.getAdditional();
	}

	@Then("^the additional should be blank$")
	public void the_additional_should_be_blank() throws Throwable {
		assertEquals("", address.getAdditional());
	}
}
