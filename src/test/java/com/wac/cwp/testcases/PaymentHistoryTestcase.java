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
import com.wac.cwp.pages.PaymentHistoryPage;
import com.wac.cwp.util.GetTestData;
import com.wac.cwp.util.PractiTest;

public class PaymentHistoryTestcase extends TestBase {

	LoginPage lgnPge;
	PaymentHistoryPage  paymentHistoryPage;
	
	public PaymentHistoryTestcase() {
		super();
	}
	
	@BeforeMethod
	public void setUp() {
		
		initialization();
		lgnPge = new LoginPage();
		paymentHistoryPage = new PaymentHistoryPage();
	}
	
	@DataProvider
	public Object[] apt_155() {
		List<HashMap<String, String>> data = GetTestData.getTestData2("PaymentHistoryPage", "verifyPaymentHistoryLink_apt_155");
		return data.toArray(); 
	}
	
	@DataProvider
	public Object[] apt_156() {
		List<HashMap<String, String>> data = GetTestData.getTestData2("PaymentHistoryPage", "verifyPaymentHistoryPage_APT_156");
		return data.toArray(); 
	}
	
	@DataProvider
	public Object[] apt_157() {
		List<HashMap<String, String>> data = GetTestData.getTestData2("PaymentHistoryPage", "verifyMakePayment_apt_157");
				return data.toArray(); 
	}
	
	@DataProvider
	public Object[] apt_158() {
		List<HashMap<String, String>> data = GetTestData.getTestData2("PaymentHistoryPage", "verifyDateFilter_apt_158");
				return data.toArray(); 
	}
	
	@DataProvider
	public Object[] apt_159() {
		List<HashMap<String, String>> data = GetTestData.getTestData2("PaymentHistoryPage", "VerifySetDateFilter_apt_159");
				return data.toArray(); 
	}
	
	@DataProvider
	public Object[] apt_160() {
		List<HashMap<String, String>> data = GetTestData.getTestData2("PaymentHistoryPage", "VerifyLoanFilter_apt_160");
				return data.toArray(); 
	}
	
	@DataProvider
	public Object[] apt_161() {
		List<HashMap<String, String>> data = GetTestData.getTestData2("PaymentHistoryPage", "VerifySetLoanFilter_apt_161");
				return data.toArray(); 
	}
	
	@DataProvider
	public Object[] apt_162() {
		List<HashMap<String, String>> data = GetTestData.getTestData2("PaymentHistoryPage", "verifySourceFilter_apt_162");
				return data.toArray(); 
	}
	
	@DataProvider
	public Object[] apt_163() {
		List<HashMap<String, String>> data = GetTestData.getTestData2("PaymentHistoryPage", "verifySetSourceFilter_apt_163");
				return data.toArray(); 
	}
	
	@DataProvider
	public Object[] apt_164() {
		List<HashMap<String, String>> data = GetTestData.getTestData2("PaymentHistoryPage", "verifyPaymentMethodFilter_apt_164");
				return data.toArray(); 
	}
	
	@DataProvider
	public Object[] apt_165() {
		List<HashMap<String, String>> data = GetTestData.getTestData2("PaymentHistoryPage", "verifySetPaymentMethodFilter_apt_165");
				return data.toArray(); 
	}
	
	@DataProvider
	public Object[] apt_166() {
		List<HashMap<String, String>> data = GetTestData.getTestData2("PaymentHistoryPage", "verifyStatusFilter_apt_166");
				return data.toArray(); 
	}
	
	@DataProvider
	public Object[] apt_167() {
		List<HashMap<String, String>> data = GetTestData.getTestData2("PaymentHistoryPage", "verifySetStatusFilter_apt_167");
				return data.toArray(); 
	}
	
	@DataProvider
	public Object[] apt_168() {
		List<HashMap<String, String>> data = GetTestData.getTestData2("PaymentHistoryPage", "verifySetAllFilter_apt_168");
				return data.toArray(); 
	}
	
	@DataProvider
	public Object[] apt_171() {
		List<HashMap<String, String>> data = GetTestData.getTestData2("PaymentHistoryPage", "verifyNoOfRecentPayments_169");
				return data.toArray(); 
	}
	
