Feature: Sign-in/Sign-out
  Scenario: User can sign in with valid credentials
    Given User is on the sign-in page
    When User enters valid credentials
    And User clicks on the Sign in button
    Then User should be signed in successfully

  Scenario: User cannot sign in with invalid credentials
    Given User is on the sign-in page
    When User enters invalid credentials
    And User clicks on the Sign in button
    Then Sign in should fail with an error message

  Scenario: User can sign out from the account
    Given User is signed in
    When User clicks on the Sign out button
    Then User should be signed out successfully
