package com.jtaf.qa.test;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.jtaf.qa.pages.HomePage;
import com.jtaf.qa.pages.LoginPage;

/**
 * 
 * @author Jaga
 *
 */
public class LoginTest extends BaseTest {

	@Test(priority = 1)
	public void verifyloginPageTitleTest() {
		String title = page.getInstance(LoginPage.class).getLoginPageTitle();
		System.out.println("******* Login Page Title");
		Assert.assertEquals(title, "Your store. Login");
	}

	@Test(priority = 2)
	public void verifyloginPageHeaderTest() {
		String header = page.getInstance(LoginPage.class).getLoginPageHeader();
		System.out.println("******* Login Page Header");
		Assert.assertEquals(header, "Admin area demo");
	}

	@Test(priority = 3)
	public void verifyLoginTest() {
		HomePage homePage = page.getInstance(LoginPage.class).doLogin(getTestData("app.username"), getTestData("app.password"));
		String homePageHeader = homePage.getHomePageHeader();
		System.out.println("******* Home Page Header");
		Assert.assertEquals(homePageHeader, "Dashboard");
	}

}
