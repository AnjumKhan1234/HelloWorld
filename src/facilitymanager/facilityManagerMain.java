package facilitymanager;


import java.awt.AWTException;
import java.awt.Robot;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.Point;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

//import testing.chromeDriver;

public class facilityManagerMain {
		
	
	public static void main(String[] args) throws InterruptedException  {
		
		System.setProperty("webdriver.chrome.driver","C:\\Users\\Anjum\\eclipse-workspace\\HelloWorld\\BrowserExe\\chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		driver.get("https://spaspacedev.azurewebsites.net/spa/main/facility/"); 
		
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		
		Thread.sleep(2000);
		//driver.findElement(By.xpath("/html/body/app-root/app-main/app-facility-pitch/div[1]/div/div[2]/div[2]/div[2]/div[2]/button")).click();
		//driver.navigate().to("https://spaspacedev.azurewebsites.net/spa/main");
		WebElement link = driver.findElement(By.xpath("//button[normalize-space()='Apply Now']"));
		
		//driver.findElement(By.cssSelector("waves-light apply-now-btn btn-primary btn")).click();
		
		//driver.findElement(By.linkText("Apply Now")).click();
		Point pt = link.getLocation();
		int NumberX = pt.getX();
		int NumberY = pt.getY();
		System.out.println(NumberX);
		System.out.println(NumberY);
		Actions builder = new Actions(driver);        
		builder.moveByOffset(NumberX+5, NumberY+5).click().build().perform();
		
		Robot robot = null;
		try {
			robot = new Robot();
		} catch (AWTException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		robot.mouseMove(NumberX,NumberY);
		  
		//readFile rf = new readFile();
		//rf.msg();
		//System.out.println(rf.fileName);
		//Thread.sleep(1000);

	}

}
