package com.jtaf.qa.helpers;

import org.apache.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import com.jtaf.qa.utilities.LoggerUtility;

/**
 * 
 * @author Jaga
 *
 */
public class MouseActionHelper extends LoggerUtility {

	Logger log = getLogger(MouseActionHelper.class);
	private WebDriver driver;

	public MouseActionHelper(WebDriver driver) {
		this.driver = driver;
	}

	public void mouseHover(WebElement element1, WebElement element2) {
		try {
			Actions builder = new Actions(driver);
			builder.moveToElement(element1).build().perform();
			element2.click();
			log.info("Mouse hover and click on element is successful");
		} catch (Exception ex) {
			ex.printStackTrace();
		}
	}

}
