package com.jtaf.qa.helpers;

import org.apache.log4j.Logger;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import com.jtaf.qa.utilities.LoggerUtility;

public class JavaScriptHelper extends LoggerUtility {

	Logger log = getLogger(JavaScriptHelper.class);
	private WebDriver driver;

	public JavaScriptHelper(WebDriver driver) {
		this.driver = driver;
	}

	public Object executeScript(String script) {
		try {
			log.info("Script : " + script);
		} catch (Exception ex) {
			ex.printStackTrace();
		}
		JavascriptExecutor executor = (JavascriptExecutor) driver;
		return executor.executeAsyncScript(script);

	}

	public Object executeScript(String script, Object... arguments) {
		try {
			log.info("Script : " + script);
		} catch (Exception ex) {
			ex.printStackTrace();
		}
		JavascriptExecutor executor = (JavascriptExecutor) driver;
		return executor.executeAsyncScript(script, arguments);
	}

	public void elementClick(WebElement element) {
		try {
			JavascriptExecutor executor = (JavascriptExecutor) driver;
			executor.executeScript("arguments[0].click();", element);
			log.info("Element Click Using JS Executor Is Successful");
		} catch (Exception ex) {
			ex.printStackTrace();
		}
	}

	public void scrollToElement(WebElement element) {
		try {
			executeScript("window.scrollTo(arguments[0],arguments[1])", element.getLocation().x,
					element.getLocation().y);
			log.info("Scroll To Element Is Successful");
		} catch (Exception ex) {
			ex.printStackTrace();
		}
	}

	public void scrollToElementAndClick(WebElement element) {
		try {
			scrollToElement(element);
			element.click();
			log.info("Scroll To Element And Click Is Successful");
		} catch (Exception ex) {
			ex.printStackTrace();
		}
	}

	public void scrollIntoView(WebElement element) {
		try {
			executeScript("arguments[0].scrollIntoView()", element);
			log.info("Scroll To View Is Successful");
		} catch (Exception ex) {
			ex.printStackTrace();
		}
	}

	public void scrollIntoViewAndClick(WebElement element) {
		try {
			scrollIntoView(element);
			element.click();
			log.info("Scroll To View And Click Is Successful");
		} catch (Exception ex) {
			ex.printStackTrace();
		}
	}

	public void scrollUpVertical() {
		try {
			executeScript("window.scrollTo(0, -document.body.scrollHeight)");
			log.info("Scroll Up Vertical Is Successful");
		} catch (Exception ex) {
			ex.printStackTrace();
		}
	}

	public void scrollDownVertical() {
		try {
			executeScript("window.scrollTo(0, document.body.scrollHeight)");
			log.info("Scroll Down Vertical Is Successful");
		} catch (Exception ex) {
			ex.printStackTrace();
		}
	}

	public void ScrolUpByPixel(String pixel) {
		try {
			executeScript("window.scrollBy(0, -'" + pixel + "')");
			log.info("Scroll Up By Pixel Is Successful");
		} catch (Exception ex) {
			ex.printStackTrace();
		}
	}

	public void ScrolDownByPixel(String pixel) {
		try {
			executeScript("window.scrollBy(0, '" + pixel + "')");
			log.info("Scroll Down By Pixel Is Successful");
		} catch (Exception ex) {
			ex.printStackTrace();
		}
	}

	public void zoomInByPercentage(String percent) {
		try {
			executeScript("document.body.style.zoom='" + percent + "'");
			log.info("Zoom In By Percent Is Successful");
		} catch (Exception ex) {
			ex.printStackTrace();
		}
	}

}
