package alerts;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

/**
 * This class demonstrates handling authentication pop-ups in Selenium WebDriver.
 * 
 * Authentication pop-ups require users to enter a username and password before 
 * accessing a webpage. Selenium does not provide a direct method to handle these pop-ups,
 * but we can bypass authentication by embedding credentials in the URL.
 */

public class HandleAuthenticationPopUps {

	public static void main(String[] args) {
		
		WebDriver driver=new ChromeDriver();
		driver.manage().window().maximize();
	
// =========================================================================================================================
// 1) Accessing the authentication-protected page without passing credentials
// =========================================================================================================================

        // If we try to access this URL without credentials, a login pop-up will appear		
		//driver.get("https://the-internet.herokuapp.com/basic_auth"); //withoud passing username and password
		
// =========================================================================================================================		
// 2) Handling Authentication Pop-ups using Embedded Credentials
// =========================================================================================================================
		
		// To bypass the authentication pop-up, embed the username and password in the URL:
        // Format: https://username:password@URL
		driver.get("https://admin:admin@the-internet.herokuapp.com/basic_auth"); //with passing username and password
		driver.quit(); // Close the browser session
		
		// Note:--------------------
        // - "admin" is the username
        // - "admin" is the password
        // - "the-internet.herokuapp.com/basic_auth" is the target URL

        // This method only works for HTTP Basic Authentication pop-ups.

	}

}
