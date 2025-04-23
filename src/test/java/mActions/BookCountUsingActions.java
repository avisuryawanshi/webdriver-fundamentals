package mActions;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

/*
 * 📌 Test Scenario:
		1️. Navigate to the Books By Kilo website.
		2️. Scroll down dynamically until all books are loaded.
		3️. Count the total number of books displayed on the webpage.
		4️. Print the book count and exit the browser.
 */

public class BookCountUsingActions {

	public static void main(String[] args) throws InterruptedException {
		
		WebDriver driver=new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		driver.get("https://www.booksbykilo.in/new-books");
		driver.manage().window().maximize();
		
// =====================================================================================================================
// Logic- Using Action class for Keyboard Actions
// =====================================================================================================================
		
		Actions act=new Actions(driver);      // Initialize Actions class for sending keyboard actions 	
		
		int previousCount=0;                  // Variables to keep track of book count during scroll
		int currentCount=0;                   // Scroll and Count Books
		
		while(true)                           // Infinite loop to scroll and fetch books until all are loaded
		{
			List<WebElement> books=driver.findElements(By.xpath("//div[@id='productsDiv']//h3"));  // Find all book elements
			currentCount = books.size();      // Count current number of books loaded
			System.out.println("📚 Books Loaded So Far: " + currentCount);
			
			if(currentCount==previousCount)   // If no new books are loaded, exit the loop
			{
				System.out.println("✅ All books are loaded successfully.");
				break;
			}
			
			previousCount=currentCount;       // Update the previous count for the next scroll/iteration
			
			act.sendKeys(Keys.END).perform(); // Scroll to the bottom of the page using Actions class
			Thread.sleep(3000);
		}
		
		System.out.println("total number of books: " + previousCount);   //total number of books: 559
		driver.quit();

	}

}
