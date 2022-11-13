package com.Clipboard.base;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;	
import io.github.bonigarcia.wdm.WebDriverManager;

public class LocalBrowserInitialzation {
	
	public static WebDriver driver=null;
	public static  WebDriver setup(String url, String browserName){
		
		if (driver == null) {
			switch (browserName) {
			case "FireFox":
				WebDriverManager.firefoxdriver().setup();
				driver = new FirefoxDriver();
				driver.get(url);
				break;

			case "Chrome":
				WebDriverManager.chromedriver().setup();
				driver = new ChromeDriver();
				driver.get(url);
				
				break;
			case "IE":
				WebDriverManager.iedriver().setup();
				driver = new InternetExplorerDriver();
				driver.get(url);
				
				break;
				
					
			default:
				throw new IllegalArgumentException(
						String.format("%s browser is not valid please provide valid browserName", browserName));
			}
		}
		driver.manage().window().maximize();
		return driver;
	}
	
	public static void quitDriver() {
		if (driver != null) {
			driver.quit();
			driver=null;
		}
	}
}
	
	

