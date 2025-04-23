package checkBoxes;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

/**
 * This class demonstrates how to handle checkboxes using Selenium WebDriver.
 * It includes:
 * 1. Selecting a specific checkbox.
 * 2. Verifying checkbox selection status.
 * 3. Checking if a checkbox is pre-selected.
 * 4. Selecting and then deselecting a checkbox.
 * 5. Using keyboard interactions (SPACE key) for accessibility testing.
 */

public class SelectSpecificCheckBox {

	public static void main(String[] args) throws InterruptedException {
		
		WebDriver driver = new ChromeDriver(); //ctrl+shift+o
		driver.get("https://testautomationpractice.blogspot.com/"); 
		driver.manage().window().maximize();
		
// ================================================================================================================================		
// 1) Selecting a Specific Checkbox ✅
// ================================================================================================================================	
		
		driver.findElement(By.xpath("//input[@id='sunday']")).click();  // Click on the checkbox
		System.out.println("Checkbox 'Sunday' is clicked.");

// ================================================================================================================================			
// 2)  Verifying Checkbox Selection using isSelected() Method
// ================================================================================================================================	
		
		WebElement checkbox = driver.findElement(By.xpath("//input[@id='sunday']"));
		checkbox.click();
		
		System.out.println("Checkbox 'Sunday' selected status: " + checkbox.isSelected());// Prints true if selected
		
// ================================================================================================================================			
// 3)  Check if the Checkbox is Pre-selected by Default ✅
// ================================================================================================================================	
		
		WebElement checkbox1 = driver.findElement(By.xpath("//input[@id='sunday']"));
		if (checkbox.isSelected()) 
		{
		    System.out.println("Checkbox is already selected.");
		} 
		else 
		{
		    System.out.println("Checkbox is not selected by default.");
		}
			
// ================================================================================================================================			
// 4)  Selecting and Deselecting the Checkbox ✅
//     Clicking and Verifying State Change (select to deselect)
// ================================================================================================================================			
		
		WebElement checkbox2 = driver.findElement(By.xpath("//input[@id='sunday']"));
		if (!checkbox.isSelected()) 
		{
		    checkbox.click();                           // Select the checkbox if not already selected
		    System.out.println("Select the checkbox");
		    Thread.sleep(3000);
		}
			checkbox.click();                           // Deselect the checkbox
			System.out.println("Deselect the checkbox");

// ================================================================================================================================	
// 5)  Validating Checkbox with Keyboard Accessibility (SPACE Key) ✅			
// ================================================================================================================================			
	
	//  Using the SPACE key to select/deselect the checkbox for accessibility testing
		WebElement checkbox3 = driver.findElement(By.xpath("//input[@id='sunday']"));
		checkbox.sendKeys(Keys.SPACE);
		
		System.out.println("Checkbox was not selected via keyboard!");

		driver.quit();    // Close the browser session
	}

}
