package testng.Parameterization;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

/**
 * 🔁 Parallel & Cross-Browser Test Class
 * This test runs the same test methods across multiple browsers using TestNG XML configuration.
 */

public class ParallelTesting {

		WebDriver driver;
// =====================================================================================================
// Setup method to launch browser based on the parameter from XML file
// Setup method that accepts browser name via @Parameters and launches the browser accordingly.
// This method runs before any test method in the class.
// =====================================================================================================

		@BeforeClass
		@Parameters({"browser"})            // Accept browser parameter from TestNG XML
	    void setup(String Br) throws InterruptedException
		{
			switch(Br.toLowerCase()) {     // To avoid issues with case sensitivity. if there is a case mismatch.
			case "chrome":
                driver = new ChromeDriver();
                break;

            case "edge":
                driver = new EdgeDriver();
                break;

            case "firefox":
                driver = new FirefoxDriver();
                break;
			
			default: 
				//System.out.println("Invalid browser");return;
				System.out.println("❌ Invalid browser name provided: " + Br);
                throw new IllegalArgumentException("Unsupported browser: " + Br);
			}
			
			// Common browser settings
			driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
			driver.get("https://opensource-demo.orangehrmlive.com/web/index.php/auth/login");
			driver.manage().window().maximize();
			Thread.sleep(5000);
		}
		
// =====================================================================================================
// Test: Validate logo is displayed
// =====================================================================================================	
		@Test (priority=1)
		void testlogo() 
		{
			 boolean status = driver.findElement(By.xpath("//img[@alt='company-branding']")).isDisplayed(); 
			 //Assert.assertEquals(status, true);
			 Assert.assertTrue(status, "❌ Logo is not displayed");
		     System.out.println("✅ Logo is displayed");
		}		
// =====================================================================================================
// Test: validate page title.
// =====================================================================================================
		@Test (priority=2)
		void testtitle()
		{
			String expectedTitle = "OrangeHRM";
	        Assert.assertEquals(driver.getTitle(), expectedTitle, "❌ Title does not match");
	        System.out.println("✅ Title is correct: " + driver.getTitle());
			//Assert.assertEquals(driver.getTitle(),"OrangeHRM");
		}		
// =====================================================================================================
// Test: Validate current URL
// =====================================================================================================
		@Test (priority=3)
		void testUrl()
		{
			String expectedUrl = "https://opensource-demo.orangehrmlive.com/web/index.php/auth/login";
	        Assert.assertEquals(driver.getCurrentUrl(), expectedUrl, "❌ URL does not match");
	        System.out.println("✅ URL is correct: " + driver.getCurrentUrl());
			//Assert.assertEquals(driver.getCurrentUrl(),"https://opensource-demo.orangehrmlive.com/web/index.php/auth/login");
		}
// =====================================================================================================
// Cleanup method to close the browser after test execution.
// =====================================================================================================
		@AfterClass
		void teardown()
		{
			driver.quit();
			System.out.println("🔒 Browser closed successfully.");
		}
}
