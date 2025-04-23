package chromeOptions.features;

import java.io.File;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

public class EnableExtensionAtRunTime {

	public static void main(String[] args) {
		
// ============================================================================================
// Scenario: Launch Chrome with an extension (SelectorsHub) at runtime and perform a basic test
// ============================================================================================
        
        // Step 1: Create ChromeOptions object
        ChromeOptions options = new ChromeOptions();
        
        // Step 2: Specify the path to the CRX file of the Chrome extension
        File extensionPath = new File("C:\\Users\\ASUS\\eclipse-workspace\\CRX file\\SelectorsHub.crx");
        
        // Step 3: Add the extension to ChromeOptions
        options.addExtensions(extensionPath);
        
        //disable specific extensions
        //options.addArguments("--disable-extensions");

        // Step 4: Initialize WebDriver with ChromeOptions
        WebDriver driver = new ChromeDriver(options);
        
        // Step 5: Maximize browser window
        driver.manage().window().maximize();
        
        // Step 6: Open a website
        driver.get("https://text-compare.com/");
        System.out.println("Opened website: text-compare.com");
        
        // Step 7: Print the title of the webpage
        System.out.println("Page Title: " + driver.getTitle());
        
// ============================================================================================
// Another Example: Launching Chrome with an Extension and Opening Google
// ============================================================================================

        // Step 1: Create a new ChromeOptions object
        /*ChromeOptions options = new ChromeOptions();
        
        // Step 2: Provide the path of the Chrome extension (.crx file)
        options.addExtensions(new File("C:\\Users\\ASUS\\eclipse-workspace\\CRX file\\SelectorsHub.crx"));
        
        // Step 3: Launch Chrome with the extension
        WebDriver driver = new ChromeDriver(options2);
        
        // Step 4: Open Google
        driver.get("https://www.google.com");
        System.out.println("Chrome launched with the extension.");
        
        // Step 5: Print the title of the webpage
        System.out.println("Page Title: " + driver.getTitle());*/
        
        // Close the browsers
        driver.quit();
    
	}

}
