package com.wac.cwp.pages;

import static org.testng.Assert.assertFalse;

import java.awt.Desktop.Action;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.concurrent.TimeUnit;

import org.apache.xmlbeans.impl.xb.xsdschema.Public;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;
import org.testng.asserts.SoftAssert;

import com.wac.cwp.base.TestBase;
import com.wac.cwp.helper.Waits;

public class AccountsPage extends TestBase {
	
	@FindBy(xpath="//span[text()='ACCOUNT']")
	WebElement accountLink;
	
	@FindBy(xpath="//Span[text()='PAYMENT HISTORY']")
	WebElement paymentHistoryLink;
	
	@FindBy(xpath="//Span[text()='SETTINGS']")
	WebElement settingsLink;
	
	@FindBy(xpath="//div[contains(text(),'Hi,')]")
	WebElement welcomeMsg;
	
	@FindBy(xpath="//p[text()='Next payment due in']/parent::div/following-sibling::div/div/div/div[1]//p[1]")
	WebElement daysRemainingForNextDue;
	
	@FindBy(xpath="//p[text()='Your payment was due']/parent::div/following-sibling::div/div/div/div[1]//p[1]")
	WebElement daysPastDue;
	
	@FindBy(xpath="//p[text()='Next payment due in']/parent::div/following-sibling::div/div/div/div[1]//p[2]")
	WebElement nextDueDateAndLoan;
	
	@FindBy(xpath="//p[text()='Next payment due in']/parent::div/following-sibling::div/div/div/div[2]//p[2]")
	WebElement nextDueAmount;
	
	@FindBy(xpath="//p[text()='Your payment was due']/parent::div/following-sibling::div/div/div/div[1]//p[2]")
	WebElement nextDueDateAndLoan2;
	
	@FindBy(xpath="//p[text()='Your payment was due']/parent::div/following-sibling::div/div/div/div[2]//p[2]")
	WebElement nextDueAmount2;
	
	@FindBy(xpath="//button[text()='Pay Now']")
	WebElement payNowButton;
	
	@FindBy(xpath="//a[text()='View loan details']")
	WebElement viewLoanDetails;
	
	@FindBy(xpath="//div[text()='Recent Payments']")
	WebElement RecentPaymentsSecHeading;
	
	@FindBy(xpath="//div[text()='Recent Payments']/following-sibling::div/div/div/div[1]/div[1]//h6")
	List<WebElement> recentPaymentDates;
	
	@FindBy(xpath="//div[text()='Recent Payments']/following-sibling::div/div/div/div[1]/div[1]//p")
	List<WebElement> recentPaymentLoanNoDetails;
	
	@FindBy(xpath="//div[text()='Recent Payments']/following-sibling::div/div/div/div[1]/div[2]//p")
	List<WebElement> recentPaymentAmounts;
	
	@FindBy(xpath="//a[text()='View all']")
	WebElement viewAll;
	
	@FindBy(xpath="//div[text()='Your Loans']")
	WebElement yourLoansSection;
	
	@FindBy(xpath="//a[contains(text(),'Loan #')]")
	List<WebElement> loanNumber;
	
	@FindBy(xpath="//p[text()='Current balance']/following-sibling::p/span")
	List<WebElement> loansCurrentBalance;
	
	@FindBy(xpath="//p[text()='Next payment due']/following-sibling::p")
	List<WebElement> loansNextPaymentDue;
	
	@FindBy(xpath="//p[text()='Your payment was due']/following-sibling::p")
	List<WebElement> loansPassedDueDate;

	@FindBy(xpath="//button[text()='Make a Payment']")
	List<WebElement> makeAPaymentButton;
	
	@FindBy(xpath="//button[text()='Apply for a Loan']")
	WebElement applyForALoan;
	
	@FindBy(xpath = "//div[@class = 'modal-dialog paymentModal modal-lg modal-dialog-centered modal-dialog-scrollable']")
	WebElement makePaymentModal;
	
	@FindBy(xpath = "//button[text() = 'Make a Payment']")
	WebElement loanDetailsMakePayment;
	
	@FindBy(xpath = "//div[contains(text(),'Loan #')]")
	WebElement loanPageLoanNo;
	
	@FindBy(xpath = "(//*[local-name() ='svg'])[4]")
	WebElement dueDatePassedAccountToolkit;
	
	@FindBy(xpath = "(//*[local-name() ='svg'])[8]")
	WebElement dueDatePassedLoanToolkit;
	
