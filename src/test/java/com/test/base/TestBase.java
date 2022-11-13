package com.test.base;

import java.lang.reflect.Method;

import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.BeforeTest;

public class TestBase 

{
	
	
	@BeforeSuite
	public void beforeSuite() {
		
	}
	
	@BeforeTest
    public void initialzeBrowser(String browserName) {
		
	}
	
	@BeforeMethod
	public void nameBefore(Method method, String browserName) {
		
	}
	
	@AfterMethod
	public  void getResult(ITestResult result, String browserName) {
		
	}
	
	@AfterTest
	public void TearDown() {
		
	}
	
	@AfterSuite
	public void closeExtentReport() {
		
	}
		
}