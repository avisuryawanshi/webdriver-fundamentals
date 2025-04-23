package webTables;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class DynamicTable {

	public static void main(String[] args) {
		
		WebDriver driver=new ChromeDriver();
		//WebDriver driver=new EdgeDriver();
		
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		driver.get("https://practice.expandtesting.com/dynamic-table"); 
		driver.manage().window().maximize();
		
		//multiple table on web page use this approach to find single table
		List<WebElement> rows=driver.findElements(By.xpath("//table[@class='table table-striped']/tbody/tr")); 
		System.out.println("number of rows:" +rows.size());
		
		for(int r=1;r<=rows.size();r++)    //outer for loop repeating the rows // Outer loop for rows
		{
			WebElement name=driver.findElement(By.xpath("//table[@class='table table-striped']/tbody/tr["+ r +"]//td[1]"));
			//System.out.println(name.getText());
			if(name.getText().equals("Chrome"))
			{
				String cpuLoad=driver.findElement(By.xpath("//td[normalize-space()='Chrome']//following-sibling::*[contains(text(),'%')]")).getText();
				String value=driver.findElement(By.xpath("//p[@id='chrome-cpu']")).getText();
				
				if(value.contains(cpuLoad))
				{
					System.out.println("CPU Load of Chrome is equal.");
				}
				else
				{
					System.out.println("CPU Load of Chrome is NOt equal.");
				}
				break;
			}
		}
		
	
	}

}
