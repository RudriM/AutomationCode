package com.wac.cwp.testcases;

import java.awt.AWTException;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.List;

import org.testng.Assert;
import org.testng.ITestContext;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import com.wac.cwp.base.TestBase;
import com.wac.cwp.pages.AccountsPage;
import com.wac.cwp.pages.ForgotPasswordPageStep1;
import com.wac.cwp.pages.ForgotPasswordPageStep2;
import com.wac.cwp.pages.LoginPage;
import com.wac.cwp.pages.RegistrationPageStep1;
import com.wac.cwp.pages.VerifyYourEmailAddressPage;
import com.wac.cwp.util.GetTestData;
import com.wac.cwp.util.HandlingMails;
import com.wac.cwp.util.PractiTest;

public class FogrotPasswordTestCases extends TestBase {
	
	LoginPage lgnPge;
	ForgotPasswordPageStep1  frgtPswdStp1;
	ForgotPasswordPageStep2  frgtPswdStp2;
	VerifyYourEmailAddressPage verifyEmail;
	HandlingMails handlingMail;
	RegistrationPageStep1 regPgeStp1;
	String loginSheet = "LoginPage";
	
	public FogrotPasswordTestCases() {
		super();
	}
	
	@BeforeMethod
	public void setUp() {
		
		initialization();
		lgnPge = new LoginPage();
		regPgeStp1 = new RegistrationPageStep1();
		frgtPswdStp1 = new ForgotPasswordPageStep1();
		frgtPswdStp2 = new ForgotPasswordPageStep2();
		verifyEmail = new VerifyYourEmailAddressPage();

	}
	  
	@DataProvider
	public Object[] fp07() {
		List<HashMap<String, String>> data = GetTestData.getTestData2("ForgotPassword", "forgotPasswordPage_FP_07");
		return data.toArray(); 
	}
	  
	@DataProvider
	public Object[] fp08_09() {
		List<HashMap<String, String>> data = GetTestData.getTestData2("ForgotPassword", "invalidOrBlankEmail_FP_08_09");
		return data.toArray(); 
	}
	
	@DataProvider
	public Object[] fp10_11() {
		List<HashMap<String, String>> data = GetTestData.getTestData2("ForgotPassword", "validEmailExistingAndNonExisting_FP_10_11");
		return data.toArray(); 
	}
	
	@DataProvider
	public Object[] fp12() {
		List<HashMap<String, String>> data = GetTestData.getTestData2("ForgotPassword", "forgotPasswordCancel_FP_12");
		return data.toArray(); 
	}
	
	@DataProvider
	public Object[] fp13() {
		List<HashMap<String, String>> data = GetTestData.getTestData2("ForgotPassword", "forgotPasswordSignUp_FP_13");
		return data.toArray(); 
	}
	
	@DataProvider
	public Object[] fp14() {
		List<HashMap<String, String>> data = GetTestData.getTestData2("ForgotPassword", "verifyEmailAddressPage_FP_14");
		return data.toArray(); 
	}
	
	@DataProvider
	public Object[] fp15_20() {
		List<HashMap<String, String>> data = GetTestData.getTestData2("ForgotPassword", "vrfyEmailAdrPageCrrctCodeAndResentCde_FP_15_20");
		return data.toArray(); 
	}
	
	@DataProvider
	public Object[] fp16_21() {
		List<HashMap<String, String>> data = GetTestData.getTestData2("ForgotPassword", "vrfyEmailAdrPageIncrrctCdeAndResentCde_FP_16_21");
		return data.toArray(); 
	}
	
	@DataProvider
	public Object[] fp17() {
		List<HashMap<String, String>> data = GetTestData.getTestData2("ForgotPassword", "vrfyEmailAdrPageIncrrctCodeMultipleTimes_FP_17");
		return data.toArray(); 
	}
	
	@DataProvider
	public Object[] fp19() {
		List<HashMap<String, String>> data = GetTestData.getTestData2("ForgotPassword", "vrfyEmailAdrPageResendCode_FP_19");
		return data.toArray(); 
	}
	
