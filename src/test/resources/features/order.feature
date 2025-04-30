@Order
Feature: Order

  Background:
    Given I am on the Demoblaze home page
    When I click on the login menu
    Then The login popup is opened
    When I log in with "<username>" and "<password>"
    Then The user is logged successfully with "<username>"

  Scenario Outline: User can complete an order
    When I click on the Samsung galaxy s6
    And I click on the button "Add to cart"
    And I confirm the popup
    And I click on the Cart menu
    And I click on the button "Place Order"
    And I fill and confirm the form
    Then A popup is displayed to confirm the order

    Examples:
      | username      | password |
      | MarcoVerratti | Marco783 |