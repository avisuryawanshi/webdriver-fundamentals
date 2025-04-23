package conditional.Methods;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

/**
 * This class demonstrates the usage of the isEnabled() method in Selenium WebDriver.
 * It checks whether an input field or button is enabled (clickable) or disabled.
 */

public class isEnabled {

	public static void main(String[] args) {
		
		WebDriver driver=new ChromeDriver();
		driver.get("https://demo.nopcommerce.com/register");
		driver.manage().window().maximize();
		
// ==========================================================================================================================
// 1) Approach 1: Using isEnabled() Directly on a WebElement
// ==========================================================================================================================
		
		boolean status=driver.findElement(By.xpath("//input[@id='FirstName']")).isEnabled();
		System.out.println("Enable status:" +status); //true-part of validation use conditional method 	
			
// ==========================================================================================================================		
// 2) Approach 2: Using isEnabled() with Conditional Logic
// ==========================================================================================================================	
		
		WebElement firstNameField = driver.findElement(By.xpath("//input[@id='FirstName']"));
		if (firstNameField.isEnabled()) 
		{
			firstNameField.click();                                               // Click the field if enabled
			System.out.println("First Name field is enabled.");
		    System.out.println("Is Enabled: " + firstNameField.isEnabled());      // Validate enabled status
		} 
		else 
		{
			System.out.println("First Name field is disabled.");
		}

		driver.quit();
		

	}

}
