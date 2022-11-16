package com.test.base;

import java.io.File;
import java.io.IOException;
import java.lang.reflect.Method;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Parameters;

import com.Clipboard.base.ConfigReader;
import com.Clipboard.base.LocalBrowserInitialzation;
import com.Clipboard.utility.ExtentReport;
import com.Clipboard.utility.ScreenShotHelper;
import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;

public class TestBase

{
	ConfigReader reader = new ConfigReader();
	ExtentTest Reportlogger;

	@BeforeSuite
	public void beforeSuite() {
		ExtentReport.initiliazeExtentReport(
						System.getProperty("user.dir") + "//" + "AmazonReport" + "//" + createFolder() + "//"
								+ timestamp() + "AmazonReport.html",
						System.getProperty("user.dir") + reader.extentConfigPath());
	}

	@BeforeTest	
	@Parameters("Browser")	
	public void initialzeBrowser(String browserName) {
		LocalBrowserInitialzation.setup(reader.app_url(), browserName);
		//RemoteBrowserIntialization.setup(reader.app_url(), browserName);
	}

	@BeforeMethod(alwaysRun = true)
	@Parameters("Browser")
	public void nameBefore(Method method, String browserName) {
		String testName = method.getDeclaringClass().getName();
		System.out.println("Test executing right now= " + testName);
		Reportlogger = ExtentReport.extent.startTest(testName);
	}

	@AfterMethod(alwaysRun = true)
	@Parameters("Browser")
	public void getResult(ITestResult result, String browserName) {
		String screenshotPath = null;
		if (result.getStatus() == ITestResult.FAILURE) {
			try {
				screenshotPath = System.getProperty("user.dir") + "//Screenshots//" + timestamp() + ".png";
				ScreenShotHelper.captureScreenshot(LocalBrowserInitialzation.driver, screenshotPath);
			} catch (IOException e) {
				e.printStackTrace();
			}
			Reportlogger.log(LogStatus.FAIL, "Test Case Failed: " + result.getName());
			Reportlogger.log(LogStatus.FAIL, "Snapshot below: " + Reportlogger.addScreenCapture(screenshotPath));
			Reportlogger.log(LogStatus.FAIL, "Exception details: " + result.getThrowable());
			Reportlogger.log(LogStatus.FAIL, "Browser: " + browserName);
		} else if (result.getStatus() == ITestResult.SKIP) {
			Reportlogger.log(LogStatus.SKIP, "Test Case Skipped is " + result.getName());
			Reportlogger.log(LogStatus.SKIP, "Test Case errors are " + result.getThrowable());
		} else if (result.getStatus() == ITestResult.SUCCESS) {
			Reportlogger.log(LogStatus.PASS, "Test Case passed: " + result.getName());
			Reportlogger.log(LogStatus.PASS, "Browser: " + browserName);
		}
		ExtentReport.extent.endTest(Reportlogger);
	}

	@AfterTest
	public void TearDown() {
		LocalBrowserInitialzation.quitDriver();
	}

	@AfterSuite
	public void closeExtentReport() {
		ExtentReport.extent.flush();
		ExtentReport.extent.close();
	}

	public String createFolder() {
		Date now = new Date();
		SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
		String time = dateFormat.format(now);
		File dir = new File(time);
		// dir.mkdir();
		return dir.toString();
	}

	public String timestamp() {
		return new SimpleDateFormat("yyyy-MM-dd HH-mm-ss").format(new Date());
	}

	public void reportLog(String message) {
		Reportlogger.log(LogStatus.INFO, message); //For extentTest HTML report
	}
}