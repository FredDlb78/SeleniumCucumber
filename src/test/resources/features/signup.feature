Feature: Signup

  Scenario: User can sign up with valid credentials
    Given I am on the Demoblaze home page
    When I click on the signup menu
    Then The signup popup is opened
    When I sign up with a new random account
    Then The user is signed up successfully