	@FindBy(xpath = "(//*[local-name() ='svg'])[3]")
	WebElement loanLastUpdate;
	
	@FindBy(id = "dataUpdate")
	WebElement loanLastUpdatedToolkitIconMessgae;
	
	@FindBy(id = "feesIcon")
	WebElement accountSummaryToolkitMsg;
	
	@FindBy(id = "overdueIcon")
	WebElement loanDetailsToolkitMsg;
	
	@FindBy(xpath = "//label[@id='select_amount_label']")
	WebElement chooseAmountLabel;
	
	@FindBy(xpath = "//ul[@Class='MuiList-root MuiList-padding MuiMenu-list css-r8u8y9']/li[1]")
	WebElement chooseAmount;
	
	@FindBy(xpath = "//input[@name = 'select_payment_amount']")
	WebElement openSelectPaymentDropDown;
	
	@FindBy(xpath = "//input[@name = 'select_payment_amount']")
	WebElement selectedAmt;
	
	@FindBy(xpath = "//button[text()='Cancel']")
	WebElement cancelBtn;
	
	@FindBy(xpath = "//button[text() = 'View Initial Disclosures']")
	WebElement viewDisclosures;
	
	@FindBy(xpath = "//button[text() = 'Apply for a Loan']")
	WebElement applyForLoan;
	
	public AccountsPage(){
		PageFactory.initElements(driver, this);
	}
	
	public boolean verifyAccountsPageIsDisplayed() {
		boolean isDisplayed = welcomeMsg.isDisplayed();
		return isDisplayed;
	}
	
	public String getWelcomeMsg() throws InterruptedException {
		Waits.explicitWaitForElementVisible(welcomeMsg);
		Thread.sleep(2000);
		String welcmeMsg = welcomeMsg.getText();
		log.info("The Welcome message in user account is: " +welcmeMsg);
		return welcmeMsg;
	}
	
	public void verifyAccountSummaryCardDetailsForDueDateNotPassedUser(HashMap<String, String> map) {
		
		Waits.explicitWaitForElementVisible(nextDueDateAndLoan);
		
		SoftAssert softAssert = new SoftAssert();
		
		String NoOfDaysToDueDate = daysRemainingForNextDue.getText();
		log.info("Number of days for due date is: " +NoOfDaysToDueDate);
		
		String dueDateAndLoanNo = nextDueDateAndLoan.getText();
		log.info("Due Date and Loan Number is: " +dueDateAndLoanNo);
		
		String amountDue = nextDueAmount.getText();
		log.info("Amount due is: " +amountDue);
		
		boolean isPayNowButtonDisplayed = payNowButton.isDisplayed();
		log.info("Is pay now button displayed: " +isPayNowButtonDisplayed);
				
		boolean isViewLoanDetailsLinkDisplayed = viewLoanDetails.isDisplayed();
		log.info("Is View Loan Details Link displayed: " +isViewLoanDetailsLinkDisplayed);
		
		softAssert.assertEquals(NoOfDaysToDueDate, map.get("NumberOfDaysToDueDate"), "Actual value is different from expected");
		
		softAssert.assertEquals(dueDateAndLoanNo, map.get("DueDateAndLoanNumber"), "Actual value is different from expected");
		
		softAssert.assertEquals(amountDue, map.get("AmountDue"), "Actual value is different from expected");
		
		softAssert.assertTrue(isPayNowButtonDisplayed, "Pay Now button is not displayed");
		
		softAssert.assertTrue(isViewLoanDetailsLinkDisplayed, "View Loan details link is not displayed");

		softAssert.assertAll();
	}
	
	public void verifyAccountSummaryCardDetailsForDueDatePassedUser(HashMap<String, String> map) {
		
		Waits.explicitWaitForElementVisible(daysPastDue);
		
		SoftAssert softAssert = new SoftAssert();
		
		String daysPassedDue = daysPastDue.getText();
		log.info("Number of days since due date has passed: " +daysPassedDue);
		
		String dueDateAndLoanNo = nextDueDateAndLoan2.getText();
		log.info("Due Date and Loan Number is: " +dueDateAndLoanNo);
		
		String amountDue = nextDueAmount2.getText();
		log.info("Amount due is: " +amountDue);
		
		boolean isPayNowButtonDisplayed = payNowButton.isDisplayed();
		log.info("Is pay now button displayed: " +isPayNowButtonDisplayed);
				
		boolean isViewLoanDetailsLinkDisplayed = viewLoanDetails.isDisplayed();
		log.info("Is View Loan Details Link displayed: " +isViewLoanDetailsLinkDisplayed);
		
		softAssert.assertEquals(daysPassedDue, map.get("NumberOfDaysToDueDate"), "Actual value is different from expected");
		
		softAssert.assertEquals(dueDateAndLoanNo, map.get("DueDateAndLoanNumber"), "Actual value is different from expected");
		
		softAssert.assertEquals(amountDue, map.get("AmountDue"), "Actual value is different from expected");
		
		softAssert.assertTrue(isPayNowButtonDisplayed, "Pay Now button is not displayed");
		
		softAssert.assertTrue(isViewLoanDetailsLinkDisplayed, "View Loan details link is not displayed");

		softAssert.assertAll();
	}
	
