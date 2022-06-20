package com.wac.cwp.pages;

import static org.testng.Assert.assertEquals;

import java.util.HashMap;
import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;
import org.testng.asserts.SoftAssert;

import com.wac.cwp.base.TestBase;
import com.wac.cwp.helper.Waits;


public class LoanDetailsPage extends TestBase {
	
	@FindBy(xpath = "//div[@class='card-body'] //a[@class='linkHideUnderlineHover']")
	WebElement viewLoanDetailsLink;
	
	@FindBy(xpath = "//a[contains(text(),'Loan #')]")
	WebElement loanNumber;
	
	@FindBy(xpath = "//div[@class='card-body']")
	WebElement loanCard;

	@FindBy(xpath = "//div[text()='Payment History']/following::div")
	WebElement paymentHistorySection;
	
	@FindBy(xpath = "//div[text() = 'Branch']/following::div")
	WebElement branchSection;

	//------------------------------Loan Details Card for Due date not passed-------------------------------------------
	@FindBy(xpath = "//p[text()='Next payment due in']/following::p[1]")
	WebElement noOfDaysforNextPayment;
	
	@FindBy(xpath = "//p[text()='Next payment due in']/following::p[2]")
	WebElement nextpaymentDueDate;
	
	@FindBy(xpath = "//p[text()='Amount']/following::p[1]")
	WebElement nextpaymentAmount;
	
	@FindBy(xpath = "//button[text() = 'Make a Payment']")
	WebElement makepaymentButton;
	
	@FindBy(xpath = "//button[text()='Set Up Recurring Payments']")
	WebElement setUpRecurringBtn;
	
	//----------------------------Loan Details card for Due date passed------------------------------------------------
	@FindBy(xpath = "//p[text() = 'Your payment was due']/following::p[1]")
	WebElement noOfDaysforNextPayment2;
	
	@FindBy(xpath = "//p[text()='Your payment was due']/following::p[2]")
	WebElement nextpaymentDueDate2;
	
	@FindBy(xpath = "//p[text()='Amount']/following::p[1]")
	WebElement nextpaymentAmount2;
	
	@FindBy(xpath = "//button[text() = 'Make a Payment']")
	WebElement makepaymentButton2;
	
	//--------------------------------Recurring Payment Section--------------------------------------------------------
	
	@FindBy(xpath = "//div[text() = 'Set Up Recurring Payments']")
	WebElement recurringPaymentModal;
	
	@FindBy(xpath = "//div/button[@id='manage-autopay-menu-button']")
	WebElement manageRecurringButton;
	
	@FindBy(xpath = "//li[text() = 'Recurring payment settings']")
	WebElement recurringSetting;
	
	@FindBy(xpath = "//li[text() = 'Stop recurring payments']")
	WebElement stopRecurringPayment;
	
	@FindBy(xpath = "//*[contains(text(), 'Your next recurring payment of')]")
	WebElement manageRecurringMessage;
	
	@FindBy(xpath = "//div/span[@class ='small-subText'][1]")
	WebElement paymentFrequency;
	
	@FindBy(xpath = "//div/span[@class ='small-subText'][2]")
	WebElement remainingPayments;
	
	//---------------------------------------Set Up recurring popUp----------------------------------------------------
	
	@FindBy(xpath = "//div[@class = 'modal-dialog paymentModal modal-lg modal-dialog-centered modal-dialog-scrollable']")
	WebElement recurringModalWindow;
	
	@FindBy(xpath = "//div[text()= 'Recurring payment settings']")
	WebElement recurrinfPaymentHeading;
	
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
	
	//---------------------------------------Stop Recurring modal------------------------------------------------------
	
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
	
	//-------------------------------------Loan Details----------------------------------------------------------------
	@FindBy(xpath = "//p[text()= 'Current balance']/following-sibling::p/span")
	WebElement currnetBalance;
	
	@FindBy(xpath = "//p[text()= 'Loan Amount']/following-sibling::p/span")
	WebElement loanAmount;
	
	@FindBy(xpath = "//p[text()= 'Borrower']/following-sibling::p")
	WebElement borrowerName;
	
	@FindBy(xpath = "//p[text()= 'Start Date']/following-sibling::p")
	WebElement loanStartDate;
	
