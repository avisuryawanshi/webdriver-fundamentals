package conditional.Methods;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

/**
 * This class demonstrates the usage of the isEnabled() method in Selenium WebDriver.
 * It verifies whether the "Register" button is enabled before and after entering mandatory details.
 */

public class isEnabledExample {

	public static void main(String[] args) {
		
		WebDriver driver=new ChromeDriver();
		driver.get("https://demo.nopcommerce.com/register");
		driver.manage().window().maximize();

// ==============================================================================================================================
// 1) Check if "Register" Button is Enabled Before Entering Required Details
// ==============================================================================================================================

		WebElement submitButton = driver.findElement(By.id("register-button"));
		
		// Trying to click the Register button without filling details will fail (Uncomment to test)
        submitButton.click();
        // Print status of the Register button before entering any details (Expected: false)
        System.out.println("Before entering credentials: " + submitButton.isEnabled()); 
         
// ==============================================================================================================================
// 2) Enter Required Registration Details & Check if Button Becomes Enabled
// ==============================================================================================================================
		
		WebElement submitBtn = driver.findElement(By.id("register-button"));
		
		// Fill "Your Personal Details" section
		driver.findElement(By.id("FirstName")).sendKeys("test");      // Enter First Name
		driver.findElement(By.id("LastName")).sendKeys("user");       // Enter Last Name
		driver.findElement(By.id("Email")).sendKeys("abc@gmail.com"); // Enter Email
		
		// Fill "Your Password" section
		driver.findElement(By.id("Password")).sendKeys("testUser");        // Enter Password
		driver.findElement(By.id("ConfirmPassword")).sendKeys("testUser"); // Confirm Password
		
		// Print status of the Register button after entering required details (Expected: true)
		System.out.println("After entering credentials: " + submitBtn.isEnabled()); // true
		
		if (submitBtn.isEnabled()) 
		{
			submitBtn.click();
			System.out.println("Register button clicked successfully!");
		}
		
		//driver.quit();   // Close the browser session

	}

}
