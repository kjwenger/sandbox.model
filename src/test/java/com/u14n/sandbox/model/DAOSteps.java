package com.u14n.sandbox.model;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

import java.lang.reflect.Method;
import java.util.Collections;

import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

/* package */ class ObjectDAO implements DAOProtocol<Object, Long> {
}

public class DAOSteps {
	DAOProtocol<Object, Long> dao;
	Object object;

	/**
	 * @param name
	 * @param parameterClasses
	 * @throws Throwable
	 */
	private void checkMethod(String name,
		@SuppressWarnings("rawtypes") Class[] parameterClasses)
			throws Throwable {
		Method method = this.dao.getClass().getMethod(name, parameterClasses);
		assertNotNull(method);
	}

	@Given("^I have a new DAO$")
	public void i_have_a_new_DAO() throws Throwable {
		this.dao = new ObjectDAO();
		assertNotNull(this.dao);
	}

	@When("^I check for the insert method$")
	public void i_check_for_the_insert_method() throws Throwable {
		checkMethod("insert", new Class[] { Object.class });
	}

	@When("^I check for the find by id method$")
	public void i_check_for_the_find_by_id_method() throws Throwable {
//		checkMethod("findById", new Class[] { Long.class });
	}

	@When("^I check for the find by name method$")
	public void i_check_for_the_find_by_name_method() throws Throwable {
		checkMethod("findByName", new Class[] { String.class });
	}

	@When("^I check for the find all method$")
	public void i_check_for_the_find_all_method() throws Throwable {
		checkMethod("findAll", new Class[] {});
	}

	@When("^I check for the update method$")
	public void i_check_for_the_update_method() throws Throwable {
		checkMethod("update", new Class[] { Object.class });
	}

	@When("^I check for the delete method$")
	public void i_check_for_the_delete_method() throws Throwable {
		checkMethod("delete", new Class[] { Object.class });
	}

	@Then("^the insert method should be defined$")
	public void the_insert_method_should_be_defined() throws Throwable {
		this.object = new Object();
		assertEquals(this.object, this.dao.insert(object));
	}

	@Then("^the find by id method should be defined$")
	public void the_find_by_id_method_should_be_defined() throws Throwable {
		try {
			this.dao.findById(0L);
		} catch (DAOException e) {
			// OK
		}
	}

	@Then("^the find by name method should be defined$")
	public void the_find_by_name_method_should_be_defined() throws Throwable {
		assertEquals(Collections.emptyList(), this.dao.findByName(""));
	}

	@Then("^the find all method should be defined$")
	public void the_find_all_method_should_be_defined() throws Throwable {
		assertEquals(Collections.emptyList(), this.dao.findAll());
	}

	@Then("^the update method should be defined$")
	public void the_update_method_should_be_defined() throws Throwable {
		assertEquals(this.object, this.dao.update(this.object));
	}

	@Then("^the delete method should be defined$")
	public void the_delete_method_should_be_defined() throws Throwable {
		assertEquals(this.object, this.dao.delete(this.object));
	}
}
