package mouse.Actions;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

public class Perform {

	public static void main(String[] args) {
		
		/*
         * Understanding perform() vs. build().perform() in Selenium:
         * 
         * 1. In newer versions of Selenium, the perform() method has been enhanced.
         * 2. The perform() method internally calls the build() method, making explicit use of build() optional.
         * 3. This means that even if we don't explicitly call build(), the actions will still be compiled into a single sequence before execution.
         * 4. As a result, using build() is optional in most scenarios unless explicitly required.
         * 5. When we call perform(), it automatically builds and executes the action in a single step.
         * 
         * Conclusion:
         * We can simplify our code by just using perform(), as it handles the 'building' step internally.
         */			
		
		WebDriver driver=new ChromeDriver(); 
		driver.get("https://tutorialsninja.com/demo/");
		driver.manage().window().maximize();
		
		// Create an object of the Actions class and pass the WebDriver instance
		Actions act = new Actions(driver);

// =========================================================================================================================
// Example: Using only perform() for executing multiple actions (Staged Execution)
// =========================================================================================================================
	
		WebElement desktops=driver.findElement(By.xpath("//a[normalize-space()='Desktops']")); 		
		WebElement mac=driver.findElement(By.xpath("//a[normalize-space()='Mac (1)']"));
		
		// Performing multiple actions without explicitly calling build()
		act.
        moveToElement(desktops).  // Hover over "Desktops"
        moveToElement(mac).       // Hover over "Mac"
        //build().                // Not required; perform() internally calls build()
        perform();                // Execute/Perform the actions
		
		System.out.println("Mouse hover over 'Desktops' and 'Mac' executed successfully using build().perform().");

	}

}
