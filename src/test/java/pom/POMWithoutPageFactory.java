package pom;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

/**
 * Page Object Model without using PageFactory.
 * This class models a Login Page with:
 * - A username input field
 * - A password input field
 * - A login button
 */

/*
 *  1. we can absolutely create a Page Object Class without using PageFactory by simply using regular WebElement declarations and initializing them using the driver.findElement() method inside methods.
	2. Instead of using @FindBy and PageFactory.initElements(), I just use regular WebDriver calls like driver.findElement() inside custom methods for each action.
	3. So we’re not using @FindBy annotations or PageFactory.initElements().
	4. Instead, we’re just relying on normal WebDriver API calls. This approach gives us more control, and can sometimes be easier to debug.

Here's how I usually structure it:
	• First, I declare a WebDriver instance in the class.
	• Then I define methods for each interaction — for example, enterUsername(), clickLogin(), etc.
Inside those methods, I locate elements using driver.findElement(By.xpath("...")) or any other strategy.
 */

public class POMWithoutPageFactory {
			
		private WebDriver driver;    //this driver is class variable. WebDriver instance used to interact with the browser

// ------------------------------------------------------------------------------------------------------
// 1) Constructor 
// Constructor: receives WebDriver from the test class and assigns it to the class variable.
// parameter name (driver) is the same as the class variable, we use the this keyword to differentiate between the two. 
// So, this.driver = driver; assigns the passed WebDriver instance to the class-level variable.
// ------------------------------------------------------------------------------------------------------
		
	    POMWithoutPageFactory(WebDriver driver)    //this driver is local variable
	    {
	        this.driver = driver;     
	    }
// ------------------------------------------------------------------------------------------------------
// 2) Locators: for login page elements
// ------------------------------------------------------------------------------------------------------		
	    private By usernameField = By.xpath("//input[@placeholder='Username']");
	    private By passwordField = By.xpath("//input[@placeholder='Password']");
	    private By loginButton   = By.xpath("//button[normalize-space()='Login']");		   
// ------------------------------------------------------------------------------------------------------	
// 3) Actions Methods
// ------------------------------------------------------------------------------------------------------	    
	    public void enterUsername(String username) {
	        driver.findElement(usernameField).sendKeys(username);
	    }
	
	    // Similarly, we create another action method for the password:
	    public void enterPassword(String password) {
	        driver.findElement(passwordField).sendKeys(password);
	    }
	
	    // Lastly, we create an action method for clicking the login button:
	    public void clickLoginButton() {
	        driver.findElement(loginButton).click();
	    }
// ------------------------------------------------------------------------------------------------------	
// Combined login method to perform all login steps
// ------------------------------------------------------------------------------------------------------
	    public void login(String username, String password) {
	        enterUsername(username);
	        enterPassword(password);
	        clickLoginButton();
	    }
		

}
