package com.wac.cwp.testcases;
import java.awt.AWTException;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.List;

import org.testng.ITestContext;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import com.wac.cwp.base.TestBase;
import com.wac.cwp.pages.AccountsPage;
import com.wac.cwp.pages.LoginPage;
import com.wac.cwp.pages.MakePaymentPage;
import com.wac.cwp.util.GetTestData;
import com.wac.cwp.util.PractiTest;


public class MakePaymentTestCases extends TestBase{

	LoginPage lgnPge;
	MakePaymentPage  paymentPage;
	
	public MakePaymentTestCases() {
		super();
	}
	
	@BeforeMethod
	public void setUp() {
		
		initialization();
		
		lgnPge = new LoginPage();
		paymentPage = new MakePaymentPage();
	}
	  
	@DataProvider
	public Object[] apt_225() {
		List<HashMap<String, String>> data = GetTestData.getTestData2("MakePayment", "verifySavedBankAcountDetail_APT_225");
		return data.toArray(); 
	}
	
	@DataProvider
	public Object[] apt_226() {
		List<HashMap<String, String>> data = GetTestData.getTestData2("MakePayment", "verifySavedkDebitPayment_APT_226_342");		
		return data.toArray(); 
	}
	
	@DataProvider
	public Object[] apt_227() {
		List<HashMap<String, String>> data = GetTestData.getTestData2("MakePayment", "verifyNotSavedDebitPayment_APT_227");		
		return data.toArray(); 
	}
	
	@DataProvider
	public Object[] apt_228() {
		List<HashMap<String, String>> data = GetTestData.getTestData2("MakePayment", "verifyNotSavedBankPayment_APT_228");		
		return data.toArray(); 
	}
	
	@DataProvider
	public Object[] apt_371() {
		List<HashMap<String, String>> data = GetTestData.getTestData2("MakePayment", "verifySavedBankPayment_APT_371");		
		return data.toArray(); 
	}
	
	@DataProvider
	public Object[] apt_373_372() {
		List<HashMap<String, String>> data = GetTestData.getTestData2("MakePayment", "verifyLinkedBankAccount_APT_373_372");		
		return data.toArray(); 
	}
	
	@DataProvider
	public Object[] apt_328_329_330_333() {
		List<HashMap<String, String>> data = GetTestData.getTestData2("MakePayment", "verifySCKYUserLoan_APT_328_329_330_333");		
		return data.toArray(); 
	}
	
	@DataProvider
	public Object[] apt_331() {
		List<HashMap<String, String>> data = GetTestData.getTestData2("MakePayment", "verifyFeePaymentAsBankAccountMethod_APT_331");		
		return data.toArray(); 
	}
	
	@DataProvider
	public Object[] apt_335() {
		List<HashMap<String, String>> data = GetTestData.getTestData2("MakePayment", "verifyPastPaymentDate_APT_335");		
		return data.toArray(); 
	}
	
	@DataProvider
	public Object[] apt_336_337() {
		List<HashMap<String, String>> data = GetTestData.getTestData2("MakePayment", "verifyPaymentDateAfterLoanDate_APT_336_337");		
		return data.toArray(); 
	}
	
	@DataProvider
	public Object[] apt_338_339() {
		List<HashMap<String, String>> data = GetTestData.getTestData2("MakePayment", "verifyRewiewPageWarningMsg_APT_338_339");		
		return data.toArray(); 
	}
	
	@DataProvider
	public Object[] apt_348() {
		List<HashMap<String, String>> data = GetTestData.getTestData2("MakePayment", "verifyPopupClocsed_APT_348");		
		return data.toArray(); 
	}
	
	@DataProvider
	public Object[] apt_349() {
		List<HashMap<String, String>> data = GetTestData.getTestData2("MakePayment", "verifyClickOnContinue_APT_349");		
		return data.toArray(); 
	}
	
	@DataProvider
	public Object[] apt_350() {
		List<HashMap<String, String>> data = GetTestData.getTestData2("MakePayment", "verifyReviewPopUPInfoWithDebitCard_APT_350_351");		
		return data.toArray(); 
	}
	
