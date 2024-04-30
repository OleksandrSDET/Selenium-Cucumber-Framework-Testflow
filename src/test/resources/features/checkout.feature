@checkout_fields
Feature:  AskOmDch - Your Information Page

  Background:
    Given I am on the Products page
    And I add product with title "Blue Shoes" to the cart
    And I click on the cart
    And I click on proceed to checkout button

  @regression
  Scenario Outline: Validate fields without default value requirement with <test>
    When I enter the first name "<firstName>"
    And I enter the last name "<lastName>"
    And I enter street address "<streetAddress>"
    And I enter city name "<cityName>"
    And I choose the state "<stateName>"
    And I enter postal code "<postalCode>"
    And I enter email address "<emailAddress>"
    And I click on place order button
    Then I should see the error message "<errorMessage>"
    Examples:
      | test                | firstName | lastName | streetAddress | cityName | stateName | postalCode | emailAddress       | errorMessage                                |
      | Empty first name    |           | TestLast | TestStreet    | TestCity | Illinois  | 12345      | TestEmail@test.com | Billing First name is a required field.     |
      | Empty last name     | TestFirst |          | TestStreet    | TestCity | Illinois  | 12345      | TestEmail@test.com | Billing Last name is a required field.      |
      | Empty streetAddress | TestFirst | TestLast |               | TestCity | Illinois  | 12345      | TestEmail@test.com | Billing Street address is a required field. |
      | Empty cityName      | TestFirst | TestLast | TestStreet    |          | Illinois  | 12345      | TestEmail@test.com | Billing Town / City is a required field.    |
      | Empty stateName     | TestFirst | TestLast | TestStreet    | TestCity |           | 12345      | TestEmail@test.com | Billing State is a required field.          |
      | Empty postalCode    | TestFirst | TestLast | TestStreet    | TestCity | Illinois  |            | TestEmail@test.com | Billing ZIP Code is a required field.       |
      | Empty emailAddress  | TestFirst | TestLast | TestStreet    | TestCity | Illinois  | 12345      |                    | Billing Email address is a required field.  |









