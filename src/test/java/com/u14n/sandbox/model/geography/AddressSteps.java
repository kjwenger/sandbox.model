package com.u14n.sandbox.model.geography;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertNotEquals;

import java.io.ObjectStreamClass;

import com.u14n.sandbox.model.geography.Address;

import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

/**
 * @author Klaus Wenger
 *
 */
public class AddressSteps {
	private static final short NIBBLE = 4;
	private static final int SHIFT = 4 * NIBBLE;

	private Address address;

	@Given("^I have a new address$")
	public void i_have_a_new_address() throws Throwable {
		this.address = new Address();
		assertNotNull(address);
	}

	@When("^I get the additional$")
	public void i_get_the_additional() throws Throwable {
		this.address.getAdditional();
	}

	@Then("^the additional should be blank$")
	public void the_additional_should_be_blank() throws Throwable {
		assertEquals("", address.getAdditional());
	}

	@When("^I get the serial version UID$")
	public void i_get_the_serial_version_UID() throws Throwable {
		long serialVersionUID = ObjectStreamClass.lookup(Address.class).getSerialVersionUID();
		assertNotEquals(0L, serialVersionUID);
	}

	@Then("^serial version UID should be (\\d+)\\.(\\d+)\\.(\\d+)\\.(\\d+)$")
	public void serial_version_UID_should_be(int arg1, int arg2, int arg3, int arg4) throws Throwable {
		//System.out.println("AddressSteps.serial_version_UID_should_be() arg1=" + arg1);
		//System.out.println("AddressSteps.serial_version_UID_should_be() arg2=" + arg2);
		//System.out.println("AddressSteps.serial_version_UID_should_be() arg3=" + arg3);
		//System.out.println("AddressSteps.serial_version_UID_should_be() arg4=" + arg4);
		long expected = arg1;
		//System.out.println("AddressSteps.serial_version_UID_should_be() expected=" + expected);
		expected <<= SHIFT;
		//System.out.println("AddressSteps.serial_version_UID_should_be() expected=" + expected);
		expected += arg2;
		//System.out.println("AddressSteps.serial_version_UID_should_be() expected=" + expected);
		expected <<= SHIFT;
		//System.out.println("AddressSteps.serial_version_UID_should_be() expected=" + expected);
		expected += arg3;
		//System.out.println("AddressSteps.serial_version_UID_should_be() expected=" + expected);
		expected <<= SHIFT;
		//System.out.println("AddressSteps.serial_version_UID_should_be() expected=" + expected);
		expected += arg4;
		//System.out.println("AddressSteps.serial_version_UID_should_be() expected=" + expected);
		long actual = ObjectStreamClass.lookup(this.address.getClass()).getSerialVersionUID();
		assertEquals(expected, actual);
	}
}
