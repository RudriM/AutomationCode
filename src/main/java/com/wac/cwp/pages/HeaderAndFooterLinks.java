package com.wac.cwp.pages;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

import com.wac.cwp.base.TestBase;
import com.wac.cwp.helper.Waits;

public class HeaderAndFooterLinks extends TestBase {
	
	@FindBy(xpath="//img[@alt='Company Logo']")
	WebElement companyLogoAtTop;
	
	@FindBy(xpath="//a[@class='site-footer-logo-wrapper']")
	WebElement companyLogoAtFooter;
	
	@FindBy(xpath="//span[text()='Help']")
	WebElement help;
	
	@FindBy(xpath="//h5[@class='site-footer-phone-title']")
	WebElement phoneTitleInFooter;
	
	@FindBy(xpath="//div[@class='site-footer-phone']")
	WebElement phoneNumberInFooter;
	
	@FindBy(xpath="//address[@class='site-footer-address']")
	WebElement footerAddress;
	
	@FindBy(xpath="//a[text()='Contact Us']")
	WebElement contactUsLink;
	
	@FindBy(xpath="//a[text()='Find a Branch']")
	WebElement findABranchLink;
	
	@FindBy(xpath="//a[text()='Investor Relations']")
	WebElement investorRelations;
	
	@FindBy(xpath="//a[text()='Testimonials']")
	WebElement testimonialsLink;
	
	@FindBy(xpath="//a[text()='Careers']")
	WebElement careersLink;
	
	@FindBy(xpath="//a[text()='Terms of Services']")
	WebElement termsLink;
	
	@FindBy(xpath="//a[text()='Privacy Notice']")
	WebElement privaceNoticeLink;
	
	@FindBy(xpath="//a[text()='Social Media Policy & Community Guidelines']")
	WebElement policyLink;
	
	@FindBy(xpath="//a[text()='Alabama Disclosures']")
	WebElement alabamaDisclosureLink;
	
	@FindBy(xpath="//a[text()='New Mexico Disclosures']")
	WebElement newMexicoDisclosureLink;
	
	@FindBy(xpath="//a[text()='South Carolina Disclosures']")
	WebElement sCDisclosureLink;
	
	@FindBy(xpath="//a[text()='FAQs']")
	WebElement faqsLink;
	
	@FindBy(xpath="//a[text()='About Us']")
	WebElement aboutUsLink;
	
	@FindBy(xpath="//a[text()='Loans']")
	WebElement loansLink;
	
	@FindBy(xpath="//a[text()='Taxes']")
	WebElement taxesLink;
	
	@FindBy(xpath="//a[text()='Education']")
	WebElement educationLink;
	
	@FindBy(xpath="//a[text()='Blog']")
	WebElement blogLink;
	
	@FindBy(xpath="//a[text()='Rates and Terms']")
	WebElement ratesAndTermsLink;
	
	@FindBy(xpath="//span[text()='LOG OUT']")
	WebElement logOut;
	
	@FindBy(xpath="//div[@class='site-footer-bottom-left']")
	WebElement copyRightMsg;
	
	
	public HeaderAndFooterLinks(){
		PageFactory.initElements(driver, this);
	}
	
	public void clickWorldFinanceLogoAtTopLeft() {
		companyLogoAtTop.click();
		log.info("Clicked on the company logo at top left corner");
	}
	
	public void clickHelpLink() {
		help.click();
		log.info("Clicked on the help link at top right corner");

	}
	
	public void verifyPhoneTitle(String expectedTitle) {
		Waits.explicitWaitForElementVisible(phoneTitleInFooter);
		String actualTitle = phoneTitleInFooter.getText();
		log.info("The actual title of phone number in the footer is : " +actualTitle);
		log.info("The expected title of phone number in the footer is : " +expectedTitle);
		Assert.assertEquals(actualTitle, expectedTitle, "The actual phone number title is different from expected");

	}
	
	public void verifyPhoneNumber(String expectedPhneNum) {
		Waits.explicitWaitForElementVisible(phoneNumberInFooter);
		String actualPhneNum = phoneNumberInFooter.getText();
		log.info("The actual phone number in the footer is : " +actualPhneNum);
		log.info("The expected phone number in the footer is : " +expectedPhneNum);
		Assert.assertEquals(actualPhneNum, expectedPhneNum, "The actual phone number is different from expected");
		
	}
	