	@DataProvider
	public Object[] apt_169() {
		List<HashMap<String, String>> data = GetTestData.getTestData2("PaymentHistoryPage", "verifyNoOfRecentPayments_169");
				return data.toArray(); 
	}
	
	
	@Test(priority = 1, dataProvider = "apt_155", description = "Verify payment history link at the top")
	public void verifyPaymentHistoryLink_apt_155(HashMap<String, String> map, ITestContext ctx, ITestResult rlt) throws InterruptedException, AWTException, IOException {
		
		SoftAssert softAssert = new SoftAssert();
		
		String dateAndTime = new SimpleDateFormat("yyyyMMddhhmmss").format(new Date());
		
		String instance = map.get("InstanceId");
				
		ctx.getCurrentXmlTest().addParameter( "InstanceId", instance);
		
		ctx.getCurrentXmlTest().addParameter( "Date", dateAndTime);
				
		log.info("In verifyPaymentHistoryLink_apt_155  ->  data is  " + map);
		
		log.info("*********************Start of  test " +map.get("TestCaseId")+ " **************************");

		lgnPge.login(map.get("Email"), map.get("Password"));
		paymentHistoryPage.clickPaymentHistory();
		paymentHistoryPage.isDisplayedHeading();
		softAssert.assertAll();
	}
	
	@Test(priority = 2, dataProvider = "apt_156", description = "Payment History page")
	public void verifyPaymentHistoryPage_APT_156(HashMap<String, String> map, ITestContext ctx, ITestResult rlt) throws InterruptedException, AWTException, IOException {
		
		SoftAssert softAssert = new SoftAssert();
		
		String dateAndTime = new SimpleDateFormat("yyyyMMddhhmmss").format(new Date());
		
		String instance = map.get("InstanceId");
				
		ctx.getCurrentXmlTest().addParameter( "InstanceId", instance);
		
		ctx.getCurrentXmlTest().addParameter( "Date", dateAndTime);
				
		log.info("In verifyPaymentHistoryPage_APT_156  ->  data is  " + map);
		
		log.info("*********************Start of  test " +map.get("TestCaseId")+ " **************************");

		lgnPge.login(map.get("Email"), map.get("Password"));
		
		paymentHistoryPage.clickPaymentHistory();
		paymentHistoryPage.verifyPaymentHistoryPage(map);
		
	}
	
	@Test(priority = 3, dataProvider = "apt_157", description = "Make a payment")
	public void verifyMakePayment_apt_157(HashMap<String, String> map, ITestContext ctx, ITestResult rlt) throws InterruptedException, AWTException, IOException {
		
		SoftAssert softAssert = new SoftAssert();
		
		String dateAndTime = new SimpleDateFormat("yyyyMMddhhmmss").format(new Date());
		
		String instance = map.get("InstanceId");
				
		ctx.getCurrentXmlTest().addParameter( "InstanceId", instance);
		
		ctx.getCurrentXmlTest().addParameter( "Date", dateAndTime);
				
		log.info("In verifyPaymentHistoryPage_APT_156  ->  data is  " + map);
		
		log.info("*********************Start of  test " +map.get("TestCaseId")+ " **************************");

		lgnPge.login(map.get("Email"), map.get("Password"));
		
		paymentHistoryPage.clickPaymentHistory();
		paymentHistoryPage.verifyMakePayment(map);
		
	}
	

	@Test(priority = 4, dataProvider = "apt_158", description = "Date Filter option verification")
	public void verifyDateFilter_apt_158(HashMap<String, String> map, ITestContext ctx, ITestResult rlt) throws InterruptedException, AWTException, IOException {
		
		SoftAssert softAssert = new SoftAssert();
		
		String dateAndTime = new SimpleDateFormat("yyyyMMddhhmmss").format(new Date());
		
		String instance = map.get("InstanceId");
				
		ctx.getCurrentXmlTest().addParameter( "InstanceId", instance);
		
		ctx.getCurrentXmlTest().addParameter( "Date", dateAndTime);
				
		log.info("In verifyDateFilte_apt_158  ->  data is  " + map);
		
		log.info("*********************Start of  test " +map.get("TestCaseId")+ " **************************");

		lgnPge.login(map.get("Email"), map.get("Password"));

		paymentHistoryPage.clickPaymentHistory();
		paymentHistoryPage.verifyDateFilter(map);		
	}
	
