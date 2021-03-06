package com.jtaf.qa.test;

import org.apache.log4j.Logger;
import org.testng.Assert;
import org.testng.annotations.Test;

import com.jtaf.qa.pages.HomePage;
import com.jtaf.qa.pages.LoginPage;

/**
 * 
 * @author Jaga
 *
 */
public class LoginPageTest extends BaseTest {

	Logger log = getLogger(LoginPage.class);

	@Test(priority = 1)
	public void verifyLoginPageTitleTest() {
		try {
			log.info("Login Page Title Test Execution Start");
			String title = page.getInstance(LoginPage.class).getLoginPageTitle();
			Assert.assertEquals(title, getTestData("login.page.title"));
			log.info("Login Page Title Test Execution End");
		} catch (Exception ex) {
			ex.printStackTrace();
		}
	}

	@Test(priority = 2)
	public void verifyLoginPageHeaderTest() {
		try {
			log.info("Login Page Header Test Execution Start");
			String header = page.getInstance(LoginPage.class).getLoginPageHeader();
			Assert.assertEquals(header, getTestData("login.page.header"));
			log.info("Login Page Header Test Execution End");
		} catch (Exception ex) {
			ex.printStackTrace();
		}
	}

	@Test(priority = 3)
	public void verifyLoginTest() {
		try {
			log.info("Login To Application Test Execution Start");
			HomePage homePage = page.getInstance(LoginPage.class).doLogin(getTestData("app.username"),
					getTestData("app.password"));
			String homePageHeader = homePage.getHomePageHeader();
			Assert.assertEquals(homePageHeader, getTestData("home.page.header"));
			log.info("Login To Application Test Execution End");
		} catch (Exception ex) {
			ex.printStackTrace();
		}
	}

}
