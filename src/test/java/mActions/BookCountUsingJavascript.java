package mActions;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

/*
 * 📌 Test Scenario:
		1️. Navigate to the Books By Kilo website.
		2️. Scroll down dynamically until all books are loaded.
		3️. Count the total number of books displayed on the webpage.
		4️. Print the book count and exit the browser.
 */

public class BookCountUsingJavascript {

	public static void main(String[] args) throws InterruptedException {
		
		WebDriver driver=new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		driver.get("https://www.booksbykilo.in/new-books");
		driver.manage().window().maximize();

// ====================================================================================================================	
// Logic- using JavascriptExecutor
// ====================================================================================================================
		
		JavascriptExecutor js=(JavascriptExecutor)driver; // Initialize JavascriptExecutor for scrolling
		
		// Variables to keep track of book count during scroll
		int previousCount=0;
		int currentCount=0;
		
		while(true)                           // Infinite loop to scroll and fetch books until all are loaded
		{
			List<WebElement> books=driver.findElements(By.xpath("//div[@id='productsDiv']//h3"));  // Find all book elements
			currentCount=books.size();
			System.out.println("📚 Books Loaded So Far: " + currentCount);
			
			if(currentCount==previousCount)   // If no new books are loaded, exit the loop
			{
				System.out.println("✅ All books are loaded successfully.");
				break;
			}
			previousCount=currentCount;       // Update the previous count for the next iteration
					
			js.executeScript("window.scrollBy(0,document.body.scrollHeight)");   // Scroll to the bottom of the page
			Thread.sleep(3000);
		}
		
		System.out.println("total number of books: "+previousCount);   // total number of books: 559
		driver.quit();
	
	}

}
