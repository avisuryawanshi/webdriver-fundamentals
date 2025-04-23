package dropDowns;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

public class SelectDropDown {

	public static void main(String[] args) {
		
		WebDriver driver=new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		driver.get("https://testautomationpractice.blogspot.com/");
		driver.manage().window().maximize();
		
		WebElement drpCountryEle=driver.findElement(By.xpath("//select[@id='country']"));  //Locate the drop-down element
		//Create a Select object/variable of select class
		Select drpCountry=new Select(drpCountryEle); //Pass the dropdown WebElement into a Select object, which will allow us to perform operations on it.  
		System.out.println("Selected option: " + drpCountryEle.getText());
		
//1)--- select option from the DropDown
		drpCountry.selectByVisibleText("France");  //drpCountry is a select class object //Select an option by visible text
		drpCountry.selectByValue("japan");         //Select an option by index
		drpCountry.selectByIndex(2);               //Select an option by value attribute
		
//2)--- capture the All options from the drop-down
		/*List<WebElement>options=drpCountry.getOptions(); //find the total number of options in a particular dropdown
		System.out.println("Number of options in a drop-down:" +options.size()); 
		
		//printing All the options------------------------------
		for(int i=0; i<options.size(); i++)
		{
			System.out.println(options.get(i).getText());
			System.out.println("Number of options:" +options.size());
		}
		
//----- Alternative Enhanced for Loop: We can also use an enhanced for loop to simplify the code. This is often preferred as it’s more readable.

		for (WebElement op : options) 
		{
        System.out.println(op.getText());
        System.out.println("Number of options:" +options.size());
        }*/

	}

}