	@FindBy(xpath = "//p[text()= 'Term Length']/following-sibling::p")
	WebElement termLength;
	
	//---------------------------------------Payment History section----------------------------------------------------
	@FindBy(xpath = "//div[text()='Payment History']")
	WebElement paymentHistorySectionHeading;
	
	@FindBy(xpath = "//div[text()='Payment History']/following-sibling::div//h6")
	List<WebElement> paymentHistoryDate;
	
	@FindBy(xpath = "//div[text()='Payment History']/following-sibling::div//p[contains(text() , 'Paid online via')]")
	List<WebElement> paymentHistoryPayMethod;
	
	@FindBy(xpath = "//div[text()='Payment History']/following-sibling::div//h6//span")
	List<WebElement> paymentHistoryPayStatus;
	
	@FindBy(xpath = "//div[text() = 'Payment History']/following-sibling::div/div/div/div[1]/div[2]")
	List<WebElement> paymentHistoryAmount;
	
	@FindBy(linkText = "View all")
	WebElement paymentHistoryViewAll;
	
	//--------------------------------------------Toolkit message -----------------------------------------------------
	@FindBy(xpath = "(//*[local-name() ='svg'])[5]")
	WebElement paymentCardToolkitIcon;
	
	@FindBy(id="overdueIcon")
	WebElement paymentCardOverdueToolkitMessage;
	
	@FindBy(xpath = "(//*[local-name() ='svg'])[4]")
	WebElement loanLastUpdateToolkitIcon;
	
	@FindBy(id = "dataUpdate")
	WebElement loanLastUpdatedToolkitIconMessgae;
	
	//------------------------------------------Make a payment Modal Window--------------------------------------------
	@FindBy(xpath = "//button[text()='Make a Payment']")
	WebElement makePaymentBtn;
		
	@FindBy(xpath = "//div[@class='modal-dialog paymentModal modal-lg modal-dialog-centered modal-dialog-scrollable']")
	WebElement makePaymentmodalWindowOpen;
			
	@FindBy(xpath = "//div[@class='modal-title h4']")
	WebElement modalHeader;
			
	@FindBy(xpath="//input[@id='paymentDate']")
    WebElement modalPaymentDate;
		
	@FindBy(xpath = "//div[@id='select_payment_amount']")
	WebElement openSelectPaymentDropDown;
		
	@FindBy(xpath = "//ul[@Class='MuiList-root MuiList-padding MuiMenu-list css-r8u8y9']/li[1]")
	WebElement chooseAmount;
		 
	@FindBy(xpath = "//p[text()='Amount']/following::p[1]")
	WebElement loanDetailAmount;
		
	@FindBy(xpath = "//div[@id= 'method']")
	WebElement selectMethod;
		
	@FindBy(xpath = "//input[@id = 'cardNumber']")
	WebElement creditCardNumber;
		
	@FindBy(xpath = "//input[@id = 'expiration']")
	WebElement expDate;
		
	@FindBy(xpath = "//input[@id = 'cvv']")
	WebElement cvvNumber;
		
	@FindBy(xpath = "//button[text() = 'Continue']")
	WebElement continuePaymentBtn;
		
	@FindBy(xpath = "//button[@id='payButton']")
	WebElement payNowBtn;
	
	public LoanDetailsPage(){
		PageFactory.initElements(driver, this);
	}
	
	//Click on view details link
	public LoanDetailsPage clickViewDetailsLink() {
		viewLoanDetailsLink.click();
		return new LoanDetailsPage();
	}
	
	//Verify Loan Number
	public boolean isDisplayedLoanNumber() {
		Waits.explicitWaitForElementVisible(loanNumber);
		boolean isdisplayed = loanNumber.isDisplayed();
		return isdisplayed;
	}
	
	//Verify Payment due details cards section
	public boolean isDisplayedPaymentDueDetailsCard() {
		Waits.explicitWaitForElementVisible(loanCard);
		boolean isDisplayed = loanCard.isDisplayed();
		return isDisplayed;
	}
	
	//Verify Payment History Section
	public boolean isDisplayedPaymentHistorySection() {
		Waits.explicitWaitForElementVisible(paymentHistorySectionHeading);
		boolean isPaymentHistorySection = paymentHistorySectionHeading.isDisplayed();
		return isPaymentHistorySection;	
	}
	