	public boolean verifyYourLoansSectionIsDisplayed() {
		Waits.explicitWaitForElementVisible(yourLoansSection);
		boolean isDisplayed = yourLoansSection.isDisplayed();
		return isDisplayed;
	}
	
	public void verifyLoanDetailsCard(HashMap<String, String> map) {
		
		Waits.explicitWaitForElementVisible(yourLoansSection);
		
		SoftAssert softAssert = new SoftAssert();
		
		int noOfLoans =	loanNumber.size();
		log.info("Actual number of loans for the user: " +noOfLoans);
		log.info("Expected number of loans for the user: " +map.get("TotalNumberOfLoans"));
		//int expectedNumOfLoans = Integer.parseInt(map.get("TotalNumberOfLoans"));
		//softAssert.assertEquals(noOfLoans,expectedNumOfLoans , "The Actual and expected number of loans does not match");
			
		for (int i =0 ; i < noOfLoans; i++) {
			
			WebElement loanNum =  loanNumber.get(i);
			String loanNumDtls = loanNum.getText();
			String lnNum = "LoanNumber"+i;
			log.info("The actual value of loan number is: " +loanNumDtls);
			log.info("The expected value of loan number is: " +map.get("LoanNumber"+i));
			softAssert.assertEquals(loanNumDtls, map.get("LoanNumber"+i), "Actual and Expected Loan Number does not match");
			
			WebElement currentBal = loansCurrentBalance.get(i);
			String currentBalValue = currentBal.getText();
			log.info("The actual value of current balance is: " +currentBalValue);
			log.info("The expected value of current balance is: " +map.get("CurrentBalance"+i));
			softAssert.assertEquals(currentBalValue, map.get("CurrentBalance"+i), "Actual and Expected Current Balance does not match");
			
			if (map.get("DueDatePassed").contentEquals("YES")) {
				
				WebElement dueDate = loansPassedDueDate.get(i);
				String dueDateValue = dueDate.getText();
				log.info("The actual value of due date is: " +dueDateValue);
				log.info("The expected value of due date is: " +map.get("DueDate"+i));
				softAssert.assertEquals(dueDateValue, map.get("DueDate"+i), "Actual and Expected due date does not match");
				
			} else {
				
				WebElement dueDate = loansNextPaymentDue.get(i);
				String dueDateValue = dueDate.getText();
				log.info("The actual value of due date is: " +dueDateValue);
				log.info("The expected value of due date is: " +map.get("DueDate"+i));
				softAssert.assertEquals(dueDateValue, map.get("DueDate"+i), "Actual and Expected due date does not match");
				
			}
			
			WebElement makePaymentBtn = makeAPaymentButton.get(i);
			boolean isDisplayed = makePaymentBtn.isDisplayed();
			log.info("Is make payment button displayed?: " +isDisplayed);
			softAssert.assertTrue(isDisplayed);
			
			softAssert.assertAll();	
		}
		
	}
	
	public boolean verifyRecentPaymentsSectionIsDisplayed() {
		Waits.explicitWaitForElementVisible(RecentPaymentsSecHeading);
		boolean isDisplayed = RecentPaymentsSecHeading.isDisplayed();
		return isDisplayed;
	}
	