	@DataProvider
	public Object[] fp22() {
		List<HashMap<String, String>> data = GetTestData.getTestData2("ForgotPassword", "vrfyEmailAdrPageUseDiffEmail_FP_22");
		return data.toArray(); 
	}
	
	@DataProvider
	public Object[] fp23() {
		List<HashMap<String, String>> data = GetTestData.getTestData2("ForgotPassword", "editEmailAndSendCode_FP_23");
		return data.toArray(); 
	}
	
	@DataProvider
	public Object[] fp24() {
		List<HashMap<String, String>> data = GetTestData.getTestData2("ForgotPassword", "emailVerifiedContinue_FP_24");
		return data.toArray(); 
	}
	
	@DataProvider
	public Object[] fp25_26_27() {
		List<HashMap<String, String>> data = GetTestData.getTestData2("ForgotPassword", "createPasswordFailure_FP_25_26_27");
		return data.toArray(); 
	}
	
	@DataProvider
	public Object[] fp28_29() {
		List<HashMap<String, String>> data = GetTestData.getTestData2("ForgotPassword", "createPasswordSuccess_FP_28_29");
		return data.toArray(); 
	}
	
	@DataProvider
	public Object[] fp32() {
		List<HashMap<String, String>> data = GetTestData.getTestData2("ForgotPassword", "finish_FP_32");
		return data.toArray(); 
	}
	
	@Test(priority = 1, dataProvider = "fp07", description = "Forgot password page")
	public void forgotPasswordPage_FP_07(HashMap<String, String> map, ITestContext ctx, ITestResult rlt) throws InterruptedException, AWTException, IOException {
		
		SoftAssert softAssert = new SoftAssert();
		
		String dateAndTime = new SimpleDateFormat("yyyyMMddhhmmss").format(new Date());
		
		String instance = map.get("InstanceId");
				
		ctx.getCurrentXmlTest().addParameter( "InstanceId", instance);
		
		ctx.getCurrentXmlTest().addParameter( "Date", dateAndTime);
				
		log.info("In forgotPasswordPage_FP_07  ->  data is  " + map);
		
		log.info("*********************Start of  test " +map.get("TestCaseId")+ " **************************");
		
		lgnPge.ClickOnForgotPasswordLink();
		
		boolean isPgeDisplayed = frgtPswdStp1.verifyForgotPasswordPageIsDisplayed();
		softAssert.assertTrue(isPgeDisplayed);
		
		boolean isEmlFieldDisplayed = frgtPswdStp1.verifyForgotPasswrdPgeEmailField();
		softAssert.assertTrue(isEmlFieldDisplayed);
		
		boolean isCancelBtnDisplayed = frgtPswdStp1.verifyForgotPasswrdPgeCancelButton();
		softAssert.assertTrue(isCancelBtnDisplayed);
		
		boolean isSendBtnDisplayed = frgtPswdStp1.verifyForgotPasswrdPgeSendButton();
		softAssert.assertTrue(isSendBtnDisplayed);
		
		boolean isSignUpDisplayed = frgtPswdStp1.verifyForgotPasswrdPgeSignUpLink();
		softAssert.assertTrue(isSignUpDisplayed);
		
		softAssert.assertAll();

	}
	  

