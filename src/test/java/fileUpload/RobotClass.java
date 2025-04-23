package fileUpload;

import java.awt.AWTException;
import java.awt.Robot;
import java.awt.Toolkit;
import java.awt.datatransfer.StringSelection;
import java.awt.event.KeyEvent;
import java.time.Duration;
import java.util.NoSuchElementException;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

/*
 * Scenario: Upload a Resume on Foundit.in Using Robot Class
	🔹 Navigate to Foundit.in (formerly Monster India).
	🔹 Click on the Upload Resume button.
	🔹 Use Robot Class to handle the OS file upload dialog.
	🔹 Verify the success message after uploading.
 */

public class RobotClass {

	public static void main(String[] args) throws InterruptedException, AWTException {
		
		WebDriver driver = new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		driver.get("https://www.foundit.in/web/en/home");
		driver.manage().window().maximize();
		
		// Validations * NOT WORKING *  		
// ---- Click on the 'Upload Resume' button -----------------------------------------------------------------------------------------
		driver.findElement(By.xpath("//a[@class='btn block resume-btn btn-orange mt20']")).click(); //span[@class='block fs-11 mt10'] 
		Thread.sleep(3000);
	
// ---- Use Robot Class to handle file selection --------------------------------------------------------------
        Robot robot = new Robot();  // Use Robot class to paste the file path and hit Enter

// ---- Copy file path to clipboard ---------------------------------------------------------------------------
        String filePath = "D:\\HL\\My office\\English.pdf";  // Specify the file to be uploaded
        StringSelection filePathSelection = new StringSelection(filePath);                     //We create a StringSelection object containing the file path.
        Toolkit.getDefaultToolkit().getSystemClipboard().setContents(filePathSelection, null); 
        System.out.println("✅ File path copied to clipboard: " + filePath);
        Thread.sleep(3000); // Wait before pasting
  		
// ---- Simulate CTRL + V (Paste) to paste the file path in the dialog -----------------------------------------
        robot.keyPress(KeyEvent.VK_CONTROL);  // Press CTRL key (For Mac, use KeyEvent.VK_META)
        robot.keyPress(KeyEvent.VK_V);        // Press 'V' key
        robot.keyRelease(KeyEvent.VK_V);      // Release 'V' key
        robot.keyRelease(KeyEvent.VK_CONTROL); // Release CTRL key
        System.out.println("✅ Pasted file path in the file upload dialog.");
        Thread.sleep(3000);

// ---- Press Enter to confirm file selection -------------------------------------------------------------------
        robot.keyPress(KeyEvent.VK_ENTER);      // Press Enter key
        robot.keyRelease(KeyEvent.VK_ENTER);    // Release Enter key
        System.out.println("✅ File upload dialog confirmed by pressing Enter.");
        Thread.sleep(3000);
        
        System.out.println("File uploaded successfully using Robot Class.");

// ---- Validate If Upload Was Successful ---------------------------------------------------------------------
        try 
        {
            WebElement successMessage = driver.findElement(By.xpath("//div[@class='toasterContent']"));
            if (successMessage.isDisplayed()) 
            {
                System.out.println("🎉 File upload successful! Confirmation message: " + successMessage.getText());
            } 
            else 
            {
                System.out.println("❌ File upload may have failed. No success message displayed.");
            }
        } 
        catch (NoSuchElementException e) 
        {
            System.out.println("❌ File upload failed! No confirmation message found.");
        }
        
// Validations NOT WORKING       
// ---- Validate Uploaded File Name -----------------------------------------------------------------------------
        try 
        {
            WebElement uploadedFileName = driver.findElement(By.xpath("//div[@class='toasterContent']"));
            if (uploadedFileName.getText().contains("English.pdf")) 
            {
                System.out.println("✅ Correct file uploaded: English.pdf");
            } 
            else 
            {
                System.out.println("❌ Incorrect file uploaded.");
            }
        } 
        catch (NoSuchElementException e) 
        {
            System.out.println("❌ Unable to verify uploaded file name.");
        }
        
        driver.quit();
 
   
	}
}
