package com.testCases;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.pageObjects.ProductPage;
import com.pageObjects.SearchProductPage;
import com.testBase.TestBase;

public class TC_003_SearchCorrectProduct extends TestBase {

	@Test
	public void searchproduct() throws InterruptedException
	{
		logger.info("*********Starting SearchProduct testcase**********");
		
		try {
	
		SearchProductPage searchproduct=new SearchProductPage(driver);
		logger.info("Enter iMac procuctname");
	    searchproduct.seacrhproductname("iMac");
	    Thread.sleep(2000);
	    logger.info("click on Searchproduct");
	    searchproduct.searchbtn();
	    
	    
		ProductPage ppage=new ProductPage(driver);
	    logger.info("Valadating correct product");
	    String confirmproduct=ppage.Productimac();
	    
	    Assert.assertEquals("iMac",confirmproduct);
		 logger.info("product match");
		 
		}
		 catch (AssertionError ae) {
			    logger.error("Exception occurred during confirm product name: " + ae.getMessage());
			    String screenshotPath = CaptureScreen("productunmatch");
			    logger.info("Screenshot taken: " + screenshotPath);
			    Assert.fail("Assertion Failed: " + ae.getMessage());
		
	}

}
}
