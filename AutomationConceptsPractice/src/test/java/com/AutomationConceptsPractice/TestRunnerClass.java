package com.AutomationConceptsPractice;

import org.testng.TestNG;

public class TestRunnerClass {
	static TestNG testNG;
	
public static void main(String[] args) {
	
	testNG=new TestNG();
	//add test class to run
	testNG.setTestClasses(new Class[] {AlertsInSelenium.class});
	testNG.run();
}
}