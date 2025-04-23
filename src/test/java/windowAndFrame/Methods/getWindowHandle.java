package windowAndFrame.Methods;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class getWindowHandle {

	public static void main(String[] args) {
		
		WebDriver driver = new ChromeDriver();
		driver.get("https://opensource-demo.orangehrmlive.com/web/index.php/auth/login");
		driver.manage().window().maximize();
		
		//getWindowHandle( )-Returns ID of the single browser window
		String windowid=driver.getWindowHandle();
		System.out.println("Window Id:" +windowid);

		driver.quit();

//---------------------------------------------------------------------------------------------------------
// Example: Calling getWindowHandle() after closing the browser window throws *NoSuchWindowException*
//---------------------------------------------------------------------------------------------------------		
		
		//driver.close();
		//System.out.println(driver.getWindowHandle()); // This will throw NoSuchWindowException
		
	}
}
