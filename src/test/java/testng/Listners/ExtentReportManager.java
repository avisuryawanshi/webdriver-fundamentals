package testng.Listners;

//✅ Utility file
//✅ Listener Utility class to generate customized ExtentReports

import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;

/**
 * 🔹 Scenario:
 * This class listens to the TestNG test lifecycle using ITestListener interface
 * and generates a rich HTML Extent Report after the execution of each test case.
 * It logs the status of each test method (pass/fail/skip) and flushes the report at the end.
 */

public class ExtentReportManager implements ITestListener{

	public ExtentSparkReporter sparkReporter; // HTML UI of the report. Responsible for report design
	public ExtentReports extent;              // populate common info on the report. Central class to manage report creation and metadata
	public ExtentTest test;                   // Represents/creating each test case entries in the report and update status of the test methods
	
// ======================================================================================================================	
// Called before any test method is run in the suite. Initializes the Extent report configuration.
// ======================================================================================================================	     
	
	public void onStart(ITestContext context) {
		
		System.out.println("[INFO] Test Suite Execution Started... Initializing Extent Report...");
		
		// Define the report path
		sparkReporter=new ExtentSparkReporter(System.getProperty("user.dir") + "/reports/MyReport.html");
		
		// Report UI configuration
		sparkReporter.config().setDocumentTitle("Automation Report");  // Title of the report. Browser tab title
		sparkReporter.config().setReportName("Functional Testing");    // Report header name of the report
		sparkReporter.config().setTheme(Theme.STANDARD);               // Can be Theme.DARK or Theme.STANDARD
		
		// Attach the reporter and set system/environment info
		extent = new ExtentReports();
		extent.attachReporter(sparkReporter);

		extent.setSystemInfo("Computer Name", "localhost");
		extent.setSystemInfo("Environment", "QA");
		extent.setSystemInfo("Tester Name", "Avi");
		extent.setSystemInfo("OS", "Windows 11");
		extent.setSystemInfo("Browser", "Chrome");
		extent.setSystemInfo("Java Version", System.getProperty("java.version"));
		
		// Optional values from system properties or environment (set in CI/CD)
		extent.setSystemInfo("Build Number", System.getProperty("build.number", "N/A"));
        extent.setSystemInfo("CI/CD Pipeline", System.getenv().getOrDefault("CI_PIPELINE_NAME", "Local Execution"));
		
		System.out.println("[INFO] Extent Report setup completed.");
	}
// ======================================================================================================================	
// Called when a test method passes.
// ======================================================================================================================	
	@Override
	public void onTestSuccess (ITestResult result) {
		
		System.out.println("[PASS] Test Passed: " + result.getName());
		
		// Create a test node in the report and mark it as PASS
		test = extent.createTest(result.getName());               // create a new entry in the report for the passed test
		test.log(Status.PASS, "Test case PASSED is:" + result.getName());         // update status to PASS pass/fail/skip
	}	
// ======================================================================================================================	
// Called when a test method fails.
// ======================================================================================================================	
	@Override
	public void onTestFailure(ITestResult result) {
		
		System.out.println("[FAIL] Test Failed: " + result.getName());
        System.out.println("[FAIL] Reason: " + result.getThrowable());
		
        // Create a test node in the report and mark it as FAIL
	    test = extent.createTest(result.getName());              // Create a new entry in the report for the failed test
	    test.log(Status.FAIL, "Test case FAILED is: " + result.getName());                  // Log the test case failure
	    test.log(Status.FAIL, "Test Case FAILED cause is: " + result.getThrowable()); // Log the error/exception message
	}
// ======================================================================================================================	
// Called when a test method skipped.
// ======================================================================================================================
	@Override
	public void onTestSkipped(ITestResult result) { 
		
		System.out.println("[SKIP] Test Skipped: " + result.getName());
		
		// Create a test node in the report and mark it as SKIP
	    test = extent.createTest(result.getName());               // Create a new entry in the report for the skipped test
	    test.log(Status.SKIP, "Test case SKIPPED is: " + result.getName());                // Log the test case as skipped
	}
// ======================================================================================================================	
// Called after all test methods are executed.
// ======================================================================================================================
	@Override
	public void onFinish(ITestContext context) { 
		
		System.out.println("[INFO] Test Suite Execution Completed. Flushing Extent Report...");		
		
		extent.flush(); // Write all test information to the report. Finalize and write the report
		System.out.println("[INFO] Report generated at: " + System.getProperty("user.dir") + "/reports/MyReport.html");
	}

}

	


