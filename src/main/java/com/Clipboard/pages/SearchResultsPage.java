package com.Clipboard.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;

import com.Clipboard.base.LocalBrowserInitialzation;
import com.Clipboard.utility.WaitHelper;


public class SearchResultsPage {
  
	public SearchResultsPage(WebDriver driver) {
		LocalBrowserInitialzation.driver=driver;
		PageFactory.initElements(LocalBrowserInitialzation.driver, this);
	}

	  @FindBy(how = How.XPATH, using = "//div//span[text()='Brands']//following::li//span[text()='Samsung']")
	  WebElement samsungfilter;
	  
	  @FindBy(how = How.XPATH, using = "//span[@data-component-type='s-search-results']//div[@data-index='2']")
	  WebElement secondSamsungTV;
	
	  @FindBy(how = How.XPATH, using = "//span[@data-action='a-dropdown-button']//span[text()='Featured']")
	  WebElement featuredDropdown;
	  
	  @FindBy(how = How.XPATH, using = "//li//a[contains(text(),'High to Low')]")
	  WebElement priceHighToLow;
	  /*
		 *  =========================All the xpaths above this=========================================
		 *   */
		
	  
	  public SearchResultsPage click_on_samsungfilter() {
		  WaitHelper.isClickable(samsungfilter, LocalBrowserInitialzation.driver);	
		  samsungfilter.click();
		  return new SearchResultsPage(LocalBrowserInitialzation.driver);
	  }
	  
	  public SearchResultsPage click_on_featuredDropdown() {
		  WaitHelper.isClickable(featuredDropdown, LocalBrowserInitialzation.driver);	
		  featuredDropdown.click();
		  return new SearchResultsPage(LocalBrowserInitialzation.driver);
	  }
	  
	  public SearchResultsPage click_on_priceHighToLow() {
		  WaitHelper.isClickable(priceHighToLow, LocalBrowserInitialzation.driver);	
		  priceHighToLow.click();
		  return new SearchResultsPage(LocalBrowserInitialzation.driver);
	  }
	  
	  public ItemPage click_on_secondSamsungTV() {
		  WaitHelper.isClickable(secondSamsungTV, LocalBrowserInitialzation.driver);	
		  secondSamsungTV.click();
		  return new ItemPage(LocalBrowserInitialzation.driver);
	  }
	  
}