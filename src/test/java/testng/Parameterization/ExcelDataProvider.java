package testng.Parameterization;

import java.io.FileInputStream;
import java.time.Duration;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

/**
 * ✅ Scenario:
	"Login Functionality with Data-Driven Testing"
	In this test case, we're validating the login functionality of the TutorialsNinja Demo site. 
	We are using a DataProvider to feed different sets of email-password combinations read from an Excel file. 
	The test will attempt to login for each dataset and verify whether the login was successful or not.
 */

public class ExcelDataProvider {
	
		WebDriver driver;

// ==========================================================================================================================
// Precondition: Launch Chrome browser and set implicit wait
// ==========================================================================================================================
	   
		@BeforeClass
	    void setup() {
	        driver = new ChromeDriver();
	        driver = new ChromeDriver();
	        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
	        System.out.println("=== Browser Launched and Setup Completed ===");
	    }
	
// ==========================================================================================================================
// Test: Validate login functionality using email and password from Excel file
// ==========================================================================================================================
    
		@Test(dataProvider = "loginData")
	    void testLogin(String email, String password) throws InterruptedException {
	        
			System.out.println("Attempting login with: " + email + " | " + password);

			// Enter login credentials
	    	driver.get("https://tutorialsninja.com/demo/index.php?route=account/login");
	        driver.manage().window().maximize();
	        driver.findElement(By.xpath("//input[@id='input-email']")).sendKeys(email);
	        driver.findElement(By.xpath("//input[@id='input-password']")).sendKeys(password);
	        driver.findElement(By.xpath("//input[@value='Login']")).click();
	        Thread.sleep(3000);  // Let the page load
	        
	        // Check if login was successful
	        boolean isLoginSuccessful = driver.findElement(By.xpath("//a[@class='list-group-item'][normalize-space()='My Account']")).isDisplayed();
	        
	        if (isLoginSuccessful) 
	        {
	        	// Perform logout after successful login
	            driver.findElement(By.xpath("//a[@class='list-group-item'][normalize-space()='Logout']")).click(); // Logout after successful login
	            Assert.assertTrue(true);
	        } 
	        else 
	        {
	        	System.out.println("Login failed for user: " + email);
	            Assert.fail("Login failed!"); // Provide a failure message
	        }
	    }
		
// ==========================================================================================================================
// Postcondition: Close browser
// ==========================================================================================================================
		    @AfterClass
		    void tearDown() 
		    {
		        driver.quit();
		        System.out.println("==> Browser closed. Test execution completed.");
		    }	
		    
// ==========================================================================================================================
// Data Provider: Fetch login data from Excel (excluding header row)
// NOTE: we can modularize your Excel reading logic into a reusable utility class. Create a Utility Class for Excel Reading
// ==========================================================================================================================
		    
			@DataProvider(name = "loginData" , indices= {0,1,2,3,4})  // Run All. You can limit with specific indices
			//@DataProvider(name = "loginData" , indices= {1,4}) // Specify the indices you want to run
			
			public Object[][] getDataFromExcel() throws Exception {
		        
// -------- Test will run for each row of login data.---------------------------------------------
		    	String excelPath = System.getProperty("user.dir") + "/testdata/LoginTestData.xlsx";
		        FileInputStream file = new FileInputStream(excelPath);
		
		        Workbook workbook = new XSSFWorkbook(file);
		        Sheet sheet = workbook.getSheetAt(0);
		
		        int rowCount = sheet.getPhysicalNumberOfRows();            // Total rows
		        int colCount = sheet.getRow(0).getPhysicalNumberOfCells(); // Total columns
		
		        Object[][] data = new Object[rowCount - 1][colCount];      // Skipping header row. // Excel header row (first row) is skipped.
		
		        // Start reading from row 1 (skip header)
		        for (int i = 1; i < rowCount; i++) 
		        {
		            Row row = sheet.getRow(i);
		            for (int j = 0; j < colCount; j++) 
		            {
		                Cell cell = row.getCell(j);
		                data[i - 1][j] = cell.toString(); // Convert to String for simplicity
		            }
		        }
		
		        workbook.close();
		        file.close();
		        System.out.println("==> Excel data loaded successfully.\n");
		        return data;
		    }

}
