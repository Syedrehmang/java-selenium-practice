package syedrehmanseleniumproject.TestComponents;

import java.io.File;
import java.io.IOException;

import org.openqa.selenium.WebDriver;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;

import syedrehmanseleniumproject.resources.ExtentReporterNG;

public class Listeners extends BaseTest implements ITestListener {

	ExtentTest test;
	ExtentReports extent = ExtentReporterNG.getReportObject();
	ThreadLocal<ExtentTest> extentTest = new ThreadLocal<ExtentTest>();

	@Override
	public void onTestStart(ITestResult result) {
		// Runs before each @Test method
		test = extent.createTest(result.getMethod().getMethodName());
		extentTest.set(test);
		
	}

	@Override
	public void onTestSuccess(ITestResult result) {
		// Runs if the @Test method passes
		extentTest.get().log(Status.PASS, "Test Passed");
	}

	@Override
	public void onTestFailure(ITestResult result) {
		// Runs if the @Test method fails
		extentTest.get().fail(result.getThrowable());
		try {
			driver = (WebDriver) result.getTestClass().getRealClass().getField("driver").get(result.getInstance());
		} catch (Exception e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		String filePath = null;
		try {
			filePath = getScreenshot(result.getMethod().getMethodName(), driver);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		extentTest.get().addScreenCaptureFromPath(filePath, result.getMethod().getMethodName());
		}

	@Override
	public void onTestSkipped(ITestResult result) {
		// Runs if the @Test method is skipped
	}

	@Override
	public void onTestFailedButWithinSuccessPercentage(ITestResult result) {
		// Optional: If test fails but meets success percentage
	}

	@Override
	public void onStart(ITestContext context) {
		// Runs before any test method in the suite/class
	}

	@Override
	public void onFinish(ITestContext context) {
		// Runs after all test methods are finished
		extent.flush();
		
	}
}
