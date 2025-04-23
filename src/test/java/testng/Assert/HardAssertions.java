package testng.Assert;

import org.testng.Assert;
import org.testng.annotations.Test;

public class HardAssertions {

	@Test()
	void Test()
	{
		/*
		Assert.assertEquals("xyz","xyz"); //it will compare two values. both are equal test will pass not equal not pass
		Assert.assertEquals("xyz","xyz1");  //both are not equal my test will fail
		Assert.assertEquals(123,345);   //fail
		Assert.assertEquals(123,"abc"); //fail
		Assert.assertEquals("123",123); //fail 123 is number not string so we cannot compare number
		*/
		
		//Assert.assertNotEquals(123,123); //it will return fail
		//Assert.assertNotEquals(123,345); //pass
		
		//Assert.assertTrue(true);  //pass
		//Assert.assertTrue(false);  //fail
		//Assert.assertTrue(1==2); //failed ..true or false are conflict
		//Assert.assertTrue(1==1);  //true
		
		//Assert.assertFalse(1==2); //pass
		//Assert.assertFalse(1==1); //fail
		
		//Assert.fail(); //intentionally  I want to fail my test method
		
	}
	
	

}
