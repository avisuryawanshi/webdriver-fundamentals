package dropDowns;

import java.time.Duration;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

public class DuplicateElementsInLIstBox {

	public static void main(String[] args) {
		
		WebDriver driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        driver.get("https://testautomationpractice.blogspot.com/");
        driver.manage().window().maximize();
        
//------ Initialize the Select class---* Locate the dropdown *-------------------------------------------------------------
        Select dropdown = new Select(driver.findElement(By.xpath("//select[@id='colors']")));
        //Select dropdown = new Select(driver.findElement(By.xpath("//select[@id='animals']")));
        
//----- Fetch all options in the dropdown---------------
        List<WebElement> options = dropdown.getOptions(); 
        
//------Extract text from options-------------------------
        List<String> optionTexts = new ArrayList<>();
        
        for (WebElement option : options) 
        {
            optionTexts.add(option.getText());
        }
        
//------Use Set to find duplicates-------------------------
        Set<String> uniqueElements = new HashSet<>();
        Set<String> duplicateElements = new HashSet<>();
        
        for (String text : optionTexts) 
        {
            if (!uniqueElements.add(text)) 
            {
                duplicateElements.add(text); // If not added to Set, it's a duplicate
            }
        }
        
//------Report the results---------------------------------
        if (duplicateElements.isEmpty()) 
        {
            System.out.println("No duplicate elements found in the list box.");
        } 
        else 
        {
            System.out.println("Duplicate elements in the list box: " + duplicateElements);
        }
        
        driver.quit();   // Close the browser
	}

}
