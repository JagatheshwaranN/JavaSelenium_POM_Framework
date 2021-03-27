package com.jtaf.qa.helpers;

import java.util.LinkedList;
import java.util.List;

import org.apache.log4j.Logger;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

import com.jtaf.qa.utilities.LoggerUtility;

/**
 * 
 * @author Jaga
 *
 */
public class DropDownHelper extends LoggerUtility {

	Logger log = getLogger(DropDownHelper.class);

	public void selectByValue(WebElement element, String value) {
		try {
			Select select = new Select(element);
			select.selectByValue(value);
			log.info("The value " + value + " is selected");
		} catch (Exception ex) {
			ex.printStackTrace();
		}
	}

	public void selectByIndex(WebElement element, int index) {
		try {
			Select select = new Select(element);
			select.selectByIndex(index);
			log.info("The value at index " + index + " is selected");
		} catch (Exception ex) {
			ex.printStackTrace();
		}
	}

	public void selectByVisibleText(WebElement element, String visibleText) {
		try {
			Select select = new Select(element);
			select.selectByVisibleText(visibleText);
			log.info("The visible text " + visibleText + " is selected");
		} catch (Exception ex) {
			ex.printStackTrace();
		}
	}

	public String getSelectValue(WebElement element) {
		String value = null;
		try {
			value = new Select(element).getFirstSelectedOption().getText();
			log.info("The selected value text is : " + value);
		} catch (Exception ex) {
			ex.printStackTrace();
		}
		return value;
	}

	public List<String> getAllDropDownValue(WebElement element) {
		List<String> dropdownvalues = null;
		try {
			Select select = new Select(element);
			List<WebElement> listelements = select.getOptions();
			dropdownvalues = new LinkedList<String>();
			for (WebElement elements : listelements) {
				log.info("The element values of the dropdown are : " + elements.getText());
				dropdownvalues.add(elements.getText());
			}
		} catch (Exception ex) {
			ex.printStackTrace();
		}
		return dropdownvalues;
	}

}
