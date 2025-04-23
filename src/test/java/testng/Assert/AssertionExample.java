package testng.Assert;

import org.testng.Assert;
import org.testng.annotations.Test;

public class AssertionExample {
	
	   @Test
	    public void testTitle() 
	   {
	        String actualTitle = "TestNG Tutorial";
	        String expectedTitle = "TestNG Tutorial";
	        
	        Assert.assertEquals(actualTitle, expectedTitle, "Title does not match!");
	   }
	  
}
