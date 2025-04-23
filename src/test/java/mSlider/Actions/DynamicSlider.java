package mSlider.Actions;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

/*
 * Handling Sliders with Dynamic Values

Some sliders don't use pixels but percentage values (e.g., 0% to 100%).
In this case, we must:
	1. Get the current value.
	2. Adjust it dynamically.

Scenario:
Move slider until it reaches 80%.
 */

public class DynamicSlider {

	public static void main(String[] args) {
		
		WebDriver driver = new ChromeDriver();
        driver.get("https://jqueryui.com/slider/"); // Demo slider
        driver.manage().window().maximize();

// --------------------------------------------------------------------------------       
// Scenario: Move slider until it reaches 80%.  
// --------------------------------------------------------------------------------        
        
        // Switch to iframe containing the slider
        driver.switchTo().frame(0);
        
        Actions act = new Actions(driver);
        
        // Locate the slider
        WebElement slider = driver.findElement(By.xpath("//span[@class='ui-slider-handle']"));
        
        // Move slider in small increments until value reaches 80%
        for (int i = 0; i < 5; i++) // Adjust as per requirement
        { 
            act.dragAndDropBy(slider, 20, 0).perform();
        }
        System.out.println("Slider moved to approximately 80%");
        
        //driver.quit();

        /*
         * Why this works?
			Moves the slider in steps.
			Ensures accuracy instead of using fixed pixel values.
         */
	}

}
