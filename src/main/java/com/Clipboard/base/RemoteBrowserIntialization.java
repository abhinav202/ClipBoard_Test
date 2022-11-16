package com.Clipboard.base;

import java.net.MalformedURLException;
import java.net.URL;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.openqa.selenium.remote.AbstractDriverOptions;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;

import static java.lang.System.getenv;

public class RemoteBrowserIntialization {

	public static WebDriver driver = null;

	public static WebDriver setup(String url, String browserName) throws MalformedURLException {

		@SuppressWarnings("rawtypes")
		AbstractDriverOptions options = null;
		
		//ChromeOptions options = new ChromeOptions();
		//FirefoxOptions options;
		
		if (driver == null) {
			if (browserName.equalsIgnoreCase("CHROME")) {
				//options = new ChromeOptions();
				System.out.println("======"+url);
				options.setCapability("browserName", "chrome");
				//options.setCapability("browserVersion", "107");
				//options.addArguments("--no-sandbox");
				//options.setPlatformName("Windows 10");						
				try {				
					driver = new RemoteWebDriver(new URL(url), options);
				}catch(Exception e) { e.printStackTrace();}				
				// Loggers.getInfoLog("New chrome driver instantiated....");
			}

			else if (browserName.equalsIgnoreCase("FIREFOX")) {
				options = new FirefoxOptions();				
				options.setCapability("browserName", "Firefox");							
				try {
				driver = new RemoteWebDriver(new URL("http://localhost:4444"), options);				
				}catch(Exception e) { e.printStackTrace();}				
				// Loggers.getInfoLog("New Firefox driver instantiated....");
			}

			else if (browserName.equalsIgnoreCase("EDGE")) {
				options = new EdgeOptions();
				options.setCapability(browserName, "Edge");
				driver = new RemoteWebDriver(new URL(url), options);
				// Loggers.getInfoLog("New Edge driver instantiated....");
			} else
				throw new IllegalArgumentException(
						String.format("%s browser is not valid please provide valid browserName", browserName));
		}
		driver.get(url);
		driver.manage().deleteAllCookies();
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