	@Test(priority = 5, dataProvider = "apt_159", description = "Set Date and Filter")
	public void VerifySetDateFilter_apt_159(HashMap<String, String> map, ITestContext ctx, ITestResult rlt) throws InterruptedException, AWTException, IOException {
		
		SoftAssert softAssert = new SoftAssert();
		
		String dateAndTime = new SimpleDateFormat("yyyyMMddhhmmss").format(new Date());
		
		String instance = map.get("InstanceId");
				
		ctx.getCurrentXmlTest().addParameter( "InstanceId", instance);
		
		ctx.getCurrentXmlTest().addParameter( "Date", dateAndTime);
				
		log.info("In VerifySetDateFilter_apt_159  ->  data is  " + map);
		
		log.info("*********************Start of  test " +map.get("TestCaseId")+ " **************************");

		lgnPge.login(map.get("Email"), map.get("Password"));

		paymentHistoryPage.clickPaymentHistory();
		paymentHistoryPage.verifySetDateFilter(map);
	}
	
	@Test(priority = 6, dataProvider = "apt_160", description = "Loan and Filter Option")
	public void VerifyLoanFilter_apt_160(HashMap<String, String> map, ITestContext ctx, ITestResult rlt) throws InterruptedException, AWTException, IOException {
		
		SoftAssert softAssert = new SoftAssert();
		
		String dateAndTime = new SimpleDateFormat("yyyyMMddhhmmss").format(new Date());
		
		String instance = map.get("InstanceId");
				
		ctx.getCurrentXmlTest().addParameter( "InstanceId", instance);
		
		ctx.getCurrentXmlTest().addParameter( "Date", dateAndTime);
				
		log.info("In VerifySetLoanFilter_apt_161  ->  data is  " + map);
		
		log.info("*********************Start of  test " +map.get("TestCaseId")+ " **************************");

		lgnPge.login(map.get("Email"), map.get("Password"));

		paymentHistoryPage.clickPaymentHistory();
		paymentHistoryPage.verifyLoanFilter(map);
	}
	
	@Test(priority = 7, dataProvider = "apt_161", description = "Set loan and Filter")
	public void VerifySetLoanFilter_apt_161(HashMap<String, String> map, ITestContext ctx, ITestResult rlt) throws InterruptedException, AWTException, IOException {
		
		SoftAssert softAssert = new SoftAssert();
		
		String dateAndTime = new SimpleDateFormat("yyyyMMddhhmmss").format(new Date());
		
		String instance = map.get("InstanceId");
				
		ctx.getCurrentXmlTest().addParameter( "InstanceId", instance);
		
		ctx.getCurrentXmlTest().addParameter( "Date", dateAndTime);
				
		log.info("In VerifySetLoanFilter_apt_161  ->  data is  " + map);
		
		log.info("*********************Start of  test " +map.get("TestCaseId")+ " **************************");

		lgnPge.login(map.get("Email"), map.get("Password"));
	
		paymentHistoryPage.clickPaymentHistory();
		paymentHistoryPage.verifySetLoanFilter(map);
	}
	
	@Test(priority = 8, dataProvider = "apt_162", description = "Set loan and Filter")
	public void verifySourceFilter_apt_162(HashMap<String, String> map, ITestContext ctx, ITestResult rlt) throws InterruptedException, AWTException, IOException {
		
		SoftAssert softAssert = new SoftAssert();
		
		String dateAndTime = new SimpleDateFormat("yyyyMMddhhmmss").format(new Date());
		
		String instance = map.get("InstanceId");
				
		ctx.getCurrentXmlTest().addParameter( "InstanceId", instance);
		
		ctx.getCurrentXmlTest().addParameter( "Date", dateAndTime);
				
		log.info("In verifySourceFilter_apt_162  ->  data is  " + map);
		
		log.info("*********************Start of  test " +map.get("TestCaseId")+ " **************************");

		lgnPge.login(map.get("Email"), map.get("Password"));
	
		paymentHistoryPage.clickPaymentHistory();
		paymentHistoryPage.verifySourceFilter(map);
	}
	
