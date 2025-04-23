package getMethods;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class getCurrentURL {

	public static void main(String[] args) {
		
		WebDriver driver = new ChromeDriver();  //(CTRL+shift+O)	
		driver.get("https://demo.opencart.com/");
		driver.manage().window().maximize();

//----------------------------------------------------------------------------------------------------------------		
// Approach 1: Retrieve and print the current URL
//----------------------------------------------------------------------------------------------------------------	
		
		//driver.getCurrentUrl();
		String currentUrl = driver.getCurrentUrl();                  // Get the current URL
		System.out.println("Current URL: " + driver.getCurrentUrl());// Print the current URL
		
//-----------------------------------------------------------------------------------------------------------------
// Approach 2: Validate the current URL
//-----------------------------------------------------------------------------------------------------------------
		String actualURL = driver.getCurrentUrl();                    
		String expectedURL = "https://demo.opencart.com/";           // Define the expected URL
			 
			if(actualURL.equals(expectedURL)) 
				{
			    System.out.println("Test Passed: URL is correct");    // URL matches the expected value
				} 
			else 
				{
			    System.out.println("Test Failed: URL mismatch");      // URL does not match the expected value
				}

		driver.quit();
	
//---------------------------------------------------------------------------------------------------------------------		
// Approach 3: Validate using TestNG or JUnit 	
//---------------------------------------------------------------------------------------------------------------------		
//For example, using TestNG or JUnit, I could write something like this:

			/*String expectedURL = "https://example.com/dashboard";             // Expected URL
			String actualURL = driver.getCurrentUrl();                          // Get the actual URL
			Assert.assertEquals(actualURL, expectedURL, "URL does not match!"); // Compare and assert
			
//----------------------------------------------------------------------------------------------------------------------
// Approach 4: Extract fragment identifier from URL (Commented) 
//----------------------------------------------------------------------------------------------------------------------
        String currentUrl = driver.getCurrentUrl();               // Get the current URL including the fragment
        System.out.println("Current URL: " + currentUrl);

        // Extract the fragment identifier if present
        if (currentUrl.contains("#"))                              // Check if the URL contains a fragment identifier (#)
	        {
	            String fragment = currentUrl.substring(currentUrl.indexOf("#"));
	            System.out.println("Fragment Identifier: " + fragment);
	        } 
        else 
	        {
	            System.out.println("No Fragment Identifier found in URL.");
	        }
	        
	    driver.quit();*/
	
	}
}
