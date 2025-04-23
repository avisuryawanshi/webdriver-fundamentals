package chromeOptions.features;

import java.io.File;
import java.util.Arrays;
import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

public class AddMultipleExtension {

	public static void main(String[] args) {
		
// ============================================================================================
// Scenario: Launch Chrome with multiple extensions at runtime
// ============================================================================================

        // Step 1: Create ChromeOptions object
        ChromeOptions options = new ChromeOptions();

        // Step 2: Define the paths to the extension (.crx) files
        List<File> extensions = Arrays.asList(
                new File("C:\\Users\\ASUS\\eclipse-workspace\\CRX file\\SelectorsHub.crx"),
                new File("C:\\Users\\ASUS\\eclipse-workspace\\CRX file\\Desktop-app-for-Google-Tasks-Chrome-Web-Store.crx"));

        // Step 3: Add each extension to ChromeOptions
        for (File extension : extensions) 
        {
            options.addExtensions(extension);
        }

        // Step 4: Initialize WebDriver with ChromeOptions
        WebDriver driver = new ChromeDriver(options);
        
        // Step 5: Maximize browser window
        driver.manage().window().maximize();

        // Step 6: Open Google
        driver.get("https://www.google.com");
        System.out.println("Chrome launched with multiple extensions.");

        // Close the browser
        //driver.quit();

	}

}
