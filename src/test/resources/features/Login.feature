
Feature: SauceDemo Login functionality

  Background:
    Given the user is on the login page

    @login
  Scenario Outline: Validate login with multiple credentials
    When the user enters username "<username>" and password "<password>"
    And the user clicks on login button
    Then the user should see "<expectedResult>"

    Examples:
      | username        | password      | expectedResult                |
      | standard_user   | secret_sauce  | dashboard                     |
      | locked_out_user | secret_sauce  | Epic sadface: Sorry, this user has been locked out. |
      | invalid_user    | wrong_pass    | Epic sadface: Username and password do not match any user |
      | empty           | empty         | Epic sadface: Username is required |
      | standard_user   | empty         | Epic sadface: Password is required |

    @performance
  Scenario: Validate login for performance_glitch_user
    When the user enters username "performance_glitch_user" and password "secret_sauce"
    And the user clicks on login button
    Then the user should see "dashboard" in less than 35 seconds

    @logout
  Scenario: Validate logout functionality
    When the user enters username "standard_user" and password "secret_sauce"
    And the user clicks on login button
    Then the user should see "dashboard"
    When the user clicks on burger menu
    And the user clicks on "logout" option
    Then the user should see "login" button