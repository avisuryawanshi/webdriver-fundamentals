package testng.BasicAsserts;

import org.testng.Assert;
import org.testng.annotations.Test;

public class AssertTrueFalse {

	
// ---------------------------------------------------------------------------------------------------------------------------------
// AssertTrue
// When to Use: Verify condition is true (positive checks)
// ---------------------------------------------------------------------------------------------------------------------------------
	@Test
    public void isLoginButtonDisplayed() {
        boolean isDisplayed = true;  // Simulated condition (e.g., from WebDriver)

        // Asserting that the login button is displayed
        Assert.assertTrue(isDisplayed, "Login button is not displayed!");

        System.out.println("Login button is visible. Test passed.");
    }
	
// ---------------------------------------------------------------------------------------------------------------------------------
// AssertFalse
// When to Use: Verify condition is false (negative checks)
// ---------------------------------------------------------------------------------------------------------------------------------

	@Test
    public void isErrorMessageDisplayed() {
        boolean errorMessageVisible = false;  // Simulated result

        // Asserting that error message should not be visible (e.g., on successful login)
        Assert.assertFalse(errorMessageVisible, "Error message should not be displayed!");

        System.out.println("Error message is not displayed. Test passed.");
    }
}
