package mKeyboard.Actions;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

//----------------------------------------------------------------------------------
// Notes:
// - This script demonstrates how to perform basic keyboard actions using Selenium.
// - The sequence follows:
//   1. Typing text in the first text area.
//   2. Selecting the entire text (CTRL + A).
//   3. Copying the text to the clipboard (CTRL + C).
//   4. Moving to the second text area using the TAB key.
//   5. Pasting the copied text into the second text area (CTRL + V).
// - Useful for testing copy-paste functionality in web applications.
// ----------------------------------------------------------------------------------
public class KeyboardActions {

	public static void main(String[] args) {
		
		WebDriver driver=new ChromeDriver(); //Ctrl+shift+O
		driver.get("https://text-compare.com/");
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		
		// Locate the first text area and enter text "WELCOME"
		driver.findElement(By.xpath("//textarea[@id='inputText1']")).sendKeys("WELCOME");
		
		Actions act=new Actions(driver);
		
// --------------------------------------------------------------------------------------------------------
// Perform keyboard actions using the Actions class
// --------------------------------------------------------------------------------------------------------
		
		// CTRL + A (Select all text in the first text area)
		act.keyDown(Keys.CONTROL).sendKeys("A").keyUp(Keys.CONTROL).perform();
		
		// CTRL + C (Copy selected text to clipboard)
		act.keyDown(Keys.CONTROL).sendKeys("C").keyUp(Keys.CONTROL).perform();
		
		// Press TAB (Move focus to the second text area) shift to 2nd box
		act.keyDown(Keys.TAB).keyUp(Keys.TAB).perform();
		
		// CTRL + V (Paste the copied text into the second text area) pass the text
		act.keyDown(Keys.CONTROL).sendKeys("V").keyUp(Keys.CONTROL).perform();

	}

}
