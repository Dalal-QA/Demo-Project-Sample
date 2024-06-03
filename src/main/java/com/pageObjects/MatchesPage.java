package com.pageObjects;

import com.base.BaseClass;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;

import java.util.List;

public class MatchesPage extends BaseClass {

    public  MatchesPage(WebDriver driver){
        PageFactory.initElements(driver, this);

    }

    @FindBy(xpath ="//input[@class='CommonInput_input__1a_v4 users_users__searchInput__p6IsS']")
    WebElement  searchBar;

    @FindBy(css="tbody tr:nth-child(1) td:nth-child(6)")
    WebElement tableDataField;

    @FindBy(xpath="//div[@class='Select_select__gLGTN mb0 false']/div[@class='between-row']")
    WebElement countryDropDown;

    @FindBy(xpath="//div[@class='Select_select__items__r3NaM w100 undefined undefined']/div[1]")
    WebElement polandCheckBox;

    @FindBy(xpath="//label[text()='USA']")
    WebElement usaCheckBox;

    @FindBy(xpath = "//label[text()='Ukraine']")
    WebElement ukraineCheckBox;
    @FindBy(xpath="//p[text()='City']")
    WebElement cityDropDown;

    @FindBy(xpath="//label[text()='Los Angeles']")
    WebElement laOption;

    @FindBy(xpath="//label[text()='Miami']")
    WebElement miamiOption;

    @FindBy(xpath="//p[.='District']")
    WebElement districtDropDown;
    @FindBy(xpath = "//div[@class='users_users__filter__uKazm whiteBlock']//div[@class='Select_selectInner__lUKzH undefined w100']/div[.='Playa vista']")
    WebElement disOptionForLa;


    @FindBy(xpath="//table[@class='table']")
    WebElement dataTable;
    public void clickOnCountryDropDrown(){
        clickOnElement(countryDropDown);

    }

//    public void clickOnPolandCheckBox(){
//        clickOnElement(polandCheckBox);
//    }

    public void clickOnUSACheckBox(){

        clickOnElement(usaCheckBox);
    }
//    public void clickOnUkraineCheckBox(){
//        clickOnElement(ukraineCheckBox);
//    }

    public void clickOnCityDropDown(){

        safeClickOnElement(cityDropDown);
    }

    public void clickOnLaOption(){

        clickOnElement(laOption);
    }
    public void clickOnDistrictDropDown(){

        safeClickOnElement(districtDropDown);
    }
    public void clickOnDistrictOption(){

        safeClickOnElement(disOptionForLa);
    }
    public void clickOnMiamiOption(){
        clickOnElement(miamiOption);
    }


    public void selectUsaLosAngelosPlayaVista(){

        clickOnCountryDropDrown();
        clickOnUSACheckBox();
        clickOnCityDropDown();
        clickOnLaOption();
        clickOnDistrictDropDown();
        clickOnDistrictOption();
    }
    public void selectUsaMiami(){

        clickOnCountryDropDrown();
        clickOnUSACheckBox();
        clickOnCityDropDown();
        clickOnMiamiOption();
        clickOnDistrictDropDown();
        clickOnDistrictOption();
    }

    public WebElement isDataTableVisible(){

        return wait.until(ExpectedConditions.visibilityOf(dataTable));
    }



//    public void clickOnCheckBox(){
//
//        try {
//            // Open the desired webpage
//            //driver.get("http://example.com");
//
//            // Locate multiple checkboxes using an appropriate selector
//            List<WebElement> checkboxes = driver.findElements(By.xpath("//div[@class='Select_select__items__r3NaM w100 undefined undefined']"));
//
//            // Check one checkbox at a time for three different checkboxes
//            int checkCount = 0;
//            for (WebElement checkbox : checkboxes) {
//                if (!checkbox.isSelected()) {
//                    checkbox.click();
//                    checkCount++;
//                    // Wait or perform an action here
//                    Thread.sleep(1000);  // Adding a wait of 1 second between actions
//                    if (checkCount >= 3) {
//                        break;
//                    }
//                }
//            }
//        } catch (InterruptedException e) {
//            e.printStackTrace();
//        } finally {
//            // Close the browser
//            driver.quit();
//        }
//    }




    public void insertSearchTerm(String playground) {
        searchBar.click();
        sendKeysToElement(searchBar, playground );

        searchBar.sendKeys(Keys.ENTER);

    }

    public boolean isTableDataVisible(String playground){
        return wait.until(ExpectedConditions.visibilityOf(tableDataField)).isDisplayed();
    }
}
