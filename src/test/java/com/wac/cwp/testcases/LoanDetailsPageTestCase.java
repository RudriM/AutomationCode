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
import com.wac.cwp.pages.LoanDetailsPage;
import com.wac.cwp.pages.LoginPage;
import com.wac.cwp.util.GetTestData;
import com.wac.cwp.util.PractiTest;

public class LoanDetailsPageTestCase extends TestBase {
	LoginPage lgnPge;
	LoanDetailsPage  loanDetailsPge;
	
	public LoanDetailsPageTestCase() {
		super();
	}
	
	@BeforeMethod
	public void setUp() {
		
		initialization();
		lgnPge = new LoginPage();
		loanDetailsPge = new LoanDetailsPage();
	}

	@DataProvider
	public Object[] apt139() {
		List<HashMap<String, String>> data = GetTestData.getTestData2("LoanDetailsPage", "verifyLoanNumber_APT_139");
		return data.toArray(); 
	}
	
	@DataProvider
	public Object[] apt140() {
		List<HashMap<String, String>> data = GetTestData.getTestData2("LoanDetailsPage", "verifyPaymentDueCardDetails_APT_140");
		return data.toArray(); 
	}
	
	@DataProvider
	public Object[] apt141() {
		List<HashMap<String, String>> data = GetTestData.getTestData2("LoanDetailsPage", "verifyLoanDetailsCard_APT_141");
		return data.toArray(); 
	}
	
	@DataProvider
	public Object[] apt142() {
		List<HashMap<String, String>> data = GetTestData.getTestData2("LoanDetailsPage", "verifyPaymentHistory_APT_142");
		return data.toArray(); 
	}
	
	@DataProvider
	public Object[] apt143() {
		List<HashMap<String, String>> data = GetTestData.getTestData2("LoanDetailsPage", "verifyPaymentAmount_143");
		return data.toArray();
	}
	
	@DataProvider
	public Object[] apt145() {
		List<HashMap<String, String>> data = GetTestData.getTestData2("LoanDetailsPage", "verifyManageRecurringPayments_APT_145");
		return data.toArray(); 
	}
	
	@DataProvider
	public Object[] apt148() {
		List<HashMap<String, String>> data = GetTestData.getTestData2("LoanDetailsPage", "verifyStopRecurringPopUp_APT_148");
		return data.toArray(); 
	}
	
	@DataProvider
	public Object[] apt144() {
		List<HashMap<String, String>> data = GetTestData.getTestData2("LoanDetailsPage", "verifySetUpRecurring_144_147");
		return data.toArray(); 
	}
	
	@DataProvider
	public Object[] apt146() {
		List<HashMap<String, String>> data = GetTestData.getTestData2("LoanDetailsPage", "verifyRecurringInfo_146");
		return data.toArray(); 
	}

	@DataProvider
	public Object[] apt_149_150() {
		List<HashMap<String, String>> data = GetTestData.getTestData2("LoanDetailsPage", "verifyToolkitMessage_149_150");
		return data.toArray(); 
	}
	
	@Test(priority = 1, dataProvider = "apt139", description = "Verify Loan number at the top")
	public void verifyLoanNumber_APT_139(HashMap<String, String> map, ITestContext ctx, ITestResult rlt) throws InterruptedException, AWTException, IOException {
		
		SoftAssert softAssert = new SoftAssert();
		
		String dateAndTime = new SimpleDateFormat("yyyyMMddhhmmss").format(new Date());
		
		String instance = map.get("InstanceId");
				
		ctx.getCurrentXmlTest().addParameter( "InstanceId", instance);
		
		ctx.getCurrentXmlTest().addParameter( "Date", dateAndTime);
				
		log.info("In verifyLoanNumber_APT_139  ->  data is  " + map);
		
		log.info("*********************Start of  test " +map.get("TestCaseId")+ " **************************");

		lgnPge.login(map.get("Email"), map.get("Password"));
		
		loanDetailsPge.clickViewDetailsLink();
		boolean isDisplayed = loanDetailsPge.isDisplayedLoanNumber();
		
		log.info("Is Loan number is display?: " +isDisplayed);
		softAssert.assertAll();
	}
	
