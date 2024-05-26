package com.StepDefinitions;

import com.base.BaseClass;
import com.pageObjects.DashboardPage;
import com.pageObjects.LoginPage;
import com.pageObjects.MatchesPage;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.Assert;

public class SearchTestStepDefinition extends BaseClass {

    LoginPage loginPage = new LoginPage(driver);
    DashboardPage dashboardPage =new DashboardPage(driver);
    MatchesPage matchesPage = new MatchesPage(driver);


    @Given("the user is on the Playball app login page {string}")
    public void the_user_is_on_the_playball_app_login_page(String website) {
       loginPage.visitUrl(website);
    }
    @Given("the user enters a valid username {string} and password {string}")
    public void the_user_enters_a_valid_username_and_password(String email, String password) {
        loginPage.inputEmailAddress(email);
        loginPage.inputPassword(password);
    }
    @When("the user clicks on the Enter button")
    public void the_user_clicks_on_the_enter_button() {
        loginPage.clickEnter();
    }
    @Then("the user should be redirected to the Dashboard page")
    public void the_user_should_be_redirected_to_the_dashboard_page() {
        Assert.assertTrue(dashboardPage.isDashboardTitleDisplayed());
    }

    @When("the user navigates to the Matches section")
    public void the_user_navigates_to_the_matches_section() {
        dashboardPage.clickMatchesButton();

    }
    @When("the user searches for matches using the playground name {string}")
    public void the_user_searches_for_matches_using_the_playground_name(String playground){
        matchesPage.insertSearchTerm(playground);
    }
    @Then("the search results should display matches at the playground {string}")
    public void the_search_results_should_display_matches_at_the_playground(String playground) {
       Assert.assertTrue(matchesPage.isTableDataVisible(playground));
    }

    @Given("the user enters a valid email {string} and password {string}")
    public void the_user_enters_a_valid_email_and_password(String email, String password) {
        loginPage.inputEmailAddress(email);
        loginPage.inputPassword(password);
    }
    @Then("the search results should display a message {string}")
    public void the_search_results_should_display_a_message(String string) {

    }

}
