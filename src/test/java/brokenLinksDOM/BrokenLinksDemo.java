package brokenLinksDOM;

import java.net.HttpURLConnection;
import java.net.URL;
import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

/*
1)Verify the Link Contains an href Attribute with a Valid URL  <a href="https://example.com">Example</a>
2)Send the href Attribute/ URL to the Server
3)Verify the Status Code  
                    ≥ 400: Indicates the link is broken 
                    < 400: Indicates the link is functional (not broken)
*/

public class BrokenLinksDemo {

	public static void main(String[] args) {
		
		WebDriver driver=new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		driver.manage().window().maximize();
		driver.get("http://www.deadlinkcity.com/");

		 List<WebElement> links =driver.findElements(By.tagName("a"));   // capture/Find all links on the web page
		 System.out.println("Total number of links:"+ links.size());
		 
		 int noOfBrokenLinks=0;    //Count the Broken Links. Before starting the loop, initialize a counter for broken links
		 
		// Check each link
         for (WebElement linkElement : links) 
         {
             String hrefAttValueURL = linkElement.getAttribute("href");

             if (hrefAttValueURL == null || hrefAttValueURL.isEmpty()) 
             {
                 System.out.println("href Attribute Value is null or empty or null URL");
                 continue;
             }

         // Verify the URL
             try
             {
	             URL linkURL=new URL(hrefAttValueURL); //converted href value from link to URL format
	             HttpURLConnection conn = (HttpURLConnection)linkURL.openConnection();  //open connection to the server
	             conn.setConnectTimeout(5000); // Optional: Set connection timeout
	             conn.connect();   //connect to server and sent request to the server 
	             
	             if(conn.getResponseCode()>=400)    //Once connected, capture the response code from the server
	             {                                              //getResponseCode() method provides the HTTP status code returned by the server.
	            	 System.out.println(hrefAttValueURL+"======>Broken link");    // Printing Results
	            	 noOfBrokenLinks++;       // Every time a broken link is found (inside the if block), increment the counter
	             }
	             else
	             {
	            	 System.out.println("Not broken link");      // Printing Results
	             }
             }
             catch(Exception e) 
             {
            	 System.out.println(hrefAttValueURL + " is a broken link (Error: " + e.getMessage() + ")");
             }
         
         }
		 
         System.out.println("Number of broken links:"+ noOfBrokenLinks);
	}
	

}
