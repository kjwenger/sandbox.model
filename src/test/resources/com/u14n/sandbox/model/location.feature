Feature: Location

  @noignore
  Scenario: a location
    Given I have a new location
    When I get the ZIP code
    Then ZIP code should be blank
