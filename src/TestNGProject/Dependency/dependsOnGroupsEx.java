package testng.Dependency;

import org.testng.annotations.Test;

public class dependsOnGroupsEx {
	
	/**dependsOnGroups:This attribute is used to make test methods depend on a particular group. 
	We can also specify a list of groups this method depends on.
	All of the methods of these groups are executed first before this method. 
	If any test method belonging to a particular group is failed, the dependent test method will not be run and will be flagged as a SKIP. 
	It has the following general form.*/
	
		@Test(groups = "GroupA") 
		public void m1() 
		{ 
		   System.out.println("m1-GroupA"); 
		} 
// -----------------------------------------------------------------------------		
		@Test(groups = "GroupA") 
		public void m2()
		{ 
		  System.out.println("m2-GroupA"); 
		}
// -----------------------------------------------------------------------------			
		@Test(groups = "GroupB") 
		public void m3()
		{ 
		   System.out.println("m3-GroupB"); 
		} 
// -----------------------------------------------------------------------------			
		@Test(dependsOnGroups = "GroupA") // This test method depends on GroupA. 
		public void m4()
		{ 
		   System.out.println("m4 is dependent on GroupA"); 
		} 

}
