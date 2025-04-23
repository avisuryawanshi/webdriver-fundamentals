package windowAndFrame.Methods;

//---------------------------------------------------------------------------------------------------------
//Scenario: Handling multiple browser windows and closing specific ones
//---------------------------------------------------------------------------------------------------------
//1. Open the OrangeHRM login page (Main Window).
//2. Click on the "OrangeHRM, Inc" link to open a new browser window (Child Window).
//3. Retrieve all open window handles using getWindowHandles().
//4. Close all child windows while keeping the main window open.
//5. Switch back to the main window and continue execution.

import java.time.Duration;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class SpecificWindowHandlesClosing {

	public static void main(String[] args) throws InterruptedException {
		
		WebDriver driver = new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		
		driver.get("https://opensource-demo.orangehrmlive.com/web/index.php/auth/login"); //current browser window
		driver.manage().window().maximize();
		Thread.sleep(3000);
		driver.findElement(By.xpath("//a[normalize-space()='OrangeHRM, Inc']")).click(); //open another browser window
		Thread.sleep(3000);
		
//---------------------------------------------------------------------------------------------------------
// Step 1: Store the main window handle
//---------------------------------------------------------------------------------------------------------
		String winId = driver.getWindowHandle();
		Set<String> windowIDs=driver.getWindowHandles(); //This retrieves a set of window handles (unique identifiers) for all open browser windows.
		System.out.println("Total open windows: " + windowIDs.size()); //Total open windows: 2

//---------------------------------------------------------------------------------------------------------
// Step 2: Close all child windows while keeping the main window open
		// Close all child windows and ensure the main window remains open. based on the condition we can close the specific browser window
		// Loop through all window handles and close specific ones
//---------------------------------------------------------------------------------------------------------
		
		for(String windowHandle:windowIDs) 
		{
		    driver.switchTo().window(windowHandle);           // Switch to each window
		    if (!windowHandle.equals(winId))                  // If it's NOT the main window, close it
		    {
		    	System.out.println("Closing child window: " + driver.getTitle());
		    	driver.close();                               // Close child windows
		    }
		}
		
//---------------------------------------------------------------------------------------------------------
// Step 3: Switch back to the main window
//---------------------------------------------------------------------------------------------------------		
		
		driver.switchTo().window(winId);                       // Switch back to main window
		
		// Perform any additional actions in the main window
        System.out.println("Back to main window: " + driver.getTitle());  //Back to main window: OrangeHRM

        // Close the driver at the end
        //driver.quit();
	}
}
//------------------------------------------------------------------------------------------------------------------------------
/*
 *  for (String handle : windowIDs) 
		 {
	            if (!handle.equals(winId)) 
	            {
	                driver.switchTo().window(handle);
	                driver.close(); // Close the child window
	            }
		 }
 */
 
