Feature: Registration
  Scenario: User can register with valid credentials
    Given User is on the registration page
    When User enters valid registration details
    And User clicks on the Register button
    Then User should be registered successfully

  Scenario: User cannot register with invalid email format
    Given User is on the registration page
    When User enters invalid email format
    And User clicks on the Register button
    Then Registration should fail with an error message