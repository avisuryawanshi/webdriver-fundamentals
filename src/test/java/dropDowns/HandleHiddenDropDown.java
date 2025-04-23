package dropDowns;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class HandleHiddenDropDown {

	public static void main(String[] args) throws InterruptedException {
		
		WebDriver driver=new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		driver.get("https://opensource-demo.orangehrmlive.com/web/index.php/auth/login");
		driver.manage().window().maximize();
		
//----- Login Steps -----------------------------------------------------------------------------------------------------
		driver.findElement(By.name("username")).sendKeys("Admin");
		driver.findElement(By.name("password")).sendKeys("admin123");
		driver.findElement(By.xpath("//button[normalize-space()='Login']")).click(); 
		
//----- clicking on PIM
		driver.findElement(By.xpath("//span[normalize-space()= 'PIM']")).click(); //PIM ////a[normalize-space()='']
		
//----- clicked on drop down
		driver.findElement(By.xpath("/html[1]/body[1]/div[1]/div[1]/div[2]/div[2]/div[1]/div[1]/div[2]/form[1]/div[1]/div[1]/div[6]/div[1]/div[2]/div[1]/div[1]/div[1]")).click();
		Thread.sleep(5000);
		
//----- select single option
		//driver.findElement(By.xpath("//span[normalize-space()='Financial Analyst']")).click();
		
//----- Count Number of options
		List<WebElement> options=driver.findElements(By.xpath("//div[@role='listbox']//span"));
		
		System.out.println("Number of options:"+ options.size()); //28 printing numbers
		
//----- printing options --------------------------
		for(WebElement op:options)
		{
			System.out.println(op.getText());
		}

	}

}
