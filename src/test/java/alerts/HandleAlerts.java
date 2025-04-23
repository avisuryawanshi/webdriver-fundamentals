package alerts;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

/**
 * This class demonstrates handling different types of JavaScript alerts in Selenium WebDriver.
 * It covers:
 * 1. Accepting a normal alert (OK button)
 * 2. Retrieving alert text using getText()
 * 3. Handling confirmation alerts (OK and Cancel buttons)
 * 4. Entering text into a prompt alert (sendKeys())
 */

public class HandleAlerts {

	public static void main(String[] args) throws InterruptedException {
		
		WebDriver driver = new ChromeDriver(); //ctrl+shift+o
		driver.get("https://the-internet.herokuapp.com/javascript_alerts"); 
		driver.manage().window().maximize();
		System.out.println("Navigated to the JavaScript Alerts page.");

// ==================================================================================================================================
// 1) Handling a Normal Alert with OK button (Accepting an Alert)
// ==================================================================================================================================
		
		driver.findElement(By.xpath("//button[normalize-space()='Click for JS Alert']")).click();
		Thread.sleep(3000);
		
		//Switch to the alert and accept it (click "OK")
		driver.switchTo().alert().accept();  //use for single command operation
		System.out.println("Alert accepted successfully.");

// ===================================================================================================================================
// 2) Retrieving Alert Text using getText()
// ===================================================================================================================================
		
		/*driver.findElement(By.xpath("//button[normalize-space()='Click for JS Alert']")).click();
		Thread.sleep(3000);
		
		String alertMessage=driver.switchTo().alert().getText();  //use for multiple operations. Create a variable to store that alert window
		//System.out.println(alertMessage.getText());             // Capture the alert text//I am a JS Alert 
		System.out.println("Alert says: " + alertMessage);        //Switch to the alert and retrieve its text
		driver.switchTo().alert().accept();                       //Accept the alert after capturing text */

// ===================================================================================================================================
// 3) Handling a Confirmation Alert (Accept & Dismiss Options)
//    (Dismissing an Alert) Confirmation Alert- OK and Cancel button
// ===================================================================================================================================
  
		/*driver.findElement(By.xpath("//button[normalize-space()='Click for JS Confirm']")).click();
		Thread.sleep(3000);
		
		//driver.switchTo().alert().accept();   // close alert using accept button
		driver.switchTo().alert().dismiss();    // Switch to the alert and dismiss it (click "Cancel")
		System.out.println("Confirmation alert dismissed successfully.");

// ===================================================================================================================================
 // 4) Handling a Prompt Alert (Entering Text)
 //    Prompt alert- input box ----Entering Text in a Prompt Alert (sendKeys())
// ===================================================================================================================================

		driver.findElement(By.xpath("//button[normalize-space()='Click for JS Prompt']")).click();
		Thread.sleep(3000);
		
		Alert promptAlert=driver.switchTo().alert();                       // Switch to the alert
		promptAlert.sendKeys("Selenium Automation");                       // Enter text into the prompt alert
		promptAlert.accept();                                              // Accept the alert after entering text
		System.out.println("Prompt alert accepted after entering text.");*/
		
		driver.quit();                                                     // Close the browser session
	}

}
