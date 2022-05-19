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
import com.wac.cwp.pages.LoginPage;
import com.wac.cwp.pages.RegistrationPageStep1;
import com.wac.cwp.pages.VerifyYourEmailAddressPage;
import com.wac.cwp.util.GetTestData;
import com.wac.cwp.util.HandlingMails;
import com.wac.cwp.util.PractiTest;

public class RegistrationTestCases extends TestBase {
	
	LoginPage lgnPge;
	VerifyYourEmailAddressPage verifyEmail;
	HandlingMails handlingMail;
	RegistrationPageStep1 regPgeStp1;
	String loginSheet = "LoginPage";
 
	
	public RegistrationTestCases() {
		super();
	}
	
	@BeforeMethod
	public void setUp() {
		
		initialization();
		lgnPge = new LoginPage();
		regPgeStp1 = new RegistrationPageStep1();
		verifyEmail = new VerifyYourEmailAddressPage();

	}
	
	@DataProvider
	public Object[] rt33() {
		List<HashMap<String, String>> data = GetTestData.getTestData2("Registration", "registrationPageStep1_RT_33");
		return data.toArray(); 
	}
	  
	@DataProvider
	public Object[] rt34_40_47_48() {
		List<HashMap<String, String>> data = GetTestData.getTestData2("Registration", "successfulCompletionOfStp1Reg_RT_34_40_47_48");
		return data.toArray(); 
	}
	
	@DataProvider
	public Object[] rt35_36_37_38_39_46() {
		List<HashMap<String, String>> data = GetTestData.getTestData2("Registration", "regStep1Error_RT_35_36_37_38_39_46");
		return data.toArray(); 
	}
	
	@DataProvider
	public Object[] rt43() {
		List<HashMap<String, String>> data = GetTestData.getTestData2("Registration", "clickPrivacyLinkInRegStep1Pge_RT_43");
		return data.toArray(); 
	}
	
	@DataProvider
	public Object[] rt44() {
		List<HashMap<String, String>> data = GetTestData.getTestData2("Registration", "clickTermsLinkInRegStep1Pge_RT_44");
		return data.toArray(); 
	}
	
	@DataProvider
	public Object[] rt45() {
		List<HashMap<String, String>> data = GetTestData.getTestData2("Registration", "clickLogInLinkInRegStep1Pge_RT_45");
		return data.toArray(); 
	}
	
	@DataProvider
	public Object[] rt322() {
		List<HashMap<String, String>> data = GetTestData.getTestData2("Registration", "verfyEmlAddSendCdePge_SendCodeEditingEmailToInvalidEmail_RT_322");
		return data.toArray(); 
	}
	
	@DataProvider
	public Object[] rt49() {
		List<HashMap<String, String>> data = GetTestData.getTestData2("Registration", "verifyEmailAddressPageAfterSendingCode_RT_49");
		return data.toArray(); 
	}
	
	@DataProvider
	public Object[] rt51() {
		List<HashMap<String, String>> data = GetTestData.getTestData2("Registration", "enterIncorrectCodeInVerifyEmailAddPge_RT_51");
		return data.toArray(); 
	}
	
	@DataProvider
	public Object[] rt52() {
		List<HashMap<String, String>> data = GetTestData.getTestData2("Registration", "enterIncrrctCodeMultipleTimesInVerfyEmlAddPge_RT_52");
		return data.toArray(); 
	}
	
	@Test(priority = 1, dataProvider = "rt33", description = "Registration page step 1")
	public void registrationPageStep1_RT_33(HashMap<String, String> map, ITestContext ctx, ITestResult rlt) throws InterruptedException, AWTException, IOException {
		
		SoftAssert softAssert = new SoftAssert();
		
		String dateAndTime = new SimpleDateFormat("yyyyMMddhhmmss").format(new Date());
		
		String instance = map.get("InstanceId");
				
		ctx.getCurrentXmlTest().addParameter( "InstanceId", instance);
		
		ctx.getCurrentXmlTest().addParameter( "Date", dateAndTime);
				
		log.info("In registrationPageStep1_rt33  ->  data is  " + map);
		
		log.info("*********************Start of  test " +map.get("TestCaseId")+ " **************************");
		
		lgnPge.clickOnSignUp();
		
		boolean isDisplayed = regPgeStp1.verifySignUpPageIsDisplayed();
		softAssert.assertTrue(isDisplayed);
		
		boolean isEmailDisplayed = regPgeStp1.verifySignUpPageHasEmailAddrField();
		softAssert.assertTrue(isEmailDisplayed);
		
		boolean isPasswordDisplayed = regPgeStp1.verifySignUpPageHasPasswordField();
		softAssert.assertTrue(isPasswordDisplayed);
		
		boolean isConfPswdDisplayed = regPgeStp1.verifySignUpPageHasConfPasswordField();
		softAssert.assertTrue(isConfPswdDisplayed);
		
		boolean isCreateAccDisplayed = regPgeStp1.verifySignUpPageHasCreateAccountButton();
		softAssert.assertTrue(isCreateAccDisplayed);
		
		boolean isTermsChckBxDisplayed = regPgeStp1.verifySignUpPageHasTermsCheckbox();
		softAssert.assertTrue(isTermsChckBxDisplayed);
		
		boolean isPrmtnChckBxDisplayed = regPgeStp1.verifySignUpPageHasPromotionCheckbox();
		softAssert.assertTrue(isPrmtnChckBxDisplayed);
		
		boolean isLoginLinkDisplayed = regPgeStp1.verifySignUpPageHasLoginLink();
		softAssert.assertTrue(isLoginLinkDisplayed);
		
		softAssert.assertAll();
		
	}
	  

