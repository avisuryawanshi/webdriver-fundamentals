package chromeOptions.features;

import java.io.File;
import java.io.IOException;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

public class BlockingAds {

	public static void main(String[] args) throws IOException {
		
// ===================================================================================
// Scenario: Launch Chrome with an AdBlocker extension to block unwanted ads.
// ===================================================================================
        
        // Step 1: Create ChromeOptions object
        ChromeOptions options = new ChromeOptions(); 
        //options.addArguments("--headless=new");  //By combining headless mode with an ad blocker extension.

        // Step 2: Add the AdBlock extension (Download any ad blocker .crx file and provide its path)// Add the CRX file as an extension
        options.addExtensions(new File("C:\\Users\\ASUS\\eclipse-workspace\\CRX file\\uBlock-Origin-Lite-Chrome-Web-Store.crx"));  

        WebDriver driver = new ChromeDriver(options); // Step 3: Launch Chrome with the extension
        driver.manage().window().maximize();          // Step 4: Maximize window
        driver.get("https://text-compare.com");       // Step 5: Open a website with ads
        System.out.println("Page Title: " + driver.getTitle());// Print title
  
// ===================================================================================
// Capture screenshot. Take a screenshot before and after enabling the extension.
// =================================================================================== 
    	TakesScreenshot ts = (TakesScreenshot) driver;         
		File sourceFile = ts.getScreenshotAs(OutputType.FILE);   
		File targetFile=new File(System.getProperty("user.dir")+"\\screenshots\\after_adblock.png"); 
        
		sourceFile.renameTo(targetFile); 
		System.out.println("Screenshot saved successfully at: " + targetFile.getAbsolutePath()); // Print confirmation message with the absolute file path
		System.out.println("Screenshot taken after enabling AdBlocker.");

        //driver.quit();
	}

}
