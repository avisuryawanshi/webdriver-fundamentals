package getMethods;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class getText {

	public static void main(String[] args) {
		
		WebDriver driver = new ChromeDriver();  //(CTRL+shift+O)	
		driver.get("https://testautomationpractice.blogspot.com/");
		//System.out.println(driver.getCurrentUrl());
		driver.manage().window().maximize();

//----------------------------------------------------------------------------------------------------------------------------------		
// 1st Approach:Retrieving text from a single element using getText()  
//----------------------------------------------------------------------------------------------------------------------------------
		
        WebElement textElement = driver.findElement(By.tagName("h1"));// Locate the element whose text needs to be retrieved
        String text = textElement.getText();                          // Get the text of the element
        System.out.println("Element text: " + text);                  // Print the retrieved text

//----------------------------------------------------------------------------------------------------------------------------------        
// 2nd Approach: Handling cases where getText() might return an empty string
//----------------------------------------------------------------------------------------------------------------------------------        
        /* 
         * Issues that can cause empty text:
         * - No Visible Text (empty <div> tags)
         * - Hidden Elements (CSS hidden/display:none)
         * - Timing Issues (element not fully loaded)
         */
        
        /*WebDriverWait wait = new WebDriverWait(driver, 10); // Wait up to 10 seconds
        WebElement element = wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("exampleId"))); // Wait for visibility
        System.out.println(element.getText()); // Retrieve text after element is visible*/

//----------------------------------------------------------------------------------------------------------------------------------        
// 3rd Approach: Handling NoSuchElementException      
//----------------------------------------------------------------------------------------------------------------------------------
        /*
         * - This occurs when trying to get text from an element that doesn’t exist on the page.
         * - Using presenceOfElementLocated() ensures the element exists before accessing its text.
         */
        
        /*WebDriverWait wait = new WebDriverWait(driver, 10); // Wait up to 10 seconds
        WebElement element = wait.until(ExpectedConditions.presenceOfElementLocated(By.id("elementId"))); // Wait for element presence
        System.out.println(element.getText()); // Retrieve text after element is present*/

//----------------------------------------------------------------------------------------------------------------------------------
// 4th Approach: Retrieving text from a list of elements (e.g., all links)
//----------------------------------------------------------------------------------------------------------------------------------  
        
        List<WebElement> elements = driver.findElements(By.tagName("a"));
        for (WebElement element : elements) 
        	{
            System.out.println(element.getText());
        }

        driver.quit();

//----------------------------------------------------------------------------------------------------------------------------------        
// 5th Approach: Handling Unexpected Spaces in Text
//----------------------------------------------------------------------------------------------------------------------------------  
        /*
         * - Sometimes retrieved text has extra spaces or newlines.
         * - Use trim() to remove leading/trailing spaces and replace multiple spaces with a single space.
         */       
        
        /*WebElement element = driver.findElement(By.id("myElement")); // Replace with your element ID
     		// Retrieve and clean the text
             String text = element.getText().trim().replaceAll("\\s+", " ");
     		// Assert the cleaned text matches the expected value
             Assert.assertEquals("Expected Text", text);*/
      
//----------------------------------------------------------------------------------------------------------------------------------  
// 6th Approach: Extracting Error Messages
//----------------------------------------------------------------------------------------------------------------------------------  
        /*
         * - Useful when validating error messages in forms or alerts.
         * - Use getText() to retrieve error messages and assert their correctness.
         */        
        
        // Locate the error message element
       /* WebElement errorMessage = driver.findElement(By.id("errorMessage")); // Replace with your error message ID
        // Retrieve the error message
        String actualErrorMessage = errorMessage.getText();
        // Assert the error message matches the expected value
        Assert.assertEquals("Please enter a valid email address.", actualErrorMessage);*/
	}
}
