package testng.Assert;

import org.testng.Assert;
import org.testng.annotations.Test;

public class AssertionsDemo {
	
	@Test()
	void TestTitle()
	{
		String expected_title="Opencart";
		String actual_title="Openshop";
		
		//using assertion, compare two values
		
		Assert.assertEquals(expected_title, actual_title);  //passing two parameters
				
		//using if else condition with assertion
		//this assertions will take a Boolean value as a parameter
		
		if(expected_title.equals(actual_title))
		{
			System.out.println("test passed");
			Assert.assertTrue(true);  //this will make my test method passed
		}
		else
		{
			System.out.println("test failed");
			Assert.assertTrue(false);  //this will make my test method failed
		}
		
// using if else condition --------------------------------------------------------------------------
				
		if(expected_title.equals(actual_title))
		{
		System.out.println("test passed");
		}
		
	    else
	    {
		System.out.println("test failed");
		}		
	}
}
