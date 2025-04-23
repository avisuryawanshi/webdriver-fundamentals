package browserWindow.Management;

import org.openqa.selenium.Dimension;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class maximizeWindow {

	public static void main(String[] args) {
		
		WebDriver driver = new ChromeDriver();
		driver.get("https://www.google.com");
		driver.manage().window().maximize(); // Maximizes the browser window

		//driver.manage().window().minimize(); // Minimizes the browser window
		
		//call maximize() before opening a URL 
		/*WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize(); // Maximized before opening the URL
		driver.get("https://www.google.com");*/  //recommended to maximize after opening the URL.


		//verify if a window is maximized
		//We can compare the current window size with the screen resolution.
		Dimension screenSize = driver.manage().window().getSize();
		System.out.println("Window Size: " + screenSize.getWidth() + "x" + screenSize.getHeight());
	
		//✅ If the window size matches the screen resolution, the window is maximized.
	
	
	}

}
