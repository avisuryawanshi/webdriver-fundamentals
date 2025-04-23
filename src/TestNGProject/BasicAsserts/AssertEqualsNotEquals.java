package testng.BasicAsserts;

import org.testng.Assert;
import org.testng.annotations.Test;

public class AssertEqualsNotEquals {
	
	 @Test
	 public void verifyResult() {
	 Assert.assertEquals("TestNG", "TestNG"); // Pass
	 Assert.assertNotEquals(5, 10); // Pass
	 }
	 
// ---------------------------------------------------------------------------------------------------------------------------------
// AssertEquals
// When to Use: Use assertEquals() when you want to validate the result is exactly what you expect.
// ---------------------------------------------------------------------------------------------------------------------------------
	 @Test
	    public void verifyPageTitle() {
	        String expectedTitle = "Welcome - MyApp";
	        String actualTitle   = "Welcome - MyApp";  // Simulated actual result

	        // Assertion to compare expected and actual values
	        Assert.assertEquals(actualTitle, expectedTitle, "Page title does not match!");

	        System.out.println("Title verification passed.");
	    }

// -----------------------------------------------------------------------------------------------------------------------------------
// AssertNotEquals
// When to Use: Use assertNotEquals() when you want to ensure two values are different, e.g., after invalid input or negative testing.
// -----------------------------------------------------------------------------------------------------------------------------------
	 @Test
	    public void verifyErrorMessage() {
	        String expectedError = "Invalid Credentials";
	        String actualError   = "Page Not Found";  // Simulated result

	        // Asserting that the actual error is NOT equal to expected success message
	        Assert.assertNotEquals(actualError, expectedError, "Error message should not match!");

	        System.out.println("Error message validation passed.");
	    }
	  
}
