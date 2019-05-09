package com.generic.pages;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.Properties;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class Utilities {
	WebDriver driver;
	private Properties properties;
	private final String propertyFilePath = "resources//user.properties";

	public void ConfigFileReader() {
		BufferedReader reader;
		try {
			reader = new BufferedReader(new FileReader(propertyFilePath));
			properties = new Properties();
			try {
				properties.load(reader);
				reader.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
		} catch (FileNotFoundException e) {
			e.printStackTrace();
			throw new RuntimeException("Configuration.properties not found at " + propertyFilePath);
		}
	}

	public WebDriver getDriver() {
		String browserType = properties.getProperty("browserType");
		try {
			if (browserType.equalsIgnoreCase("CHROME")) {
				System.setProperty("webdriver.chrome.driver", properties.getProperty("chromeDriverExePath"));
				driver = new ChromeDriver();
				return driver;
			}
		} catch (Exception e) {
			System.out.println(e.getMessage());
			return null;
		}
		return driver;

	}

}
