package wait.Methods;

//---------------------------------------------------------------------------------------------------------
//Scenario: Using Implicit Wait in Selenium WebDriver
//---------------------------------------------------------------------------------------------------------
//1. Open the OrangeHRM login page.
//2. Use Implicit Wait to handle dynamic element loading.
//3. Enter the username in the login field.

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class ImplicitWait {

	public static void main(String[] args) {
		
		WebDriver driver=new ChromeDriver();
		
//----- Set Implicit Wait to 5 seconds (applies globally to all elements)
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5)); // we can just specify only one time at the beginning after creating the driver instance
		
		driver.get("https://opensource-demo.orangehrmlive.com/web/index.php/auth/login");
        driver.manage().window().maximize();
        driver.findElement(By.xpath("//input[@placeholder='Username']")).sendKeys("Admin");
        driver.quit();
        
        


		

	}

}
