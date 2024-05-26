package com.pageObjects;

import com.base.BaseClass;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class MatchesPage extends BaseClass {

    public  MatchesPage(WebDriver driver){
        PageFactory.initElements(driver, this);

    }

    @FindBy(xpath ="//input[@class='CommonInput_input__1a_v4 users_users__searchInput__p6IsS']")
    WebElement  searchBar;

    @FindBy(css="tbody tr:nth-child(1) td:nth-child(6)")
    WebElement tableDataField;


    public void insertSearchTerm(String playground) {
        searchBar.click();
        sendKeysToElement(searchBar, playground );

        searchBar.sendKeys(Keys.ENTER);

    }

    public boolean isTableDataVisible(String playground){
        return wait.until(ExpectedConditions.visibilityOf(tableDataField)).isDisplayed();
    }
}