	@DataProvider
	public Object[] apt_352_353() {
		List<HashMap<String, String>> data = GetTestData.getTestData2("MakePayment", "verifyReviewPopUPInfoWithDebitCard_APT_352_353");		
		return data.toArray(); 
	}
	
	@DataProvider
	public Object[] apt_354() {
		List<HashMap<String, String>> data = GetTestData.getTestData2("MakePayment", "verifyNoticeInfo_APT_354");		
		return data.toArray(); 
	}
	
	@DataProvider
	public Object[] apt_355() {
		List<HashMap<String, String>> data = GetTestData.getTestData2("MakePayment", "verifyNoticeBankInfo_APT_355");		
		return data.toArray(); 
	}
	
	@DataProvider
	public Object[] apt_356() {
		List<HashMap<String, String>> data = GetTestData.getTestData2("MakePayment", "verifyPaymentPostingInfo_APT_356");		
		return data.toArray(); 
	}
	
	@DataProvider
	public Object[] apt_357() {
		List<HashMap<String, String>> data = GetTestData.getTestData2("MakePayment", "verifyClickonCancel_357");		
		return data.toArray(); 
	}
	
	@DataProvider
	public Object[] apt_358() {
		List<HashMap<String, String>> data = GetTestData.getTestData2("MakePayment", "verifyTotalAmountOnPayButton_358");		
		return data.toArray(); 
	}
	
	@DataProvider
	public Object[] apt_359() {
		List<HashMap<String, String>> data = GetTestData.getTestData2("MakePayment", "verifySubmitPayment_APT_359");		
		return data.toArray(); 
	}
	
	@DataProvider
	public Object[] apt_343_344() {
		List<HashMap<String, String>> data = GetTestData.getTestData2("MakePayment", "verifyPartialPaymentWarningMsg_APT_343_344");		
		return data.toArray(); 
	}
	
	@DataProvider
	public Object[] apt_360_361_362_363_365() {
		List<HashMap<String, String>> data = GetTestData.getTestData2("MakePayment", "verifyReceiptPopUp_Debit_APT_360_361_362_363_365");		
		return data.toArray(); 
	}
	
	@DataProvider
	public Object[] apt_248() {
		List<HashMap<String, String>> data = GetTestData.getTestData2("MakePayment", "verifyReceiptPopUp_Bank_248");		
		return data.toArray(); 
	}
	
	
	@Test(priority = 1, dataProvider = "apt_225", description = "Make Payment pop up: select payment method saved Bank account details.")
	public void verifySavedBankAcountDetail_APT_225(HashMap<String, String> map, ITestContext ctx, ITestResult rlt) throws InterruptedException, AWTException, IOException {
		
		SoftAssert softAssert = new SoftAssert();
		
		String dateAndTime = new SimpleDateFormat("yyyyMMddhhmmss").format(new Date());
		
		String instance = map.get("InstanceId");
				
		ctx.getCurrentXmlTest().addParameter( "InstanceId", instance);
		
		ctx.getCurrentXmlTest().addParameter( "Date", dateAndTime);
				
		log.info("In verifySavedBankAcountDetail_APT_225  ->  data is  " + map);
		
		log.info("*********************Start of  test " +map.get("TestCaseId")+ " **************************");

		lgnPge.login(map.get("Email"), map.get("Password"));
	
		paymentPage.verifyMakePaymentSavedAsBank(map);
		softAssert.assertAll();

	}
	
	@Test(priority = 2, dataProvider = "apt_226", description = "Make Payment pop up: select payment method saved debit card details.")
	public void verifySavedkDebitPayment_APT_226_342(HashMap<String, String> map, ITestContext ctx, ITestResult rlt) throws InterruptedException, AWTException, IOException {
		
		SoftAssert softAssert = new SoftAssert();
		
		String dateAndTime = new SimpleDateFormat("yyyyMMddhhmmss").format(new Date());
		
		String instance = map.get("InstanceId");
				
		ctx.getCurrentXmlTest().addParameter( "InstanceId", instance);
		
		ctx.getCurrentXmlTest().addParameter( "Date", dateAndTime);
				
		log.info("In verifySavedkDebitPayment_APT_226_342  ->  data is  " + map);
		
		log.info("*********************Start of  test " +map.get("TestCaseId")+ " **************************");
		
		lgnPge.login(map.get("Email"), map.get("Password"));
		
		paymentPage.verifyMakePaymentSavedAsDebit(map);
		softAssert.assertAll();
	}
	