	@Test(priority = 9, dataProvider = "apt_163", description = "Set Source and Filter")
	public void verifySetSourceFilter_apt_163(HashMap<String, String> map, ITestContext ctx, ITestResult rlt) throws InterruptedException, AWTException, IOException {
		
		SoftAssert softAssert = new SoftAssert();
		
		String dateAndTime = new SimpleDateFormat("yyyyMMddhhmmss").format(new Date());
		
		String instance = map.get("InstanceId");
				
		ctx.getCurrentXmlTest().addParameter( "InstanceId", instance);
		
		ctx.getCurrentXmlTest().addParameter( "Date", dateAndTime);
				
		log.info("In verifySetSourceFilter_apt_163  ->  data is  " + map);
		
		log.info("*********************Start of  test " +map.get("TestCaseId")+ " **************************");

		lgnPge.login(map.get("Email"), map.get("Password"));
	
		paymentHistoryPage.clickPaymentHistory();
		paymentHistoryPage.verifySetSourceFilter(map);
	}
	
	@Test(priority = 10, dataProvider = "apt_164", description = "Verify Payment method is displayed")
	public void verifyPaymentMethodFilter_apt_164(HashMap<String, String> map, ITestContext ctx, ITestResult rlt) throws InterruptedException, AWTException, IOException {
		
		SoftAssert softAssert = new SoftAssert();
		
		String dateAndTime = new SimpleDateFormat("yyyyMMddhhmmss").format(new Date());
		
		String instance = map.get("InstanceId");
				
		ctx.getCurrentXmlTest().addParameter( "InstanceId", instance);
		
		ctx.getCurrentXmlTest().addParameter( "Date", dateAndTime);
				
		log.info("In verifyPaymentMethodFilter_apt_164  ->  data is  " + map);
		
		log.info("*********************Start of  test " +map.get("TestCaseId")+ " **************************");

		lgnPge.login(map.get("Email"), map.get("Password"));
	
		paymentHistoryPage.clickPaymentHistory();
		paymentHistoryPage.verifyPaymentFilter(map);
	}
	
	@Test(priority = 11, dataProvider = "apt_165", description = "Set Source and Filter")
	public void verifySetPaymentMethodFilter_apt_165 (HashMap<String, String> map, ITestContext ctx, ITestResult rlt) throws InterruptedException, AWTException, IOException {
		
		SoftAssert softAssert = new SoftAssert();
		
		String dateAndTime = new SimpleDateFormat("yyyyMMddhhmmss").format(new Date());
		
		String instance = map.get("InstanceId");
				
		ctx.getCurrentXmlTest().addParameter( "InstanceId", instance);
		
		ctx.getCurrentXmlTest().addParameter( "Date", dateAndTime);
				
		log.info("In verifySetPaymentMethodFilter_apt_165  ->  data is  " + map);
		
		log.info("*********************Start of  test " +map.get("TestCaseId")+ " **************************");

		lgnPge.login(map.get("Email"), map.get("Password"));
	
		paymentHistoryPage.clickPaymentHistory();
		paymentHistoryPage.verifySetPaymentMethodFilter(map);
	}
	
	@Test(priority = 12, dataProvider = "apt_166", description = "Set Source and Filter")
	public void verifyStatusFilter_apt_166(HashMap<String, String> map, ITestContext ctx, ITestResult rlt) throws InterruptedException, AWTException, IOException {
		
		SoftAssert softAssert = new SoftAssert();
		
		String dateAndTime = new SimpleDateFormat("yyyyMMddhhmmss").format(new Date());
		
		String instance = map.get("InstanceId");
				
		ctx.getCurrentXmlTest().addParameter( "InstanceId", instance);
		
		ctx.getCurrentXmlTest().addParameter( "Date", dateAndTime);
				
		log.info("In verifyStatusFilter_apt_166  ->  data is  " + map);
		
		log.info("*********************Start of  test " +map.get("TestCaseId")+ " **************************");

		lgnPge.login(map.get("Email"), map.get("Password"));
	
		paymentHistoryPage.clickPaymentHistory();
		paymentHistoryPage.verifyStatusFilter(map);
	}
	
