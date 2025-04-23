package mActions;

import java.time.Duration;
import java.util.List;

import org.apache.xmlbeans.impl.xb.xsdschema.Attribute.Use;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

/*
 * 📌 Scenario:
	Objective:
	The goal of this test script is to dynamically scroll down an infinitely loading webpage and locate a specific book titled "Disney Frozen Movie Storybook" using the Selenium Actions class (keyboard keys).

	Test Steps:
	1. Launch the Chrome browser and open the BooksByKilo website.
	2. Maximize the browser window and apply an implicit wait.
	3. Initialize the Actions class to simulate keyboard interactions.
	4. Continuously scroll down using the "End" key until the target book is found.
	5. Once found, print a success message and exit the loop.
	6. Close the browser after the search is completed.
 */

public class InfiniteScrollingActionKeys {

	public static void main(String[] args) throws InterruptedException {
		
		WebDriver driver=new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		driver.get("https://www.booksbykilo.in/new-books");
		driver.manage().window().maximize();
		
		// Initialize Actions class to perform keyboard interactions
		Actions act = new Actions(driver);

		// Variable to track if the target book is found	
		boolean found = false;
		
// ---- Use a while loop to scroll until the element is located: ---------------------------------------------------------
				
		while (!found) 
		{
		List<WebElement> books = driver.findElements(By.xpath("//div[@id='productsDiv']//h3"));  // Locate all visible book titles
		
// ---- Iterate through the books to check if the target book is present
		for (WebElement book : books)
			{
				if (book.getText().equals("Disney Frozen Movie Storybook"))
				{
					System.out.println("Book found: " + book.getText());
					found = true;
					break;
			    }
			}
		
// ------------ If book not found, scroll down using the "End" key to load more content
				if (!found) 
				{
					System.out.println("📜 Scrolling down to load more books...");
					act.sendKeys(Keys.END).perform();
				    Thread.sleep(3000); // Allow time for more elements to load
				}	
				
				// Step 6: Successfully found the book
				System.out.println("✅ Successfully located 'Disney Frozen Movie Storybook' on the webpage.");
		}
		
		driver.quit();
	}

}