	@Test(priority = 2, dataProvider = "fp08_09", description = "Blank or Invalid Email in Forgot Password Page")
	public void invalidOrBlankEmail_FP_08_09(HashMap<String, String> map, ITestContext ctx, ITestResult rlt) throws InterruptedException, AWTException, IOException {
		
		SoftAssert softAssert = new SoftAssert();
		
		String dateAndTime = new SimpleDateFormat("yyyyMMddhhmmss").format(new Date());
		
		String instance = map.get("InstanceId");
				
		ctx.getCurrentXmlTest().addParameter( "InstanceId", instance);
		
		ctx.getCurrentXmlTest().addParameter( "Date", dateAndTime);
				
		log.info("In invalidOrBlankEmail_FP_08_09  ->  data is  " + map);
		
		log.info("*********************Start of  test " +map.get("TestCaseId")+ " **************************");
		
		lgnPge.ClickOnForgotPasswordLink();
		
		String email = map.get("Email");
		
		if (email.contentEquals("BLANK")){
			log.info("No email is specified");
			} 
		else {	
			frgtPswdStp1.enterEmailAddress(map.get("Email"));
			}
		
		frgtPswdStp1.clickSendVericationCode();
		
		String errorMsg = frgtPswdStp1.getInvalidEmailError();
		
		log.info("Expected error message is: " +map.get("ErrorMessage"));
		
		softAssert.assertEquals(errorMsg, map.get("ErrorMessage"), "Actual error message is different from expected");
		
		softAssert.assertAll();
		

	}
	
	
	@Test(priority = 3, dataProvider = "fp10_11", description = "Failed login to customer web portal")
	public void validEmailExistingAndNonExisting_FP_10_11(HashMap<String, String> map, ITestContext ctx, ITestResult rlt) throws Exception {
		
		SoftAssert softAssert = new SoftAssert();
		
		String dateAndTime = new SimpleDateFormat("yyyyMMddhhmmss").format(new Date());
		
		String instance = map.get("InstanceId");
				
		ctx.getCurrentXmlTest().addParameter( "InstanceId", instance);
		
		ctx.getCurrentXmlTest().addParameter( "Date", dateAndTime);
				
		log.info("In validEmailExistingAndNonExisting_FP_10_11  ->  data is  " + map);
		
		log.info("*********************Start of  test " +map.get("TestCaseId")+ " **************************");
		
		lgnPge.ClickOnForgotPasswordLink();
		
		frgtPswdStp1.enterEmailAddress(map.get("Email"));
		
		frgtPswdStp1.clickSendVericationCode();
		
		boolean isDisplayed = verifyEmail.verifyEmailAddressPageIsDisplayed();
		
		softAssert.assertTrue(isDisplayed);
		
		
		if (map.get("EmailExists").contentEquals("NO")) {

			verifyEmail.enterVerificationCode(map);
			
			verifyEmail.clickOnVerifyCode();
			
			verifyEmail.clickContinue();
			
			String error = verifyEmail.getAccountNotExistError();
			
			softAssert.assertEquals(error, map.get("ErrorMessage"), "Actual message is different from expected");
		} 
		else {
			
			try {
				handlingMail = new HandlingMails(map.get("Email"), map.get("GmailPassword"), HandlingMails.EmailFolder.INBOX);
				log.info("Connection to email is successfull");
			    } catch (Exception e) {
			      e.printStackTrace();
			      Assert.fail(e.getMessage());
			    }
			
			boolean isEmailRecieved = handlingMail.isMessageInFolder(map.get("EmailSubject"), true);
			log.info("is Verification Email recieved : " +isEmailRecieved);
			
		}
		
		softAssert.assertAll();

	}
	
	@Test(priority = 4, dataProvider = "fp12", description = "Forgot password page cancel option")
	public void forgotPasswordCancel_FP_12(HashMap<String, String> map, ITestContext ctx, ITestResult rlt) throws InterruptedException, AWTException, IOException {
		
		SoftAssert softAssert = new SoftAssert();
		
		String dateAndTime = new SimpleDateFormat("yyyyMMddhhmmss").format(new Date());
		
		String instance = map.get("InstanceId");
				
		ctx.getCurrentXmlTest().addParameter( "InstanceId", instance);
		
		ctx.getCurrentXmlTest().addParameter( "Date", dateAndTime);
				
		log.info("In forgotPasswordCancel_FP_12  ->  data is  " + map);
		
		log.info("*********************Start of  test " +map.get("TestCaseId")+ " **************************");
		
		lgnPge.ClickOnForgotPasswordLink();
		
		frgtPswdStp1.clickCancel();
		
		boolean isDisplayed = lgnPge.verifyLoginScreenIsDisplayed();
		
		softAssert.assertTrue(isDisplayed);
		
		softAssert.assertAll();
		
	}
	
