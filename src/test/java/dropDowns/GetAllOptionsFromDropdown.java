package dropDowns;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

public class GetAllOptionsFromDropdown {

	public static void main(String[] args) {
		
		WebDriver driver=new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		driver.get("https://phppot.com/demo/jquery-dependent-dropdown-list-countries-and-states/");
		driver.manage().window().maximize();
		
		WebElement drpCountryEle=driver.findElement(By.xpath("//select[@id='country']"));  //Locate the drop-down element
		Select drpCountry=new Select(drpCountryEle); //Create a Select object.Pass the dropdown WebElement into a Select object. 
		
//----- capture the All options from the drop-down
		List<WebElement>options=drpCountry.getOptions(); //find the total number of options in a particular dropdown
		System.out.println("Number of options in a drop-down:" +options.size()); 
		
		//printing All the options------------------------------
		for(int i=0; i<options.size(); i++)
		{
			System.out.println(options.get(i).getText());  
		}
		
//----- Alternative Enhanced for Loop: We can also use an enhanced for loop to simplify the code. This is often preferred as it’s more readable.

		for (WebElement op : options) 
		{
        System.out.println(op.getText());   //printing the options
        }

	}

}
