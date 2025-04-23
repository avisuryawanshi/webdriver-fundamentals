package browserWindow.Management;

import org.openqa.selenium.Dimension;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

public class setSize {

	public static void main(String[] args) {
		
		 WebDriver driver = new ChromeDriver();
	     driver.get("https://opensource-demo.orangehrmlive.com/web/index.php/auth/login");
	     
//1st Approach----------------------------------------------------------------------		
	     // Set browser window size to 1024x768
	     Dimension d = new Dimension(1366, 768);
	     driver.manage().window().setSize(d);
	     System.out.println("Window size set to: " + driver.manage().window().getSize());
	     //driver.quit();

//2nd Approach-----change the browser window size dynamically------------------------

	     //driver.manage().window().setSize(new Dimension(1366, 768));
	     
//3rd Approach----------------------------------------------------------------------- 
//verify that the browser window has been resized correctly using assertions.
	     /*Dimension expectedSize = new Dimension(1366, 768);
	     Dimension actualSize = driver.manage().window().getSize();
	     Assert.assertEquals(actualSize, expectedSize, "Window size mismatch!");*/
	     
//4th Approach-----------------------------------------------------------------------      
//pass negative or zero values in Dimension
	     
	     /*Dimension d1 = new Dimension(-800, 600);  // Invalid 
	     driver.manage().window().setSize(d1);   //throw an IllegalArgumentException*/
//--------------------------------------------------------------------------------------	     
	     /*try 
	     	{
	        // Trying to set an invalid window size (negative width)---------------
	            Dimension d2 = new Dimension(-800, 600);  // Invalid size
	            driver.manage().window().setSize(d2);
	        } 
	     catch (IllegalArgumentException e) 
	     	{
	            System.out.println("❌ Caught IllegalArgumentException: " + e.getMessage());
	        }*/
//5th Approach------* set the window size in headless mode *-----------------------------------------------------------------
	     
	     /*ChromeOptions options = new ChromeOptions();
	     options.addArguments("--headless");
	     WebDriver driver = new ChromeDriver(options);
	     driver.get("https://opensource-demo.orangehrmlive.com/web/index.php/auth/login");
	     // Set window size in headless mode
	     driver.manage().window().setSize(new Dimension(1200, 800));*/   
	     
	}
}
