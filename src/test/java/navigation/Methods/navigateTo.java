package navigation.Methods;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class navigateTo {

	public static void main(String[] args) throws InterruptedException {

		WebDriver driver = new ChromeDriver();  
		driver.navigate().to("https://www.google.com");
		System.out.println(driver.getCurrentUrl());
		driver.manage().window().maximize();
		
		driver.navigate().to("https://www.wikipedia.org");
		System.out.println(driver.getCurrentUrl());
		Thread.sleep(3000);
		
		driver.navigate().back();  // Navigates back to Google
		Thread.sleep(3000);
		
		driver.navigate().forward(); // Navigates forward to Wikipedia
		Thread.sleep(3000);
		
		driver.navigate().refresh(); // Refresh the page

//------Verify page load success using the title or URL of the page.-------------------------------
		
		/*driver.navigate().to("https://www.google.com");
		String expectedTitle = "Google";
		String actualTitle = driver.getTitle();
		if (actualTitle.equals(expectedTitle)) 
			{
			    System.out.println("Page loaded successfully!");
			} 
		else 
			{
			    System.out.println("Page did not load correctly.");
			}*/

		

	}

}
