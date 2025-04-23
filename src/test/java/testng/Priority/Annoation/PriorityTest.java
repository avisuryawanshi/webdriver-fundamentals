package testng.Priority.Annoation;

import org.testng.annotations.Test;

public class PriorityTest {
	
// We can have multiple @Test methods in a single class. TestNG will execute all @Test methods in the class.
// ==================================================================================================================================
/* Scenario 1: Sequential execution of test cases
 * Steps:
 * 1) Open App
 * 2) Login
 * 3) Logout */	
// ===================================================================================================================================	
	
		@Test(priority=1)   //@Test(priority=number) controls the order of execution.
		void openApp()      // Method to open the application
		{
		    System.out.println("Opening application...");    
		}

		@Test(priority=2)
		void login()        // Method to log into the application                                    
		{
		    System.out.println("Logging into application...");    
		}

		@Test(priority=3)
		void logout()       // Method to log out of the application
		{
		    System.out.println("Logging out from application...");    
		}
			
// ==================================================================================================================================
/* Scenario 2: Changing the execution order of methods/Changing location of method
* Steps:
* 3) Logout
* 1) Login
* 2) Open App*/
// ==================================================================================================================================
	
		@Test(priority=3)
		void logoutModified()       // Method to log out of the application
		{
		    System.out.println("Logging out from application...");    
		}

		@Test(priority=1)   //@Test(priority=number) controls the order of execution.
		void openAppModified()      // Method to open the application
		{
		    System.out.println("Opening application...");    
		}

		@Test(priority=2)
		void loginModified()        // Method to log into the application                                    
		{
		    System.out.println("Logging into application...");    
		}

// ==================================================================================================================================
/* Scenario 3: Default priority test (default priority is 0)
* Steps:
* 2) logout
* 1) open
* 0) login*/
// ==================================================================================================================================

		@Test(priority=2)
		void logoutDefault()       // Method to log out of the application
		{
		    System.out.println("Logging out from application...");    
		}

		@Test(priority=1)
		void openAppDefault()      // Method to open the application
		{
		    System.out.println("Opening application...");    
		}

		@Test // Default priority (0)
		void loginDefault()        // Method to log into the application                                    
		{
		    System.out.println("Logging into application...");    
		}
		
// ==================================================================================================================================
/* Scenario 4: Assigning the same priority to multiple methods
* Steps:
* 2) logout
* 2) login
* 1) open*/
// ==================================================================================================================================

		@Test(priority=2)
		void logoutSamePriority()       // Method to log out of the application
		{
		    System.out.println("Logging out from application...");    
		}

		@Test(priority=2) 
		void loginSamePriority()       // Method to log into the application                                    
		{
		    System.out.println("Logging into application...");    
		}

		@Test(priority=1)
		void openAppSamePriority()      // Method to open the application
		{
		    System.out.println("Opening application...");    
		}

// ==================================================================================================================================
/* Scenario 5: Using negative priority values (-4, -3, -2, -1, 0, 1, 2, 3, 4)
* Steps:
*  1) logout
*  0) login
* -1) open*/
// ==================================================================================================================================

		@Test(priority=1)
		void logoutNegativePriority()       // Method to log out of the application
		{
		    System.out.println("Logging out from application...");    
		}

		@Test(priority=0) 
		void loginNegativePriority()       // Method to log into the application                                    
		{
		    System.out.println("Logging into application...");    
		}

		@Test(priority=-1)
		void openAppNegativePriority()      // Method to open the application
		{
		    System.out.println("Opening application...");    
		}

// ==================================================================================================================================
// Scenario 6: Methods without @Test annotation (not executed by TestNG)
// ==================================================================================================================================

		//@Test(priority=1)
		void logoutNoAnnotation()       // Method to log out of the application
		{
		    System.out.println("Logging out from application...");    
		}

		//@Test(priority=0)
		void loginNoAnnotation()       // Method to log into the application                                    
		{
		    System.out.println("Logging into application...");    
		}

		//@Test(priority=-1)
		void openAppNoAnnotation()      // Method to open the application
		{
		    System.out.println("Opening application...");    
		}

// ==================================================================================================================================
// Scenario 7: Disabling a test case using enabled = false inside the @Test annotation.
// ==================================================================================================================================

		@Test
		public void activeTest() 
		{
		    System.out.println("This test will execute");
		}

		@Test(enabled = false)
		public void disabledTest() 
		{
		    System.out.println("This test will NOT execute");
		}
		
}

