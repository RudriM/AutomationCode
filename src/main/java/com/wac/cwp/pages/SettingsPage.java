package com.wac.cwp.pages;

import java.util.HashMap;
import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.asserts.SoftAssert;

import com.wac.cwp.base.TestBase;
import com.wac.cwp.helper.Waits;


public class SettingsPage extends TestBase{

	@FindBy(xpath = "//a[@class = 'menuItem']/span[text()='SETTINGS']")
	WebElement settingLink;
	
	@FindBy(xpath = "//div[text() = 'Settings']")
	WebElement settingHeading;
	
	@FindBy(xpath = "//div[@class = 'card-settings-header profile-card card-header']")
	WebElement profileCard;
	
	@FindBy(xpath = "//div[@class = 'card-settings-header-single card-header']")
	WebElement accountCard;
	
	@FindBy(xpath = "//div[@class = 'autopay-card-header card-header']")
	WebElement recurringCard;
	
	@FindBy(xpath = "//div[@class = 'settingsCardName ']")
	WebElement profileCardName;
	
	@FindBy(xpath = "//div[text() = 'Address']/following-sibling :: div")
	WebElement profileCardAddress;

	@FindBy(xpath = "(//*[local-name() ='svg'])[3]")
	WebElement profileToolkitIcon;
	
	@FindBy(xpath = "//div[text() = 'Email Address']/following-sibling :: div")
	WebElement accountCardEmail;
	
	@FindBy(xpath = "//div[text() = 'Mobile Phone Number']/following-sibling :: div")
	WebElement accountCardPhone;
	
	@FindBy(xpath = "(//*[local-name() ='svg'])[4]")
	WebElement accoountToolkitIcon;
	
	@FindBy(xpath = "//button[@class = 'btnSecondary btnAddBank']")
	List<WebElement> recurringBtn;
	
	@FindBy(xpath = "//a[@class = 'linkHideUnderlineHover loanLink']")
	List<WebElement> noOfLoan;
	
	@FindBy(xpath = "//a[@class = 'linkHideUnderlineHover loanLink']")
	List<WebElement> recurringLoanNo;
	
	@FindBy(xpath = "//div[@class = 'modal-dialog paymentModal modal-lg modal-dialog-centered modal-dialog-scrollable']")
	WebElement recurringModalWindow;
	
	@FindBy(xpath = "//div[text()= 'Set Up Recurring Payments']")
	WebElement recurringHeading;
	
	@FindBy(xpath = "//input[@id = 'autoPayDate']")
	WebElement dateToBeginRecurring;
	
	@FindBy(xpath = "//input[@id='cardNumber']")
	WebElement recurringCardNumber;
	
	@FindBy(xpath = "//input[@id='expiration']")
	WebElement recurringExpiryDate;
	
	@FindBy(xpath = "//input[@id='cvv']")
	WebElement recurringCvv;
	
	@FindBy(xpath = "//button[text()='Save']")
	WebElement saveRecurring;
	
	@FindBy(xpath = "//div/button[@id='manage-autopay-menu-button']")
	WebElement manageRecurringButton;
	
	@FindBy(xpath = "//li[text() = 'Recurring payment settings']")
	WebElement recurringSetting;
	
	@FindBy(xpath = "//li[text() = 'Stop recurring payments']")
	WebElement stopRecurringPayment;
	
	@FindBy(xpath = "//p[@class = 'autopay-monthlyPayment-amount']")
	List<WebElement> monthlyAmount;
	
	@FindBy(xpath = "//*[contains(text(), 'Next Payment scheduled for')]")
	List<WebElement> nextPayment;
	
	@FindBy(xpath = "//div/span[@class ='small-subText']/span")
	List<WebElement> remainingPayments;
	
	@FindBy(xpath = "//div[@id ='method']")
	WebElement methodDropdown;
	
	@FindBy(xpath = "//li[text() ='Other']")
	WebElement Other;
	
	@FindBy(xpath = "//div[@class = 'modal-dialog paymentModal modal-lg modal-dialog-centered']/div[@class = 'modal-content']")
	WebElement stopRecurringModal;
	
	@FindBy(xpath = "//div[text() = 'Stop recurring payments']")
	WebElement stopRecurringModalHeading;
	
	@FindBy(xpath = "//*[contains(text(),'You are about to stop recurring payments for loan')]")
	WebElement stopRecurringBody;
	
	@FindBy(xpath = "//button[text() = 'Never Mind']")
	WebElement neverMindButton;
	
	@FindBy(xpath = "//button[text() = 'Stop Payments']")
	WebElement stopRecurringButton;
	 
	public SettingsPage() {
		PageFactory.initElements(driver, this);
	}
	
	public SettingsPage clickSettingsPageLink() {
		settingLink.click();
		log.info("Clicked on Settings Link");
		Waits.explicitWaitForElementVisible(settingHeading);

		return new SettingsPage();
	}
	
