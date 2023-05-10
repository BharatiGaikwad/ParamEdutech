package testcase;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertTrue;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.openqa.selenium.WebDriver;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.param.project.Utility;

import pages.HomePage;

public class VerifyOmayoHomePage {
	
	//private static final String valueToSelect = null;
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
	  
	   @Test(priority=1,groups= {"sanity"},enabled = true)//enabled = false test case run hot nahi..group run karaych asel testng.xml file group karun run karne
		public void verifyOmayoPage()
		{
		   // verify user is on omayo home page
		  assertEquals(homepage.getPageTitle().getText(), "omayo (QAFox.com)");//ha result true ALA tr pass reult hohile
		  
		// verify that value is selected fome dropdown
		  String value="doc 1";//verfication sati phahije paret store keli
		  Utility.selectValueFromDropdown(homepage.getDropDown(), value);//dropdown mhadli value select keli
		  assertEquals(homepage.getValueSelectedInDropdown(), value);//verfication 
		  
		  //make sure image is displayed at left upper side
		  assertTrue(homepage.getCollageImage().isDisplayed());
		  
		  // verify table content ...expected 
		  List<String> expectedTableData=new ArrayList<String>();
		  expectedTableData =Arrays.asList("Kishore","22","Delhi","Manish","25","Pune","Praveen","29","Bangalore","Dheepthi","31","Mumbai");
		  assertTrue(homepage.getTableData().equals(expectedTableData));
		  
		}
	 
	   //------------------------------------------------------------------------------------------
	   
	   
	   
	   
	   
	   
	   //--------------------------------------------------------------------------------------------------------------------------
	   //test case jar fail jali tr teycha screen shot create hoto ..ITestResult current result display karto
	   // after method mahde use karyacha
	   @AfterMethod
	   public void tearDown(ITestResult result) throws IOException  // browser quit kel test case jalvr
	   {
		   //Fail ala trach screen shot getla pahije teysati ha code
		   if(result.getStatus()==ITestResult.FAILURE)
		   {
			  Utility.getScreenshot(driver, result.getName());
			  
		   }
		   driver.quit();
		   
	   }

}
