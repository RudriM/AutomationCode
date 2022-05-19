package com.wac.cwp.util;

import org.testng.IRetryAnalyzer;
import org.testng.ITestResult;

import com.wac.cwp.base.TestBase;

public class RetryAnalyzer extends TestBase implements IRetryAnalyzer{
	
	int counter = 0;
	int retryLimit = 0;
	
	@Override
	public boolean retry(ITestResult result) {
		if(counter < retryLimit) {
			counter++;
			return true;
		}
		return false;
	}

}
