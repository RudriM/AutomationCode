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
import com.wac.cwp.pages.LoginPage;
import com.wac.cwp.pages.SettingsPage;
import com.wac.cwp.util.GetTestData;
import com.wac.cwp.util.PractiTest;

public class SettingsPageTestCase extends TestBase {
	
	LoginPage lgnPge;
	SettingsPage stngPage;
	
	public SettingsPageTestCase() {
		super();
	}

	@BeforeMethod
	public void setUp() {
		
		initialization();
		lgnPge = new LoginPage();
		stngPage = new SettingsPage();
	}
	
	@DataProvider
	public Object[] apt_172() {
		List<HashMap<String, String>> data = GetTestData.getTestData2("SettingsPage", "verifySettingsLinkAtTop_APT_172");
		return data.toArray(); 
	}
	
	@DataProvider
	public Object[] apt_173() {
		List<HashMap<String, String>> data = GetTestData.getTestData2("SettingsPage", "verifyCards_APT_173");
		return data.toArray(); 
	}
	
	@DataProvider
	public Object[] apt_174_175() {
		List<HashMap<String, String>> data = GetTestData.getTestData2("SettingsPage", "verifyProfileCardDetails_174_175");
		return data.toArray(); 
	}
	
	@DataProvider
	public Object[] apt_176_177() {
		List<HashMap<String, String>> data = GetTestData.getTestData2("SettingsPage", "verifyAccountCardDetails_176_177");
		return data.toArray(); 
	}
	
	@DataProvider
	public Object[] apt_180_181() {
		List<HashMap<String, String>> data = GetTestData.getTestData2("SettingsPage", "VerifyverifyRecurringCard_180_181");
		return data.toArray(); 
	}
	
	@DataProvider
	public Object[] apt_218_223() {
		List<HashMap<String, String>> data = GetTestData.getTestData2("SettingsPage", "verifySetUpRecurring_218_223");
		return data.toArray(); 
	}
	
	@DataProvider
	public Object[] apt_219() {
		List<HashMap<String, String>> data = GetTestData.getTestData2("SettingsPage", "verifyManageRecurringPayments_APT_219");
		return data.toArray(); 
	}
	
	@DataProvider
	public Object[] apt_220() {
		List<HashMap<String, String>> data = GetTestData.getTestData2("SettingsPage", "VerifyManageRecurringDetails_APT_220");
		return data.toArray(); 
	}
	
	@DataProvider
	public Object[] apt_221() {
		List<HashMap<String, String>> data = GetTestData.getTestData2("SettingsPage", "verifyManageRecurringChange_APT_221");
		return data.toArray(); 
	}
	
	@DataProvider
	public Object[] apt_222() {
		List<HashMap<String, String>> data = GetTestData.getTestData2("SettingsPage", "verifyStopRecurringModel_APT_222");
		return data.toArray(); 
	}
	
	@DataProvider
	public Object[] apt_224() {
		List<HashMap<String, String>> data = GetTestData.getTestData2("SettingsPage", "VerifyLoanDetailsPage_224");
		return data.toArray(); 
	}
	
	
	@Test(priority = 1, dataProvider = "apt_172", description = "Settings Link At The Top")
	public void verifySettingsLinkAtTop_APT_172(HashMap<String, String> map, ITestContext ctx, ITestResult rlt) throws InterruptedException, AWTException, IOException {
		
		SoftAssert softAssert = new SoftAssert();
		
		String dateAndTime = new SimpleDateFormat("yyyyMMddhhmmss").format(new Date());
		
		String instance = map.get("InstanceId");
				
		ctx.getCurrentXmlTest().addParameter( "InstanceId", instance);
		
		ctx.getCurrentXmlTest().addParameter( "Date", dateAndTime);
		
		lgnPge.login(map.get("Email"), map.get("Password"));

		log.info("In verifySettingsLinkAtTop_APT_172  ->  data is  " + map);
		
		log.info("*********************Start of  test " +map.get("TestCaseId")+ " **************************");

		stngPage.clickSettingsPageLink();
		
		boolean isDisplayed = stngPage.isDisplaySettingsPage();

		isDisplayed = stngPage.isDisplaySettingsPage();
		
		log.info("Is Settings page displayed?: " +isDisplayed);
		
		softAssert.assertTrue(isDisplayed);
		
		softAssert.assertAll();
	}
	
