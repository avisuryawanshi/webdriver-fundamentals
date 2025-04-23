package windowAndFrame.Methods;

//---------------------------------------------------------------------------------------------------------
//Scenario: Handling a single open browser window
//---------------------------------------------------------------------------------------------------------
//1. Launch the browser and navigate to the OrangeHRM login page.
//2. Retrieve all open window handles using getWindowHandles().
//3. Verify if only one window (main window) is open and print the window handle.
//4. Close the browser.

import java.util.Set;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class SingleWindowHandler {

	public static void main(String[] args) throws InterruptedException {

//-----------------------------------------------------------------------------------------------------------------		
//Approach-3 if you call getWindowHandles() when only one window is open
//getWindowHandles() will return a Set<String> containing only one window handle (the main window).
//-----------------------------------------------------------------------------------------------------------------
		
		WebDriver driver = new ChromeDriver();
		driver.get("https://opensource-demo.orangehrmlive.com/web/index.php/auth/login"); //current browser window
		driver.manage().window().maximize();
		Thread.sleep(3000);
		
//---------------------------------------------------------------------------------------------------------
// Handling a Single Window Scenario
//---------------------------------------------------------------------------------------------------------
		
        Set<String> windowHandles = driver.getWindowHandles();                 // Retrieve all window handles (in this case, only one window should be present)
        System.out.println("Number of open windows: " + windowHandles.size()); // Expected output: 1
        
        if (windowHandles.size() == 1)                                         // Check if only one window (main window) is open
        {
            System.out.println("Only one window (Main Window) is open: " + windowHandles.iterator().next());
        }
        
        driver.quit();

	}

}

		
    
		
		
		
		
      

    