	public boolean isDisplaySettingsPage() {
		Waits.explicitWaitForElementVisible(settingHeading);
		boolean heading = settingHeading.isDisplayed();
		return heading;
	}
	
	public boolean isDisplayedProfileCard() {
		Waits.explicitWaitForElementVisible(profileCard);
		boolean proCard = profileCard.isDisplayed();
		return proCard;
	}
	
	public boolean isDisplayedAccountCard() {
		Waits.explicitWaitForElementVisible(accountCard);
		boolean accCard = accountCard.isDisplayed();
		return accCard;
	}
	
	public boolean isDisplayedRecurringCard() {
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		boolean recCard = recurringCard.isDisplayed();
		return recCard;
	}
	
	public boolean isDisplayedProfileToolkit() {
		Waits.explicitWaitForElementVisible(profileCard);
		SoftAssert softAssert = new SoftAssert();
		Actions a = new Actions(driver);
		a.moveToElement(profileToolkitIcon).perform();
		driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
		boolean profileToolkitMessage = profileToolkitIcon.isDisplayed();
		log.info("Profile toolkit message is displayed? " +profileToolkitMessage);
		softAssert.assertTrue(profileToolkitMessage);
		return profileToolkitMessage;
		
	}
	
	public boolean isDisplayedAccountToolkit() {
		Waits.explicitWaitForElementVisible(accountCard);
		SoftAssert softAssert = new SoftAssert();
		Actions a = new Actions(driver);
		a.moveToElement(accoountToolkitIcon).perform();
		driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
		boolean accountToolkitMessage = accoountToolkitIcon.isDisplayed();
		log.info("Account toolkit message is displayed? " +accountToolkitMessage);
		softAssert.assertTrue(accountToolkitMessage);
		return accountToolkitMessage;
	}
	
	public void verifyProfileDetails(HashMap<String, String> map) {

		Waits.explicitWaitForElementVisible(settingHeading);
		
		SoftAssert softAssert = new SoftAssert();
		settingLink.click();
		String name = profileCardName.getText();
		log.info("Customer full name is: " +name);
		
		String address = profileCardAddress.getText();
		log.info("Customer Address is: " +address);
		
		softAssert.assertEquals(name, map.get("FullName"), "Actual name is different from expected");
		softAssert.assertEquals(address, map.get("Addresss"), "Actual address is different from expected");
		
		softAssert.assertAll();
	}
	
	public void verifyAccountDetails(HashMap<String, String> map) {

		Waits.explicitWaitForElementVisible(settingHeading);
		
		SoftAssert softAssert = new SoftAssert();
		settingLink.click();

		String email = accountCardEmail.getText();
		log.info("Customer full name is: " +email);
		
		String phoneNumber = accountCardPhone.getText();
		log.info("Customer Address is: " +phoneNumber);
		
		softAssert.assertEquals(email, map.get("AccountEmail"), "Actual email is different from expected");
		softAssert.assertEquals(phoneNumber, map.get("AccountPhone"), "Actual phone is different from expected");
		
		softAssert.assertAll();
	}
	
	public void verifyRecurringCardForMoreLoan(HashMap<String, String> map) {
		Waits.explicitWaitForElementVisible(recurringCard);

		SoftAssert softAssert = new SoftAssert();

		int noOfLoanCount = noOfLoan.size();
		log.info("No of loans listed are: " +noOfLoanCount);
		log.info("Expected Loans listed are: " +map.get("NoOfLoans"));
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		for(int i = 0; i < noOfLoanCount; i++) {

			WebElement recLoan = recurringLoanNo.get(i);
			String recLoanNo = recLoan.getText();
			log.info("The actual loan number is: "+recLoanNo);
			log.info("The expected loan number is: "+map.get("RecurringLoanNumber"+i));
			softAssert.assertEquals(recLoanNo, map.get("RecurringLoanNumber"+i), "Actual and Expected loan number does not match");
			
			WebElement recurringButton = recurringBtn.get(i);
			boolean isDisplay = recurringButton.isDisplayed();
			log.info("Is recurring button is displayed? " +isDisplay);
			softAssert.assertTrue(isDisplay);
		}
	}
	
	public void setUpRecurring(HashMap<String, String> map) throws InterruptedException {
		SoftAssert softAssert = new SoftAssert();
		
		settingLink.click();
		Waits.explicitWaitForElementVisible(recurringCard);
		int noOfRecurringBrn = recurringBtn.size();
		for(int i = 0; i< noOfRecurringBrn ; i++) {
		recurringBtn.get(i).click();
		
		String recurringPayDate = dateToBeginRecurring.getText();
		log.info("Today's date is displayed: " +recurringPayDate);
		
		dateToBeginRecurring.sendKeys(map.get("PaymentDate"));
		log.info("Specified date is"  +map.get("PaymentDate"));
		
		recurringCardNumber.sendKeys(map.get("CardNumber"));
		log.info("Specified card number is"  +map.get("CardNumber"));
		
		recurringExpiryDate.sendKeys(map.get("ExpiryDate"));
		log.info("Specified expiry date is"  +map.get("ExpiryDate"));
		
		recurringCvv.sendKeys(map.get("CVV"));
		log.info("Specified CVV number is"  +map.get("CVV"));
		saveRecurring.click();	
		}
	}
	
