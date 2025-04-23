package testng.Annotations;

import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class BeforeAfterTestAnnotations {

	@Test
	void abc()
	{
		System.out.println("This is abc from C1...");
	}
	
	@BeforeTest
	void bt()
	{
		System.out.println("This is BeforeTest method...");
	}
	
	@Test
	void xyz()
	{
		System.out.println("This is xyz from C2...");
	}
	
	@AfterTest
	void at()
	{
		System.out.println("This is AfterTest method...");
	}
}
