package com.pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class SearchProductPage extends BasePage {

	//Constructor

		public SearchProductPage(WebDriver driver) {
			super(driver);
			// TODO Auto-generated constructor stub
		}


		//Locators
		@FindBy(xpath = "//input[@placeholder='Search']")
		WebElement txtsearchproductname;
		
		
		@FindBy(xpath = "//button[@class='btn btn-default btn-lg']")
		WebElement btnsearch;

		
		//Actions
		//Actions
			public void seacrhproductname(String productname)
			{
				txtsearchproductname.sendKeys(productname);
			}
			
			
			public void searchbtn()
			{
				btnsearch.click();
			}
}
