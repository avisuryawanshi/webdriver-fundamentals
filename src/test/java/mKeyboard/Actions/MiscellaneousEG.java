package mKeyboard.Actions;

import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

public class MiscellaneousEG {

	public static void main(String[] args) {
		
		 	WebDriver driver=new ChromeDriver(); //Ctrl+shift+O
			driver.get("https://demo.nopcommerce.com/");
			driver.manage().window().maximize();
			
			// Locate the "Register" link element
			WebElement regLink=driver.findElement(By.xpath("//a[normalize-space()='Register']"));
			
			Actions act=new Actions(driver);
			
// -----------------------------------------------------------------------------------------------------------
// Perform "CTRL + Left Click" to open the Register link in a new tab
// -----------------------------------------------------------------------------------------------------------			
			 act.keyDown(Keys.CONTROL) // Press CTRL key
	            .click(regLink)        // Click on the Register link
	            .keyUp(Keys.CONTROL)   // Release CTRL key
	            .perform();            // Execute the action seque
					 
// ----------------------------------------------------------------------------------
// At this point, the Register page has opened in a new tab.
// However, WebDriver's focus remains on the original (home) page.
// To interact with elements on the new tab, we must switch to it.
// ----------------------------------------------------------------------------------		
			
			//switching to registration page
			 
			// Get window handles for all open tabs and store them in a list
			 List<String> ids = new ArrayList<>(driver.getWindowHandles());
			
			// Switch WebDriver focus to the newly opened "Register" page tab
			driver.switchTo().window(ids.get(1));  // Switch to the registration page tab
			
			// Perform an action on the registration page
			 driver.findElement(By.xpath("//input[@id='FirstName']")).sendKeys("Avi Suryawanshi");
			 
// ----------------------------------------------------------------------------------
// Switching back to the original home page tab
// ----------------------------------------------------------------------------------
		
			driver.switchTo().window(ids.get(0)); // Switch focus back to the home page
			
			// Perform an action on the home page (search for "T-shirts")
			driver.findElement(By.xpath("//input[@id='small-searchterms']")).sendKeys("T-shirts");
			
// ----------------------------------------------------------------------------------
	        // Notes:
	        // - This script demonstrates how to handle multiple tabs using WebDriver.
	        // - Always use getWindowHandles() to fetch all open tabs before switching.
	        // - Switching between tabs is essential when interacting with elements across pages.
// ----------------------------------------------------------------------------------
	}

}
