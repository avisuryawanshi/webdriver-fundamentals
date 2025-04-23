
package testng.Dependency;

import org.testng.Assert;
import org.testng.annotations.Test;

public class dependsOnMethodsEx {
	
/**
 * The attribute dependsOnMethods is used to make the test method depend on a particular method. 
 * We can also specify a list of methods this method depends on.
 * The test method annotated with @Test and attribute dependsOnMethods will run after executing all those methods on which this test method is dependent. 
 * If any of these methods are not executed successfully, this test method will not be run and will be flagged as a SKIP.	
 */
	
		@Test 
		public void m1() 
		{ 
		  System.out.println("Test method one"); 
		} 
// -----------------------------------------------------------------------------		
		@Test(dependsOnMethods = "m1") 
		public void m2()
		{ 
		   System.out.println("Test method two"); 
		} 
// -----------------------------------------------------------------------------		
		@Test 
		public void m3()
		{ 
		   Assert.fail(); 
		   System.out.println("Test method three"); 
		} 
// -----------------------------------------------------------------------------		
		@Test(dependsOnMethods = {"m3", "m1"}) 
		public void m4()
		{ 
		   System.out.println("Test method four"); 
		} 

}
