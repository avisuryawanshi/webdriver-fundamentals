package dropDowns;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class DynamicGoogleAutoSuggestDropDown {

	public static void main(String[] args) throws InterruptedException {
		
		WebDriver driver=new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10)); // Wait for suggestions to load
		driver.get("https://www.google.com/");
		driver.manage().window().maximize();
		
//------Type input in the search box------------------------------------------------------------------------------------------------------------		
		driver.findElement(By.name("q")).sendKeys("selenium"); //search box
		Thread.sleep(5000); //A Thread.sleep(5000) pauses execution for 5 seconds to allow time for Google’s auto-suggestions to appear
		
//----- Capture all suggestions--------------------------------
		List <WebElement> list=driver.findElements(By.xpath("//ul[@role='listbox']//li//div[@role='option']")); //Locate and Store Auto-Suggest Options
		System.out.println(list.size());  //Prints the total number of suggestions retrieved.
		
//----- for loop iterates through all the suggestions stored in the list.---------------------------------------------------
		for (int i=0;i<list.size();i++)     
		{
		   System.out.println(list.get(i).getText()); //Fetches the visible text of each suggestion and prints it to the console.
		
		   if(list.get(i).getText().equals("selenium")) //Condition: Checks if the text of current suggestion matches the desired value("selenium").
		   {
		      list.get(i).click();  //Calls click() on the matching suggestion to select it
		      break;                //Breaks the loop after selecting the desired option to avoid unnecessary iterations.
		   }
		}


	}

}
