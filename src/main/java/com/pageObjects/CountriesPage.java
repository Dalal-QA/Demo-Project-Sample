package com.pageObjects;

import com.base.BaseClass;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.Assert;

import java.awt.*;
import java.util.List;

public class CountriesPage extends BaseClass {

    public CountriesPage(WebDriver webDriver) {
        PageFactory.initElements(webDriver, this);
    }

    @FindBy(xpath = "//button[text()=\"Hide\"]")
    WebElement hideCountry;

    @FindBy(css = ".table__row.table__title")
    WebElement tableTitle;

    @FindBy(xpath = "//tbody/tr[1]")
    WebElement tableFirstRow;


    @FindBy(xpath="//button[@class='SubmitButton_button__JpaGS darkButton']")
    WebElement addCountryButton;

    @FindBy(xpath = "//input[@name='country']")
    WebElement countryNameField;
    @FindBy(xpath = "//select[@id='currency']")
    WebElement dropDownCurrency;

    @FindBy(xpath="//input[@name='serviceCommission']")
    WebElement playballFeeInputField;

    @FindBy(xpath="//input[normalize-space(@name)='organizerCommission']")
    WebElement organizerFeeInputField;
    //xpath=//input[@name='organizerCommission']

    @FindBy(xpath="//input[@name='acquiring']")
    WebElement acquiringFeeInputField;
    @FindBy(xpath = "//button[@class='gm-control-active gm-fullscreen-control']")
    WebElement fullScreenButtonMap;

    @FindBy(xpath="//button[@class='gm-control-active gm-fullscreen-control']")
    WebElement escapeFullScreenButton;

    @FindBy(xpath = "//button[text()='Add country']")
    WebElement addCountryButton2;





    public void clickOnAddCountryButton(){

        highlightElement(driver, addCountryButton);

        clickOnElement(addCountryButton);
    }

    public void enterNameOfCountry(String name){
        sendKeysToElement(countryNameField, name);
    }
    public void selectCurrencyFromTheDropDown(String currency){
            dropDownCurrency.click();
            selectFromDropdownByVisibleText( dropDownCurrency, currency);
    }

    public void enterPlayballFeeByPressingTheArrowUpKey(){
        //playballFeeInputField.click();
        clickOnElement(playballFeeInputField);
        playballFeeInputField.sendKeys(Keys.ARROW_UP);

//        try {
//            // Create an instance of Robot
//            Robot robot = new Robot();
//
//            // Number of times to press the "arrow up" key
//            int times = 4;
//
//            // Press the "arrow up" key the specified number of times
//            pressArrowUp(robot, times);
//        } catch (AWTException e) {
//            e.printStackTrace();
//        }
    }

    public void verifyTheExpectedBehavior(){

        String expectedText = "1";
        String actualText=playballFeeInputField.getText();
        Assert.assertEquals(expectedText,actualText);


    }

    public void enterOrganizerFeeByPressingTheArrowUpKey(){
        organizerFeeInputField.click();
        clickOnElement(organizerFeeInputField);
      organizerFeeInputField.sendKeys(Keys.ARROW_UP);

//        try {
//            // Create an instance of Robot
//            Robot robot = new Robot();
//
//            // Number of times to press the "arrow up" key
//            int times = 4;
//
//            // Press the "arrow up" key the specified number of times
//            pressArrowUp(robot, times);
//        } catch (AWTException e) {
//            e.printStackTrace();
//        }
    }
    public void verifyTheExpectedBehaviorInOrganizerFee(){

        String expectedText = "1";
        String actualText=organizerFeeInputField.getText();
        Assert.assertEquals(expectedText,actualText);
    }

    public void enterAquiringFeeByPressingTheArrowUpKey(){
        //acquiringFeeInputField.click();
        clickOnElement(acquiringFeeInputField);
        acquiringFeeInputField.sendKeys(Keys.ARROW_UP);
    }
    public void verifyTheExpectedBehaviorInAcquiringFee(){

        String expectedText = "1";
        String actualText=acquiringFeeInputField.getText();
        Assert.assertEquals(expectedText,actualText);
    }


    public void chooseLocationOnTheMap() {
//        clickOnElement(fullScreenButtonMap);
//
//        String[] coords = coordinates.split(",");
//        int xOffset = Integer.parseInt(coords[0].trim());
//        int yOffset = Integer.parseInt(coords[1].trim());
//
//        // Find the map element
//        WebElement mapElement = driver.findElement(By.xpath("//img[@src='https://maps.gstatic.com/mapfiles/transparent.png']"));
//
//        // Click on the map at the specified coordinates
//        Actions actions = new Actions(driver);
//        actions.moveToElement(mapElement, xOffset, yOffset).click().perform();
//        clickOnElement(escapeFullScreenButton);
        clickOnElement(addCountryButton2);


    }



    public void hideCountry(String country){
        List<WebElement> allCountries = driver.findElements(By.xpath("//tbody/tr/td[1]"));
        for(int i=0;i<allCountries.size();i++){
            if(allCountries.get(i).getText().equalsIgnoreCase(country)){
                String status = driver.findElement(By.xpath("//tbody/tr["+i+"]/td[9]")).getText();
                if(status.equalsIgnoreCase("Opened")){
                    wait.until(ExpectedConditions.visibilityOf(hideCountry));
                    wait.until(ExpectedConditions.elementToBeClickable(hideCountry));
                    hideCountry.click();
                    log.info("Clicked On Hide Country");
                }else {
                    log.info("Country already Hidden");
                }
            }
        }
    }

    public boolean isCountryDisplayedWithStatus(String country, String status){
        wait.until(ExpectedConditions.visibilityOf(tableTitle));
        wait.until(ExpectedConditions.visibilityOf(tableFirstRow));
        List<WebElement> allCountries = driver.findElements(By.xpath("//tbody/tr/td[1]"));
        for(int i=0;i<allCountries.size();i++) {
            if (allCountries.get(i).getText().equalsIgnoreCase(country)) {
                String statusActual = driver.findElement(By.xpath("//tbody/tr["+i+"]/td[9]")).getText();
                return statusActual.equalsIgnoreCase(status);
            }
        }
        return false;
    }
}
