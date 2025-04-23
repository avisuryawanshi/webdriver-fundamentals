package testng.Parameterization;

import java.time.Duration;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

/**
 * Data Provider Method:
 * This method supplies multiple sets of login credentials.
 * Data is hardcoded directly into the method for simplicity.
 * You can also select specific rows using the 'indices' attribute.
 */

public class HardcodedDataProviderEg {

	    WebDriver driver;
	
// Precondition: Launch browser and set implicit wait
// ------------------------------------------------------------------------------------------------------------	   
	    @BeforeClass
	    void setup() {
	        driver = new ChromeDriver();
	        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
	        System.out.println("=== Browser Launched and Setup Completed ===");
	    }
	
// Test Method: Executes login functionality using data from DataProvider
// ------------------------------------------------------------------------------------------------------------	    
	    @Test(dataProvider = "loginData")
	    void testLogin(String email, String password) throws InterruptedException {
	        
	    	driver.get("https://tutorialsninja.com/demo/index.php?route=account/login");
	        driver.manage().window().maximize();
	        driver.findElement(By.xpath("//input[@id='input-email']")).sendKeys(email);
	        driver.findElement(By.xpath("//input[@id='input-password']")).sendKeys(password);
	        driver.findElement(By.xpath("//input[@value='Login']")).click();
	        Thread.sleep(3000);
	        boolean status = driver.findElement(By.xpath("//a[@class='list-group-item'][normalize-space()='My Account']")).isDisplayed();
	        
	        if (status) 
	        {
	            driver.findElement(By.xpath("//a[@class='list-group-item'][normalize-space()='Logout']")).click(); // Logout after successful login
	            Assert.assertTrue(true);
	        } 
	        else 
	        {
	        	System.out.println("Login failed for user: " + email);
	            Assert.fail("Login failed!"); // Provide a failure message
	        }
	    }
	
// Postcondition: Close browser after all tests
// ------------------------------------------------------------------------------------------------------------		   
	    @AfterClass
	    void tearDown() 
	    {
	        driver.close();
	    }

// ------------------------------------------------------------------------------------------------------------
// Data Provider Method: 
// Option A: Use all inputs (default) 
// ------------------------------------------------------------------------------------------------------------    
	    // *--failed--*
	    /*@DataProvider(name = "loginData")
	    public Object[][] provideLoginData() {
	        return new Object[][]
	        {
	                {"abc@gmail.com", "test@123"},   //test inputs
	                {"avi.suryawanshi635113@gmail.com", "Test@29"},
	                {"xyz@gmail.com", "test123"},
	                {"pavano1123@gmail.com", "test@123"},
	                {"johncanedy@gmail.com", "test"}
	        };*/

// ------------------------------------------------------------------------------------------------------------
// Option B: Use specific inputs by index	        
// I want to execute, suppose 2 or 3 inputs or a specific input
// ------------------------------------------------------------------------------------------------------------
    
	    //@DataProvider(name = "loginData" , indices= {1})
	    //@DataProvider(name = "loginData" , indices= {0,4})
	    @DataProvider(name = "loginData" , indices= {0,1,2,3,4})
	    //@DataProvider(name = "loginData" , indices= {1,4}) // Specify the indices you want to run
	    
	    public Object[][] provideLoginData() {
	        return new Object[][]{									  //test inputs, array indexing starting from 0
	                {"abc@gmail.com", "test@123"},                    //0 
	                {"avi.suryawanshi635113@gmail.com", "Test@29"},   //1
	                {"xyz@gmail.com", "test123"},                     //2
	                {"pavano1123@gmail.com", "test@123"},             //3
	                {"rj123@gmail.com", "Ravina"}                     //4
	        };
	    }
}
