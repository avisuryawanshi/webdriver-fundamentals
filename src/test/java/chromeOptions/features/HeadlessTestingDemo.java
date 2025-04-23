package chromeOptions.features;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

public class HeadlessTestingDemo {

	public static void main(String[] args) {
		
// =========================================================================================================
// Scenario: Perform a basic validation test on the TutorialsNinja demo site in headless mode
// =========================================================================================================
				
// Step 1:  Create ChromeOptions object and enable headless mode
			ChromeOptions options=new ChromeOptions();
			options.addArguments("--headless=new");   // Enables headless execution (no UI display)
		
// Step 2:  Initialize the WebDriver with ChromeOptions
			WebDriver driver=new ChromeDriver(options); //For chrome browser
			System.out.println("Chrome browser launched in headless mode.");
		
// Step 3:  Open the target website
			driver.get("https://tutorialsninja.com/demo/");
		
// Step 4:  Get the title of the webpage
			String actualTitle = driver.getTitle();
	        System.out.println("Page Title Retrieved: " + actualTitle);
			
// Step 5:  Validate the page title
	        String expectedTitle = "Your Store";  // Expected title of the homepage
	       
	        if (actualTitle.equals(expectedTitle)) 
	        {
	            System.out.println("Test Passed: Page title matches expected title.");
	        } 
	        else 
	        {
	            System.out.println("Test Failed: Page title does not match expected title.");
	        }
// Step 6:  Close the browser
	        driver.quit();	
	}

}
