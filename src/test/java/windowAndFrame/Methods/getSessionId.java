package windowAndFrame.Methods;

import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.remote.SessionId;

public class getSessionId {

	public static void main(String[] args) {
		
		//WebDriver driver = new ChromeDriver(); // WebDriver instance  
		//System.out.println(driver.getSessionId()); // This will NOT workge->>tSessionId() is not available in the WebDriver interface
		
		/* NOTE:
		    🔹 getSessionId() is mainly used with RemoteWebDriver to track and manage WebDriver sessions.
			🔹 It is helpful in Selenium Grid, logging, and debugging test execution.
			🔹 After closing the browser, calling getSessionId() returns null.
			🔹 Not available in WebDriver directly—must use RemoteWebDriver.
		 */
		
		RemoteWebDriver driver = new ChromeDriver(); // Typecasting WebDriver to RemoteWebDriver
		SessionId session = driver.getSessionId();
		
		System.out.println("Session ID: " + session.toString());
        System.out.println("Session ID: " + driver.getSessionId()); // Fetching session ID
        
        driver.quit();

	}

}
