@login
Feature: AskOmDch - Login Page

  Background:
    Given I land on AskOmDch Account page

  @regression
  Scenario: Validate Successful Login
    When I enter a username "testuser123"
    And I enter a password "Testing123!"
    And I click on the login button
    Then I should be able to see the "Hello testuser123" message

  @regression
  Scenario Outline: Validate Unsuccessful Login with <test>
    When I enter a username "<username>"
    And I enter a password "<password>"
    And I click on the login button
    Then I should see the error message "<errorMessage>"

    Examples:
      | test                          | username     | password      | errorMessage                                                                                                                         |
      | Invalid username and password | test_user123 | test_password | Error: The username test_user123 is not registered on this site. If you are unsure of your username, try your email address instead. |
      | Empty password                | test_user123 |               | Error: The password field is empty.                                                                                                  |
      | Empty username                |              | test_password | Error: Username is required.                                                                                                         |
