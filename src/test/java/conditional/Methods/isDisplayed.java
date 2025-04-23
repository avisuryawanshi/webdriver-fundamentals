package conditional.Methods;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

/**
 * This class demonstrates the usage of the isDisplayed() method in Selenium WebDriver.
 * It verifies the presence of a web element (e.g., logo, image, button, input box, etc.).
 */

public class isDisplayed {

	public static void main(String[] args) {
		
		WebDriver driver=new ChromeDriver();
		driver.get("https://demo.nopcommerce.com/register");
		driver.manage().window().maximize();

// =======================================================================================================================
// 1) Using isDisplayed() Directly on a WebElement
// =======================================================================================================================
		//isDisplayed()--> image or input box, links, button
		
		WebElement logo=driver.findElement(By.xpath("//img[@alt='nopCommerce demo store']"));
		System.out.println("Display status of logo:" +logo.isDisplayed()); // Prints true if displayed

// =======================================================================================================================
// 2) Using isDisplayed() with if-else Condition
// =======================================================================================================================		
		
		boolean logostatus=driver.findElement(By.xpath("//img[@alt='nopCommerce demo store']")).isDisplayed();
		//System.out.println("Display status:" +logostatus);
		if (logostatus) 
			{
			    System.out.println("Logo is displayed.");
			} 
		else
			{
			    System.out.println("Logo is not displayed.");
			}
		
// =======================================================================================================================			
// 3) Alternative Approach - Storing Element in a Variable and Checking its Visibility	
// =======================================================================================================================	
		
		WebElement element = driver.findElement(By.xpath("//img[@alt='nopCommerce demo store']"));
		if (element.isDisplayed()) 
			{
		    System.out.println("Element is visible on the page.");  // Perform actions on the element
		}
		 else 
			{
		    System.out.println("Element is not visible.");  // Handle the case where the element is not visible
		}


		// Close the browser
		driver.quit();
	}

}
