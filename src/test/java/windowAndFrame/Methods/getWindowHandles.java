package windowAndFrame.Methods;

/*
 * Scenario:
 *  1. Opens the OrangeHRM login page. (Launches a browser)
 *  2. Clicks the "OrangeHRM, Inc" link, which opens a new window.
 *  3. Retrieves and prints the unique window identifiers (handles) for all open browser windows.
 *  4. Closes the browser.
*/
 
import java.time.Duration;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class getWindowHandles {

	public static void main(String[] args) throws InterruptedException {
		
		WebDriver driver = new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		
		driver.get("https://opensource-demo.orangehrmlive.com/web/index.php/auth/login"); //current browser window
		driver.manage().window().maximize();
		Thread.sleep(3000);          // Pause for 3 seconds (not recommended; better to use explicit wait)
		
		driver.findElement(By.xpath("//a[normalize-space()='OrangeHRM, Inc']")).click(); //open another browser window
		
		Set<String> windowIds=driver.getWindowHandles(); //This retrieves a set of window handles (unique identifiers) for all open browser windows.
		//System.out.println(windowIDs); 
		System.out.println("Window Ids:" +windowIds);
		System.out.println("Total open windows: " + windowIds.size());
		
//------Optional: Print each window ID on a new line for better readability-------------------------
        for (String windowId : windowIds) 
        {
            //System.out.println(windowId);
            System.out.println("Window Ids:" +windowId);
        }
		
        driver.quit();
//---------------------------------------------------------------------------------------------------------
// Different Approaches to Handle Multiple Windows:
//---------------------------------------------------------------------------------------------------------
// Approach-1: Convert Set into List (Useful when dealing with 2 or 3 windows)
// Approach-2: Use a Looping Statement (Best for handling multiple dynamic windows)
// Approach-3: If getWindowHandles() is called when only one window is open, it will return a set with a single ID
//---------------------------------------------------------------------------------------------------------

	}
}


	


