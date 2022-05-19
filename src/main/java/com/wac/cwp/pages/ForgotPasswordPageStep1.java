package com.wac.cwp.pages;


import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.wac.cwp.base.TestBase;
import com.wac.cwp.helper.Waits;


public class ForgotPasswordPageStep1 extends TestBase{
	
	@FindBy(xpath="//h1[@id='forgotPasswordHeader']")
	WebElement forgotPasswordPageHeader;
	
	@FindBy(xpath="//input[@id='email']")
	WebElement forgotPasswordEmail;
	
	@FindBy(xpath="//button[@id='cancelButton']")
	WebElement forgotPasswordCancel;
	
	@FindBy(xpath="//button[@id='email_ver_but_send']")
	WebElement forgotPasswordSendVerification;
	
	@FindBy(xpath="//a[text()='Sign up']")
	WebElement signUp;	
	
	@FindBy(xpath="//div[@class='error itemLevel show']")
	WebElement invalidEmailError;
	
	public ForgotPasswordPageStep1(){
		PageFactory.initElements(driver, this);
	}
	
	public boolean verifyForgotPasswordPageIsDisplayed() {
		
		Waits.explicitWaitForElementVisible(forgotPasswordPageHeader);
		boolean isDisplayed = forgotPasswordPageHeader.isDisplayed();
		log.info("Is forgot password page displayed: " +isDisplayed);
		return isDisplayed;
		
	}
	
	public boolean verifyForgotPasswrdPgeEmailField() {
		
		boolean isDisplayed = forgotPasswordEmail.isDisplayed();
		log.info("Is email field displayed: " +isDisplayed);
		return isDisplayed;
	}
	
	public boolean verifyForgotPasswrdPgeCancelButton() {
		
		boolean isDisplayed = forgotPasswordCancel.isDisplayed();
		log.info("Is cancel button displayed: " +isDisplayed);
		return isDisplayed;
	}
	
	public boolean verifyForgotPasswrdPgeSendButton() {
		
		boolean isDisplayed = forgotPasswordSendVerification.isDisplayed();
		log.info("Is send verification button displayed: " +isDisplayed);
		return isDisplayed;
		
	}
	
	public boolean verifyForgotPasswrdPgeSignUpLink() {
		
		boolean isDisplayed = signUp.isDisplayed();
		log.info("Is sign up link displayed: " +isDisplayed);		
		return	isDisplayed;
		
	}
	
	public void enterEmailAddress(String email) {
		Waits.explicitWaitForElementVisible(forgotPasswordEmail);
		forgotPasswordEmail.sendKeys(email);
		log.info("In forgot password screen specified the email as: " +email);
	}
	
	public LoginPage clickCancel() {
		forgotPasswordCancel.click();
		log.info("Clicked on cancel option");
		return new LoginPage();
	}

	
	public VerifyYourEmailAddressPage clickSendVericationCode() {
		forgotPasswordSendVerification.click();
		log.info("Clicked on send verification code");
		return new VerifyYourEmailAddressPage();
		
	}
	
	public String getEmailAddress() {
		String email = forgotPasswordEmail.getText();
		return email;
	}
	
	public void editEmailAddress(String email) {
		Waits.explicitWaitForElementVisible(forgotPasswordEmail);
		forgotPasswordEmail.clear();
		forgotPasswordEmail.sendKeys(email);
		log.info("In forgot password screen specified the email as: " +email);
		
	}
	
	public RegistrationPageStep1 clickSignUp() {
		signUp.click();
		log.info("Clicked on sign up link");
		return new RegistrationPageStep1();
	}
	
	public String getInvalidEmailError() {
		Waits.explicitWaitForElementVisible(invalidEmailError);
		String errorMessage = invalidEmailError.getText();
		errorMessage = errorMessage.trim();
		log.info("The error message displayed is " +errorMessage);
		return errorMessage;
	}


}
