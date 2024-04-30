@products
Feature:  AskOmDch - Products Page

  Background:
    Given I am on the Products page

  @regression
  Scenario: Verify products can be added to the cart
    Given the cart should be empty
    When I add product with title "Blue Shoes" to the cart
    And I click on the cart
    Then I verify product is successfully added to the cart

  @regression
  Scenario: Verify products can be removed from the cart
    When I add product with title "Blue Shoes" to the cart
    And I click on the cart
    And I remove a product from the cart with title "Blue Shoes"
    Then the product should be removed

  @regression
  Scenario Outline: Verify products can be sorted by Categories
    And I sort products by category "<category>"
    Then products should be sorted by category "<category>"
    Examples:
      | category            |
      | Accessories         |
      | Men                |
      | Men’s Jeans         |
      | Men’s Shirts        |
      | Men’s Shoes         |
      | Purses And Handbags |
      | Women               |
      | Women’s Jeans       |
      | Women’s Shirts      |
      | Women’s Shoes       |

  @regression
  Scenario Outline: Verify product detail access by clicking attribute
    When I click on the product "<attribute>"
    Then I should redirected to the product detail page
    Examples:
      | attribute |
      | Name      |
      | Image     |