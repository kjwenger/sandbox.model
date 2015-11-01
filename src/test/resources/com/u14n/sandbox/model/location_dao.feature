@noignore
Feature: Location Data-Access-Objects (Location DAO)

  Scenario: Insert a new Location to new Location DAO
    Given I have a new Location DAO
    When I insert a new Location into the Location DAO
    Then the new Location should have been inserted

  Scenario: Insert and delete a new Location to new Location DAO
    Given I have a new Location DAO
    When I insert a new Location into the Location DAO
    And I delete the new Location from the Location DAO
    Then the new Location should have been deleted
