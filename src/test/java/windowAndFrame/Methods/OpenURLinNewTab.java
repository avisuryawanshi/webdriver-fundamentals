package windowAndFrame.Methods;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WindowType;
import org.openqa.selenium.chrome.ChromeDriver;

public class OpenURLinNewTab {

	public static void main(String[] args) {
		
		    WebDriver driver=new ChromeDriver();                        // Ctrl+Shift+O to import necessary classes
			driver.get("https://www.opencart.com/");                    // Open the first URL in the first tab
			System.out.println("First tab title: " + driver.getTitle());
			 
			// Selenium 4.x feature: Open a new tab dynamically
			driver.switchTo().newWindow(WindowType.TAB);                //opens new tab url // Opens a new tab and switches to it
			driver.get("https://www.orangehrm.com/");                   // Open the second URL in the new tab
			System.out.println("Second tab title: " + driver.getTitle());
			
			// Now, both tabs are open, and the WebDriver is focused on the second tab

//---------------------------------------------------------------------------------------------------------
// Example: Open a new tab, perform actions, and switch back to the main tab
//---------------------------------------------------------------------------------------------------------
			
			/*WebDriver driver = new ChromeDriver();
		     driver.get("https://www.google.com");           // Open first tab
		     System.out.println("First tab title: " + driver.getTitle());
		
		     // Open a new tab and switch to it
		     driver.switchTo().newWindow(WindowType.TAB);
		     driver.get("https://www.selenium.dev");         // Navigate to Selenium website
		     System.out.println("Second tab title: " + driver.getTitle());
		        
		     driver.quit();                                  // Close all tabs and quit browser
		    		
//---------------------------------------------------------------------------------------------------------
// Example: Store the main window handle, open a new tab, perform actions, close new tab, switch back to the main tab.
//---------------------------------------------------------------------------------------------------------			
			WebDriver driver=new ChromeDriver();            // Initialize WebDriver
			driver.get("https://www.opencart.com/");        // Open main tab
			
			String mainTab = driver.getWindowHandle();      // Store main tab handle
			driver.switchTo().newWindow(WindowType.TAB);    // Open new tab
			
			driver.get("https://www.selenium.dev");         // Perform actions in the new tab
			driver.close();                                 // Close the new tab
			driver.switchTo().window(mainTab);              // Switch back to main tab

//---------------------------------------------------------------------------------------------------------
// Example: Verify if a new tab has been successfully opened
//---------------------------------------------------------------------------------------------------------
			
			WebDriver driver=new ChromeDriver(); //Ctrl+shift+O
			driver.get("https://www.opencart.com/");                // Open main tab
			
			int initialTabCount = driver.getWindowHandles().size(); // Get initial number of open tabs

			driver.switchTo().newWindow(WindowType.TAB);            // Open new tab
 
			int newTabCount = driver.getWindowHandles().size();     // Get updated tab count

			if (newTabCount > initialTabCount) {
			    System.out.println("New tab opened successfully.");
			}
			driver.quit();*/                                        // Close all tabs and quit browser
			
	}

}
