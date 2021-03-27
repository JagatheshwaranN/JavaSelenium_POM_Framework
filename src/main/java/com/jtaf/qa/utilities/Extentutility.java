package com.jtaf.qa.utilities;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;

/**
 * 
 * @author Jaga
 *
 */
public class ExtentUtility {

	private static ExtentReports extent;

	public static ExtentReports getInstance() {
		if (extent == null) {
			return createInstance("test-output/report/extent-report.html");
		} else {
			return extent;
		}
	}

	public static ExtentReports createInstance(String fileName) {
		try {
			ExtentHtmlReporter htmlReporter = new ExtentHtmlReporter(fileName);
			htmlReporter.config().setTheme(Theme.STANDARD);
			htmlReporter.config().setDocumentTitle("Automation Execution Report");
			htmlReporter.config().setEncoding("utf-8");
			htmlReporter.config().setReportName("Automation Execution Report");
			extent = new ExtentReports();
			extent.attachReporter(htmlReporter);
		} catch (Exception ex) {
			ex.printStackTrace();
		}
		return extent;
	}
}
