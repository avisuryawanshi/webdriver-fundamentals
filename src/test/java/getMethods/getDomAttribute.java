package getMethods;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

public class getDomAttribute {

	public static void main(String[] args) {

		WebDriver driver = new ChromeDriver();  //(CTRL+shift+O)	
		driver.get("https://naveenautomationlabs.com/opencart/index.php?route=account/login");
		driver.manage().window().maximize();
		
// --------- Deprecated method (getAttribute) - Not in use ---------------------------------------------------------------------------
        /* 
         * The getAttribute() method is now deprecated for fetching DOM attributes.
         * Instead, we use getDomAttribute() or getDomProperty().
         */
		
		/*driver.findElement(By.id("input-email")).getAttribute("placeholder");
		System.out.println("placeholdervalue");*/
//-------------------------------------------------------------------------------------------------------------------------------------		
		driver.findElement(By.id("input-email")).getDomAttribute("placeholder");
		System.out.println("placeholdervalue");
		
        System.out.println("-----------------------------------------------");
//------------------------------------------------------------------------------------------------------------------------------------		
		// Fetching attribute value from the DOM
		WebElement element=driver.findElement(By.id("input-email"));
        String domValue = element.getDomAttribute("placeholder");
        String domValue1 = element.getDomProperty("placeholder");
        
        System.out.println("DOM Attribute Value: " + domValue);
        System.out.println("DOM Property Value: " + domValue1);
        
        System.out.println("-----------------------------------------------");
        
//-------------------------------------------------------------------------------------------------------------------------------------
// Using sendKeys() and fetching input field values  
//-------------------------------------------------------------------------------------------------------------------------------------		
       
        driver.findElement(By.id("input-email")).sendKeys("avinash@gmail.com");  //using send keys
        String valueAttr=driver.findElement(By.id("input-email")).getDomProperty("value");
        System.out.println(valueAttr);
        
        String placeholderVal=driver.findElement(By.id("input-email")).getDomAttribute("placeholder");
        String nameVal=driver.findElement(By.id("input-email")).getDomProperty("name");          
        
        // Print values
        System.out.println("Value entered in the input field: " + valueAttr);
        System.out.println("Placeholder value: " + placeholderVal);
        System.out.println("Name attribute value: " + nameVal);
        System.out.println(placeholderVal);
        System.out.println(nameVal);
       
        driver.quit();
	}

}
