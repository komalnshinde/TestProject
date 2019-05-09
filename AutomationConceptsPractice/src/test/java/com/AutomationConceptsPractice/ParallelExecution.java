package com.AutomationConceptsPractice;

import java.io.IOException;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.ITestListener;
import org.testng.ITestResult;
import org.testng.ITestRunnerFactory;
import org.testng.Reporter;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import org.testng.internal.ITestResultNotifier;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.markuputils.ExtentColor;
import com.aventstack.extentreports.markuputils.MarkupHelper;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;
import com.aventstack.extentreports.reporter.configuration.ChartLocation;
import com.aventstack.extentreports.reporter.configuration.Theme;
import org.testng.ITestResult;

public class ParallelExecution {
	WebDriver driver;
	  ExtentTest test;
	  ExtendReportSetUp extentReport = new ExtendReportSetUp();
	     
	  
	@BeforeMethod(groups= {"P1","P2","P3"})
	public void openBrowser() {
		System.out.println("Before method..");
		System.setProperty("webdriver.chrome.driver", ".//drivers//chromedriver.exe");
		driver = new ChromeDriver();
		extentReport.initializeExtentReport("Testing");

	}

	@Test(priority =1,groups= { "P1" })
	public void executSessionOne() {

		// Goto guru99 site
		driver.get("http://demo.guru99.com/V4/");
		// find user name text box and fill it
		driver.findElement(By.name("uid")).sendKeys("Driver 1");

	}

	@Test( priority =2,groups= { "P1" })
	public void executeSessionTwo() {

		// Goto guru99 site
		driver.get("http://demo.guru99.com/V4/");
		// find user name text box and fill it
		driver.findElement(By.name("uid")).sendKeys("Driver 2");

	}

	@Test( priority =3,groups= { "P2" })
	public void executSessionThree() {

		// Goto guru99 site
		driver.get("http://demo.guru99.com/V4/");
		// find user name text box and fill it
		driver.findElement(By.name("uid")).sendKeys("Driver 3");

	}

	@AfterMethod
	public void closeBrowser() throws IOException {
		ITestResult result = Reporter.getCurrentTestResult();
		
		System.out.println("Closing the browser...");
		driver.close();
		System.out.println("After method..");
		//extentReport.endExtentReport(result.getStatus());
	}
	
	 
}
