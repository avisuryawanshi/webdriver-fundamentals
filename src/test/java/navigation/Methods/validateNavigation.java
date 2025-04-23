package navigation.Methods;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class validateNavigation {

	public static void main(String[] args) {
		
		WebDriver driver = new ChromeDriver();  
	
		driver.navigate().to("https://www.google.com");
		System.out.println(driver.getCurrentUrl());
		driver.manage().window().maximize();
		
		String googleTitle = driver.getTitle();
		driver.navigate().to("https://www.wikipedia.org");
		System.out.println(driver.getCurrentUrl());
		
		String wikiTitle = driver.getTitle();
		driver.navigate().back();
		if (driver.getTitle().equals(googleTitle)) 
			{
			    System.out.println("Back navigation successful!");
			}
		
		driver.navigate().forward();
		if (driver.getTitle().equals(wikiTitle)) 
			{
			    System.out.println("Forward navigation successful!");
			}
		
		driver.navigate().refresh();
		System.out.println("Page refreshed successfully!");


	}

}
