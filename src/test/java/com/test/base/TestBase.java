package com.test.base;

import java.lang.reflect.Method;

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

public class TestBase {
	
	ConfigReader reader = new ConfigReader();
	
	@BeforeSuite
	public void beforeSuite() {

	}

	@BeforeTest
	@Parameters("Browser")
	public void initialzeBrowser(String browserName) {
		LocalBrowserInitialzation.setup(reader.app_url(), browserName);
	}

	@BeforeMethod(alwaysRun = true)
	@Parameters("Browser")
	public void nameBefore(Method method, String browserName) {
		String testName = method.getDeclaringClass().getName();
		System.out.println("Test executing right now= " + testName);		
	}

	@AfterMethod
	public void getResult(ITestResult result, String browserName) {

	}

	@AfterTest
	public void TearDown() {
		LocalBrowserInitialzation.quitDriver();
	}

	@AfterSuite
	public void closeExtentReport() {

	}

}