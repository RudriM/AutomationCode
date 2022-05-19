package com.wac.cwp.pages;

import java.util.HashMap;
import java.util.List;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

import com.wac.cwp.base.TestBase;
import com.wac.cwp.helper.Waits;
import com.wac.cwp.util.HandlingMails;

public class VerifyYourEmailAddressPage extends TestBase{
	
	HandlingMails handlingMail;
	
	@FindBy(xpath="//h1[text()='Verify Your Email Address']")
	WebElement verifyPageHeader;
	
	@FindBy(xpath="//div[@class='verificationInfoText' and @aria-hidden='false']")
	WebElement messageAtTop;
	
	@FindBy(xpath="//input[@id='readOnlyEmail_ver_input']")
	WebElement verificationCode;
	
	@FindBy(xpath="//button[text()='RESEND CODE']")
	WebElement resendCodeButton;
	
	@FindBy(xpath="//button[text()='VERIFY CODE']")
	WebElement verifyCodeButton;
	
	@FindBy(xpath="//a[text()='Use a different email address']")
	WebElement useDiffEmailLink;
	
	@FindBy(xpath="//div[@id='claimVerificationServerError']")
	WebElement accountNotExistingError;
	
	@FindBy(xpath="//div[@class='error itemLevel show' and @aria-hidden='false']")
	WebElement errorMsgbelowField;
	
	@FindBy(xpath="//div[@class='verificationErrorText error' and @aria-hidden='false']")
	WebElement invalidCodeErrorMsg;
	
	@FindBy(xpath="//div[@class='resendEmailVerCodeMessage']/span")
	WebElement resendSuccMessage;
	
	@FindBy(xpath="//div[@id='email_success']")
	WebElement verificationSuccessMsg;
	
	@FindBy(xpath="//button[text()='Continue']")
	WebElement continueButton;
	
	@FindBy(xpath="//input[@id='readOnlyEmail']")
	WebElement emailField;
	
	@FindBy(xpath="//button[text()='SEND CODE']")
	WebElement sendCode;
	
	public VerifyYourEmailAddressPage(){
		PageFactory.initElements(driver, this);
	}
	
	public boolean verifyEmailAddressPageIsDisplayed() {
		
		Waits.explicitWaitForElementVisible(verifyPageHeader);
		boolean isDisplayed = verifyPageHeader.isDisplayed();
		log.info("Is Verify Email Address Page Displayed: " +isDisplayed);
		return isDisplayed;
	}
	public void enterVerificationCode(HashMap<String, String> map) throws Exception {
		
		//connecting to the user e-mail id via backend api
		try {
			handlingMail = new HandlingMails(map.get("Email"), map.get("GmailPassword"), HandlingMails.EmailFolder.INBOX);
			log.info("Connection to email is successfull");
		    } catch (Exception e) {
		      e.printStackTrace();
		      Assert.fail(e.getMessage());
		    }
		

		
		String code = handlingMail.getCode();

		verificationCode.sendKeys(code);
		log.info("Specified the verification code as: " +code);
		
		}
	
	public void enterInvalidCode(String code) {
		Waits.explicitWaitForElementVisible(verificationCode);
		verificationCode.sendKeys(code);
		log.info("Specified the verification code as: " +code);
		
	}
	
	public void clickOnResendCode() {
		Waits.explicitWaitForElementVisible(resendCodeButton);
		resendCodeButton.click();
		log.info("Clicked on resend code option");
	}
	
	public void verifyResendSuccessMessage(String message) {
		Waits.explicitWaitForElementVisible(resendSuccMessage);
		String resendMessage = resendSuccMessage.getText();
		log.info("The actual message displayed is " +resendMessage);
		log.info("The expected message is " +message);
		Assert.assertEquals(resendMessage, message, "The Expected and Actual message are different");
	}
	
	public void clickOnVerifyCode() {
		verifyCodeButton.click();
		log.info("Clicked on verify code option");
	}
	
	public ForgotPasswordPageStep1 clickOnUseDifferentEmail() {
		Waits.explicitWaitForElementVisible(useDiffEmailLink);
		useDiffEmailLink.click();
		log.info("Clicked on use different email button");
		return new ForgotPasswordPageStep1();
	}
	
