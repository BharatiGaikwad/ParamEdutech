package pages;

import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

public class HomePage {
	//saglay web element che getter setter create karachay
	WebDriver driver;
	WebElement pageTitle;
	WebElement SearchBoxText;
	WebElement dropDown;
	WebElement collageImage;
	WebElement maleRadioButton;
	WebElement femaleRadioButton;
	WebElement orageCheckbox;
	WebElement blueCheckbox;
	
	//constructor use kela 
	public HomePage(WebDriver driver)
	{
		this.driver=driver;//instance variable and local variable same asel tr this keyword cha use kela
	}
	
	
	//----------------------------------------------------------------------------------------------------------------
	//pratek web element la hach code create karne
	//webelement pagetital vr right click karun source->genreate getter and setter  vr click kel 
	public WebElement getPageTitle() {
		setPageTitle();//setpagetitle call kel
		return pageTitle;
	}
	public void setPageTitle() {
		this.pageTitle = driver.findElement(By.xpath("//h1[@class='title']"));
	}
	//---------------------------------------------------------------------------------------------------------------
    // webelement SetSearchBox vr right click karun source->genreate getter and setter  vr click kel 
	public WebElement getSearchBoxText() {
		setSearchBoxText();
		return SearchBoxText;
	}

	public void setSearchBoxText() {
		this.SearchBoxText=driver.findElement(By.xpath("//input[@name='q' and @title='search']"));
	}
	//--------------------------------Dropdown getter setter-----------------------------------------------------------------
	public WebElement getDropDown() {
		setDropDown();
		return dropDown;
	}
	public void setDropDown() {
		dropDown = driver.findElement(By.xpath("//select[@id='drop1']"));
	}
    //-----------------------getter setter CollageImage---------------------------------------------------------------------------
	public WebElement getCollageImage() {
		setCollageImage();
		return collageImage;
	}
	public void setCollageImage() {
		this.collageImage = driver.findElement(By.xpath("//img[contains(@src,'college')]"));// src link mhadla ekhad letter ghych jas  college getl
	}
//-------------------------------getter and setter MaleRadioButton---------------------------------------------------------------
	public WebElement getMaleRadioButton() {
		setMaleRadioButton();
		return maleRadioButton;
	}
	public void setMaleRadioButton() {
		this.maleRadioButton = driver.findElement(By.xpath("//input[@id='radio1']"));
	}

//-------------------------getter and setter FemaleRadioButton----------------------------------------------------------------------------
	public WebElement getFemaleRadioButton() {
		setFemaleRadioButton();
		return femaleRadioButton;
	}
	public void setFemaleRadioButton() {
		this.femaleRadioButton =  driver.findElement(By.xpath("//input[@id='radio2']"));;
	}

//---------------------------getter setter OrageCheckbox--------------------------------------------------------------------
	public WebElement getOrageCheckbox() {
		setOrageCheckbox();
		return orageCheckbox;
	}
	public void setOrageCheckbox() {
		this.orageCheckbox =  driver.findElement(By.xpath("//input[@id='checkbox1']"));;;
	}
	//---------------------------getter setter BlueCheckbox--------------------------------------------------------------------

	public WebElement getBlueCheckbox() {
		setBlueCheckbox();
		return blueCheckbox;
	}
	public void setBlueCheckbox() {
		this.blueCheckbox = driver.findElement(By.xpath("//input[@id='checkbox2']"));;;;
	}


	//-------------------------methods--------------------------------------------------------------------------------------
	//varti elemant find karun method create karun je ky kayach te teyt karach eg send key 
	public void SetTextInSearchTextField(String TextToSearch)//pratek search box send key use honaysati string to search patval ahe
	{
	 getSearchBoxText().sendKeys(TextToSearch);
	}
	
	public boolean VerifySearchTextFieldISEnabled () // isEnabled ahe ka nahi asel tr true nasel tr false teysati boolean datatype use kela
	{
		return getSearchBoxText().isEnabled();
		
		
	}

	//--------------get Value Selected  In Dropdown --------------------------------------------------------------------------
	public String getValueSelectedInDropdown()
	{
		Select  select=new Select(getDropDown());
		return select.getFirstSelectedOption().getText();
		
	}
	//-----------------------Table--all data actual----------------------------------------------------------------------------------------------
	public List<String> getTableData() {
		
		ArrayList<String> table =new ArrayList<String>();
		List<WebElement> tableData = driver.findElements(By.xpath("//table[@id='table1']//tr//td"));
		for (WebElement ele:tableData)
		{
			table .add(ele.getText());
		}
		return table;
	}
	//---------------------------------------------------------------------------------------------------------------------------------------
	

}
