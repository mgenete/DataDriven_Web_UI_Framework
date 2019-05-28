package com.qa.listner;

import org.apache.log4j.Logger;
import org.testng.IRetryAnalyzer;
import org.testng.ITestResult;



public class Retry implements IRetryAnalyzer{
	
	public static Logger log = Logger.getLogger(Retry.class.getName());
	int counter = 0;
	int retryLimit = 3;
	

	public boolean retry(ITestResult result) {
		if(counter < retryLimit) {
			log.info("Retrying test " + result.getName() + " with status " + getResultStatusName(result.getStatus()) + " for the " + (counter + 1) + " times(s).");
			counter++;
			return true;
		}
		return false;
	}
	
	public String getResultStatusName( int status) {
		String resultName = null;
		if(status == 1)
			resultName = "Success";
		if(status == 2)
			resultName = "Failure";
		if(status == 3)
			resultName = "Skip";
		return resultName;
	}
	



}
