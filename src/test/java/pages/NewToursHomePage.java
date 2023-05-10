package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class NewToursHomePage {

	
	WebDriver driver;
	WebElement registrationlinkClick;
	
	//constructor use kela 
		public NewToursHomePage(WebDriver driver)
		{
			this.driver=driver;//instance variable and local variable same asel tr this keyword cha use kela
		}
//-------webelement registrationlinkClick --getter setter--------------------------------------------
		public WebElement getRegistrationlinkClick() 
		{
			setRegistrationlinkClick();
			return registrationlinkClick;
		}

		public void setRegistrationlinkClick() 
		{
			this.registrationlinkClick = driver.findElement(By.xpath("//a[text()='REGISTER']"));
		}
//-------------------registrationlinkClick METHOD create keli------------------------------------------------
		public void clickOnRegistrationLink()
		{
			getRegistrationlinkClick().click();
		}
		
}
