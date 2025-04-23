package brokenLinksDOM;

import java.net.HttpURLConnection;
import java.net.URL;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class BrokenLinksTest {

	public static void main(String[] args) {
		
		WebDriver driver = new ChromeDriver();
        driver.get("https://example.com"); // Replace with the actual URL
        driver.manage().window().maximize();

        // Get all links on the webpage
        List<WebElement> links = driver.findElements(By.tagName("a"));

        for (WebElement link : links) 
        {
            String url = link.getDomAttribute("href");
            if (url != null && !url.isEmpty()) {
                verifyBrokenLink(url);
            }
        }

        driver.quit();
    }

    public static void verifyBrokenLink(String linkUrl) {
        try {
            URL url = new URL(linkUrl);
            HttpURLConnection http = (HttpURLConnection) url.openConnection();
            http.setRequestMethod("HEAD");
            http.connect();
            int responseCode = http.getResponseCode();

            if (responseCode >= 400) 
            {
                System.out.println(linkUrl + " is a Broken Link! (Response Code: " + responseCode + ")");
            } 
            else 
            {
                System.out.println(linkUrl + " is a Valid Link! (Response Code: " + responseCode + ")");
            }

        } 
        catch (Exception e) 
        {
            System.out.println(linkUrl + " is a Broken Link! (Exception: " + e.getMessage() + ")");
        }

	}

}
