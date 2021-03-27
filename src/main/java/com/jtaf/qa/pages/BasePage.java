package com.jtaf.qa.pages;

import java.util.List;

import org.apache.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;

import com.jtaf.qa.helpers.AlertHelper;
import com.jtaf.qa.helpers.BrowserHelper;
import com.jtaf.qa.helpers.DropDownHelper;
import com.jtaf.qa.helpers.JavaScriptHelper;
import com.jtaf.qa.helpers.MouseActionHelper;
import com.jtaf.qa.helpers.VerificationHelper;

/**
 * @author Jaga
 *
 */
public class BasePage extends Page {

	Logger log = getLogger(BasePage.class);

	AlertHelper alertHelper = new AlertHelper(driver);
	BrowserHelper browserHelper = new BrowserHelper(driver);
	DropDownHelper dropDownHelper = new DropDownHelper();
	JavaScriptHelper javaScriptHelper = new JavaScriptHelper(driver);
	MouseActionHelper mouseActionHelper = new MouseActionHelper(driver);
	VerificationHelper verificationHelper = new VerificationHelper();

	public BasePage(WebDriver driver) {
		super(driver);

	}

	@Override
	public String getPageTitle() {
		return driver.getTitle();
	}

	@Override
	public String getPageHeader(By locator) {
		return getElement(locator).getText();

	}

	@Override
	public WebElement getElement(By locator) {
		WebElement element = null;
		try {
			waitForElementPresent(locator);
			element = driver.findElement(locator);
		} catch (Exception ex) {
			log.info("Some error occured while creation of element : " + locator.toString());
			ex.printStackTrace();
		}
		return element;
	}

	@Override
	public List<WebElement> getElements(By locator) {
		List<WebElement> elements = null;
		try {
			waitForElementPresent(locator);
			elements = driver.findElements(locator);
		} catch (Exception ex) {
			log.info("Some error occured while creation of element : " + locator.toString());
			ex.printStackTrace();
		}
		return elements;
	}

	@Override
	public void waitForElementPresent(By locator) {
		try {
			wait.until(ExpectedConditions.presenceOfElementLocated(locator));
		} catch (Exception ex) {
			log.info("Some error occured while wait for element : " + locator.toString());
			ex.printStackTrace();
		}
	}

	@Override
	public void waitForElementVisible(By locator) {
		try {
			wait.until(ExpectedConditions.visibilityOfElementLocated(locator));
		} catch (Exception ex) {
			log.info("Some error occured while wait for element : " + locator.toString());
			ex.printStackTrace();
		}
	}

	@Override
	public void waitForPageTitle(String title) {
		try {
			wait.until(ExpectedConditions.titleContains(title));
		} catch (Exception ex) {
			log.info("Some error occured while wait for page title : " + title);
			ex.printStackTrace();
		}
	}

}
