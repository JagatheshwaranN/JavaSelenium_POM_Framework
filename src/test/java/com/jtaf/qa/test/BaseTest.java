package com.jtaf.qa.test;

import java.io.IOException;

import org.apache.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Parameters;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.jtaf.qa.pages.BasePage;
import com.jtaf.qa.pages.Page;
import com.jtaf.qa.utilities.FileReaderUtility;

/**
 * 
 * @author Jaga
 *
 */
public class BaseTest extends FileReaderUtility {

	public static WebDriver driver;
	public static Page page;
	public static ExtentReports extent;
	public static ExtentTest test;

	Logger log = getLogger(BaseTest.class);

	@BeforeSuite
	public void init() throws IOException {
		loadPropertyFile();
		log.info("======================== [ Property File Load Successful ] ========================");
	}

	@BeforeMethod
	@Parameters(value = { "browser" })
	public void setUpTest(String browser) {
		if (System.getProperty("os.name").contains(getTestData("operating.system"))) {
			if (browser.equalsIgnoreCase(getTestData("browser.chrome"))) {
				System.setProperty("webdriver.chrome.driver", getTestData("chrome.driver"));
				log.info("======================== [ Launching " + browser + " Browser] ==============================");
				driver = new ChromeDriver();
				driver.manage().window().maximize();
			} else if (browser.equalsIgnoreCase("browser.firefox")) {
				System.setProperty("webdriver.chrome.driver", getTestData("firefox.driver"));
				log.info("======================== [ Launching " + browser + " Browser] ==============================");
				driver = new ChromeDriver();
				driver.manage().window().maximize();
			} else {
				log.info("No Browser Is Defined In XML File");
			}
			driver.get(getTestData("app.url"));
			page = new BasePage(driver);
		} else {
			log.info("======================== [ The Operating System Is Not WINDOWS ] ==================");
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
