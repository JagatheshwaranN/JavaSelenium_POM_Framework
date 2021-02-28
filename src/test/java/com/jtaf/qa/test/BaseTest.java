package com.jtaf.qa.test;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Parameters;

import com.jtaf.qa.pages.BasePage;
import com.jtaf.qa.pages.Page;

/**
 * 
 * @author Jaga
 *
 */
public class BaseTest {

	WebDriver driver;
	public Page page;

	@BeforeMethod
	@Parameters(value = { "browser" })
	public void setUpTest(String browser) {
		if (System.getProperty("os.name").contains("Windows")) {
			if (browser.equalsIgnoreCase("Chrome")) {
				System.setProperty("webdriver.chrome.driver", "src/main/resources/BrowserDrivers/chromedriver.exe");
				driver = new ChromeDriver();
				driver.manage().window().maximize();
			} else if (browser.equalsIgnoreCase("Chrome")) {
				System.setProperty("webdriver.chrome.driver", "src/main/resources/BrowserDrivers/chromedriver.exe");
				driver = new ChromeDriver();
				driver.manage().window().maximize();
			} else {
				System.out.println("No browser is defined in xml file");
			}
			driver.get("https://admin-demo.nopcommerce.com/login");
			page = new BasePage(driver);
		} else {
			System.out.println("The operating system is not Windows");
			Assert.fail();
		}
	}

	@AfterMethod
	public void tearDown() {
		driver.quit();
	}
}
