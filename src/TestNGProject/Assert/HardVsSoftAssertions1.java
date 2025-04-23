package testng.Assert;

import org.testng.Assert;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

/**
 * This class demonstrates the difference between Hard and Soft Assertions in TestNG.
 * 
 * ➤ Hard Assertions: Stop the test execution immediately when a failure occurs.
 * ➤ Soft Assertions: Continue the test execution even after assertion failures and 
 *    report all of them at the end using assertAll().
 */

public class HardVsSoftAssertions1 {

// -------------------------------------------------------------------------------------------------------
// ▶ Scenario: Demonstrating Hard Assertion
// -------------------------------------------------------------------------------------------------------
   
	@Test
    void test_hardassertions() {
        System.out.println("Starting hard assertion test...");
        System.out.println("Step 1: Opening the application.");
        System.out.println("Step 2: Entering login details.");

        // ❌ Hard assertion - This will fail and stop execution here
        Assert.assertEquals(1, 2, "❌ Mismatch in expected and actual result - stopping execution");

        System.out.println("Step 3: Clicking Login.");       // This line will NOT execute
        System.out.println("Step 4: Verifying dashboard.");  // This line will NOT execute
    }

// -------------------------------------------------------------------------------------------------------
// ▶ Scenario: Demonstrating Soft Assertion
// -------------------------------------------------------------------------------------------------------
   
	@Test
    void test_softassertions() {
        System.out.println("Starting soft assertion test...");
        System.out.println("Step 1: Opening the application.");
        System.out.println("Step 2: Entering login details.");

        // ✅ Soft assertion - Test will continue even if this fails
        SoftAssert sa = new SoftAssert();
        sa.assertEquals(1, 2, "❌ Soft assert failure: Values not equal");

        System.out.println("Step 3: Clicking Login.");       // This line WILL execute
        System.out.println("Step 4: Verifying dashboard.");  // This line WILL execute

        // ✅ Required to collect all soft assertion results
        sa.assertAll();  // Reports all collected assertion failures
    }

}
