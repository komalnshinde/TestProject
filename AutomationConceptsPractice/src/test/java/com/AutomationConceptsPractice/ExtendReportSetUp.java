package com.AutomationConceptsPractice;

import java.io.IOException;

import org.openqa.selenium.WebDriver;
import org.testng.ITestResult;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.MediaEntityBuilder;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;
import com.mongodb.diagnostics.logging.Logger;


public class ExtendReportSetUp {

	ExtentReports extent;
	ExtentTest logger;
	WebDriver driver;

	public void initializeExtentReport(String testCaseName) {
		ExtentHtmlReporter reporter = new ExtentHtmlReporter(Constants.reportPath);
		
		extent = new ExtentReports();
		
		extent.attachReporter(reporter);
		
		logger = extent.createTest(testCaseName);
	}
	
	
	
	public void endExtentReport(ITestResult result ) throws IOException {
		
		if(result.getStatus() == ITestResult.FAILURE) {
			String temp = Utility.getScreenshot(driver);
			
			logger.fail(result.getThrowable().getMessage(), MediaEntityBuilder.createScreenCaptureFromPath(temp).build());
		}
	}
	
	public static void log_Pass(String status,String message,WebDriver driver) {

	}
	
	
}
