package testng.Listners;

/*
 * Scenario:
 * This test class is designed to validate the OrangeHRM application's basic UI elements and behaviors.
 * The flow includes:
 * 1. Launching the application
 * 2. Validating if the logo is displayed (Expected to Pass)
 * 3. Verifying the current URL (Intentionally Failing)
 * 4. Checking the Home Page Title (Skipped due to dependency on the failed test)
 * 5. Closing the browser
 * 
 * Objective:
 * To demonstrate how different test outcomes (Pass, Fail, Skip) are handled and observed,
 * especially when used with TestNG Listeners.
 */

import java.time.Duration;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class OrangeHRMListeners {

		WebDriver driver;    
	    
	    @BeforeClass
	    void setup() throws InterruptedException{
	    
	    	driver=new ChromeDriver();    
		    driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		    driver.get("https://opensource-demo.orangehrmlive.com/web/index.php/auth/login");
		    driver.manage().window().maximize();
		    Thread.sleep(3000);
	    }
// ================================================================================================================================	
// Test 1: Validate Logo - Expected to PASS - Checks if the logo is visible on the login page
// ================================================================================================================================	
	    
	    @Test(priority=1)
	    void testlogo() throws InterruptedException
		    {
		       boolean status=driver.findElement(By.xpath("//img[@alt='company-branding']")).isDisplayed();
			   Assert.assertEquals(status, true, "❌ Logo is NOT displayed!");
		       System.out.println("✅ Logo is displayed successfully.");
		    }
// ================================================================================================================================	
// Test 2: Validate Application URL - Expected to FAIL - Intentionally causes failure by providing an incorrect URL	    
// ================================================================================================================================	
	
	    @Test(priority=2)
	    void testAppUrl()
		    {
		    	Assert.assertEquals(driver.getCurrentUrl(),"https://opensource-demo.orangehrmlive.com/");
		    }

// ================================================================================================================================
// Test 3: Validate Home Page Title - Will be SKIPPED if 'testAppUrl' fails - Depends on 'testAppUrl' 
// ================================================================================================================================
	    
	    @Test(priority=3, dependsOnMethods= {"testAppUrl"})
	    void testHomePageTitle()
	    {
	    	Assert.assertEquals(driver.getTitle(),"OrangeHRM");
	    }
	    
// ================================================================================================================================	    
// Tear Down - Closes the browser after test execution
// ================================================================================================================================
	    @AfterClass
	    void teardown()
	    {
	    	driver.quit();
	    	System.out.println("✅ Browser closed successfully.");
	    }	
}
