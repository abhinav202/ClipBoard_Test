package com.Clipboard.utility;

import java.io.File;

import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;

public class ExtentReport {

	public static ExtentReports extent;
	public static ExtentTest Reportlogger;
	// private static ITestResult result;

	public static void initiliazeExtentReport(String filePath, String extentXML) {
		extent = new ExtentReports(filePath, false);
		extent.loadConfig(new File("undostres_core//test-output//extent-config.xml"));
	}

}