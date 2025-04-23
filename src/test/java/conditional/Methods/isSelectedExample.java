package conditional.Methods;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

/**
 * This class demonstrates the usage of the isSelected() method in Selenium WebDriver.
 * It checks and manipulates the selection state of a checkbox element on the nopCommerce registration page.
 */

public class isSelectedExample {

	public static void main(String[] args) {
		
		WebDriver driver=new ChromeDriver();
		driver.get("https://demo.nopcommerce.com/register");
		driver.manage().window().maximize();	

//============================================================================================================		
// 1) ✅ Check and Select the Newsletter Checkbox if Not Already Selected
//============================================================================================================	
		// Locate the Newsletter checkbox
		WebElement checkbox = driver.findElement(By.id("Newsletter"));
		
		if (!checkbox.isSelected())   // If the checkbox is not selected, click to select it
		{
		    checkbox.click();         // Select the checkbox if not already selected
		}
		
		// Verify if the checkbox is selected after clicking
		if (checkbox.isSelected()) 
		{
		    System.out.println("✅ Checkbox is selected.");
		} 
		else 
		{
		    System.out.println("❌ Checkbox is NOT selected.");
		}
		
//============================================================================================================		
// 2) ❌ Deselect the Checkbox if It Was Selected by Default (Optional Scenario)
//============================================================================================================
		
		/*WebElement newsletterCheckBox = driver.findElement(By.id("Newsletter"));
		
		if (newsletterCheckBox.isSelected())  // If the checkbox is selected by default, deselect it	
		{
			newsletterCheckBox.click();
		}
		
		// Verify the deselection status
		System.out.println("Checkbox is deselected: " + !newsletterCheckBox.isSelected());

		//driver.quit(); */                      // Close the browser session


	}

}