	@Test(priority = 3, dataProvider = "apt_227", description = "Verify make payment for not saved debit card")
	public void verifyNotSavedDebitPayment_APT_227(HashMap<String, String> map, ITestContext ctx, ITestResult rlt) throws InterruptedException, AWTException, IOException {
		
		SoftAssert softAssert = new SoftAssert();
		
		String dateAndTime = new SimpleDateFormat("yyyyMMddhhmmss").format(new Date());
		
		String instance = map.get("InstanceId");
				
		ctx.getCurrentXmlTest().addParameter( "InstanceId", instance);
		
		ctx.getCurrentXmlTest().addParameter( "Date", dateAndTime);
				
		log.info("In verifyNotSavedDebitPayment_APT_227  ->  data is  " + map);
		
		log.info("*********************Start of  test " +map.get("TestCaseId")+ " **************************");
		
		lgnPge.login(map.get("Email"), map.get("Password"));
		
		paymentPage.verifyMakePaymentNotSavedAsDebit(map);
		softAssert.assertAll();

	}
	
	@Test(priority = 4, dataProvider = "apt_228", description = "Verify make payment for not saved Bank account")
	public void verifyNotSavedBankPayment_APT_228(HashMap<String, String> map, ITestContext ctx, ITestResult rlt) throws InterruptedException, AWTException, IOException {
		
		SoftAssert softAssert = new SoftAssert();
		
		String dateAndTime = new SimpleDateFormat("yyyyMMddhhmmss").format(new Date());
		
		String instance = map.get("InstanceId");
				
		ctx.getCurrentXmlTest().addParameter( "InstanceId", instance);
		
		ctx.getCurrentXmlTest().addParameter( "Date", dateAndTime);
				
		log.info("In verifyNotSavedBankPayment_APT_228  ->  data is  " + map);
		
		log.info("*********************Start of  test " +map.get("TestCaseId")+ " **************************");
		
		lgnPge.login(map.get("Email"), map.get("Password"));
		
		paymentPage.verifyMakePaymentNotSavedBankAccount(map);
		softAssert.assertAll();

	}
	
	@Test(priority = 5, dataProvider = "apt_371", description = "Verify select Debit Card option for user who has saved another card already")
	public void verifySavedBankPayment_APT_371(HashMap<String, String> map, ITestContext ctx, ITestResult rlt) throws InterruptedException, AWTException, IOException {
		
		SoftAssert softAssert = new SoftAssert();
		
		String dateAndTime = new SimpleDateFormat("yyyyMMddhhmmss").format(new Date());
		
		String instance = map.get("InstanceId");
				
		ctx.getCurrentXmlTest().addParameter( "InstanceId", instance);
		
		ctx.getCurrentXmlTest().addParameter( "Date", dateAndTime);
				
		log.info("In verifySavedBankPayment_APT_371  ->  data is  " + map);
		
		log.info("*********************Start of  test " +map.get("TestCaseId")+ " **************************");
		
		lgnPge.login(map.get("Email"), map.get("Password"));
		
		paymentPage.verifyMakePaymentSavedBankAccount(map);
		softAssert.assertAll();

	}
	@Test(priority = 6, dataProvider = "apt_373_372", description = "Verify Linked bank account number")
	public void verifyLinkedBankAccount_APT_373_372(HashMap<String, String> map, ITestContext ctx, ITestResult rlt) throws InterruptedException, AWTException, IOException {
		
		SoftAssert softAssert = new SoftAssert();
		
		String dateAndTime = new SimpleDateFormat("yyyyMMddhhmmss").format(new Date());
		
		String instance = map.get("InstanceId");
				
		ctx.getCurrentXmlTest().addParameter( "InstanceId", instance);
		
		ctx.getCurrentXmlTest().addParameter( "Date", dateAndTime);
				
		log.info("In verifyLinkedBankAccount_APT_373  ->  data is  " + map);
		
		log.info("*********************Start of  test " +map.get("TestCaseId")+ " **************************");
		
		lgnPge.login(map.get("Email"), map.get("Password"));
		
		paymentPage.verifyMakePaymentlinkedBankAccount(map);
		paymentPage.isDisplayedMakePaymentToolkit();
		softAssert.assertAll();
	}
	
