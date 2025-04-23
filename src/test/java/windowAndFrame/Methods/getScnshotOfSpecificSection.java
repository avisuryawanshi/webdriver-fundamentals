package windowAndFrame.Methods;

import java.io.File;
import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class getScnshotOfSpecificSection {

	public static void main(String[] args) {
		
		WebDriver driver=new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		driver.get("https://demo.nopcommerce.com/");
		driver.manage().window().maximize();
/*------------------------------------------------------------------------------------------------------------------------		
//2)--- Capture a Screenshot of a Specific Section
	  - Use WebElement and getScreenshotAs(OutputType.FILE) to capture a specific section of the page.
-------------------------------------------------------------------------------------------------------------------------*/		
		WebElement featuredProducts=driver.findElement(By.xpath("//div[@class='product-grid home-page-product-grid']")); //xpath pointing to entire box
				
		File sourceFile = featuredProducts.getScreenshotAs(OutputType.FILE);                            // Capture the screenshot of the WebElement and store it as a File object
		File targetFile=new File(System.getProperty("user.dir")+"\\screenshots\\featuredProducts.png"); // Define the target file path dynamically using the project directory
		sourceFile.renameTo(targetFile);                                                                // Move the screenshot to the target location
		System.out.println("Screenshot saved successfully at: " + targetFile.getAbsolutePath());        // Print confirmation message with the absolute file path

		driver.quit();
	}

}

//---------------------------------------------------------------------------------------------------------
//2) Future Enhancements (To be implemented if needed)
//---------------------------------------------------------------------------------------------------------
// - Capture multiple WebElements individually.
// - Combine multiple element screenshots into one image.
// - Capture screenshot with timestamp for unique file naming.
//
//---------------------------------------------------------------------------------------------------------