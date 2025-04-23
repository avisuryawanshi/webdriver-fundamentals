package windowAndFrame.Methods;

import java.io.File;
import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class getscnshotOfSpecificWebElement {

	public static void main(String[] args) {
	
		WebDriver driver=new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		driver.get("https://demo.nopcommerce.com/");
		driver.manage().window().maximize();
		
//---------------------------------------------------------------------------------------------------------
// 3) Capture a Screenshot of a Specific WebElement
//---------------------------------------------------------------------------------------------------------
		
		WebElement nopCommerceLogo=driver.findElement(By.xpath("//img[@alt='nopCommerce demo store']"));
				
		File sourceFile = nopCommerceLogo.getScreenshotAs(OutputType.FILE);
		File targetFile=new File(System.getProperty("user.dir")+"\\screenshots\\nopCommerceLogo.png");
		sourceFile.renameTo(targetFile); 
		System.out.println("Screenshot saved successfully at: " + targetFile.getAbsolutePath());
				
		driver.quit();	
	}

}
