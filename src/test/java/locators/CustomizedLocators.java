package locators;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class CustomizedLocators {

	public static void main(String[] args) {
	
		WebDriver driver=new ChromeDriver(); 
		driver.get("https://demo.nopcommerce.com/");    
		driver.manage().window().maximize();
		
//-----[ CSS Locators ]-----------------------------------------------------------------------------

//path: <input type="text" class="search-box-text ui-autocomplete-input" id="small-searchterms" autocomplete="off" 
		//name="q" placeholder="Search store" aria-label="Search store" data-has-listeners="true" style="" css="1">------------------------------------

//1)--- tag and id combination //tag#id ----------------------------------------------------
		driver.findElement(By.cssSelector("input#small-searchterms")).sendKeys("T-shirts");
		
		//Remove tag only and id combination
		//driver.findElement(By.cssSelector("#small-searchterms")).sendKeys("T-shirts");
		 
//2)--- tag and classname //tag.classname
		//driver.findElement(By.cssSelector("input.search-box-text ui-autocomplete-input")).sendKeys("T-shirts");
		
		//Remove tag and keep classname //.classname
		//driver.findElement(By.cssSelector(".search-box-text")).sendKeys("T-shirts");
		
//3)--- tag and attribute //tag[attribute="value"]
		//driver.findElement(By.cssSelector("input[placeholder='Search store']")).sendKeys("T-shirts");
		
		//Remove tag name only and keep [attribute="value"]
		//driver.findElement(By.cssSelector("[placeholder='Search store']")).sendKeys("T-shirts");
		
//4)--- tag, class and attribute //tag-classname[attribute="value"]
		//driver.findElement(By.cssSelector("input.search-box-text[name='q']")).sendKeys("T-shirts");
		
//5)--- class and attribute //classname[attribute="value"]
		//driver.findElement(By.cssSelector(".search-box-text[name='q']")).sendKeys("T-shirts");
        
        driver.quit();
	}

}
