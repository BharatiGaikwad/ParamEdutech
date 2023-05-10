package com.param.project;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Properties;

import org.apache.commons.io.FileUtils;
import org.apache.poi.hssf.usermodel.HSSFRow;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

public class Utility {

	
	public static WebDriver getDriver()
	{
		System.getProperty("WebDriver.Chrome.Driver", "src/test/resources/chromedriver.exe");
		WebDriver driver =new ChromeDriver();
		return driver;
		
	}
	public static String getProperty(String key) throws IOException
	{
		File file =new File("src/test/resources/data.properties");
		
		// file read karne he harddisk se utakhe RAM me lane he file read karnaysati FileInputStream use kel connect
		
			FileInputStream fileInputStream =new FileInputStream(file);
			Properties properties =new Properties();
			properties.load(fileInputStream);	
			return properties.getProperty(key);
		
	}
	//----------------------------Screen Shot Code-------------------------------------------------------------------------------------
	
		// Screen shot sarkha code lihaychi gharj nahi tey ekhda code lihila tari chalto to code jite screenshot ghaych tite call kayacha
		
		public static void getScreenshot(WebDriver driver,String screenshotName) throws IOException
		{
		 TakesScreenshot takesScreenshot=(TakesScreenshot)driver;
		 File file= takesScreenshot.getScreenshotAs(OutputType.FILE);
		 FileUtils.copyFile(file, new File("src/test/resources/ScreenShot" + screenshotName +".png"));
		}
		
		
		//-------------VerifyNewToursRegistration .java-------excel file mhadala data  web vr registration karaych ahe teych code---------------------------------------------------------------------------------------------------------
		

		public static List<String> readExcel() throws IOException {
			File file = new File("src/test/resources/registration.xls");
			FileInputStream fileInputStream = new FileInputStream(file);

			List<String> userRegistrationDetails = new ArrayList<String>();

			// reading .xls file
			HSSFWorkbook hssfWorkbook = new HSSFWorkbook(fileInputStream);

			HSSFSheet sheet = hssfWorkbook.getSheetAt(0);

			int lastRowNumer = sheet.getLastRowNum();

			int lastCellNumber = 0;

			for (int i = 1; i <= lastRowNumer; i++) {
				HSSFRow row = sheet.getRow(i);
				lastCellNumber = row.getLastCellNum();
				for (int j = 0; j < lastCellNumber; j++) {
					userRegistrationDetails.add(row.getCell(j).getStringCellValue());
				}
			}
			return userRegistrationDetails;
		}
		
		//------------------------------------------------------------------------------------------------------------------------------
		//Utility apke dropdown ki value select karne me help krega
		//kup sare web vr dropdown ho sakte he usake liye utility method likhi he
		//konta pan dropdown asel uskha web element/locator  bhej dho
		//konsabhi dropdown hoo he method hiddel karegha
		
		public static void selectValueFromDropdown(WebElement dropDown, String valueToSelect) {
			Select select = new Select(dropDown);
			select.selectByVisibleText(valueToSelect);
		}
	}
		//------------------------------------------------------------------------------------------------------------------------------

