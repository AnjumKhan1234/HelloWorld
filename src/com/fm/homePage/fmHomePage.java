package com.fm.homePage;

import org.openqa.selenium.By;
import org.openqa.selenium.Point;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;

public class fmHomePage {
	WebDriver driver;
	
	By ApplyNow = By.xpath("//button[normalize-space()='Apply Now']");
	
	public fmHomePage(WebDriver driver) {
		this.driver = driver;
	}
	
	public void clickOnApplyNow() {
		//driver.findElement(ApplyNow).click();
		WebElement link = driver.findElement(ApplyNow);
		Point pt = link.getLocation();
		int NumberX = pt.getX();
		int NumberY = pt.getY();
		System.out.println(NumberX);
		System.out.println(NumberY);
		Actions builder = new Actions(driver);        
		builder.moveByOffset(NumberX+10, NumberY+5).click().build().perform();
	}
}
