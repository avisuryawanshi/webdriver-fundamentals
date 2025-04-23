package testng.BasicAsserts;

import org.testng.Assert;
import org.testng.annotations.Test;

public class AssertNullNotNull {
	
// ---------------------------------------------------------------------------------------------------------------------------------
// AssertNull
/** When to Use: Assert.assertNull(object):
 *  Passes when the given object is null.
 *  Fails if the object is not null.*/
// ---------------------------------------------------------------------------------------------------------------------------------

	@Test
    public void testAssertNull() {
        String actualValue = null;

        // Assert that the object is null
        Assert.assertNull(actualValue, "Expected value to be null, but it was not.");
        System.out.println("assertNull passed: actualValue is null.");
    }
	
// ---------------------------------------------------------------------------------------------------------------------------------
// AssertNotNull
/** When to Use: Assert.assertNotNull(object):
 *	Passes when the given object is not null.
 *	Fails if the object is null.*/
// ---------------------------------------------------------------------------------------------------------------------------------
    
	@Test
    public void testAssertNotNull() {
        String actualValue = "Hello, TestNG!";

        // Assert that the object is not null
        Assert.assertNotNull(actualValue, "Expected value to be not null, but it was null.");
        System.out.println("assertNotNull passed: actualValue is not null.");
    }
}
