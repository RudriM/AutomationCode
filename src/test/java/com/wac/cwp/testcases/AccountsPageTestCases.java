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
import com.wac.cwp.util.GetTestData;
import com.wac.cwp.util.PractiTest;

public class AccountsPageTestCases extends TestBase{
	
	
	LoginPage lgnPge;
	AccountsPage  acctPge;
	
	public AccountsPageTestCases() {
		super();
	}
	
	@BeforeMethod
	public void setUp() {
		
		initialization();
		
		lgnPge = new LoginPage();
		acctPge = new AccountsPage();
	}
	  
	@DataProvider
	public Object[] apt119() {
		List<HashMap<String, String>> data = GetTestData.getTestData2("AccountsPage", "verifyAccountLinkAtTop_APT_119");
		return data.toArray(); 
	}
	
	@DataProvider
	public Object[] apt120() {
		List<HashMap<String, String>> data = GetTestData.getTestData2("AccountsPage", "verifyWelcomeMsgInAccountsPage_APT_120");
		return data.toArray(); 
	}
	
	@DataProvider
	public Object[] apt121_122_367() {
		List<HashMap<String, String>> data = GetTestData.getTestData2("AccountsPage", "verifyAccountSummaryCard_APT_121_122_367");
		return data.toArray(); 
	}
	
	@DataProvider
	public Object[] apt123_124_368() {
		List<HashMap<String, String>> data = GetTestData.getTestData2("AccountsPage", "verifyYourLoansSection_APT_123_124_368");
		return data.toArray(); 
	}
	
	@DataProvider
	public Object[] apt125_126() {
		List<HashMap<String, String>> data = GetTestData.getTestData2("AccountsPage", "verifyRecentPaymentSection_APT_125_126");
		return data.toArray(); 
	}
	
	@Test(priority = 1, dataProvider = "apt119", description = "Accounts Link At The Top")
	public void verifyAccountLinkAtTop_APT_119(HashMap<String, String> map, ITestContext ctx, ITestResult rlt) throws InterruptedException, AWTException, IOException {
		
		SoftAssert softAssert = new SoftAssert();
		
		String dateAndTime = new SimpleDateFormat("yyyyMMddhhmmss").format(new Date());
		
		String instance = map.get("InstanceId");
				
		ctx.getCurrentXmlTest().addParameter( "InstanceId", instance);
		
		ctx.getCurrentXmlTest().addParameter( "Date", dateAndTime);
				
		log.info("In verifyAccountLinkAtTop_APT_119  ->  data is  " + map);
		
		log.info("*********************Start of  test " +map.get("TestCaseId")+ " **************************");

		lgnPge.login(map.get("Email"), map.get("Password"));
				
		boolean isDisplayed = acctPge.verifyAccountsPageIsDisplayed();
		
		acctPge.clickAccountsLink();
		
		isDisplayed = acctPge.verifyAccountsPageIsDisplayed();
		
		log.info("Is accounts page displayed?: " +isDisplayed);
		
		softAssert.assertTrue(isDisplayed);
		
		softAssert.assertAll();
		
	}
	
	@Test(priority = 2, dataProvider = "apt120", description = "Verify welcome message")
	public void verifyWelcomeMsgInAccountsPage_APT_120(HashMap<String, String> map, ITestContext ctx, ITestResult rlt) throws InterruptedException, AWTException, IOException {
		
		SoftAssert softAssert = new SoftAssert();
		
		String dateAndTime = new SimpleDateFormat("yyyyMMddhhmmss").format(new Date());
		
		String instance = map.get("InstanceId");
				
		ctx.getCurrentXmlTest().addParameter( "InstanceId", instance);
		
		ctx.getCurrentXmlTest().addParameter( "Date", dateAndTime);
				
		log.info("In verifyWelcomeMsgInAccountsPage_APT_120  ->  data is  " + map);
		
		log.info("*********************Start of  test " +map.get("TestCaseId")+ " **************************");

		lgnPge.login(map.get("Email"), map.get("Password"));
				
		boolean isDisplayed = acctPge.verifyAccountsPageIsDisplayed();
		
		String wlcmeMsg = acctPge.getWelcomeMsg();
		
		softAssert.assertEquals(wlcmeMsg, map.get("WelcomeMessage"), "Actual welcome message does not match expected welcome message");
		
		softAssert.assertAll();
		
	}
	
