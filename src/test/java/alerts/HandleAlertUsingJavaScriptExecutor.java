package alerts;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.UnhandledAlertException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

/*Sometimes, if the alert isn't handled correctly, we might get an error. 
To prevent this, we can wrap our JavaScriptExecutor code in a 'try-catch' block. 
This is like saying, 'Try to close the alert, and if you get an error, just ignore it and move on'.*/

public class HandleAlertUsingJavaScriptExecutor {

	public static void main(String[] args) throws InterruptedException {
		
		WebDriver driver = new ChromeDriver(); //ctrl+shift+o
		driver.get("https://testautomationpractice.blogspot.com/"); 
		driver.manage().window().maximize();
		
		driver.findElement(By.xpath("//button[@id='alertBtn']")).click();
		Thread.sleep(3000);     // Add delay to observe the alert

//-------------------------------------------------------------------------------------------------------------------	
// Handling the alert using JavaScriptExecutor 
//-------------------------------------------------------------------------------------------------------------------		
		try 
		{
		JavascriptExecutor js=(JavascriptExecutor)driver;                 // Create an instance of JavaScriptExecutor
		js.executeScript("window.alert = function() {};");                // Override the window.alert function to suppress alerts
		} 
		catch (UnhandledAlertException e) 
		{
		//---- Catch any unhandled alert exception and continue execution -----------------------------------
		//System.out.println("An unhandled alert was encountered. Please handle the alert before proceeding.");
		}
		
		driver.quit();

	}

}
