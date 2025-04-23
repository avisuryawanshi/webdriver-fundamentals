package dropDowns;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

public class SelectDropDownEg {

	public static void main(String[] args) {
		
		WebDriver driver=new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		driver.get("https://phppot.com/demo/jquery-dependent-dropdown-list-countries-and-states/");
		driver.manage().window().maximize();
		
//----- country -------------------		
		WebElement drpCountryEle=driver.findElement(By.xpath("//select[@id='country-list']"));  
		Select drpCountry=new Select(drpCountryEle);

//----- state ---------------------
		WebElement drpStateEle=driver.findElement(By.xpath("//select[@id='state-list']"));  
		Select drpState=new Select(drpStateEle);
		
//----- This action opens the drop-down options ----------------------------------------------------------------
		//driver.findElement(By.xpath("//select[contains(@class,'demoInp')]")).click();
		//select single option
		//driver.findElement(By.xpath("//select[@value='China']")).click();

//----- select option from the Country DropDown
		drpCountry.selectByVisibleText("China");  //drpCountry is a select class object
		//drpCountry.selectByValue("2");
		//drpCountry.selectByIndex(2);
		
//----- select option from the State DropDown
		drpState.selectByVisibleText("Hebei");  //drpCountry is a select class object
		//drpState.selectByValue("5");
		//drpState.selectByIndex(2);
		
//----- capture the options from the drop-down--------------------------------------------------------------------------
		List<WebElement>options=drpCountry.getOptions();
		System.out.println("Number of options in a drop-down:" +options.size()); //6
		
		//printing the options
				for(int i=0; i<options.size(); i++)
				{
					System.out.println(options.get(i).getText());
					//System.out.println("Number of options:" +options.size());
				}
//------------------------------------------------------------------------------
				
		//Alternative Enhanced for Loop: We can also use an enhanced for loop to simplify the code. This is often preferred as it’s more readable.

				for (WebElement op : options) 
				{
		        System.out.println(op.getText());
		        //System.out.println("Number of options:" +options.size());
		        }	

	}

}