	@Test(priority = 2, dataProvider = "rt34_40_47_48", description = "Successfull completion of Step 1 Registration")
	public void successfulCompletionOfStp1Reg_RT_34_40_47_48(HashMap<String, String> map, ITestContext ctx, ITestResult rlt) throws InterruptedException, AWTException, IOException {
		
		SoftAssert softAssert = new SoftAssert();
		
		String dateAndTime = new SimpleDateFormat("yyyyMMddhhmmss").format(new Date());
		
		String instance = map.get("InstanceId");
				
		ctx.getCurrentXmlTest().addParameter( "InstanceId", instance);
		
		ctx.getCurrentXmlTest().addParameter( "Date", dateAndTime);
				
		log.info("In successfulCompletionOfStp1Reg_RT_34_40_47_48  ->  data is  " + map);
		
		log.info("*********************Start of  test " +map.get("TestCaseId")+ " **************************");
		
		lgnPge.clickOnSignUp();
		
		regPgeStp1.fillUpSignUpFormInStep1(map);
		
		boolean isVerifyPagedisplayed = verifyEmail.verifyEmailAddressPageIsDisplayed();
		softAssert.assertTrue(isVerifyPagedisplayed);
		
		boolean isSendCodeButtonDisplayed = verifyEmail.verifySendCodeButtonIsDisplayed();
		softAssert.assertTrue(isSendCodeButtonDisplayed);

	}
	
	
	@Test(priority = 3, dataProvider = "rt35_36_37_38_39_46", description = "Failed step 1 of registration")
	public void regStep1Error_RT_35_36_37_38_39_46(HashMap<String, String> map, ITestContext ctx, ITestResult rlt) throws Exception {
		
		SoftAssert softAssert = new SoftAssert();
		
		String dateAndTime = new SimpleDateFormat("yyyyMMddhhmmss").format(new Date());
		
		String instance = map.get("InstanceId");
				
		ctx.getCurrentXmlTest().addParameter( "InstanceId", instance);
		
		ctx.getCurrentXmlTest().addParameter( "Date", dateAndTime);
				
		log.info("In regStep1Error_RT_35_36_37_38_39_46  ->  data is  " + map);
		
		log.info("*********************Start of  test " +map.get("TestCaseId")+ " **************************");
		
		lgnPge.clickOnSignUp();
		
		regPgeStp1.fillUpSignUpFormInStep1(map);
		
		if (map.get("TestCaseId").contentEquals("35") || map.get("TestCaseId").contentEquals("37") ||map.get("TestCaseId").contentEquals("38") || map.get("TestCaseId").contentEquals("46") ) {
			String  FieldError  = regPgeStp1.getErrorMsgbelowFields();
			log.info("The actual error messages below fields are: " +FieldError);
			log.info("The expected error messages below fields are: " +map.get("FieldErrorMessage"));
			softAssert.assertEquals(FieldError, map.get("FieldErrorMessage"), "Actual error message is different from expected error message");	
			}

		if (map.get("TestCaseId").contentEquals("36") || map.get("TestCaseId").contentEquals("37") ||map.get("TestCaseId").contentEquals("38") || map.get("TestCaseId").contentEquals("39") ) {
			String topError = regPgeStp1.getErrorMsgAtTop();
			log.info("The actual error messages at the top is: " +topError);
			log.info("The expected error messages at the top is: " +map.get("TopErrorMessage"));
			softAssert.assertEquals(topError, map.get("TopErrorMessage"), "Actual error message is different from expected error message");	
		}
		
		softAssert.assertAll();
		

	}
	
