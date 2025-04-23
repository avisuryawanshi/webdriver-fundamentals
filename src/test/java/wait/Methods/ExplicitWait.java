package wait.Methods;

//---------------------------------------------------------------------------------------------------------
//Scenario: Using Explicit Wait in Selenium WebDriver
//---------------------------------------------------------------------------------------------------------
//1. Open the OrangeHRM login page.
//2. Use Explicit Wait to wait until elements are visible before interacting with them.
//3. Enter the username and password.
//4. Wait for the login button to be clickable and then click it.


import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class ExplicitWait {

	public static void main(String[] args) {
	
		WebDriver driver=new ChromeDriver();
		
		WebDriverWait wait=new WebDriverWait(driver,Duration.ofSeconds(10)); //declartion
		
		driver.get("https://opensource-demo.orangehrmlive.com/web/index.php/auth/login");
        driver.manage().window().maximize();
        
//----- Step 1: Wait for Username Field to be Visible and Enter Username
        WebElement username=wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//input[@placeholder='Username']")));
		username.sendKeys("Admin");
		
//----- Step 2: Wait for Password Field to be Visible and Enter Password
		WebElement password=wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//input[@placeholder='Password']")));
		password.sendKeys("admin123");
		
//----- Step 3: Wait for Login Button to be Clickable and Click
		WebElement login=wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//button[normalize-space()='Login']")));
		login.click();
		 
		//driver.findElement(By.xpath("//input[@placeholder='Username']")).sendKeys("Admin"); not need write this method separately why bcoz explicit wait return the element that we are going to access directly-> username.sendKeys("Admin");
		//driver.close();
		

	}

}
