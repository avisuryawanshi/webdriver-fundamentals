package tricks;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

/*
 * 📌 Scenario:
		Objective: Identify mandatory and non-mandatory fields on a registration form by checking for the * (asterisk) symbol in pseudo-elements (::before).
		Approach:
		
		1. Use Selenium WebDriver to interact with the webpage.
		2. Extract form labels using findElements().
		3. Use JavaScript Executor to retrieve the ::before pseudo-element content.
		4. Check if the pseudo-element contains * and classify fields accordingly.
		5. Print results to the console.
 */

public class PseudoElements {

	public static void main(String[] args) {
	        
	        WebDriver driver = new ChromeDriver();
	        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10)); // Set an implicit wait
	        driver.get("https://tutorialsninja.com/demo/index.php?route=account/register");// Open the registration page
	        //driver.get("https://demo.opencart.com/en-gb?route=account/register");
	        driver.manage().window().maximize();
	        
 // ------- Step 1: Locate all label elements in the registration form
	        //List<WebElement> elements = driver.findElements(By.xpath("//form[@id='form-register']//label")); // Find all label elements in the form
	        List<WebElement> elements = driver.findElements(By.xpath("//form[@class='form-horizontal']//label")); //div[@id='content']
	        System.out.println("Total Labels Found: " + elements.size());
	        System.out.println("----------------------------------------");
	        
// -------- Step 2: Create a JavascriptExecutor instance
	        JavascriptExecutor js = (JavascriptExecutor) driver; // Create a JavascriptExecutor object	        
	        
// -------- Step 3: Iterate through each label and check for mandatory fields
	        for (WebElement element : elements) // Iterate through each label element
	        {	     
	        	// JavaScript to retrieve the content of the ::before pseudo-element
	            String script = "return window.getComputedStyle(arguments[0], '::Before').getPropertyValue('content');";// JavaScript to retrieve the content of the pseudo-element (::Before)            	            
	            
	            String content = (String) js.executeScript(script, element);// Execute JavaScript to fetch the pseudo-element content	            
	            
	            // Identify mandatory fields based on '*' in pseudo-element content
	            if (content.contains("*")) //if (content != null && content.contains("*")) 
	            {
	                System.out.println("Mandatory Field: " + element.getText());
	            } 
	            else 
	            {
	                System.out.println("Not Mandatory Field: " + element.getText());
	            }
	        }	        	       
	        driver.quit(); // Close the browser
	}
}
