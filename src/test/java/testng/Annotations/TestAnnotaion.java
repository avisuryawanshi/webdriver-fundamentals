package testng.Annotations;

import org.testng.annotations.Test;

public class TestAnnotaion {

/*
 * For example, if I have a method called sampleTest() that contains some test logic, 
 * I'd simply put @Test right above it. 
 * Then, when I run the test suite, TestNG will automatically execute sampleTest().	
 */

	/**
     * This method serves as a simple test case.
     * When the test suite runs, TestNG will automatically execute this method.
     * used to define a test method that will be executed as part of a test suite.
     * Any method marked with @Test does not require a main() method to execute; TestNG handles execution.
     */ 

// Example 1 ---------------------------------------------------------------------------------------------------------	 	
	    @Test
	    public void sampleTest() 
	    {
	        System.out.println("Executing sample test...");
	        // Your test logic here
	    }
	    
// Example 2 ---------------------------------------------------------------------------------------------------------	    
	    
	    public class MyTest {

	        @Test
	        public void openApp() {
	            // Code to open the application
	            System.out.println("Opening application...");
	        }

	        @Test
	        public void login() {
	            // Code to log in
	            System.out.println("Logging in...");
	        }

	        @Test
	        public void logout() {
	            // Code to log out
	            System.out.println("Logging out...");
	        }
	    }
// ---------------------------------------------------------------------------------------------------------	    
	    
	    
// We can have multiple @Test methods in a single class. TestNG will execute all @Test methods in the class.
// ---------------------------------------------------------------------------------------------------------	
	    public class MultipleTests {
	        
	    	/**
	         * Test case A: This test method will execute independently as part of the suite.
	         */
	    	
	    	@Test
	        public void testA() 
	        {
	            System.out.println("Test A executed");
	        }

	    	/**
	         * Test case B: This test method will also execute independently.
	         */
	    	
	        @Test
	        public void testB() 
	        {
	            System.out.println("Test B executed");
	        }
	    }
}


