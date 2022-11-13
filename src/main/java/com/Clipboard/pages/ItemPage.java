package com.Clipboard.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;

import com.Clipboard.base.LocalBrowserInitialzation;
import com.Clipboard.utility.WaitHelper;
import com.Clipboard.utility.WindowHelper;


public class ItemPage {
  
	public ItemPage(WebDriver driver) {
		LocalBrowserInitialzation.driver=driver;
		PageFactory.initElements(LocalBrowserInitialzation.driver, this);
	}

	  @FindBy(how = How.XPATH, using = "//div//h1[contains(text(), 'About this item')]")
	  WebElement aboutThisItemText;
	  
	  /*
		 *  =========================All the xpaths above this=========================================
		 *   */
		
	  
	  public String check_aboutThisItem_is_displayed() {
		  
		  WindowHelper.switchToWindow(2, LocalBrowserInitialzation.driver);		  
		  WaitHelper.isVisible(aboutThisItemText, LocalBrowserInitialzation.driver);
		  
		  return aboutThisItemText.getText();
	  }
	  
	 
}