package AutomateInternetSpeed;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class InternetSpeedTest {

	public static void main(String[] args) throws InterruptedException {
		
// Instead of Speedtest.net, you can also use Fast.com (Netflix’s speed test site):
// Fast.com is simpler but does not provide upload speed.
		
// ---- Initialize WebDriver and open Fast.com (Netflix’s speed test site)
		WebDriver driver = new ChromeDriver();
    	driver.get("https://fast.com/");
    	driver.manage().window().maximize();
    	Thread.sleep(30000);  // Wait for speed test to complete
    	
// ---- Locate and fetch the speed test result -------------------------------------------------------------
    	
    	// WebElement speed = driver.findElement(By.xpath("//div[@class='speed-results-container']/div[1]"));
    	WebElement speed = driver.findElement(By.xpath("//div[@id='speed-value']"));
    	
    	System.out.println("🚀 Internet Speed: " + speed.getText() + " Mbps");
    
    	driver.quit();
    
	}

}
