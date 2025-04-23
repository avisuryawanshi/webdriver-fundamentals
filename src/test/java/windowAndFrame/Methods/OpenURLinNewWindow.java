package windowAndFrame.Methods;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WindowType;
import org.openqa.selenium.chrome.ChromeDriver;

public class OpenURLinNewWindow {

	public static void main(String[] args) {
		
		WebDriver driver=new ChromeDriver();                            //Ctrl+shift+O
		driver.get("https://www.opencart.com/");                        // Open the first URL in the first browser window
		System.out.println("First window title: " + driver.getTitle());
		
		//Selenium 4.x feature: Open a new browser window dynamically.
		
		driver.switchTo().newWindow(WindowType.WINDOW);                 // Open the second URL in the new window
		driver.get("https://www.orangehrm.com/");
		System.out.println("Second window title: " + driver.getTitle());

		//Now, two browser windows are open, and WebDriver is focused on the second window

//---------------------------------------------------------------------------------------------------------
// Example: Open a new window and switch control between windows
//---------------------------------------------------------------------------------------------------------	
		
		/*WebDriver driver = new ChromeDriver();
        driver.get("https://www.google.com");                                    // Open first window
        System.out.println("First window title: " + driver.getTitle());
        
//----- Open a new browser window // Store main window handle before opening a new window------------------
        String mainWindow = driver.getWindowHandle();
        WebDriver newWindow = driver.switchTo().newWindow(WindowType.WINDOW);    // Open a new browser window
        newWindow.get("https://www.selenium.dev");                               // Navigate in new window    
        System.out.println("Second window title: " + newWindow.getTitle());
        
//----- Switch back to the main window ----------------------------------------
        driver.switchTo().window(mainWindow);
        System.out.println("Switched back to main window: " + driver.getTitle());

        driver.quit();
   
//---------------------------------------------------------------------------------------------------------
Example: close only the newly opened window and return to the main window
         Open a new window, perform actions, close it, and return to the main window
//---------------------------------------------------------------------------------------------------------		
		WebDriver driver=new ChromeDriver();
		driver.get("https://www.opencart.com/");           // Open main window
		
		String mainWindow = driver.getWindowHandle();      // Store main window handle
		driver.switchTo().newWindow(WindowType.WINDOW);    // Open new window
		driver.get("https://www.selenium.dev");            // Perform actions in the new window
		
		driver.close();                                    // Close the new window                  
		driver.switchTo().window(mainWindow);              // Switch back to main window
	
//---------------------------------------------------------------------------------------------------------
// Example: Verify if a new window has been successfully opened
//---------------------------------------------------------------------------------------------------------		
		WebDriver driver=new ChromeDriver();
		driver.get("https://www.opencart.com/");                   // Open main window
		
		int initialWindowCount = driver.getWindowHandles().size(); // Count open windows
		driver.switchTo().newWindow(WindowType.WINDOW);            // Open new window
		
		int newWindowCount = driver.getWindowHandles().size();     // Count windows after opening new one
		if (newWindowCount > initialWindowCount) 
		{
		    System.out.println("New window opened successfully.");
		}

		driver.quit();*/
        
	}

}