	public void verifyRecentPaymentDetails(HashMap<String, String> map) {
		Waits.explicitWaitForElementVisible(RecentPaymentsSecHeading);
		
		SoftAssert softAssert = new SoftAssert();
		
		int numOfRecPayments = recentPaymentDates.size();
		log.info("No of Recent Payments listed are: " +numOfRecPayments);
		log.info("Expected number of recent payments are: " +map.get("NumOfRecentPayments"));
		
		for (int i =0 ; i < numOfRecPayments; i++) {
			
			WebElement loanPaid =  recentPaymentLoanNoDetails.get(i);
			String paidLoanNum = loanPaid.getText();
			log.info("The actual value of paid loan number is: " +paidLoanNum);
			log.info("The expected value of paid loan number is: " +map.get("PaidLoanNumber"+i));
			softAssert.assertEquals(paidLoanNum, map.get("PaidLoanNumber"+i), "Actual and Expected Paid Loan Number does not match");
			
			WebElement paymentDate = loansCurrentBalance.get(i);
			String payDate = paymentDate.getText();
			log.info("The actual value of payment date is: " +payDate);
			log.info("The expected value of payment date is: " +map.get("PaymentDate"+i));
			softAssert.assertEquals(payDate, map.get("PaymentDate"+i), "Actual and Expected Payment Date does not match");
			
			WebElement paymentAmount = loansCurrentBalance.get(i);
			String payAmount = paymentAmount.getText();
			log.info("The actual value of payment amount is: " +payAmount);
			log.info("The expected value of payment amount is: " +map.get("PaymentAmount"+i));
			softAssert.assertEquals(payAmount, map.get("PaymentAmount"+i), "Actual and Expected Payment Amount does not match");
			
		}
		
		softAssert.assertAll();
	}
	
	public void LoanDetailsPageAccountSummary(HashMap<String, String> map) {
		Waits.explicitWaitForElementVisible(viewLoanDetails);
		
		SoftAssert softAssert = new SoftAssert();
		ClickViewLoanDetailsLink();
		
		String NoOfDaysToDueDate = daysRemainingForNextDue.getText();
		log.info("Number of days for due date is: " +NoOfDaysToDueDate);
		
		String dueDate = nextDueDateAndLoan.getText();
		log.info("Due Date is: " +dueDate);
		
		String amountDue = nextDueAmount.getText();
		log.info("Amount due is: " +amountDue);
		
		boolean isPayNowButtonDisplayed = loanDetailsMakePayment.isDisplayed();
		log.info("Is make a payment button displayed: " +isPayNowButtonDisplayed);
		
		softAssert.assertEquals(NoOfDaysToDueDate, map.get("NumberOfDaysToDueDate"), "Actual value is different from expected");
		
		softAssert.assertEquals(dueDate, map.get("LoanNumber"), "Actual value is different from expected");
		
		softAssert.assertEquals(amountDue, map.get("AmountDue"), "Actual value is different from expected");
		
		softAssert.assertTrue(isPayNowButtonDisplayed, "Pay Now button is not displayed");
		
	}
	
	public boolean isDisplayedMakePaymentModel() {
		Waits.explicitWaitForElementVisible(payNowButton);
		payNowButton.click();
		boolean isDisplayed = makePaymentModal.isDisplayed();
		log.info("Make a paytment modal is displayed? " +isDisplayed);
		return isDisplayed;
	}
	
	public boolean verifyViewAllLinkIsDisplayed() {
		Waits.explicitWaitForElementVisible(viewAll);
		boolean isDisplayed = viewAll.isDisplayed();
		return isDisplayed;
	}	
	
	
	public AccountsPage clickAccountsLink() {
		accountLink.click();
		log.info("Clicked on Accounts Link");
		return new AccountsPage();
	}
	
	public PaymentsPage clickPaymentHistoryLink() {
		paymentHistoryLink.click();
		log.info("Clicked on Payment History Link");
		return new PaymentsPage();
	}
	
	public SettingsPage clickSettingsLink() {
		settingsLink.click();
		log.info("Clicked on Settings Link");
		return new SettingsPage();
	}
	
	public LoanDetailsPage ClickViewLoanDetailsLink() {
		viewLoanDetails.click();
		log.info("Clicked on Loan Details Link");
		return new LoanDetailsPage();
	}
	
	public PaymentHistoryPage clickOnViewAllLink() {
		viewAll.click();
		log.info("Click on view all link");
		return new PaymentHistoryPage();
	}
	
	// Click on loan number
	public LoanDetailsPage ClickLoanLoanNumber() throws InterruptedException {
	Waits.explicitWaitForElementVisible(yourLoansSection);

	int totalLoan = loanNumber.size();
	log.info("no of loan size: "  +totalLoan);
		
	for(int i =0; i<totalLoan ; i++) {
		String loanNo = loanNumber.get(i).getText();
		log.info("Click on loan number: " +loanNo);

		loanNumber.get(i).click();
		log.info("Successfully navigate to loan page");
		accountLink.click();
		}
		return new LoanDetailsPage();
	}
	
