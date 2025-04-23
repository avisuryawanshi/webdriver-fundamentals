package testng.Annotations;

import org.testng.annotations.*;

/**
 * This class demonstrates how @BeforeMethod and @AfterMethod
 * can be used along with @BeforeTest and @AfterTest in TestNG.
 * 
 * Scenario: User Authentication and Dashboard Access
 *		@BeforeTest →   Set up a database connection (runs once before all tests).
 *		@BeforeMethod → Open browser and navigate to login page (runs before each test).
 *		@Test →         Two test cases: User Login and Dashboard Verification.
 *		@AfterMethod →  Close browser after each test execution.
 *		@AfterTest →    Disconnect from the database (runs once after all tests).
 */

public class BeforeAfterTestMethodDemo {

// -------------------------------------------------------------------------------------------------------------------------------------
	/*
	 *  We use @BeforeMethod and @AfterMethod alongside @BeforeTest and @AfterTest in TestNG, but their scope is different.
	 * 	▪ @BeforeTest and @AfterTest run once for an entire <test> in the XML file.
	 * 	▪ @BeforeMethod and @AfterMethod run before and after every test method inside that <test>.
	 */
// -------------------------------------------------------------------------------------------------------------------------------------	
	
		
		// Runs once before all test cases in this test suite (e.g., testng.xml <test> tag)
		@BeforeTest
		public void beforeTest() {
		    System.out.println("Runs once before all tests in the test suite");
		    System.out.println("🔄 Setting up database connection before running tests...");
		}
		
		// Runs before each @Test method
		@BeforeMethod
		public void beforeMethod() {
		    System.out.println("Runs before each test method");
		    System.out.println("🌐 Opening browser and navigating to login page...");
		}
		
		// First test case: User Login
		@Test
		public void test1() {
		    System.out.println("Executing test1");
		    System.out.println("✅ Executing User Login Test...");
		}
		
		// Second test case: Dashboard Verification
	    @Test(priority = 2)
	    public void dashboardAccessTest() {
	    	System.out.println("Executing test2");
	        System.out.println("📊 Executing Dashboard Access Test...");
	    }
	    
	    // Runs after each @Test method
		@AfterMethod
		public void afterMethod() {
		    System.out.println("Runs after each test method");
		    System.out.println("❌ Closing browser after test execution...");
		  
		}
		
		// Runs once after all test cases in this test suite
		@AfterTest
		public void afterTest() {
		    System.out.println("Runs once after all tests in the test suite");
		    System.out.println("📴 Disconnecting database connection after all tests...");
		}
		
/**
* Key Takeaways:
* @BeforeTest / @AfterTest → Execute once before/after all test cases in a test suite.
* @BeforeMethod / @AfterMethod → Execute before/after each test method.
* TestNG Annotations Help in Structuring Tests → Useful in large automation projects.
*/

}
