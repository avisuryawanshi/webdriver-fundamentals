package getMethods;

/*
1. Initializes the WebDriver.
2. Opens the URL "https://www.example.com".
3. Retrieves the entire HTML source code of the page using driver.getPageSource();.
4. Prints the source code to the console.
5. Closes the browser.
 */

//Note: The output will be a long string of HTML code, including all the tags and attributes of the webpage.

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class getPageSource {

	public static void main(String[] args) {
		
		WebDriver driver = new ChromeDriver();  //(CTRL+shift+O)	
		driver.get("https://demo.opencart.com/");
		driver.manage().window().maximize();
		
//1st Approach----------------------------------------------------------------------
		String pageSource=driver.getPageSource();    // Get the page source
		System.out.println(pageSource);
		
		//driver.quit();
		
//2nd Approach-----------------------------------------------------------------------
		//String pageSource = driver.getPageSource();
		// Verify if a specific text or element exists
		if (pageSource.contains("Expected Text")) 
			{
			    System.out.println("Text is present on the page.");
			} 
		else 
			{
			    System.out.println("Text is NOT present on the page.");
			}
		
		driver.quit();

		
		
		
	}

}
