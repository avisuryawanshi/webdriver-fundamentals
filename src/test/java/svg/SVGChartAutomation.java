package svg;

import java.io.File;
import java.io.IOException;
import java.util.List;

import javax.imageio.ImageIO;

import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

public class SVGChartAutomation {

	public static void main(String[] args) throws IOException {
		
        WebDriver driver = new ChromeDriver();
        driver.get("https://developers.google.com/chart/interactive/docs/gallery/barchart");
        driver.manage().window().maximize();

        // Handle iframe if the chart is inside one
        try 
        {
            driver.switchTo().frame(driver.findElement(By.tagName("iframe")));
        } 
        catch (NoSuchElementException e) 
        {
            System.out.println("No iframe detected. Proceeding...");
        }

        // Locate all bars in the SVG chart
        List<WebElement> bars = driver.findElements(By.xpath("//*[name()='svg']/*[name()='g']/*[name()='rect']"));

        // Initialize Actions class for mouse interactions
        Actions act = new Actions(driver);

        for (int i = 0; i < bars.size(); i++) 
        {
            WebElement bar = bars.get(i);
            act.moveToElement(bar).perform(); // Hover over each bar
            
            try 
            {
                // Locate tooltip text dynamically
                WebElement tooltip = driver.findElement(By.xpath("//*[name()='svg']/*[name()='g']/*[name()='text']"));
                
                // Print and validate tooltip
                String tooltipText = tooltip.getText();
                System.out.println("Tooltip " + (i + 1) + " Text: " + tooltipText);

                if (!tooltipText.isEmpty()) {
                    System.out.println("✅ Tooltip is displayed correctly!");

                    // Capture a screenshot
                    File screenshot = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
                    File destinationFile = new File("tooltip_" + (i + 1) + ".png");
                    ImageIO.write(ImageIO.read(screenshot), "png", destinationFile);
                    System.out.println("📸 Screenshot saved: " + destinationFile.getAbsolutePath());
                } 
                else 
                {
                    System.out.println("❌ Tooltip is missing!");
                }

            } catch (NoSuchElementException e) {
                System.out.println("⚠ Tooltip not found for bar " + (i + 1));
            }
        }

        // Close browser
       // driver.quit();

	}

}
