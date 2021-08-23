
package facilitymanager;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class chromeDriver {
	public static void main(String[] args) {
		System.setProperty("webdriver.chrome.driver","C:\\Users\\Anjum\\eclipse-workspace\\HelloWorld\\BrowserExe\\chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		driver.get("https://spaspacedev.azurewebsites.net/spa/main/facility/"); 
	}
	
}