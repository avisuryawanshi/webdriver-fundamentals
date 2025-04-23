package mSlider.Actions;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

//----------------------------------------------------------------------------------
// Notes:
// - The `dragAndDropBy(element, xOffset, yOffset)` method is used to move sliders.
// - `xOffset` moves the slider horizontally (positive for right, negative for left).
// - `yOffset` is set to `0` because vertical movement is unnecessary.
// - The updated locations help verify if the sliders have moved correctly.
// ----------------------------------------------------------------------------------

public class slider {

	public static void main(String[] args) {
		
		WebDriver driver=new ChromeDriver(); //Ctrl+shift+O
		
		driver.get("https://www.jqueryscript.net/demo//Price-Range-Slider-jQuery-UI/");
		driver.manage().window().maximize();
		
		Actions act=new Actions(driver);
		
		//Min slider
		WebElement min_slider=driver.findElement(By.xpath("//div[@class='price-range-block']//span[1]"));
		System.out.println("Default Location of the min slider:" +min_slider.getLocation()); //(86,232)=(x,y)
		//System.out.println("Location of the min slider:" +min_slider.getLocation().getX()); //(86)=(x)
		//System.out.println("Location of the min slider:" +min_slider.getLocation().getY()); //(232)=(y)
		
		act.dragAndDropBy(min_slider, 100, 232).perform();
		System.out.println("Location of the min slider after moving:" +min_slider.getLocation()); //(158,250)
		
		//Max slider
		WebElement max_slider=driver.findElement(By.xpath("//span[2]"));
		System.out.println("Default Location of the max slider:" +max_slider.getLocation()); //(612, 288)=(x,y)
		
		act.dragAndDropBy(max_slider, -100, 288).perform();
		System.out.println("Location of the max slider after moving:" +max_slider.getLocation());

	}

}
