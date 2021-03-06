package com.jtaf.qa.test;

import org.apache.log4j.Logger;
import org.testng.Assert;
import org.testng.annotations.Test;

import com.jtaf.qa.pages.CustomerSearchPage;
import com.jtaf.qa.pages.HomePage;
import com.jtaf.qa.pages.LoginPage;

public class CustomerSearchPageTest extends BaseTest {

	Logger log = getLogger(CustomerSearchPageTest.class);

	@Test(priority = 1)
	public void verifyCustomerSearch() {
		try {
			log.info("Customer Search Page Test Execution Start");
			HomePage homePage = page.getInstance(LoginPage.class).doLogin(getTestData("app.username"),
					getTestData("app.password"));
			String homePageHeader = homePage.getHomePageHeader();
			Assert.assertEquals(homePageHeader, getTestData("home.page.header"));
			CustomerSearchPage customerSearchPage = page.getInstance(HomePage.class).navigateToCustomerSearchPage();
			String customerSearchPageHeader = customerSearchPage.getCustomerSearchPageHeader();
			Assert.assertEquals(customerSearchPageHeader, getTestData("customer.search.page.header"));
			customerSearchPage.customerSearch(getTestData("customer.name"));
			log.info("Customer Search Page Test Execution End");
		} catch (Exception ex) {
			ex.printStackTrace();
		}
	}

}
