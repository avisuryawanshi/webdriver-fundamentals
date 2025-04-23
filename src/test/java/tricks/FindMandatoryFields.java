package tricks;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class FindMandatoryFields {

	public static void main(String[] args) {
		
		// Set up WebDriver (Ensure the correct WebDriver is installed)
        WebDriver driver = new ChromeDriver();
        driver.get("https://tutorialsninja.com/demo/index.php?route=account/register"); // Replace with actual page URL

        // 1. Find Fields with 'required' Attribute
        List<WebElement> requiredFields = driver.findElements(By.xpath("//form[@class='form-horizontal']//label"));
        System.out.println("Fields with 'required' attribute: " + requiredFields.size());
        
        for (WebElement field : requiredFields) 
        {
            System.out.println("Field Name: " + field.getDomAttribute("for"));
        }

        // 3. Find Fields Marked with '*' in Label
        List<WebElement> starLabels = driver.findElements(By.xpath("//label[@class='col-sm-2 control-label']"));
        System.out.println("Fields with '*' in label: " + starLabels.size());
        
        for (WebElement label : starLabels) 
        {
            System.out.println("Label Text: " + label.getText());         
        }

        // 4. Detect Pseudo-Elements (::before or ::after) using JavaScript
        /*JavascriptExecutor js = (JavascriptExecutor) driver;
        List<WebElement> inputFields = driver.findElements(By.tagName("input"));
        
        for (WebElement field : inputFields) 
        {
            String script = "return window.getComputedStyle(arguments[0], '::before').getPropertyValue('content') || "
                    + "window.getComputedStyle(arguments[0], '::after').getPropertyValue('content');";
            String pseudoContent = (String) js.executeScript(script, field);
            
            if (pseudoContent != null && !pseudoContent.equals("none")) 
            {
                System.out.println("Field with pseudo-element indicator: " + field.getDomAttribute("name"));
            }
        }

        // 5. Check for Red Border (Common Visual Indicator for Mandatory Fields)
        for (WebElement field : inputFields) 
        {
            String borderColor = (String) js.executeScript(
                "return window.getComputedStyle(arguments[0]).getPropertyValue('border-color');", field);
            
            if (borderColor.equals("rgb(255, 0, 0)")) // Adjust based on actual site styling
            { 
                System.out.println("Field with red border (potentially required): " + field.getDomAttribute("name"));
            }
        }*/

        // Close Browser
        driver.quit();

	}

}
