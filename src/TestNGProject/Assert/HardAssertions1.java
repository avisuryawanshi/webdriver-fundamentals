package testng.Assert;

import org.testng.Assert;
import org.testng.annotations.Test;

public class HardAssertions1 {

			@Test
		    public void testEqual() 
			{
		        String expectedTitle = "Welcome to TestNG";
		        String actualTitle = "Welcome to TestNG";
		        Assert.assertEquals(actualTitle, expectedTitle, "Titles do not match!");
		    }
			
			@Test
		    public void testNotEqual() 
			{
		        int expectedValue = 100;
		        int actualValue = 90;
		        Assert.assertNotEquals(actualValue, expectedValue, "Values should not be equal!");
		    }
			
			@Test
		    public void testTrue() 
			{
		        boolean condition = (5 > 1);
		        Assert.assertTrue(condition, "Condition is not true!");
		    }
			
			@Test
		    public void testFalse() 
			{
		        boolean condition = (5 < 1);
		        Assert.assertFalse(condition, "Condition is not false!");
		    }
			
			@Test
		    public void testNull() 
			{
		        Object obj = null;
		        Assert.assertNull(obj, "Object is not null!");
		    }
			
			@Test
		    public void testNotNull() 
			{
		        Object obj = new Object();
		        Assert.assertNotNull(obj, "Object is null!");
		    }

}
