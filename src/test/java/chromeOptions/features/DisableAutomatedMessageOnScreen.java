package chromeOptions.features;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

/*
 * Scenario:
		We need to disable the "Chrome is being controlled by automated test software" message that appears 
		when running Selenium automation tests in Chrome browser. This message is not harmful but can be distracting during UI automation testing.

	Solution:
	We use ChromeOptions and set the experimental option excludeSwitches to "enable-automation", which removes the automation message from the browser.		
 */
		
public class DisableAutomatedMessageOnScreen {

	public static void main(String[] args) {
			
// ============================================================================================================
// Scenario: Disable the "Chrome is being controlled by automated test software" message
// ============================================================================================================	
		
// Step 1: Create ChromeOptions object --------------------------------
		ChromeOptions options=new ChromeOptions();           
		
// Step 2: Set experimental option to remove the automation message ---
		options.setExperimentalOption("excludeSwitches", new String[] {"enable-automation"}); 
		
// Step 3: Initialize WebDriver with ChromeOptions --------------------
		WebDriver driver=new ChromeDriver(options); // Pass options to the ChromeDriver
		driver.manage().window().maximize();
		driver.get("https://tutorialsninja.com/demo/");
				
// Step 4: Get and print the page title -------------------------------
		String actualTitle=driver.getTitle();
	  	System.out.println("Page Title Retrieved: " + actualTitle);
			
			if(actualTitle.equals("Your Store"))
			{
			    System.out.println("Test Passed: Page title matches expected title.");
			}
			else
			{
				System.out.println("Test Failed: Page title does not match expected title.") ;	
			}	
		driver.quit();
	}

}
