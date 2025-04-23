package testng.BasicAsserts;

import org.testng.Assert;
import org.testng.annotations.Test;

/**
 * 	▪ In this example:
	▪ testEqual() checks if the actual title matches the expected title.
	▪ testNotEqual() checks if the actual value is not equal to the expected value.
	▪ testTrue() checks if the condition is true.
	▪ testFalse() checks if the condition is false.
	▪ testNull() checks if the object is null.
	▪ testNotNull() checks if the object is not null.
These assertions help ensure that your test cases validate the expected outcomes correctly.
 */

public class TestNGExample {
	
		@Test
	    public void testEqual() {
	        String expectedTitle = "Welcome to TestNG";
	        String actualTitle   = "Welcome to TestNG";
	        Assert.assertEquals(actualTitle, expectedTitle, "Titles do not match!");
	    }
		
		@Test
	    public void testNotEqual() {
	        int expectedValue = 100;
	        int actualValue   = 90;
	        Assert.assertNotEquals(actualValue, expectedValue, "Values should not be equal!");
	    }
		
		@Test
	    public void testTrue() {
	        boolean condition = (5 > 1);
	        Assert.assertTrue(condition, "Condition is not true!");
	    }
		
		@Test
	    public void testFalse() {
	        boolean condition = (5 < 1);
	        Assert.assertFalse(condition, "Condition is not false!");
	    }
		
		@Test
	    public void testNull() {
	        Object obj = null;
	        Assert.assertNull(obj, "Object is not null!");
	    }
		
		@Test
	    public void testNotNull() {
	        Object obj = new Object();
	        Assert.assertNotNull(obj, "Object is null!");
	    }


}
