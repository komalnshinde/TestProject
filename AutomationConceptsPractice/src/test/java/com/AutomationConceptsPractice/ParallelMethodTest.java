package com.AutomationConceptsPractice;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class ParallelMethodTest {


	    @BeforeMethod(groups= {"P1","P2","P3"})
	    public void beforeMethod() {
	        long id = Thread.currentThread().getId();
	        System.out.println("Before test-method. Thread id is: " + id);
	    }
	 
	    @Test(priority =1,groups= { "P1" })
	    public void testMethodsOne() {
	        long id = Thread.currentThread().getId();
	        System.out.println("Simple test-method One. Thread id is: " + id);
	    }
	 
	    @Test(priority =2,groups= { "P2" })
	    public void testMethodsTwo() {
	        long id = Thread.currentThread().getId();
	        System.out.println("Simple test-method Two. Thread id is: " + id);
	    }
	 
	    @AfterMethod
	    public void afterMethod() {
	        long id = Thread.currentThread().getId();
	        System.out.println("After test-method. Thread id is: " + id);
	    }
}