	@Test(priority = 7, dataProvider = "apt_328_329_330_333", description = "Verify E-complish fee")
	public void verifySCKYUserLoan_APT_328_329_330_333(HashMap<String, String> map, ITestContext ctx, ITestResult rlt) throws InterruptedException, AWTException, IOException {
		
		SoftAssert softAssert = new SoftAssert();
		
		String dateAndTime = new SimpleDateFormat("yyyyMMddhhmmss").format(new Date());
		
		String instance = map.get("InstanceId");
				
		ctx.getCurrentXmlTest().addParameter( "InstanceId", instance);
		
		ctx.getCurrentXmlTest().addParameter( "Date", dateAndTime);
				
		log.info("In verifySCKYUserLoan_APT_328_329_330_333  ->  data is  " + map);
		
		log.info("*********************Start of  test " +map.get("TestCaseId")+ " **************************");
		
		lgnPge.login(map.get("Email"), map.get("Password"));
		
		if(map.get("UserFrom").equals("MO")){
			paymentPage.verifyNonSCKYUser(map);
		}else if(map.get("UserFrom").equals("KY")) {
			paymentPage.verifyKYSCUser(map);
		}else if(map.get("UserFrom").equals("SC")){
			paymentPage.verifyKYSCUser(map);
		}
		softAssert.assertAll();
	}
	
	@Test(priority = 8, dataProvider = "apt_331", description = "Verify E-complish fee when Bank account method is selected")
	public void verifyFeePaymentAsBankAccountMethod_APT_331(HashMap<String, String> map, ITestContext ctx, ITestResult rlt) throws InterruptedException, AWTException, IOException {
		
		SoftAssert softAssert = new SoftAssert();
		
		String dateAndTime = new SimpleDateFormat("yyyyMMddhhmmss").format(new Date());
		
		String instance = map.get("InstanceId");
				
		ctx.getCurrentXmlTest().addParameter( "InstanceId", instance);
		
		ctx.getCurrentXmlTest().addParameter( "Date", dateAndTime);
				
		log.info("In verifyFeePaymentAsBankAccountMethod_APT_331  ->  data is  " + map);
		
		log.info("*********************Start of  test " +map.get("TestCaseId")+ " **************************");
		
		lgnPge.login(map.get("Email"), map.get("Password"));
		
		paymentPage.makeAPaymentAsBankAccount(map);
		softAssert.assertAll();

	}
	
	@Test(priority = 9, dataProvider = "apt_335", description = "Verify error message when user enter past date manually")
	public void verifyPastPaymentDate_APT_335(HashMap<String, String> map, ITestContext ctx, ITestResult rlt) throws InterruptedException, AWTException, IOException {
		
		SoftAssert softAssert = new SoftAssert();
		
		String dateAndTime = new SimpleDateFormat("yyyyMMddhhmmss").format(new Date());
		
		String instance = map.get("InstanceId");
				
		ctx.getCurrentXmlTest().addParameter( "InstanceId", instance);
		
		ctx.getCurrentXmlTest().addParameter( "Date", dateAndTime);
				
		log.info("In verifyPastPaymentDate_APT_335  ->  data is  " + map);
		
		log.info("*********************Start of  test " +map.get("TestCaseId")+ " **************************");
		
		lgnPge.login(map.get("Email"), map.get("Password"));
		
		paymentPage.verifyPastPaymentDate(map);
		softAssert.assertAll();
	
	}
	