	@Test(priority = 2, dataProvider = "apt140", description = "Verify Payment Due Card details")
	public void verifyPaymentDueCardDetails_APT_140(HashMap<String, String> map, ITestContext ctx, ITestResult rlt) throws InterruptedException, AWTException, IOException {
		SoftAssert softAssert = new SoftAssert();
		
		String dateAndTime = new SimpleDateFormat("yyyyMMddhhmmss").format(new Date());
		
		String instance = map.get("InstanceId");
	
		ctx.getCurrentXmlTest().addParameter( "InstanceId", instance);
		
		ctx.getCurrentXmlTest().addParameter( "Date", dateAndTime);
				
		log.info("In verifyPaymentDueCardDetails_APT_140  ->  data is  " + map);
		
		log.info("*********************Start of  test " +map.get("TestCaseId")+ " **************************");

		lgnPge.login(map.get("Email"), map.get("Password"));
				
		loanDetailsPge.clickViewDetailsLink();

		if(map.get("DueDatePassed").contentEquals("Yes")) {
			loanDetailsPge.isDisplayedPaymentCardToolkit();
			loanDetailsPge.verifyPaymentDueCardDetailsForDueDatePassed(map);
		}
		else {
			loanDetailsPge.verifyPaymentDueCardDetailsForDueDateNotPassed(map);
		}
		softAssert.assertAll();
	}
	
	@Test(priority = 3, dataProvider = "apt141",description = "Verify Loan Details Card")
	public void verifyLoanDetailsCard_APT_141(HashMap<String, String> map, ITestContext ctx, ITestResult rlt) throws InterruptedException, AWTException, IOException {
		
		SoftAssert softAssert = new SoftAssert();
		
		String dateAndTime = new SimpleDateFormat("yyyyMMddhhmmss").format(new Date());
		
		String instance = map.get("InstanceId");
				
		ctx.getCurrentXmlTest().addParameter( "InstanceId", instance);
		
		ctx.getCurrentXmlTest().addParameter( "Date", dateAndTime);
				
		log.info("In verifyLoanDetailsCard_APT_141  ->  data is  " + map);
		
		log.info("*********************Start of  test " +map.get("TestCaseId")+ " **************************");

		lgnPge.login(map.get("Email"), map.get("Password"));
		
		loanDetailsPge.clickViewDetailsLink();
		
		loanDetailsPge.verifyLoanDetailsCard(map);
	}
	
	@Test(priority = 4, dataProvider = "apt142", description = "Verify Payment History Section")
	public void verifyPaymentHistory_APT_142(HashMap<String, String> map, ITestContext ctx, ITestResult rlt) throws InterruptedException, AWTException, IOException {
		
		SoftAssert softAssert = new SoftAssert();
		
		String dateAndTime = new SimpleDateFormat("yyyyMMddhhmmss").format(new Date());
		
		String instance = map.get("InstanceId");
				
		ctx.getCurrentXmlTest().addParameter( "InstanceId", instance);
		
		ctx.getCurrentXmlTest().addParameter( "Date", dateAndTime);
				
		log.info("In verifyPaymentHistory_APT_142  ->  data is  " + map);
		
		log.info("*********************Start of  test " +map.get("TestCaseId")+ " **************************");

		lgnPge.login(map.get("Email"), map.get("Password"));
		
		loanDetailsPge.clickViewDetailsLink();
		boolean isPaymentHistorySectionDisplayed = loanDetailsPge.isDisplayedPaymentHistorySection();
		softAssert.assertTrue(isPaymentHistorySectionDisplayed);
		
		boolean IsViewAllLinkDisplayed = loanDetailsPge.verifyViewAllLinkIsDisplayed();
//		softAssert.assertTrue(IsViewAllLinkDisplayed);
		
		loanDetailsPge.verifyPayementHistoryDetails(map);
		loanDetailsPge.clickViewAll();
		softAssert.assertAll();
	}

