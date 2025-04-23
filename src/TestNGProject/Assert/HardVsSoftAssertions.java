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

public class HardVsSoftAssertions {

// -------------------------------------------------------------------------------------------------------	
// ▶ Scenario: Demonstrating Hard Assertion
// -------------------------------------------------------------------------------------------------------	
	
	@Test
	void test_hardassertions()
	{
		System.out.println("testing....");
		System.out.println("testing....");
		
		Assert.assertEquals(1, 2); //hard assertion
		
		System.out.println("testing....");
		System.out.println("testing....");
	}
	
// -------------------------------------------------------------------------------------------------------
// ▶ Scenario: Demonstrating Soft Assertion
// -------------------------------------------------------------------------------------------------------
	
	@Test
	void test_softassertions()
	{
		System.out.println("testing....");
		System.out.println("testing....");
		
		SoftAssert sa=new SoftAssert();
		sa.assertEquals(1, 2); //soft assertion
		
		System.out.println("testing....");
		System.out.println("testing....");
		
		sa.assertAll();   //Mandatory
	}

}