	@Test(priority = 10, dataProvider = "apt_336_337", description = "Verify Warning message when user select a payment date as a date which after loan due date ")
	public void verifyPaymentDateAfterLoanDate_APT_336_337(HashMap<String, String> map, ITestContext ctx, ITestResult rlt) throws InterruptedException, AWTException, IOException {
		
		SoftAssert softAssert = new SoftAssert();
		
		String dateAndTime = new SimpleDateFormat("yyyyMMddhhmmss").format(new Date());
		
		String instance = map.get("InstanceId");
				
		ctx.getCurrentXmlTest().addParameter( "InstanceId", instance);
		
		ctx.getCurrentXmlTest().addParameter( "Date", dateAndTime);
				
		log.info("In verifyPaymentDateAfterLoanDate_APT_336_337 ->  data is  " + map);
		
		log.info("*********************Start of  test " +map.get("TestCaseId")+ " **************************");
		
		lgnPge.login(map.get("Email"), map.get("Password"));
		
		paymentPage.verifyWarningMsgPayDateAfterLoanDate(map);
		softAssert.assertAll();
			
	}
	
	@Test(priority = 11, dataProvider = "apt_338_339", description = "Verify Warning message when user enter select a payment date as a date which after loan due date ")
	public void verifyRewiewPageWarningMsg_APT_338_339(HashMap<String, String> map, ITestContext ctx, ITestResult rlt) throws InterruptedException, AWTException, IOException {
		
		SoftAssert softAssert = new SoftAssert();
		
		String dateAndTime = new SimpleDateFormat("yyyyMMddhhmmss").format(new Date());
		
		String instance = map.get("InstanceId");
				
		ctx.getCurrentXmlTest().addParameter( "InstanceId", instance);
		
		ctx.getCurrentXmlTest().addParameter( "Date", dateAndTime);
				
		log.info("In verifyRewiewPageWarningMsg_APT_338_339 ->  data is  " + map);
		
		log.info("*********************Start of  test " +map.get("TestCaseId")+ " **************************");
		
		lgnPge.login(map.get("Email"), map.get("Password"));
		
		paymentPage.paymentReviewPageWarningMessage(map);
		softAssert.assertAll();
	}
	
	@Test(priority = 12, dataProvider = "apt_348", description = "Make a payment pop up is closed after clicking on cancel button")
	public void verifyPopupClocsed_APT_348(HashMap<String, String> map, ITestContext ctx, ITestResult rlt) throws InterruptedException, AWTException, IOException {
		
		SoftAssert softAssert = new SoftAssert();
		
		String dateAndTime = new SimpleDateFormat("yyyyMMddhhmmss").format(new Date());
		
		String instance = map.get("InstanceId");
				
		ctx.getCurrentXmlTest().addParameter( "InstanceId", instance);
		
		ctx.getCurrentXmlTest().addParameter( "Date", dateAndTime);
				
		log.info("In verifyRewiewPageWarningMsg_APT_348 ->  data is  " + map);
		
		log.info("*********************Start of  test " +map.get("TestCaseId")+ " **************************");
		
		lgnPge.login(map.get("Email"), map.get("Password"));
		
		paymentPage.verifyPopUpclickOnCancel(map);
		softAssert.assertAll();
	}
	
	@Test(priority = 13, dataProvider = "apt_349", description = "Navigate to Review page after clicking on continue button")
	public void verifyClickOnContinue_APT_349(HashMap<String, String> map, ITestContext ctx, ITestResult rlt) throws InterruptedException, AWTException, IOException {
		
		SoftAssert softAssert = new SoftAssert();
		
		String dateAndTime = new SimpleDateFormat("yyyyMMddhhmmss").format(new Date());
		
		String instance = map.get("InstanceId");
				
		ctx.getCurrentXmlTest().addParameter( "InstanceId", instance);
		
		ctx.getCurrentXmlTest().addParameter( "Date", dateAndTime);
				
		log.info("In verifyClickOnContinue_APT_349 ->  data is  " + map);
		
		log.info("*********************Start of  test " +map.get("TestCaseId")+ " **************************");
		
		lgnPge.login(map.get("Email"), map.get("Password"));
		
		paymentPage.verifyPopUpclickOnContinue(map);
		softAssert.assertAll();
	}
	
