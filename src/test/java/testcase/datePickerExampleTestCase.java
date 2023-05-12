package testcase;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.Test;

import com.param.project.Utility;

public class datePickerExampleTestCase {
	WebDriver driver;
	
	@Test
	public void Setup()
	{
		driver=Utility.getDriver();
		driver.get("https://demoqa.com/automation-practice-form");
		driver.manage().window().minimize();
		Utility.selectDateFromDatePicker(driver, "June","2023","15");
	}
	
	@AfterMethod
	public void tearDown()
	{
		driver.quit();
	}
	

}
