package com.jtaf.qa.helpers;

import org.apache.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;

import com.jtaf.qa.pages.BasePage;

public class MouseActionHelper extends BasePage {

	Logger log = getLogger(MouseActionHelper.class);

	public MouseActionHelper(WebDriver driver) {
		super(driver);
	}

	public void mouseHover(WebElement element1, WebElement element2) {
		try {
			Actions builder = new Actions(driver);
			builder.moveToElement(element1).build().perform();
			element2.click();
			log.info("Mouse Hover And Click On Element Is Successful");
		} catch (Exception ex) {
			ex.printStackTrace();
		}
	}

}