	@Test(priority = 5, dataProvider = "fp13", description = "Forgot password page sign up option")
	public void forgotPasswordSignUp_FP_13(HashMap<String, String> map, ITestContext ctx, ITestResult rlt) throws InterruptedException, AWTException, IOException {
		
		SoftAssert softAssert = new SoftAssert();
		
		String dateAndTime = new SimpleDateFormat("yyyyMMddhhmmss").format(new Date());
		
		String instance = map.get("InstanceId");
				
		ctx.getCurrentXmlTest().addParameter( "InstanceId", instance);
		
		ctx.getCurrentXmlTest().addParameter( "Date", dateAndTime);
				
		log.info("In forgotPasswordSignUp_FP_13  ->  data is  " + map);
		
		log.info("*********************Start of  test " +map.get("TestCaseId")+ " **************************");
		
        lgnPge.ClickOnForgotPasswordLink();
		
		frgtPswdStp1.clickSignUp();
		
		boolean isDisplayed = regPgeStp1.verifySignUpPageIsDisplayed();
		
		softAssert.assertTrue(isDisplayed);
		
		softAssert.assertAll();

	}
	
	@Test(priority = 6, dataProvider = "fp14", description = "Verify email address page")
	public void verifyEmailAddressPage_FP_14(HashMap<String, String> map, ITestContext ctx, ITestResult rlt) throws InterruptedException, AWTException, IOException {
		
		SoftAssert softAssert = new SoftAssert();
		
		String dateAndTime = new SimpleDateFormat("yyyyMMddhhmmss").format(new Date());
		
		String instance = map.get("InstanceId");
				
		ctx.getCurrentXmlTest().addParameter( "InstanceId", instance);
		
		ctx.getCurrentXmlTest().addParameter( "Date", dateAndTime);
				
		log.info("In verifyEmailAddressPage_FP_14  ->  data is  " + map);
		
		log.info("*********************Start of  test " +map.get("TestCaseId")+ " **************************");
		
		lgnPge.ClickOnForgotPasswordLink();
		
		frgtPswdStp1.enterEmailAddress(map.get("Email"));
		
		frgtPswdStp1.clickSendVericationCode();
		
		boolean isDisplayed = verifyEmail.verifyEmailAddressPageIsDisplayed();
		
		softAssert.assertTrue(isDisplayed);
		
		softAssert.assertAll();
		
	}
	
	@Test(priority = 7, dataProvider = "fp15_20", description = "enter correct code and correct resent code")
	public void vrfyEmailAdrPageCrrctCodeAndResentCde_FP_15_20(HashMap<String, String> map, ITestContext ctx, ITestResult rlt) throws Exception {
		
		SoftAssert softAssert = new SoftAssert();
		
		String dateAndTime = new SimpleDateFormat("yyyyMMddhhmmss").format(new Date());
		
		String instance = map.get("InstanceId");
				
		ctx.getCurrentXmlTest().addParameter( "InstanceId", instance);
		
		ctx.getCurrentXmlTest().addParameter( "Date", dateAndTime);
				
		log.info("In vrfyEmailAdrPageCrrctCodeAndResentCde_FP_15_20  ->  data is  " + map);
		
		log.info("*********************Start of  test " +map.get("TestCaseId")+ " **************************");
		
		lgnPge.ClickOnForgotPasswordLink();
		
		frgtPswdStp1.enterEmailAddress(map.get("Email"));
		
		frgtPswdStp1.clickSendVericationCode();
		
		if (map.get("RESEND").contentEquals("YES")) {
			
			try {
				handlingMail = new HandlingMails(map.get("Email"), map.get("GmailPassword"), HandlingMails.EmailFolder.INBOX);
				log.info("Connection to email is successfull");
			    } catch (Exception e) {
			      e.printStackTrace();
			      Assert.fail(e.getMessage());
			    }
			
			boolean isEmailRecieved = handlingMail.isMessageInFolder(map.get("EmailSubject"), true);
			log.info("is Verification Email recieved : " +isEmailRecieved);
			
			verifyEmail.clickOnResendCode();
		}
		
		verifyEmail.enterVerificationCode(map);
		
		verifyEmail.clickOnVerifyCode();
		
		verifyEmail.verifyValidCodeResult(map.get("SuccessMessage"));
		
		boolean isDisplayed = verifyEmail.verifyContinueButtonIsDisplayed();
		
		softAssert.assertTrue(isDisplayed);
		
		softAssert.assertAll();
		
	}
	