	//View all link is displayed
	public boolean verifyViewAllLinkIsDisplayed() {
		Waits.explicitWaitForElementVisible(paymentHistoryViewAll);
		boolean isDisplayed = paymentHistoryViewAll.isDisplayed();
		return isDisplayed;
	}
	
	//Verify Branch section is displayed 
	public boolean isDisplayedBranchSection() {
		Waits.explicitWaitForElementVisible(branchSection);
		boolean isDisplayed = branchSection.isDisplayed();
		return isDisplayed;
	}

	//Verify Loan Last Updated Toolkit message
	public boolean isDisplayedLoanDataToolkit() {
		SoftAssert softAssert = new SoftAssert();
		Actions a = new Actions(driver);
		a.moveToElement(loanLastUpdateToolkitIcon).perform();
		boolean loanUpdateToolkitMessage = loanLastUpdatedToolkitIconMessgae.isDisplayed();
		softAssert.assertTrue(loanUpdateToolkitMessage);
		return loanUpdateToolkitMessage;
	}
	
	//Verify Payment card Toolkit message
	public boolean isDisplayedPaymentCardToolkit() {
		SoftAssert softAssert = new SoftAssert();
		Actions a = new Actions(driver);
		a.moveToElement(paymentCardToolkitIcon).perform();
		boolean paymentToolkitMessage = paymentCardOverdueToolkitMessage.isDisplayed();
		softAssert.assertTrue(paymentToolkitMessage);
		return paymentToolkitMessage;
	}
	
	//Verify Setup Recurring Payments button is displayed
	public boolean isDisplayedSetUpRecurringButton() {
		Waits.explicitWaitForElementVisible(setUpRecurringBtn);
		boolean setupRecurringBtn = setUpRecurringBtn.isDisplayed();
		return setupRecurringBtn;
	}
	
	//Verify Manage Recurring payments button is displayed 
	public boolean isDisplayedManageRecurringButton() {
		boolean manageRecurringBtn = manageRecurringButton.isDisplayed();
		return manageRecurringBtn;
	}
	
	//verify SetUp recurring modal
	public boolean isDisplayedSetUpRecurringModal() {
		boolean setupRecurringModal = recurringModalWindow.isDisplayed();
		return setupRecurringModal;
	}
			
	public void verifyPaymentDueCardDetailsForDueDateNotPassed(HashMap<String, String> map) {
		
		SoftAssert softAssert = new SoftAssert();
		Waits.explicitWaitForElementVisible(loanCard);

		clickViewDetailsLink();
		String noOfDaysForNextpayment = noOfDaysforNextPayment.getText();
		log.info("Number of days for next payment is: " +noOfDaysForNextpayment);
		
		String paymentDueDate = nextpaymentDueDate.getText();
		log.info("Payment Due Date is: " +paymentDueDate);
		
		String paymentAmount = nextpaymentAmount.getText();
		log.info("Next Payment Amount is:" +paymentAmount);
		
		boolean isMakepaymentbuttonVisible = makepaymentButton.isDisplayed();
		log.info("Is Make a payment button is display? " +isMakepaymentbuttonVisible);
		
    	boolean isRecurrigPaymentbuttonVisible = isDisplayedSetUpRecurringButton();
    	log.info("Is Recurring payment button is display? " +isRecurrigPaymentbuttonVisible);
		
		softAssert.assertEquals(noOfDaysForNextpayment, map.get("noOfDaysforNextPayment"), "Actual value is different from expected");
		softAssert.assertEquals(paymentDueDate, map.get("nextpaymentDueDate"), "Actual date is different from expected");
		softAssert.assertEquals(paymentAmount, map.get("nextpaymentAmount"), "Payment Amount is different from expected");
		softAssert.assertTrue(isMakepaymentbuttonVisible, "Make a payment button is not displayed");
		softAssert.assertTrue(isRecurrigPaymentbuttonVisible, "Set a Recurring payment button is not displayed");
	
		softAssert.assertAll();
	}
	
