@removeFromCart
Feature:  AskOmDch - Cart Page

  Background:
    Given I am on the Products page

  @regression
  Scenario Outline: Verify products can be removed from the cart
    When I add product with title "<title>" to the cart
    And I click on the cart
    And I remove a product from the cart with title "<title>"
    Then the cart should no longer contain product "<title>"
    Examples:
      | title                           |
      | Anchor Bracelet                 |
      | Basic Blue Jeans                |
      | Black Over-the-shoulder Handbag |
      | Blue Denim Shorts               |