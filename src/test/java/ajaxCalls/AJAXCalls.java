package ajaxCalls;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class AJAXCalls {

	public static void main(String[] args) {
		
		WebDriver driver = new ChromeDriver();
        
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10)); 
        driver.get("https://testautomationpractice.blogspot.com/p/gui-elements-ajax-hidden.html");
        driver.manage().window().maximize();
        
        driver.findElement(By.xpath("//button[@id='loadContent']")).click();   // Trigger an Ajax call
        WebElement loadedElement=driver.findElement(By.xpath("//h2[normalize-space()='AJAX Content Loaded']")); 
        
        System.out.println("Loaded Content: " + loadedElement.getText()); //Loaded Content: AJAX Content Loaded
        
        driver.quit();
        
/*------//Wait for the Ajax content to load- if you get Exception
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10)); // Use explicit wait to handle the dynamic element
        WebElement loadedElement = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//h2[@id='ajax-content']")));
        System.out.println(loadedElement.getText());*/   //AJAX Content Loaded      
	}

}
