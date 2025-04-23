package browserWindow.Management;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class deleteAllCookies {

	public static void main(String[] args) {
		
		WebDriver driver = new ChromeDriver();  //(CTRL+shift+O)	
		driver.get("https://www.youtube.com/");
		driver.manage().window().maximize();
		
		// Print total number of cookies before deletion
        System.out.println("Before deleting: " + driver.manage().getCookies().size());
        
        // Delete all cookies from the browser session
        driver.manage().deleteAllCookies();
        
        // Print total cookies after deletion
        System.out.println("After deleting: " + driver.manage().getCookies().size());
       // driver.quit();
	}

}
