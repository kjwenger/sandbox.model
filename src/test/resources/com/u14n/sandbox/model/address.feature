Feature: Address

  @noignore
  Scenario: A new address
    Given I have a new address
    When I get the additional
    Then the additional should be blank

  Scenario: A serialized address
    Given I have a new address
    When I get the serial version UID
    Then serial version UID should be 1.0.0.0

  @ignore
  Scenario: Red Hat Headquarters Suite
    Given I have the Red Hat Headquarters Suite address
    When I get the country code
    And I get the region code
    And I get the ZIP code
    And I get the city
    And I get the street
    And I get the id
    Then country code should be "USA"
    And region code should be "NC"
    And ZIP code should be "27601"
    And city should be "Raleigh"
    And street should be "100 E Davie St"
    And id should be 1370790227
    And it should be self-equaling
