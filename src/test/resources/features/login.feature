@Login
Feature: Login

  Scenario Outline: User can log in with an existing account
    Given I am on the Demoblaze home page
    When I click on the login menu
    Then The login popup is opened
    When I log in with "<username>" and "<password>"
    Then The user is logged successfully with "<username>"

    Examples:
      | username      | password |
      | MarcoVerratti | Marco783 |