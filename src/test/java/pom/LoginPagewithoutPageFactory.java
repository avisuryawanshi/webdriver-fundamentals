package pom;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

// page object class
public class LoginPagewithoutPageFactory {

	WebDriver driver;   //this driver is class variable 
	
// ------------------------------------------------------------------------------------------------------	
// 1. constructor
// ------------------------------------------------------------------------------------------------------
	LoginPagewithoutPageFactory(WebDriver driver)   //this driver is local variable
	{
	    this.driver = driver;	
	}
// ------------------------------------------------------------------------------------------------------	
// 2. Locators
// ------------------------------------------------------------------------------------------------------
	By txt_username_loc = By.xpath("//input[@placeholder='Username']");
	By txt_password_loc = By.xpath("//input[@placeholder='Password']");
	By btn_login_loc    = By.xpath("//button[@type='submit']");
	
// ------------------------------------------------------------------------------------------------------	
// 3. Actions methods
// ------------------------------------------------------------------------------------------------------	
	public void setUserName(String user)
	{
		driver.findElement(txt_username_loc).sendKeys(user);  	   
	}
	
	// Similarly, we create another action method for the password:
	public void setPassword(String pwd)                                                          
	{
		driver.findElement(txt_password_loc).sendKeys(pwd);
	}
	
	// Lastly, we create an action method for clicking the login button:
	public void clickLogin()
	{
		driver.findElement(btn_login_loc).click();
	}
	
}

