package com.wac.cwp.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.wac.cwp.base.TestBase;

public class VerifyYourMobileNumberPage extends TestBase {
	
	@FindBy(xpath="//input[@id='verificationCode']")
	WebElement enterCode;
	
	@FindBy(xpath="//div[@id='differentPhoneLink']")
	WebElement differentPhoneLink;
	
	@FindBy(xpath="//div[@id='callMeLink']")
	WebElement callMeLink;
	
	@FindBy(xpath="//button[@id='retryCodeBtn']")
	WebElement resendCode;
	
	@FindBy(xpath="//button[@id='verifyCode']")
	WebElement verifyCode;
	
	@FindBy(xpath="//h1[text()='Stay in the know.']")
	WebElement stayInKnowVerificationHeader;
	
	@FindBy(xpath="//input[@id='extension_TextOptInPromotional_true']")
	WebElement promotionsTextMessageCheckbox;
	
	@FindBy(xpath="//input[@id='extension_TextOptInTransactional_true']")
	WebElement transactionalTextMessageCheckbox;
	
	@FindBy(xpath="//button[@id='continue']")
	WebElement continueButton;
	
	public VerifyYourMobileNumberPage(){
		PageFactory.initElements(driver, this);
	}
	
	

}