	@Test(priority = 14, dataProvider = "apt_350", description = "Verify review pop up information when user select Debit card")
	public void verifyReviewPopUPInfoWithDebitCard_APT_350_351(HashMap<String, String> map, ITestContext ctx, ITestResult rlt) throws InterruptedException, AWTException, IOException {
		
		SoftAssert softAssert = new SoftAssert();
		
		String dateAndTime = new SimpleDateFormat("yyyyMMddhhmmss").format(new Date());
		
		String instance = map.get("InstanceId");
				
		ctx.getCurrentXmlTest().addParameter( "InstanceId", instance);
		
		ctx.getCurrentXmlTest().addParameter( "Date", dateAndTime);
				
		log.info("In verifyRewiewPageWarningMsg_APT_350 ->  data is  " + map);
		
		log.info("*********************Start of  test " +map.get("TestCaseId")+ " **************************");
		
		lgnPge.login(map.get("Email"), map.get("Password"));
		if(map.get("PaymentMethod").equals("Debit")) {
			paymentPage.verifyReviewPopUPInfoWithDebitCard(map);
		}else if(map.get("PaymentMethod").equals("Bank")){
			paymentPage.verifyReviewPopUPInfoWithBankInfo(map);
		}
		softAssert.assertAll();
	}
	
	@Test(priority = 15, dataProvider = "apt_352_353", description = "Verify payment Autorization information when user select Debit card")
	public void verifyReviewPopUPInfoWithDebitCard_APT_352_353(HashMap<String, String> map, ITestContext ctx, ITestResult rlt) throws InterruptedException, AWTException, IOException {
		
		SoftAssert softAssert = new SoftAssert();
		
		String dateAndTime = new SimpleDateFormat("yyyyMMddhhmmss").format(new Date());
		
		String instance = map.get("InstanceId");
				
		ctx.getCurrentXmlTest().addParameter( "InstanceId", instance);
		
		ctx.getCurrentXmlTest().addParameter( "Date", dateAndTime);
				
		log.info("In verifyReviewPopUPInfoWithDebitCard_APT_352_353 ->  data is  " + map);
		
		log.info("*********************Start of  test " +map.get("TestCaseId")+ " **************************");
		
		lgnPge.login(map.get("Email"), map.get("Password"));
		
		if(map.get("PaymentMethod").equals("Debit")) {
			paymentPage.verifyPaymentAuthInfo(map);
		}else if (map.get("PaymentMethod").equals("Bank")) {
			paymentPage.verifyPaymentAuthInfoWithBank(map);
		}
		softAssert.assertAll();
	}
	
	@Test(priority = 16, dataProvider = "apt_354", description = "Verifying E-notice information")
	public void verifyNoticeInfo_APT_354(HashMap<String, String> map, ITestContext ctx, ITestResult rlt) throws InterruptedException, AWTException, IOException {
		
		SoftAssert softAssert = new SoftAssert();
		
		String dateAndTime = new SimpleDateFormat("yyyyMMddhhmmss").format(new Date());
		
		String instance = map.get("InstanceId");
				
		ctx.getCurrentXmlTest().addParameter( "InstanceId", instance);
		
		ctx.getCurrentXmlTest().addParameter( "Date", dateAndTime);
				
		log.info("In verifyNoticeInfo_APT_354  ->  data is  " + map);
		
		log.info("*********************Start of  test " +map.get("TestCaseId")+ " **************************");
		
		lgnPge.login(map.get("Email"), map.get("Password"));
		
		paymentPage.verifyNoticeInfo(map);
		softAssert.assertAll();	
		}
	
