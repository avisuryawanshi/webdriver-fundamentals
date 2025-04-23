package browserWindow.Management;

import java.awt.AWTException;
import java.awt.Robot;
import java.awt.event.KeyEvent;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

/*
 * Different Ways to Zoom In and Out using Selenium:
 *
 * 1. Actions Class          - Simulates keyboard shortcuts (CTRL + "+" or "-").
 * 2. JavaScript Executor    - Uses document.body.style.zoom (Works in Chrome, Edge).
 * 3. Robot Class            - Simulates keyboard actions using AWT.
 * 4. Browser Options        - Sets zoom level at browser startup (ChromeOptions).
 * 5. Touch Actions          - Simulates pinch and zoom on mobile.
 * 6. Element-Specific Zoom  - Zooms in on a specific web element.
 */

public class zoomInZoomOut {

	public static void main(String[] args) throws InterruptedException, AWTException {
		
		//WebDriver driver = new ChromeDriver();
		//driver.get("https://www.google.com");

// ==============================================================================================================================
// 1. Zoom In and Out using Actions Class (Keyboard Shortcuts)
// ==============================================================================================================================

		/*Actions action = new Actions(driver);

// ---- Zoom In (CTRL + "+")
		action.keyDown(Keys.CONTROL).sendKeys(Keys.ADD).keyUp(Keys.CONTROL).perform();
		Thread.sleep(2000);

// ---- Zoom Out (CTRL + "-")
		action.keyDown(Keys.CONTROL).sendKeys(Keys.SUBTRACT).keyUp(Keys.CONTROL).perform();
		Thread.sleep(2000);

// ---- Reset Zoom Level to Default (CTRL + "0")
        action.keyDown(Keys.CONTROL).sendKeys("0").keyUp(Keys.CONTROL).perform();
        Thread.sleep(2000);
		
// ==============================================================================================================================
// 2. Zoom In and Out using JavaScript Executor
// ==============================================================================================================================
		
//zoom in and zoom out using JavaScript Executor------------------------------------------------------
		
		//WebDriver driver = new ChromeDriver();
		//driver.get("https://www.google.com");
		
		driver.manage().window().maximize();
		JavascriptExecutor js = (JavascriptExecutor) driver;
		
// ---- Set the zoom level to 50%
        js.executeScript("document.body.style.zoom='50%'");  // Set the zoom level to 50%
        System.out.println("Zoom level set to 50%.");
        Thread.sleep(3000);                                  // Wait to observe the zoom change

// ---- Set the zoom level to 75%
        js.executeScript("document.body.style.zoom='0.75'"); // Set the zoom level to 75%
        System.out.println("Zoom level set to 75%.");
        Thread.sleep(3000);

// ---- Reset to default zoom level (100%)
        js.executeScript("document.body.style.zoom='100%'"); // Reset to default zoom level 
        Thread.sleep(3000);

// ---- Set the zoom level to 150%
        js.executeScript("document.body.style.zoom='1.5'");  // Set the zoom level to 150%
        System.out.println("Zoom level set to 150%.");
        Thread.sleep(3000);	                           		
       
// ==============================================================================================================================
// 3. Get the Current Zoom Level using JavaScript
   // verify the current zoom level of a page
// ==============================================================================================================================    
       
		//JavascriptExecutor js = (JavascriptExecutor) driver;
      
        String zoomLevel = js.executeScript("return document.body.style.zoom;").toString();
        System.out.println("Current Zoom Level: " + zoomLevel);
        // ✅ Note: This method might not work in Firefox.*/
		
// ==============================================================================================================================
// 4. zoom in and out in a specific element instead of the whole page
// ==============================================================================================================================
		
		WebDriver driver = new ChromeDriver();
		driver.get("https://testautomationpractice.blogspot.com/");
		driver.manage().window().maximize();
		
		JavascriptExecutor js = (JavascriptExecutor) driver;

// ---- Find the target element (Example element with ID "example")
        WebElement element = driver.findElement(By.xpath("//form[@id='Wikipedia1_wikipedia-search-form']"));

// ---- Zoom In on the specific element
        js.executeScript("arguments[0].style.transform='scale(2.5)'", element);
        System.out.println("Zoomed in on the specific element.");
        
//✅ zoom specific elements instead of the entire page.

// ==============================================================================================================================
// 5. Zoom In and Out using Robot Class (Simulating Keyboard Shortcuts)
// ==============================================================================================================================

        /*Robot robot = new Robot();
        
// ---- Zoom In (CTRL + "+")
        robot.keyPress(KeyEvent.VK_CONTROL);
        robot.keyPress(KeyEvent.VK_ADD);
        robot.keyRelease(KeyEvent.VK_ADD);
        robot.keyRelease(KeyEvent.VK_CONTROL);
        Thread.sleep(2000);

// ---- Zoom Out (CTRL + "-")
        robot.keyPress(KeyEvent.VK_CONTROL);
        robot.keyPress(KeyEvent.VK_SUBTRACT);
        robot.keyRelease(KeyEvent.VK_SUBTRACT);
        robot.keyRelease(KeyEvent.VK_CONTROL);
        Thread.sleep(2000);*/

        // ✅ The Robot class is useful when the Actions class doesn't work properly.	
		
        
        // Close the driver
        //driver.quit();
		
	}

}
