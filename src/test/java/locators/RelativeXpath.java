package locators;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class RelativeXpath {

	public static void main(String[] args) {

		WebDriver driver=new ChromeDriver(); 
		driver.get("https://demo.opencart.com/");    
		driver.manage().window().maximize();
		
//1)--- xPath with single attribute-------------------------------------------
		//driver.findElement(By.xpath("//input[@placeholder='Search']")).sendKeys("Laptops");
		
//2)--- xPath with multiple attribute-----------------------------------------
		//driver.findElement(By.xpath("//input[@type=\'text\'][@placeholder=\'Search\']")).sendKeys("Laptops");
		
//3)--- xPath with "and" operator---------------------------------------------
		//driver.findElement(By.xpath("//input[@type=\'text\' and @placeholder=\'Search\']")).sendKeys("Laptops");
		
//4)--- xPath with "or" operator----------------------------------------------
		//driver.findElement(By.xpath("//input[@type=\'text\' or @placeholder=\'XYZ\']")).sendKeys("Laptops");
				
//5)--- xPath with text()- inner text(not consider any attribute--------------
		//driver.findElement(By.xpath("//a[text()='MacBook']"));
		
		//boolean displaystatus=driver.findElement(By.xpath("//h3[text()='Featured']")).isDisplayed();
		//System.out.println(displaystatus);
		
		//String value=driver.findElement(By.xpath("//h3[text()='Featured']")).getText();
		//System.out.println(value);
		
//6)--- xPath with contains()---------------------------------------------------
		//driver.findElement(By.xpath("//input[contains(@placeholder,'Sea')]")).sendKeys("Laptops");
		
//7)--- xPath with starts-with()------------------------------------------------
		//driver.findElement(By.xpath("//input[starts-with(@placeholder,'Sea')]")).sendKeys("Laptops");
		
		//chained xPath
		boolean imagestatus=driver.findElement(By.xpath("//div[@id='logo']/a/img")).isDisplayed();
		System.out.println(imagestatus);
		
		driver.quit();
	}

}