	public void verifyManageRecurringButton(HashMap<String, String> map) {
		Waits.explicitWaitForElementVisible(recurringCard);
		SoftAssert softAssert = new SoftAssert();		

		clickSettingsPageLink();
		
		manageRecurringButton.click();
		
		boolean setUpRecurring = recurringSetting.isDisplayed();
		log.info("Reccuring setting option is available - "+setUpRecurring);
		
		boolean stopRecurring = stopRecurringPayment.isDisplayed();
		log.info("Stop Reccuring option is available - "+stopRecurring);
		
		softAssert.assertTrue(setUpRecurring, "Recurring setting option is not available");
		softAssert.assertTrue(stopRecurring, "Stop recurring option is not available");
	}
	
	public void manageRecurringDetails(HashMap<String, String> map) {
		Waits.explicitWaitForElementVisible(recurringCard);
		SoftAssert softAssert = new SoftAssert();
		
		clickSettingsPageLink();
		int noOfLoan = recurringLoanNo.size();

		for (int i =0; i<noOfLoan; i++) {
			String loanText = recurringLoanNo.get(i).getText();
			log.info("Loan number is: " +loanText);
			
			String loanAmount = monthlyAmount.get(i).getText();
			log.info("Loan amount: " +loanAmount);
			
			String paymentSchedule = nextPayment.get(i).getText();
			log.info("Next payment Schedule is: " +paymentSchedule);
			
			String remainingPay = remainingPayments.get(i).getText();
			log.info("Remaining payments are: " +remainingPay);

			softAssert.assertEquals(loanText, map.get("LoanNumber"), "Actual loan number is different from expected");
			softAssert.assertEquals(loanAmount, map.get("MonthlyAmount"), "Actual Amount is different from expected");
			softAssert.assertEquals(paymentSchedule, map.get("NextPaymentsAndMethods"), "Actual next schedule payment is different from expected");
			softAssert.assertEquals(remainingPay, map.get("RemainingPayments"), "Actual remaining payments are different from expected");
		}
		
	}
	
	public void changeRecurringPayment(HashMap<String, String> map) {
		Waits.explicitWaitForElementVisible(recurringCard);
		SoftAssert softAssert = new SoftAssert();		

		clickSettingsPageLink();
		
		manageRecurringButton.click();
		recurringSetting.click();
		
		dateToBeginRecurring.sendKeys(map.get("PaymentDate"));
		log.info("Specified date is"  +map.get("PaymentDate"));
		
		methodDropdown.click();
		Other.click();
		
		recurringCardNumber.sendKeys(map.get("CardNumber"));
		log.info("Specified card number is"  +map.get("CardNumber"));
		
		recurringExpiryDate.sendKeys(map.get("ExpiryDate"));
		log.info("Specified expiry date is"  +map.get("ExpiryDate"));
		
		recurringCvv.sendKeys(map.get("CVV"));
		log.info("Specified CVV number is"  +map.get("CVV"));
		saveRecurring.click();	
		}
	
	public void verifyStopRecurringPopUp(HashMap<String, String> map) throws InterruptedException {
		SoftAssert softAssert = new SoftAssert();
		
		Waits.explicitWaitForElementVisible(recurringCard);
		clickSettingsPageLink();
		
		Waits.explicitWaitForElementVisible(manageRecurringButton);
		manageRecurringButton.click();
		
		stopRecurringPayment.click();
		Waits.explicitWaitForElementVisible(stopRecurringModalHeading);
		
		String modalBodyText = stopRecurringBody.getText();
		log.info("Modal body text is: " +modalBodyText);
		
		boolean modalNeverMindBtn = neverMindButton.isDisplayed();
		log.info("Is never mind button is displayed? " +modalNeverMindBtn);
		
		boolean modalStopBtn = stopRecurringButton.isDisplayed();
		log.info("Is never mind button is displayed? " +modalStopBtn);
		
		softAssert.assertEquals(modalBodyText, map.get("stopRecurringBody"), "Actual text is different from expected");
		softAssert.assertTrue(modalNeverMindBtn, "Never mind button is not available.");
		softAssert.assertTrue(modalStopBtn, "Stop payments button is not available.");
		
		softAssert.assertAll();
	}
	
	public LoanDetailsPage ClickLoanDetailsLink() {
		Waits.explicitWaitForElementVisible(recurringCard);
		settingLink.click();
		int noofLoans = recurringLoanNo.size();
			for(int i = 0; i< noofLoans; i++) {
				recurringLoanNo.get(i).click();
				log.info("Clicked on Loan  Link");
			}
				return new LoanDetailsPage();
			
	}
}

