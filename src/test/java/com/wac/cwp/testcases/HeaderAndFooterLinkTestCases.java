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
import com.wac.cwp.pages.HeaderAndFooterLinks;
import com.wac.cwp.pages.LoginPage;
import com.wac.cwp.util.GetTestData;
import com.wac.cwp.util.PractiTest;

public class HeaderAndFooterLinkTestCases extends TestBase {
	
	
	LoginPage lgnPge;
	HeaderAndFooterLinks HdrAndFtrLnk;
	AccountsPage  acctPge;
	
	public HeaderAndFooterLinkTestCases() {
		super();
	}
	
	@BeforeMethod
	public void setUp() {
		
		initialization();	
		lgnPge = new LoginPage();
		HdrAndFtrLnk = new HeaderAndFooterLinks();
		acctPge = new AccountsPage();

	}
	
	@DataProvider
	public Object[] FAHL_296_297_299_302To319() {
		List<HashMap<String, String>> data = GetTestData.getTestData2("FooterAndHeaderLinks", "clickHeaderAndFooterLinks_FAHL_296_297_299_302To319");
		return data.toArray(); 
	}
	
	@DataProvider
	public Object[] FAHL_298() {
		List<HashMap<String, String>> data = GetTestData.getTestData2("FooterAndHeaderLinks", "clickLogout_FAHL_298");
		return data.toArray(); 
	}
	
	@DataProvider
	public Object[] FAHL_300() {
		List<HashMap<String, String>> data = GetTestData.getTestData2("FooterAndHeaderLinks", "VerifyBranchServiceCenterDetails_FAHL_300");
		return data.toArray(); 
	}
	
	@DataProvider
	public Object[] FAHL_301() {
		List<HashMap<String, String>> data = GetTestData.getTestData2("FooterAndHeaderLinks", "VerifyCopyRightMessage_FAHL_301");
		return data.toArray(); 
	}
	
	
	
