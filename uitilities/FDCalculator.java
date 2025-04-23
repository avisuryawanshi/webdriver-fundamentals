package uitilities;

import java.io.IOException;
import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

public class FDCalculator {

	public static void main(String[] args) throws IOException, InterruptedException {
		
		WebDriver driver=new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		driver.get("https://www.moneycontrol.com/fixed-income/calculator/state-bank-of-india-sbi/fixed-deposit-calculator-SBI-BSB001.html");
		driver.manage().window().maximize();
		
		String filePath=System.getProperty("user.dir")+ "\\testdata\\Caldata.xlsx";
		
		int rows=ExcelUtils.getRowCount(filePath, "Sheet1");  // Get the total number of rows in the Excel sheet
		
		for(int i=1; i<= rows; i++)     // Iterate through each row in the Excel sheet i representing row no.
		{
			//1) read data from excel--------------------------------------------------
			String principle=ExcelUtils.getCellData(filePath, "Sheet1", i, 0);   //return principle amount
			String interestRate=ExcelUtils.getCellData(filePath, "Sheet1", i, 1);
			String tenure=ExcelUtils.getCellData(filePath, "Sheet1", i, 2);   //written period value
			String tenurePeriod=ExcelUtils.getCellData(filePath, "Sheet1", i, 3);
			String frequency=ExcelUtils.getCellData(filePath, "Sheet1", i, 4);
			String expectedMaturityValue=ExcelUtils.getCellData(filePath, "Sheet1", i, 5);
			
			//pass above data into application------------------------------------------
			driver.findElement(By.xpath("//input[@id='principal']")).sendKeys(principle);
			driver.findElement(By.xpath("//input[@id='interest']")).sendKeys(interestRate);
			driver.findElement(By.xpath("//input[@id='tenure']")).sendKeys(tenure);
			
			// Select options from dropdowns
			Select perdrp=new Select(driver.findElement(By.xpath("//select[@id='tenurePeriod']"))); //drop down
			perdrp.selectByVisibleText(tenurePeriod);
			
			Select fredrp=new Select(driver.findElement(By.xpath("//select[@id='frequency']")));//drop down
			fredrp.selectByVisibleText(frequency);
			
			driver.findElement(By.xpath("//div[@class='cal_div']//a[1]")).click();  //clicked on calculate
		
			//validation---------------------------------------------------------
			String actualMaturityValue=driver.findElement(By.xpath("//span[@id='resp_matval']//strong")).getText();
			//String act_mvalue=driver.findElement(By.xpath("//span[@id='resp_matval' and @class='gL_27']/strong")).getText();

			if(Double.parseDouble(expectedMaturityValue)==Double.parseDouble(actualMaturityValue))
			{
				System.out.println("Test passed");
				ExcelUtils.setCellData(filePath, "Sheet1", i, 7, "Passed");
				ExcelUtils.fillGreenColor(filePath,"Sheet1", i, 7);
			}
			else
			{
				System.out.println("Test failed");
				ExcelUtils.setCellData(filePath, "Sheet1", i, 7, "Failed");
				ExcelUtils.fillRedColor(filePath, "Sheet1", i, 7);
			}
			
			Thread.sleep(3000);	
			driver.findElement(By.xpath("//img[@class='PL5']")).click();  //clicked on clear button
		
		}   //ending of for loop 

		driver.quit();  
	
	}

}
