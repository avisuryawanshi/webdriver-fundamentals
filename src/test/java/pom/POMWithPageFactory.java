package pom;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

/**
 * Login Page Object using PageFactory
 */

public class POMWithPageFactory {
	
		WebDriver driver;
// ------------------------------------------------------------------------------------------------------	
	    
		// Constructor to initialize elements
	    public POMWithPageFactory(WebDriver driver) 
	    {
	        this.driver = driver;
	        PageFactory.initElements(driver, this); // Initializes @FindBy elements
	    }
	
// ------------------------------------------------------------------------------------------------------
	    // Locators using @FindBy annotation
	    /*@FindBy(name = "username")
	    WebElement usernameField;
	
	    @FindBy(name = "password")
	    WebElement passwordField;
	
	    @FindBy(xpath = "//button[@type='submit']")
	    WebElement loginButton;
	
// ------------------------------------------------------------------------------------------------------
	    // Action method to enter username
	    public void setUserName(String username) {
	        System.out.println("Entering username: " + username);
	        usernameField.sendKeys(username);
	    }
	
	    // Action method to enter password
	    public void setPassword(String password) {
	        System.out.println("Entering password.");
	        passwordField.sendKeys(password);
	    }
	
	    // Action method to click login button
	    public void clickLogin() {
	        System.out.println("Clicking login button.");
	        loginButton.click();
	    }
	
// ------------------------------------------------------------------------------------------------------
	    // Combined method
	    public void login(String username, String password) {
	        setUserName(username);
	        setPassword(password);
	        clickLogin();
	    }*/

}
