package chromeOptions.features;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

/*
 * Scenario:
	This script demonstrates how to run Selenium WebDriver tests in Chrome's Incognito mode using ChromeOptions.
	
	Why Incognito Mode?
	Incognito mode does not store cache, cookies, or session data, making it ideal for testing login sessions 
	and user flows without previous data interference.
	It ensures a clean test environment for every execution.	
 */
public class RunTestsIncognitoMode {

	public static void main(String[] args) {	

// =====================================================================================================
// Scenario: Launch Chrome browser in Incognito mode and validate the page title of TutorialsNinja demo
// =====================================================================================================
		
// ---- Step 1: Create ChromeOptions object -----------------------------------------------------------
        ChromeOptions options = new ChromeOptions();

        // Enable Incognito Mode (Browser will not save cache, cookies, or session data)
        options.addArguments("--incognito");
        System.out.println("Incognito mode enabled.");

// ---- Step 2: Initialize WebDriver with configured ChromeOptions -------------------------------------
        WebDriver driver = new ChromeDriver(options);
        System.out.println("Chrome browser launched in Incognito mode.");
        driver.manage().window().maximize();
        driver.get("https://tutorialsninja.com/demo/");
       
// ---- Step 3: Retrieve and print the page title -----------------------------------------------------
        
        String actualTitle = driver.getTitle();
        System.out.println("Page Title Retrieved: " + actualTitle);

	        if(actualTitle.equals("Your Store"))
			{
			    System.out.println("Test Passed");
			}
			else
			{
				System.out.println("Test Failed") ;	
			}	
	        
        driver.quit();
    }

}
