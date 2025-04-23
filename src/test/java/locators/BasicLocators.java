package locators;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class BasicLocators {

	public static void main(String[] args) {
		
		WebDriver driver = new ChromeDriver();
        driver.get("https://tutorialsninja.com/demo/");
        driver.manage().window().maximize();
        
//1)------Id //isDisplayed method-----------------------------------------------------------------
        /*WebElement Username = driver.findElement(By.id("input-email"));
        Username.sendKeys("rj123@gmail.com");
        
        boolean logoDisplaystatus = driver.findElement(By.id("cart-total")).isDisplayed();//we have to call id method & we have to pass the value of the id("logo")
        System.out.println(logoDisplaystatus);
       
        WebElement logoDisplaystatus1 = driver.findElement(By.id("cart-total"));
        boolean result = logoDisplaystatus1.isDisplayed();
        if(result)
	        {
	       	 System.out.println("It is present on the screen");
	        }
        else
	        {
	       	 System.out.println("It is not present on the screen");
	        }*/
        
//2)----Name----------------------------------------------------------------- ---------       
        //A name locator is the best choice for testing a --"Login Form"--
        //WebElement name = driver.findElement(By.name("email"));
        //name.sendKeys("rj123@gmail.com");
	
//3)----LinkText   //findElements method------------------------------------------------
        //driver.findElement(By.linkText("Tablets")).click(); //header part
        //<a href="https://tutorialsninja.com/demo/index.php?route=product/category&amp;path=57">Tablets</a>
	
//4)----partialLinkText------------------------------------------------------------------
        //driver.findElement(By.partialLinkText("Tabl")).click();
        //<a href="https://tutorialsninja.com/demo/index.php?route=product/category&amp;path=57">Tablets</a>
    	
//5)----className  //findElements method--------------------------------------------------   
        List<WebElement> headerLinks = driver.findElements(By.className("container"));
        System.out.println("total number of header links:"+headerLinks.size());
        
        List<WebElement> footerLinks = driver.findElements(By.className("col-sm-3"));
        System.out.println("total number of footer links:"+footerLinks.size());
        
//6)----tagName for <a for all links------------------------------------------------------
        List<WebElement> Links = driver.findElements(By.tagName("a"));
        System.out.println("total number of links:"+Links.size()); 
        
//7)----tagName for <img for total image links--------------------------------------------
        List<WebElement> images = driver.findElements(By.tagName("img"));
        System.out.println("total number of images:"+images.size());
        
        driver.quit();
	}

}
