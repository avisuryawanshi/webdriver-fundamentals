package testng.Assert;

import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

public class SoftAssertDemo {

/**
 * 📝 Output Behavior:
	All validations will execute, and failures will be reported only after assertAll().
	If assertAll() is skipped, the test passes regardless of failures.	
 */
	
	@Test
    public void softAssertExample() {
        System.out.println("Test Started");

        SoftAssert softAssert = new SoftAssert();

        // First Assertion - Fails
        softAssert.assertEquals("Hello", "Hi", "String mismatch");

        // Second Assertion - Pass
        softAssert.assertTrue(10 > 5, "Condition failed");

        // Third Assertion - Fails
        softAssert.assertNotEquals(100, 100, "Values are equal");

        System.out.println("All validations done");

        // Required to collect all assertion results
        softAssert.assertAll();
    }

// ===================================================================================================
// Example 2: Use Case — Form Validation
/**
 *  Real-World Relevance:
 *	This test checks multiple field validations at once.
 *	Even if one validation fails, the others still run — a perfect case for soft assertions.*/	
// ===================================================================================================

	@Test
	public void validateLoginForm() {
	    SoftAssert softAssert = new SoftAssert();

	    String actualUsernameError = "Username is required";
	    String actualPasswordError = "Password is required";

	    String expectedUsernameError = "Username cannot be empty";
	    String expectedPasswordError = "Password is required";

	    softAssert.assertEquals(actualUsernameError, expectedUsernameError, "Username error message mismatch");
	    softAssert.assertEquals(actualPasswordError, expectedPasswordError, "Password error message mismatch");

	    // More UI validations can go here...

	    softAssert.assertAll();
	}

}
