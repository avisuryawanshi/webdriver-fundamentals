package checkBoxes;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

/**
 * This class demonstrates how to handle checkboxes using Selenium WebDriver.
 * It covers:
 * 1. Selecting only the first three checkboxes.
 * 2. Printing the count of selected checkboxes.
 */

public class SelectOnlyFirst3 {

	public static void main(String[] args) {
		
		WebDriver driver = new ChromeDriver(); //ctrl+shift+o
		driver.get("https://testautomationpractice.blogspot.com/"); 
		driver.manage().window().maximize();
		
// ===================================================================================================================================
// 1) ✅ Select/ Locate All Checkboxes
// ===================================================================================================================================
		
		List<WebElement> checkboxes=driver.findElements(By.xpath("//input[@class='form-check-input' and @type='checkbox' ]"));
		System.out.println("Total number of checkboxes: " + checkboxes.size()); //Print Total Checkbox Count 7

// ===================================================================================================================================		
// 2) ✅ Select Only the First Three Checkboxes
// ===================================================================================================================================		
		
		for(int i=0;i<3;i++)            // Loop to select only the first three checkboxes
		{
			checkboxes.get(i).click();  // Click the checkbox
			System.out.println("Checkbox '" + checkboxes.get(i).getDomAttribute("id") + "' is selected.");
		}

// ===================================================================================================================================		
// 3) ✅ Print Count of Selected Checkboxes
// ===================================================================================================================================		
		
		int selectedCount = 0;                 // Variable to store count of selected checkboxes
		for (WebElement checkbox : checkboxes) 
		{
		    if (checkbox.isSelected())         // Increment count if checkbox is selected
		    {
		        selectedCount++;
		    }
		}
		// Print the total number of checkboxes that are selected
		System.out.println("Total number of selected checkboxes: " + selectedCount); // Expected: 3

		driver.quit();                         // Close the browser session

	}

}
