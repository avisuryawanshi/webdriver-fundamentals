package fileUpload;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

/*
 * 📌 Scenario: Single File Upload Using sendKeys()
		Requirement: Automate the process of uploading a single file to a webpage that supports file uploads using <input type="file">.
		✅ Solution: Use Selenium WebDriver's sendKeys() method to directly set the file path.
 */

public class SingleFileUploadSendKeys {

	public static void main(String[] args) {
		
		WebDriver driver=new ChromeDriver();
		driver.get("https://davidwalsh.name/demo/multiple-file-upload.php");
		driver.manage().window().maximize();
		
// =================================================================================================================================
// Approach 1: Upload a single file using sendKeys() - OpenCart -FRS.pdf
// =================================================================================================================================		
		// Define the absolute path of the file to be uploaded
		driver.findElement(By.xpath("//input[@id='filesToUpload']")).sendKeys("D:\\QA- Software Testing\\2024\\Projects\\Opencart Project Documents\\OpenCart -FRS.pdf");
		
		// Verify if the file is successfully uploaded
		if(driver.findElement(By.xpath("//li[normalize-space()='OpenCart -FRS.pdf']")).getText().equals("OpenCart -FRS.pdf"))
	    {
			System.out.println("File is successfully uploaded");
	    }
		else
		{
			System.out.println("File upload failed.");
		}
// =================================================================================================================================
// Approach 2: Verify if the correct file path is set in the input field
// =================================================================================================================================	
		
		// Define the absolute path of the file to be uploaded
		/*String filePath = "D:\\QA- Software Testing\\2024\\Projects\\Opencart Project Documents\\OpenCart -FRS.pdf";
		
		System.out.println("Attempting to upload file: " + filePath);
	        
        WebElement fileInput = driver.findElement(By.xpath("//input[@id='filesToUpload']"));
        fileInput.sendKeys(filePath); // Upload the file
	        
		// Verify if the file is successfully uploaded
        WebElement uploadedFile = driver.findElement(By.xpath("//li[normalize-space()='OpenCart -FRS.pdf']"));
        
		String uploadedFileName = uploadedFile.getText();
        
        if (uploadedFileName.equals("OpenCart -FRS.pdf")) 
        {
            System.out.println("✅ Verified: Correct file name appears in the uploaded list.");
        } 
        else 
        {
            System.out.println("❌ Error: Incorrect file name displayed.");
        }*/

        // Close the browser
        //driver.quit();
	
	
	}

}
