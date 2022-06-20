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

public class LoginTestCases extends TestBase {
	
	LoginPage lgnPge;
	AccountsPage  acctPge;
	String loginSheet = "LoginPage";
	
	public LoginTestCases() {
		super();
	}
	
	@BeforeMethod
	public void setUp() {
		
		initialization();
		
		lgnPge = new LoginPage();
		acctPge = new AccountsPage();
	}
	  
	@DataProvider
	public Object[] lt01() {
		List<HashMap<String, String>> data = GetTestData.getTestData2("Login", "successfulLogin_LT_01");
		return data.toArray(); 
	}
	  
	@DataProvider
	public Object[] lt02_03_04_05_06() {
		List<HashMap<String, String>> data = GetTestData.getTestData2("Login", "failedLogin_LT_02_03_04_05_06");
		return data.toArray(); 
	}
	
	
	@Test(priority = 1, dataProvider = "lt01", description = "Successfull login to customer web portal")
	public void successfulLogin_LT_01(HashMap<String, String> map, ITestContext ctx, ITestResult rlt) throws InterruptedException, AWTException, IOException {
		
		SoftAssert softAssert = new SoftAssert();
		
		String dateAndTime = new SimpleDateFormat("yyyyMMddhhmmss").format(new Date());
		
		String instance = map.get("InstanceId");
				
		ctx.getCurrentXmlTest().addParameter( "InstanceId", instance);
		
		ctx.getCurrentXmlTest().addParameter( "Date", dateAndTime);
				
		log.info("In successfulLogin_LT_01  ->  data is  " + map);
		
		log.info("*********************Start of  test " +map.get("TestCaseId")+ " **************************");

		lgnPge.login(map.get("Email"), map.get("Password"));
				
//		boolean isDisplayed = acctPge.verifyAccountsPageIsDisplayed();
//		
//		log.info("Is user successfully logged in?: " +isDisplayed);
//		
//		softAssert.assertTrue(isDisplayed);
//		
//		softAssert.assertAll();
		
	}
	  
	@Test(priority = 2, dataProvider = "lt02_03_04_05_06", description = "Failed login to customer web portal")
	public void failedLogin_LT_02_03_04_05_06(HashMap<String, String> map, ITestContext ctx, ITestResult rlt) throws InterruptedException, AWTException, IOException {
		
		SoftAssert softAssert = new SoftAssert();
		
		String dateAndTime = new SimpleDateFormat("yyyyMMddhhmmss").format(new Date());
		
		String instance = map.get("InstanceId");
		
		String errMsg;
				
		ctx.getCurrentXmlTest().addParameter( "InstanceId", instance);
		
		ctx.getCurrentXmlTest().addParameter( "Date", dateAndTime);
				
		log.info("In failedLogin_LT_02_03_04_05_06  ->  data is  " + map);
		
		log.info("*********************Start of  test " +map.get("TestCaseId")+ " **************************");
		
		String email = map.get("Email");
		String psswrd = map.get("Password");
		
		if (email.contentEquals("BLANK") && psswrd.contentEquals("BLANK")) {
			
			lgnPge.login("", "");	
			
		} 
		else if (psswrd.contentEquals("BLANK")) {
			
			lgnPge.login(map.get("Email"), "");	
			
		} 
		else if (email.contentEquals("BLANK")) {
			
			lgnPge.login("", map.get("Password"));
			
		}
		else {
			
			lgnPge.login(map.get("Email"), map.get("Password"));
		}
		
		if (psswrd.contentEquals("BLANK") || email.contentEquals("BLANK"))
		{
			errMsg = lgnPge.missingUsernameOrPasswordError();
			log.info("The actual error message is: " +errMsg);
			log.info("The expected error message is: " +map.get("FieldError"));
			softAssert.assertEquals(errMsg, map.get("FieldError"), "Actual error message is different from expected error message");
			
		}
		else {
			errMsg = lgnPge.getInvalidUserNameOrPasswordError();
			log.info("The actual error message is: " +errMsg);
			log.info("The expected error message is: " +map.get("MainError"));
			softAssert.assertEquals(errMsg, map.get("MainError"), "Actual error message is different from expected error message");
		}
		
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
