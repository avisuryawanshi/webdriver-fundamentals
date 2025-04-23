package dropDowns;

import java.time.Duration;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

public class SortedDropDownList {

	public static void main(String[] args) {
		
		WebDriver driver=new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		driver.get("https://testautomationpractice.blogspot.com/");
		driver.manage().window().maximize();
		
//----- //Initialize the Select class--Select the dropdown----- *E.g. Animals List DropDown* ------------
		Select dropdown=new Select(driver.findElement(By.xpath("//select[@id='animals']")));
		
//----- Un-Sorted List ---*E.g. Colors List DropDown*----------------------------------------------------
		//Select dropdown=new Select(driver.findElement(By.xpath("//select[@id='colors']")));
				
//----- Fetch all options in the dropdown--------------------
		List<WebElement> options=dropdown.getOptions();
			
//----- Create two lists: one original, one for sorting -------------------------
		ArrayList<String> originalList=new ArrayList<String>();
		ArrayList<String> tempList=new ArrayList<String>();
		
		for(WebElement option:options) //extract the text of each option
		{
			originalList.add(option.getText());
			tempList.add(option.getText());
		}
				
		/*System.out.println("Before sorting........");
		System.out.println("Original list:  "+ originalList);
		System.out.println("Temporary list: "+ tempList);
		System.out.println("-----------------------------------------------------------------");*/
				
//----- Sort the temporary list-----------------------
		Collections.sort(tempList); //sorted temp list
				
		/*System.out.println("After sorting........");
		System.out.println("Original list:  "+ originalList);
		System.out.println("Temporary list: "+ tempList);
		System.out.println("-----------------------------------------------------------------");*/
				
//----- Compare both lists---------------
		if(originalList.equals(tempList))
		{
			System.out.println("List box is sorted");
		}
		else
		{
			System.out.println("List box is not sorted");
		}
				
		driver.quit();

	}

}
