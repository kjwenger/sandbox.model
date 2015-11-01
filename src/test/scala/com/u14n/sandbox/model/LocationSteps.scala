package com.u14n.sandbox.model

import org.junit.Test
import org.junit.Assert._
import cucumber.api.java.en.Given
import cucumber.api.java.en.Then
import cucumber.api.java.en.When
import cucumber.api.PendingException

class LocationSteps() {
  var location: Location = _
  var newLocation: Location = new Location()
  var redHatAmphitheater: Location = new Location(
    "USA",
    "NC",
    "27601",
    "Raleigh",
    "500 S McDowell St")
  var countryCode: String = _
  var regionCode: String = _
  var zipCode: String = _
  var city: String = _
  var street: String = _
  var identifier: Int = _

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

  @When("^I get the country code$")
  def i_get_the_country_code() {
    countryCode = location.getCountryCode
  }

  @When("^I get the region code$")
  def i_get_the_region_code() {
    regionCode = location.getRegionCode
  }

  @When("^I get the ZIP code$")
  def i_get_the_ZIP_code() {
    zipCode = location.getZipCode
  }

  @When("^I get the city")
  def i_get_the_city() {
    city = location.getCity
  }

  @When("^I get the street")
  def i_get_the_street() {
    street = location.getStreet
  }

  @When("^I get the identifier$")
  def i_get_the_identifier() {
    identifier = location.getIdentifier
  }

  @Then("^country code should be \"([^\"]*)\"$")
  def country_code_should_be(arg1: String) {
    assertEquals(arg1, countryCode)
  }

  @Then("^region code should be \"([^\"]*)\"$")
  def region_code_should_be(arg1: String) {
    assertEquals(arg1, regionCode)
  }

  @Then("^ZIP code should be \"([^\"]*)\"$")
  def ZIP_code_should_be(arg1: String) {
    assertEquals(arg1, zipCode)
  }

  @Then("^city should be \"([^\"]*)\"$")
  def city_should_be(arg1: String) {
    assertEquals(arg1, city)
  }

  @Then("^street should be \"([^\"]*)\"$")
  def street_should_be(arg1: String) {
    assertEquals(arg1, street)
  }

  @Then("^identifier should be (-?\\d+)$")
  def identifier_should_be(arg1: Int) {
    assertEquals(arg1, identifier)
  }
}