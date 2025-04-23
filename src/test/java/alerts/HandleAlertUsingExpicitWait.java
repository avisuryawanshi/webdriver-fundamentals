package alerts;

import java.time.Duration;


import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
/**
 * This class demonstrates handling JavaScript alerts using Explicit Wait in Selenium.
 * Instead of using the traditional switchTo().alert() method, we wait for the alert
 * to be present before interacting with it.
 */

public class HandleAlertUsingExpicitWait {

	public static void main(String[] args) throws InterruptedException {
		
		//Without using the switching command, we can handle it by using "explicit wait" 
		
		WebDriver driver = new ChromeDriver(); //ctrl+shift+o
		WebDriverWait wait=new WebDriverWait(driver,Duration.ofSeconds(10));    // Declare an Explicit Wait with a timeout of 10 seconds
		
		driver.get("https://the-internet.herokuapp.com/javascript_alerts"); 
		System.out.println("Navigating to the JavaScript Alerts page.");
		driver.manage().window().maximize();
		
//----- Locate and click the button that triggers a simple JavaScript alert -----------------------------------------------
		driver.findElement(By.xpath("//button[normalize-space()='Click for JS Alert']")).click();
		Thread.sleep(3000);

//--------------------------------------------------------------------------------------------------------------------------
// Handling the alert using Explicit Wait
//--------------------------------------------------------------------------------------------------------------------------
		Alert myalert=wait.until(ExpectedConditions.alertIsPresent()); //capture alert // Wait until the alert is present and switch to it
		System.out.println(myalert.getText());                         // Expected output: "I am a JS Alert"
		myalert.accept();                                              // Accept (click OK on) the alert
		
		System.out.println("You successfully clicked an alert");       // Print confirmation message
		//System.out.println("Alert handled successfully.");           

		driver.quit();                                                 // Close the browser session
	}

}
