package mActions;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

/*
 * This approach ensures that scrolling is attempted with JavaScript Executor first, 
 * and if it fails, it gracefully falls back to Actions class.
 */

public class InfiniteScrollingDynamicWithLogic {

	public static void main(String[] args) throws InterruptedException {
		
		WebDriver driver=new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		driver.get("https://www.booksbykilo.in/new-books");
		driver.manage().window().maximize();
		
// =====================================================================================================================================================		
// (Best Approach): Final Solution: Dynamic Scrolling with Logic
// This approach dynamically scrolls the page until the desired book "Disney Frozen Movie Storybook" is found.
// =====================================================================================================================================================	
		JavascriptExecutor js = (JavascriptExecutor) driver;    // JavaScript Executor for scrolling
		Actions act = new Actions(driver);                      // Actions class to simulate keyboard scrolling
		
		boolean found = false;  // Variable to track if the desired book is found

// ---- While loop to scroll until the desired book is located --------------------------------
		
		while (!found)     																			// While loop to scroll until the desired book is located
		{
		    List<WebElement> books = driver.findElements(By.xpath("//div[@id='productsDiv']//h3")); // Capture all books titles currently visible

		    for (WebElement book : books)                                                   // 🔹 Iterate through the list of books to find the target book
			 {
		        if (book.getText().equals("Disney Frozen Movie Storybook"))
		        {
		            System.out.println("Book found: " + book.getText());                    // Print success message and update the 'found' flag
		            found = true;
		            break; // Exit loop as the book has been found
		        }
		     }
				
// -------- If book is not yet found, continue scrolling --------------------------------------
		    if (!found) 
		    	
		    {
		        js.executeScript("window.scrollBy(0, document.body.scrollHeight);"); // Scroll to the bottom of the page // Scroll down using JavaScript Executor
		    	act.sendKeys(Keys.END).perform();   // Alternate way: Simulate pressing the "End" key to scroll further
		        Thread.sleep(3000); // Allow time for more elements to load
		    }   
		}

	}

}
