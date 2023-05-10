package testcase;

import static org.testng.Assert.assertFalse;
import static org.testng.Assert.assertTrue;
import java.io.IOException;
import org.openqa.selenium.WebDriver;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import com.param.project.Utility;
import pages.HomePage;

public class VerifyCheckboxesAndRadioButtonByDefaultBehavoure {
	
	
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
	
	   //testcase Verify Checkboxes And RadioButton By Default Behavoure
	  
	   @Test(priority=1,groups= {"e2e"},enabled = true)//enabled = false test case run hot nahi..group run karaych asel testng.xml file group karun run karne
		public void verifyCheckboxesAndRadioButtonBehaviours()
		{
		   
		  //Verify that male and female  radio button are unchecked make sure orage checkbox is checked and blue checkbox is unchecked
		  
		   //male and female  radio button are unchecked ahet check karnaysati
		   assertFalse(homepage.getMaleRadioButton().isSelected());//select ahe ka radio button nahi false return kargha ...assertfalus mhade false condition takavi lagete trach testcase pass hohile
		   assertFalse(homepage.getFemaleRadioButton().isSelected());//select ahe ka radio button nahi false return kargha ...assertfalus mhade false condition takavi lagete trach testcase pass hohile
		  
		   // orage checkbox is checked and blue checkbox is unchecked
		   assertTrue(homepage.getOrageCheckbox().isSelected());//select ahe ka checkbox ahe true return kargha..asserttrue mhade condtion true takavi lagte tarach tastcase pass hohile
	       assertFalse(homepage.getBlueCheckbox().isSelected());////select ahe ka checkbox nahi false return kargha  ..assertfalus mhade false condition takavi lagete trach testcase pass hohile 
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
