package com.jtaf.qa.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

/**
 * @author Jaga
 *
 */
public class LoginPage extends BasePage {

	private By emailId = By.id("Email");
	private By password = By.id("Password");
	private By loginButton = By.xpath("//input[@value='Log in']");
	private By header = By.className("page-title");

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
			getEmailId().clear();
			getEmailId().sendKeys(username);
			getPassword().clear();
			getPassword().sendKeys(password);
			getLoginButton().click();
		} catch (Exception ex) {
			ex.printStackTrace();
		}
		return getInstance(HomePage.class);
	}

}
