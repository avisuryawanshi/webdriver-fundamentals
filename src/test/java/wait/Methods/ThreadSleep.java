package wait.Methods;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class ThreadSleep {

	public static void main(String[] args) throws InterruptedException {
		
		//Thread method
		WebDriver driver=new ChromeDriver();
		driver.get("https://opensource-demo.orangehrmlive.com/web/index.php/auth/login");
        driver.manage().window().maximize();
        
        Thread.sleep(3000);  //pause the execution

        driver.findElement(By.xpath("//input[@placeholder='Username']")).sendKeys("Admin");
        driver.quit();
       


		

	}

}
