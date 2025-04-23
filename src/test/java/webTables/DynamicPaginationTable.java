package webTables;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;

public class DynamicPaginationTable {

	public static void main(String[] args) {

		WebDriver driver=new ChromeDriver();
		//WebDriver driver=new EdgeDriver();
		
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		
		driver.get("https://testautomationpractice.blogspot.com/"); 
		driver.manage().window().maximize();

		
		/*//driver.findElement(By.xpath("//input[@id='input-username']")).sendKeys("demo");
		//driver.findElement(By.xpath("//input[@id='input-password']")).sendKeys("demo");
		
		WebElement username=driver.findElement(By.xpath("//input[@placeholder='Username']"));
		username.clear();    // Clear any pre-filled value
		username.sendKeys("Admin");
		
		WebElement password=driver.findElement(By.xpath("//input[@placeholder='Password']"));
		password.clear();    // Clear any pre-filled value
		password.sendKeys("admin123"); 
		
		driver.findElement(By.xpath("//button[normalize-space()='Login']")).click();*/

		
		
		
	


       

	}

}
