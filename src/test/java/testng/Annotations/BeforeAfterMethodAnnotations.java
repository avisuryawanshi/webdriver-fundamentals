package testng.Annotations;

import org.testng.annotations.*;

/*TC1 -two test methods
----------
1) Login - - - ->@BeforeMethod
2) Search - - - > @Test    
3) Logout - - - >@AfterMethod

4) Login
5) Adv Search - - ->@Test 
6) Logout
*/

public class BeforeAfterMethodAnnotations {

/**
 * This method runs before every @Test method.
 * It simulates a login process before executing test cases.
 */
		
		@BeforeMethod
		void login()
		{
			System.out.println("This is login");
		}
		
/**
 * This is a test case for searching a product or content.
 * It will execute after login and before logout.
 */
		
		@Test(priority=1)
		void seacrh()
		{
			System.out.println("Test Execution: Performing search operation.");
		}
		
/**
 * This is a test case for performing an advanced search.
 * It will also execute after login and before logout.
 */
		
		@Test(priority=2)
		void advancedsearch()
		{
			System.out.println("Test Execution: Performing advanced search operation.");
		}
		
/**
 * This method runs after every @Test method.
 * It simulates logging out after completing the test execution.
 */
		
		@AfterMethod
		void logout()
		{
			System.out.println("This is logout");
		}
		
// ================================================================================================================
// Example: use @BeforeMethod and @AfterMethod in data-driven testing	
// ================================================================================================================
		
		@DataProvider(name = "userData")
		public Object[][] getData() {
		    return new Object[][] 
    		{
		        {"user1", "pass1"},
		        {"user2", "pass2"}
    		};
		}
		@BeforeMethod
		public void setup() 
		{
		    System.out.println("Opening browser...");
		}
		
		@Test(dataProvider = "userData")
		public void loginTest(String username, String password)
		{
		    System.out.println("Logging in with " + username + " and " + password);
		}
		
		@AfterMethod
		public void teardown() 
		{
		    System.out.println("Closing browser...");
		}

}

