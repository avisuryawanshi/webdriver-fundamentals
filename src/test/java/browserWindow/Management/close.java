package browserWindow.Management;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class close {

	public static void main(String[] args) throws InterruptedException {
		
		WebDriver driver = new ChromeDriver();  //(CTRL+shift+O)	
		driver.get("https://opensource-demo.orangehrmlive.com/web/index.php/auth/login");
		driver.manage().window().fullscreen();
		Thread.sleep(5000);
        
        driver.findElement(By.linkText("OrangeHRM, Inc")).click(); //this will open new browser window  
		
        Thread.sleep(5000);
        driver.close(); //close single browser window wherever driver is focus 
        //driver.quit(); //close all the browser windows 
        
//This will throw an exception since the driver instance is still in memory----------------------------------
       
        /*WebDriver driver = new ChromeDriver();  //(CTRL+shift+O)	
		driver.get("https://opensource-demo.orangehrmlive.com/web/index.php/auth/login");
		driver.manage().window().maximize();
		Thread.sleep(5000);
        
        driver.findElement(By.linkText("OrangeHRM, Inc")).click(); //this will open new browser window  
		
        Thread.sleep(5000);
        driver.close();
        
        // This will throw an exception since the driver instance is still in memory
        driver.get("https://www.bing.com");  // NoSuchSessionException*/

	}

}
