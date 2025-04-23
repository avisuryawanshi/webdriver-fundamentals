package shadowDom;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class WaitForShadowDOM {

	public static void main(String[] args) {
		
		WebDriver driver = new ChromeDriver();
        driver.get("https://example.com/dynamic-shadow"); // Replace with real site URL
        driver.manage().window().maximize();

        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        JavascriptExecutor js = (JavascriptExecutor) driver;

        // Wait for Shadow Host to be present
        WebElement shadowHost = wait.until(ExpectedConditions.presenceOfElementLocated(By.cssSelector("shadow-host")));

        // Get the Shadow Root
        WebElement shadowRoot = (WebElement) js.executeScript("return arguments[0].shadowRoot", shadowHost);

        // Locate an element inside Shadow DOM
        WebElement button = shadowRoot.findElement(By.cssSelector("button"));
        button.click();

        driver.quit();
	}

}
