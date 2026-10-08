package com.testBase;
import java.io.ByteArrayInputStream;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.time.Duration;
import java.util.Date;
import java.util.Properties;
import org.apache.commons.io.FileUtils;
import org.apache.commons.lang3.RandomStringUtils;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;

import io.qameta.allure.Allure;

public class TestBase {
	
	public static WebDriver driver;
	public Logger logger;
	public Properties p;
	

@BeforeClass(groups= {"Sanity","Regression"})
@Parameters("browser")
public void Setup(String br) throws IOException
{   
	
	// Loading config.properties file
	FileReader filep = new FileReader("./src/test/resources/config.properties");
	p = new Properties();
	p.load(filep);
	
	//Generates the logs
	logger = LogManager.getLogger(this.getClass());
	
	switch (br.toLowerCase()) {
	case "chrome":
		logger.info("Opening chrome browser");
		driver = new ChromeDriver();
		break;
	case "edge":
	logger.info("Opening edge browser");
		driver = new EdgeDriver();
	break;
	case "firefox":
		logger.info("Opening firefox browser");
		driver = new FirefoxDriver();
		break;
	default:
		System.out.println("Invalid Browser Name...");
		return;
	}
    
//	driver=new ChromeDriver();
	driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
	driver.get(p.getProperty("appURL"));
	driver.manage().window().maximize();
	
}

@AfterClass
public void Teardown()
{
	driver.close();
}


//Random String
public String randomstring() {
 String generatestring = RandomStringUtils.randomAlphabetic(5);
 return generatestring;
}

//Random Number
public String randomnumber() {
 String generatenumber = RandomStringUtils.randomNumeric(10);
 return generatenumber;
}

//Alphanumeric
public String alphanumeric() {
 String generatestring = RandomStringUtils.randomAlphabetic(5);
 String generatenumber = RandomStringUtils.randomNumeric(10);

 return generatestring + "@" + generatenumber;
}

public String CaptureScreen(String tname) {
	String timestamp = new SimpleDateFormat("yyyy.MM.dd.HH.mm.ss").format(new Date());

	TakesScreenshot takescreenshot = (TakesScreenshot) driver;
	File sourcefile = takescreenshot.getScreenshotAs(OutputType.FILE);

	String Targepathtfile = System.getProperty("user.dir") + "\\Screenshots\\" + tname + "_" + timestamp + ".png";
	File Targetfile = new File(Targepathtfile);

	try {

		Targetfile.getParentFile().mkdirs();

		// Copy file using FileUtils (more reliable)
		FileUtils.copyFile(sourcefile, Targetfile);

		System.out.println("Screenshot saved: " + Targepathtfile);
		
	 byte[] screenshotBytes = ((TakesScreenshot) driver).getScreenshotAs(OutputType.BYTES);
         Allure.addAttachment("Failed Screenshot: ",new ByteArrayInputStream(screenshotBytes));
         
	} catch (Exception e) {
		e.printStackTrace();
	}

	return Targepathtfile;
}

}
