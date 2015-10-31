package com.u14n.sandbox.model

import org.junit.Test
import org.junit.Assert._
import cucumber.api.java.en.Given
import cucumber.api.java.en.Then
import cucumber.api.java.en.When
import cucumber.api.PendingException

class LocationSteps() {
    var location: Location = new Location();

    @Given("^I have a new location$")
    def i_have_a_new_location() {
        assertNotNull(location)
    }
    
    @When("^I get the ZIP code$")
    def i_get_the_ZIP_code() {
        location.getZipCode
    }
    
    @Then("^ZIP code should be blank$")
    def ZIP_code_should_be_blank() {
        assertEquals("", location.zipCode);
    }  
}