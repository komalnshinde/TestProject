package com.generic.pages;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.List;
import java.util.NoSuchElementException;
import java.util.Properties;

import org.openqa.selenium.By;
import org.openqa.selenium.ElementNotVisibleException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

public class WrapperFunctions {
	WebDriver driver;
	String strReturnVal = "";
	WebDriverWait wait = new WebDriverWait(driver, 10);

	// wait for visibility of element
	public boolean waitForVisibilityOfElement(By locator) {
		try {
			wait.until(ExpectedConditions.visibilityOfElementLocated(locator));
			return true;
		} catch (ElementNotVisibleException e) {
			System.out.println("ElementNotVisibleException" + e.getMessage());
			return false;
		} catch (Exception e) {
			System.out.println(e.getMessage());
			return false;
		}
	}

	// Click
	public boolean click(By locator) {

		try {
			this.waitForVisibilityOfElement(locator);
			driver.findElement(locator).click();
			return true;
		} catch (NoSuchElementException e) {
			System.out.println("No Such Element Exception :" + e.getMessage());
			return false;
		} catch (Exception e) {
			System.out.println(e.getMessage());
			return false;
		}
	}

	// SetText
	public boolean setText(By locator, String textToEnter) {
		try {
			this.waitForVisibilityOfElement(locator);
			driver.findElement(locator).sendKeys(textToEnter);
			return true;
		} catch (NoSuchElementException e) {
			System.out.println("No Such Element Exception :" + e.getMessage());
			return false;
		} catch (Exception e) {
			System.out.println(e.getMessage());
			return false;
		}
	}

	// GetText
	public String getText(By locator) {
		try {
			this.waitForVisibilityOfElement(locator);
			strReturnVal = driver.findElement(locator).getText();
			return strReturnVal;
		} catch (NoSuchElementException e) {
			System.out.println("No Such Element Exception :" + e.getMessage());
			return null;
		} catch (NullPointerException e) {
			System.out.println("Null Pointer Exception :" + e.getMessage());
			return null;
		} catch (Exception e) {
			System.out.println(e.getMessage());
			return null;
		}

	}

	// Select dropdown value by visible text
	public boolean selectDropdownValueByVisibleText(By locator, String optionToSelect) {
		try {
			this.waitForVisibilityOfElement(locator);
			WebElement dropdown = driver.findElement(locator);
			Select select = new Select(dropdown);
			List<WebElement> allOptions = select.getOptions();
			for (WebElement option : allOptions) {
				String text = option.getText();
				if (text.equals(optionToSelect)) {
					option.click();
				}
			}
			return true;
		} catch (NoSuchElementException e) {
			System.out.println("No Such Element Exception :" + e.getMessage());
			return false;
		} catch (Exception e) {
			System.out.println(e.getMessage());
			return false;
		}
	}
	
	
	//Select dropdown value by index
	public boolean selectDropdownValueByIndex(By locator,int index){
		try {
			this.waitForVisibilityOfElement(locator);
			WebElement dropdown = driver.findElement(locator);
			Select select = new Select(dropdown);
			select.selectByIndex(index);
			return true;
		} catch (NoSuchElementException e) {
			System.out.println("No Such Element Exception :" + e.getMessage());
			return false;
		} catch (Exception e) {
			System.out.println(e.getMessage());
			return false;
		}
	}
	
	
	//Select dropdown value by value
		public boolean selectDropdownValueByValue(By locator,String valueAttributeText){
			try {
				this.waitForVisibilityOfElement(locator);
				WebElement dropdown = driver.findElement(locator);
				Select select = new Select(dropdown);
				select.selectByValue(valueAttributeText);
				return true;
			} catch (NoSuchElementException e) {
				System.out.println("No Such Element Exception :" + e.getMessage());
				return false;
			} catch (Exception e) {
				System.out.println(e.getMessage());
				return false;
			}
		}
	
	
	

}
