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
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

/**
 * Notes:
	Headless Chrome needs Chrome version 60+ (use --headless=new if version is 109+).
	Added window size helps avoid issues with hidden elements in headless mode.
	driver.findElements(...).size() > 0 is safer than isDisplayed() in headless, as visibility can sometimes fail to detect elements in hidden view.
 */

public class ExcelDataProviderHeadless {
	
		WebDriver driver;

// Precondition: Launch browser in headless mode and set implicit wait
// ------------------------------------------------------------------------------------------------------------	   
		   
		@BeforeClass
	    void setup() {
			ChromeOptions options = new ChromeOptions(); 
			options.addArguments("--headless=new"); // Enable headless mode (Chrome 109+ supports 'new' mode)
	        options.addArguments("--window-size=1920,1080"); // Optional: Helps ensure elements are interactable
	        options.addArguments("--disable-gpu"); // Recommended for headless
	        options.addArguments("--remote-allow-origins=*");
	      
	        driver = new ChromeDriver(options);
	        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
	        System.out.println("=== Browser Launched and Setup Completed ===");
	    }
		
// Test Method: Executes login functionality using data from DataProvider
// ------------------------------------------------------------------------------------------------------------	    
	    
		@Test(dataProvider = "loginData")
	    void testLogin(String email, String password) throws InterruptedException {
	        
	    	driver.get("https://tutorialsninja.com/demo/index.php?route=account/login");
	        driver.manage().window().maximize();
	        driver.findElement(By.xpath("//input[@id='input-email']")).sendKeys(email);
	        driver.findElement(By.xpath("//input[@id='input-password']")).sendKeys(password);
	        driver.findElement(By.xpath("//input[@value='Login']")).click();
	        Thread.sleep(3000);
	        boolean status = driver.findElement(By.xpath("//a[@class='list-group-item'][normalize-space()='My Account']")).isDisplayed();
	        
	        if (status) 
	        {
	            driver.findElement(By.xpath("//a[@class='list-group-item'][normalize-space()='Logout']")).click(); // Logout after successful login
	            Assert.assertTrue(true);
	        } 
	        else 
	        {
	        	System.out.println("Login failed for user: " + email);
	            Assert.fail("Login failed!"); // Provide a failure message
	        }
	    }
		
// Postcondition: Close browser after all tests
// ------------------------------------------------------------------------------------------------------------		   
		    @AfterClass
		    void tearDown() 
		    {
		        driver.close();
		    }		    
// ======================================================================================================================   		
// Data Provider Method: Reads from Excel
// ======================================================================================================================
		    
	    	// Excel header row (first row) is skipped.
			@DataProvider(name = "loginData" , indices= {0,1,2,3,4})  // Run All
			//@DataProvider(name = "loginData" , indices= {1,4}) // Specify the indices you want to run
			
		    public Object[][] getDataFromExcel() throws Exception {
		        
// -------- Test will run for each row of login data.---------------------------------------------
		    	String excelPath = System.getProperty("user.dir") + "/testdata/LoginTestData.xlsx";
		        FileInputStream file = new FileInputStream(excelPath);
		
		        Workbook workbook = new XSSFWorkbook(file);
		        Sheet sheet = workbook.getSheetAt(0);
		
		        int rowCount = sheet.getPhysicalNumberOfRows();
		        int colCount = sheet.getRow(0).getPhysicalNumberOfCells();
		
		        Object[][] data = new Object[rowCount - 1][colCount];
		
		        for (int i = 1; i < rowCount; i++) 
		        {
		            Row row = sheet.getRow(i);
		            for (int j = 0; j < colCount; j++) 
		            {
		                Cell cell = row.getCell(j);
		                data[i - 1][j] = cell.toString();
		            }
		        }
		
		        workbook.close();
		        file.close();
		        return data;
		    }

}
