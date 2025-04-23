package checkBoxes;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

/**
 * This class demonstrates how to handle multiple checkboxes using Selenium WebDriver.
 * It covers:
 * 1. Selecting all checkboxes using a traditional "for loop."
 * 2. Selecting all checkboxes using an enhanced "for-each loop."
 */

public class SelectMultipleCheckBox {

	public static void main(String[] args) {
		
		WebDriver driver = new ChromeDriver(); //ctrl+shift+o
		driver.get("https://testautomationpractice.blogspot.com/"); 
		driver.manage().window().maximize();
		
// ====================================================================================================================================
// 1) ✅ Selecting All Checkboxes
// ====================================================================================================================================
		
		List<WebElement> checkboxes=driver.findElements(By.xpath("//input[@class='form-check-input' and @type='checkbox' ]"));
		
		System.out.println("Total number of checkboxes: " + checkboxes.size()); //Print Total Checkboxes Count/found
		//System.out.println("✅ Selected Checkboxes ✅");

// ---- Scenario 1: ✅ Selecting All Checkboxes Using a Classical/ Traditional "for loop" -----
		for(int i=0;i<checkboxes.size();i++)
		{
			checkboxes.get(i).click();    // Click each checkbox
			System.out.println("Checkbox " + (i + 1) + " is clicked."); //Print Each Checkbox Click Action
		}
		
// ---- Scenario 2: ✅ Selecting All Checkboxes Using an Enhanced "for-each loop" (simplest way) -----
		System.out.println("✅ Selected Checkboxes with their IDs ✅");
		for(WebElement checkbox:checkboxes)
		{
			checkbox.click();     // Click each checkbox
			//System.out.println("Checkbox IDs"); //Print Checkbox Count Along with IDs
			
			///*depecated method - Not in use*
			//System.out.println(checkbox.getAttribute("id"));  
		    ///*currently in use*
			//System.out.println(checkbox.getDomAttribute("id"));
			//System.out.println("Clicked checkbox ID: " + checkbox.getDomAttribute("id")); // Print checkbox ID
			
			// Alternative: Print selection status (true/false)
			//System.out.println("Checkbox ID: " + checkbox.getDomAttribute("id") + " | Selected: " + checkbox.isSelected()); //Print Checkbox Selection Status (True/False)
			System.out.println("Checkbox ID: " + checkbox.getDomAttribute("id") + " | Selected: " + checkbox.isDisplayed());
		}
		driver.quit();
	}

}
