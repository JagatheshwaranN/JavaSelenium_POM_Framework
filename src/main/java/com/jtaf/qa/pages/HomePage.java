package com.jtaf.qa.pages;

import org.apache.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class HomePage extends BasePage {

	private By header = By.xpath("//div[@class='content-header']");
	private By leftNavCustomersOption = By.xpath("//a[@href='#']//p[contains(text(),'Customers')]");
	private By leftNavInlineCustomersOption = By.xpath("//a[@href='/Admin/Customer/List']//p[contains(text(),'Customers')]");
	private By customerSearchSection = By.xpath("//div[@class='card card-default card-search']");
	
	Logger log = getLogger(HomePage.class);

	public HomePage(WebDriver driver) {
		super(driver);
	}

	public WebElement getHeader() {
		return getElement(header);
	}

	public String getHomePageTitle() {
		return getPageTitle();
	}

	public String getHomePageHeader() {
		return getPageHeader(header);
	}

	public WebElement getLeftNavCustomersOption() {
		return getElement(leftNavCustomersOption);
	}

	public WebElement getLeftNavInlineCustomersOption() {
		return getElement(leftNavInlineCustomersOption);
	}

	public WebElement getCustomerSearchSection() {
		return getElement(customerSearchSection);
	}

	public CustomerSearchPage navigateToCustomerSearchPage() {
		try {
			log.info("Home Page navigateToCustomerSearchPage Execution Start");
			getLeftNavCustomersOption().click();
			getLeftNavInlineCustomersOption().click();
			getCustomerSearchSection().isDisplayed();
			log.info("Home Page navigateToCustomerSearchPage Execution End");
		} catch (Exception ex) {
			ex.printStackTrace();
		}
		return getInstance(CustomerSearchPage.class);
	}
}
