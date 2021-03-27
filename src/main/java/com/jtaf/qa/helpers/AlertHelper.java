package com.jtaf.qa.helpers;

import org.apache.log4j.Logger;
import org.openqa.selenium.Alert;
import org.openqa.selenium.NoAlertPresentException;
import org.openqa.selenium.WebDriver;
import com.jtaf.qa.utilities.LoggerUtility;

/**
 * 
 * @author Jaga
 *
 */
public class AlertHelper extends LoggerUtility {

	Logger log = getLogger(AlertHelper.class);
	private WebDriver driver;

	public AlertHelper(WebDriver driver) {
		this.driver = driver;
	}

	public Alert getAlert() {
		try {
			log.info("Switch to alert popup is succesful");
		} catch (Exception ex) {
			ex.printStackTrace();
		}
		return driver.switchTo().alert();
	}

	public void acceptAlert() {
		try {
			getAlert().accept();
			log.info("Alert popup accept is succesful");
		} catch (Exception ex) {
			ex.printStackTrace();
		}
	}

	public void dismissAlert() {
		try {
			getAlert().dismiss();
			log.info("Alert popup dismiss is succesful");
		} catch (Exception ex) {
			ex.printStackTrace();
		}
	}

	public String getAlertText() {
		String text = null;
		try {
			text = getAlert().getText();
			log.info("Alert popup text is : " + text);
		} catch (Exception ex) {
			ex.printStackTrace();
		}
		return text;

	}

	public boolean isAlertPresent() {
		try {
			driver.switchTo().alert();
			log.info("Alert popup is present : " + true);
			return true;
		} catch (NoAlertPresentException ex) {
			log.info("Alert popup is not present : " + false);
			return false;
		}

	}

	public void acceptAlertIfPresent() {
		try {
			if (!isAlertPresent()) {
				return;
			}
			log.info("Alert present - alert popup accept is succesful");
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
			log.info("Alert present - alert popup dismiss is succesful");
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
			log.info("Alert present - alert prompt popup accept is succesful");
		} catch (Exception ex) {
			ex.printStackTrace();
		}
	}

}
