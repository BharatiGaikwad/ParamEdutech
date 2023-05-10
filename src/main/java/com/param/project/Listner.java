package com.param.project;

import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;
import org.testng.Reporter;
//use jat hot nahi
// hey method automatic genrete hotat ..implement kelvr Listner error ali tr tite click kelvr add implement menthod to karne 
//jari nahi ala tari listner vr right click karun ->source->overrid implemented method karne
//interface use karnaysati implements keyword use kelaS
//testng.xml file vr listner add karun to titun run karava lagto..jay test case use karnar teyvr right click karun  testng ->convert to testng karne
public class Listner implements ITestListener{

	public void onTestStart(ITestResult result) {
		Reporter.log("Test Case Started"+result.getName());
		
	}

	public void onTestSuccess(ITestResult result) {
		Reporter.log("Test Case Success"+result.getName());
		
	}

	public void onTestFailure(ITestResult result) {
		Reporter.log("Test Case Failure"+result.getName());
		
	}

	public void onTestSkipped(ITestResult result) {
		Reporter.log("Test Case skipped"+result.getName());
		
	}

	public void onTestFailedButWithinSuccessPercentage(ITestResult result) {
		
	}

	public void onTestFailedWithTimeout(ITestResult result) {
		
	}

	public void onStart(ITestContext context) {
		
	}

	public void onFinish(ITestContext context) {
		
	}

}
