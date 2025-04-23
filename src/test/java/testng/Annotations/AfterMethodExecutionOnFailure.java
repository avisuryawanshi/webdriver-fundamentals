package testng.Annotations;

import org.testng.annotations.*;

public class AfterMethodExecutionOnFailure {
	
/**
Q. What happens if a test method fails? Will @AfterMethod still execute?
✅ Answer: Yes, @AfterMethod will still execute even if a test fails. This ensures cleanup is performed even when a test case encounters an error.	
 */
	
	
/**
 * This method runs before each test method.
 * Typically used to set up preconditions, such as launching a browser or initializing variables.
 */
		@BeforeMethod
		public void setup() {
		    System.out.println("Setup: Opening browser...");
		}
		
/**
 * This test method will deliberately fail due to an ArithmeticException.
 * The failure should not prevent @AfterMethod from executing.
 */
		@Test
		public void testFailure() {
		    System.out.println("Executing failing test...");
		    int result = 1 / 0;  // This will cause an ArithmeticException // This will cause an ArithmeticException (divide by zero)
		}
		
/**
 * This method runs after each test method, even if the test fails.
 * Typically used for cleanup, such as closing a browser or resetting test data.
 */
		
		@AfterMethod
		public void teardown() {
		    System.out.println("Teardown: Closing browser...");
		}
}

/**
 * 📌 Expected Console Output:
 * ---------------------------------
 * Setup: Opening browser...
 * Executing failing test...
 * Exception in thread "main" java.lang.ArithmeticException: / by zero
 * Teardown: Closing browser...
 * ---------------------------------
 * ✅ Even though the test fails, @AfterMethod still executes.
 * This behavior ensures proper resource management in test execution.
 */

