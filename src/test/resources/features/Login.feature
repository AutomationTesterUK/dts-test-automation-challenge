
Feature: SauceDemo Login functionality

  Scenario Outline: Validate login with multiple credentials
    Given the user is on the login page
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

  Scenario: Validate login for performance_glitch_user
    Given the user is on the login page
    When the user enters username "performance_glitch_user" and password "secret_sauce"
    And the user clicks on login button
    Then the user should see "dashboard" even if it takes longer
