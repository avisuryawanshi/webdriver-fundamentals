package mouse.Actions;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

public class buildPerform {

	public static void main(String[] args) {
		
		WebDriver driver=new ChromeDriver(); 
		driver.get("https://tutorialsninja.com/demo/");
		driver.manage().window().maximize();
		
		// Create an object of the Actions class and pass the WebDriver instance
		Actions act = new Actions(driver);

// =========================================================================================================================
// Example: When build() is required :Staged Execution
// =========================================================================================================================
		// If we want to hover over a menu and then hover over a submenu before performing an action,
		// we need to build() the sequence before executing perform().
		// When build() is required: If we want to hover over a menu and then click on a submenu, we'd use code like this:
		
		// Locate the "Desktops" menu element
		WebElement desktops=driver.findElement(By.xpath("//a[normalize-space()='Desktops']")); 
				
		// Locate the "Mac" submenu element
		WebElement mac=driver.findElement(By.xpath("//a[normalize-space()='Mac (1)']"));
		
		// Multiple actions executed together
		act.
        moveToElement(desktops).  // Hover over "Desktops"
        moveToElement(mac).       // Hover over "Mac"
        build().                  // Build the sequence of actions
        perform();                // Execute/Perform the actions
		
		System.out.println("Mouse hover over 'Desktops' and 'Mac' executed successfully using build().perform().");
// ==========================================================================================================================
// Example: When build() is NOT required :Immediate Execution
// ==========================================================================================================================
        // If we only want to perform a single action (e.g., clicking an element),
        // using build() is unnecessary.
		//If we just want to click on a button, we can use: actions.click(button).perform(); In this case, build() is unnecessary.
		
		// Locate the "shopping cart button" element
		/*WebElement cartButton=driver.findElement(By.xpath("//span[@id='cart-total']")); 
		act.click(cartButton).perform();  // Click on "Desktops" without using build(), as it's a single action.
		System.out.println("Clicked on 'Shopping Cart' button using perform().");*/
		
		//driver.quit();
	}

}
