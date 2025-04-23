package frames;

import java.time.Duration;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class handleframes {

	public static void main(String[] args) {
		
		WebDriver driver=new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

		driver.get("https://ui.vision/demo/webtest/frames/");
		driver.manage().window().maximize();

		//Frame1
		WebElement frame1=driver.findElement(By.xpath("//frame[@src='frame_1.html']")); //Switch to Frame 1 and Perform Action
		driver.switchTo().frame(frame1);      //passed frame as a WebElement
		driver.findElement(By.xpath("//input[@name='mytext1']")).sendKeys("WELCOME");
		
		driver.switchTo().defaultContent(); //Switch Back to the Main Page
		
		//Frame2
		WebElement frame2=driver.findElement(By.xpath("//frame[@src='frame_2.html']")); //Switch to Frame 2 and Perform Action
		driver.switchTo().frame(frame2);      //passed frame as a WebElement
		driver.findElement(By.xpath("//input[@name='mytext2']")).sendKeys("selenium");

		driver.switchTo().defaultContent(); //Switch Back to the Main Page Again
		
		//Frame3
		WebElement frame3=driver.findElement(By.xpath("//frame[@src='frame_3.html']"));
		driver.switchTo().frame(frame3);      //passed frame as a WebElement
		driver.findElement(By.xpath("//input[@name='mytext3']")).sendKeys("java");
		
		driver.switchTo().defaultContent(); //Switch Back to the Main Page Again
		
		//inner frame - part of frame 3 itself
		driver.switchTo().frame(0);    //switching to frame using index
		
		//driver.findElement(By.xpath("//div[@id='i9']//div[@class='AB7Lab Id5V1']")).click(); // Perform an action on an element in the inner frame
		
		WebElement rdbutton=driver.findElement(By.xpath("//div[@id='i6']//div[@class='AB7Lab Id5V1']"));
		JavascriptExecutor js=(JavascriptExecutor)driver;
		js.executeScript("arguments[0].click();",rdbutton);
		
		driver.switchTo().defaultContent();  // Switch back to the main page
		
		System.out.println(driver.getPageSource());

	}

}
