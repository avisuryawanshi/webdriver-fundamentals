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
 * This approach ensures that scrolling is attempted with Actions class first, 
 * and if it fails, it gracefully falls back to JavaScript Executor.
 */

public class ScrollToSpecificElement {

	public static void main(String[] args) throws InterruptedException {
		
		WebDriver driver=new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		driver.get("https://www.booksbykilo.in/new-books");
		driver.manage().window().maximize();
		
// ===========================================================================================================================		
// (Approach 1): Scroll to the 'Magic Book' element using Actions Class
// ===========================================================================================================================			
		
		// Locate the 'Magic Book' element
		WebElement book=driver.findElement(By.xpath("//h3[normalize-space()='Magic Book']")); //scrool till 'Magic Book'
		
		Actions act = new Actions(driver);
		act.scrollToElement(book).perform();                                                  // Scroll down to 'Magic Book'
		System.out.println("🔽 Scrolled to 'Magic Book' using Actions Class (scrollToElement method).");
		
		// ✅ Alternative: Move to the 'Magic Book' element (if needed)
        //act.moveToElement(book).perform();  // Works as well
        //System.out.println("📌 Moved to 'Magic Book' using Actions Class (moveToElement method).");

// ===========================================================================================================================================	
// (Approach 2): Attempt to scroll using JavaScript Executor (working)
// ===========================================================================================================================================				
		//WebElement book=driver.findElement(By.xpath("//h3[normalize-space()='Magic Book']")); 
		
		WebElement element = driver.findElement(By.xpath("//div[@data-name='Magic Book']"));
		
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("document.body.style.zoom='50%'");  // Set the zoom level to 50%
		js.executeScript("arguments[0].style.transform='scale(2.5)'", element);  //Zoom In on the specific element
		
		try 
		{
            js.executeScript("arguments[0].scrollIntoView(true);", book);
            System.out.println("✅ Successfully scrolled to the 'Magic Book' element using JavaScript Executor.");
        } 
		catch (Exception e) 
		{
            System.out.println("⚠ JavaScript Executor scrolling failed! Switching to Actions Class.");
		}
		
	}

}
