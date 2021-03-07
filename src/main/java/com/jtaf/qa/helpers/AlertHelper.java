package com.jtaf.qa.helpers;

import org.apache.log4j.Logger;
import org.openqa.selenium.Alert;
import org.openqa.selenium.NoAlertPresentException;
import org.openqa.selenium.WebDriver;

import com.jtaf.qa.pages.BasePage;

/**
 * 
 * @author Jaga
 *
 */
public class AlertHelper extends BasePage {

	Logger log = getLogger(AlertHelper.class);

	public AlertHelper(WebDriver driver) {
		super(driver);
	}

	public Alert getAlert() {
		try {
			log.info("Switch To Alert Popup Is Succesful");
		} catch (Exception ex) {
			ex.printStackTrace();
		}
		return driver.switchTo().alert();
	}

	public void acceptAlert() {
		try {
			getAlert().accept();
			log.info("Alert Popup Accept Is Succesful");
		} catch (Exception ex) {
			ex.printStackTrace();
		}
	}

	public void dismissAlert() {
		try {
			getAlert().dismiss();
			log.info("Alert Popup Dismiss Is Succesful");
		} catch (Exception ex) {
			ex.printStackTrace();
		}
	}

	public String getAlertText() {
		String text = null;
		try {
			text = getAlert().getText();
			log.info("Alert Popup Text Is : " + text);
		} catch (Exception ex) {
			ex.printStackTrace();
		}
		return text;

	}

	public boolean isAlertPresent() {
		try {
			driver.switchTo().alert();
			log.info("Alert Popup Is Present : " + true);
			return true;
		} catch (NoAlertPresentException ex) {
			log.info("Alert Popup Is Not Present : " + false);
			return false;
		}

	}

	public void acceptAlertIfPresent() {
		try {
			if (!isAlertPresent()) {
				return;
			}
			log.info("Alert Present - Alert Popup Accept Is Succesful");
			getAlertText();
			acceptAlert();
		} catch (Exception ex) {
			ex.printStackTrace();
		}
	}

	public void dismissAlertIfPresent() {
		try {
			if (!isAlertPresent()) {
				return;
			}
			log.info("Alert Present - Alert Popup Dismiss Is Succesful");
			dismissAlert();
		} catch (Exception ex) {
			ex.printStackTrace();
		}
	}

	public void acceptPrompt(String text) {
		try {
			if (!isAlertPresent()) {
				return;
			}
			Alert alert = getAlert();
			alert.sendKeys(text);
			alert.accept();
			log.info("Alert Present - Alert Prompt Popup Accept Is Succesful");
		} catch (Exception ex) {
			ex.printStackTrace();
		}
	}
	
}
