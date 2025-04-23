package mouse.Actions;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

public class DragAndDropAction {

	public static void main(String[] args) {
		
		WebDriver driver=new ChromeDriver(); 
		driver.get("http://dhtmlgoodies.com/scripts/drag-drop-custom/demo-drag-drop-3.html");
		driver.manage().window().maximize();

		Actions act=new Actions(driver);

// ------------------------------------------------------------------------------------------------
// Drag and drop operation 1: Move "Rome" (Capital) to "Italy" (Country)
// ------------------------------------------------------------------------------------------------	
		WebElement rome=driver.findElement(By.xpath("//div[@id='box6']"));
		WebElement italy=driver.findElement(By.xpath("//div[@id='box106']"));
		
		act.dragAndDrop(rome, italy).perform();
		
		/*// Verification step: Check if the element has been dropped correctly
        if (rome.getDomAttribute("class").contains("dragableBox")) 
        {
            System.out.println("Rome successfully dropped in Italy.");
        }
        else 
        {
            System.out.println("Failed to drop Rome in Italy.");
        }*/
		
// ------------------------------------------------------------------------------------------------		
// Drag and drop operation 2: Move "Washington" (Capital) to "United States" (Country)
// ------------------------------------------------------------------------------------------------
        WebElement washington=driver.findElement(By.xpath("//div[@id='box3']"));
		WebElement unitedstates=driver.findElement(By.xpath("//div[@id='box103']"));
				
		act.dragAndDrop(washington, unitedstates).perform();
		
		/*// Verification step: Check if the element has been dropped correctly
        if (washington.getDomAttribute("class").contains("dragableBox")) 
        {
            System.out.println("Washington successfully dropped in United States.");
        } 
        else 
        {
            System.out.println("Failed to drop Washington in United States.");
        }*/
		
        //driver.quit();
		
	}

}