	@Test(priority = 13, dataProvider = "apt_167", description = "Set Source and Filter")
	public void verifySetStatusFilter_apt_167 (HashMap<String, String> map, ITestContext ctx, ITestResult rlt) throws InterruptedException, AWTException, IOException {
		
		SoftAssert softAssert = new SoftAssert();
		
		String dateAndTime = new SimpleDateFormat("yyyyMMddhhmmss").format(new Date());
		
		String instance = map.get("InstanceId");
				
		ctx.getCurrentXmlTest().addParameter( "InstanceId", instance);
		
		ctx.getCurrentXmlTest().addParameter( "Date", dateAndTime);
				
		log.info("In verifySetStatusFilter_apt_167  ->  data is  " + map);
		
		log.info("*********************Start of  test " +map.get("TestCaseId")+ " **************************");

		lgnPge.login(map.get("Email"), map.get("Password"));
	
		paymentHistoryPage.clickPaymentHistory();
		paymentHistoryPage.verifySetStatusMethodFilter(map);
	}
	
	@Test(priority = 14, dataProvider = "apt_168", description = "Verify all Filter")
	public void verifySetAllFilter_apt_168(HashMap<String, String> map, ITestContext ctx, ITestResult rlt) throws InterruptedException, AWTException, IOException {
		SoftAssert softAssert = new SoftAssert();
		
		String dateAndTime = new SimpleDateFormat("yyyyMMddhhmmss").format(new Date());
		
		String instance = map.get("InstanceId");
				
		ctx.getCurrentXmlTest().addParameter( "InstanceId", instance);
		
		ctx.getCurrentXmlTest().addParameter( "Date", dateAndTime);
				
		log.info("In verifySetAllFilter_apt_168  ->  data is  " + map);
		
		log.info("*********************Start of  test " +map.get("TestCaseId")+ " **************************");

		lgnPge.login(map.get("Email"), map.get("Password"));
	
		paymentHistoryPage.clickPaymentHistory();
		paymentHistoryPage.verifySetAllFilter(map);
	}
	
	@Test(priority = 15, dataProvider = "apt_171", description = "Verify Loan last update toolkit message")
	public void verifyToolkitMsg_171(HashMap<String, String> map, ITestContext ctx, ITestResult rlt) throws InterruptedException, AWTException, IOException {
		
		SoftAssert softAssert = new SoftAssert();
		
		String dateAndTime = new SimpleDateFormat("yyyyMMddhhmmss").format(new Date());		
		String instance = map.get("InstanceId");
				
		ctx.getCurrentXmlTest().addParameter( "InstanceId", instance);
		
		ctx.getCurrentXmlTest().addParameter( "Date", dateAndTime);
				
		log.info("In verifyToolkitMsg_171  ->  data is  " + map);
		
		log.info("*********************Start of  test " +map.get("TestCaseId")+ " **************************");

		lgnPge.login(map.get("Email"), map.get("Password"));
	
		paymentHistoryPage.clickPaymentHistory();
		paymentHistoryPage.isDisplayedHistoryLoanDataToolkit();
	}
	
	@Test(priority = 16, dataProvider = "apt_169", description = "Verify recent payment section")
	public void verifyNoOfRecentPayments_169(HashMap<String, String> map, ITestContext ctx, ITestResult rlt) throws InterruptedException, AWTException, IOException {
		
		SoftAssert softAssert = new SoftAssert();
		
		String dateAndTime = new SimpleDateFormat("yyyyMMddhhmmss").format(new Date());		
		String instance = map.get("InstanceId");
				
		ctx.getCurrentXmlTest().addParameter( "InstanceId", instance);
		
		ctx.getCurrentXmlTest().addParameter( "Date", dateAndTime);
				
		log.info("In verifyNoOfRecentPayments_169  ->  data is  " + map);
		
		log.info("*********************Start of  test " +map.get("TestCaseId")+ " **************************");

		lgnPge.login(map.get("Email"), map.get("Password"));
	
		paymentHistoryPage.clickPaymentHistory();
		paymentHistoryPage.recentPaymentDetails(map);
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
