package com.sar.listners;

import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;
import org.testng.Reporter;

import com.aventstack.extentreports.Status;
import com.sar.base.TestBase;
import com.sar.utilities.TestUtils;

public class CustomListeners extends TestBase implements ITestListener {

	
    public void onTestStart(ITestResult result) {
		// TODO Auto-generated method stub
	   test = rep.createTest(result.getName().toUpperCase());
	}

	
	public void onTestSuccess(ITestResult result) {
		// TODO Auto-generated method stub
		test.log(Status.PASS, result.getName().toUpperCase()+"PASS");
		rep.flush();
		
	}

	
	public void onTestFailure(ITestResult result) {
		// TODO Auto-generated method stub
	
		test.log(Status.FAIL, result.getName().toUpperCase()+"failed with Exception : "+result.getThrowable());
		test.addScreenCaptureFromPath(System.getProperty("user.dir")+"\\Screenshots\\"+result.getName()+".jpg");
		
		
		TestUtils.screencapture(result.getMethod().getMethodName());
		System.setProperty("org.uncommons.reportng.escape-output", "false");
		Reporter.log("Capturing Screenshot");
		Reporter.log("<a target=\"_blank\" href = \"C:\\Users\\sarve\\eclipse-workspace\\DataDriven\\Screenshots\\"+result.getMethod().getMethodName()+".jpg\">Screenshot</a>");
		Reporter.log("<br>");
		Reporter.log("<a target=\"_blank\" href = \"C:\\Users\\sarve\\eclipse-workspace\\DataDriven\\Screenshots\\"+result.getMethod().getMethodName()+".jpg\"><img src =\"C:\\Users\\sarve\\eclipse-workspace\\DataDriven\\Screenshots\\"+result.getMethod().getMethodName()+".jpg\" height= 400 width = 700></img></a>");
		rep.flush();
	}

	
	public void onTestSkipped(ITestResult result) {
		// TODO Auto-generated method stub
	
	}

	
	public void onTestFailedButWithinSuccessPercentage(ITestResult result) {
		// TODO Auto-generated method stub
		
	}

	
	public void onTestFailedWithTimeout(ITestResult result) {
		// TODO Auto-generated method stub
		
	}


	public void onStart(ITestContext context) {
		// TODO Auto-generated method stub
	
	}

	
	public void onFinish(ITestContext context) {
		// TODO Auto-generated method stub
	
	}
	


}