	@Test(priority = 17, dataProvider = "apt_355", description = "Verifying E-Notice information with Bank payment")
	public void verifyNoticeBankInfo_APT_355(HashMap<String, String> map, ITestContext ctx, ITestResult rlt) throws InterruptedException, AWTException, IOException {
		
		SoftAssert softAssert = new SoftAssert();
		
		String dateAndTime = new SimpleDateFormat("yyyyMMddhhmmss").format(new Date());
		
		String instance = map.get("InstanceId");
				
		ctx.getCurrentXmlTest().addParameter( "InstanceId", instance);
		
		ctx.getCurrentXmlTest().addParameter( "Date", dateAndTime);
				
		log.info("In verifyNoticeBankInfo_APT_355  ->  data is  " + map);
		
		log.info("*********************Start of  test " +map.get("TestCaseId")+ " **************************");
		
		lgnPge.login(map.get("Email"), map.get("Password"));
		
		paymentPage.verifyNoticeInfoBank(map);
		softAssert.assertAll();	
	
	}
	
	@Test(priority = 18, dataProvider = "apt_356", description = "Verifying payment posting information")
	public void verifyPaymentPostingInfo_APT_356(HashMap<String, String> map, ITestContext ctx, ITestResult rlt) throws InterruptedException, AWTException, IOException {
		
		SoftAssert softAssert = new SoftAssert();
		
		String dateAndTime = new SimpleDateFormat("yyyyMMddhhmmss").format(new Date());
		
		String instance = map.get("InstanceId");
				
		ctx.getCurrentXmlTest().addParameter( "InstanceId", instance);
		
		ctx.getCurrentXmlTest().addParameter( "Date", dateAndTime);
				
		log.info("In verifyPaymentPostingInfo_APT_356  ->  data is  " + map);
		
		log.info("*********************Start of  test " +map.get("TestCaseId")+ " **************************");
		
		lgnPge.login(map.get("Email"), map.get("Password"));
		
		paymentPage.verifyPaymentPostingInfo(map);
		softAssert.assertAll();	
	}
	
	@Test(priority = 19, dataProvider = "apt_357", description = "Verifying Click on cancel button")
	public void verifyClickonCancel_357(HashMap<String, String> map, ITestContext ctx, ITestResult rlt) throws InterruptedException, AWTException, IOException {
		
		SoftAssert softAssert = new SoftAssert();
		
		String dateAndTime = new SimpleDateFormat("yyyyMMddhhmmss").format(new Date());
		
		String instance = map.get("InstanceId");
				
		ctx.getCurrentXmlTest().addParameter( "InstanceId", instance);
		
		ctx.getCurrentXmlTest().addParameter( "Date", dateAndTime);
				
		log.info("In verifyClickonCancel_357  ->  data is  " + map);
		
		log.info("*********************Start of  test " +map.get("TestCaseId")+ " **************************");
		
		lgnPge.login(map.get("Email"), map.get("Password"));
		
		paymentPage.verifyCancelButton(map);
		softAssert.assertAll();	
	}
	

	@Test(priority = 20, dataProvider = "apt_358", description = "Verifying amount on Pay button")
	public void verifyTotalAmountOnPayButton_358(HashMap<String, String> map, ITestContext ctx, ITestResult rlt) throws InterruptedException, AWTException, IOException {
		
		SoftAssert softAssert = new SoftAssert();
		
		String dateAndTime = new SimpleDateFormat("yyyyMMddhhmmss").format(new Date());
		
		String instance = map.get("InstanceId");
				
		ctx.getCurrentXmlTest().addParameter( "InstanceId", instance);
		
		ctx.getCurrentXmlTest().addParameter( "Date", dateAndTime);
				
		log.info("In verifyTotalAmountOnPayButton_358  ->  data is  " + map);
		
		log.info("*********************Start of  test " +map.get("TestCaseId")+ " **************************");
		
		lgnPge.login(map.get("Email"), map.get("Password"));
		
		paymentPage.verifyPyamentAmount(map);
		softAssert.assertAll();	
	}
	
