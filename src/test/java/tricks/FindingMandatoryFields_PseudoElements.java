package tricks;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class FindingMandatoryFields_PseudoElements {

	public static void main(String[] args) {
		
        WebDriver driver=new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        driver.get("https://tutorialsninja.com/demo/index.php?route=account/register");// Open the registration page
		//driver.get("https://demo.opencart.com/en-gb?route=account/register");
		driver.manage().window().maximize();
		
// ---- Locate all label elements within the registration form
		//List<WebElement> elements=driver.findElements(By.xpath("//form[@id='form-register']//label"));
		List<WebElement> requiredFields = driver.findElements(By.xpath("//form[@class='form-horizontal']//label"));
		System.out.println("Mandatory Fields Count: " + requiredFields.size());
		//System.out.println("Fields with '*' in label: " + requiredFields.size());
		System.out.println("----------------------------------------");
		
// ---- Create a JavaScript Executor instance -----------------------------------------------------------------------------------------------
		JavascriptExecutor js = (JavascriptExecutor) driver; 
		
// ---- Iterate through each label element to check for pseudo-elements
		for(WebElement field:requiredFields)
		{
			//System.out.println(field.getText());
			//Execute JavaScript to get the pseudo-element content
			//String content=js.executeScript(script, element).toString(); // Execute the JavaScript and retrieve the pseudo-element content
			
// -------- JavaScript to retrieve the content of the ::before pseudo-element
		    String script="return window.getComputedStyle(arguments[0], '::Before').getPropertyValue('content');";
		    String pseudoContent = (String) js.executeScript(script, field);
		    //System.out.println("Pseudo-element content: " + pseudoContent);
		
// ------ Check if the pseudo-element contains an asterisk (*) indicating a required field
		  if (pseudoContent.contains("*")) //if (pseudoContent != null && pseudoContent.contains("*")) 
		    {
		        System.out.println("Mandatory Field: " + field.getText());
		    }
	      else
		    {
		    	System.out.println("Not Mandatory Field" + field.getText());
		    }	
		}
		
		System.out.println("--------------------------------------------------");
		
// ======================================================================================================================	
// Checking Field Border or Background Color
// Some forms highlight mandatory fields visually (e.g., red border).
// ======================================================================================================================	
		
		// Checking Field Border or Background Color for additional validation
		String script = "return window.getComputedStyle(arguments[0]).getPropertyValue('border-color');";
		WebElement field = driver.findElement(By.xpath("//form[@class='form-horizontal']//label"));
		String borderColor = (String) ((JavascriptExecutor) driver).executeScript(script, field);
		
		// Print detected border color (useful for identifying required fields with visual cues)S
		System.out.println("Field Border Color: " + borderColor);

			driver.quit();
	}

}
