package browserWindow.Management;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class quit {

	public static void main(String[] args) throws InterruptedException {
		
		WebDriver driver = new ChromeDriver();  //(CTRL+shift+O)	
		driver.get("https://opensource-demo.orangehrmlive.com/web/index.php/auth/login");
		driver.manage().window().maximize();
		Thread.sleep(5000);
        
        driver.findElement(By.linkText("OrangeHRM, Inc")).click(); //this will open new browser window  
		
        Thread.sleep(5000);
        driver.quit(); //close all the browser windows 

//This will throw an exception since the WebDriver session is terminated------------------------------------   
        
        /*WebDriver driver = new ChromeDriver();
        driver.get("https://www.google.com");
        // Quit the entire session (all open browser windows)
        driver.quit(); 
        
        // This will throw an exception since the WebDriver session is terminated
        driver.get("https://www.bing.com");  // SessionNotCreatedException*/

	}

}
