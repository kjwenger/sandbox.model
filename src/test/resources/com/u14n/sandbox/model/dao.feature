@noignore
Feature: Data-Access-Objects (DAO)

  Scenario: A new DAO
    Given I have a new DAO
    When I check for the insert method
    And I check for the find by id method
    And I check for the find by name method
    And I check for the find all method
    And I check for the update method
    And I check for the delete method
    Then the insert method should be defined
    And the find by id method should be defined
    And the find by name method should be defined
    And the find all method should be defined
    And the update method should be defined
    And the delete method should be defined
    