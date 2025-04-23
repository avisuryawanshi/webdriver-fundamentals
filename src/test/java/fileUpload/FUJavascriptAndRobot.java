package fileUpload;

import java.awt.AWTException;
import java.awt.Robot;
import java.awt.Toolkit;
import java.awt.datatransfer.StringSelection;
import java.awt.event.KeyEvent;
import java.time.Duration;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

/*
 * 📌 Scenario: Upload a Resume on Foundit.in Using JavaScriptExecutor and Robot Class
		1️ Navigate to Foundit.in (formerly Monster India).
		2️ Click on the Upload Resume button using JavascriptExecutor.
		3️ Use Robot Class to handle the file upload process.
		4️ Verify whether the upload was successful.
 */

public class FUJavascriptAndRobot {

	public static void main(String[] args) throws InterruptedException, AWTException {

// ===============================================================
// Using JavaScriptExecutor and Robot Class (Recommended Approach)
// ===============================================================		
		WebDriver driver=new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		driver.get("https://www.foundit.in/web/en/home");
		driver.manage().window().maximize();
// ---------------------------------------------------------------------------------------------------------------------
// Click on the 'Upload Resume' button
// ---------------------------------------------------------------------------------------------------------------------
		
		driver.findElement(By.xpath("//a[@class='btn block resume-btn btn-orange mt20']")).click(); // Click on the "Upload Resume" button
		Thread.sleep(3000);
		
// ---------------------------------------------------------------------------------------------------------------------
// Using JavaScriptExecutor to click on the hidden file input field 
// ---------------------------------------------------------------------------------------------------------------------		
		JavascriptExecutor js=(JavascriptExecutor)driver;
		WebElement fileInput = driver.findElement(By.xpath("(//input[@id='file-upload'])[1]"));
        js.executeScript("arguments[0].click();", fileInput);
		
        //js.executeScript("arguments[0].click();",driver.findElement(By.xpath("(//input[@id='file-upload'])[1]")));
		
// ---- (1) Copy the file path to clipboard 
        String filePath = "D:\\HL\\My office\\English.pdf"; // File to upload
        StringSelection filePathSelection = new StringSelection(filePath);
        Toolkit.getDefaultToolkit().getSystemClipboard().setContents(filePathSelection, null);
        System.out.println("✅ File path copied to clipboard: " + filePath);
        Thread.sleep(3000);
	
// ---- (2) Use Robot class to paste the file path and hit Enter
        Robot rb = new Robot();

        // Simulate CTRL + V (Paste)
        rb.keyPress(KeyEvent.VK_CONTROL);
        rb.keyPress(KeyEvent.VK_V);
        rb.keyRelease(KeyEvent.VK_V);
        rb.keyRelease(KeyEvent.VK_CONTROL);
        System.out.println("✅ Pasted file path in the file upload dialog.");
        Thread.sleep(3000);

// ---- (3) Press Enter to confirm file selection
        rb.keyPress(KeyEvent.VK_ENTER);
        rb.keyRelease(KeyEvent.VK_ENTER);
        System.out.println("✅ File upload dialog confirmed by pressing Enter.");
        Thread.sleep(3000);

// ---------------------------------------------------------------------------------------------------------------------	
// Verify Upload Success
// ---------------------------------------------------------------------------------------------------------------------	
        try 
        {
            WebElement successMessage = driver.findElement(By.xpath("//div[@class='toasterContent']"));
            if (successMessage.isDisplayed()) 
            {
                System.out.println("File upload successful! Message: " + successMessage.getText());
            }
            else 
            {
                System.out.println("❌ File upload may have failed. No success message displayed.");
            }
        } 
        catch (Exception e) 
	        {
	            System.out.println("❌ File upload failed! No confirmation message found.");
	        }
        
// ---------------------------------------------------------------------------------------------------------------------	
        driver.quit();

	}

}
