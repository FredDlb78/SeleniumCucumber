Feature: Signup

  Scenario: User can sign up with valid credentials
    Given I go to the Demoblaze home page
    When I click on the signup menu
    Then The signup popup is opened
#    When I sign up with <username> and <password>
#    Then The user is signed up successfully
#
#    Examples:
#      | username | password      |
#      | testuser | testpassword  |
#      | testuser1| testpassword1 |