package testng.Assert;

import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

public class SoftAssertions {
	
	@Test
    public void testSoftAssertions() {
        SoftAssert softAssert = new SoftAssert();
        
        System.out.println("Test started");
        
        // First assertion
        softAssert.assertEquals("Hello", "Hello", "First assertion failed");
        
        // Second assertion
        softAssert.assertTrue(5 > 10, "Second assertion failed");
        
        // Third assertion
        softAssert.assertFalse(3 > 2, "Third assertion failed");
        
        System.out.println("Test completed");
        
// ---- continue execution
        softAssert.assertAll(); // Collate results, Must be called at the end 
    }


}
