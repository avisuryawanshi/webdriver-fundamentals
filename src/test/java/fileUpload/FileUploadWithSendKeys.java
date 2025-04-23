package fileUpload;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class FileUploadWithSendKeys {

	public static void main(String[] args) {
		
		WebDriver driver=new ChromeDriver();
		driver.get("https://davidwalsh.name/demo/multiple-file-upload.php");
		driver.manage().window().maximize();
		
// =================================================================================================================================
// Approach 1: Single file uploaded by using sendKeys()- OpenCart -FRS.pdf
// =================================================================================================================================		
		// Provide absolute file path
		driver.findElement(By.xpath("//input[@id='filesToUpload']")).sendKeys("D:\\QA- Software Testing\\2024\\Projects\\Opencart Project Documents\\OpenCart -FRS.pdf");
		
		if(driver.findElement(By.xpath("//li[normalize-space()='OpenCart -FRS.pdf']")).getText().equals("OpenCart -FRS.pdf"))
	    {
		System.out.println("File is successfully uploaded");
	    }
		else
		{
			System.out.println("File upload failed.");
		}
		
//=================Multiple Files uploaded - // File paths for upload==================================================================
		/*String file1="D:\\QA- Software Testing\\2024\\\\Projects\\Opencart Project Documents\\OpenCart -FRS.pdf";
		String file2="D:\\QA- Software Testing\\2024\\Projects\\Opencart Project Documents\\OpenCart -Test Plan.pdf";
		
		driver.findElement(By.xpath("//input[@id='filesToUpload']")).sendKeys(file1+"\n"+file2); // Uploading multiple files using sendKeys
		
		int numberOfFilesUploaded=driver.findElements(By.xpath("//ul[@id='fileList']//li")).size(); // Verify the number of uploaded files
		
//------ Validation 1: Check the number of uploaded files-------------------------------
		if(numberOfFilesUploaded==2)
		{
			System.out.println("All Files are successfully Uploaded");
		}
		else
		{
			System.out.println("Files are not uploaded or incorrect files uploaded");
		}
		
//------ validation 2- validates/verify file names------------------------------------------
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
		String[] expectedFiles = {"OpenCart-FRS.pdf", "OpenCart-TestPlan.pdf"};

		// Validate file names
		boolean allFilesMatch = true;
		for (int i = 0; i < expectedFiles.length; i++) {
		    String actualFileName = driver.findElement(By.xpath("//ul[@id='fileList']//li[" + (i + 1) + "]")).getText();
		    if (!actualFileName.equals(expectedFiles[i])) 
		    {
		        allFilesMatch = false;
		        break;
		    }
		}
		if (allFilesMatch) 
		{
		    System.out.println("All file names match.");
		} 
		else 
		{
		    System.out.println("File names do not match.");
		}*/

	}

}
