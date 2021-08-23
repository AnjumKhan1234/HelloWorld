package facilitymanager;
import java.awt.AWTException;
import java.awt.Robot;
import java.util.concurrent.TimeUnit;
import org.openqa.selenium.By;
import org.openqa.selenium.Point;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;

public class Firefox_Example{
	public static void main(String[] args) throws InterruptedException {
		// RK Te
		System.setProperty("webdriver.gecko.driver","C:\\Users\\Anjum\\eclipse-workspace\\HelloWorld\\src\\testing\\geckodriver.exe");
		WebDriver driver = new FirefoxDriver(); //Creating an object of FirefoxDriver
		driver.manage().window().maximize();
		driver.manage().deleteAllCookies();
		driver.manage().timeouts().pageLoadTimeout(40, TimeUnit.SECONDS);
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		driver.get("https://spaspacedev.azurewebsites.net/spa/main/facility/");
		
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		
		Thread.sleep(2000);
		WebElement link = driver.findElement(By.xpath("//button[normalize-space()='Apply Now']"));
		
		//WebElement link = driver.findElement(By.xpath("//div[@fxlayoutalign='center']"));
		//driver.findElement(By.cssSelector("waves-light apply-now-btn btn-primary btn")).click();
		
		driver.findElement(By.linkText("Apply Now")).click();
		/* Point pt = link.getLocation();
		int NumberX = pt.getX();
		int NumberY = pt.getY();
		System.out.println(NumberX);
		System.out.println(NumberY);
		Actions builder = new Actions(driver);        
		
		
		Robot robot = null;
		try {
			robot = new Robot();
		} catch (AWTException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		robot.mouseMove(NumberX+650,NumberY+110); 
		
		builder.moveByOffset(NumberX+10, NumberY+5).click().build().perform(); */
		
		/* driver.findElement(By.name("q")).sendKeys("Browserstack Guide"); //name locator for text box
		WebElement searchbutton = driver.findElement(By.name("btnK"));//name locator for google search
		searchbutton.click();
		driver.quit(); */
	}
}
