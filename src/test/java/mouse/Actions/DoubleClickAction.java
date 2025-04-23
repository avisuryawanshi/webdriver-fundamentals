package mouse.Actions;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

public class DoubleClickAction {

	public static void main(String[] args) {
		
		WebDriver driver=new ChromeDriver(); //Ctrl+shift+O
		driver.get("https://www.w3schools.com/tags/tryit.asp?filename=tryhtml5_ev_ondblclick3");
		driver.manage().window().maximize();
		
		//switch to frame
		driver.switchTo().frame("iframeResult");
		
		// Locate input fields and the button
		WebElement inputbox1=driver.findElement(By.xpath("//input[@id='field1']"));
		WebElement inputbox2=driver.findElement(By.xpath("//input[@id='field2']"));
		WebElement button=driver.findElement(By.xpath("//button[normalize-space()='Copy Text']"));
		
		inputbox1.clear(); //clear existing values
		inputbox1.sendKeys("WELCOME"); // Enter text "WELCOME" into inputbox1
		
//----- Double click action on the button 
		Actions act=new Actions(driver);
		act.doubleClick(button).perform();
		
		// Validations: inputbox2 contains the same text or not ("WELCOME")
		String text=inputbox2.getDomAttribute("value");
		System.out.println("Captured value is: " + text);
		
		// Validate whether the text has been copied correctly
		if(text.equals("WELCOME"))
		{
			System.out.println("Text copied");
		}
		else
		{
			System.out.println("Text not copied properly...");
		}
		
		// Close the browser session
        //driver.quit();

	}

}
