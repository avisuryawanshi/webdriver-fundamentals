package frames;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class UsingExplicitWaits {

	public static void main(String[] args) {
		
		WebDriver driver=new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

		driver.get("https://ui.vision/demo/webtest/frames/");
		driver.manage().window().maximize();

		/*//Traditional Approach: Using switchTo()
		WebElement frame1=driver.findElement(By.xpath("//frame[@src='frame_1.html']")); // Locate the iframe
		driver.switchTo().frame(frame1);      // Switch to the iframe //passed frame as a WebElement 
		driver.findElement(By.xpath("//input[@name='mytext1']")).sendKeys("testing"); // Interact with an element inside the iframe
		driver.switchTo().defaultContent(); //Switch Back to the Main Page*/
		
		//Alternative Approach: Using Explicit Waits //Handling iframes Without switchTo()
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10)); // Declare Explicit Wait
		wait.until(ExpectedConditions.frameToBeAvailableAndSwitchToIt(By.xpath("//frame[@src='frame_1.html']")));// Wait for the iframe to be available and automatically switch to it
		driver.findElement(By.xpath("//input[@name='mytext1']")).sendKeys("Testing"); // Interact with an element inside the iframe
		driver.switchTo().defaultContent(); 	// Return to the main page

	}

}