	public void verifyPaymentDueCardDetailsForDueDatePassed(HashMap<String, String> map) {
		Waits.explicitWaitForElementVisible(loanCard);
		SoftAssert softAssert = new SoftAssert();
		
		clickViewDetailsLink();
		String noOfDaysForNextpayment2 = noOfDaysforNextPayment2.getText();
		log.info("Number of days for next payment is: " +noOfDaysforNextPayment2);
		
		String paymentDueDate2 = nextpaymentDueDate2.getText();
		log.info("Payment Due Date is: " +paymentDueDate2);
		
		String paymentAmount2 = nextpaymentAmount2.getText();
		log.info("Next Payment Amount is:" +paymentAmount2);
		
		boolean isMakepaymentbuttonVisible2 = makepaymentButton2.isDisplayed();
		log.info("Is Make a payment button is display? " +isMakepaymentbuttonVisible2);
		
		softAssert.assertEquals(noOfDaysForNextpayment2, map.get("noOfDaysforNextPayment"), "Actual value is different from expected");
		softAssert.assertEquals(paymentDueDate2, map.get("nextpaymentDueDate"), "Actual date is different from expected");
		softAssert.assertEquals(paymentAmount2, map.get("nextpaymentAmount"), "Payment Amount is different from expected");
		softAssert.assertTrue(isMakepaymentbuttonVisible2, "Make a payment button is not displayed");
		//softAssert.assertEquals(isRecurrigPaymentbuttonVisible2, "Set a Recurring payment button is not displayed and disabled");
		
		softAssert.assertAll();

	}
	
	//Verify loan Details Card
	public void verifyLoanDetailsCard(HashMap<String, String> map) {
		Waits.explicitWaitForElementVisible(currnetBalance);
		SoftAssert softAssert = new SoftAssert();
		clickViewDetailsLink();
		
		String currentLoanBal = currnetBalance.getText();
		log.info("Current loan balance is: " +currentLoanBal);
		
		String loanCardAmount = loanAmount.getText();
		log.info("Loan amount on Loan details card is: " +loanCardAmount);
		
		String borrorwerFullName = borrowerName.getText();
		log.info("Borrower full Name is: " +borrorwerFullName);
		
		String loanDate = loanStartDate.getText();
		log.info("Loan Start Date is: " +loanDate);
		
		String term = termLength.getText();
		log.info("Loan Term legth is: " +term);
		
		softAssert.assertEquals(currentLoanBal, map.get("currnetBalance"), "Actual value is different from expected");
		softAssert.assertEquals(loanCardAmount, map.get("loanAmount"), "Actual amount is different from expected");
		softAssert.assertEquals(borrorwerFullName, map.get("borrowerName"), "Borrower name is different from expected");
		softAssert.assertEquals(loanDate, map.get("loanStartDate"), "Loan start date is different from expected");
		softAssert.assertEquals(term, map.get("termLength"), "Term length is different from expected");
		
		softAssert.assertAll();
		
	}
		
	public void verifyPayementHistoryDetails(HashMap<String, String> map) {
		
		Waits.explicitWaitForElementVisible(viewLoanDetailsLink);
		viewLoanDetailsLink.click();
		SoftAssert softAssert = new SoftAssert();
		Waits.explicitWaitForElementVisible(paymentHistorySectionHeading);

		int numOfRecPayments = paymentHistoryDate.size();
		log.info("No of Recent Payments listed are: " +numOfRecPayments);
		log.info("Expected number of recent payments are: " +map.get("NumOfRecentPayments"));
		
		for (int i = 0 ; i <= numOfRecPayments - 1 ; i++) {
			
			driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
			WebElement paymentDateHistory =  paymentHistoryDate.get(i);
			String paymentHDate = paymentDateHistory.getText();
			log.info("The actual Payment date is: " +paymentHDate);
			log.info("The expected Payment History Date is: " +map.get("PaymentDateAndStatus"+i));
			softAssert.assertEquals(paymentHDate, map.get("PaymentDateAndStatus"+i), "Actual and Expected Payment Date does not match");

			WebElement paymentMethod = paymentHistoryPayMethod.get(i);
			String payHMethod= paymentMethod.getText();
			log.info("The actual payment Method is: "+payHMethod);
			log.info("The expected payment Method is: "+map.get("payMethod"+i));
			softAssert.assertEquals(payHMethod, map.get("payMethod"+i), "Actual and Expected Payment Method does not match");			
			
			WebElement paymentHistoryPayAmount = paymentHistoryAmount.get(i);
			String payHAmount = paymentHistoryPayAmount.getText();
			log.info("The actual payment Amount is: "+payHAmount);
			log.info("The expected payment Amount is: "+map.get("payAmount"+i));
			softAssert.assertEquals(payHAmount, map.get("payAmount"+i), "Actual and Expected Payment Amount does not match");
	
		}
		boolean isDisplayed = paymentHistoryViewAll.isDisplayed();
		log.info("View all link is displayed? " +isDisplayed);
		
		softAssert.assertAll();
	}
	