	public void verifyOfficeAddressAtFooter(String address) {
		Waits.explicitWaitForElementVisible(footerAddress);
		String actualAddress = footerAddress.getText();
		log.info("The actual address in the footer is : " +actualAddress);
		log.info("The expected address in the footer is : " +address);
		Assert.assertEquals(actualAddress, address, "The actual address is different from expected");
	}
	
	public void verifyCopyRightMessage(String cpyRightMsg) {
		Waits.explicitWaitForElementVisible(copyRightMsg);
		String actualCpyRgtMsg = copyRightMsg.getText();
		log.info("The actual address in the footer is : " +actualCpyRgtMsg);
		log.info("The expected address in the footer is : " +cpyRightMsg);
		Assert.assertEquals(actualCpyRgtMsg, cpyRightMsg, "The copy right message is different from expected");
	}
	
	public void clickCompanyLinkContactUs() {
		
		contactUsLink.click();
		log.info("Clicked on the footer link : Contact Us");

	}
	
	public void clickCompanyLinkFindABranch() {
		
		findABranchLink.click();
		log.info("Clicked on the footer link: Find A Branch");
		
	}
	
	public void clickComapnyLinkInvestorRelation() {
		
		investorRelations.click();
		log.info("Clicked on the footer link: Investor Relation");
		
	}
	
	public void clickCompanyLinkTestimonials() {
		
		testimonialsLink.click();
		log.info("Clicked on the footer link: Testimonials");
		
	}
	
	public void clickCompanyLinkCareers() {
		
		careersLink.click();
		log.info("Clicked on the footer link: Careers");
		
	}
	
	public void clickLegalLinkTermsOfService() {
		
		termsLink.click();
		log.info("Clicked on the footer link: Terms Of Service");
		
	}
	
	public void clickLegalLinkPrivacyNotice() {
		
		privaceNoticeLink.click();
		log.info("Clicked on the footer link: Privacy Notice");
		
	}
	
	public void clickLegalLinkSocialMediaAndComm() {
		
		policyLink.click();
		log.info("Clicked on the footer link: Social Media Policy & Community Guidelines");
		
	}
	
	
	public void clickLegalLinkALDisclosure() {
			
		alabamaDisclosureLink.click();
		log.info("Clicked on the footer link: Alabama Disclosures");
	}
	
	public void clickLegalLinkNMDisclosure() {
		
		newMexicoDisclosureLink.click();
		log.info("Clicked on the footer link: New Mexico Disclosures");
		
	}
	
	public void clickLegalLinkSCDisclosure() {
		
		sCDisclosureLink.click();
		log.info("Clicked on the footer link: South Carolina Disclosures");
		
	}
	
	public void clickAlsoSeeLinkFAQs() {
		
		faqsLink.click();
		log.info("Clicked on the footer link: FAQs");
		
	}
	
	public void clickAlsoSeeLinkAboutUs() {
		
		aboutUsLink.click();
		log.info("Clicked on the footer link: About Us");
		
	}
	
	public void clickAlsoSeeLinkLoans() {
		
		loansLink.click();
		log.info("Clicked on the footer link: Loans");
		
	}
	
	public void clickAlsoSeeLinkTaxes() {
		
		taxesLink.click();
		log.info("Clicked on the footer link: Taxes");
		
	}
	
	public void clickAlsoSeeLinkEducation() {
		
		educationLink.click();
		log.info("Clicked on the footer link: Education");
		
	}
	
	public void clickAlsoSeeLinkBlog() {
		
		blogLink.click();
		log.info("Clicked on the footer link: Blog");
		
	}
	
	public void clickRateAndTermsLink() {
		ratesAndTermsLink.click();
		log.info("Clicked on the footer link: Rates and Terms");
	}
	
	public void clickCompanyLogoAtFooter() {
		companyLogoAtFooter.click();
		log.info("Clicked on the World Finance logo at the footer");
	}
	
	public void clickLogout() {
		logOut.click();
		log.info("Clicked on the logout link at the header");
	}

	public void verifyTheURLOpened(String expectedURL) {
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
		String actualUrl = driver.getCurrentUrl();
		expectedURL = expectedURL.trim();
		log.info("The actual url opened is : " +actualUrl);
		log.info("The expected url to open is : " +expectedURL);
		Assert.assertEquals(actualUrl, expectedURL, "The actual URL opened is different from expected");
	}
}
