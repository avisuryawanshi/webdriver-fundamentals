package windowAndFrame.Methods;

//---------------------------------------------------------------------------------------------------------
//Scenario: Handling multiple browser windows using a loop
//---------------------------------------------------------------------------------------------------------
//1. Open the OrangeHRM login page.
//2. Click on the "OrangeHRM, Inc" link to open a new browser window.
//3. Retrieve all open window handles using getWindowHandles().
//4. Switch between multiple windows and perform actions using a loop.
//5. Validate and print window titles and URLs.
//6. Close specific windows based on their titles.

import java.time.Duration;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class WindowIteratorLopping {

	public static void main(String[] args) throws InterruptedException {
		
		WebDriver driver = new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		
		driver.get("https://opensource-demo.orangehrmlive.com/web/index.php/auth/login"); //current browser window
		driver.manage().window().maximize();
		Thread.sleep(3000);
		
		driver.findElement(By.xpath("//a[normalize-space()='OrangeHRM, Inc']")).click(); //open another browser window
		
//---------------------------------------------------------------------------------------------------------
// Retrieving window handles and printing window details
//---------------------------------------------------------------------------------------------------------		
		Set<String> windowIds=driver.getWindowHandles(); //This retrieves a set of window handles (unique identifiers) for all open browser windows.
		System.out.println("Window Ids:" +windowIds);  //Window Ids:[77331E530418687867FA8529C2068846, 938BE09C1940FB371A7072A1B31888A6] // Print all window IDs
		System.out.println("Total open windows: " + windowIds.size()); //Total open windows: 2  // Print the total number of open windows

//---------------------------------------------------------------------------------------------------------
// Approach-2 looping statement- if you have multiple windows
// Handles switching between multiple windows *simple way*
//---------------------------------------------------------------------------------------------------------

		for (String handle : windowIds)                                         // Loop through each window handle and switch to it
		{
            driver.switchTo().window(handle);
            System.out.println("Switched to window: " + driver.getTitle());     // Print the title and URL of the currently switched window
            System.out.println("Switched to window: " + driver.getCurrentUrl());
        }
		
//---------------------------------------------------------------------------------------------------------
// Approach-3: Handling specific windows based on title validation
// Checks if the title of the window matches/---fetching getCurrentUrl
//---------------------------------------------------------------------------------------------------------		
		/*for(String winId:windowIds)
			{
			String title=driver.switchTo().window(winId).getTitle(); //Retrieves the title of the currently focused window.
					
				if(title.equals("OrangeHRM")) // validation on parent window "OrangeHRM" Checks if the title of the window matches “OrangeHRM.”
				{
					System.out.println(driver.getCurrentUrl()); //If true, it prints the current URL of that window. https://opensource-demo.orangehrmlive.com/web/index.php/auth/login
				}
					
				if(title.equals("Human Resources Management Software | OrangeHRM")) // validation on child window "Human Resources Management Software | OrangeHRM"
				{
					System.out.println(driver.getCurrentUrl());  //https://www.orangehrm.com/
				}
				
				if(title.equals("OrangeHRM") || title.equals("Human Resources Management Software | OrangeHRM")) //close both browser window
				{
					driver.close();
				}
			}*/
	}

}
