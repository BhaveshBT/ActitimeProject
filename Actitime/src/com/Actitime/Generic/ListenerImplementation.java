package com.Actitime.Generic;

import java.io.File;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;
import org.testng.Reporter;

import com.google.common.io.Files;

public class ListenerImplementation extends Baseclass implements ITestListener  {

	@Override
	public void onTestStart(ITestResult result) {
		Reporter.log("test started",true);
	}

	@Override
	public void onTestSuccess(ITestResult result) {
		Reporter.log("testscript passed",true);
	}

	@Override
	public void onTestFailure(ITestResult result) {
		String name = result.getName();
		
		TakesScreenshot TS = (TakesScreenshot) driver;
		File src = TS.getScreenshotAs(OutputType.FILE);
		File dest = new File("./Screenshot/"+name+".png");
		try {
			Files.copy(src, dest);
		}	catch (Exception e) {
				
		}
	driver.close();
		
	}

	@Override
	public void onTestSkipped(ITestResult result) {
		// TODO Auto-generated method stub
		ITestListener.super.onTestSkipped(result);
	}

	@Override
	public void onTestFailedButWithinSuccessPercentage(ITestResult result) {
		// TODO Auto-generated method stub
		ITestListener.super.onTestFailedButWithinSuccessPercentage(result);
	}

	@Override
	public void onTestFailedWithTimeout(ITestResult result) {
		// TODO Auto-generated method stub
		ITestListener.super.onTestFailedWithTimeout(result);
	}

	@Override
	public void onStart(ITestContext context) {
		// TODO Auto-generated method stub
		ITestListener.super.onStart(context);
	}

	@Override
	public void onFinish(ITestContext context) {
		// TODO Auto-generated method stub
		ITestListener.super.onFinish(context);
	}

	

}
