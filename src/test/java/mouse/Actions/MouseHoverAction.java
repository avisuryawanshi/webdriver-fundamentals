package mouse.Actions;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

public class MouseHoverAction {

	public static void main(String[] args) {
		
		WebDriver driver=new ChromeDriver(); //Ctrl+shift+O
		driver.get("https://tutorialsninja.com/demo/");
		driver.manage().window().maximize();
		
		// Locate the "Desktops" menu element
		WebElement desktops=driver.findElement(By.xpath("//a[normalize-space()='Desktops']")); 
		// Locate the "Mac" submenu element
		WebElement mac=driver.findElement(By.xpath("//a[normalize-space()='Mac (1)']"));  
		
// ========================================================================================================================================
// Mouse Hover Action (moveToElement) using Actions class object.
// ========================================================================================================================================		

		// Create an object of the Actions class and pass the WebDriver instance
		Actions act = new Actions(driver); //create object for action class that is predefined class which is available in Selenium, pass driver as a parameter
		
		// Move to "Desktops" and then to "Mac" using Actions class
        act.moveToElement(desktops)  // Hover over the "Desktops" menu
           .moveToElement(mac)       // Move to the "Mac" submenu
           .perform();               // Execute the actions
		
        /*
        Alternative approach:
        
        act.
        moveToElement(desktops).  // Hover over "Desktops"
        moveToElement(mac).       // Hover over "Mac"
        build().                  // Build the sequence of actions
        perform();                // Perform the actions
        */

        // Close the browser (if required)
        // driver.quit();
	}

}
