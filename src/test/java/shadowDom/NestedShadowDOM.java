package shadowDom;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class NestedShadowDOM {

	public static void main(String[] args) {
		
		WebDriver driver = new ChromeDriver();
        driver.get("https://example.com/nested-shadow"); // Replace with real site URL
        driver.manage().window().maximize();

        JavascriptExecutor js = (JavascriptExecutor) driver;

        // Locate Outer Shadow Host
        WebElement outerHost = driver.findElement(By.cssSelector("outer-element"));
        WebElement outerRoot = (WebElement) js.executeScript("return arguments[0].shadowRoot", outerHost);

        // Locate Inner Shadow Host inside Outer Shadow DOM
        WebElement innerHost = outerRoot.findElement(By.cssSelector("inner-element"));
        WebElement innerRoot = (WebElement) js.executeScript("return arguments[0].shadowRoot", innerHost);

        // Find and click the button inside Inner Shadow DOM
        WebElement submitButton = innerRoot.findElement(By.cssSelector("button.submit"));
        submitButton.click();

        driver.quit();

	}

}
