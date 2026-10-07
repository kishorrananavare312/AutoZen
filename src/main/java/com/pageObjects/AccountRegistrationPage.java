package com.pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class AccountRegistrationPage extends BasePage{
	
	
	public AccountRegistrationPage(WebDriver driver) {
		super(driver);
	}
	
	
	//Locators
	@FindBy(xpath = "//input[@name='firstname']")
	WebElement txtfirstname;
	
	@FindBy(xpath = "//input[@id='input-lastname']")
	WebElement txtlastname;
	
	@FindBy(xpath = "//input[@id='input-email']")
	WebElement txtemail;

	@FindBy(xpath = "//input[@id='input-telephone']")
	WebElement txttelephone;
	
	@FindBy(xpath = "//input[@id='input-password']")
	WebElement txtpwd;
	
	@FindBy(xpath = "//input[@id='input-confirm']")
	WebElement txtconfirmpwd;
	
	@FindBy(xpath = "//input[@name='agree']")
	WebElement checkpolicy;
	
	@FindBy(xpath = "//input[@value='Continue']")
	WebElement btncontinue;
	
	@FindBy(xpath = "//h1[normalize-space()='Your Account Has Been Created!']")
	WebElement confirmationmsg;
	
	
	//Action
	public void setfirstname(String fname)
	{
		txtfirstname.sendKeys(fname);
	}
	
	public void setlastname(String lname)
	{
		txtlastname.sendKeys(lname);
	}
	
	public void setemail(String email)
	{
		txtemail.sendKeys(email);
	}
	
	public void settelephoneno(String telno)
	{
		txttelephone.sendKeys(telno);
	}
	
	public void setpassword(String pwd)
	{
		txtpwd.sendKeys(pwd);
	}
	
	public void setconfirmpassword(String cpwd)
	{
		txtconfirmpwd.sendKeys(cpwd);
	}
	
	public void policy()
	{
		checkpolicy.click();
	}
	
	public void continu()
	{
		btncontinue.click();
	}
	
	
	public String confirmationmsg()
	{
		try {
			return (confirmationmsg.getText());
		}
		catch(Exception e)
		{
		 return (e.getMessage());
		}
		
	}
	

	

}
