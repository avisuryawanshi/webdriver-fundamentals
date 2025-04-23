package chromeOptions.features;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

/*
 * Scenario:
	This script demonstrates how to use ChromeOptions to customize the Chrome browser's behavior for Selenium automation.
	It includes:
	✅ Disabling automation message (removes "Chrome is being controlled by automated test software").
	✅ Disabling browser notifications (prevents pop-ups from interfering with execution).
	✅ Starting the browser in maximized mode (ensures all elements are visible).
	✅ Using Incognito mode (helps with session-based testing).
	✅ Disabling GPU acceleration (useful in headless mode).
	✅ Running the browser in headless mode (for faster execution without UI).
 */

public class ChromeOptionsExample {

	public static void main(String[] args) {

// =========================================================================================================
// Scenario: Launch Chrome browser with multiple ChromeOptions settings for optimized automation execution
// =========================================================================================================		
		
		// Create ChromeOptions object 
        ChromeOptions options = new ChromeOptions();

// 1. Remove "Chrome is being controlled by automated test software" message
// --------------------------------------------------------------------------------
        options.setExperimentalOption("excludeSwitches", new String[]{"enable-automation"});
        System.out.println("Automation message disabled.");

// 2. Disable browser notifications (prevents pop-ups during execution)
// --------------------------------------------------------------------------------
        options.addArguments("--disable-notifications");
        System.out.println("Browser notifications disabled.");

// 3. Start browser maximized (ensures all elements are properly visible)
// --------------------------------------------------------------------------------
        options.addArguments("--start-maximized");
        System.out.println("Browser will launch in maximized mode.");
      
// 4. Run browser in Incognito mode (avoids session data interference)
// --------------------------------------------------------------------------------
        options.addArguments("--incognito");
        System.out.println("Incognito mode enabled.");

// 5. Disable GPU hardware acceleration (recommended for stability in headless mode)
// --------------------------------------------------------------------------------
        options.addArguments("--disable-gpu");
        System.out.println("GPU acceleration disabled.");

// 6. Run Chrome in headless mode (browser will execute in the background)
// --------------------------------------------------------------------------------
        options.addArguments("--headless=new");
        System.out.println("Headless mode enabled. Browser will run in the background.");

    	
        // Initialize WebDriver with the configured ChromeOptions 
       
        WebDriver driver = new ChromeDriver(options);

        // Open a website
        driver.get("https://www.google.com");

        // Print the page title
        //System.out.println("Page Title: " + driver.getTitle());
        
        // Get and print the page title ---------------------------------------------------------------
        String pageTitle = driver.getTitle();
        System.out.println("Page Title Retrieved: " + pageTitle);

        // ---- Step 5: Validate if the title contains "Google" ----------------------------------------------------
        if (pageTitle.contains("Google")) 
        {
            System.out.println("Test Passed: Page title contains 'Google'.");
        } 
        else 
        {
            System.out.println("Test Failed: Page title does not contain 'Google'.");
        }

        // Close the browser
        driver.quit();

	}

}
