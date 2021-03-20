package com.jtaf.qa.pages;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.jtaf.qa.utilities.LoggerUtility;

/**
 * @author Jaga
 *
 */
public abstract class Page extends LoggerUtility {

	public WebDriver driver;
	public WebDriverWait wait;

	public Page(WebDriver driver) {
		this.driver = driver;
		this.wait = new WebDriverWait(this.driver, 30);
	}

	public abstract String getPageTitle();

	public abstract String getPageHeader(By locator);

	public abstract WebElement getElement(By locator);

	public abstract List<WebElement> getElements(By locator);

	public abstract void waitForElementPresent(By locator);

	public abstract void waitForElementVisible(By locator);
	
	public abstract void waitForPageTitle(String title);

	public <TPage extends BasePage> TPage getInstance(Class<TPage> pageClass) {
		try {
			return pageClass.getDeclaredConstructor(WebDriver.class).newInstance(this.driver);
		} catch (Exception ex) {
			ex.printStackTrace();
			return null;
		}
	}

}
