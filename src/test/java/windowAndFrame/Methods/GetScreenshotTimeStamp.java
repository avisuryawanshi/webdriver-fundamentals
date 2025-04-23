package windowAndFrame.Methods;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.time.Duration;
import java.util.Date;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import com.google.common.io.Files;

public class GetScreenshotTimeStamp {

    public static void main(String[] args) throws IOException {
        
        WebDriver driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        driver.get("https://demo.nopcommerce.com/");
        driver.manage().window().maximize();
   
/*---------------------------------------------------------------------------------------------------------
     // 4) Capture a Screenshot with a Unique Timestamp
     //- Use SimpleDateFormat to generate a unique filename based on timestamp.
---------------------------------------------------------------------------------------------------------*/
        
        GetScreenshotTimeStamp screenshotUtil = new GetScreenshotTimeStamp();       // Create an instance of GetScreenshotTimeStamp to call the captureScreen method
        String screenshotPath = screenshotUtil.captureScreen(driver, "HomePage");   // Capture the screenshot and store the returned file path
        System.out.println("Screenshot saved at: " + screenshotPath);               // Print confirmation message with the absolute file path

        driver.quit();  // Closing the browser
    }
//------------------------------------------------------------------------------------------------------
        //Method to capture screenshot with timestamp 
//------------------------------------------------------------------------------------------------------
    
    public String captureScreen(WebDriver driver, String testName) throws IOException {

//------Generating a timestamp to append to the screenshot file name
        String timeStamp = new SimpleDateFormat("yyyyMMdd_HHmmss").format(new Date());

//----- Take a screenshot and store it in a temporary file
        TakesScreenshot takesScreenshot = (TakesScreenshot) driver;
        File sourceFile = takesScreenshot.getScreenshotAs(OutputType.FILE);

//----- Define the target file path dynamically based on project directory, test name, and timestamp
        String targetFilePath = System.getProperty("user.dir") + "/screenshots/" + testName + "_" + timeStamp + ".png";
        File targetFile = new File(targetFilePath);

//----- Copy the screenshot from the temporary file to the target location
        Files.copy(sourceFile, targetFile);

     // Return the absolute path of the saved screenshot
        return targetFilePath;
    }
}
