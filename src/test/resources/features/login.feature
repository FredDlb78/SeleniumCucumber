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

  Scenario Outline: User can't log in with "<invalid credentials>"
    Given I am on the Demoblaze home page
    When I click on the login menu
    Then The login popup is opened
    When I log in with "<username>" and "<password>"
    Then The user is not logged and the error message "<error message>" is displayed

    Examples:
      | invalid credentials | username      | password | error message                         |
      | Wrong username      | MarciVerratto | Marco783 | User does not exist.                  |
      | Wrong password      | MarcoVerratti | Marco784 | Wrong password.                       |
      | Empty username      |               | Marco783 | Please fill out Username and Password.|
      | Empty password      | MarcoVerratti |          | Please fill out Username and Password.|