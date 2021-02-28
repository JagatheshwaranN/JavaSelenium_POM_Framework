package com.jtaf.qa.pages;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;

public class CustomerSearchPage extends BasePage {

	private By header = By.xpath("//h1[@class='pull-left']");
	private By searchCustomerSection = By.xpath("//div[@class='panel panel-default panel-search']");
	private By firstName = By.id("SearchFirstName");
	private By searchCustomerButton = By.id("search-customers");
	private By tableCustomerGrid = By.xpath("//table[@id='customers-grid']");
	private By tableCustomerGridName = By.xpath("//table[@id='customers-grid']//tbody//tr//td[3]");
	private By tableCustomerGridEmpty = By.xpath("//table//td[@class='dataTables_empty']");

	public CustomerSearchPage(WebDriver driver) {
		super(driver);
	}

	public WebElement getPageHeader() {
		return getElement(header);
	}

	public WebElement getSearchCustomerSection() {
		return getElement(searchCustomerSection);
	}

	public WebElement getFirstName() {
		return getElement(firstName);
	}

	public WebElement getSearchCustomerButton() {
		return getElement(searchCustomerButton);
	}

	public WebElement getTableCustomerGrid() {
		return getElement(tableCustomerGrid);
	}

	public List<WebElement> getTableCustomerGridName() {
		return getElements(tableCustomerGridName);
	}

	public WebElement getTableCustomerGridEmpty() {
		return getElement(tableCustomerGridEmpty);
	}

	public String getCustomerSearchPageHeader() {
		return getPageHeader(header);
	}

	public void customerSearch(String customerName) {
		getSearchCustomerSection().isDisplayed();
		getFirstName().sendKeys(customerName);
		getSearchCustomerButton().click();
		boolean flag = getTableCustomerGrid().isDisplayed();
		if (flag == true) {
			System.out.println("********* Customer search result section found");
			int customerNameGrid = getTableCustomerGridName().size();
			if (customerNameGrid == 1) {
				try {
					Thread.sleep(2000);
				} catch (InterruptedException ex) {
					ex.printStackTrace();
				}
				String actualCustomerName = getTableCustomerGridName().get(0).getText();
				System.out.println("********* Actual Customer Name : " + actualCustomerName);
				if (actualCustomerName.equalsIgnoreCase("Victoria Terces")) {
					System.out.println("********* Customer match successful");
				} else {
					Assert.assertFalse(true, "Customer match unsuccessful");
				}
			} else {
				System.out.println("Empty table data found : " + getTableCustomerGridEmpty().isDisplayed());
				Assert.assertFalse(true, "No Customer data found");
			}
		} else {
			Assert.assertFalse(true, "No customer search result section found");
		}
	}

}
