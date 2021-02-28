package com.jtaf.qa.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class HomePage extends BasePage {

	private By header = By.className("content-header");
	private By leftNavCustomersOption = By.xpath("//a[@href='#']//span[text()='Customers']");
	private By leftNavInlineCustomersOption = By.xpath("//a[@href='/Admin/Customer/List']//span[text()='Customers']");

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

	public CustomerSearchPage navigateToCustomerSearchPage() {
		getLeftNavCustomersOption().click();
		getLeftNavInlineCustomersOption().click();
		return getInstance(CustomerSearchPage.class);
	}
}
