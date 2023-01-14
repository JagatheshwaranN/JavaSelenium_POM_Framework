package com.jtaf.qa.pages;

import org.apache.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;

/**
 * @author Jaga
 *
 */
public class LoginPage extends BasePage {

	private By emailId = By.id("Email");
	private By password = By.id("Password");
	private By loginButton = By.xpath("//button[text()='Log in']");
	private By header = By.className("page-title");

	Logger log = getLogger(LoginPage.class);

	public LoginPage(WebDriver driver) {
		super(driver);
	}

	public WebElement getHeader() {
		return getElement(header);
	}

	public WebElement getLoginButton() {
		return getElement(loginButton);
	}

	public WebElement getPassword() {
		return getElement(password);
	}

	public WebElement getEmailId() {
		return getElement(emailId);
	}

	public String getLoginPageTitle() {
		return getPageTitle();
	}

	public String getLoginPageHeader() {
		return getPageHeader(header);
	}

	public HomePage doLogin(String username, String password) {
		try {
			log.info("Do login execution start");
			Assert.assertEquals(true, verificationHelper.verifyElementPresent(getEmailId()));
			getEmailId().clear();
			getEmailId().sendKeys(username);
			Assert.assertEquals(true, verificationHelper.verifyElementPresent(getPassword()));
			getPassword().clear();
			getPassword().sendKeys(password);
			// javaScriptHelper.elementClick(getLoginButton());
			getLoginButton().click();
			log.info("Do login execution end");
		} catch (Exception ex) {
			ex.printStackTrace();
		}
		return getInstance(HomePage.class);
	}

}