	@Test(priority = 4, dataProvider = "rt43", description = "click Privacy Link")
	public void clickPrivacyLinkInRegStep1Pge_RT_43(HashMap<String, String> map, ITestContext ctx, ITestResult rlt) throws InterruptedException, AWTException, IOException {
		
		SoftAssert softAssert = new SoftAssert();
		
		String dateAndTime = new SimpleDateFormat("yyyyMMddhhmmss").format(new Date());
		
		String instance = map.get("InstanceId");
				
		ctx.getCurrentXmlTest().addParameter( "InstanceId", instance);
		
		ctx.getCurrentXmlTest().addParameter( "Date", dateAndTime);
				
		log.info("In clickPrivacyLinkInRegStep1Pge_RT_43  ->  data is  " + map);
		
		log.info("*********************Start of  test " +map.get("TestCaseId")+ " **************************");
		
		lgnPge.clickOnSignUp();
		
		regPgeStp1.clickPrivayPolicyLink();
		
		regPgeStp1.verifyTheURLOpenedInNewTab(map.get("URL"));

	}
	
	@Test(priority = 5, dataProvider = "rt44", description = "Click Terms Link")
	public void clickTermsLinkInRegStep1Pge_RT_44(HashMap<String, String> map, ITestContext ctx, ITestResult rlt) throws InterruptedException, AWTException, IOException {
		
		SoftAssert softAssert = new SoftAssert();
		
		String dateAndTime = new SimpleDateFormat("yyyyMMddhhmmss").format(new Date());
		
		String instance = map.get("InstanceId");
				
		ctx.getCurrentXmlTest().addParameter( "InstanceId", instance);
		
		ctx.getCurrentXmlTest().addParameter( "Date", dateAndTime);
				
		log.info("In clickTermsLinkInRegStep1Pge_RT_44  ->  data is  " + map);
		
		log.info("*********************Start of  test " +map.get("TestCaseId")+ " **************************");
		
		lgnPge.clickOnSignUp();
		
		regPgeStp1.clickTermsOfServiceLink();
		
		regPgeStp1.verifyTheURLOpenedInNewTab(map.get("URL"));

	}
	
	@Test(priority = 6, dataProvider = "rt45", description = "click on login link")
	public void clickLogInLinkInRegStep1Pge_RT_45(HashMap<String, String> map, ITestContext ctx, ITestResult rlt) throws InterruptedException, AWTException, IOException {
		
		SoftAssert softAssert = new SoftAssert();
		
		String dateAndTime = new SimpleDateFormat("yyyyMMddhhmmss").format(new Date());
		
		String instance = map.get("InstanceId");
				
		ctx.getCurrentXmlTest().addParameter( "InstanceId", instance);
		
		ctx.getCurrentXmlTest().addParameter( "Date", dateAndTime);
				
		log.info("In clickLogInLinkInRegStep1Pge_RT_45  ->  data is  " + map);
		
		log.info("*********************Start of  test " +map.get("TestCaseId")+ " **************************");
		
		lgnPge.clickOnSignUp();
		
		regPgeStp1.clickSignin();
		
		boolean isDisplayed  = lgnPge.verifyLoginScreenIsDisplayed();
		
		softAssert.assertTrue(isDisplayed);
		
		softAssert.assertAll();
	}
	
	
	@Test(priority = 7, dataProvider = "rt322", description = "In Verify Email Address Page - Send Code after editing to invalid email")
	public void verfyEmlAddSendCdePge_SendCodeEditingEmailToInalidEmail_RT_322(HashMap<String, String> map, ITestContext ctx, ITestResult rlt) throws InterruptedException, AWTException, IOException {
		
		SoftAssert softAssert = new SoftAssert();
		
		String dateAndTime = new SimpleDateFormat("yyyyMMddhhmmss").format(new Date());
		
		String instance = map.get("InstanceId");
				
		ctx.getCurrentXmlTest().addParameter( "InstanceId", instance);
		
		ctx.getCurrentXmlTest().addParameter( "Date", dateAndTime);
				
		log.info("In enterIncrrctCodeMultipleTimesInVerfyEmlAddPge_RT_52  ->  data is  " + map);
		
		log.info("*********************Start of  test " +map.get("TestCaseId")+ " **************************");
		
		lgnPge.clickOnSignUp();
		
		regPgeStp1.fillUpSignUpFormInStep1(map);
		
		verifyEmail.editEmail(map.get("EditEmail"));
		
		verifyEmail.clickOnSendCode();
		
		String  FieldError  = verifyEmail.getInvalidEmailError();
		
		log.info("The actual error messages below fields are: " +FieldError);
		
		log.info("The expected error messages below fields are: " +map.get("FieldErrorMessage"));
		
		softAssert.assertEquals(FieldError, map.get("FieldErrorMessage"), "Actual error message is different from expected error message");	
		
		softAssert.assertAll();
		
	}
	
