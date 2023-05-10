package testcase;

import static org.testng.Assert.assertEquals;

import java.io.IOException;

import org.openqa.selenium.WebDriver;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.param.project.Utility;

import pages.HomePage;

public class VerifyApplicationPageTitel {
   WebDriver driver;
   HomePage homepage; 
   
   @BeforeMethod
   
   public void setup() throws IOException
   {
	   driver =Utility.getDriver(); //utility.java  main/java mhade save ahe chreome driver access kela
	   driver.get(Utility.getProperty("url"));//url ha data.properties mhanun access kela 
	   driver.manage().window().maximize();
	   homepage=new HomePage(driver);//Homepage object create kela hit home page code call karta yeto
   }
	//------------------------------------------------------------------------------------------------------------------------
   //first test case  page titel get karun actual result ..expected tital ky hot te check kel
   @Test(priority=1,groups= {"sanity"},enabled = false)//enabled = false test case run hot nahi..group run karaych asel testng.xml file group karun run karne
	public void verifyPageTitle()
	{
	  assertEquals(homepage.getPageTitle().getText(), "omayo (QAFox.com)");//ha result true ALA tr pass reult hohile
	}
   //--------------------------------------------------------------------------------------------------------------------------
   //test case jar fail jali tr teycha screen shot create hoto ..ITestResult current result display karto
   // after method mahde use karyacha
   @AfterMethod
   public void tearDown(ITestResult result) throws IOException  // browser quit kel test case jalvr
   {
	   //fali ala trach screen shot getla pahije teysati ha code
	   if(result.getStatus()==ITestResult.FAILURE)
	   {
		  Utility.getScreenshot(driver, result.getName());
		  
	   }
	   driver.quit();
	   
   }
}