	@Test(priority = 1, dataProvider = "FAHL_296_297_299_302To319", description = "Clicking on header and footer links")
	public void clickHeaderAndFooterLinks_FAHL_296_297_299_302To319(HashMap<String, String> map, ITestContext ctx, ITestResult rlt) throws InterruptedException, AWTException, IOException {
		
		SoftAssert softAssert = new SoftAssert();
		
		String dateAndTime = new SimpleDateFormat("yyyyMMddhhmmss").format(new Date());
		
		String instance = map.get("InstanceId");
				
		ctx.getCurrentXmlTest().addParameter( "InstanceId", instance);
		
		ctx.getCurrentXmlTest().addParameter( "Date", dateAndTime);
				
		log.info("In clickHeaderAndFooterLinks_FAHL_296_297_299_302To319  ->  data is  " + map);
		
		log.info("*********************Start of  test " +map.get("TestCaseId")+ " **************************");
		
		if ((map.get("PageOnWhichToClick")).contentEquals("LoginPage")) {
			
		} else {
			
			lgnPge.login(map.get("Email"), map.get("Password"));
			boolean isDisplayed = acctPge.verifyAccountsPageIsDisplayed();
			
			if ((map.get("PageOnWhichToClick")).contentEquals("PaymentHistoryPage")) {
				acctPge.clickPaymentHistoryLink();
				log.info("clicked on payment history link");
			} else if ((map.get("PageOnWhichToClick")).contentEquals("SettingsPage")) {
				acctPge.clickSettingsLink();
				log.info("clicked on settings link");
			} else if ((map.get("PageOnWhichToClick")).contentEquals("LoanDetailsPage")) {
				acctPge.ClickViewLoanDetailsLink();
				log.info("clicked on view loan details link");
			}
		}
		

		if ((map.get("LinkToClick")).contentEquals("CompanyLogoAtHeader")) {
			
			HdrAndFtrLnk.clickWorldFinanceLogoAtTopLeft();
			log.info("Clicked on company logo at the top left");
			
		} else if ((map.get("LinkToClick")).contentEquals("HelpAtHeader")) {
			
			HdrAndFtrLnk.clickHelpLink();
			log.info("Clicked on help link at the header");
			
		} else if ((map.get("LinkToClick")).contentEquals("CompanyLogoAtFooter")) {
			
			HdrAndFtrLnk.clickCompanyLogoAtFooter();
			log.info("Clicked on company logo at the footer");
			
		} else if ((map.get("LinkToClick")).contentEquals("ContactUsAtFooter")) {
			
			HdrAndFtrLnk.clickCompanyLinkContactUs(); 
			log.info("Clicked on contact us link at the footer");
			
		} else if ((map.get("LinkToClick")).contentEquals("FindABranchAtFooter")) {
			
			HdrAndFtrLnk.clickCompanyLinkFindABranch(); 
			log.info("Clicked on find a branch link at the footer");
			
		} else if ((map.get("LinkToClick")).contentEquals("InvestorRelationAtFooter")) {
			
			HdrAndFtrLnk.clickComapnyLinkInvestorRelation(); 
			log.info("Clicked on Investor Relations link at the footer");
			
		} else if ((map.get("LinkToClick")).contentEquals("TestimonialsAtFooter")) {
			
			HdrAndFtrLnk.clickCompanyLinkTestimonials();
			log.info("Clicked on Testimonials link at the footer");
			
		} else if ((map.get("LinkToClick")).contentEquals("CareersAtFooter")) {
			
			HdrAndFtrLnk.clickCompanyLinkCareers();
			log.info("Clicked on Careers link at the footer");
			
		} else if ((map.get("LinkToClick")).contentEquals("TermsOfServiceAtFooter")) {
			
			HdrAndFtrLnk.clickLegalLinkTermsOfService();
			log.info("Clicked on Terms of service link at the footer");
			
		} else if ((map.get("LinkToClick")).contentEquals("PrivacyNoticeAtFooter")) {
			
			HdrAndFtrLnk.clickLegalLinkPrivacyNotice();
			log.info("Clicked on Privacy Notice link at the footer");
			
		} else if ((map.get("LinkToClick")).contentEquals("SocialMediaLinkAtFooter")) {
			
			HdrAndFtrLnk.clickLegalLinkSocialMediaAndComm();
			log.info("Clicked on Social Media and Communication link at the footer");
			
		} else if ((map.get("LinkToClick")).contentEquals("AlDisclosureAtFooter")) {
			
			HdrAndFtrLnk.clickLegalLinkALDisclosure();
			log.info("Clicked on Alabama Disclosure link at the footer");
			
		} else if ((map.get("LinkToClick")).contentEquals("NMDisclosureAtFooter")) {
			
			HdrAndFtrLnk.clickLegalLinkNMDisclosure();
			log.info("Clicked on New Mexico Disclosure link at the footer");
			
		} else if ((map.get("LinkToClick")).contentEquals("SCDisclosureAtFooter")) {
			
			HdrAndFtrLnk.clickLegalLinkSCDisclosure();
			log.info("Clicked on South Carolina Disclosure link at the footer");
			
		} else if ((map.get("LinkToClick")).contentEquals("FAQAtFooter")) {
			
			HdrAndFtrLnk.clickAlsoSeeLinkFAQs();
			log.info("Clicked on FAQ's link at the footer");
			
		} else if ((map.get("LinkToClick")).contentEquals("AboutUsAtFooter")) {
			
			HdrAndFtrLnk.clickAlsoSeeLinkAboutUs();
			log.info("Clicked on About Us link at the footer");
			
		} else if ((map.get("LinkToClick")).contentEquals("LoansAtFooter")) {
			
			HdrAndFtrLnk.clickAlsoSeeLinkLoans();
			log.info("Clicked on Loans link at the footer");
			
		} else if ((map.get("LinkToClick")).contentEquals("TaxesAtFooter")) {
			
			HdrAndFtrLnk.clickAlsoSeeLinkTaxes();
			log.info("Clicked on Taxes link at the footer");
			
		} else if ((map.get("LinkToClick")).contentEquals("EducationAtFooter")) {
			
			HdrAndFtrLnk.clickAlsoSeeLinkEducation();
			log.info("Clicked on Education link at the footer");
			
		} else if ((map.get("LinkToClick")).contentEquals("BlogAtFooter")) {
			
			HdrAndFtrLnk.clickAlsoSeeLinkBlog();
			log.info("Clicked on Blog link at the footer");
			
		} else if ((map.get("LinkToClick")).contentEquals("RateAndTermsAtFooter")) {
			
			HdrAndFtrLnk.clickRateAndTermsLink();
			log.info("Clicked on Rate And Terms link at the footer");
			
		}
		
		HdrAndFtrLnk.verifyTheURLOpened(map.get("ExpectedURL"));

	}
	
	
	@Test(priority = 2, dataProvider = "FAHL_298", description = "click on logout link")
	public void clickLogout_FAHL_298(HashMap<String, String> map, ITestContext ctx, ITestResult rlt) throws InterruptedException, AWTException, IOException {
		
		SoftAssert softAssert = new SoftAssert();
		
		String dateAndTime = new SimpleDateFormat("yyyyMMddhhmmss").format(new Date());
		
		String instance = map.get("InstanceId");
				
		ctx.getCurrentXmlTest().addParameter( "InstanceId", instance);
		
		ctx.getCurrentXmlTest().addParameter( "Date", dateAndTime);
				
		log.info("In clickLogout_FAHL_298  ->  data is  " + map);
		
		log.info("*********************Start of  test " +map.get("TestCaseId")+ " **************************");
		
		if ((map.get("PageOnWhichToClick")).contentEquals("LoginPage")) {
			
		} else {
			
			lgnPge.login(map.get("Email"), map.get("Password"));
			boolean isDisplayed = acctPge.verifyAccountsPageIsDisplayed();
			
			if ((map.get("PageOnWhichToClick")).contentEquals("PaymentHistoryPage")) {
				acctPge.clickPaymentHistoryLink();
				log.info("clicked on payment history link");
			} else if ((map.get("PageOnWhichToClick")).contentEquals("SettingsPage")) {
				acctPge.clickSettingsLink();
				log.info("clicked on settings link");
			} else if ((map.get("PageOnWhichToClick")).contentEquals("LoanDetailsPage")) {
				acctPge.ClickViewLoanDetailsLink();
				log.info("clicked on view loan details link");
			}
		}
		
		HdrAndFtrLnk.clickLogout();
		
		boolean isDisplayed = lgnPge.verifyLoginScreenIsDisplayed();
		
		Assert.assertTrue(isDisplayed);

	}
	
