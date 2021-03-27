package com.jtaf.qa.listeners;

import java.io.File;
import java.text.SimpleDateFormat;
import java.util.Calendar;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;
import org.testng.Reporter;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.jtaf.qa.test.BaseTest;
import com.jtaf.qa.utilities.ExtentUtility;

/**
 * 
 * @author Jaga
 *
 */
public class ExtentListener extends BaseTest implements ITestListener {

	public static ExtentReports extent;
	public static ExtentTest test;

	@Override
	public void onFinish(ITestContext testContext) {
		try {
			extent.flush();
			Reporter.log(testContext.getName() + " test finished");
		} catch (Exception ex) {
			ex.printStackTrace();
		}
	}

	@Override
	public void onStart(ITestContext testContext) {
		try {
			extent = ExtentUtility.getInstance();
			test = extent.createTest(testContext.getName());
			Reporter.log(testContext.getName() + " test started");
		} catch (Exception ex) {
			ex.printStackTrace();
		}
	}

	@Override
	public void onTestFailedButWithinSuccessPercentage(ITestResult arg0) {
		// TODO Auto-generated method stub
	}

	@Override
	public void onTestFailure(ITestResult testResult) {
		try {
			test.log(Status.FAIL, testResult.getThrowable());
			Reporter.log(testResult.getMethod().getMethodName() + " test failed " + testResult.getThrowable());
			if (!testResult.isSuccess()) {
				Calendar calendar = Calendar.getInstance();
				SimpleDateFormat simpleDateFormat = new SimpleDateFormat("dd_MM_yyyy_hh_mm_ss");
				String methodName = testResult.getName();
				File src = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
				String reportDirectory = new File(System.getProperty("user.dir")).getAbsolutePath()
						+ "/src/test/resources/";
				File dest = new File((String) reportDirectory + "/screenshots/failure/" + methodName + "_"
						+ simpleDateFormat.format(calendar.getTime()) + ".png");
				FileUtils.copyFile(src, dest);
				test.addScreenCaptureFromPath(dest.getAbsolutePath());
				Reporter.log("<a href='" + dest.getAbsolutePath() + "'> <img src='" + dest.getAbsolutePath()
						+ "' height='100' width='100'/></a>");
			}
		} catch (Exception ex) {
			ex.printStackTrace();
		}
	}

	@Override
	public void onTestSkipped(ITestResult testResult) {
		try {
			test.log(Status.SKIP, testResult.getThrowable());
			Reporter.log(testResult.getMethod().getMethodName() + " test skipped " + testResult.getThrowable());
		} catch (Exception ex) {
			ex.printStackTrace();
		}
	}

	@Override
	public void onTestStart(ITestResult testResult) {
		try {
			test.log(Status.INFO, testResult.getName() + " started");
			Reporter.log(testResult.getMethod().getMethodName() + " test started");
		} catch (Exception ex) {
			ex.printStackTrace();
		}
	}

	@Override
	public void onTestSuccess(ITestResult testResult) {
		try {
			test.log(Status.PASS, testResult.getName() + " passed");

			Reporter.log(testResult.getMethod().getMethodName() + " test passed");
			if (testResult.isSuccess()) {
				Calendar calendar = Calendar.getInstance();
				SimpleDateFormat simpleDateFormat = new SimpleDateFormat("dd_MM_yyyy_hh_mm_ss");
				String methodName = testResult.getName();
				File src = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
				String reportDirectory = new File(System.getProperty("user.dir")).getAbsolutePath()
						+ "/src/test/resources/";
				File dest = new File((String) reportDirectory + "/screenshots/success/" + methodName + "_"
						+ simpleDateFormat.format(calendar.getTime()) + ".png");
				FileUtils.copyFile(src, dest);
				test.addScreenCaptureFromPath(dest.getAbsolutePath());
				Reporter.log("<a href='" + dest.getAbsolutePath() + "'> <img src='" + dest.getAbsolutePath()
						+ "' height='100' width='100'/></a>");
			}
		} catch (Exception ex) {
			ex.printStackTrace();
		}
	}

}