	@Test(priority = 8, dataProvider = "fp16_21", description = "enter incorrect code and old resent code")
	public void vrfyEmailAdrPageIncrrctCdeAndResentCde_FP_16_21(HashMap<String, String> map, ITestContext ctx, ITestResult rlt) throws Exception {
				
		String dateAndTime = new SimpleDateFormat("yyyyMMddhhmmss").format(new Date());
		
		String instance = map.get("InstanceId");
				
		ctx.getCurrentXmlTest().addParameter( "InstanceId", instance);
		
		ctx.getCurrentXmlTest().addParameter( "Date", dateAndTime);
				
		log.info("In vrfyEmailAdrPageIncrrctCdeAndResentCde_FP_16_21  ->  data is  " + map);
		
		log.info("*********************Start of  test " +map.get("TestCaseId")+ " **************************");
		
		lgnPge.ClickOnForgotPasswordLink();
		
		frgtPswdStp1.enterEmailAddress(map.get("Email"));
		
		frgtPswdStp1.clickSendVericationCode();
		
		if (map.get("RESEND").contentEquals("YES")) {
			
			try {
				handlingMail = new HandlingMails(map.get("Email"), map.get("GmailPassword"), HandlingMails.EmailFolder.INBOX);
				log.info("Connection to email is successfull");
			    } catch (Exception e) {
			      e.printStackTrace();
			      Assert.fail(e.getMessage());
			    }
			
			String code = handlingMail.getCode();
			
			verifyEmail.clickOnResendCode();
			
			verifyEmail.enterInvalidCode(code);
		} 
		
		else {
			
			verifyEmail.enterInvalidCode("123A56");
		}
		
		verifyEmail.clickOnVerifyCode();
		
		verifyEmail.verifyEmailAddressPageIsDisplayed();
		
		verifyEmail.verifyInvalidCodeResult(map.get("ErrorMessage"));

	}
	
	@Test(priority = 9, dataProvider = "fp17", description = "repeated incorrect code")
	public void vrfyEmailAdrPageIncrrctCodeMultipleTimes_FP_17(HashMap<String, String> map, ITestContext ctx, ITestResult rlt) throws InterruptedException, AWTException, IOException {
		
		String dateAndTime = new SimpleDateFormat("yyyyMMddhhmmss").format(new Date());
		
		String instance = map.get("InstanceId");
				
		ctx.getCurrentXmlTest().addParameter( "InstanceId", instance);
		
		ctx.getCurrentXmlTest().addParameter( "Date", dateAndTime);
				
		log.info("In vrfyEmailAdrPageIncrrctCodeMultipleTimes_FP_17  ->  data is  " + map);
		
		log.info("*********************Start of  test " +map.get("TestCaseId")+ " **************************");
		
		lgnPge.ClickOnForgotPasswordLink();
		
		frgtPswdStp1.enterEmailAddress(map.get("Email"));
		
		frgtPswdStp1.clickSendVericationCode();
		
		verifyEmail.enterInvalidCode("123A56");
		
		verifyEmail.clickOnVerifyCode();
		
		verifyEmail.enterInvalidCode("123A56");
		
		verifyEmail.clickOnVerifyCode();
		
		verifyEmail.enterInvalidCode("123A56");
		
		verifyEmail.clickOnVerifyCode();
		
		verifyEmail.verifyInvalidCodeResult(map.get("ErrorMessage"));
		
	}
	
	@Test(priority = 10, dataProvider = "fp19", description = "resend code")
	public void vrfyEmailAdrPageResendCode_FP_19(HashMap<String, String> map, ITestContext ctx, ITestResult rlt) throws InterruptedException, AWTException, IOException {
		
		SoftAssert softAssert = new SoftAssert();
		
		String dateAndTime = new SimpleDateFormat("yyyyMMddhhmmss").format(new Date());
		
		String instance = map.get("InstanceId");
				
		ctx.getCurrentXmlTest().addParameter( "InstanceId", instance);
		
		ctx.getCurrentXmlTest().addParameter( "Date", dateAndTime);
				
		log.info("In vrfyEmailAdrPageResendCode_FP_19  ->  data is  " + map);
		
		log.info("*********************Start of  test " +map.get("TestCaseId")+ " **************************");
		
		lgnPge.ClickOnForgotPasswordLink();
		
		frgtPswdStp1.enterEmailAddress(map.get("Email"));
		
		frgtPswdStp1.clickSendVericationCode();
		
		verifyEmail.clickOnResendCode();
		
		verifyEmail.verifyEmailAddressPageIsDisplayed();
		
		verifyEmail.verifyResendSuccessMessage(map.get("SuccessMessage"));
		
	}
	
