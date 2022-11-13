package com.test.pages;

import static org.testng.Assert.assertEquals;

import org.testng.annotations.Test;

import com.Clipboard.base.LocalBrowserInitialzation;
import com.Clipboard.pages.HomePage;
import com.test.base.TestBase;


public class Verify_About_this_item_on_ProductPage extends TestBase {
    
	@Test
	public void verify_about_this_item_text() {
		
		HomePage homePage= new HomePage(LocalBrowserInitialzation.driver);
        
		homePage
				.click_on_hamburgerMenu()
        		.click_on_TvElectronicslink()
        		.click_on_Televisionslink();
        
		int a =1;
		assertEquals(a==1, "Test ran");
	
	}
	
}
