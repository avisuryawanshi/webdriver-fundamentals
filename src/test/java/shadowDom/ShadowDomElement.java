package shadowDom;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.SearchContext;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class ShadowDomElement {

	public static void main(String[] args) throws InterruptedException {
		
		WebDriver driver=new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		driver.manage().window().maximize();
		driver.get("https://books-pwakit.appspot.com/explore?q=");

		//This Element is inside single shadow DOM.
		//String cssSelectorForHost1 = "book-app[apptitle='BOOKS']";
		//Thread.sleep(1000);
		
		//driver.findElement(By.cssSelector("#input")).sendKeys("WELCOME"); throwing no such element exception
		
		// Access the element inside a single Shadow DOM
		SearchContext shadow = driver.findElement(By.cssSelector("book-app[apptitle='BOOKS']")).getShadowRoot();
		Thread.sleep(1000);
		
		// Interact with the input element inside the Shadow DOM
		shadow.findElement(By.cssSelector("#input")).sendKeys("WELCOME");
		
		// Perform your test actions
		System.out.println("Title of the page: " + driver.getTitle());

	}

}
