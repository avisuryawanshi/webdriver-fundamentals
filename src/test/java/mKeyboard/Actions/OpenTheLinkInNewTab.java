package mKeyboard.Actions;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

/*
 * =============================================================
 * Miscellaneous Concepts:  Handling Keyboard Actions: Opening a Link in a New Tab
 * =============================================================
 * 
 * Scenario: 
 * - The requirement is to open the "Register" link in a new tab 
 *   instead of navigating away from the current page.
 * - By default, clicking on the "Register" link loads the 
 *   registration page in the same tab, replacing the homepage.
 * - To achieve this, we use the Actions class to simulate 
 *   a "CTRL + Left Click" action, which opens the link in a new tab.
 */

public class OpenTheLinkInNewTab {

	public static void main(String[] args) {
		
		WebDriver driver=new ChromeDriver(); //Ctrl+shift+O
		driver.get("https://demo.nopcommerce.com/");
		driver.manage().window().maximize();
			
		// Locate the "Register" link element
		WebElement regLink=driver.findElement(By.xpath("//a[normalize-space()='Register']"));
			
		Actions act=new Actions(driver);
		
//---------------------------------------------------------------------------------------------------------
// Perform "CTRL + Left Click" to open the link in a new tab
//---------------------------------------------------------------------------------------------------------
		 act.keyDown(Keys.CONTROL) // Press CTRL key
            .click(regLink)        // Click on the Register link
            .keyUp(Keys.CONTROL)   // Release CTRL key
            .perform();            // Execute the action sequence

// Note: The new tab will open, but WebDriver will still focus on the original tab.
// If required, we can switch to the new tab using driver.getWindowHandles().

	}

}
