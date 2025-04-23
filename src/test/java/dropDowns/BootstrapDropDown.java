package dropDowns;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

/**
 * This class demonstrates how to handle Bootstrap drop-downs in Selenium WebDriver.
 * It covers selecting a single option, capturing all available options, and selecting multiple options.
 */

public class BootstrapDropDown {

	public static void main(String[] args) {
		
		WebDriver driver=new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		driver.get("https://www.jquery-az.com/boots/demo.php?ex=63.0_2");
		driver.manage().window().maximize();
		
// ==============================================================================================================================================
// 1) Click on the dropdown to display available options
// ==============================================================================================================================================
		
		driver.findElement(By.xpath("//button[contains(@class,'multisele')]")).click();
		// Alternative XPath (uncomment if needed)
		//driver.findElement(By.xpath("//button[@title='HTML, CSS']")).click();// selectorHub xpath working
		
// ==============================================================================================================================================		
// 2) Select a Single Option from the Dropdown
// ==============================================================================================================================================
		// Select the "Java" option from the dropdown
		driver.findElement(By.xpath("//label[normalize-space()='Java']")).click(); 
		// Alternative XPath: //label[normalize-space()='Java'] //input[@value='Java']
		
// ==============================================================================================================================================		
// 3) Capture All Options in the Dropdown and Print Count/size
// ==============================================================================================================================================		
		// Find all label elements within the dropdown's unordered list (ul)
		List<WebElement> options=driver.findElements(By.xpath("//ul[contains(@class,'multiselect')]//label"));
		System.out.println("Total number of options:" +options.size()); // Expected: 14
		
// ==============================================================================================================================================	
// 4) Print All Options Available in the Dropdown
// ==============================================================================================================================================
		// Iterate through the list of options and print their text
		for(WebElement op:options)            // Using an enhanced for-loop for better readability
		{
			System.out.println(op.getText()); // Extract and print the text of each option
		}
		
// ==============================================================================================================================================        
// 5) Select Multiple Options from the Dropdown (Uncomment to Use)
// ==============================================================================================================================================
		
		/*for (WebElement op : options)     // Select all available options
		{
	    op.click();                         // Select each option
	    }
		
		for (WebElement op : options)       // Select specific options (Java, Python, MYSQL)
		{
            String option = op.getText();
			 	
			if (option.equals("Java") || option.equals("Python") || option.equals("MYSQL")) 
			{
                op.click();
			}
		}*/
		
		// Close the browser session
        // driver.quit();

	}

}
