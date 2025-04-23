package mSlider.Actions;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

/*
 * This example automates a vertical volume slider.

	Scenario:
	1. Open the Demo Vertical Slider.
	2. Move the slider upwards to increase volume.
	3. Move the slider downwards to decrease volume.
 */

public class VerticalSlider {

	public static void main(String[] args) {
		
		WebDriver driver = new ChromeDriver();
        driver.get("https://jqueryui.com/slider/#slider-vertical"); // Demo Vertical Slider
        driver.manage().window().maximize();
        
//----- Switch to the frame that contains the slider
        driver.switchTo().frame(0);
        
        Actions act = new Actions(driver);
        
        // Locate the vertical slider
        WebElement slider = driver.findElement(By.xpath("//span[@class='ui-slider-handle ui-corner-all ui-state-default']"));
        System.out.println("Before Moving: " + slider.getLocation()); // Print initial position
        
//----- Move slider UP (Negative Y offset) ---------------------------------------------
        act.dragAndDropBy(slider, 0, -50).perform();
        
//----- Move slider DOWN (Positive Y offset) --------------------------------------------
        act.dragAndDropBy(slider, 0, 50).perform();
        
        System.out.println("After Moving: " + slider.getLocation()); // Print new position
        
        //driver.quit();

        /*
         * Why this works?
			Switches inside an iframe before interacting.
			Moves UP using -yOffset and DOWN using +yOffset.
         */
	}

}
