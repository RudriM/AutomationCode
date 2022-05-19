package com.wac.cwp.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.wac.cwp.base.TestBase;

public class RegistrationPageStep2 extends TestBase {
	
	@FindBy(xpath="//input[@id='number']")
	WebElement enterPhneNumber;
	
	@FindBy(xpath="//button[@id='verifyPhone']")
	WebElement callMeInstead;
	
	@FindBy(xpath="//button[@id='sendCode']")
	WebElement sendVerificationCode;
	

	
	
	
	
	
	
	
	public RegistrationPageStep2(){
		PageFactory.initElements(driver, this);
	}


}
