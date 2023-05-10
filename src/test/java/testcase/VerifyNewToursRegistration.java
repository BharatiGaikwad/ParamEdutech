package testcase;

import java.io.IOException;
import java.util.List;

import org.openqa.selenium.WebDriver;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.param.project.Utility;
import pages.NewToursHomePage;
import pages.RegistrationPage;

public class VerifyNewToursRegistration {
	
	WebDriver driver;
	
	NewToursHomePage newToursHomePage;//NewToursHomePage page hit import kel
	RegistrationPage registrationPage;// RegistrationPage page import kel 
	
	 //---------------------------------------------------------------------------
	   @BeforeMethod
	   
	   public void setup() throws IOException
	   {
		   driver =Utility.getDriver(); //utility.java  main/java mhade save ahe chreome driver access kela
		   driver.get(Utility.getProperty("url"));//url ha data.properties mhanun access kela 
		   driver.manage().window().maximize();
		   newToursHomePage=new NewToursHomePage(driver);//NewToursHomePage object create kela hit home page code call karta yeto
		   registrationPage=new RegistrationPage(driver);
	   }
     //-----------------------testcase click On Registration Link------------------------------------------------
	  //dataProvider hit call kela click kelavr dataProvider method javal jahile to data catch karel
	   @Test(dataProvider = "registration")
		public void VerifyRegistartion(String firstName, String lastName, String phone, String email) {
			newToursHomePage.clickOnRegistrationLink();
			registrationPage.getFirstNameTextField().sendKeys(firstName);
			registrationPage.getLastNameTextField().sendKeys(lastName);
			registrationPage.getPhoneTextField().sendKeys(phone);
			registrationPage.getEmailTextField().sendKeys(email);
		}

	   //------------------------------------------------------------------------
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
	   
	  //----------1--------click On Registration Link- jalvr to data filp karcaha to data provider karta yrto----------------------------------------------------------------------------- 
	  
	   //1 Set array dim dirct filp karcha
//   @DataProvider(name ="registration")
//   public String[][] registrationDataProvider()
//	   {
//	   		   String[][] registration= { {"Bharati","Chopade","9518656877","bharati@gmail.com"} };
//	   
//		   return registration;
//		   
//		   
//	   }
//	
	   
	   //------or----2--------click On Registration Link jalvr-excel file varch   data filp karcaha to data provider karta yrto----------------------------------------------------------------------------- 
	  
	   
	   
	   @DataProvider(name = "registration")
		public String[][] registrationDataProvider() throws IOException {
			List<String> data = Utility.readExcel();//utility mhadli readExcel hit call kel
			String[][] registration1 = new String[1][4];
			for (int i = 0; i < data.size(); i++) {
				registration1[0][i] = data.get(i);
			}
			return registration1;
		}
}