	@Test(priority = 8, dataProvider = "rt49", description = "Verify Email Address Page after sending code")
	public void verifyEmailAddressPageAfterSendingCode_RT_49(HashMap<String, String> map, ITestContext ctx, ITestResult rlt) throws Exception {
		
		SoftAssert softAssert = new SoftAssert();
		
		String dateAndTime = new SimpleDateFormat("yyyyMMddhhmmss").format(new Date());
		
		String instance = map.get("InstanceId");
				
		ctx.getCurrentXmlTest().addParameter( "InstanceId", instance);
		
		ctx.getCurrentXmlTest().addParameter( "Date", dateAndTime);
				
		log.info("In verifyEmailAddressPageAfterSendingCode_RT_49  ->  data is  " + map);
		
		log.info("*********************Start of  test " +map.get("TestCaseId")+ " **************************");
		
		lgnPge.clickOnSignUp();
		
		String email = regPgeStp1.fillUpSignUpFormInStep1(map);
				
		verifyEmail.clickOnSendCode();
		
		boolean isDisplayed = verifyEmail.verifyEmailAddressPageIsDisplayed();
		softAssert.assertTrue(isDisplayed);
		
		boolean isMessageCorrect = verifyEmail.verifyMessageAtTopOfVerifyEmailPage(email);
		softAssert.assertTrue(isMessageCorrect);
		
		boolean isVerificationCodeFieldDisplayed = verifyEmail.verifyThatVerifyEmailPageHasVerificationCodeField();
		softAssert.assertTrue(isVerificationCodeFieldDisplayed);
		
		boolean isVerifyCodeBtnDisplayed =  verifyEmail.verifyVerifyCodeButtonIsDisplayed();
		softAssert.assertTrue(isVerifyCodeBtnDisplayed);
		
		boolean isResendCodeBtnDisplayed =  verifyEmail.verifyResendCodeButtonIsDisplayed();
		softAssert.assertTrue(isResendCodeBtnDisplayed);
		
		boolean isUseDiffEmailLinkDisplayed =  verifyEmail.verifyDiffEmailLinkIsDisplayed();
		softAssert.assertTrue(isUseDiffEmailLinkDisplayed);
		
		softAssert.assertAll();

		
	}
	
	@Test(priority = 9, dataProvider = "rt51", description = "enter incorrect code in verify email address page")
	public void enterIncorrectCodeInVerifyEmailAddPge_RT_51(HashMap<String, String> map, ITestContext ctx, ITestResult rlt) throws Exception {
				
		String dateAndTime = new SimpleDateFormat("yyyyMMddhhmmss").format(new Date());
		
		String instance = map.get("InstanceId");
				
		ctx.getCurrentXmlTest().addParameter( "InstanceId", instance);
		
		ctx.getCurrentXmlTest().addParameter( "Date", dateAndTime);
				
		log.info("In enterIncorrectCodeInVerifyEmailAddPge_RT_51  ->  data is  " + map);
		
		log.info("*********************Start of  test " +map.get("TestCaseId")+ " **************************");
		
		lgnPge.clickOnSignUp();
		
		regPgeStp1.fillUpSignUpFormInStep1(map);
				
		verifyEmail.clickOnSendCode();
		
		verifyEmail.enterInvalidCode("123456");
		
		verifyEmail.clickOnVerifyCode();
		
		verifyEmail.verifyInvalidCodeResult(map.get("FieldErrorMessage"));


	}
	
	@Test(priority = 10, dataProvider = "rt52", description = "repeated incorrect code in verify email address page")
	public void enterIncrrctCodeMultipleTimesInVerfyEmlAddPge_RT_52(HashMap<String, String> map, ITestContext ctx, ITestResult rlt) throws InterruptedException, AWTException, IOException {
		
		String dateAndTime = new SimpleDateFormat("yyyyMMddhhmmss").format(new Date());
		
		String instance = map.get("InstanceId");
				
		ctx.getCurrentXmlTest().addParameter( "InstanceId", instance);
		
		ctx.getCurrentXmlTest().addParameter( "Date", dateAndTime);
				
		log.info("In enterIncrrctCodeMultipleTimesInVerfyEmlAddPge_RT_52  ->  data is  " + map);
		
		log.info("*********************Start of  test " +map.get("TestCaseId")+ " **************************");
		
		lgnPge.clickOnSignUp();
		
		regPgeStp1.fillUpSignUpFormInStep1(map);
				
		verifyEmail.clickOnSendCode();
		
		verifyEmail.enterInvalidCode("123456");
		
		verifyEmail.clickOnVerifyCode();
		
		verifyEmail.enterInvalidCode("123456");
		
		verifyEmail.clickOnVerifyCode();
		
		verifyEmail.enterInvalidCode("123456");
		
		verifyEmail.clickOnVerifyCode();
		
		verifyEmail.verifyInvalidCodeResult(map.get("FieldErrorMessage"));

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
