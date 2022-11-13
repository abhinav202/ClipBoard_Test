package com.Clipboard.base;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class LocalBrowserInitialzation {

	public static WebDriver driver = null;

	public static WebDriver setup(String url, String browserName) {

		if (driver == null) {
			switch (browserName) {
			case "FireFox":
				//WebDriverManager.firefoxdriver().setup();
				driver = new FirefoxDriver();
				driver.get(url);
				break;

			case "Chrome":
				//WebDriverManager.chromedriver().setup();	//No need to use WebDriverManager dependency
				driver = new ChromeDriver();				//because of the latest changes in Selenium 4.6.0
				driver.get(url);
				break;
				
			case "Edge":
				//WebDriverManager.iedriver().setup();
				driver = new EdgeDriver();
				driver.get(url);
				break;

			default:
				throw new IllegalArgumentException(
						String.format("%s browser is not valid please provide valid browserName", browserName));
			}
		}
		System.out.println("===maximize");
		driver.manage().window().maximize();
		return driver;
	}

	public static void quitDriver() {
		if (driver != null) {
			driver.quit();
			driver = null;
		}
	}
}