	@Test(priority = 2, dataProvider = "apt_173", description = "Settings Link At The Top")
	public void verifyCards_APT_173(HashMap<String, String> map, ITestContext ctx, ITestResult rlt) throws InterruptedException, AWTException, IOException {
		
		SoftAssert softAssert = new SoftAssert();
		
		String dateAndTime = new SimpleDateFormat("yyyyMMddhhmmss").format(new Date());
		
		String instance = map.get("InstanceId");
				
		ctx.getCurrentXmlTest().addParameter( "InstanceId", instance);
		
		ctx.getCurrentXmlTest().addParameter( "Date", dateAndTime);
		
		lgnPge.login(map.get("Email"), map.get("Password"));
				
		log.info("In verifyCards_APT_173  ->  data is  " + map);
		
		log.info("*********************Start of  test " +map.get("TestCaseId")+ " **************************");

		stngPage.clickSettingsPageLink();
		
		boolean isDisplayedProfile = stngPage.isDisplayedProfileCard();
		log.info("Is Profile card displayed?: " +isDisplayedProfile);
		softAssert.assertTrue(isDisplayedProfile);

		boolean isDisplayedAccount = stngPage.isDisplayedAccountCard();
		log.info("Is Acoount card displayed?: " +isDisplayedAccount);
		softAssert.assertTrue(isDisplayedAccount);


		boolean isDisplayedRecurring = stngPage.isDisplayedRecurringCard();
		log.info("Is Recurring card displayed?: " +isDisplayedRecurring);
		softAssert.assertTrue(isDisplayedRecurring);
		
		softAssert.assertAll();
	}
	
	@Test(priority = 3, dataProvider = "apt_174_175", description = "Verify Profile Details")
	public void verifyProfileCardDetails_174_175(HashMap<String, String> map, ITestContext ctx, ITestResult rlt) throws InterruptedException, AWTException, IOException {
		
		SoftAssert softAssert = new SoftAssert();
		
		String dateAndTime = new SimpleDateFormat("yyyyMMddhhmmss").format(new Date());
		
		String instance = map.get("InstanceId");
				
		ctx.getCurrentXmlTest().addParameter( "InstanceId", instance);
		
		ctx.getCurrentXmlTest().addParameter( "Date", dateAndTime);
				
		log.info("In verifyProfileCardDetails_174  ->  data is  " + map);
		
		log.info("*********************Start of  test " +map.get("TestCaseId")+ " **************************");

		lgnPge.login(map.get("Email"), map.get("Password"));
		
		stngPage.clickSettingsPageLink();
		stngPage.verifyProfileDetails(map);
		
		boolean toolkit = stngPage.isDisplayedProfileToolkit();
		log.info("Profile toolkit is displayed ? " +toolkit);
		
		softAssert.assertAll();
	}
	
	@Test(priority = 4, dataProvider = "apt_176_177", description = "Verify Account Details")
	public void verifyAccountCardDetails_176_177(HashMap<String, String> map, ITestContext ctx, ITestResult rlt) throws InterruptedException, AWTException, IOException {
		
		SoftAssert softAssert = new SoftAssert();
		
		String dateAndTime = new SimpleDateFormat("yyyyMMddhhmmss").format(new Date());
		
		String instance = map.get("InstanceId");
				
		ctx.getCurrentXmlTest().addParameter( "InstanceId", instance);
		
		ctx.getCurrentXmlTest().addParameter( "Date", dateAndTime);
				
		log.info("In verifyAccountCardDetails_176_177  ->  data is  " + map);
		
		log.info("*********************Start of  test " +map.get("TestCaseId")+ " **************************");

		lgnPge.login(map.get("Email"), map.get("Password"));
		stngPage.clickSettingsPageLink();
		stngPage.verifyAccountDetails(map);
		stngPage.isDisplayedAccountToolkit();
	}
	
