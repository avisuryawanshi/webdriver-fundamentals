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
 * Project Title:
	📌 "Automating Flight Search on an AJAX-Based Travel Website"

🔹 Project Overview:
		Many travel websites use AJAX to fetch flight details dynamically when users search for flights. 
		In this project, we'll automate the flight search functionality of an AJAX-based web application, 
		ensuring that the results load correctly without a full page refresh.
 */
public class FlightSearchAutomation {

	public static void main(String[] args) throws InterruptedException {

/*
 * 🔹 Scenario: Automating Flight Search with AJAX Handling
		🔸 Steps to Automate:
			1. Open the travel website (e.g., https://www.cleartrip.com/).
			2. Select the From and To locations (AJAX dropdown).
			3. Pick a travel date.
			4. Click on the Search Flights button.
			5. Wait for AJAX results to load.
			6. Extract and print flight details.
 */
        WebDriver driver = new ChromeDriver();

//===== ✅ Step 2: Open Travel Website ==========================================================================
        driver.get("https://www.cleartrip.com/");
        driver.manage().window().maximize();
        System.out.println("✅ Navigated to the Cleartrip website.");
        
        driver.findElement(By.xpath("//div[@class='pb-1 px-1 flex flex-middle nmx-1']//*[name()='svg']")).click();
        //Thread.sleep(3000);
        
//===== ✅ Step 3: Select 'From' Location (Handling AJAX suggestions) ===========================================
        WebElement fromCity = driver.findElement(By.xpath("//input[@placeholder='Where from?']"));
        fromCity.sendKeys("pune");
        System.out.println("✅ Entered destination city: Pune");
        Thread.sleep(3000);

        // Wait for AJAX dropdown to load and select the first suggestion
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        List<WebElement> fromSuggestions = wait.until(ExpectedConditions.presenceOfAllElementsLocatedBy(By.xpath("//div[@class='sc-aXZVg bXugJh row']//div[1]//div[2]//ul[1]")));
        fromSuggestions.get(0).click();
        System.out.println("✅ Selected suggestion for 'To' location.");
       

//===== ✅ Step 4: Select 'To' Location (Handling AJAX suggestions) ==============================================
        WebElement toCity = driver.findElement(By.xpath("//input[@placeholder='Where to?']"));
        toCity.sendKeys("mumbai");
        System.out.println("✅ Entered destination city: mu");

        // Wait for AJAX dropdown to load and select the first suggestion
        List<WebElement> toSuggestions = wait.until(ExpectedConditions.presenceOfAllElementsLocatedBy(By.xpath("//div[@class='dropdown p-absolute t-13 ln-1 w-100p']")));
        toSuggestions.get(0).click();
        System.out.println("✅ Selected first suggestion for 'To' location.");

//===== ✅ Step 5: Click on 'Search Flights' ======================================================================
        driver.findElement(By.xpath("//button[@class='sc-dAlyuH hzVhEm flex-1']")).click();
        System.out.println("✅ Clicked on 'Search Flights' button.");

//===== ✅ Step 6: Wait for AJAX-based flight results to load =====================================================
        wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//div[@data-testid='flightCard']")));
        System.out.println("✅ Flight search results loaded successfully.");

//===== ✅ Step 7: Extract and Print Flight Details ===============================================================
        List<WebElement> flights = driver.findElements(By.xpath("//div[@data-testid='flightCard']"));
        System.out.println("✅ Total Flights Found: " + flights.size());
        
        //🔹 Traditional for Loop
        for (WebElement flight : flights) 
        {
            System.out.println("✈ Flight Details: " + flight.getText());
            System.out.println("----------------------------------");
        }
        
        //🔹 Replace Traditional for-each Loop with forEach(). Optimized forEach() Method
        // ✅ Print Flight Details Using Lambda Expression
        //flights.forEach(flight -> System.out.println("✈ Flight Details: " + flight.getText()));*/

        
        
        //driver.quit();
        //System.out.println("✅ Browser closed successfully.");

	}

}
