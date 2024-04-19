package com.jtaf.qa.test;

import java.io.IOException;

import org.apache.log4j.Logger;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.jtaf.qa.base.BaseTest;
import com.jtaf.qa.pages.HomePage;
import com.jtaf.qa.pages.LoginPage;
import com.jtaf.qa.utilities.ExcelReaderUtility;

/**
 * 
 * @author Jaga
 *
 */
public class LoginPageTest extends BaseTest {

	Logger log = getLogger(LoginPage.class);
	ExcelReaderUtility excelReader = new ExcelReaderUtility();

	@Test(priority = 1)
	public void verifyLoginTest() {
		try {
			log.info("Login to application test execution start");
			String title = page.getInstance(LoginPage.class).getLoginPageTitle();
			Assert.assertEquals(title, getTestData("login.page.title"));
			String header = page.getInstance(LoginPage.class).getLoginPageHeader();
			Assert.assertEquals(header, getTestData("login.page.header"));
			HomePage homePage = page.getInstance(LoginPage.class).doLogin(getTestData("app.username"),
					getTestData("app.password"));
			String homePageHeader = homePage.getHomePageHeader();
			Assert.assertEquals(homePageHeader, getTestData("home.page.header"));
			log.info("Login to application test execution end");
		} catch (Exception ex) {
			ex.printStackTrace();
		}
	}

	@DataProvider(name = "LoginData")
	public Object[][] getData() throws IOException {
		return excelReader.getDataFromExcel(System.getProperty("user.dir") + getTestData("excel.path"), "login");
	}

	@Test(dataProvider = "LoginData", priority = 2, enabled = false)
	public void verifyLoginTestUsingExcelData(String username, String password) {
		try {
			log.info("Login to application using excel data test execution start");
			String title = page.getInstance(LoginPage.class).getLoginPageTitle();
			Assert.assertEquals(title, getTestData("login.page.title"));
			String header = page.getInstance(LoginPage.class).getLoginPageHeader();
			Assert.assertEquals(header, getTestData("login.page.header"));
			HomePage homePage = page.getInstance(LoginPage.class).doLogin(username, password);
			String homePageHeader = homePage.getHomePageHeader();
			Assert.assertEquals(homePageHeader, getTestData("home.page.header"));
			log.info("Login to application using excel data test execution end");
		} catch (Exception ex) {
			ex.printStackTrace();
		}
	}

}
