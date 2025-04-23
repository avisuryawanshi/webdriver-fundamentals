package testng.Listners;

import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

/**✅ Scenario:
* This MyListener class is a custom TestNG listener that implements the ITestListener interface.
* It provides hooks for different stages of the test lifecycle, such as:
	1. Test start		
	2. Test success
	3. Test failure	
	4. Test skip	
	5. Execution start and end
* These hooks are useful for logging, taking screenshots on failure, generating custom reports, etc.
*/

public class MyListener implements ITestListener{

/**
 * Custom TestNG Listener for tracking test execution events.
 * This class implements ITestListener to log the status of tests.
 
 * ✅ Logs when:
 * - Test suite starts and finishes
 * - Individual test starts, passes, fails, or is skipped
 
 * 🔧 Useful for:
 * - Debugging test flows
 * - Generating detailed logs
 * - Future integration with screenshots, reports, or alerts
 */
	  
// Invoked before the test suite starts.=============================================================
	
		  public void onStart(ITestContext context) 
		  {
			  System.out.println("Test execution is started...");
		  }
		  
// Invoked when each individual test method starts.---------------------------
		  
		  public void onTestStart(ITestResult result) 
		  {
			  System.out.println("Test started...");  
		  }
	
// Invoked when a test method completes successfully.-------------------------
		  
		  public void onTestSuccess(ITestResult result) 
		  {
			  System.out.println("Test passed..."); 
		  }
	
 // Invoked when a test method fails.-----------------------------------------
		  
		  public void onTestFailure(ITestResult result) 
		  {
			  System.out.println("Test failed...");
			// You can integrate screenshot capture here
		  }
		  
 // Invoked when a test method is skipped (e.g., due to dependency failure).--
		  
		  public void onTestSkipped(ITestResult result) 
		  {
			  System.out.println("Test skipped...");  
		  }
		  
 // Invoked after the test suite has finished executing.=============================================
		  
		  public void onFinish(ITestContext context) 
		  {
			  System.out.println("Test execution is completed..."); 
		  }
}