	@Test(priority = 5, dataProvider = "apt_180_181", description = "Verify Recurring Details")
	public void VerifyverifyRecurringCard_180_181(HashMap<String, String> map, ITestContext ctx, ITestResult rlt) throws InterruptedException, AWTException, IOException {
		
		SoftAssert softAssert = new SoftAssert();
		
		String dateAndTime = new SimpleDateFormat("yyyyMMddhhmmss").format(new Date());
		
		String instance = map.get("InstanceId");
				
		ctx.getCurrentXmlTest().addParameter( "InstanceId", instance);
		
		ctx.getCurrentXmlTest().addParameter( "Date", dateAndTime);
				
		log.info("In VerifyverifyRecurringCard_180_181  ->  data is  " + map);
		
		log.info("*********************Start of  test " +map.get("TestCaseId")+ " **************************");

		lgnPge.login(map.get("Email"), map.get("Password"));
		stngPage.clickSettingsPageLink();
		stngPage.verifyRecurringCardForMoreLoan(map);
		softAssert.assertAll();
	}
	
	@Test(priority =6 , dataProvider = "apt_218_223", description = "Verify Set up Recurring")
	public void verifySetUpRecurring_218_223(HashMap<String, String> map, ITestContext ctx, ITestResult rlt) throws InterruptedException, AWTException, IOException {
		SoftAssert softAssert = new SoftAssert();
		
		String dateAndTime = new SimpleDateFormat("yyyyMMddhhmmss").format(new Date());
		
		String instance = map.get("InstanceId");
				
		ctx.getCurrentXmlTest().addParameter( "InstanceId", instance);
		
		ctx.getCurrentXmlTest().addParameter( "Date", dateAndTime);
				
		log.info("In verifySetUpRecurring_144_147  ->  data is  " + map);
		
		log.info("*********************Start of  test " +map.get("TestCaseId")+ " **************************");

		lgnPge.login(map.get("Email"), map.get("Password"));
		
		stngPage.clickSettingsPageLink();
		stngPage.setUpRecurring(map);
		softAssert.assertAll();
	}
	
	@Test(priority = 7, dataProvider = "apt_219", description = "Verify Manage Recurring button")
	public void verifyManageRecurringPayments_APT_219(HashMap<String, String> map, ITestContext ctx, ITestResult rlt) throws InterruptedException, AWTException, IOException {
		SoftAssert softAssert = new SoftAssert();
		
		String dateAndTime = new SimpleDateFormat("yyyyMMddhhmmss").format(new Date());
		
		String instance = map.get("InstanceId");
				
		ctx.getCurrentXmlTest().addParameter( "InstanceId", instance);
		
		ctx.getCurrentXmlTest().addParameter( "Date", dateAndTime);
				
		log.info("In verifyManageRecurringPayments_APT_219  ->  data is  " + map);
		
		log.info("*********************Start of  test " +map.get("TestCaseId")+ " **************************");

		lgnPge.login(map.get("Email"), map.get("Password"));
		
		stngPage.clickSettingsPageLink();
		
		stngPage.verifyManageRecurringButton(map);

		softAssert.assertAll();
	}
	