	@Test(priority = 11, dataProvider = "fp22", description = "Forgot Password Use Different Email Address")
	public void vrfyEmailAdrPageUseDiffEmail_FP_22(HashMap<String, String> map, ITestContext ctx, ITestResult rlt) throws InterruptedException, AWTException, IOException {
		
		SoftAssert softAssert = new SoftAssert();
		
		String dateAndTime = new SimpleDateFormat("yyyyMMddhhmmss").format(new Date());
		
		String instance = map.get("InstanceId");
				
		ctx.getCurrentXmlTest().addParameter( "InstanceId", instance);
		
		ctx.getCurrentXmlTest().addParameter( "Date", dateAndTime);
				
		log.info("In vrfyEmailAdrPageUseDiffEmail_FP_22  ->  data is  " + map);
		
		log.info("*********************Start of  test " +map.get("TestCaseId")+ " **************************");
		
		lgnPge.ClickOnForgotPasswordLink();
		
		frgtPswdStp1.enterEmailAddress(map.get("Email"));
		
		frgtPswdStp1.clickSendVericationCode();
		
		verifyEmail.clickOnUseDifferentEmail();
		
		frgtPswdStp1.verifyForgotPasswordPageIsDisplayed();
		
		boolean isPgeDisplayed = frgtPswdStp1.verifyForgotPasswordPageIsDisplayed();
		
		softAssert.assertTrue(isPgeDisplayed);		

	}
	
	@Test(priority = 12, dataProvider = "fp23", description = "edit email and send code")
	public void editEmailAndSendCode_FP_23(HashMap<String, String> map, ITestContext ctx, ITestResult rlt) throws Exception {
		
		SoftAssert softAssert = new SoftAssert();
		
		String dateAndTime = new SimpleDateFormat("yyyyMMddhhmmss").format(new Date());
		
		String instance = map.get("InstanceId");
				
		ctx.getCurrentXmlTest().addParameter( "InstanceId", instance);
		
		ctx.getCurrentXmlTest().addParameter( "Date", dateAndTime);
				
		log.info("In editEmailAndSendCode_FP_23  ->  data is  " + map);
		
		log.info("*********************Start of  test " +map.get("TestCaseId")+ " **************************");
		
		lgnPge.ClickOnForgotPasswordLink();
		
		frgtPswdStp1.enterEmailAddress(map.get("Email"));
		
		frgtPswdStp1.clickSendVericationCode();
		
		verifyEmail.clickOnUseDifferentEmail();
		
		frgtPswdStp1.verifyForgotPasswordPageIsDisplayed();
		
		boolean isPgeDisplayed = frgtPswdStp1.verifyForgotPasswordPageIsDisplayed();
		softAssert.assertTrue(isPgeDisplayed);
		
		frgtPswdStp1.editEmailAddress(map.get("AlternateEmail"));
		
		frgtPswdStp1.clickSendVericationCode();
		
		try {
			handlingMail = new HandlingMails(map.get("AlternateEmail"), map.get("GmailPassword"), HandlingMails.EmailFolder.INBOX);
			log.info("Connection to email is successfull");
		    } catch (Exception e) {
		      e.printStackTrace();
		      Assert.fail(e.getMessage());
		    }
		

		
		String code = handlingMail.getCode();

		verifyEmail.enterInvalidCode(code);
		log.info("Specified the verification code as: " +code);
		
		verifyEmail.clickOnVerifyCode();
		
		verifyEmail.verifyValidCodeResult(map.get("SuccessMessage"));
		
	}
	
