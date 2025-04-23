package testng.Dependency;

import org.testng.Assert;

/*Test case
1. openapp {fail}
2. login 
3. search 
4. advsearch 
5. Logout
*/

import org.testng.annotations.Test;

public class DependencyMethods {
	
			//login fail
			@Test(priority=1)
			void openapp()
			{
				Assert.assertTrue(false);	
			}
		
			@Test(priority=2, dependsOnMethods= {"openapp"})
			void login()
			{
				Assert.assertTrue(true);  //Hard assertion
			}
			
			@Test(priority=3, dependsOnMethods= {"login"})
			void search()
			{
				Assert.assertTrue(true);
			}
			
			@Test(priority=4, dependsOnMethods= {"login"})
			void advsearch()
			{
				Assert.assertTrue(true);
			}
			
			@Test(priority=5, dependsOnMethods= {"login"})
			void logout()
			{
				Assert.assertTrue(true);
			}

	
}
