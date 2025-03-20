Feature: Signup

  Scenario Outline: User can sign up with valid credentials
    Given I go to the Demoblaze home page
    When I click on the signup menu
    Then The signup popup is opened
    When I sign up with <username> and <password>
    Then The user is signed up successfully

    Examples:
      | username | password |
      | user1    | pass1    |
      | user2    | pass2    |
      | user3    | pass3    |
