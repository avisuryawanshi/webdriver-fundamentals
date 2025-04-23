package ajaxCalls;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class GooglesAJAXsearch {

	public static void main(String[] args) {
		
		WebDriver driver = new ChromeDriver();
		driver.get("https://www.google.com/");
		
		WebElement searchBox = driver.findElement(By.name("q")); 
		searchBox.sendKeys("Selenium WebDriver");

		// Wait for AJAX suggestions to appear
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));
		WebElement suggestion = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//ul[@role='listbox']/li[1]")));
		
		// Click on the first suggestion
		suggestion.click();
		
		System.out.println("First suggestion clicked, navigating to search results.");
		
		// Verify search results page is displayed
        //wait.until(ExpectedConditions.titleContains("Selenium WebDriver"));
        //System.out.println("Search results page loaded successfully.");


	}

}
