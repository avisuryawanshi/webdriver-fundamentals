package chromeOptions.features;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

/*
 * Scenario:
	In some cases, test automation needs to handle websites with expired, self-signed, or untrusted SSL certificates. 
	By default, browsers display a security warning and block access.
	
	Use Case:
	This test demonstrates how to configure Selenium’s ChromeOptions to bypass SSL certificate errors 
	and access a website with an invalid SSL certificate (https://expired.badssl.com/).
 */

public class HeadlessSSL {

	public static void main(String[] args) {

// ------------------------------------------------------------------------------------------------------------------------		
// 1) Scenario: Access a website with an expired SSL certificate in Selenium
// ------------------------------------------------------------------------------------------------------------------------	
		
		ChromeOptions options=new ChromeOptions();     //Create ChromeOptions instance
		options.setAcceptInsecureCerts(true);          //Enable accept SSL certificate  //Accept insecure SSL certificates
		
// ---- Initialize the Chrome WebDriver with configured options
		WebDriver driver=new ChromeDriver(options);    //Pass options to ChromeDriver
		
		driver.get("https://expired.badssl.com/");     // Navigate to a website with an expired SSL certificate
		driver.manage().window().maximize();
		
// ---- Print the title of the web page
		System.out.println("Title of the page: " + driver.getTitle()); //privacy error

// ------------------------------------------------------------------------------------------------------------------------			
// 2) Handle SSL certificate errors in headless mode
// ------------------------------------------------------------------------------------------------------------------------	
		
		/*ChromeOptions options = new ChromeOptions();
		options.addArguments("--headless=new");        // Run in headless mode
		
		options.setAcceptInsecureCerts(true);          // Accept insecure SSL certificates
		
// ---- Initialize the Chrome WebDriver with configured options
		WebDriver driver=new ChromeDriver(options);    //Pass options to ChromeDriver
		
		driver.get("https://expired.badssl.com/");     // Navigate to a website with an expired SSL certificate
		driver.manage().window().maximize();

// ---- Print the title of the web page
		System.out.println("Title of the page: " + driver.getTitle()); //privacy error*/
		
// ------------------------------------------------------------------------------------------------------------------------			
// 3)  Running Automation Tests in Different Browsers with SSL Issues
// ------------------------------------------------------------------------------------------------------------------------			
		
		
		driver.quit();
	}

}
