package com.jtaf.qa.helpers;

import java.util.LinkedList;
import java.util.Set;

import org.apache.log4j.Logger;
import org.openqa.selenium.WebDriver;

import com.jtaf.qa.utilities.LoggerUtility;

/**
 * 
 * @author Jaga
 *
 */
public class BrowserHelper extends LoggerUtility {

	Logger log = getLogger(BrowserHelper.class);
	private WebDriver driver;

	public BrowserHelper(WebDriver driver) {
		this.driver = driver;
	}

	public void goBack() {
		try {
			driver.navigate().back();
			log.info("Browser navigate to previous page");
		} catch (Exception ex) {
			ex.printStackTrace();
		}
	}

	public void goForward() {
		try {
			driver.navigate().forward();
			log.info("Browser navigate to front page");
		} catch (Exception ex) {
			ex.printStackTrace();
		}
	}

	public void refresh() {
		try {
			driver.navigate().refresh();
			log.info("Browser refresh the current page");
		} catch (Exception ex) {
			ex.printStackTrace();
		}
	}

	public Set<String> getWindowHandles() {
		try {
			log.info("Capturing windows unique alphanumeric ids");
		} catch (Exception ex) {
			ex.printStackTrace();
		}
		return driver.getWindowHandles();
	}

	public void SwitchToWindow(int index) {
		try {
			LinkedList<String> windowsId = new LinkedList<String>(getWindowHandles());
			if (index < 0 || index > windowsId.size())
				throw new IllegalArgumentException("Window handle has invalid index : " + index);
			driver.switchTo().window(windowsId.get(index));
			log.info("Switch to window with index : " + index);
		} catch (Exception ex) {
			ex.printStackTrace();
		}
	}

	public void switchToParentWindow() {
		try {
			LinkedList<String> windowsid = new LinkedList<String>(getWindowHandles());
			driver.switchTo().window(windowsid.get(0));
			log.info("Switch to parent window");
		} catch (Exception ex) {
			ex.printStackTrace();
		}
	}

	public void switchToParentWithChildClose() {
		try {
			switchToParentWindow();
			LinkedList<String> windowsid = new LinkedList<String>(getWindowHandles());
			for (int i = 1; i < windowsid.size(); i++) {
				log.info("Child window id : " + windowsid.get(i));
				driver.switchTo().window(windowsid.get(i));
				driver.close();
			}
			switchToParentWindow();
		} catch (Exception ex) {
			ex.printStackTrace();
		}
	}

	public void switchToFrame(String nameOrid) {
		try {
			driver.switchTo().frame(nameOrid);
			log.info("Switch to frame with name or id : " + nameOrid);
		} catch (Exception ex) {
			ex.printStackTrace();
		}
	}

	public String getCurrentPageUrl() {
		String url = null;
		try {
			url = driver.getCurrentUrl();
			log.info("Current page url : " + url);
		} catch (Exception ex) {
			ex.printStackTrace();
		}
		return url;
	}

}