	@Test(priority = 3, dataProvider = "apt121_122_367", description = "Verify Account Summary Card Details")
	public void verifyAccountSummaryCard_APT_121_122_367(HashMap<String, String> map, ITestContext ctx, ITestResult rlt) throws InterruptedException, AWTException, IOException {
		
		SoftAssert softAssert = new SoftAssert();
		
		String dateAndTime = new SimpleDateFormat("yyyyMMddhhmmss").format(new Date());
		
		String instance = map.get("InstanceId");
				
		ctx.getCurrentXmlTest().addParameter( "InstanceId", instance);
		
		ctx.getCurrentXmlTest().addParameter( "Date", dateAndTime);
				
		log.info("In verifyAccountSummaryCard_APT_121_122  ->  data is  " + map);
		
		log.info("*********************Start of  test " +map.get("TestCaseId")+ " **************************");

		lgnPge.login(map.get("Email"), map.get("Password"));
				
		boolean isDisplayed = acctPge.verifyAccountsPageIsDisplayed();
		
		if(map.get("DueDatePassed").contentEquals("YES")) {
			
			acctPge.verifyAccountSummaryCardDetailsForDueDatePassedUser(map);
			
		} else {
			
			acctPge.verifyAccountSummaryCardDetailsForDueDateNotPassedUser(map);
		}
		
		
		
	}
	
	@Test(priority = 4, dataProvider = "apt123_124_368", description = "Verify Your Loans Section")
	public void verifyYourLoansSection_APT_123_124_368(HashMap<String, String> map, ITestContext ctx, ITestResult rlt) throws InterruptedException, AWTException, IOException {
		
		SoftAssert softAssert = new SoftAssert();
		
		String dateAndTime = new SimpleDateFormat("yyyyMMddhhmmss").format(new Date());
		
		String instance = map.get("InstanceId");
				
		ctx.getCurrentXmlTest().addParameter( "InstanceId", instance);
		
		ctx.getCurrentXmlTest().addParameter( "Date", dateAndTime);
				
		log.info("In verifyYourLoansSection_APT_123_124_368  ->  data is  " + map);
		
		log.info("*********************Start of  test " +map.get("TestCaseId")+ " **************************");

		lgnPge.login(map.get("Email"), map.get("Password"));
				
		boolean isDisplayed = acctPge.verifyAccountsPageIsDisplayed();
		
		boolean IsYourLoanSectionDisplayed = acctPge.verifyYourLoansSectionIsDisplayed();
		softAssert.assertTrue(IsYourLoanSectionDisplayed);
				
		acctPge.verifyLoanDetailsCard(map);
		
		softAssert.assertAll();
		
	}
	
	@Test(priority = 5, dataProvider = "apt125_126", description = "Verify Recent Payment Details")
	public void verifyRecentPaymentSection_APT_125_126(HashMap<String, String> map, ITestContext ctx, ITestResult rlt) throws InterruptedException, AWTException, IOException {
		
		SoftAssert softAssert = new SoftAssert();
		
		String dateAndTime = new SimpleDateFormat("yyyyMMddhhmmss").format(new Date());
		
		String instance = map.get("InstanceId");
				
		ctx.getCurrentXmlTest().addParameter( "InstanceId", instance);
		
		ctx.getCurrentXmlTest().addParameter( "Date", dateAndTime);
				
		log.info("In verifyRecentPaymentSection_APT_125_126  ->  data is  " + map);
		
		log.info("*********************Start of  test " +map.get("TestCaseId")+ " **************************");

		lgnPge.login(map.get("Email"), map.get("Password"));
				
		boolean isDisplayed = acctPge.verifyAccountsPageIsDisplayed();
		
		boolean isRecentPaymentSectionDisplayed = acctPge.verifyRecentPaymentsSectionIsDisplayed();
		softAssert.assertTrue(isRecentPaymentSectionDisplayed);
		
		boolean IsViewAllLinkDisplayed = acctPge.verifyViewAllLinkIsDisplayed();
		softAssert.assertTrue(IsViewAllLinkDisplayed);
		
		acctPge.verifyRecentPaymentDetails(map);
		
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
