package getMethods;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

//----------------Browser & Page information Retrieval -----------------------------------------------

public class getPageTitle {

	public static void main(String[] args) {
		
		WebDriver driver = new ChromeDriver();  //(CTRL+shift+O)	
		driver.get("https://demo.opencart.com/");
		driver.manage().window().maximize();
		
//--------------------------------------------------------------------------------------------------------------
// Approach 1: Retrieve and print the page title 
//--------------------------------------------------------------------------------------------------------------		
		String actualTitle=driver.getTitle();                            // Get the page title
		System.out.println("The title of the page is:" +actualTitle);    // Print the title
		
		System.out.println("--------------------------------------");

//--------------------------------------------------------------------------------------------------------------
// Approach 2: Manually validate the title
//--------------------------------------------------------------------------------------------------------------		

//If you don't want to use TestNG or JUnit, you can print the result manually:
		
		String actualPageTitle = driver.getTitle();
		String expectedTitle = "Your Store";
		
		if(actualPageTitle.equals("Your Store"))
		    {
			System.out.println("Test Passed");  //Test Passed // If titles match
			}
		else
			{
			System.out.println("Test Failed");  // If titles do not match
			}
		
//--------------------------------------------------------------------------------------------------------------
// Approach 3: Validate title using TestNG (Commented)
//--------------------------------------------------------------------------------------------------------------
//Using Selenium with TestNG. Compare it with the expected title using assertions.
		
		/*@Test
	    public void validateTitle() {
	        String actualTitle = driver.getTitle();        // Get the actual title
	        String expectedTitle = "Google";               // Expected title
	        Assert.assertEquals(actualTitle, expectedTitle, "Title validation failed!");*/ // Compare titles using TestNG assertion
		
		driver.quit();
	}
}
