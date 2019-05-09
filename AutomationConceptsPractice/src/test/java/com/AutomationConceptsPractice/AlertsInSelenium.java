package com.AutomationConceptsPractice;

import java.io.File;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.aventstack.extentreports.utils.FileUtil;

public class AlertsInSelenium {

	WebDriver driver;

	@BeforeMethod
	public void openBrowser() {
//		System.setProperty("webdriver.chrome.driver", ".//drivers//chromedriver.exe");
//		driver = new ChromeDriver();
System.setProperty("webdriver.gecko.driver", ".//drivers//geckodriver.exe");
driver = new FirefoxDriver();
	}

	@Test(priority = 1, enabled = true)
	public void simpleAlert() throws InterruptedException {

		driver.get("http://toolsqa.com/handling-alerts-using-selenium-webdriver/");
		System.out.println();
		driver.manage().window().maximize();
		
		// This step will result in an alert on screen
		driver.findElement(By.xpath("//button[text()='Simple Alert']")).click();
		Thread.sleep(3000);
		
		
		// Switch to Alert
		Alert simpleAlert = driver.switchTo().alert();
		Utility.getScreenshot(driver);
		
		// Get alert text
		String alertText = simpleAlert.getText();
		System.out.println("Alert text is " + alertText);

		// Accept alert
		simpleAlert.accept();
	}

	@Test(priority = 2,enabled = true)
	public void confirmationAlert() throws InterruptedException {

		driver.get("http://demo.guru99.com/test/delete_customer.php");
		driver.manage().window().maximize();

		// This step will result in an alert on screen
		// Enter customer ID
		WebElement emailId = driver.findElement(By.xpath("//input[@name='cusid']"));

		System.out.println("Entering customer ID...");
		emailId.sendKeys("12345");

		// Click on submit button
		System.out.println("Clicking on submit button...");
		driver.findElement(By.xpath("//input[@name='submit']")).click();
		Thread.sleep(5000);

		
		
		// Switch to Alert
		Alert confirmationAlert = driver.switchTo().alert();

		// Get alert text
		String alertText = confirmationAlert.getText();
		System.out.println("Alert text is " + alertText);
		Utility.getScreenshot(driver);

		// Dissmiss Alert
		confirmationAlert.dismiss();
		System.out.println("Clicked on Cancel button");
		Thread.sleep(5000);
	}

	@Test(priority = 3,enabled = true)
	public void promptAlert() throws InterruptedException {

		driver.get("https://www.hyrtutorials.com/p/alertsdemo.html");
		driver.manage().window().maximize();
		
		// This step will result in an alert on screen
		WebElement element = driver.findElement(By.id("promptBox"));
		element.click();
		

		
		Thread.sleep(4000);
		Alert promptAlert = driver.switchTo().alert();
		
		String alertText = promptAlert.getText();
		System.out.println("Alert text is " + alertText);
		
		// Send some text to the alert
		promptAlert.sendKeys("Komal");
		Thread.sleep(4000); // This sleep is not necessary, just for demonstration
		promptAlert.accept();
		Utility.getScreenshot(driver);
		
		String alertBoxOutput = driver.findElement(By.id("output")).getText();
		System.out.println("alertBoxOutput text is :"+alertBoxOutput);
	}

	@AfterMethod
	public void closeBrowser() {

		System.out.println("Closing the browser...");
		driver.close();
	}

	
	
}
