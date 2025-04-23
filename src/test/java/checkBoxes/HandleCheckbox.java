package checkBoxes;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

/**
 * This class demonstrates different ways to handle checkboxes using Selenium WebDriver.
 * It covers:
 * 1. Selecting a specific checkbox
 * 2. Selecting all checkboxes
 * 3. Selecting the last 3 checkboxes
 * 4. Selecting the first 3 checkboxes
 * 5. Unselecting checkboxes if they are already selected
 */

public class HandleCheckbox {

	public static void main(String[] args) throws InterruptedException {

		WebDriver driver = new ChromeDriver(); //ctrl+shift+o
		driver.get("https://testautomationpractice.blogspot.com/"); 
		driver.manage().window().maximize();
		
// ================================================================================================================================		
// 1) Selecting a Specific Checkbox
// ================================================================================================================================				
		
		driver.findElement(By.xpath("//input[@id='sunday']")).click();
		
// ================================================================================================================================	
// 2) Selecting All Checkboxes
// ================================================================================================================================	
		
		//--- Find all checkboxes on the page ---
		//List<WebElement> checkboxes=driver.findElements(By.xpath("//input[@class='form-check-input' and @type='checkbox' ]"));
		
// ----- Scenario 1: Using a Classical/ Traditional "for loop" to Select All Checkboxes -----
		/*for(int i=0;i<checkboxes.size();i++)
		{
			checkboxes.get(i).click();
		}
	
// ----- Scenario 2: Using an Enhanced "for loop" to Select All Checkboxes (simplest way) ---
		for(WebElement checkbox:checkboxes)
		{
			checkbox.click();
		}

// ================================================================================================================================			
// 3) Selecting the Last 3 Checkboxes
// ================================================================================================================================	

		// Formula: Total checkboxes - Number of checkboxes to select = Starting index
        // Example: 7 total checkboxes - 3 checkboxes to select = Start at index 4
		// Total no. of checkboxes - How many checkboxes you want to select = give you the Starting index
		// 7 - 3 = 4
		
		for(int i=4;i<checkboxes.size();i++)
		{
			checkboxes.get(i).click();
		}

// ================================================================================================================================			
// 4) Selecting the First 3 Checkboxes
// ================================================================================================================================			
	
		for(int i=0;i<3;i++)
		{
			checkboxes.get(i).click();
		}

// ================================================================================================================================	
// 5) Unselecting Checkboxes If They Are Already Selected
// ================================================================================================================================	

		// Step 1: Select all checkboxes first ------
		for(WebElement checkbox:checkboxes) 
		{
			checkbox.click();
		}
		
		// Step 2: Select the first 3 checkboxes again -----
		for(int i=0;i<3;i++) 
		{
			checkboxes.get(i).click();
		}
		Thread.sleep(5000); // Step 3: Wait for 5 seconds (for demonstration purposes)
		
		// Step 4: Iterate through all checkboxes and uncheck them if they are selected -----
		for(int i=0;i<checkboxes.size();i++)
		{
			if(checkboxes.get(i).isSelected())
			checkboxes.get(i).click();
		}*/

	}

}
