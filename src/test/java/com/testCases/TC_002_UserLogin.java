package com.testCases;

import static org.testng.Assert.assertTrue;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.pageObjects.HomePage;
import com.pageObjects.LoginPage;
import com.pageObjects.MyAccountPage;
import com.testBase.TestBase;

public class TC_002_UserLogin extends TestBase {
	
	@Test(groups={"Regression","Sanity"})
	public void Userlogin()
	{
		try
		{   
			logger.info("*********Starting UserLogin testcase**********");
			
			HomePage hp=new HomePage(driver);
			hp.account();
			logger.info("click on Myaccount");
			
		
			hp.login();
			logger.info("click on Login");
			
			
			
			LoginPage lp=new LoginPage(driver);
		    logger.info("Providing login details");
			lp.username(p.getProperty("Username"));
			lp.password(p.getProperty("password"));
			lp.loginbtn();
			
		    logger.info("Validating login details");
			MyAccountPage myacc=new MyAccountPage(driver);
			boolean confirmation=myacc.confirmmyaccount();
			
			assertTrue(confirmation);
			logger.info("Login Successfully");
			
			
		}
		catch(AssertionError ae)
		{
			logger.error("Exception occurred during login test: " + ae.getMessage());
		    String screenshotPath = CaptureScreen("UserLoginFailure");
		    logger.info("Screenshot taken: " + screenshotPath);
		    Assert.fail("Assertion Failed: " + ae.getMessage());
		}
		logger.info("login test is finished");
	}

}