	public PaymentHistoryPage clickViewAll() {
		paymentHistoryViewAll.click();
		log.info("Clicked on View all link");
		return new PaymentHistoryPage();
	}

	//Verify manage recurring payment button
	public void verifyManageRecurringButton(HashMap<String, String> map) {
		Waits.explicitWaitForElementVisible(loanCard);
		SoftAssert softAssert = new SoftAssert();		

		viewLoanDetailsLink.click();
		String manageRecurringMessageInfo = manageRecurringMessage.getText();
		log.info("Message displayed next to Manage recurring button is correct? " +manageRecurringMessageInfo);
		
		String managePaymentFrequency = paymentFrequency.getText();
		log.info("Payment frequency is: " +managePaymentFrequency);
		
		String manageRemainingPayment = remainingPayments.getText();
		log.info("Manage Remaining payments are: " +manageRemainingPayment);
		
		manageRecurringButton.click();
		
		boolean setUpRecurring = recurringSetting.isDisplayed();
		log.info("Reccuring setting option is available - "+setUpRecurring);
		
		boolean stopRecurring = stopRecurringPayment.isDisplayed();
		log.info("Reccuring setting option is available - "+stopRecurring);
		
		softAssert.assertTrue(setUpRecurring, "Recurring setting option is not available");
		softAssert.assertTrue(stopRecurring, "Stop recurring option is not available");
		softAssert.assertEquals(manageRecurringMessageInfo,map.get("RecurringInfo"), "Actual information is different from expected");
		softAssert.assertEquals(managePaymentFrequency, map.get("PaymentFrequency"), "Actual payments frequency is different from expected");
		softAssert.assertEquals(manageRemainingPayment,map.get("RemainingPayments"), "Actual remaining payments are different from expected");

		
		softAssert.assertAll();
	}
	
	//Verify set up recurring payment
	public void setUpRecurring(HashMap<String, String> map) throws InterruptedException {
		SoftAssert softAssert = new SoftAssert();
		
		viewLoanDetailsLink.click();
		Waits.explicitWaitForElementVisible(loanCard);
		setUpRecurringBtn.click();
		
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
	
	//verify stop recurring payments modal
	public void verifyStopRecurringPopUp(HashMap<String, String> map) throws InterruptedException {
		SoftAssert softAssert = new SoftAssert();
		
		Waits.explicitWaitForElementVisible(loanCard);
		clickViewDetailsLink();
		
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
	
	//Verify Make a payment pop is open
	public boolean isPaymentModalIsOpen() {
		Waits.explicitWaitForElementVisible(makePaymentmodalWindowOpen);
		driver.switchTo().frame(makePaymentmodalWindowOpen);
		boolean modalDisplayed = makePaymentmodalWindowOpen.isDisplayed();
		return modalDisplayed;
	}
		
	//Make a Payment	
	public void makePayment(HashMap<String, String> map) {
		SoftAssert softAssert = new SoftAssert();
			
		viewLoanDetailsLink.click();
		Waits.explicitWaitForElementVisible(loanCard);
		makePaymentBtn.click();
		
		String payDate = modalPaymentDate.getText();
		log.info("Today's date is displayed: " +payDate);
		
		modalPaymentDate.sendKeys(map.get("PaymentDate"));
		log.info("Specified date is"  +map.get("PaymentDate"));

		openSelectPaymentDropDown.click();
		String chooseAmountOption = chooseAmount.getText();
		log.info("Dropdown amount is" +chooseAmountOption);

		chooseAmount.click();
		
		continuePaymentBtn.click();
		Waits.explicitWaitForElementVisible(payNowBtn);
		payNowBtn.click();
		}
}