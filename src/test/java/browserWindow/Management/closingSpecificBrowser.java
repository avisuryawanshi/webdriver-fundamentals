package browserWindow.Management;

import java.time.Duration;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

/*Scenario:
creating new class ClosingSpecificBrowserWindow  taking main method  
I launch my application, maximized it, click on the link,  so this will open another browser window and then I captured both the window IDs 
now I have a two browser windows as soon as you have done this two browser windows are open. 
now I want to close whichever browser window open I want to I want to close it.*/

public class closingSpecificBrowser {

	public static void main(String[] args) {
		
		WebDriver driver = new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		
		driver.navigate().to("https://opensource-demo.orangehrmlive.com/web/index.php/auth/login"); //current browser window
		driver.manage().window().maximize();
		
		driver.findElement(By.xpath("//a[normalize-space()='OrangeHRM, Inc']")).click(); //open another browser window
		Set<String> windowIDs=driver.getWindowHandles(); //This retrieves a set of window handles (unique identifiers) for all open browser windows.

//based on the condition we can close the specific browser window

		for(String winId:windowIDs)
		{
			String title=driver.switchTo().window(winId).getTitle();
			  //String url=driver.switchTo().window(winId).getCurrentUrl();

			System.out.println(title); 
			
				//if(title.equals("OrangeHRM")) //close the Parent browser window
			//if(title.equals("Human Resources Management Software | OrangeHRM")) //close the child browser window

			if(title.equals("OrangeHRM") || title.equals("Human Resources Management Software | OrangeHRM")) //close both browser window
			{
				driver.close();
			}
		}


	}

}
