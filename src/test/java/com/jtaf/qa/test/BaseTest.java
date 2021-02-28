package com.jtaf.qa.test;

import java.io.IOException;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Parameters;

import com.jtaf.qa.pages.BasePage;
import com.jtaf.qa.pages.Page;
import com.jtaf.qa.utilities.FileReader;

/**
 * 
 * @author Jaga
 *
 */
public class BaseTest extends FileReader {

	public WebDriver driver;
	public Page page;

	@BeforeSuite
	public void init() throws IOException {
		loadPropertyFile();
		System.out.println("+++++++++++++++ [ Property file load successful ] +++++++++++++++");
	}

	@BeforeMethod
	@Parameters(value = { "browser" })
	public void setUpTest(String browser) {
		if (System.getProperty("os.name").contains(getTestData("operating.system"))) {
			if (browser.equalsIgnoreCase(getTestData("browser.chrome"))) {
				System.setProperty("webdriver.chrome.driver", getTestData("chrome.driver"));
				System.out.println("+++++++++++++++ [ Launching " + browser + " browser] +++++++++++++++");
				driver = new ChromeDriver();
				driver.manage().window().maximize();
			} else if (browser.equalsIgnoreCase("browser.firefox")) {
				System.setProperty("webdriver.chrome.driver", getTestData("firefox.driver"));
				driver = new ChromeDriver();
				driver.manage().window().maximize();
			} else {
				System.out.println("No browser is defined in xml file");
			}
			driver.get(getTestData("app.url"));
			page = new BasePage(driver);
		} else {
			System.out.println("+++++++++++++++ [ The operating system is not WINDOWS ] +++++++++++++++");
			Assert.fail();
		}
	}

	@AfterMethod
	public void tearDown() {
		driver.close();
	}

	@AfterSuite
	public void exit() {
		driver.quit();
	}

}