	@Test(priority = 13, dataProvider = "fp24", description = "Continue after successful verification")
	public void emailVerifiedContinue_FP_24(HashMap<String, String> map, ITestContext ctx, ITestResult rlt) throws Exception {
		
		SoftAssert softAssert = new SoftAssert();
		
		String dateAndTime = new SimpleDateFormat("yyyyMMddhhmmss").format(new Date());
		
		String instance = map.get("InstanceId");
				
		ctx.getCurrentXmlTest().addParameter( "InstanceId", instance);
		
		ctx.getCurrentXmlTest().addParameter( "Date", dateAndTime);
				
		log.info("In emailVerifiedContinue_FP_24  ->  data is  " + map);
		
		log.info("*********************Start of  test " +map.get("TestCaseId")+ " **************************");
		
		lgnPge.ClickOnForgotPasswordLink();
		
		frgtPswdStp1.enterEmailAddress(map.get("Email"));
		
		frgtPswdStp1.clickSendVericationCode();
				
		verifyEmail.enterVerificationCode(map);
		
		verifyEmail.clickOnVerifyCode();
		
		verifyEmail.clickOnContinue();
		
		boolean isDisplayed = frgtPswdStp2.verifyForgotPasswordStep2IsDisplayed();
		softAssert.assertTrue(isDisplayed);
		
		boolean isPasswordFieldDisplayed = frgtPswdStp2.verifyPasswordField();
		softAssert.assertTrue(isPasswordFieldDisplayed);
		
		boolean isConfirmPswrdBtnDisplayed = frgtPswdStp2.verifyConfirmPasswordField();
		softAssert.assertTrue(isConfirmPswrdBtnDisplayed);
		
		boolean isCancelBtnDisplayed = frgtPswdStp2.verifyCancelButton();
		softAssert.assertTrue(isCancelBtnDisplayed);
		
		boolean isChngePswdBtnDisplayed = frgtPswdStp2.verifyChangePasswordBtn();
		softAssert.assertTrue(isChngePswdBtnDisplayed);
		
		softAssert.assertAll();
		
	}
	
	@Test(priority = 14, dataProvider = "fp25_26_27", description = "Failed attempts to create new password")
	public void createPasswordFailure_FP_25_26_27(HashMap<String, String> map, ITestContext ctx, ITestResult rlt) throws Exception {
		
		SoftAssert softAssert = new SoftAssert();
		
		String dateAndTime = new SimpleDateFormat("yyyyMMddhhmmss").format(new Date());
		
		String instance = map.get("InstanceId");
				
		ctx.getCurrentXmlTest().addParameter( "InstanceId", instance);
		
		ctx.getCurrentXmlTest().addParameter( "Date", dateAndTime);
				
		log.info("In createPasswordFailure_FP_25_26_27  ->  data is  " + map);
		
		log.info("*********************Start of  test " +map.get("TestCaseId")+ " **************************");
		
		lgnPge.ClickOnForgotPasswordLink();
		
		frgtPswdStp1.enterEmailAddress(map.get("Email"));
		
		frgtPswdStp1.clickSendVericationCode();
				
		verifyEmail.enterVerificationCode(map);
		
		verifyEmail.clickOnVerifyCode();
		
		verifyEmail.clickOnContinue();
		
		if (map.get("Password").contentEquals("BLANK")) {
			
		} else {
			frgtPswdStp2.enterPasswordAndConfirmPassword(map.get("Password"), map.get("ConfirmPassword"));
		}
		
		frgtPswdStp2.clickChangePswd();
		
		
		if (map.get("TestCaseId").contains("25") || map.get("TestCaseId").contains("26")) {
			String Error = frgtPswdStp2.verifyPasswordChangeErrors();
			log.info("The expected error message is: " +map.get("ErrorMessage"));
			softAssert.assertEquals(Error, map.get("ErrorMessage"), "Actual error message is different from expected error message");
		}
		
		if (map.get("TestCaseId").contains("26") || map.get("TestCaseId").contains("27")) {
			String MainError = frgtPswdStp2.getMainError();
			log.info("The expected error message is: " +map.get("MainError"));
			softAssert.assertEquals(MainError, map.get("MainError"), "Actual error message is different from expected error message");
		}
		
		softAssert.assertAll();
		
	}
	
