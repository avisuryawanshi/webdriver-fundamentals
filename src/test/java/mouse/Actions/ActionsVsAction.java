package mouse.Actions;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Action;
import org.openqa.selenium.interactions.Actions;

public class ActionsVsAction {

public static void main(String[] args) {
		
WebDriver driver=new ChromeDriver(); //Ctrl+shift+O
		
		driver.get("https://swisnl.github.io/jQuery-contextMenu/demo.html");
		driver.manage().window().maximize();
		
		WebElement button=driver.findElement(By.xpath("//span[@class='context-menu-one btn btn-neutral']"));
		
		// Actions class is used to perform mouse interactions like right-click, drag and drop, etc.
		Actions act=new Actions(driver);
		
//----------------------------------------------------------------------------------------------------------------		
// Actions - // Performing right-click action directly using perform() method	
//----------------------------------------------------------------------------------------------------------------	
		
		act.contextClick(button).perform(); // Right-clicks on the button
        System.out.println("Right-click action performed using Actions class.");
		
//----------------------------------------------------------------------------------------------------------------		
// Action - // Action interface is used to store the created action before execution
//----------------------------------------------------------------------------------------------------------------		
        
		Action myAction=act.contextClick(button).build(); // Building the right-click action
        myAction.perform();   // Performing the stored action
        //System.out.println("Right-click action stored in Action interface.");
        System.out.println("Stored action executed successfully.");
        

	}

}
