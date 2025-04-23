package testng.Dependency;

import org.testng.Assert;
import org.testng.annotations.Test;

/*Test case
1. openapp 
2. login 
3. search 
4. advsearch {adv search depend on search}
5. Logout
*/

public class DependencyMethods2 {

	@Test(priority=1)
	void openapp()
	{
		Assert.assertTrue(true);	
	}

	@Test(priority=2, dependsOnMethods= {"openapp"})
	void login()
	{
		Assert.assertTrue(true);  //Hard assertion
	}
	
	@Test(priority=3, dependsOnMethods= {"login"})
	void search()
	{
		Assert.assertTrue(false);
	}
	
	//adv search depend search
	@Test(priority=4, dependsOnMethods= {"login","search"})
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
