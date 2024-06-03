package com.base;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.awt.*;
import java.awt.event.KeyEvent;
import java.io.FileInputStream;
import java.io.IOException;
import java.time.Duration;
import java.time.Instant;
import java.util.Date;
import java.util.Properties;


public class BaseClass {
	public static WebDriverWait wait;
	public static Properties prop;
	public static JavascriptExecutor jsDriver;
	public static int timestamp = (int) (new Date().getTime()/1000);
  
   public static WebDriver driver=null;

	public static final Logger log = LoggerFactory.getLogger(BaseClass.class);
	
	public static void launchDriver()
	{
		try {
			prop = new Properties();
			FileInputStream ip = new FileInputStream(System.getProperty("user.dir")+ "/src/main/resources/config.properties");
			prop.load(ip);
		} catch (IOException e) {
			e.printStackTrace();
		}
		log.info("Initialization Test...");
		log.info("TimeStamp: "+timestamp);
		WebDriverManager.chromedriver().setup();
		ChromeOptions chromeOptions = new ChromeOptions();
		//chromeOptions.addArguments("--headless");
		chromeOptions.addArguments("--no-sandbox");
		chromeOptions.addArguments("--start-maximized");
		chromeOptions.addArguments("--window-size=1920,1080");
		DesiredCapabilities capabilities = new DesiredCapabilities();
		capabilities.setCapability(ChromeOptions.CAPABILITY, chromeOptions);
		driver = new ChromeDriver(chromeOptions);
		driver.manage().window().maximize();
		wait = new WebDriverWait(driver, Duration.ofSeconds(25));
		
	}

	public static void tearDown()
	{
		log.info("::::Active Browser is close::::");
		driver.quit();
		log.info("::::All Browser is quit::::");
	}


	public void clickOnElement(WebElement element) {

		wait.until(ExpectedConditions.elementToBeClickable(element));
		element.click();
	}

	public void sendKeysToElement(WebElement element, String keys) {
		wait.until(ExpectedConditions.visibilityOf(element));
		element.sendKeys(keys);
	}

	public void selectFromDropdownByVisibleText(WebElement element, String visibleText) {
		Select select = new Select(element);
		select.selectByVisibleText(visibleText);
	}


	public static void pressArrowUp(Robot robot, int times) {
		for (int i = 0; i < times; i++) {
			// Press and release the "arrow up" key
			robot.keyPress(KeyEvent.VK_UP);
			robot.keyRelease(KeyEvent.VK_UP);

			// Optional: Add a small delay between key presses
			robot.delay(100); // 100 milliseconds delay
		}
	}
	public WebElement findElementByXPathJS(String xPath) {
		jsDriver = (JavascriptExecutor) (driver);
		String query = String.format("document.getElement(By.xpath(\"%s\")", xPath);
		return (WebElement) (jsDriver.executeScript(query));
	}
	public void jsClickOnElement(WebElement element) {
		jsDriver = (JavascriptExecutor) (driver);
		jsDriver.executeScript("arguments[0].click();", element);
	}
	public void safeClickOnElement(WebElement element) {
		try {
			clickOnElement(element);
		} catch (ElementClickInterceptedException | StaleElementReferenceException e) {
			System.out.println("Unable to click - trying again");
			jsClickOnElement(element);
		} catch (TimeoutException | java.util.NoSuchElementException e) {
			System.out.println("Unable to locate element - check element locator and ensure element is being made available");
		}
	}

	public void highlightElement(WebDriver driver, WebElement element) {
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("arguments[0].style.border='3px solid red'", element);
	}
}