	@Test(priority = 5, dataProvider = "apt143", description = "Successfully make a payment")
	public void verifyPaymentAmount_143(HashMap<String, String> map, ITestContext ctx, ITestResult rlt) throws InterruptedException, AWTException, IOException 
	{
		SoftAssert softAssert = new SoftAssert();
		
		String dateAndTime = new SimpleDateFormat("yyyyMMddhhmmss").format(new Date());
		
		String instance = map.get("InstanceId");
				
		ctx.getCurrentXmlTest().addParameter( "InstanceId", instance);
		
		ctx.getCurrentXmlTest().addParameter( "Date", dateAndTime);
				
		log.info("In  verifyPaymentAmount_143  ->  data is  " + map);
		
		log.info("*********************Start of  test " +map.get("TestCaseId")+ " **************************");
		
		lgnPge.login(map.get("Email"), map.get("Password"));
		
		loanDetailsPge.clickViewDetailsLink();
		loanDetailsPge.makePayment(map);
		softAssert.assertAll();
	}
	
	
	@Test(priority = 6, dataProvider = "apt145", description = "Verify Manage Recurring button")
	public void verifyManageRecurringPayments_APT_145(HashMap<String, String> map, ITestContext ctx, ITestResult rlt) throws InterruptedException, AWTException, IOException {
		SoftAssert softAssert = new SoftAssert();
		
		String dateAndTime = new SimpleDateFormat("yyyyMMddhhmmss").format(new Date());
		
		String instance = map.get("InstanceId");
				
		ctx.getCurrentXmlTest().addParameter( "InstanceId", instance);
		
		ctx.getCurrentXmlTest().addParameter( "Date", dateAndTime);
				
		log.info("In verifyManageRecurringPayments_APT_145  ->  data is  " + map);
		
		log.info("*********************Start of  test " +map.get("TestCaseId")+ " **************************");

		lgnPge.login(map.get("Email"), map.get("Password"));
		
		loanDetailsPge.clickViewDetailsLink();
		
		if(map.get("RecurringPaymentSetUp").contentEquals("Yes")) {
			
			loanDetailsPge.isDisplayedPaymentDueDetailsCard();
			loanDetailsPge.verifyManageRecurringButton(map);
		}
		else {
			loanDetailsPge.isDisplayedSetUpRecurringButton();
		}
		softAssert.assertAll();
	}
	@Test(priority = 7, dataProvider = "apt148", description = "Verify Stop Recurring button")
	public void verifyStopRecurringPopUp_APT_148(HashMap<String, String> map, ITestContext ctx, ITestResult rlt) throws InterruptedException, AWTException, IOException {
		SoftAssert softAssert = new SoftAssert();
		
		String dateAndTime = new SimpleDateFormat("yyyyMMddhhmmss").format(new Date());
		
		String instance = map.get("InstanceId");
				
		ctx.getCurrentXmlTest().addParameter( "InstanceId", instance);
		
		ctx.getCurrentXmlTest().addParameter( "Date", dateAndTime);
				
		log.info("In verifyStopRecurringPopUp_APT_148  ->  data is  " + map);
		
		log.info("*********************Start of  test " +map.get("TestCaseId")+ " **************************");

		lgnPge.login(map.get("Email"), map.get("Password"));
		
		loanDetailsPge.clickViewDetailsLink();
		loanDetailsPge.verifyStopRecurringPopUp(map);
		softAssert.assertAll();
	}
	
	@Test(priority =8 , dataProvider = "apt144", description = "Verify Set Recurring")
	public void verifySetUpRecurring_144_147(HashMap<String, String> map, ITestContext ctx, ITestResult rlt) throws InterruptedException, AWTException, IOException {
		SoftAssert softAssert = new SoftAssert();
		
		String dateAndTime = new SimpleDateFormat("yyyyMMddhhmmss").format(new Date());
		
		String instance = map.get("InstanceId");
				
		ctx.getCurrentXmlTest().addParameter( "InstanceId", instance);
		
		ctx.getCurrentXmlTest().addParameter( "Date", dateAndTime);
				
		log.info("In verifySetUpRecurring_144_147  ->  data is  " + map);
		
		log.info("*********************Start of  test " +map.get("TestCaseId")+ " **************************");

		lgnPge.login(map.get("Email"), map.get("Password"));
		
		loanDetailsPge.clickViewDetailsLink();
		loanDetailsPge.setUpRecurring(map);
		softAssert.assertAll();
	}

	@Test(priority = 10 , dataProvider = "apt_149_150", description = "Verify Set Recurring")
	public void verifyToolkitMessage_149_150(HashMap<String, String> map, ITestContext ctx, ITestResult rlt) throws InterruptedException, AWTException, IOException {
		SoftAssert softAssert = new SoftAssert();
		
		String dateAndTime = new SimpleDateFormat("yyyyMMddhhmmss").format(new Date());
		
		String instance = map.get("InstanceId");
				
		ctx.getCurrentXmlTest().addParameter( "InstanceId", instance);
		
		ctx.getCurrentXmlTest().addParameter( "Date", dateAndTime);
				
		log.info("In verifyManageRecurringPayments_APT_149_150  ->  data is  " + map);
		
		log.info("*********************Start of  test " +map.get("TestCaseId")+ " **************************");

		lgnPge.login(map.get("Email"), map.get("Password"));
		loanDetailsPge.isDisplayedLoanDataToolkit();
		loanDetailsPge.isDisplayedPaymentCardToolkit();
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