	//Click on make a payment button
	public void MakePayment(HashMap<String, String> map) throws InterruptedException {
		//Waits.explicitWaitForElementVisible(yourLoansSection);
		SoftAssert softAssert = new SoftAssert();

		int totalMakePaymentBtn = makeAPaymentButton.size();
		log.info("Total payment button for loan is: " +totalMakePaymentBtn);
		//driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);

		for(int i =0; i<totalMakePaymentBtn; i++) {

			Actions a = new Actions(driver);
			a.moveToElement(makeAPaymentButton.get(i)).click().perform();
			openSelectPaymentDropDown.click();
			chooseAmount.click();
			String chooseAmountOption = chooseAmount.getText();
			log.info("Dropdown amount is" +chooseAmountOption);
			cancelBtn.click();
			softAssert.assertEquals(chooseAmountOption, map.get("CurrentBalance"+i), "Actual value is different from expected");
		}
	}
	//Toolkit verification for Due date passed user 
	public boolean isDisplayedLoanLastUpdateToolkit() {
		Waits.explicitWaitForElementVisible(loanLastUpdate);
		SoftAssert softAssert = new SoftAssert();
		Actions a = new Actions(driver);
		a.moveToElement(loanLastUpdate).perform();
		boolean loanUpdateToolkitMessage = loanLastUpdatedToolkitIconMessgae.isDisplayed();
		softAssert.assertTrue(loanUpdateToolkitMessage);
		return loanUpdateToolkitMessage;
	}
	
	public boolean isDisplayedAccountSummaryToolkit() {
		Waits.explicitWaitForElementVisible(dueDatePassedAccountToolkit);
		SoftAssert softAssert = new SoftAssert();
		Actions a = new Actions(driver);
		a.moveToElement(dueDatePassedAccountToolkit).perform();
		boolean accountSummaryToolkitMessage = accountSummaryToolkitMsg.isDisplayed();
		softAssert.assertTrue(accountSummaryToolkitMessage);
		return accountSummaryToolkitMessage;
	}
	
	public boolean isDisplayedLoanToolkit() {
		Waits.explicitWaitForElementVisible(dueDatePassedLoanToolkit);
		SoftAssert softAssert = new SoftAssert();
		Actions a = new Actions(driver);
		a.moveToElement(dueDatePassedLoanToolkit).perform();
		boolean loanSummaryToolkitMessage = loanDetailsToolkitMsg.isDisplayed();
		softAssert.assertTrue(loanSummaryToolkitMessage);
		return loanSummaryToolkitMessage;
	}
	
	public void clickApplyLoan() {
		applyForLoan.click();
		log.info("Clicked on the Apply for loan link");
	}
	
	public void clickDisclosures() {
		viewDisclosures.click();
		log.info("Clicked on the view Disclosures link");
	}
	
	public void verifyTheURLOpened(String expectedURL) {
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
		String actualUrl = driver.getCurrentUrl();
		expectedURL = expectedURL.trim();
		log.info("The actual url opened is : " +actualUrl);
		log.info("The expected url to open is : " +expectedURL);
		Assert.assertEquals(actualUrl, expectedURL, "The actual URL opened is different from expected");
	}
	
	public void verifyDisclosuresTab(String expectedURL) {
	    ArrayList<String> tabs = new ArrayList<String>(driver.getWindowHandles());
	    driver.switchTo().window(tabs.get(1));
	    String actualUrl = driver.getCurrentUrl();
		expectedURL = expectedURL.trim();
		log.info("The actual url opened is : " +actualUrl);
		log.info("The expected url to open is : " +expectedURL);
		Assert.assertEquals(actualUrl, expectedURL, "The actual URL opened is different from expected");

	}
	
	//Toolkit should not displayed for due date passed user
	public boolean verifyAccountToolkitIconPresent() {
		if(dueDatePassedAccountToolkit.isDisplayed()) {
			log.info("Account summary Toolikit is present");
			return true;
		}else
			log.info("Account summary Toolikit is not present");
			return false;
	}
	
	public boolean verifyLoanToolkitIconPresent() {
		if(dueDatePassedLoanToolkit.isDisplayed()) {
			log.info("Loan summary Toolikit is present");
			return true;
		}else
			log.info("Loan summary Toolikit is not present");
			return false;
	}
}
