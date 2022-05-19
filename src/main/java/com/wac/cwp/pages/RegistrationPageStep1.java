package com.wac.cwp.pages;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

import com.wac.cwp.base.TestBase;
import com.wac.cwp.helper.Waits;
import com.wac.cwp.helper.GetCurrentDateAndTime;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class RegistrationPageStep1 extends TestBase {
	
	@FindBy(xpath="//h1[text()='Sign Up']")
	WebElement signUpPageTitle;
	
	@FindBy(xpath="//input[@id='email']")
	WebElement signUpEmailAddress;
	
	@FindBy(xpath="//input[@id='newPassword']")
	WebElement signUpPassword;
	
	@FindBy(xpath="//input[@id='reenterPassword']")
	WebElement reenterPassword;
	
	@FindBy(xpath="//input[@id='extension_TermsOfUseConsented_2021-02-19']/following-sibling::span")
	WebElement termsCheckbox;
	
	@FindBy(xpath="//input[@id='extension_EmailOptInPromotional_true']/following-sibling::span")
	WebElement promotionCheckbox;
	
	@FindBy(xpath="//button[text()='Create Account']")
	WebElement createAccount;
	
	@FindBy(xpath="//a[text()='Log In']")
	WebElement logInLink;
	
	@FindBy(xpath="//a[text()='Privacy Policy']")
	WebElement privacyLink;
	
	@FindBy(xpath="//a[text()='Terms of Service']")
	WebElement termsLink;
	
	@FindBy(xpath="//div[@class='error itemLevel show' and @aria-hidden='false']")
	List<WebElement> errorMsgbelowField;
	
	@FindBy(xpath="//div[@class='error pageLevel' and @aria-hidden = 'false']")
	WebElement errorMsgAtTop;
	
	public RegistrationPageStep1(){
		PageFactory.initElements(driver, this);
		}
	
	public boolean verifySignUpPageIsDisplayed() {
		Waits.explicitWaitForElementVisible(signUpPageTitle);
		boolean isDisplayed = signUpPageTitle.isDisplayed();
		log.info("Is Sign Up page displayed? : " +isDisplayed);
		return isDisplayed;
	}
	
	public boolean verifySignUpPageHasEmailAddrField() {
		Waits.explicitWaitForElementVisible(signUpEmailAddress);
		boolean isDisplayed = signUpEmailAddress.isDisplayed();
		log.info("Does Sign Up page has Email field? : " +isDisplayed);
		return isDisplayed;
	}
	
	public boolean verifySignUpPageHasPasswordField() {
		Waits.explicitWaitForElementVisible(signUpPassword);
		boolean isDisplayed = signUpPassword.isDisplayed();
		log.info("Does Sign Up page has Password field? : " +isDisplayed);
		return isDisplayed;
	}
	
	public boolean verifySignUpPageHasConfPasswordField() {
		Waits.explicitWaitForElementVisible(reenterPassword);
		boolean isDisplayed = reenterPassword.isDisplayed();
		log.info("Does Sign Up page has Confirm Password field? : " +isDisplayed);
		return isDisplayed;
	}
	
	public boolean verifySignUpPageHasTermsCheckbox() {
		Waits.explicitWaitForElementVisible(termsCheckbox);
		boolean isDisplayed = termsCheckbox.isDisplayed();
		log.info("Does Sign Up page has Terms checkbox? : " +isDisplayed);
		return isDisplayed;
	}
	
	public boolean verifySignUpPageHasPromotionCheckbox() {
		Waits.explicitWaitForElementVisible(promotionCheckbox);
		boolean isDisplayed = promotionCheckbox.isDisplayed();
		log.info("Does Sign Up page has promotion email checkbox? : " +isDisplayed);
		return isDisplayed;
	}
	
	public boolean verifySignUpPageHasCreateAccountButton() {
		Waits.explicitWaitForElementVisible(createAccount);
		boolean isDisplayed = createAccount.isDisplayed();
		log.info("Does Sign Up page has create account button? : " +isDisplayed);
		return isDisplayed;
	}
	
	public boolean verifySignUpPageHasLoginLink() {
		Waits.explicitWaitForElementVisible(logInLink);
		boolean isDisplayed = logInLink.isDisplayed();
		log.info("Does Sign Up page has logIn Link? : " +isDisplayed);
		return isDisplayed;
	}
	
	public String fillUpSignUpFormInStep1(HashMap<String, String> map) {
		
		Waits.explicitWaitForElementVisible(createAccount);
		
		String emailGenerated = "";
	    
		if(map.get("Email").contentEquals("BLANK")) {
			
		} 
		else if (map.get("Email").contentEquals("Generate")) {
			
			String time = GetCurrentDateAndTime.getDateyyyyMMddhhmmssFormat();
			emailGenerated = "test"+time+"@mailinator.com";
			signUpEmailAddress.sendKeys(emailGenerated);
			log.info("Specified sign up email address as"  +emailGenerated);
		} 
		else {
			
			signUpEmailAddress.sendKeys(map.get("Email"));
			log.info("Specified sign up email address as"  +map.get("Email"));
		}
		
		if(map.get("Password").contentEquals("BLANK")) {
			
		}
		else {
			signUpPassword.sendKeys(map.get("Password"));
			log.info("Specified sign up password as"  +map.get("Password"));
		}
		
		if(map.get("ConfirmPassword").contentEquals("BLANK")) {
			
		}
		else {
			reenterPassword.sendKeys(map.get("ConfirmPassword"));
			log.info("Specified sign up confirm password as"  +map.get("ConfirmPassword"));
		}
		
		
		if(map.get("AcceptTerms").contentEquals("YES")) {
			termsCheckbox.click();
			log.info("Accepted terms and conditions");
		}
		
		
		if(map.get("AcceptPromotion").contentEquals("YES")) {
			promotionCheckbox.click();
			log.info("Accepted promotion checkbox");
		}
		
		createAccount.click();
		log.info("Clicked on create account");
		
		return emailGenerated;
		
	}
	
	public void clickSignin() {
		logInLink.click();
		log.info("Clicked on the sign in link");
	}
	
	public void clickPrivayPolicyLink() {
		Waits.explicitWaitForElementVisible(createAccount);
		privacyLink.click();
		log.info("Clicked on privacy policy link");
	}
	
	public void clickTermsOfServiceLink() {
		Waits.explicitWaitForElementVisible(createAccount);
		termsLink.click();
		log.info("Clicked on terms of service link");
	}
	
	public String getErrorMsgAtTop() {
		
		String errMsg = errorMsgAtTop.getText();
		log.info("The error message displayed at the top is: " +errMsg);
		return errMsg;
	}
	
	public String getErrorMsgbelowFields() {
		
		String errorMess;
		String allErrorMsgs = "";
		
		Waits.explicitWaitForElementVisible(createAccount);
		
		int len = errorMsgbelowField.size();
		
		for (int i=0 ; i < len ; i++) {
			errorMess = errorMsgbelowField.get(i).getText();
			log.info("The error message displayed is " +errorMess);
			allErrorMsgs = allErrorMsgs + " " + errorMess;
		}
		
		allErrorMsgs = allErrorMsgs.trim();

		return allErrorMsgs;
		
	}
	
	public VerifyYourEmailAddressPage verifySucessfulCompletionOfStep1() {	
		
		return new VerifyYourEmailAddressPage();
	}
	
	public void verifyTheURLOpenedInNewTab(String expectedURL) {
		
		(new WebDriverWait(driver, 30)).until(ExpectedConditions.numberOfWindowsToBe(2));
		List<String> browserTabs = new ArrayList<String> (driver.getWindowHandles());
		driver.switchTo().window(browserTabs .get(1));
		String actualUrl = driver.getCurrentUrl();
		log.info("The actual url opened is : " +actualUrl);
		log.info("The expected url to open is : " +expectedURL);
		Assert.assertEquals(actualUrl, expectedURL, "The actual URL opened is different from expected");
		driver.close();
		driver.switchTo().window(browserTabs.get(0));
	}

}
