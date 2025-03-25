Feature: Signup

  Scenario: User can sign up with a new account
    Given I am on the Demoblaze home page
    When I click on the signup menu
    Then The signup popup is opened
    When I sign up with a new random account
    Then The user is signed up successfully

  Scenario Outline: User cannot sign up with "<invalid credential>"
    Given I am on the Demoblaze home page
    When I click on the signup menu
    Then The signup popup is opened
    When I sign up with "<username>" and "<password>"
    Then The user is not signed up successfully with "<invalid credential>" and "<error message>" is displayed

    Examples:
      | invalid credential    | username       | password | error message                          |
      | an existing user      | MarcoVerratti  | Marco783 | This user already exist.               |
      | an empty username     |                | Marco783 | Please fill out Username and Password. |
      | an empty password     | MarcoVerratti  |          | Please fill out Username and Password. |