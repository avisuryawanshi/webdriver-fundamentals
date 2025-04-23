package windowAndFrame.Methods;

import java.io.File;
import java.time.Duration;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class getScreenshotAs {

	public static void main(String[] args) {
		
		WebDriver driver=new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		driver.get("https://demo.nopcommerce.com/");
		driver.manage().window().maximize();
		
//---------------------------------------------------------------------------------------------------------
//1) Capture a Full-Page Screenshot
//---------------------------------------------------------------------------------------------------------
		
		TakesScreenshot ts = (TakesScreenshot) driver;           // Convert WebDriver instance to TakesScreenshot interface
		
		File sourceFile = ts.getScreenshotAs(OutputType.FILE);   // Capture the screenshot and store it as a File object
		//File targetFile=new File("C:\\Users\\ASUS\\eclipse-workspace\\webdriver-fundamentals\\screenshots\\fullpage1.png");   // Defining the target file path for the screenshot
		
		File targetFile=new File(System.getProperty("user.dir")+"\\screenshots\\fullpage.png"); // Define the target file path dynamically using the project directory
        
		sourceFile.renameTo(targetFile); // Copies the source file to the target location
		System.out.println("Screenshot saved successfully at: " + targetFile.getAbsolutePath()); // Print confirmation message with the absolute file path
		//System.out.println("Screenshot captured for failed test case: " + targetFile.getName());
		
		driver.quit();		
	}
	
}

/*---------------------------------------------------------------------------------------------------------
2) Capture a Screenshot of a Specific Section (To be implemented)
 - Use WebElement and getScreenshotAs(OutputType.FILE) to capture a specific section of the page.
 
---------------------------------------------------------------------------------------------------------

3) Capture a Screenshot of a Specific WebElement (To be implemented)
 - Use WebElement and getScreenshotAs(OutputType.FILE) to capture an individual element.

---------------------------------------------------------------------------------------------------------
4) Capture a Screenshot with Timestamp (To be implemented)
 - Use SimpleDateFormat to generate a unique filename based on timestamp.

---------------------------------------------------------------------------------------------------------*/
     

		
		
		
	


