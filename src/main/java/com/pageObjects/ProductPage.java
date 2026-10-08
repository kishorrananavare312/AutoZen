package com.pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class ProductPage extends BasePage{
	
	//constructor
		public ProductPage(WebDriver driver)
		{
			super(driver);
		}
		
		
		//Locators
		@FindBy(xpath = "//a[normalize-space()='iMac']")
		WebElement productmatch;
		
		
		
		//Actions
		public String Productimac()
		{
			try {
				return (productmatch.getText());
			}
			catch(Exception e)
			{
			 return (e.getMessage());
			}
		}

}
