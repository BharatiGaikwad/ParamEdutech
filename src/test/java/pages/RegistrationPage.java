package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class RegistrationPage {
	
	WebDriver driver;
	WebElement firstNameTextField;
	WebElement lastNameTextField;
	WebElement phoneTextField;
	WebElement emailTextField;
	
	//constructor use kela 
	public RegistrationPage(WebDriver driver)
	{
		this.driver=driver;//instance variable and local variable same asel tr this keyword cha use kela
	}
//-----------------------getter and setter FirstNameTextFild------------------------------------------------------------------------------------------------------------
	public WebElement getFirstNameTextField() {
		setFirstNameTextField();
		return firstNameTextField;
	}

	public void setFirstNameTextField() {
		this.firstNameTextField = driver.findElement(By.xpath("//input[@name='firstName']"));
	}
//-----------------------getter and setter  LatsNameTextFild-----------------------------------------------------------------------------------------------
	public WebElement getLastNameTextField() {
		setLastNameTextField();
		return lastNameTextField;
	}

	public void setLastNameTextField() {
		this.lastNameTextField = driver.findElement(By.xpath("//input[@name='lastName']"));
	}

//--------------------------getter and setter PhoneNoTextFild---------------------------------------------------------------------------------------------
	public WebElement getPhoneTextField() {
		setPhoneTextField();
		return phoneTextField;
	}

	public void setPhoneTextField() {
		this.phoneTextField = driver.findElement(By.xpath("//input[@name='phone']"));
	}
//----------------------------getter and setter EmailTextFild-------------------------------------------------------------------------------------
	public WebElement getEmailTextField() {
		setEmailTextField();
		return emailTextField;
	}

	public void setEmailTextField() {
		this.emailTextField = driver.findElement(By.xpath("//input[@name='userName']"));
	}

}
