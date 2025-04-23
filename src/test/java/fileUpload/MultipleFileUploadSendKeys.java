package fileUpload;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

/*
 * 📌 Scenario: Upload Multiple Files Using sendKeys()
	Requirement: Automate the process of uploading multiple files to a webpage that supports file uploads using <input type="file" multiple>.
	✅ Solution: Use Selenium WebDriver's sendKeys() method to upload multiple files by providing their absolute paths separated by a newline (\n).
 */

public class MultipleFileUploadSendKeys {

	public static void main(String[] args) {
		
		WebDriver driver=new ChromeDriver();
		driver.get("https://davidwalsh.name/demo/multiple-file-upload.php");
		driver.manage().window().maximize();

// ==================================================================================================================================
// Multiple Files uploaded - // ✅ Step 1: Define File Paths for Upload
// ==================================================================================================================================
		
		String file1="D:\\QA- Software Testing\\2024\\\\Projects\\Opencart Project Documents\\OpenCart -FRS.pdf";
		String file2="D:\\QA- Software Testing\\2024\\Projects\\Opencart Project Documents\\OpenCart -Test Plan.pdf";
		
		// Print file paths before uploading
        System.out.println("Uploading files: ");
        System.out.println("1️ " + file1);
        System.out.println("2️ " + file2);
        
// ==================================================================================================================================
// ✅ Step 2: Upload Multiple Files using sendKeys()
// ==================================================================================================================================
		
        WebElement fileInput = driver.findElement(By.xpath("//input[@id='filesToUpload']"));
		fileInput.sendKeys(file1+"\n"+file2); // Uploading multiple files using sendKeys
	
// ==================================================================================================================================		
// ✅ Step 3: Verify Number of Uploaded Files
// ==================================================================================================================================
		
		List<WebElement> uploadedFiles = driver.findElements(By.xpath("//ul[@id='fileList']//li"));
        int numberOfFilesUploaded = uploadedFiles.size(); // Verify the number of uploaded files
		
// ---- Validation 1: Check the number of uploaded files-------------------------------
		
		if(numberOfFilesUploaded == 2)
		{
			System.out.println("✅ Success: Both files uploaded successfully!");
		}
		else
		{
			System.out.println("❌ Error: File upload count mismatch. Expected: 2, Found: " + numberOfFilesUploaded);
		}
		
// ==================================================================================================================================
// ✅ Step 4: Validate File Names
// ==================================================================================================================================
		
		// Approach 1:
		if(driver.findElement(By.xpath("//ul[@id='fileList']//li[1]")).getText().equals("OpenCart -FRS.pdf")
		&& (driver.findElement(By.xpath("//ul[@id='fileList']//li[2]")).getText().equals("OpenCart -Test Plan.pdf")))
		{
			System.out.println("File names match..");
		}
		else
		{
			System.out.println("file names do not match..");
		}
		
//================= Expected file names========================================================================================
		
		//Approach 2:
		String[] expectedFiles = {"OpenCart -FRS.pdf", "OpenCart -Test Plan.pdf"};
        boolean allFilesMatch = true;

        for (int i = 0; i < expectedFiles.length; i++) 
        {
            String actualFileName = uploadedFiles.get(i).getText();
            if (!actualFileName.equals(expectedFiles[i])) 
            {
                allFilesMatch = false;
                System.out.println("❌ Mismatch: Expected: " + expectedFiles[i] + " | Found: " + actualFileName);
            }
        }
        
        if (allFilesMatch) 
        {
            System.out.println("✅ Success: All file names match correctly.");
        } 
        else 
        {
            System.out.println("❌ Error: Some file names do not match the expected values.");
        }
        
        driver.quit();

	}

}
