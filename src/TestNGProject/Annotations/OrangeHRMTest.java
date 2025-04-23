package testng.Annotations;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

/**
 * This TestNG class automates the OrangeHRM login functionality.
 *
 * Test Scenarios:
 * 1) Open Application
 * 2) Test Logo Presence
 * 3) Login
 * 4) Close Application
 */

	public class OrangeHRMTest {
 
		/*variable we have to create outside of the method. this driver becomes the common variable across all the methods 
        because this is an instance variable or class variable or class object we can access it in every method.*/
		
		WebDriver driver;     // Declare WebDriver instance at the class level to share across methods
		
// --------------------------------------------------------------------------------------------------------	
 /**
 * Step 1: Open the OrangeHRM application
 * - Launch Chrome browser
 * - Navigate to OrangeHRM login page
 * - Maximize the browser window
 */
// --------------------------------------------------------------------------------------------------------		
		@Test(priority=1)
		void openApp()
		{
			driver=new ChromeDriver();    // instantiation we have to do inside this method  
			driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
			driver.get("https://opensource-demo.orangehrmlive.com/web/index.php/auth/login");
			driver.manage().window().maximize();
			System.out.println("Application opened successfully.");
		}
// --------------------------------------------------------------------------------------------------------	
/**
 * Step 2: Verify that the company logo is displayed on the login page
 * - Wait for the page to load
 * - Check if the logo element is visible
 */
// --------------------------------------------------------------------------------------------------------		
		@Test(priority=2)
		void testlogo() throws InterruptedException
		{
			Thread.sleep(3000);
		    boolean status=driver.findElement(By.xpath("//img[@alt='company-branding']")).isDisplayed();
		    System.out.println("Logo Displayed: " + status);
		}
// --------------------------------------------------------------------------------------------------------		
/**
 * Step 3: Perform login action
 * - Enter username
 * - Enter password
 * - Click on login button
 */
// --------------------------------------------------------------------------------------------------------				
		@Test(priority=3)
		void testlogin()
		{
			driver.findElement(By.xpath("//input[@placeholder='Username']")).sendKeys("Admin");
			driver.findElement(By.xpath("//input[@placeholder='Password']")).sendKeys("admin123");
			driver.findElement(By.xpath("//button[@type='submit']")).click();
			System.out.println("Login successful.");
		}		
// --------------------------------------------------------------------------------------------------------			
 /**
 * Step 4: Close the application
 * - Close the browser window
 */
// --------------------------------------------------------------------------------------------------------			
		@Test(priority=4)
		void closeApp()
		{
			driver.close();
			System.out.println("Application closed successfully.");
		}
}
