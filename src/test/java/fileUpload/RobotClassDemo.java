package fileUpload;

import java.awt.AWTException;
import java.awt.Robot;
import java.awt.Toolkit;
import java.awt.datatransfer.StringSelection;
import java.awt.event.KeyEvent;
import java.io.File;
import java.time.Duration;
import java.util.NoSuchElementException;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class RobotClassDemo {

	public static void main(String[] args) throws InterruptedException, AWTException {
		
		WebDriver driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        driver.get("https://www.foundit.in/web/en/home");
        driver.manage().window().maximize();
        
// ---- Validate & Click on the 'Upload Resume' button -----------------------------------------------------------------------------------------
        try 
        {
            WebElement uploadButton = driver.findElement(By.xpath("//a[@class='btn block resume-btn btn-orange mt20']"));
            if (uploadButton.isDisplayed()) 
            {
                uploadButton.click();
                System.out.println("✅ 'Upload Resume' button clicked successfully.");
            } 
            else 
            {
                System.out.println("❌ 'Upload Resume' button is not visible.");
                driver.quit();
                return;
            }
        } 
        catch (NoSuchElementException e) 
        {
            System.out.println("❌ 'Upload Resume' button not found.");
            driver.quit();
            return;
        }

        Thread.sleep(3000);

// ---- Validate File Path Before Uploading --------------------------------------------------------------
        String filePath = "D:\\HL\\My office\\English.pdf";  // Specify the file to be uploaded
        File file = new File(filePath);

        if (!file.exists()) 
        {
            System.out.println("❌ File does not exist at the given path: " + filePath);
            driver.quit();
            return;
        }

// ---- Use Robot Class to handle file selection --------------------------------------------------------------
        Robot robot = new Robot();        // Use Robot class to paste the file path and hit Enter

// ---- Copy file path to clipboard ---------------------------------------------------------------------------
        StringSelection filePathSelection = new StringSelection(filePath);
        Toolkit.getDefaultToolkit().getSystemClipboard().setContents(filePathSelection, null);
        System.out.println("✅ File path copied to clipboard: " + filePath);
        Thread.sleep(3000); // Wait before pasting
          
// ---- Simulate CTRL + V (Paste) to paste the file path in the dialog -----------------------------------------
        robot.keyPress(KeyEvent.VK_CONTROL);    // Press CTRL key (For Mac, use KeyEvent.VK_META)
        robot.keyPress(KeyEvent.VK_V);          // Press 'V' key
        robot.keyRelease(KeyEvent.VK_V);        // Release 'V' key
        robot.keyRelease(KeyEvent.VK_CONTROL);  // Release CTRL key
        System.out.println("✅ Pasted file path in the file upload dialog.");
        Thread.sleep(3000);

// ---- Press Enter to confirm file selection -------------------------------------------------------------------
        robot.keyPress(KeyEvent.VK_ENTER);      // Press Enter key
        robot.keyRelease(KeyEvent.VK_ENTER);    // Release Enter key
        System.out.println("✅ File upload dialog confirmed by pressing Enter.");
        Thread.sleep(3000);

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

// ---- Close Browser -----------------------------------------------------------------------------------------
        driver.quit();
        System.out.println("✅ Browser closed successfully.");

	}

}
