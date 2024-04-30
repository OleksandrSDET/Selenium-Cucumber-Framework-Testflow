@overview @smoke
Feature:  AskOmDch - Overview Page

  Background:
    Given I am on the Products page
    And I add product with title "Blue Shoes" to the cart
    And I click on the cart
    And I click on proceed to checkout button
    When I enter the first name "TestFirst"
    And I enter the last name "TestLast"
    And I enter street address "TestStreet"
    And I enter city name "TestCity"
    And I choose the state "Illinois"
    And I enter postal code "12345"
    And I enter email address "TestEmail@test.com"

  @regression
  Scenario Outline: Verify product payment method
    When I select the product "<paymentMethod>"
    And I click on place order button
    Then I should see the payment method message "<paymentMethod>"
    Examples:
      | paymentMethod        |
      | Direct bank transfer |
      | Cash on delivery     |

  @regression
  Scenario: Verify order details is completed
    And I click on place order button
    Then I should see "Thank you. Your order has been received." message



