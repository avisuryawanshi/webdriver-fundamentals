package mSlider.Actions;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

/*
 * JavaScript-Based Slider (When Actions Class Fails)
	
	Some sliders don't work well with dragAndDropBy(). In those cases, JavaScript can directly set the value.
	Scenario:
	1. Open range slider.
	2. Use JavaScript to set slider value without dragging.
 */
public class JSExecutorSlider {

	public static void main(String[] args) {
		
		WebDriver driver = new ChromeDriver();
        driver.get("https://www.seleniumeasy.com/test/drag-drop-range-sliders-demo.html");
        driver.manage().window().maximize();

        // Locate slider
        WebElement slider = driver.findElement(By.xpath("//input[@type='range']"));

//------------------------------------------------------------------------------------------------       
        // Use JavaScript to set slider value
//------------------------------------------------------------------------------------------------
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("arguments[0].value='50';", slider);

        // Get the new slider value
        String value = slider.getDomAttribute("value");
        System.out.println("Slider moved to: " + value);

        //driver.quit();
        
        /*
         * Why use JavaScript?
			-Some sliders don't respond to dragAndDropBy().
			-Directly sets slider value attribute.
         */

	}

}
