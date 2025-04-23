package pom;

/*✅ Scenario: Login Page with
	Username input
	Password input
	Login button
*/

import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;

// Another approach -using page factory

public class LoginPage1UsingPageFactory {

		WebDriver driver;   //this driver is class variable 

// ------------------------------------------------------------------------------------------------------
// 1) Constructor
// ------------------------------------------------------------------------------------------------------
	   
		LoginPage1UsingPageFactory(WebDriver driver)   //this driver is local variable
		{
		    this.driver = driver;	
		    PageFactory.initElements(driver, this); // Initialize @FindBy elements using PageFactory. //MANDATORY
		}
		
// ------------------------------------------------------------------------------------------------------
// 2) Locators using @FindBy annotation  
// ------------------------------------------------------------------------------------------------------
		/*@FindBy(xpath="//input[@placeholder='Username']") 
	    WebElement txt_username_loc;*/
	    
	    //another approach using @FindBy annotation with How Keyword
	    @FindBy(how=How.XPATH, using="//input[@placeholder='Username']")  //Another way of Locating WebElement using Find by
	    WebElement txt_username_loc;
	    
	    @FindBy(xpath="//input[@placeholder='Password']") 
	    WebElement txt_password_loc;
	    
	    @FindBy(xpath="//button[@type='submit']") 
	    WebElement btn_login_loc;
	    
		//capture all the links on the webpage 
	    @FindBy(tagName="a")
	    List<WebElement> links;

// ------------------------------------------------------------------------------------------------------    
// 3) Actions methods
// ------------------------------------------------------------------------------------------------------
		public void setUserName(String user)
		{
			txt_username_loc.sendKeys(user);  	   
		}
		
		public void setPassword(String pwd)                                                          
		{
			txt_password_loc.sendKeys(pwd);
		}
		
		public void clickLogin()
		{
		btn_login_loc.click();
		}
		
		// Combined method
	    public void login(String username, String password) {
	        setUserName(username);
	        setPassword(password);
	        clickLogin();
	    }
	
}
