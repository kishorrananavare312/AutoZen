package com.pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class HomePage extends BasePage{

	//Constructor
	public HomePage(WebDriver driver) {
		super(driver);
	}
	
	
	//Locators
	@FindBy(xpath="//span[normalize-space()='My Account']")
	WebElement lnkmyaccount;
	
	  @FindBy(xpath = "//a[normalize-space()='Register']")
	    WebElement register;
		
	    
	    @FindBy(xpath = "//a[normalize-space()='Login']")
	    WebElement linklogin;
	  
		
		//action
		public void account()
		{
		 lnkmyaccount.click();
		}
		
		public void registeration()
		{
		 register.click();
		}
		
		public void login()
		{
		 linklogin.click();
		}
		

}
