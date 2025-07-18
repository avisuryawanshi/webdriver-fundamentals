package launchBrowser;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import testng.email.SendEmailReport;

/*Application run on a single browser
	• Running from IDE: I can execute the tests directly from my IDE by right-clicking on the test class or method and selecting "Run."

Test case steps:
1) Launch browser (chrome)                first step I want to launch my Chrome browser
2) Open URL https://demo.opencart.com/    I want to open this application URL 
3) Validate title should be "Your Store"  I want to check the title of the page
4) quit browser                           close the browser
*/

public class SingleBrowserTest {

public static void main(String[] args) {
		
//1)--- Launch browser (chrome)
		WebDriver driver = new ChromeDriver();  //(CTRL+shift+O)	
		
		//Alternative browser options:
		//ChromeDriver driver = new ChromeDriver(); 
		//WebDriver driver=new EdgeDriver();
		//WebDriver driver=new FirefoxDriver();
		
//2)--- Open URL https://demo.opencart.com/ 
		driver.get("https://demo.opencart.com/");
		driver.manage().window().maximize();
		
//3)--- Validate title should be "Your Store"
		String actualTitle = driver.getTitle();  
		System.out.println("The title of the page is: " + actualTitle);

//4)--- Check if the actual title matches the expected title
		if(actualTitle.equals("Your Store"))
		    {
			System.out.println("Title validation passed!");
			}
			else
			{
			System.out.println("Title validation Failed!");
			}
		
		// 4) quit browser
		//driver.close(); //while using this method will get-> java.net.SocketException: Connection reset // Avoids java.net.SocketException: Connection reset error
		driver.quit();    // Properly closes the entire browser session
		
// Send email ===========================================================================================================
// Trigger email sending here
	    try 
	    {
	        SendEmailReport.sendReport();  // Email utility class call
	    } 
	    catch (Exception e) 
	    {
	        System.out.println("[ERROR] Failed to send email report.");
	        e.printStackTrace();
	    }
		}
}
