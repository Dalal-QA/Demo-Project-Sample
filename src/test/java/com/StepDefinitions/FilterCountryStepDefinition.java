package com.StepDefinitions;

import com.base.BaseClass;
import com.pageObjects.MatchesPage;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class FilterCountryStepDefinition extends BaseClass {
MatchesPage matchesPage= new MatchesPage(driver);

    @Then("User clicks on dropdown country")
    public void user_clicks_on_dropdown_country() {

        matchesPage.clickOnCountryDropDrown();
    }
    @And("User selects country Name from country name drop down")
    public void userSelectsCountryNameFromCountryNameDropDown() {

        matchesPage.clickOnUSACheckBox();
    }
    @And("User selects a City form the available cities option")
    public void userSelectsACityFormTheAvailableCitiesOption() {

        matchesPage.clickOnCityDropDown();
        matchesPage.clickOnLaOption();

    }
    @When("User selects a District from the available district option")
    public void userSelectsADistrictFromTheAvailableDistrictOption() {
        matchesPage.clickOnDistrictDropDown();
        matchesPage.clickOnDistrictOption();
    }


    @Then("user should see a data table of related results displayed")
    public void userShouldSeeADataTableOfRelatedResultsDisplayed() {

        matchesPage.isDataTableVisible();
    }
}
