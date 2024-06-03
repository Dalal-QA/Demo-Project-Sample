Feature: Countries and cities tests


  Background:

    Given Visit website "https://www.playball-qa.fun/"
    When Login to the portal
    Then Verify that Successfully logged in to the portal
    When Clicks on "Countries & cities"

  @hide-country
  Scenario: [Positive] Should be possible hide the Country
    Then Verify that "Countries" page is displayed
    When Hide "Qatar" Country
    Then Verify that "Qatar" Country shows "Hidden" status

@add-countries
    Scenario Outline: [Positive] User should be able to add countries

      When User clicks on add country button
      And User enter name "<name>" in the name input field
      And User choose Currency form "<currency>" drop down
      And User enter Playball Fee in the PlaYBall fee input field
      And User enter Organizer's fee in the Organizer's fee  input field
      And User enter Acquiring fee in the Acquiring fee input field
      When User clicks on add country button
      Then User should see the added country on the countries list



      Examples:
        | name    | currency |
        | Spain   | EUR      |
        | Ukraine | UAH      |
        | Poland  | PLN      |