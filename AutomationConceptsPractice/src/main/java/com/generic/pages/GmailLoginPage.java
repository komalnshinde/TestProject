package com.generic.pages;

import org.openqa.selenium.By;

public class GmailLoginPage {
	WrapperFunctions objWrapperFunctions = new WrapperFunctions();
	
	public GmailLoginPage() {
		
	}
	
	//Inputs 
	By inpEmail = By.xpath("//input[@id='identifierId']");
	
	
	//Buttons
	 By btnNext = By.xpath("//div[@class='ZFr60d CeoRYc']");
	 
	 
	 //Set email Id
	 public void setGmailLoginPageEmailId(String emailId) {
		 objWrapperFunctions.setText(inpEmail, emailId);
		 
	 }
	 
	 //Click on Next button
	 public void clickGmailLoginPageNextButton() {
		 objWrapperFunctions.click(btnNext);
	 }
}
