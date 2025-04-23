package conditional.Methods;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

/**
 * This class demonstrates the usage of the isSelected() method in Selenium WebDriver.
 * It verifies the selection status of radio buttons and checkboxes before and after clicking them.
 */

public class isSelected {

	public static void main(String[] args) {
		
		WebDriver driver=new ChromeDriver();
		driver.get("https://demo.nopcommerce.com/register");
		driver.manage().window().maximize();

// Case 1:====================================================================================================================
// Check Initial Selection Status of the Male Radio Button
//============================================================================================================================
			
		//boolean status=driver.findElement(By.xpath("//input[@id='gender-male']")).isSelected();
		//System.out.println("Select status:" +status);  // Expected: false
				 
// Case 2:====================================================================================================================
// 1) Locate Male and Female Radio Buttons
//============================================================================================================================
			WebElement male_RadioButton=driver.findElement(By.xpath("//input[@id='gender-male']"));
			WebElement female_RadioButton=driver.findElement(By.xpath("//input[@id='gender-female']"));	
//============================================================================================================================			
// 2) Check Selection Status Before Clicking Any Radio Button
//============================================================================================================================
			
			System.out.println("\nBefore selection:");
			System.out.println("Male selected: " + male_RadioButton.isSelected());   // Expected: false
		    System.out.println("Female selected: " + female_RadioButton.isSelected()); // Expected: false
				
//============================================================================================================================		 
// 3) ✅ Select the *Male* Radio Button and Verify Status
//============================================================================================================================
				
		    System.out.println("\nAfter selecting Male:");
			male_RadioButton.click(); //select male radio button
			System.out.println("Male selected: " + male_RadioButton.isSelected());   // Expected: true
		    System.out.println("Female selected: " + female_RadioButton.isSelected()); // Expected: false
				
//============================================================================================================================		 
// 4) ✅ Select the *Female* Radio Button and Verify Status
//============================================================================================================================
				
		    System.out.println("\nAfter selecting Female:");
			female_RadioButton.click(); //select female radio button
			System.out.println("Male selected: " + male_RadioButton.isSelected());   // Expected: false
		    System.out.println("Female selected: " + female_RadioButton.isSelected()); // Expected: true

// Case 3:====================================================================================================================		    
// ✅ Check Initial Selection Status of the Newsletter Checkbox
//============================================================================================================================
				
		    boolean newsletterstatus=driver.findElement(By.xpath("//input[@id='Newsletter']")).isSelected();
			System.out.println("News letter checkbox status:" +newsletterstatus); // Expected: true/false
				
			driver.quit(); // Close the browser session

	}

}
