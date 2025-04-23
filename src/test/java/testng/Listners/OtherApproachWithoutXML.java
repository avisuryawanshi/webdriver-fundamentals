package testng.Listners;

//not using this approach

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

// ====================== Not using this approach ===========================================

@Listeners(testng.Listners.MyListener.class)
public class OtherApproachWithoutXML {
 
WebDriver driver;    
    
    @BeforeClass
    void setup() throws InterruptedException
    {
    driver=new ChromeDriver();    

    driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
    driver.get("https://opensource-demo.orangehrmlive.com/web/index.php/auth/login");
    driver.manage().window().maximize();
    Thread.sleep(3000);
    }

    @Test(priority=1)
    void testlogo() throws InterruptedException
    {
       boolean status=driver.findElement(By.xpath("//img[@alt='company-branding']")).isDisplayed();
	   Assert.assertEquals(status, true);
    //System.out.println("logo displayed..."+status);
    }

    @Test(priority=2)
    void testAppUrl()
    {
    	Assert.assertEquals(driver.getCurrentUrl(),"https://opensource-demo.orangehrmlive.com/");
    }

    @Test(priority=3, dependsOnMethods= {"testAppUrl"})
    void testHomePageTitle()
    {
    	Assert.assertEquals(driver.getTitle(),"OrangeHRM");
    }
    
    @AfterClass
    void teardown()
    {
    	driver.quit();
    }
 
}


