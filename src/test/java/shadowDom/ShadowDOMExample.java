package shadowDom;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class ShadowDOMExample {

	public static void main(String[] args) {
		
		WebDriver driver = new ChromeDriver();
        driver.get("https://books-pwakit.appspot.com/");
        driver.manage().window().maximize();

        JavascriptExecutor js = (JavascriptExecutor) driver;

        // Locate the Shadow Host
        WebElement shadowHost = driver.findElement(By.tagName("book-app"));

        // Get the Shadow Root
        WebElement shadowRoot = (WebElement) js.executeScript("return arguments[0].shadowRoot", shadowHost);

        // Locate the search input inside Shadow DOM
        WebElement searchBox = shadowRoot.findElement(By.cssSelector("input"));

        // Enter text
        searchBox.sendKeys("Selenium Automation");

        // Close browser
        driver.quit();

	}

}
