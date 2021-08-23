package com.fm.automation;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.concurrent.TimeUnit;

import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;

import com.fm.homePage.fmHomePage;
import org.openqa.selenium.support.ui.Select;

public class AutomateFacilityManager {

	//public void AutomateFM() {
	public static void main(String[] args) throws IOException, InterruptedException {
		System.setProperty("webdriver.gecko.driver","C:\\Users\\Anjum\\eclipse-workspace\\HelloWorld\\src\\testing\\geckodriver.exe");
		
		//Create an object of File class to open xls file
		File file =  new File("C:\\Users\\Anjum\\Desktop\\spa_space.xlsx");
		
		//Create an object of FileInputStream class to read excel file
		FileInputStream inputStream = new FileInputStream(file);
		
		//creating workbook instance that refers to .xls file
		XSSFWorkbook wb=new XSSFWorkbook(inputStream);
		
		// This is a test
		
		//creating a Sheet object
		XSSFSheet sheet=wb.getSheet("spaSpace");
		
		//get all rows in the sheet
		int rowCount=sheet.getLastRowNum()-sheet.getFirstRowNum();
   
		System.out.println(rowCount);
		for(int i=1;i<=rowCount;i++) {
			if (sheet.getRow(i).getCell(0).getStringCellValue() != "") {
				//System.out.println(sheet.getRow(i).getCell(0).getStringCellValue() + '-' + sheet.getRow(i).getCell(1).getStringCellValue());
				System.out.println(sheet.getRow(i).getCell(2).getNumericCellValue());
			}
		}
		for(int i=1; i <= rowCount; i++) {
			WebDriver driver = new FirefoxDriver(); //Creating an object of FirefoxDriver 
		
			driver.manage().window().maximize();
			driver.manage().deleteAllCookies();
			driver.manage().timeouts().pageLoadTimeout(40, TimeUnit.SECONDS);
			driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
			driver.get("https://spaspacedev.azurewebsites.net/spa/main/facility/");
			Thread.sleep(3000);
			fmHomePage homepage = new fmHomePage(driver);
			homepage.clickOnApplyNow(); 
			Thread.sleep(3000);
			
			driver.findElement(By.xpath("//input[@id='FacilityName']")).sendKeys(sheet.getRow(i).getCell(0).getStringCellValue());
			driver.findElement(By.xpath("//input[@id='FacilityCity']")).sendKeys(sheet.getRow(i).getCell(1).getStringCellValue());
			Select fc = new Select(driver.findElement(By.xpath("//select[@id='FacilityState']")));
			fc.selectByIndex((int) sheet.getRow(i).getCell(2).getNumericCellValue());
			
			Thread.sleep(3000);
			//driver.close();
			Actions act = new Actions(driver);
			act.sendKeys(Keys.TAB).build().perform();
			Thread.sleep(3000);
			act.sendKeys(Keys.TAB).build().perform();
			driver.findElement(By.id("email")).sendKeys("HELLO");
			Thread.sleep(3000);
			//act.sendKeys(Keys.RETURN).build().perform();
		} 
		
	}
}
