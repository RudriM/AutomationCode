package com.wac.cwp.pages;

import java.util.List;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;
import org.testng.asserts.SoftAssert;

import com.wac.cwp.base.TestBase;
import com.wac.cwp.helper.Waits;

public class ForgotPasswordPageStep2 extends TestBase {
	
	@FindBy(xpath="//h1[text()='Forgot Password']")
	WebElement forgotPasswordPageHeader;
	
	@FindBy(xpath="//input[@id='newPassword']")
	WebElement newPassword;
	
	@FindBy(xpath="//input[@id='reenterPassword']")
	WebElement confirmPassword;
	
	@FindBy(xpath="//button[@id='cancelButton']")
	WebElement cancelButton;
	
	@FindBy(xpath="//button[text()='CHANGE PASSWORD']")
	WebElement confirmPasswordButton;
	
	@FindBy(xpath="//div[@class='error pageLevel alert alert-danger' and @aria-hidden='false']")
	WebElement invalidPasswordMainErrorMsg;
	
	@FindBy(xpath="//div[@class='error itemLevel show' and @aria-hidden='false']")
	List<WebElement> setupPasswordFieldErrorMsg;
	
	@FindBy(xpath="//h1[@id='changePasswordHeader']")
	WebElement passwordChangeSuccess;
	
	@FindBy(xpath="//button[text()='Finish']")
	WebElement finishButton;
	
	
	public ForgotPasswordPageStep2(){
		PageFactory.initElements(driver, this);
	}
	
	public boolean verifyForgotPasswordStep2IsDisplayed() {
		Waits.explicitWaitForElementVisible(forgotPasswordPageHeader);
		boolean isDisplayed = forgotPasswordPageHeader.isDisplayed();
		log.info("is forgot password page Step 2 displayed? : " +isDisplayed);
		return isDisplayed;
	}
	
	public boolean verifyPasswordField() {
		Waits.explicitWaitForElementVisible(newPassword);
		boolean isDisplayed = newPassword.isDisplayed();
		log.info("does forgot password page step2 has new password field displayed? : " +isDisplayed);
		return isDisplayed;
	}
	
	public boolean verifyConfirmPasswordField() {
		Waits.explicitWaitForElementVisible(confirmPassword);
		boolean isDisplayed = confirmPassword.isDisplayed();
		log.info("does forgot password page step2 has confirm password field displayed? : " +isDisplayed);
		return isDisplayed;
	}
	
	public boolean verifyCancelButton() {
		Waits.explicitWaitForElementVisible(cancelButton);
		boolean isDisplayed = cancelButton.isDisplayed();
		log.info("does forgot password page step2 has cancel button displayed? : " +isDisplayed);
		return isDisplayed;
	}
	
	public boolean verifyChangePasswordBtn() {
		Waits.explicitWaitForElementVisible(confirmPasswordButton);
		boolean isDisplayed = confirmPasswordButton.isDisplayed();
		log.info("does forgot password page step2 has change password button displayed? : " +isDisplayed);
		return isDisplayed;
	}
	
	public void enterPasswordAndConfirmPassword(String password, String confPassword) {
		Waits.explicitWaitForElementVisible(newPassword);
		newPassword.sendKeys(password);
		log.info("Specified password as: " +password);
		confirmPassword.sendKeys(confPassword);
		log.info("Specified confirm password as: " +confPassword);		
	}
	
	public void clickChangePswd() {
		Waits.explicitWaitForElementVisible(confirmPasswordButton);
		confirmPasswordButton.click();
		log.info("Clicked on change password button");
	}
	
	public void clickCancel() {
		cancelButton.click();
		log.info("Clicked on cancel button");
	}
	
	public void verifySuccessfullPasswordChange(String expectedMsg) {
		Waits.explicitWaitForElementVisible(passwordChangeSuccess);
		String successMsg = passwordChangeSuccess.getText();
		log.info("The actual success message displayed is: " +successMsg);
		log.info("The expected success message is: " +expectedMsg);
		Assert.assertEquals(successMsg, expectedMsg, "The actual success message is different from expected message");
	}
	
	public String verifyPasswordChangeErrors() {
		
		String errorMess;
		String allErrorMsgs = "";
		
		Waits.explicitWaitForElementVisible(forgotPasswordPageHeader);
		
		int len = setupPasswordFieldErrorMsg.size();
		
		for (int i=0 ; i < len ; i++) {
			errorMess = setupPasswordFieldErrorMsg.get(i).getText();
			log.info("The error message displayed is " +errorMess);
			allErrorMsgs = allErrorMsgs + " " + errorMess;
		}
		
		allErrorMsgs = allErrorMsgs.trim();

		return allErrorMsgs;
	}
	
	public String getMainError() {
		
		String actualErrorMsg = invalidPasswordMainErrorMsg.getText();
		log.info("The actual error message displayed is: " +actualErrorMsg);
		return actualErrorMsg;

	}
	
	public boolean verifyFinishButton() {
		Waits.explicitWaitForElementVisible(finishButton);
		boolean isDisplayed = finishButton.isDisplayed();
		log.info("Is finish button displayed? : " +isDisplayed);
		return isDisplayed;
	}
	
	public LoginPage clickOnFinish() {
		Waits.explicitWaitForElementVisible(finishButton);
		finishButton.click();
		log.info("Clicked on finish button");
		return new LoginPage();
	}
	

}
