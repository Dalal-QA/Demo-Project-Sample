package com.StepDefinitions;

import com.base.BaseClass;
import com.pageObjects.CountriesPage;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class AddCountriesStepDefinition extends BaseClass {
    CountriesPage countriesPage = new CountriesPage(driver);

    @When("User clicks on add country button")
    public void user_clicks_on_add_country_button() {
        countriesPage.clickOnAddCountryButton();

    }
    @When("User enter name {string} in the name input field")
    public void user_enter_name_in_the_name_input_field(String name) {

        countriesPage.enterNameOfCountry(name);

    }
    @When("User choose Currency form {string} drop down")
    public void user_choose_currency_form_drop_down(String currency) {
        countriesPage.selectCurrencyFromTheDropDown(currency);

    }
    @When("User enter Playball Fee in the PlaYBall fee input field")
    public void user_enter_playball_fee_in_the_pla_y_ball_fee_input_field() {
        countriesPage.enterPlayballFeeByPressingTheArrowUpKey();
        //countriesPage.verifyTheExpectedBehavior();

    }
    @When("User enter Organizer's fee in the Organizer's fee  input field")
    public void user_enter_organizer_s_fee_in_the_organizer_s_fee_input_field() {
        countriesPage.enterOrganizerFeeByPressingTheArrowUpKey();
        //countriesPage.verifyTheExpectedBehaviorInOrganizerFee();

    }
    @When("User enter Acquiring fee in the Acquiring fee input field")
    public void user_enter_acquiring_fee_in_the_acquiring_fee_input_field() {
        countriesPage.enterAquiringFeeByPressingTheArrowUpKey();
        //countriesPage.verifyTheExpectedBehaviorInAcquiringFee();

    }


    @Then("User should see the added country on the countries list")
    public void user_should_see_the_added_country_on_the_countries_list() {

        countriesPage.chooseLocationOnTheMap();

    }


}
