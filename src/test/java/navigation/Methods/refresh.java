package navigation.Methods;

import org.openqa.selenium.By;
import org.openqa.selenium.StaleElementReferenceException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class refresh {

	public static void main(String[] args) {
		
		WebDriver driver = new ChromeDriver();  
		driver.navigate().to("https://testautomationpractice.blogspot.com/");
		System.out.println(driver.getCurrentUrl());
		driver.manage().window().maximize();
		
		try 
		{
		    WebElement element = driver.findElement(By.id("button"));
		    element.click();
		} 
		catch (StaleElementReferenceException e) 
		{
		    driver.navigate().refresh();
		    WebElement element = driver.findElement(By.id("button"));
		    element.click();
		}


	}

}
