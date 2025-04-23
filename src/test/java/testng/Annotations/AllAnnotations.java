package testng.Annotations;

import org.testng.annotations.*;  // Importing all TestNG annotations in one go

/*import all these packages so instead of importing each individual package 
simply you can put *star because all annotations are part of the annotation package.*/ 

/**
 * This class demonstrates the execution order of TestNG annotations.

 *
 * Scenario:
 * 1. Execute BeforeSuite (Runs once before the entire suite)
 * 2. Execute BeforeTest (Runs once before all test methods in this <test> tag)
 * 3. Execute BeforeClass (Runs once before the first test method in the class)
 * 4. Execute BeforeMethod (Runs before each @Test method)
 * 5. Execute Test Methods (tm1 & tm2)
 * 6. Execute AfterMethod (Runs after each @Test method)
 * 7. Execute AfterClass (Runs once after all test methods in the class)
 * 8. Execute AfterTest (Runs once after all test methods in this <test> tag)
 * 9. Execute AfterSuite (Runs once after the entire suite)
 */


	public class AllAnnotations {

		@BeforeSuite
		void bs()
		{
			System.out.println("This is BeforeSuite...");
		}
		
		@AfterSuite
		void as()
		{
			System.out.println("This is AfterSuite...");
		}
		
		@BeforeTest
		void bt()
		{
			System.out.println("This is BeforeTest method...");
		}
		
		@AfterTest
		void at()
		{
			System.out.println("This is AfterTest method...");
		}
		
		@BeforeClass
		void bc()
		{
			System.out.println("This is BeforeClass method...");
		}
		
		@AfterClass
		void ac()
		{
			System.out.println("This is AfterClass method...");
		}
	
		@BeforeMethod
		void bm()
		{
			System.out.println("This is before method...");
		}
	
		@AfterMethod
		void am ()
		{
			System.out.println("This is After method...");
		}
		
		@Test(priority=1)
		void tm1()
		{
			System.out.println("This is Test method1....");
		}
		
		@Test(priority=2)
		void tm2()
		{
			System.out.println("This is Test method2....");
		}
		
// Another Example ===================================================================================================================================
		
		@BeforeSuite
	    void beforeSuite() {
	        System.out.println("[BeforeSuite] - This runs once before the entire test suite.");
	    }

	    @AfterSuite
	    void afterSuite() {
	        System.out.println("[AfterSuite] - This runs once after the entire test suite.");
	    }

	    @BeforeTest
	    void beforeTest() {
	        System.out.println("[BeforeTest] - This runs before all test methods inside the <test> tag in the XML.");
	    }

	    @AfterTest
	    void afterTest() {
	        System.out.println("[AfterTest] - This runs after all test methods inside the <test> tag in the XML.");
	    }

	    @BeforeClass
	    void beforeClass() {
	        System.out.println("[BeforeClass] - This runs once before the first test method in this class.");
	    }

	    @AfterClass
	    void afterClass() {
	        System.out.println("[AfterClass] - This runs once after all test methods in this class.");
	    }

	    @BeforeMethod
	    void beforeMethod() {
	        System.out.println("[BeforeMethod] - This runs before each test method.");
	    }

	    @AfterMethod
	    void afterMethod() {
	        System.out.println("[AfterMethod] - This runs after each test method.");
	    }

	    @Test(priority = 1)
	    void testMethod1() {
	        System.out.println("[Test] - Executing Test Method 1");
	    }

	    @Test(priority = 2)
	    void testMethod2() {
	        System.out.println("[Test] - Executing Test Method 2");
	    }
		
		
}
