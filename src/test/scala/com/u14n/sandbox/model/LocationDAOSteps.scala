package com.u14n.sandbox.model

import org.junit.Test
import org.junit.Assert._
import cucumber.api.java.en.Given
import cucumber.api.java.en.Then
import cucumber.api.java.en.When
import cucumber.api.PendingException

class LocationDAOSteps() {
  var location: Location = new Location();
  var locationDAO: LocationDAO = new LocationDAO.ConcurrentMemory();

  @Given("^I have a new Location DAO$")
  def i_have_a_new_Location_DAO() {
    assertNotNull(locationDAO);
  }

  @When("^I insert a new Location into the Location DAO$")
  def i_insert_a_new_Location_into_the_Location_DAO() {
    assertEquals(location, locationDAO.insert(location));
  }

  /**
   * @todo
   */
  @Then("^the new Location should have been inserted$")
  def the_new_Location_should_have_been_inserted() {
    // TODO      assertEquals(location, locationDAO.findById(location));
  }

  @When("^I delete the new Location from the Location DAO$")
  def i_delete_the_new_Location_from_the_Location_DAO() {
    assertEquals(location, locationDAO.delete(location));
  }

  /**
   * @todo
   */
  @Then("^the new Location should have been deleted$")
  def the_new_Location_should_have_been_deleted() {
    // TODO      locationDAO.findById(location);
  }
}