package com.qa.listner;

import org.apache.log4j.Logger;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

import com.qa.base.TestBase;

public class Listner extends TestBase implements ITestListener{
	
	
	static Logger log = Logger.getLogger(Listner.class.getName());
	

	public void onTestStart(ITestResult result) {
		log.info("Test started: "+ result.getName());
		
	}

	public void onTestSuccess(ITestResult result) {
		log.info("Test passed: "+ result.getName());
		
	}

	public void onTestFailure(ITestResult result) {
		log.info("Test failed: "+ result.getThrowable());
		
	}

	public void onTestSkipped(ITestResult result) {
		log.info("Test skipped: "+ result.getThrowable());
		
	}

	public void onTestFailedButWithinSuccessPercentage(ITestResult result) {
		// TODO Auto-generated method stub
		
	}

	public void onStart(ITestContext context) {
		// TODO Auto-generated method stub
		
	}

	public void onFinish(ITestContext context) {
		// TODO Auto-generated method stub
		
	}

}
