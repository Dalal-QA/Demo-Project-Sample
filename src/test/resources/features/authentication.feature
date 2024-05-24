Feature: Users should be able to authenticate to the application
  //@login
    Background:  //shared steps
    Given user visit the  website "https://www.playball-qa.fun/"
    When user enter "point@gmail.com" in email input field

  Scenario Outline: [positive] User should be able to login


#    When user login to the application with valid credential

    When user enter "<ValidPassword>" in a password input field
    And user clicks on Enter button

#    When user enter "<point@gmail.com>" in email input field
#    And user enter "12345678" in a password input field
#    And user clicks on Enter button
    Then user is navigated to authenticated Dashboard

Examples:
  | ValidPassword |
  | 12345678      |
@invalid-Login
  Scenario Outline: [Negative] User should not be able to login with invalid credential
      When user enter "<invalid password>" in a password input field
      And user clicks on Enter button
      Then error message should be displayed


      Examples:
        | invalid password |
        | 22345678         |
        | 32345678         |
        | 42345678         |