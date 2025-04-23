package pom;

import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

// login test cases without using Page factory
public class LoginTestCaseWithoutPageFactory {

	    WebDriver driver;
		
		@BeforeClass()
		void setup()
		{
			driver = new ChromeDriver();
	        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
	        driver.manage().window().maximize();
	        driver.get("https://opensource-demo.orangehrmlive.com/web/index.php/auth/login");
	        System.out.println("Browser launched and navigated to login page.");
		}
		
		@Test()
		void testlogin()
		{
			//POMWithoutPageFactory lp = new POMWithoutPageFactory(driver);
			LoginPagewithoutPageFactory lp = new LoginPagewithoutPageFactory(driver);
	        lp.setUserName("Admin");
	        lp.setPassword("admin123");
	        lp.clickLogin();
	        
	        String expectedTitle = "OrangeHRM";
	        String actualTitle = driver.getTitle();
	        System.out.println("Validating page title after login...");
	        Assert.assertEquals(actualTitle, expectedTitle, "Login failed or title mismatch.");
			//Assert.assertEquals(driver.getTitle(), "OrangeHRM");
		}
		
		@AfterClass()
		void tearDown()
		{
			driver.quit();
		}
}
