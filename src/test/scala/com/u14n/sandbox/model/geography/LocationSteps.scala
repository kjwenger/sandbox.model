package com.u14n.sandbox.model.geography

import org.junit.Assert._
import cucumber.api.java.en.Given
import cucumber.api.java.en.Then
import cucumber.api.java.en.When

class LocationSteps() {
  var location: Location = _
  var newLocation: Location = new Location()
  var redHatAmphitheater: Location = new Location(
    "USA",
    "NC",
    "27601",
    "Raleigh",
    "S McDowell St",
    "500")
  var redHatHeadquarters: Location = new Location(
    "USA",
    "NC",
    "27601",
    "Raleigh",
    "E Davie St",
    "100")
  var countryCode: String = _
  var regionCode: String = _
  var postalCode: String = _
  var city: String = _
  var street: String = _
  var number: String = _
  var id: Long = _

  @Given("^I have a new location$")
  def i_have_a_new_location() {
    location = newLocation
    assertNotNull(location)
  }

  @Given("^I have the Red Hat Amphitheater location$")
  def i_have_the_Red_Hat_Amphitheater_location() {
    location = redHatAmphitheater
    assertNotNull(location)
  }

  @Given("^I have the Red Hat Headquarters location$")
  def i_have_the_Red_Hat_Headquarters_location() {
    location = redHatHeadquarters
    assertNotNull(location)
  }

  @When("^I get the country code$")
  def i_get_the_country_code() {
    countryCode = location.getCountryCode
  }

  @When("^I get the region code$")
  def i_get_the_region_code() {
    regionCode = location.getRegionCode
  }

  @When("^I get the postal code$")
  def i_get_the_postal_code() {
    postalCode = location.getPostalCode
  }

  @When("^I get the city")
  def i_get_the_city() {
    city = location.getCity
  }

  @When("^I get the street")
  def i_get_the_street() {
    street = location.getStreet
  }

  @When("^I get the number")
  def i_get_the_number() {
    number = location.getNumber
  }

  @When("^I get the id$")
  def i_get_the_id() {
    id = location.getId
  }

  @Then("^country code should be \"([^\"]*)\"$")
  def country_code_should_be(arg1: String) {
    assertEquals(arg1, countryCode)
  }

  @Then("^region code should be \"([^\"]*)\"$")
  def region_code_should_be(arg1: String) {
    assertEquals(arg1, regionCode)
  }

  @Then("^postal code should be \"([^\"]*)\"$")
  def postal_code_should_be(arg1: String) {
    assertEquals(arg1, postalCode)
  }

  @Then("^city should be \"([^\"]*)\"$")
  def city_should_be(arg1: String) {
    assertEquals(arg1, city)
  }

  @Then("^street should be \"([^\"]*)\"$")
  def street_should_be(arg1: String) {
    assertEquals(arg1, street)
  }

  @Then("^number should be \"([^\"]*)\"$")
  def number_should_be(arg1: String) {
    assertEquals(arg1, number)
  }

  @Then("^id should be (\\d+)$")
  def id_should_be(arg1: Long) {
    assertEquals(arg1, id)
  }

  @Then("^it should be self-equaling$")
  def it_should_be_self_equaling() {
    val newLocation = new Location(location)
    assertTrue(newLocation.equals(location));
    assertTrue(location.equals(newLocation));
    assertTrue(newLocation == location);
    assertTrue(location == newLocation);
    assertEquals(location.hashCode(), newLocation.hashCode());
  }
}