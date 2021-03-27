package com.jtaf.qa.helpers;

import org.apache.log4j.Logger;
import org.openqa.selenium.WebElement;
import com.jtaf.qa.utilities.LoggerUtility;

/**
 * 
 * @author Jaga
 *
 */
public class VerificationHelper extends LoggerUtility {

	Logger log = getLogger(VerificationHelper.class);

	public boolean verifyElementPresent(WebElement element) {
		boolean isDisplayed = false;
		try {
			isDisplayed = element.isDisplayed();
			log.info("Element is present on the page");
		} catch (Exception ex) {
			ex.printStackTrace();
		}
		return isDisplayed;
	}

	public boolean verifyTextEquals(WebElement element, String text) {
		boolean flag = false;
		try {
			String actualText = element.getText();
			if (actualText.equals(text)) {
				log.info("Element text and given text is equal");
				return flag = true;
			} else {
				return flag;
			}
		} catch (Exception ex) {
			ex.printStackTrace();
		}
		return flag;
	}

	public String readTextValueFromElement(WebElement element) {
		boolean displayed = false;
		String text = null;
		try {
			displayed = isDisplayed(element);
			if (!displayed)
				return null;
			text = element.getText();
			log.info("Element Text Is : " + text);
		} catch (Exception ex) {
			ex.printStackTrace();
		}
		return text;
	}

	public String readValueFromInput(WebElement element) {
		String value = null;
		try {
			if (!isDisplayed(element))
				return null;
			value = element.getAttribute("value");
			log.info("Element Text Is : " + value);
		} catch (Exception ex) {
			ex.printStackTrace();
		}
		return value;
	}

	public boolean isDisplayed(WebElement element) {
		boolean flag = false;
		try {
			element.isDisplayed();
			flag = true;
			log.info("Element is displayed on the page");
		} catch (Exception ex) {
			ex.printStackTrace();
		}
		return flag;
	}

}
