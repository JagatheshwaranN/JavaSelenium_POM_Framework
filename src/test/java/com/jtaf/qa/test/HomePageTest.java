package com.jtaf.qa.test;

import org.apache.log4j.Logger;
import org.testng.Assert;
import org.testng.annotations.Test;

import com.jtaf.qa.pages.HomePage;

/**
 * 
 * @author Jaga
 *
 */
public class HomePageTest extends BaseTest {
	
	Logger log = getLogger(HomePageTest.class);

	@Test(priority = 1)
	public void verifyHomePageTitleTest() {
		try {
			log.info("Home Page Title Test Execution Start");
			String title = page.getInstance(HomePage.class).getHomePageTitle();
			Assert.assertEquals(title, getTestData("home.page.title"));
			log.info("Home Page Title Test Execution End");
		} catch (Exception ex) {
			ex.printStackTrace();
		}
	}

	@Test(priority = 2)
	public void verifyHomePageHeaderTest() {
		try {
			log.info("Home Page Header Test Execution Start");
			String header = page.getInstance(HomePage.class).getHomePageHeader();
			Assert.assertEquals(header, getTestData("home.page.header"));
			log.info("Home Page Header Test Execution End");
		} catch (Exception ex) {
			ex.printStackTrace();
		}
	}

}
