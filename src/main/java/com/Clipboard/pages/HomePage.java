package com.Clipboard.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;

import com.Clipboard.base.LocalBrowserInitialzation;



public class HomePage {
  
	public HomePage(WebDriver driver) {
		LocalBrowserInitialzation.driver=driver;
		PageFactory.initElements(LocalBrowserInitialzation.driver, this);
	}

	  @FindBy(how = How.XPATH, using = "//a[@role='button' and @id='nav-hamburger-menu']")
	  WebElement hamburgerMenu;
	  
	  @FindBy(how = How.XPATH, using = "//li//div[text()='shop by category']//following::li//div[text()='TV, Appliances, Electronics']")
	  WebElement tvElectronicslink;
	  
	  @FindBy(how = How.XPATH, using = "//a[text()='Televisions']")
	  WebElement televisionslink;
	  

	  /*
		 *  =========================All the xpaths above this=========================================
		 *   */
		
	  
	  public HomePage click_on_hamburgerMenu() {		 	
		  hamburgerMenu.click();
		  return new HomePage(LocalBrowserInitialzation.driver);
	  }
	  
	  public HomePage click_on_TvElectronicslink() {		  	
		  tvElectronicslink.click();
		  return new HomePage(LocalBrowserInitialzation.driver);
	  }
	  
	  public HomePage click_on_Televisionslink() {		  	
		  televisionslink.click();
		  return new HomePage(LocalBrowserInitialzation.driver);
	  }
	  
}