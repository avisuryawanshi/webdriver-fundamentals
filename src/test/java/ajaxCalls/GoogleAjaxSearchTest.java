package ajaxCalls;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

/*
 * // 📌 **Test Scenario:**
        // 1️ Open Google homepage.
        // 2️ Type "Selenium WebDriver" in the search box.
        // 3️ Capture and print all AJAX-based search suggestions.
        // 4️ Click on a suggestion containing "tutorial".
        // 5️ Verify that the search results page is loaded.
        // 6️ Close the browser.
 */

public class GoogleAjaxSearchTest {

	public static void main(String[] args) throws InterruptedException {
		
		// ✅ Step 1: Initialize WebDriver
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();

        // ✅ Step 2: Navigate to Google search
        driver.get("https://www.google.com");
    
        // Optional: If a cookie pop-up appears, click the "Accept All" button (uncomment if needed)
        //driver.findElement(By.xpath("//button[@class='M6CB1c rr4y5c']")).click();

// ===========================================================================================================================
// ✅ Step 3: Find search box and enter text 
// Locate the Google search box and enter the query "Selenium WebDriver"
// ===========================================================================================================================
        
        WebElement searchBox = driver.findElement(By.name("q"));
        searchBox.sendKeys("Selenium WebDriver");
        
// ===========================================================================================================================        
// ✅ Step 4: Wait for AJAX suggestions to load
// Use Explicit Wait to wait for the AJAX-generated suggestion list to appear
// ===========================================================================================================================
        
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        List<WebElement> suggestions = wait.until(ExpectedConditions.presenceOfAllElementsLocatedBy(By.xpath("//ul[@role='listbox']//li")));
        
// ===========================================================================================================================       
// ✅ Step 5: Print all suggestions 
// Count and display the number of suggestions found
// ===========================================================================================================================
        
        System.out.println("Total Suggestions: " + suggestions.size());
        
        // Loop through the suggestions and print their text content
        for (WebElement suggestion : suggestions) 
        {
            System.out.println("Suggestion: " + suggestion.getText()); //Loaded Content: AJAX Content Loaded
            //System.out.println("Loaded Content: " + suggestion.getText()); 
        }

// ===========================================================================================================================        
// ✅ Step 6: Click on a specific suggestion (e.g., "Selenium WebDriver tutorial") 
// Iterate through the suggestions and select one containing the word "tutorial"
// ===========================================================================================================================       
       
        for (WebElement suggestion : suggestions) 
        {
            if (suggestion.getText().contains("tutorial")) 
            {
                suggestion.click(); // Click on the matched suggestion
                break;              // Exit the loop after clicking
            }
        }

// ✅ Step 7: Verify search results page is loaded -------------------------------------------------
        // Wait until the search results page title contains "Selenium WebDriver tutorial"
        /*wait.until(ExpectedConditions.titleContains("Selenium WebDriver tutorial"));
        System.out.println("✅ Search results page loaded successfully!");

// ✅ Step 8: Close browser
        //driver.quit();*/

	}

}
