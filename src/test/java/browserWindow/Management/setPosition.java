package browserWindow.Management;

import java.awt.Toolkit;

import org.openqa.selenium.Dimension;
import org.openqa.selenium.Point;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class setPosition {

	public static void main(String[] args) {
		
		 WebDriver driver = new ChromeDriver();
	     driver.get("https://opensource-demo.orangehrmlive.com/web/index.php/auth/login");
	     
//1st Approach----------------------------------------------------------------------		
	     
	     Point p = new Point(300, 200);
	     driver.manage().window().setPosition(p);
	     System.out.println("Window Position: " + p.getX() + "," + p.getY());
	     //driver.quit();

//2nd Approach-----setting negative coordinates------------------------

	     /*Point p = new Point(-100, -100);
	     driver.manage().window().setPosition(p);
	     System.out.println("Window Position: " + p.getX() + "," + p.getY());*/
	     
//3rd Approach----------------------------------------------------------------------- 
//handle an exception if an invalid position is set
	     
	     /*try 
	     	{
	    	    Point p = new Point(-5000, 5000);  // Invalid position
	    	    driver.manage().window().setPosition(p);
	     	} 
	     catch (IllegalArgumentException e) 
	     	{
	    	    System.out.println("Invalid window position: " + e.getMessage());
	    	}*/
	     
//4th Approach-----------------------------------------------------------------------      
//compare the expected and actual positions using getPosition().
	     
	     /*Point expectedPosition = new Point(200, 150);
	     driver.manage().window().setPosition(expectedPosition);

	     Point actualPosition = driver.manage().window().getPosition();
	     
	     if (actualPosition.equals(expectedPosition)) 
	     {
	         System.out.println("✅ Window position set correctly.");
	     } 
	     else 
	     {
	         System.out.println("❌ Window position mismatch.");
	     }
	     
//Use setSize() with Toolkit to get screen dimensions dynamically---(Not Recommanded)----------------------------------------------
	     
	  // Get screen dimensions dynamically
	        java.awt.Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
	        int width = (int) screenSize.getWidth();
	        int height = (int) screenSize.getHeight();
	        
	        // Set browser window size to screen size
	        org.openqa.selenium.Dimension browserSize = new org.openqa.selenium.Dimension(width, height);
	        driver.manage().window().setSize(browserSize);
	        
	        // Set browser window position to (0,0) so it starts from the top-left corner
	        driver.manage().window().setPosition(new Point(0, 0));
	        
	        System.out.println("✅ Browser window set dynamically to screen size: " + width + "x" + height);*/

	}

}
