package mSlider.Actions;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

/*
 * This example moves both the minimum and maximum range sliders on a price range filter.

	Scenario:
	- Open the jQuery Price Range Slider demo.
	- Adjust Min Slider (move right).
	- Adjust Max Slider (move left).
	- Print slider positions before and after movement.
 */

public class PriceRangeSlider {

	public static void main(String[] args) {
		
		WebDriver driver = new ChromeDriver();
        driver.get("https://www.jqueryscript.net/demo/Price-Range-Slider-jQuery-UI/");
        driver.manage().window().maximize();

        Actions act = new Actions(driver);

        //Horizontal
        // Locate the Min and Max sliders
        WebElement minSlider = driver.findElement(By.xpath("//div[@class='price-range-block']//span[1]"));
        WebElement maxSlider = driver.findElement(By.xpath("//div[@class='price-range-block']//span[2]"));

        // Print initial positions
        System.out.println("Before Moving:");
        System.out.println("Min Slider Position: " + minSlider.getLocation());
        System.out.println("Max Slider Position: " + maxSlider.getLocation());

        // Move sliders
        act.dragAndDropBy(minSlider, 50, 0).perform();  // Move Min slider to right (increase minimum price)
        act.dragAndDropBy(maxSlider, -50, 0).perform(); // Move Max slider to left (decrease maximum price)

        // Print the new positions of the sliders after movement
        System.out.println("After Moving:");
        System.out.println("Min Slider Position: " + minSlider.getLocation());
        System.out.println("Max Slider Position: " + maxSlider.getLocation());

        //driver.quit();

	}

}
