package com.AutomationConceptsPractice;

import java.util.List;
import java.util.concurrent.TimeUnit;

import org.apache.log4j.Logger;
import org.apache.log4j.config.PropertyGetter;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class SeleniumConcepts {
	WebDriver driver;
	Logger log = Logger.getLogger("Test");

    // configure log4j properties file
	
	//System.setProperty("org.apache.commons.logging.Log", "org.apache.commons.logging.impl.Jdk14Logger");

	@BeforeMethod
	public void openBrowser() {
		System.setProperty("webdriver.chrome.driver", ".//drivers//chromedriver.exe");
		driver = new ChromeDriver();
		
	}

	@Test(priority = 1, enabled = true)
	public void seleniumWaits() {
		//Logger log = Logger.getLogger("Test");
		System.out.println("Entering url...");
		log.info("Entering url...");
		driver.get("https://accounts.google.com");
		driver.get("http://sagar.kardekar:Welcome@123@192.168.15.148:6565/Talentric/#/login");
		
		
		
		driver.manage().window().maximize();

		// Implicite wait
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

		
		System.out.println("Entering username...");
		driver.findElement(By.xpath("//input[@placeholder='User ID']")).sendKeys("balbasredh");
		
		driver.findElement(By.xpath("//input[@id='txtpassword']")).sendKeys("anhsgdjfs");
		
		// Enter username
		WebElement emailId = driver.findElement(By.xpath("//input[@id='identifierId']"));
		System.out.println("Entering emailId...");
		log.info("Entering emailId...");
		emailId.sendKeys("komalnshinde@gmail.com");

		// Click on next button
		System.out.println("Click on next button...");
		log.info("Click on next button...");
		driver.findElement(By.xpath("//div[@id='identifierNext']")).click();

		// Wait for password webelement and set password
		WebElement password = driver.findElement(By.xpath("//input[@name='password']"));
		// Explicite wait
		WebDriverWait wait = new WebDriverWait(driver, 10);
		log.info("Entering password....");
		System.out.println("Entering password...");
		wait.until(ExpectedConditions.visibilityOf(password));
		password.sendKeys("xyz");
	}

	@Test(priority = 2, enabled = true)
	public void aletInSelenium() {

		System.out.println("Entering url...");
		log.info("Entering url....");
		driver.get("http://demo.guru99.com/test/delete_customer.php");
		driver.manage().window().maximize();

		// Implicite wait
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

		// Enter customer ID
		WebElement emailId = driver.findElement(By.xpath("//input[@name='cusid']"));
		log.info("Entering customer ID...");
		System.out.println("Entering customer ID...");
		emailId.sendKeys("12345");

		// Click on submit button
		driver.findElement(By.xpath("//input[@name='submit']")).click();

		// Handeling alert

		Alert alert = driver.switchTo().alert();
		System.out.println("Alert meassage :" + alert.getText());
		log.info("Accepting alert..clikcing on confirmation pop up oK button");
		System.out.println("Accepting alert..clikcing on confirmation pop up oK button");
		alert.accept();
		System.out.println("Alert meassage :" + alert.getText());
		log.info("Accepting alert..clikcing on success pop up oK button");
		System.out.println("Accepting alert..clikcing on success pop up oK button");
		alert.accept();
		alert.dismiss();
		alert.getText();
		alert.sendKeys("xyz");
		
	}

	@Test(priority = 3, enabled = true)
	public void dropdownCommands() {
		System.out.println("Entering url...");
		log.info("Entering url...");
		driver.get("http://toolsqa.com/automation-practice-form");
		driver.manage().window().maximize();

		// Implicite wait
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

		WebElement dropdown = driver.findElement(By.xpath("//select[@id='continents']"));
		Select select = new Select(dropdown);

		// Select Europe by index
		log.info("Select option by index");
		System.out.println("Select option by index");
		select.selectByIndex(1);

		// Select Antartica by text
		log.info("Select option by visible text");
		System.out.println("Select option by visible text");
		select.selectByVisibleText("Antartica");

		// Get all options in list
		List<WebElement> allOptions = select.getOptions();
		for (int i = 0; i <= allOptions.size() - 1; i++) {
			String option = allOptions.get(i).getText();
			System.out.println("Dropdown option " + option);
			if (option.equals("North America")) {
				log.info("Selecting North America");
				System.out.println("Selecting North America");
				allOptions.get(i).click();
			}
		}
	}

	@Test(priority = 4, enabled = true)
	public void iframeHandeling() {
		System.out.println("Entering url...");
		log.info("Entering url...");
		driver.get("http://toolsqa.com/iframe-practice-page/");
		driver.manage().window().maximize();

		// Implicite wait
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

		// Getting the count of frames on the page
		log.info("Getting the count of frames on the page..");
		System.out.println("Getting the count of frames on the page..");
		List<WebElement> iframes = driver.findElements(By.tagName("iframe"));
		int count = iframes.size();
		System.out.println("No. of iframes on webpage are " + count);

		// Switch to frame by using id
		log.info("Switching to first frame using id");
		System.out.println("Switching to first frame using id");
		driver.switchTo().frame("IF1");

		log.info("Switching to default");
		System.out.println("Switching to default");
		driver.switchTo().defaultContent();

		// Switch to frame by using index
		log.info("Switching to second frame using index");
		System.out.println("Switching to second frame using index");
		driver.switchTo().frame(1);

		log.info("Switching to default");
		System.out.println("Switching to default");
		driver.switchTo().defaultContent();
	}
	
	@AfterMethod
	public void closeBrowser() {
		log.info("Closing the browser...");
	System.out.println("Closing the browser...");
		driver.close();
	}
	

}
