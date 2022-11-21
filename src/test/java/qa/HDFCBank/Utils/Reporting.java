package qa.HDFCBank.Utils;




import java.io.IOException;

import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;

import qa.HDFCBank.Base.BaseClass;

public class Reporting extends BaseClass implements ITestListener{
	
	ExtentReports extent = extentReporter.extendReportsGenerator();
	ExtentTest test;

	public void onStart(ITestContext context) {
		// TODO Auto-generated method stub
		
	}
	
	public void onTestStart(ITestResult result) {
		test = extent.createTest(result.getMethod().getMethodName());
		
	}

	public void onTestSuccess(ITestResult result) {

		test.log(Status.PASS, "Test Passed Successfully");
		
	}

	public void onTestFailure(ITestResult result) {

	test.log(Status.FAIL, result.getMethod().getMethodName()+"Test Passed");
	
	try {
		String sspath = myUtils.takeScreenshots(result.getMethod().getMethodName());
		test.addScreenCaptureFromPath(sspath);
	} catch (IOException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
		
	}

	public void onTestSkipped(ITestResult result) {

		test.log(Status.SKIP, result.getMethod().getMethodName()+"Test Skipped");
		
	}

	public void onTestFailedWithTimeout(ITestResult result) {
		// TODO Auto-generated method stub
		
	}



	public void onFinish(ITestContext context) {
		extent.flush();
	}

}
