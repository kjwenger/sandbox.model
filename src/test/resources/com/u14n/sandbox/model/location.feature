Feature: Location

  @noignore
  Scenario: A location
    Given I have a new location
    When I get the country code
    And I get the region code
    And I get the ZIP code
    And I get the city
    And I get the street
    And I get the identifier
    Then country code should be ""
    And region code should be ""
    And ZIP code should be ""
    And city should be ""
    And street should be ""
    And identifier should be 115856201

  Scenario: Red Hat Amphitheater
    Given I have the Red Hat Amphitheater location
    When I get the country code
    And I get the region code
    And I get the ZIP code
    And I get the city
    And I get the street
    And I get the identifier
    Then country code should be "USA"
    And region code should be "NC"
    And ZIP code should be "27601"
    And city should be "Raleigh"
    And street should be "500 S McDowell St"
    And identifier should be -760791817
