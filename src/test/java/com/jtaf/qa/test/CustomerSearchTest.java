package com.jtaf.qa.test;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.jtaf.qa.pages.CustomerSearchPage;
import com.jtaf.qa.pages.HomePage;
import com.jtaf.qa.pages.LoginPage;

public class CustomerSearchTest extends BaseTest {

	@Test(priority = 1)
	public void verifyCustomerSearch() {
		HomePage homePage = page.getInstance(LoginPage.class).doLogin("admin@yourstore.com", "admin");
		String homePageHeader = homePage.getHomePageHeader();
		System.out.println("********* Home Page Header");
		Assert.assertEquals(homePageHeader, "Dashboard");
		CustomerSearchPage customerSearchPage = page.getInstance(HomePage.class).navigateToCustomerSearchPage();
		String customerSearchPageHeader = customerSearchPage.getCustomerSearchPageHeader();
		System.out.println("********* Customer Search Page Header");
		Assert.assertEquals(customerSearchPageHeader, "Customers");
		customerSearchPage.customerSearch("Victoria");
	}

}