	@Test(priority = 8, dataProvider = "apt_220", description = "Verify Manage Recurring button")
	public void VerifyManageRecurringDetails_APT_220(HashMap<String, String> map, ITestContext ctx, ITestResult rlt) throws InterruptedException, AWTException, IOException {
		SoftAssert softAssert = new SoftAssert();
		
		String dateAndTime = new SimpleDateFormat("yyyyMMddhhmmss").format(new Date());
		
		String instance = map.get("InstanceId");
				
		ctx.getCurrentXmlTest().addParameter( "InstanceId", instance);
		
		ctx.getCurrentXmlTest().addParameter( "Date", dateAndTime);
				
		log.info("In VerifyManageRecurringDetails_APT_220  ->  data is  " + map);
		
		log.info("*********************Start of  test " +map.get("TestCaseId")+ " **************************");

		lgnPge.login(map.get("Email"), map.get("Password"));
		
		stngPage.clickSettingsPageLink();
		
		stngPage.manageRecurringDetails(map);

		softAssert.assertAll();
	}
	
	@Test(priority = 9, dataProvider = "apt_221", description = "Update Manage Recurring payment")
	public void verifyManageRecurringChange_APT_221(HashMap<String, String> map, ITestContext ctx, ITestResult rlt) throws InterruptedException, AWTException, IOException {
		SoftAssert softAssert = new SoftAssert();
		
		String dateAndTime = new SimpleDateFormat("yyyyMMddhhmmss").format(new Date());
		
		String instance = map.get("InstanceId");
				
		ctx.getCurrentXmlTest().addParameter( "InstanceId", instance);
		
		ctx.getCurrentXmlTest().addParameter( "Date", dateAndTime);
				
		log.info("In verifyManageRecurringChange_APT_221  ->  data is  " + map);
		
		log.info("*********************Start of  test " +map.get("TestCaseId")+ " **************************");

		lgnPge.login(map.get("Email"), map.get("Password"));
		
		stngPage.clickSettingsPageLink();
		
		stngPage.changeRecurringPayment(map);

		softAssert.assertAll();
	}
	
	@Test(priority = 10, dataProvider = "apt_222", description = "Verify stop model pop up")
	public void verifyStopRecurringModel_APT_222(HashMap<String, String> map, ITestContext ctx, ITestResult rlt) throws InterruptedException, AWTException, IOException {
		SoftAssert softAssert = new SoftAssert();
		
		String dateAndTime = new SimpleDateFormat("yyyyMMddhhmmss").format(new Date());
		
		String instance = map.get("InstanceId");
				
		ctx.getCurrentXmlTest().addParameter( "InstanceId", instance);
		
		ctx.getCurrentXmlTest().addParameter( "Date", dateAndTime);
				
		log.info("In verifyStopRecurringModel_APT_222  ->  data is  " + map);
		
		log.info("*********************Start of  test " +map.get("TestCaseId")+ " **************************");

		lgnPge.login(map.get("Email"), map.get("Password"));
		
		stngPage.clickSettingsPageLink();
		
		stngPage.verifyStopRecurringPopUp(map);

		softAssert.assertAll();
	}
	
	@Test(priority = 11, dataProvider = "apt_224", description = "Verify Loan link")
	public void VerifyLoanDetailsPage_224(HashMap<String, String> map, ITestContext ctx, ITestResult rlt) throws InterruptedException, AWTException, IOException {
		SoftAssert softAssert = new SoftAssert();
		
		String dateAndTime = new SimpleDateFormat("yyyyMMddhhmmss").format(new Date());
		
		String instance = map.get("InstanceId");
				
		ctx.getCurrentXmlTest().addParameter( "InstanceId", instance);
		
		ctx.getCurrentXmlTest().addParameter( "Date", dateAndTime);
				
		log.info("In VerifyLoanDetailsPage_224  ->  data is  " + map);
		
		log.info("*********************Start of  test " +map.get("TestCaseId")+ " **************************");

		lgnPge.login(map.get("Email"), map.get("Password"));
		
		stngPage.clickSettingsPageLink();
		
		stngPage.ClickLoanDetailsLink();
		log.info("Navigated to loan details page");

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
