package windowAndFrame.Methods;

//---------------------------------------------------------------------------------------------------------
//Scenario: Handling multiple browser windows and converting window handles from Set to List
//---------------------------------------------------------------------------------------------------------
//1. Open the OrangeHRM login page (Main Window).
//2. Click on the "OrangeHRM, Inc" link to open a new browser window (Child Window).
//3. Retrieve all open window handles using getWindowHandles().
//4. Convert the Set of window handles to a List to allow easy indexing.
//5. Switch to the child window and print the title.
//6. Switch back to the main window and print the title.

import java.time.Duration;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class WindowHandlesConverterSetToList {

	public static void main(String[] args) throws InterruptedException {
		
		WebDriver driver = new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		
		driver.get("https://opensource-demo.orangehrmlive.com/web/index.php/auth/login"); //current browser window
		driver.manage().window().maximize();
		Thread.sleep(3000);
		// Click the "OrangeHRM, Inc" link to open a new browser window (Child Window)
		driver.findElement(By.xpath("//a[normalize-space()='OrangeHRM, Inc']")).click(); //open another browser window

//---------------------------------------------------------------------------------------------------------
// Step 1: Retrieve all open window handles and convert Set to List
//---------------------------------------------------------------------------------------------------------		
		Set<String> windowIds=driver.getWindowHandles(); //This retrieves a set of window handles (unique identifiers) for all open browser windows.
		System.out.println("Window Ids:" +windowIds);
		System.out.println("Total open windows: " + windowIds.size());
		
		//WindowHandleConverter – Convert Set to List for easy access using index.-----------------------------------
		List<String> windowList=new ArrayList<String>(windowIds);    
		
		// we have consider parent and child window browser // Assign parent and child window handles based on index
		String parentID=windowList.get(0);
		String childID=windowList.get (1);
		Thread.sleep(3000);     // Consider using explicit waits instead of Thread.sleep

//---------------------------------------------------------------------------------------------------------
// Step 2: Switch to child window and print the title
//---------------------------------------------------------------------------------------------------------
		driver.switchTo().window(childID);
		System.out.println("Switched to Child Window - Title: " + driver.getTitle()); // Expected: Human Resources Management Software | OrangeHRM
		//System.out.println(driver.getTitle()); //Human Resources Management Software | OrangeHRM
		Thread.sleep(3000);
				
//---------------------------------------------------------------------------------------------------------
// Step 3: Switch back to parent window and print the title
//---------------------------------------------------------------------------------------------------------
		driver.switchTo().window(parentID);
		//System.out.println(driver.getTitle());  //OrangeHRM
		System.out.println("Switched back to Parent Window - Title: " + driver.getTitle()); // Expected: OrangeHRM
		Thread.sleep(3000);
		
		driver.quit();

	}

}
