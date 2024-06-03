package com.StepDefinitions;

import com.base.BaseClass;
import com.pageObjects.DashboardPage;
import com.pageObjects.LoginPage;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;

public class AuthenticationTestStepDefinition extends BaseClass {
    LoginPage loginPage = new LoginPage(driver);
    DashboardPage dashboardPage = new DashboardPage(driver);

//    @Given("user navigate to the application")
//    public void user_navigate_to_the_application(String website) {
//        driver.get("https://www.playball-qa.fun/");
//        //driver.get(website);
//        driver.manage().deleteAllCookies();
//        driver.manage().window().maximize();
//
//
//    }

    @Given("user visit the  website {string}")
    public void user_visit_the_website(String website) {
        loginPage.visitUrl(website);
    }

    @When("user login to the application with valid credential")
    public void user_login_to_the_application_with_valid_credential() {
        loginPage.loginToThePortal();
    }

//    @When("user enter {string} in email input field")
//    public void user_enter_in_email_input_field(String email) {
//
//        loginPage.inputEmailAddress(email);
//
//
//    }
//    @When("user enter {string} in a password input field")
//    public void user_enter_in_a_password_input_field(String password) {
//        loginPage.inputPassword(password);
//
//    }
//    @When("user clicks on Enter button")
//    public void user_clicks_on_enter_button() {
//        loginPage.clickEnter();


    //}
    @When("user enter {string} in email input field")
    public void user_enter_in_email_input_field(String email) {
        loginPage.inputEmailAddress(email);
    }
    @When("user enter {string} in a password input field")
    public void user_enter_in_a_password_input_field(String password) {
        loginPage.inputPassword(password);

    }
    @When("user clicks on Enter button")
    public void user_clicks_on_enter_button() {
        loginPage.clickEnter();
    }
    @Then("error message should be displayed")
    public void error_message_should_be_displayed() {

        loginPage.isErrorMessageVisible();
        highlightElement(driver,loginPage.errorMessage);

    }

//    @Then("user is navigated to authenticated Dashboard")
//    public void user_is_navigated_to_authenticated_dashboard() {
//        Assert.assertTrue(dashboardPage.isDashboardTitleDisplayed());
//
//    }





}