	public void verifyValidCodeResult(String expectedMsg) {
		Waits.explicitWaitForElementVisible(verificationSuccessMsg);
		String veriftnSuccess = verificationSuccessMsg.getText();
		log.info("The actual message displayed is " +veriftnSuccess);
		log.info("The expected message is " +expectedMsg);
		Assert.assertEquals(veriftnSuccess, expectedMsg, "The Expected and Actual message are different");
		
	}
	
	public void verifyInvalidCodeResult(String expectedMsg) {
		String VerificationFail = invalidCodeErrorMsg.getText();
		log.info("The actual message displayed is " +VerificationFail);
		log.info("The expected message is " +expectedMsg);
		Assert.assertEquals(VerificationFail, expectedMsg, "The Expected and Actual message are different");
	}
	
	public ForgotPasswordPageStep2 clickContinue() {
		Waits.explicitWaitForElementVisible(continueButton);
		continueButton.click();
		log.info("Clicked on continue button");
		return new ForgotPasswordPageStep2();
	}
	
	public void editEmail(String email) {
		Waits.explicitWaitForElementVisible(emailField);
		emailField.clear();
		emailField.sendKeys(email);
	}
	
	public void clickOnSendCode() {
		sendCode.click();
		log.info("Clicked on send code button");
	}
	
	public String getAccountNotExistError() {
		Waits.explicitWaitForElementVisible(accountNotExistingError);
		String errMsg = accountNotExistingError.getText();
		log.info("The error message is: " +errMsg);
		return errMsg;
	}
	
	public boolean verifyContinueButtonIsDisplayed() {
		Waits.explicitWaitForElementVisible(continueButton);
		boolean isDisplayed = continueButton.isDisplayed();
		log.info("Is Continue button displayed? :" +isDisplayed);
		return isDisplayed;
	}
	
	public void clickOnContinue() {
		Waits.explicitWaitForElementVisible(continueButton);
		continueButton.click();
		log.info("Clicked on Continue button");
	}
	
	public boolean verifySendCodeButtonIsDisplayed() {
		Waits.explicitWaitForElementVisible(sendCode);
		boolean isDisplayed = sendCode.isDisplayed();
		log.info("Is Send Code button displayed? :" +isDisplayed);
		return isDisplayed;
	}
	
	public String getInvalidEmailError() {
		Waits.explicitWaitForElementVisible(sendCode);
		String errorMsg = errorMsgbelowField.getText();
		return errorMsg;
	}
	
	public boolean verifyMessageAtTopOfVerifyEmailPage(String email) {
		Waits.explicitWaitForElementVisible(verifyCodeButton);
		String expectedMessage = "We sent an email to "+email+". Please enter the verification code you received below.";
		String actualMessage = messageAtTop.getText();
		log.info("Actual message at the top: " +actualMessage);
		log.info("Expected message at the top: " +expectedMessage);
		boolean isMessageCorrect = expectedMessage.contentEquals(actualMessage);
		return isMessageCorrect;
		
	}
	
	public boolean verifyThatVerifyEmailPageHasVerificationCodeField() {
		Waits.explicitWaitForElementVisible(verifyCodeButton);
		boolean isDisplayed = verificationCode.isDisplayed();
		log.info("Does Verify Email Page has Verification Code Input field? : " +isDisplayed);
		return isDisplayed;
	}
	
	public boolean verifyResendCodeButtonIsDisplayed() {
		Waits.explicitWaitForElementVisible(resendCodeButton);
		boolean isDisplayed = resendCodeButton.isDisplayed();
		log.info("Is Resend Code button displayed? :" +isDisplayed);
		return isDisplayed;
	}
	
	public boolean verifyVerifyCodeButtonIsDisplayed() {
		Waits.explicitWaitForElementVisible(verifyCodeButton);
		boolean isDisplayed = verifyCodeButton.isDisplayed();
		log.info("Is Verify Code button displayed? :" +isDisplayed);
		return isDisplayed;
	}
	
	public boolean verifyDiffEmailLinkIsDisplayed() {
		Waits.explicitWaitForElementVisible(verifyCodeButton);
		boolean isDisplayed = useDiffEmailLink.isDisplayed();
		log.info("Is use different email link displayed? :" +isDisplayed);
		return isDisplayed;
	}
	
	}