	@Test(priority = 3, dataProvider = "FAHL_300", description = "Verify Branch Service Center Details")
	public void VerifyBranchServiceCenterDetails_FAHL_300(HashMap<String, String> map, ITestContext ctx, ITestResult rlt) throws InterruptedException, AWTException, IOException {
		
		SoftAssert softAssert = new SoftAssert();
		
		String dateAndTime = new SimpleDateFormat("yyyyMMddhhmmss").format(new Date());
		
		String instance = map.get("InstanceId");
				
		ctx.getCurrentXmlTest().addParameter( "InstanceId", instance);
		
		ctx.getCurrentXmlTest().addParameter( "Date", dateAndTime);
				
		log.info("In VerifyBranchServiceCenterDetails_FAHL_300  ->  data is  " + map);
		
		log.info("*********************Start of  test " +map.get("TestCaseId")+ " **************************");
		
		if ((map.get("PageOnWhichToClick")).contentEquals("LoginPage")) {
			
		} else {
			
			lgnPge.login(map.get("Email"), map.get("Password"));
			boolean isDisplayed = acctPge.verifyAccountsPageIsDisplayed();
			
			if ((map.get("PageOnWhichToClick")).contentEquals("PaymentHistoryPage")) {
				acctPge.clickPaymentHistoryLink();
				log.info("clicked on payment history link");
			} else if ((map.get("PageOnWhichToClick")).contentEquals("SettingsPage")) {
				acctPge.clickSettingsLink();
				log.info("clicked on settings link");
			} else if ((map.get("PageOnWhichToClick")).contentEquals("LoanDetailsPage")) {
				acctPge.ClickViewLoanDetailsLink();
				log.info("clicked on view loan details link");
			}
		}
		
		HdrAndFtrLnk.verifyPhoneTitle(map.get("Title"));
		
		HdrAndFtrLnk.verifyPhoneNumber(map.get("PhoneNumber"));
		
		HdrAndFtrLnk.verifyOfficeAddressAtFooter(map.get("Address"));

	}
	
	@Test(priority = 4, dataProvider = "FAHL_301", description = "Verify copy right message")
	public void VerifyCopyRightMessage_FAHL_301(HashMap<String, String> map, ITestContext ctx, ITestResult rlt) throws InterruptedException, AWTException, IOException {
		
		SoftAssert softAssert = new SoftAssert();
		
		String dateAndTime = new SimpleDateFormat("yyyyMMddhhmmss").format(new Date());
		
		String instance = map.get("InstanceId");
				
		ctx.getCurrentXmlTest().addParameter( "InstanceId", instance);
		
		ctx.getCurrentXmlTest().addParameter( "Date", dateAndTime);
				
		log.info("In VerifyCopyRightMessage_FAHL_301  ->  data is  " + map);
		
		log.info("*********************Start of  test " +map.get("TestCaseId")+ " **************************");
		
		if ((map.get("PageOnWhichToClick")).contentEquals("LoginPage")) {
			
		} else {
			
			lgnPge.login(map.get("Email"), map.get("Password"));
			boolean isDisplayed = acctPge.verifyAccountsPageIsDisplayed();
			
			if ((map.get("PageOnWhichToClick")).contentEquals("PaymentHistoryPage")) {
				acctPge.clickPaymentHistoryLink();
				log.info("clicked on payment history link");
			} else if ((map.get("PageOnWhichToClick")).contentEquals("SettingsPage")) {
				acctPge.clickSettingsLink();
				log.info("clicked on settings link");
			} else if ((map.get("PageOnWhichToClick")).contentEquals("LoanDetailsPage")) {
				acctPge.ClickViewLoanDetailsLink();
				log.info("clicked on view loan details link");
			}
		}
		
		HdrAndFtrLnk.verifyCopyRightMessage(map.get("CopyRightMessage"));

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
