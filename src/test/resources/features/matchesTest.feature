Feature: User should be able to filter country,city and district
  Background:
    Given Visit website "https://www.playball-qa.fun/"
    When Login to the portal
    Then Verify that Successfully logged in to the portal
    And the user navigates to the Matches section
    And User clicks on dropdown country

    @filter-country

  Scenario: [Positive] should be possible to filter countries

    And User selects country Name from country name drop down
    And User selects a City form the available cities option
    When User selects a District from the available district option
    Then user should see a data table of related results displayed