	@Test(priority = 21, dataProvider = "apt_359", description = "Verifying submit payment")
	public void verifySubmitPayment_APT_359(HashMap<String, String> map, ITestContext ctx, ITestResult rlt) throws InterruptedException, AWTException, IOException {
		
		SoftAssert softAssert = new SoftAssert();
		
		String dateAndTime = new SimpleDateFormat("yyyyMMddhhmmss").format(new Date());
		
		String instance = map.get("InstanceId");
				
		ctx.getCurrentXmlTest().addParameter( "InstanceId", instance);
		
		ctx.getCurrentXmlTest().addParameter( "Date", dateAndTime);
				
		log.info("In verifySubmitPayment_APT_359  ->  data is  " + map);
		
		log.info("*********************Start of  test " +map.get("TestCaseId")+ " **************************");
		
		lgnPge.login(map.get("Email"), map.get("Password"));
		
		paymentPage.verifySubmitPayment(map);
		
		softAssert.assertAll();	
	}
	
	@Test(priority = 22, dataProvider = "apt_343_344", description = "Verify partial payment warning message")
	public void verifyPartialPaymentWarningMsg_APT_343_344(HashMap<String, String> map, ITestContext ctx, ITestResult rlt) throws InterruptedException, AWTException, IOException {
		
		SoftAssert softAssert = new SoftAssert();
		
		String dateAndTime = new SimpleDateFormat("yyyyMMddhhmmss").format(new Date());
		
		String instance = map.get("InstanceId");
				
		ctx.getCurrentXmlTest().addParameter( "InstanceId", instance);
		
		ctx.getCurrentXmlTest().addParameter( "Date", dateAndTime);
				
		log.info("In verifyPartialPaymentWarningMsg_APT_343_344  ->  data is  " + map);
		
		log.info("*********************Start of  test " +map.get("TestCaseId")+ " **************************");
		
		lgnPge.login(map.get("Email"), map.get("Password"));
		
		paymentPage.verifyPartialPaymentWarningMsg(map);
		
		softAssert.assertAll();	
	}
	

	@Test(priority = 23, dataProvider = "apt_360_361_362_363_365", description = "Verify receipt pop up ")
	public void verifyReceiptPopUp_Debit_APT_360_361_362_363_365(HashMap<String, String> map, ITestContext ctx, ITestResult rlt) throws InterruptedException, AWTException, IOException {
		
		SoftAssert softAssert = new SoftAssert();
		
		String dateAndTime = new SimpleDateFormat("yyyyMMddhhmmss").format(new Date());
		
		String instance = map.get("InstanceId");
				
		ctx.getCurrentXmlTest().addParameter( "InstanceId", instance);
		
		ctx.getCurrentXmlTest().addParameter( "Date", dateAndTime);
				
		log.info("In verifyPartialPaymentWarningMsg_APT_343_344  ->  data is  " + map);
		
		log.info("*********************Start of  test " +map.get("TestCaseId")+ " **************************");
		
		lgnPge.login(map.get("Email"), map.get("Password"));
		
		paymentPage.verifyReceiptModal(map);
		
		softAssert.assertAll();	
	}
	
	@Test(priority = 24, dataProvider = "apt_248", description = "Verify receipt pop up - payment by Bank")
	public void verifyReceiptPopUp_Bank_248(HashMap<String, String> map, ITestContext ctx, ITestResult rlt) throws InterruptedException, AWTException, IOException {
		
		SoftAssert softAssert = new SoftAssert();
		
		String dateAndTime = new SimpleDateFormat("yyyyMMddhhmmss").format(new Date());
		
		String instance = map.get("InstanceId");
				
		ctx.getCurrentXmlTest().addParameter( "InstanceId", instance);
		
		ctx.getCurrentXmlTest().addParameter( "Date", dateAndTime);
				
		log.info("In verifyReceiptPopUp_Bank_248  ->  data is  " + map);
		
		log.info("*********************Start of  test " +map.get("TestCaseId")+ " **************************");
		
		lgnPge.login(map.get("Email"), map.get("Password"));
		
		paymentPage.verifyReceiptPopUPInfoWithBankInfo(map);
		
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
