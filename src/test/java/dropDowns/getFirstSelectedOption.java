package dropDowns;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

public class getFirstSelectedOption {

	public static void main(String[] args) {
		
		WebDriver driver=new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		driver.get("https://testautomationpractice.blogspot.com/");
		driver.manage().window().maximize();
		
//---	Use getFirstSelectedOption() to capture the selected first option.

		Select dropdown = new Select(driver.findElement(By.xpath("//select[@id='country']")));
		WebElement selectedOption = dropdown.getFirstSelectedOption();
		System.out.println("Selected option: " + selectedOption.getText());

 

	}

}
