package mSlider.Actions;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

public class SliderEg {

	public static void main(String[] args) {
		
        WebDriver driver = new ChromeDriver();
        driver.get("https://www.jqueryscript.net/demo//Price-Range-Slider-jQuery-UI/");
        driver.manage().window().maximize();

        Actions act = new Actions(driver);

// ===========================================================================================================================
// Handling the Minimum Price Slider
// ===========================================================================================================================

        // Locate the minimum price slider element
        WebElement min_slider = driver.findElement(By.xpath("//div[@class='price-range-block']//span[1]"));

//----- Capture and print the initial location of the minimum slider
        int minSliderXBefore = min_slider.getLocation().getX();
        System.out.println("Initial Min Slider Location: " + minSliderXBefore);

//----- Move the minimum slider 50 pixels to the right
        act.dragAndDropBy(min_slider, 50, 0).perform();

//----- Capture and print the new location of the minimum slider after movement
        int minSliderXAfter = min_slider.getLocation().getX();
        System.out.println("New Min Slider Location: " + minSliderXAfter);

        // Validation: Check if the slider actually moved
        if (minSliderXAfter > minSliderXBefore) 
        {
            System.out.println("✅ Min slider moved successfully.");
        } 
        else 
        {
            System.out.println("❌ Min slider did not move correctly.");
        }

// ===========================================================================================================================
// Handling the Maximum Price Slider
// ===========================================================================================================================

        // Locate the maximum price slider element
        WebElement max_slider = driver.findElement(By.xpath("//span[2]"));

//----- Capture and print the initial location of the maximum slider
        int maxSliderXBefore = max_slider.getLocation().getX();
        System.out.println("Initial Max Slider Location: " + maxSliderXBefore);

//----- Move the maximum slider 50 pixels to the left
        act.dragAndDropBy(max_slider, -50, 0).perform();

//----- Capture and print the new location of the maximum slider after movement
        int maxSliderXAfter = max_slider.getLocation().getX();
        System.out.println("New Max Slider Location: " + maxSliderXAfter);

        // Validation: Check if the slider actually moved
        if (maxSliderXAfter < maxSliderXBefore) 
        {
            System.out.println("✅ Max slider moved successfully.");
        } 
        else 
        {
            System.out.println("❌ Max slider did not move correctly.");
        }

        // ----------------------------------------------------------------------------------
        // Notes:
        // - `dragAndDropBy(element, xOffset, yOffset)` is used to move sliders.
        // - `xOffset`: Moves slider horizontally (positive for right, negative for left).
        // - `yOffset`: Remains `0` as vertical movement is not needed.
        // - The validation confirms if the sliders have moved by comparing before and after positions.
        // ----------------------------------------------------------------------------------

        // Close the browser
        //driver.quit();

	}

}
