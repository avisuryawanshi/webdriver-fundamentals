package AutomateInternetSpeed;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class SpeedTest {

	public static void main(String[] args) {
		
		// Alternative Approach: ---------------------------------------------------------------------------        
	       
			 // ✅ Step 1: Initialize the WebDriver (ChromeDriver)
	        WebDriver driver = new ChromeDriver();
	        driver.manage().window().maximize();

	        // ✅ Step 2: Navigate to the SpeedTest website
	        driver.get("https://www.speedtest.net/");
	        
	        // ✅ Step 3: Click on the "Go" button to start the test
	        WebElement goButton = driver.findElement(By.xpath("//span[contains(text(),'Go')]"));
	        goButton.click();

	        // ✅ Step 4: Wait for the test to complete (Adjust time as needed)
	        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(60));

	        // ✅ Step 5: Extract and display the download speed
	        WebElement downloadSpeed = driver.findElement(By.xpath("//div[contains(@class, 'result-item-download')]//span[contains(@class, 'download-speed')]"));
	        System.out.println("Download Speed: " + downloadSpeed.getText() + " Mbps");

	        // ✅ Step 6: Extract and display the upload speed
	        WebElement uploadSpeed = driver.findElement(By.xpath("//div[contains(@class, 'result-item-upload')]//span[contains(@class, 'upload-speed')]"));
	        System.out.println("Upload Speed: " + uploadSpeed.getText() + " Mbps");

	        // ✅ Step 7: Close the browser session
	        //driver.quit();

	}

}
