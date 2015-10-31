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
    