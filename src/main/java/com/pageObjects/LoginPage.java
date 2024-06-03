package com.pageObjects;

import com.base.BaseClass;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.locators.RelativeLocator;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class LoginPage extends BaseClass {

    public LoginPage(WebDriver driver){
        PageFactory.initElements(driver,this);
    }

    @FindBy(name = "email")
    WebElement emailField;

    @FindBy(xpath="//input[@name='password']")
    WebElement passwordField;


    @FindBy(xpath="//button[text()='Enter']")
    WebElement enterButton;
    @FindBy(xpath = "//div[text()='Login has not been completed. Incorrect password!']")
    public WebElement errorMessage;

    public void visitUrl(String website){
        driver.get(website);
       log.info("Visited" + website);
    }

    public void inputEmailAddress(String email) {

        sendKeysToElement(emailField,email);
    }
    public void inputPassword(String password) {

        sendKeysToElement(passwordField,password);
    }



    public void clickEnter(){
        clickOnElement(enterButton);


    }

    public WebElement isErrorMessageVisible(){

        return wait.until(ExpectedConditions.visibilityOf(errorMessage));
    }

    public DashboardPage login(String email , String password){

        inputEmailAddress(email);
        inputPassword(password);
        clickEnter();
        return new DashboardPage(driver);


    }


    public void loginToThePortal(){
        wait.until(ExpectedConditions.visibilityOf(emailField));
        emailField.sendKeys(prop.getProperty("email"));
        log.info("Entered Email: "+prop.getProperty("email"));

        wait.until(ExpectedConditions.visibilityOf(passwordField));
        passwordField.sendKeys(prop.getProperty("password"));
        log.info("Entered Password");

        wait.until(ExpectedConditions.elementToBeClickable(enterButton));
        enterButton.click();
        log.info("Clicked on Enter Button");
    }


    }

