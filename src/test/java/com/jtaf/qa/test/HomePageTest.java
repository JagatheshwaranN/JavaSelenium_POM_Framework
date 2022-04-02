package com.jtaf.qa.test;

import org.apache.log4j.Logger;
import org.testng.Assert;
import org.testng.annotations.Test;

import com.jtaf.qa.base.BaseTest;
import com.jtaf.qa.pages.HomePage;
import com.jtaf.qa.pages.LoginPage;

/**
 * 
 * @author Jaga
 *
 */
public class HomePageTest extends BaseTest {

	Logger log = getLogger(HomePageTest.class);

	@Test(priority = 2)
	public void verifyHomePageTest() {
		try {
			log.info("Home page header test execution start");
			HomePage homePage = page.getInstance(LoginPage.class).doLogin(getTestData("app.username"),
					getTestData("app.password"));
			String title = page.getInstance(HomePage.class).getHomePageTitle();
			Assert.assertEquals(title, getTestData("home.page.title"));
			String homePageHeader = homePage.getHomePageHeader();
			Assert.assertEquals(homePageHeader, getTestData("home.page.header"));
			log.info("Home page header test execution end");
		} catch (Exception ex) {
			ex.printStackTrace();
		}
	}

}
