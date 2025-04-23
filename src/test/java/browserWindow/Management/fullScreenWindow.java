package browserWindow.Management;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class fullScreenWindow {

	public static void main(String[] args) {
		
		WebDriver driver = new ChromeDriver();
		driver.get("https://www.google.com");

		driver.manage().window().fullscreen(); // Fullscreen mode

        // Use fullscreen() if you want to remove all distractions. 
		// Expands the browser to true full screen, hiding UI elements like the taskbar.
	}

}