	@Test(priority = 15, dataProvider = "fp28_29", description = "successfull attempt to create password")
	public void createPasswordSuccess_FP_28_29(HashMap<String, String> map, ITestContext ctx, ITestResult rlt) throws Exception {
		
		SoftAssert softAssert = new SoftAssert();
		
		String dateAndTime = new SimpleDateFormat("yyyyMMddhhmmss").format(new Date());
		
		String instance = map.get("InstanceId");
						
		ctx.getCurrentXmlTest().addParameter( "InstanceId", instance);
		
		ctx.getCurrentXmlTest().addParameter( "Date", dateAndTime);
				
		log.info("In createPasswordSuccess_FP_28_29  ->  data is  " + map);
		
		log.info("*********************Start of  test " +map.get("TestCaseId")+ " **************************");
		
		lgnPge.ClickOnForgotPasswordLink();
		
		frgtPswdStp1.enterEmailAddress(map.get("Email"));
		
		frgtPswdStp1.clickSendVericationCode();
				
		verifyEmail.enterVerificationCode(map);
		
		verifyEmail.clickOnVerifyCode();
		
		verifyEmail.clickOnContinue();
		
		frgtPswdStp2.enterPasswordAndConfirmPassword(map.get("Password"), map.get("ConfirmPassword"));

		frgtPswdStp2.clickChangePswd();
		
		frgtPswdStp2.verifySuccessfullPasswordChange(map.get("SuccessMessage"));
		
		boolean isDisplayed = frgtPswdStp2.verifyFinishButton();
		
		softAssert.assertTrue(isDisplayed);
		
		softAssert.assertAll();
		

	}
	
	@Test(priority = 16, dataProvider = "fp32", description = "clicking finish after successfull password change")
	public void finish_FP_32(HashMap<String, String> map, ITestContext ctx, ITestResult rlt) throws Exception {
		
		SoftAssert softAssert = new SoftAssert();
		
		String dateAndTime = new SimpleDateFormat("yyyyMMddhhmmss").format(new Date());
		
		String instance = map.get("InstanceId");
				
		ctx.getCurrentXmlTest().addParameter( "InstanceId", instance);
		
		ctx.getCurrentXmlTest().addParameter( "Date", dateAndTime);
				
		log.info("In finish_FP_32  ->  data is  " + map);
		
		log.info("*********************Start of  test " +map.get("TestCaseId")+ " **************************");
		
		lgnPge.ClickOnForgotPasswordLink();
		
		frgtPswdStp1.enterEmailAddress(map.get("Email"));
		
		frgtPswdStp1.clickSendVericationCode();
				
		verifyEmail.enterVerificationCode(map);
		
		verifyEmail.clickOnVerifyCode();
		
		verifyEmail.clickOnContinue();
		
		frgtPswdStp2.enterPasswordAndConfirmPassword(map.get("Password"), map.get("ConfirmPassword"));

		frgtPswdStp2.clickChangePswd();
		
		frgtPswdStp2.clickOnFinish();
		
		boolean isDisplayed = lgnPge.verifyLoginScreenIsDisplayed();
		
		softAssert.assertTrue(isDisplayed);
		
		softAssert.assertAll();
		
	}
	  

	@AfterMethod
	public void tearDown(ITestContext ctx, ITestResult rlt) throws Exception {
		  
		String instance = ctx.getCurrentXmlTest().getParameter("InstanceId");
		String date = ctx.getCurrentXmlTest().getParameter("Date");
		String testName = rlt.getMethod().getMethodName();
		String failureReason = "";
		String screenShot = testName + "_" + date + ".png";
		int result = 3;
			
		if (rlt.getStatus() == ITestResult.SUCCESS)
		{
			result = 0;
			PractiTest.runWithAttachments(instance, result, screenShot, failureReason);	
		} 
		  
		else if (rlt.getStatus() == ITestResult.FAILURE)
		{
			failureReason = rlt.getThrowable().toString();
			log.info(failureReason);
			result = 1;
			PractiTest.runWithAttachments(instance, result, screenShot, failureReason);
		}
		  
		else if (rlt.getStatus() == ITestResult.SKIP)
		{
			result = 2;
		}
		//Closing the browser
		driver.close();
		  
	}
}
