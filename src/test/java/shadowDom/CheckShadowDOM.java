package shadowDom;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class CheckShadowDOM {

	public static void main(String[] args) {
		
		WebDriver driver = new ChromeDriver();
        driver.get("https://example.com");

        JavascriptExecutor js = (JavascriptExecutor) driver;

        // JavaScript code to check if an element is inside Shadow DOM
        boolean isShadow = (boolean) js.executeScript( "return !!document.querySelector('shadow-host').shadowRoot");
        
        System.out.println("Is the element inside Shadow DOM? " + isShadow);

        driver.quit();
		

	}

}
