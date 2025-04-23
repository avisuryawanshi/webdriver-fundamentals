package svg;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import javax.imageio.ImageIO;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

public class SVGChartWithExcelValidation {

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

        // Load expected tooltip values from Excel
        List<String> expectedTooltips = readExcelData("TooltipData.xlsx");

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
                
                // Extract tooltip text
                String actualTooltip = tooltip.getText();
                System.out.println("Tooltip " + (i + 1) + " Text: " + actualTooltip);

                // Validate against expected value
                if (i < expectedTooltips.size()) 
                {
                    String expectedTooltip = expectedTooltips.get(i);
                    if (actualTooltip.equals(expectedTooltip)) 
                    {
                        System.out.println("✅ Tooltip validation PASSED for bar " + (i + 1));
                    } 
                    else 
                    {
                        System.out.println("❌ Tooltip validation FAILED for bar " + (i + 1));
                        System.out.println("   Expected: " + expectedTooltip);
                        System.out.println("   Actual: " + actualTooltip);

                        // Take a screenshot on failure
                        File screenshot = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
                        File destinationFile = new File("tooltip_mismatch_" + (i + 1) + ".png");
                        ImageIO.write(ImageIO.read(screenshot), "png", destinationFile);
                        System.out.println("📸 Screenshot saved: " + destinationFile.getAbsolutePath());
                    }
                }

            } 
            catch (NoSuchElementException e) 
            {
                System.out.println("⚠ Tooltip not found for bar " + (i + 1));
            }
        }

        // Close browser
        driver.quit();
    }

    // Method to read expected tooltip values from an Excel file
    public static List<String> readExcelData(String filePath) throws IOException {
        List<String> tooltipValues = new ArrayList<>();
        FileInputStream file = new FileInputStream(new File(filePath));
        Workbook workbook = new XSSFWorkbook(file);
        Sheet sheet = workbook.getSheetAt(0);

        Iterator<Row> rowIterator = sheet.iterator();
        while (rowIterator.hasNext()) 
        {
            Row row = rowIterator.next();
            Cell cell = row.getCell(0); // Assuming tooltip values are in the first column
            tooltipValues.add(cell.getStringCellValue());
        }

        workbook.close();
        return tooltipValues;

	}

}
