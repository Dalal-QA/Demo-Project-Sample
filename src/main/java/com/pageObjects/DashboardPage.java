package com.pageObjects;

import com.base.BaseClass;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class DashboardPage extends BaseClass {

    public DashboardPage(WebDriver driver) {
        PageFactory.initElements(driver, this);
    }

    @FindBy(xpath = "//h1[text()='Dashboard']")
    WebElement dashboardTitle;

    @FindBy(xpath ="//p[@class='NavbarItem_item__label__FfqJ1 false'][normalize-space()='Matches']")
    WebElement matchesButton;

    //

    public MatchesPage clickMatchesButton(){
        clickOnElement(matchesButton);
        return new MatchesPage(driver);
    }

    public boolean isDashboardTitleDisplayed(){
        return wait.until(ExpectedConditions.visibilityOf(dashboardTitle)).isDisplayed();
    }

    public void clickOnMenu(String option){
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//p[text()=\""+option+"\"]")));
        wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//p[text()=\""+option+"\"]")));
        driver.findElement(By.xpath("//p[text()=\""+option+"\"]")).click();
        log.info("Clicked on "+option+" option");
    }

    public boolean isPageTitleDisplayed(String menu){
        return wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//h1[contains(text(),\""+menu+"\")]"))).isDisplayed();
    }
}
