package com.wac.cwp.pages;

import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.wac.cwp.base.TestBase;
import com.wac.cwp.helper.Waits;

public class LoginPage extends TestBase{
	
	@FindBy(xpath="//h2[@id='headerLogoText']")
	WebElement pageHeaderText;
	
	@FindBy(xpath="//input[@id='signInName']")
	WebElement signInUserName;
	
	@FindBy(xpath="//input[@id='password']")
	WebElement signInPassword;
	
	@FindBy(xpath="//a[@id='forgotPassword']")
	WebElement forgotPassword;
	
	@FindBy(xpath="//button[@id='next']")
	WebElement signIn;
	
	@FindBy(xpath="//div[contains(@class,'error pageLevel')]/p")
	WebElement invalidErrorMsg;
	
	@FindBy(xpath="//div[@class='error itemLevel' and @aria-hidden='false']/p")
	List<WebElement> missingError;
	
	@FindBy(xpath="//a[@id='createAccount']")
	WebElement signUp;	
	
	
	
	public LoginPage(){
		PageFactory.initElements(driver, this);
	}
	
	
	public boolean verifyLoginScreenIsDisplayed() {
		Waits.explicitWaitForElementVisible(pageHeaderText);
		boolean isDisplayed = pageHeaderText.isDisplayed();
		log.info("is Login page displayed? : " +isDisplayed);
		return isDisplayed;
	}
	
	public void login(String userName, String password) {
		
		signInUserName.sendKeys(userName);
		log.info("Specified the sign in name as: " +userName);
		signInPassword.sendKeys(password);
		log.info("Specified the sign in password as: " +password);
		signIn.click();
		log.info("Click on sign in button");
	}
	
	public RegistrationPageStep1 clickOnSignUp() {
		signUp.click();
		log.info("Clicked on sign up option");
		return new RegistrationPageStep1();
	}
	
	public String getInvalidUserNameOrPasswordError() {
		Waits.explicitWaitForElementVisible(invalidErrorMsg);
		String errorMessage = invalidErrorMsg.getText();
		log.info("The error message displayed is " +errorMessage);
		return errorMessage;
	}
	
	public String missingUsernameOrPasswordError() {
		
		String errorMess;
		String allErrorMsgs = "";
		
		Waits.explicitWaitForElementVisible(signIn);
		
		int len = missingError.size();
		
		for (int i=0 ; i < len ; i++) {
			errorMess = missingError.get(i).getText();
			log.info("The error message displayed is " +errorMess);
			allErrorMsgs = allErrorMsgs + " " + errorMess;
		}
		
		allErrorMsgs = allErrorMsgs.trim();

		return allErrorMsgs;
	}
	
	public ForgotPasswordPageStep1 ClickOnForgotPasswordLink() {
		forgotPassword.click();
		log.info("clicked on forgot password link");
		return new ForgotPasswordPageStep1();
	}
		
}
