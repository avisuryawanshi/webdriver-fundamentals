package testng.Annotations;

import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

/*TC1 -two test methods
----------
1) Login - - - ->@BeforeClass
2) Search - - - > @Test    
5) Adv Search - - ->@Test 
6) Logout - - - ->@AfterClass
*/

public class BeforeAfterClassAnnotations {

		@BeforeClass
		void login()
		{
			System.out.println("This is login");
		}
		
		@Test(priority=1)
		void seacrh()
		{
			System.out.println("This is search");
		}
		
		@Test(priority=2)
		void advancedsearch()
		{
			System.out.println("this is advsearch");
		}
		
		@AfterClass
		void logout()
		{
			System.out.println("This is logout");
		}
}
