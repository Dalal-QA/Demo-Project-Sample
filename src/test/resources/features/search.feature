Feature: User is able to search Matches By Playground in Playball Application

  Background:
    Given the user is on the Playball app login page "https://www.playball-qa.fun/"


@search-playground
    Scenario Outline:[Positive]Successful login and search for matches by playground
      Given the user enters a valid username "<email>" and password "<password>"
      When the user clicks on the Enter button
      Then the user should be redirected to the Dashboard page
      When the user navigates to the Matches section
      And the user searches for matches using the playground name "<playground>"
      Then the search results should display matches at the playground "<playground>"

      Examples:
        | email           | password | playground   |
        | point@gmail.com | 12345678 | Sherman Oaks |
        | point@gmail.com | 12345678 | Breeze Field |
        | point@gmail.com | 12345678 | Park         |

  @fake-search
  Scenario: [Negative]Search for matches with special characters in playground name
    Given the user enters a valid email "point@gmail.com" and password "12345678"
    When the user clicks on the Enter button
    Then the user should be redirected to the Dashboard page
    When the user navigates to the Matches section
    And the user searches for matches using the playground name "!@#Playground$%^"
    Then the search results should display a message "No matches found for !@#Playground$%^"