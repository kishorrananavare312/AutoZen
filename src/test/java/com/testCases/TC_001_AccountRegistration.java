package com.testCases;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.pageObjects.AccountRegistrationPage;
import com.pageObjects.HomePage;
import com.testBase.TestBase;

public class TC_001_AccountRegistration extends TestBase {
	
 @Test(groups={"Sanity"})
  public void accountregistrationverify() throws InterruptedException
  {
	 
	 logger.info("*********Starting Accountregitration testcase**********");
	 
	 try
	 {
	  HomePage hp=new HomePage(driver);
	  hp.account();
	  logger.info("click on myaccount");
	 
	
	  hp.registeration();
	  logger.info("click on Register");
	  
	
	  AccountRegistrationPage acc=new AccountRegistrationPage(driver);
	  logger.info("Providing customer details");
	  acc.setfirstname(randomstring().toUpperCase());
	  acc.setlastname(randomstring().toUpperCase());
	  acc.setemail(randomstring().toUpperCase()+"@gmail.com");
	  acc.settelephoneno(randomnumber());
	  
	  String pwdd=alphanumeric();
	  acc.setpassword(pwdd);
	  acc.setconfirmpassword(pwdd);
	  acc.policy();
	  acc.continu();
	  Thread.sleep(3000);
	  
	  
	  logger.info("Valaidating confirmation message");
	  String msg=acc.confirmationmsg();
	  Assert.assertEquals("Your Account Has Been Created!", msg);
	  logger.info("Account Created Successfully");	  
	 }
	 
	 catch (AssertionError ae) {
		    logger.error("Exception occurred during account registration test: " + ae.getMessage());
		    String screenshotPath = CaptureScreen("UserLoginFailure");
		    logger.info("Screenshot taken: " + screenshotPath);
		    Assert.fail("Assertion Failed: " + ae.getMessage());
		}
	 
	 logger.info("Account regstration test is finished");  
  }
	

}
