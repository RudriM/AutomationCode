package com.wac.cwp.pages;

import java.util.HashMap;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.python.compiler.Filename;
import org.python.modules.thread.thread;
import org.testng.asserts.SoftAssert;

import com.mysql.cj.x.protobuf.MysqlxCrud.Find;
import com.wac.cwp.base.TestBase;
import com.wac.cwp.helper.Waits;


public class MakePaymentPage extends TestBase {
	
	@FindBy(xpath = "//button[text() = 'Pay Now']")
	WebElement makeAPayment;
	
	@FindBy(xpath = "//div[@class = 'modal-dialog paymentModal modal-lg modal-dialog-centered modal-dialog-scrollable']")
	WebElement MakePaymentModal;
	
	@FindBy(xpath = "//div[text() = 'Make a Payment']")
	WebElement makeAPaymentHeading;
	
	@FindBy(xpath = "//input[@id = 'paymentDate']")
	WebElement paymentDate;
	
	@FindBy(xpath = "//div[@id = 'select_payment_amount']")
	WebElement chooseAmount;
	
	@FindBy(xpath = "//ul[@Class='MuiList-root MuiList-padding MuiMenu-list css-r8u8y9']/li[1]")
	WebElement chooseAmountOption;
	
	@FindBy(xpath = "//ul[@Class='MuiList-root MuiList-padding MuiMenu-list css-r8u8y9']/li[2]")
	WebElement chooseOtherAmountOption;
	
	@FindBy(xpath = "//input[@id='amount']")
	WebElement customAmount;
	
	@FindBy(xpath = "//div[@id = 'method']")
	WebElement chooseMethodDropdown;
	
	@FindBy(xpath = "//ul[@Class='MuiList-root MuiList-padding MuiMenu-list css-r8u8y9']/li[2]")
	WebElement savedCardInfo;
	
	@FindBy(xpath = "//ul[@Class='MuiList-root MuiList-padding MuiMenu-list css-r8u8y9']/li[4]")
	WebElement otherPaymentMethodOption;
	
	@FindBy(xpath = "//button[text() = 'Bank Account']")
	WebElement bankAccountOption;
	
	@FindBy(xpath = "//button[text() = 'Debit Card']")
	WebElement DebitCardOption;
	
	@FindBy(id = "cardNumber")
	WebElement cardNumber;
	
	@FindBy(id = "expiration")
	WebElement expirationDate;
	
	@FindBy(id = "cvv")
	WebElement cvvNumber;
	
	@FindBy(xpath = "//span[contains(text(),'For')]")
	WebElement feeMessage;
	
	@FindBy(xpath = "//button[text() = 'Continue']")
	WebElement continueBtn;
	
	@FindBy(xpath = "//button[text() = 'Cancel']")
	WebElement cancelBtn;
	
	@FindBy(xpath = "//input[@id = 'save']")
	WebElement saveCardForFutureCheckBox;
	
	@FindBy(xpath = "//a[contains(text(), 'Click Here to')]")
	WebElement applyForBankAccount;
	
	@FindBy(xpath = "//label[@id=\"save_label\"]/span[contains(text(), 'This will')]")
	WebElement savedCardMessageInfo;
	
	@FindBy(xpath = "//div[@id = 'paymentSubMethodDropdown']")
	WebElement accountType;
	
	@FindBy(xpath = "//input[@id = 'bankRoutingNumber']")
	WebElement routingNumber;
	
	@FindBy(xpath = "//input[@id = 'bankAccountNumber']")
	WebElement accountNumber;
	
	@FindBy(xpath = "//button[text() = 'Remove Linked Account']")
	WebElement removedBankAccBtn;
	
	@FindBy(xpath = "(//*[local-name() ='svg'])[11]")
	WebElement makePaymentToolkit;
	
	//E - complish fee add on Review and confirmation pop up
	@FindBy(xpath = "//div[2]/span[@class = 'itemized-payment-amount']")
	WebElement eComplishFee;
	
	@FindBy(xpath = "//span[text() = 'Total']/following-sibling:: span")
	WebElement totalAmount;
	
	@FindBy(xpath = "//span[contains(text(),'Date')]")
	WebElement pastDateErrorMsg;
	
	@FindBy(xpath = "//div[contains(text(),'The payment date')]")
	WebElement loanDueDateWarningMsg;
	
	@FindBy(xpath = "//div[contains(text(),'You are about to schedule')]")
	WebElement reviewPageWarningMsg;
	
	@FindBy(xpath = "//div[text()= 'Review and Confirm Payment']")
	WebElement reviewHeading;
	
	@FindBy(xpath = "//label[text() = 'Payment Date']/following-sibling:: span")
	WebElement reviewPagePaymentDate;
	
	@FindBy(xpath = "//div[1]/span[@class = 'itemized-payment-amount']")
	WebElement reviewPagePaymentAmount;
	
	@FindBy(xpath = "//div[1]/span[@class = 'itemized-payment-amount-subText']")
	WebElement reviewPagePaymentMethod;
	
	@FindBy(xpath = "//div[2]/span[@class = 'itemized-payment-amount']")
	WebElement reviewPageEcomplishFee;
	
	@FindBy(xpath = "//div[2]/span[@class = 'itemized-payment-totalAmount']")
	WebElement reviewPageTotalAmount;
	
	@FindBy(xpath = "//div[text() = 'Payment Authorization']")
	WebElement paymentAuthHeading;
	
	@FindBy(xpath = "//div[text() = 'Notice of E-Complish Fee']")
	WebElement noticeInformation;
	
	@FindBy(xpath = "//div[text() = 'Payment Posting']")
	WebElement paymentPostingInfo;
	
	@FindBy(xpath = "//button[text() = 'Back']")
	WebElement backButton;
	
	@FindBy(xpath = "//button[text() = 'Pay ']")
	WebElement payButton;
	
	@FindBy(xpath = "//button[text()='Pay ']/span")
	WebElement payButtonAmount;
	
	@FindBy(xpath = "//div[contains(text(),'I understand')]")
	WebElement bankAccStatementInfo;            
	
	@FindBy(xpath = "//div[contains(text(),'By clicking')]")
	WebElement paymentAuthInfo1;
	
	@FindBy(xpath = "//div[2]/div[3]/div[3][@class = 'payment-disclosure-regularText']")
	WebElement paymentAuthInfo2;
	
	@FindBy(xpath = "//div[3]/div/div/div[2]/div[3]")
	WebElement paymentAuthBankInfo;

	@FindBy(xpath = "//div[3]/div[2]/span[1][@class = 'payment-disclosure-boldText']")
	WebElement paymentAuthCustomerName;
	
	@FindBy(xpath = "//div[3]/div[2]/span[2][@class = 'payment-disclosure-boldText']")
	WebElement paymentAuthAmount;
	
	@FindBy(xpath = "//div[3]/div[2]/span[4][@class = 'payment-disclosure-boldText']")
	WebElement paymentAuthDebit;
	
	@FindBy(xpath = "//div[3]/div[2]/span[5][@class = 'payment-disclosure-boldText']")
	WebElement paymentAuthDate;
	
	@FindBy(xpath = "//div[text() = 'Payment Authorization']/following-sibling::div")
	WebElement paymentAuthBankInfoMsg;
	
	@FindBy(xpath = "//div/div[3]/span[3][@class = 'payment-disclosure-boldText']")
	WebElement worldAccNumber;
	
	@FindBy(xpath = "//div/div[4]/span[1][@class = 'payment-disclosure-boldText']")
	WebElement bankAccLastDigitNumber;
	
	@FindBy(xpath = "//div[3]/div[3]/span[1][@class = 'payment-disclosure-boldText']")
	WebElement PayAuthBankCustName;
	
	@FindBy(xpath = "//div[3]/div[3]/span[2][@class = 'payment-disclosure-boldText']")
	WebElement payAuthBankAmount;
	
	@FindBy(xpath = "//div[2]/div[3]/div[5]/span[@class = 'payment-disclosure-boldText']")
	WebElement payAuthBankDate;
	
	@FindBy(xpath = "//div[3]/div/div/div[2]/div[4]")
	WebElement niticeInfoSection;
	
	@FindBy(xpath = "//div[2]/div[4]/div[3]/span[@class = 'payment-disclosure-boldText']")
	WebElement noticeSection;
	
	@FindBy(xpath = "//div[3]/div/div/div[2]/div[5]")
	WebElement paymentPostingSection;
	
	@FindBy(xpath = "//div[3]/div/div/div[2]/div[4]")
	WebElement paymentPostBanksection;
	
	@FindBy(xpath = "//button[text()='Continue']")
	WebElement paymentContinue;
	
	@FindBy(xpath = "//div[contains(text(), 'Partial payments')]")
	WebElement partialPaymentMsg;
	
	//Payment Receipt page
	@FindBy(xpath = "//label[text() = 'Payment Date']/following-sibling::span")
	WebElement receiptDate;
	
	@FindBy(xpath = "//label[text() = 'Paid By']/following-sibling::span[1]")
	WebElement reciptPaidByName;
	
	@FindBy(xpath = "//label[text() = 'Paid By']/following-sibling::span[2]")
	WebElement receiptAddress;
	
	@FindBy(xpath = "//label[text() = 'Paid By']/following-sibling::span[4]")
	WebElement receiptEmail;
	
	@FindBy(xpath = "//label[text() = 'Status']/following-sibling::span")
	WebElement receiptStatus;
	
	@FindBy(xpath = "//div[1]/span[1][@class = 'itemized-payment-amount']")
	WebElement receiptAmount;
	
	@FindBy(xpath = "//div[1]/div/span[2][contains(text(),'Debit Card')]")
	WebElement receiptDebitMethod;
	
	@FindBy(xpath = "//div[2]/span[2][@class = 'itemized-payment-amount']")
	WebElement receiptEFee;
	
	@FindBy(xpath = "//span[text() = 'Total']/following-sibling::span[1]")
	WebElement receiptTotalAmount;
	
	@FindBy(xpath = "//div[contains(text(), 'Tracking #')]")
	WebElement receiptTrackingNumber;
	
	@FindBy(xpath = "//div[contains(text(), 'Approval Code')]")
	WebElement receiptApprovalCode;
	
	@FindBy(xpath = "//button[text() = 'Close']")
	WebElement closeButton;
	
	@FindBy(xpath = "//button[text() = 'Print']")
	WebElement printButton;
	
	
	
	public MakePaymentPage(){
		PageFactory.initElements(driver, this);
	}
	
	public void clickOnMakePayment() {
		makeAPayment.click();
	} 

	public AccountsPage clickCancelBtn() {
		cancelBtn.click();
		log.info("Clicked on cancel button");
		return new AccountsPage();
	}
	
	//Make Payment pop up: select payment method saved Bank account details.
	public void verifyMakePaymentSavedAsBank(HashMap<String, String> map) throws InterruptedException {
		
		Waits.explicitWaitForElementVisible(makeAPayment);
		
		SoftAssert softAssert = new SoftAssert();
		Thread.sleep(5000);
		clickOnMakePayment();
		Thread.sleep(10000);

		paymentDate.sendKeys(map.get("PaymenDate"));
		log.info("Specified date is"  +map.get("PaymenDate"));
		
		boolean chooseAmountDropDown = chooseAmount.isDisplayed();
		log.info("Choose amount dropdown is displayed: " +chooseAmountDropDown);
		
		chooseAmount.click();
		
		chooseOtherAmountOption.click();
		log.info("Amount due options is selected");
		
		customAmount.sendKeys(map.get("OtherAmount"));
		log.info("Specified Amount is"  +map.get("OtherAmount"));

		chooseMethodDropdown.click();
		
		otherPaymentMethodOption.click();
		log.info("Other is selected as payment method");
		
		bankAccountOption.click();

		boolean isDisplayedCancelBtn = cancelBtn.isDisplayed();
		log.info("Cancel button is displayed ?" +isDisplayedCancelBtn);
		
		boolean isDisplayedContinuebtn = continueBtn.isDisplayed();
		log.info("Continue button is displayed? " +isDisplayedContinuebtn);
		
		softAssert.assertEquals(paymentDate, map.get("PaymentDate"), "Actual value is different from expected");
		softAssert.assertTrue(chooseAmountDropDown, "Choose Amount DropDown is not displayed");
		softAssert.assertTrue(isDisplayedCancelBtn, "Cancel button is not displayed");
		softAssert.assertTrue(isDisplayedContinuebtn, "Continue button is not displayed");
		
	}
	
	//Make Payment pop up: select payment method saved Debit Card details.
	public void verifyMakePaymentSavedAsDebit(HashMap<String, String> map) throws InterruptedException {
		
		Waits.explicitWaitForElementVisible(makeAPayment); 
		
		SoftAssert softAssert = new SoftAssert();
		Thread.sleep(5000);
		clickOnMakePayment();
		Thread.sleep(10000);

		Boolean paymentdateDisplay = paymentDate.isDisplayed();
		log.info("Is displaye payment date option ?" + paymentdateDisplay);
		
		boolean chooseAmountDropDown = chooseAmount.isDisplayed();
		log.info("Is Choose amount dropdown is displayed? " +chooseAmountDropDown);
		
		chooseAmount.click();
		chooseOtherAmountOption.click();

		log.info("Other amount option is selected");
		
		boolean otherAmountTextbox = customAmount.isDisplayed();
		log.info("Other amount textbox is present: " +otherAmountTextbox);
		
		customAmount.sendKeys(map.get("OtherAmount"));
		log.info("Specified Amount is"  +map.get("OtherAmount"));
				
		chooseMethodDropdown.click();
		savedCardInfo.click();
		log.info("Saved debit card info is selected");

		boolean isDisplayedCVV = cvvNumber.isDisplayed();
		log.info("CVV text box is displayed: " +isDisplayedCVV);
				
		boolean isDisplayedCancelBtn = cancelBtn.isDisplayed();
		log.info("Cancel button is displayed ?" +isDisplayedCancelBtn);
		
		boolean isDisplayedContinuebtn = continueBtn.isDisplayed();
		log.info("Continue button is displayed? " +isDisplayedContinuebtn);
		
		softAssert.assertTrue(paymentdateDisplay, "Actual value is different from expected");
		softAssert.assertTrue(chooseAmountDropDown, "Choose Amount DropDown is not displayed");
		softAssert.assertTrue(otherAmountTextbox, "Other amount textbox is not displayed");
		softAssert.assertTrue(isDisplayedCVV, "CVV textbox is not displayed");
		softAssert.assertTrue(isDisplayedCancelBtn, "Cancel button is not displayed");
		softAssert.assertTrue(isDisplayedContinuebtn, "Continue button is not displayed");	
	}
	
	//Verify make payment for not saved Debit card
	public void verifyMakePaymentNotSavedAsDebit(HashMap<String, String> map) throws InterruptedException {
		
		Waits.explicitWaitForElementVisible(makeAPayment); 
		
		SoftAssert softAssert = new SoftAssert();
		Thread.sleep(5000);
		clickOnMakePayment();
		Thread.sleep(10000);

		Boolean paymentdateDisplay = paymentDate.isDisplayed();
		log.info("Is displaye payment date option ?" + paymentdateDisplay);
		
		boolean chooseAmountDropDown = chooseAmount.isDisplayed();
		log.info("Is Choose amount dropdown is displayed? " +chooseAmountDropDown);
		
		chooseAmount.click();
		chooseAmountOption.click();
		
		boolean isDisplayedContinuebtn = continueBtn.isDisplayed();
		log.info("Continue button is displayed? " +isDisplayedContinuebtn);
		
		chooseMethodDropdown.click();
		otherPaymentMethodOption.click();
		
		boolean isDisplayedCard = cardNumber.isDisplayed();
		log.info("Card number text box is displayed: " +isDisplayedCard);
		
		boolean isDisplayedCVV = cvvNumber.isDisplayed();
		log.info("CVV text box is displayed: " +isDisplayedCVV);
		
		boolean isDisplayedExpiryDate = expirationDate.isDisplayed();
		log.info("Expiry date text box is displayed: " +isDisplayedExpiryDate);
		
		String ecomplishMessage = feeMessage.getText();
		log.info("Ecomplish message is: " +ecomplishMessage);
		
		boolean saveCardForFuture = saveCardForFutureCheckBox.isDisplayed();
		log.info("Save card for future box is displayed? " +saveCardForFuture);
		
		boolean isDisplayedCancelBtn = cancelBtn.isDisplayed();
		log.info("Cancel button is displayed ?" +isDisplayedCancelBtn);
		
		softAssert.assertTrue(paymentdateDisplay, "Payment date is not displayed");
		softAssert.assertTrue(chooseAmountDropDown, "Choose amount dropdown is not displayed");
		softAssert.assertTrue(isDisplayedCard, "Card number field is not displayed");
		softAssert.assertTrue(isDisplayedExpiryDate, "Expiry Date field is not displayed");
		softAssert.assertEquals(ecomplishMessage, map.get("FeeMessage"),"Card number field is not displayed");
		softAssert.assertTrue(saveCardForFuture, "Saved for future card checkbox is not displayed");
		softAssert.assertTrue(isDisplayedContinuebtn, "Continue button is not displayed");	
		softAssert.assertTrue(isDisplayedCancelBtn,"Cancel button is not displayed");
	}
	
	//Verify make payment for not saved Bank account
	public void verifyMakePaymentNotSavedBankAccount(HashMap<String, String> map) throws InterruptedException {
		
		Waits.explicitWaitForElementVisible(makeAPayment); 
		
		SoftAssert softAssert = new SoftAssert();
		Thread.sleep(5000);
		clickOnMakePayment();
		Thread.sleep(10000);

		Boolean paymentdateDisplay = paymentDate.isDisplayed();
		log.info("Is displaye payment date option ?" + paymentdateDisplay);
		
		boolean chooseAmountDropDown = chooseAmount.isDisplayed();
		log.info("Is Choose amount dropdown is displayed? " +chooseAmountDropDown);
		
		chooseAmount.click();
		chooseAmountOption.click();
		
		bankAccountOption.click();
		
		boolean isDisplayedSecurelyLink= applyForBankAccount.isDisplayed();
		log.info("Securely link is displayed? " +isDisplayedSecurelyLink);
		
		boolean isDisplayedContinuebtn = continueBtn.isDisplayed();
		log.info("Continue button is displayed? " +isDisplayedContinuebtn);
		
		boolean isDisplayedCancelBtn = cancelBtn.isDisplayed();
		log.info("Cancel button is displayed ?" +isDisplayedCancelBtn);
		
		softAssert.assertTrue(paymentdateDisplay, "Payment date is not displayed");
		softAssert.assertTrue(chooseAmountDropDown, "Choose amount dropdown is not displayed");
		softAssert.assertTrue(isDisplayedSecurelyLink, "Securely link is not displayed");
		softAssert.assertTrue(isDisplayedContinuebtn, "Continue button is not displayed");	
		softAssert.assertTrue(isDisplayedCancelBtn,"Cancel button is not displayed");

	}
	
	//select payment method other and select Debit Card option for user who has saved another card already
	public void verifyMakePaymentSavedBankAccount(HashMap<String, String> map) throws InterruptedException {
		
		Waits.explicitWaitForElementVisible(makeAPayment); 
		
		SoftAssert softAssert = new SoftAssert();
		Thread.sleep(5000);
		clickOnMakePayment();
		Thread.sleep(10000);

		Boolean paymentdateDisplay = paymentDate.isDisplayed();
		log.info("Is displaye payment date option ?" + paymentdateDisplay);
		
		boolean chooseAmountDropDown = chooseAmount.isDisplayed();
		log.info("Is Choose amount dropdown is displayed? " +chooseAmountDropDown);
		
		chooseAmount.click();
		chooseAmountOption.click();
		
		boolean isDisplayedContinuebtn = continueBtn.isDisplayed();
		log.info("Continue button is displayed? " +isDisplayedContinuebtn);
		
		chooseMethodDropdown.click();
		
		otherPaymentMethodOption.click();
		log.info("Other is selected as payment method");
		
		DebitCardOption.click();
		
		boolean isDisplayedCard = cardNumber.isDisplayed();
		log.info("Card number text box is displayed: " +isDisplayedCard);
		
		boolean isDisplayedCVV = cvvNumber.isDisplayed();
		log.info("CVV text box is displayed: " +isDisplayedCVV);
		
		boolean isDisplayedExpiryDate = expirationDate.isDisplayed();
		log.info("Expiry date text box is displayed: " +isDisplayedExpiryDate);
		
		String ecomplishMessage = feeMessage.getText();
		log.info("Ecomplish message is: " +ecomplishMessage);
		
		boolean saveCardForFuture = saveCardForFutureCheckBox.isDisplayed();
		log.info("Save card for future box is displayed? " +saveCardForFuture);
		
		String savedCardMessage = savedCardMessageInfo.getText();
		log.info("Saved Card message: "+savedCardMessage);
		
		boolean isDisplayedCancelBtn = cancelBtn.isDisplayed();
		log.info("Cancel button is displayed ?" +isDisplayedCancelBtn);
		
		softAssert.assertTrue(paymentdateDisplay, "Payment date is not displayed");
		softAssert.assertTrue(chooseAmountDropDown, "Choose amount dropdown is not displayed");
		softAssert.assertTrue(isDisplayedCard, "Card number field is not displayed");
		softAssert.assertTrue(isDisplayedExpiryDate, "Expiry Date field is not displayed");
		softAssert.assertEquals(ecomplishMessage, map.get("FeeMessage"),"Card number field is not displayed");
		softAssert.assertTrue(saveCardForFuture, "Saved for future card checkbox is not displayed");
		softAssert.assertEquals(savedCardMessage, map.get("SavedCardMessage"), "Message for saved card is not correct");
		softAssert.assertTrue(isDisplayedContinuebtn, "Continue button is not displayed");	
		softAssert.assertTrue(isDisplayedCancelBtn,"Cancel button is not displayed");
	}
	
	// select payment method other and select Bank account option for the user who has already linked their bank account 
	public void verifyMakePaymentlinkedBankAccount(HashMap<String, String> map) throws InterruptedException {
		
		Waits.explicitWaitForElementVisible(makeAPayment); 
		
		SoftAssert softAssert = new SoftAssert();
		Thread.sleep(5000);
		clickOnMakePayment();
		Thread.sleep(10000);

		Boolean paymentdateDisplay = paymentDate.isDisplayed();
		log.info("Is displaye payment date option ?" + paymentdateDisplay);
		
		boolean chooseAmountDropDown = chooseAmount.isDisplayed();
		log.info("Is Choose amount dropdown is displayed? " +chooseAmountDropDown);
		
		chooseAmount.click();
		chooseAmountOption.click();
		
		boolean isDisplayedContinuebtn = continueBtn.isDisplayed();
		log.info("Continue button is displayed? " +isDisplayedContinuebtn);
		
		chooseMethodDropdown.click();
		otherPaymentMethodOption.click();
		log.info("Other is selected as payment method");
		
		bankAccountOption.click();
		
		boolean accType = accountType.isDisplayed();
		log.info("Account Type is displayed ?" +accType);

		String routingNum= routingNumber.getText();
		log.info("Routing number is: " +routingNum);
		
		String accNum= accountNumber.getText();
		log.info("Account number is: " +accNum);
		
		boolean removeCard = removedBankAccBtn.isDisplayed();
		log.info("Remove Card button is displayed ?" +removeCard);
		
		boolean isDisplayedCancelBtn = cancelBtn.isDisplayed();
		log.info("Cancel button is displayed ?" +isDisplayedCancelBtn);
		
		softAssert.assertTrue(paymentdateDisplay, "Payment date is not displayed");
		softAssert.assertTrue(chooseAmountDropDown, "Choose amount dropdown is not displayed");
		softAssert.assertTrue(accType, "Account type is not displayed");	
		softAssert.assertEquals(routingNum,map.get("RoutingNumber"), "Routing number is not correct");
		softAssert.assertEquals(accNum, map.get("AccountNumber"),"Account number is not correct");
		softAssert.assertTrue(isDisplayedContinuebtn, "Continue button is not displayed");	
		softAssert.assertTrue(isDisplayedCancelBtn,"Cancel button is not displayed");

	}

	//Toolkit message available on make a payment page
	public boolean isDisplayedMakePaymentToolkit() {
		Waits.explicitWaitForElementVisible(MakePaymentModal);
		SoftAssert softAssert = new SoftAssert();
		Actions a = new Actions(driver);
		a.moveToElement(makePaymentToolkit).perform();
		boolean makePaymentToolkitIcon = makeAPayment.isDisplayed();
		log.info("Make a payment toolkit icon is displayed? " +makePaymentToolkitIcon);
		softAssert.assertTrue(makePaymentToolkitIcon);
		return makePaymentToolkitIcon;
	}
	
	//Verify E-ComplishFee for Non SC/KY user
	public void verifyNonSCKYUser(HashMap<String, String> map) throws InterruptedException {
		Waits.explicitWaitForElementVisible(makeAPayment); 
		
		SoftAssert softAssert = new SoftAssert();
		Thread.sleep(5000);
		clickOnMakePayment();
		
		chooseAmount.click();
		chooseAmountOption.click();
		
		cvvNumber.sendKeys(map.get("CVV"));
		
		String feeMsg = feeMessage.getText();
		log.info("Fee message for non SC & KY user is: " +feeMsg);
		
		continueBtn.click();
		
		boolean isfeeDisplayed = eComplishFee.isDisplayed();
		log.info("E-complish fee is displayed $3.99? " +isfeeDisplayed);
		
		String totalPayment= totalAmount.getText();
		log.info("Total amount is: " +totalPayment);
		
		softAssert.assertEquals(feeMsg, map.get("FeeMessage"),"Fee message is not displayed");
		softAssert.assertTrue(isfeeDisplayed, "E-complish Fee is not displayed");
		softAssert.assertEquals(totalPayment, map.get("TotalAmount"),"Actual and expected value is different ");
		softAssert.assertAll();
	}
	
	//Verify E-ComplishFee for SC/KY user
	public void verifyKYSCUser(HashMap<String, String> map) throws InterruptedException {
		Waits.explicitWaitForElementVisible(makeAPayment); 
		
		SoftAssert softAssert = new SoftAssert();
		Thread.sleep(5000);
		makeAPayment.click();
		
		chooseAmount.click();
		chooseAmountOption.click();
		
		cardNumber.sendKeys(map.get("CardNumber"));
		expirationDate.sendKeys(map.get("ExpiryDate"));
		cvvNumber.sendKeys(map.get("CVV"));
		
		String feeMsg = feeMessage.getText();
		log.info("Fee message for KY user is: " +feeMsg);
		
		continueBtn.click();
		
		boolean isfeeDisplayed = eComplishFee.isDisplayed();
		log.info("Is E-complish fee $0 ? " +isfeeDisplayed);
		
		String totalPayment= totalAmount.getText();
		log.info("Total amount is: " +totalPayment);
		
		softAssert.assertEquals(feeMsg, map.get("FeeMessage"),"Fee message is not displayed");
		softAssert.assertTrue(isfeeDisplayed, "E-complish Fee is not displayed");
		softAssert.assertEquals(totalPayment, map.get("TotalAmount"),"Actual and expected value is different ");
		softAssert.assertAll();
	}
	
	//verify E-complish fee when user select payment method as Bank account
	public void makeAPaymentAsBankAccount(HashMap<String, String> map) throws InterruptedException {
		Waits.explicitWaitForElementVisible(makeAPayment); 
		
		SoftAssert softAssert = new SoftAssert();
		Thread.sleep(5000);
		makeAPayment.click();
		
		chooseAmount.click();
		chooseAmountOption.click();
		
		chooseMethodDropdown.click();
		
		otherPaymentMethodOption.click();
		log.info("Other is selected as payment method");
		
		bankAccountOption.click();
		softAssert.assertFalse(feeMessage.isDisplayed(),"E-complish fee message should not display when payment is done using Bank account"); ;
		
		continueBtn.click();
		softAssert.assertFalse(eComplishFee.isDisplayed(),"E-complish fee amount should not display ");		
		
		String totalPayment = totalAmount.getText();
		log.info("Total amount is: " +totalPayment);
		
		//softAssert.assertEquals(feeMsg, map.get("FeeMessage"),"Fee message is displayed");
		//softAssert.assertTrue(isfeeDisplayed, "E-complish Fee is displayed");
		softAssert.assertEquals(totalPayment, map.get("TotalAmount"),"Actual and expected value is different ");
		softAssert.assertAll();
		
	}
	
	//Verify error message when user enter past date manually
	public void verifyPastPaymentDate(HashMap<String, String> map) throws InterruptedException {
		Waits.explicitWaitForElementVisible(makeAPayment);
		
		SoftAssert softAssert = new SoftAssert();
		Thread.sleep(5000);
		clickOnMakePayment();
		Thread.sleep(10000);

		paymentDate.sendKeys(map.get("PaymenDate"));
		log.info("Specified date is"  +map.get("PaymenDate"));
		
		chooseAmount.click();
		chooseOtherAmountOption.click();
			
		customAmount.sendKeys(map.get("OtherAmount"));
		log.info("Specified Amount is"  +map.get("OtherAmount"));
		
		cardNumber.sendKeys(map.get("CardNumber"));
		expirationDate.sendKeys(map.get("ExpiryDate"));
		cvvNumber.sendKeys(map.get("CVV"));
		
		continueBtn.click();
		String errorMsg = pastDateErrorMsg.getText();
		log.info("Error message is: "+errorMsg);
		
		softAssert.assertEquals(errorMsg, map.get("ErrorMessage"),"Error message is different");
		softAssert.assertAll();
	}
	
	//verify Warning Message when 
	public void verifyWarningMsgPayDateAfterLoanDate(HashMap<String, String> map) throws InterruptedException {
		Waits.explicitWaitForElementVisible(makeAPayment);
		
		SoftAssert softAssert = new SoftAssert();
		Thread.sleep(5000);
		clickOnMakePayment();
		Thread.sleep(10000);

		paymentDate.sendKeys(map.get("PaymenDate"));
		log.info("Specified date is"  +map.get("PaymenDate"));
		
		boolean isDisplayedWarningMsgMakePaymentPage = loanDueDateWarningMsg.isDisplayed();
		log.info("Warning message is displayed: "+isDisplayedWarningMsgMakePaymentPage);
		
		String makePaymentwarningMsg = loanDueDateWarningMsg.getText();
		log.info("Warning message on make a payment is : " +makePaymentwarningMsg);
		
		chooseAmount.click();
		chooseOtherAmountOption.click();
			
		customAmount.sendKeys(map.get("OtherAmount"));
		cardNumber.sendKeys(map.get("CardNumber"));
		expirationDate.sendKeys(map.get("ExpiryDate"));
		cvvNumber.sendKeys(map.get("CVV"));
		
		continueBtn.click();
		boolean isDisplayedWarningMsgOnReviewPage = loanDueDateWarningMsg.isDisplayed();
		log.info("Warning message on review page is : "+isDisplayedWarningMsgOnReviewPage);
		
		String WarningMsgOnReviewPage = loanDueDateWarningMsg.getText();
		log.info("Warning message on review page is : "+WarningMsgOnReviewPage);
		
		softAssert.assertEquals(makePaymentwarningMsg, map.get("WarningMessage"), "Warning message is not correct");
		softAssert.assertTrue(isDisplayedWarningMsgOnReviewPage, "Warning message is not correct");
		
		softAssert.assertEquals(WarningMsgOnReviewPage, map.get("WarningMessage"), "Warning message is not correct");
		softAssert.assertTrue(isDisplayedWarningMsgOnReviewPage, "Warning message is not correct");
		
		softAssert.assertAll();
	}
	
	public void paymentReviewPageWarningMessage(HashMap<String, String> map) throws InterruptedException {
		Waits.explicitWaitForElementVisible(makeAPayment);

		SoftAssert softAssert = new SoftAssert();
		Thread.sleep(5000);
		clickOnMakePayment();
		Thread.sleep(10000);

		paymentDate.sendKeys(map.get("PaymenDate"));
		log.info("Specified date is"  +map.get("PaymenDate"));
		
		boolean isDisplayedWarningMsgMakePaymentPage = loanDueDateWarningMsg.isDisplayed();
		log.info("Warning message on make payment page is displayed: "+isDisplayedWarningMsgMakePaymentPage);
		
		String makePaymentwarningMsg = loanDueDateWarningMsg.getText();
		log.info("Warning message on make a payment is : " +makePaymentwarningMsg);
		
		chooseAmount.click();
		chooseOtherAmountOption.click();
			
		customAmount.sendKeys(map.get("OtherAmount"));
		cardNumber.sendKeys(map.get("CardNumber"));
		expirationDate.sendKeys(map.get("ExpiryDate"));
		cvvNumber.sendKeys(map.get("CVV"));
		
		continueBtn.click();
		boolean isDisplayedWarningMsgOnReviewPage = loanDueDateWarningMsg.isDisplayed();
		log.info("Warning message on review page is : "+isDisplayedWarningMsgOnReviewPage);
		
		String WarningMsgOnReviewPage = loanDueDateWarningMsg.getText();
		log.info("Warning message on review page is : "+WarningMsgOnReviewPage);
		
		boolean isDisplayedReviewPageMsg = reviewPageWarningMsg.isDisplayed();
		log.info("Review page warning message is displayed: "+isDisplayedReviewPageMsg);
		
		String reviewPageMsg = reviewPageWarningMsg.getText();
		log.info("Review page warning message is displayed: "+reviewPageMsg);
		
		softAssert.assertTrue(isDisplayedReviewPageMsg,"Warning message is not correct");
		softAssert.assertEquals(reviewPageMsg, map.get("ReviewWarningMessage"), "Warning message is not correct");
		softAssert.assertAll();
	}
	
	//Specifying all valid details in make a payment pop up, click on "Cancel' button 
	public void verifyPopUpclickOnCancel(HashMap<String, String> map) throws InterruptedException {
		Waits.explicitWaitForElementVisible(makeAPayment); 
		
		SoftAssert softAssert = new SoftAssert();
		Thread.sleep(5000);
		clickOnMakePayment();
		Thread.sleep(10000);

		paymentDate.sendKeys(map.get("PaymenDate"));
		log.info("Specified date is: "  +map.get("PaymenDate"));
		
		chooseAmount.click();
		chooseAmountOption.click();
		
		cardNumber.sendKeys(map.get("CardNumber"));
		log.info("Specified card number is: "  +map.get("CardNumber"));

		
		expirationDate.sendKeys(map.get("ExpiryDate"));
		log.info("Specified expiry date is: "  +map.get("ExpiryDate"));

		cvvNumber.sendKeys(map.get("CVV"));
		log.info("Specified CVV number is: "  +map.get("CVV"));


		cancelBtn.click();
		makeAPayment.click();
		boolean modal = MakePaymentModal.isEnabled();
		log.info("Make a payment pop up is closed: " +modal);
		
		softAssert.assertTrue(modal, "Make a payment pop up is closed");
		softAssert.assertAll();
	}
	
	public void verifyPopUpclickOnContinue(HashMap<String, String> map) throws InterruptedException {
		Waits.explicitWaitForElementVisible(makeAPayment); 
		
		SoftAssert softAssert = new SoftAssert();
		Thread.sleep(5000);
		clickOnMakePayment();
		Thread.sleep(10000);

		paymentDate.sendKeys(map.get("PaymenDate"));
		log.info("Specified date is: "  +map.get("PaymenDate"));
		
		chooseAmount.click();
		chooseAmountOption.click();
		
		cardNumber.sendKeys(map.get("CardNumber"));
		log.info("Specified card number is: "  +map.get("CardNumber"));

		
		expirationDate.sendKeys(map.get("ExpiryDate"));
		log.info("Specified expiry date is: "  +map.get("ExpiryDate"));

		cvvNumber.sendKeys(map.get("CVV"));
		log.info("Specified CVV number is: "  +map.get("CVV"));
	
		continueBtn.click();
		boolean isDisplayedReviewHeading = reviewHeading.isDisplayed();
		log.info("Review heading is displayed: " +isDisplayedReviewHeading);
		
		softAssert.assertAll();
	}
	
	public void verifyReviewPopUPInfoWithDebitCard(HashMap<String, String> map) throws InterruptedException {
		Waits.explicitWaitForElementVisible(makeAPayment); 
		
		SoftAssert softAssert = new SoftAssert();
		Thread.sleep(5000);
		clickOnMakePayment();
		Thread.sleep(10000);
		
		paymentDate.sendKeys(map.get("PaymenDate"));
		log.info("Specified date is"  +map.get("PaymenDate"));
		
		chooseAmount.click();
		chooseOtherAmountOption.click();
			
		customAmount.sendKeys(map.get("OtherAmount"));
		cardNumber.sendKeys(map.get("CardNumber"));
		expirationDate.sendKeys(map.get("ExpiryDate"));
		cvvNumber.sendKeys(map.get("CVV"));
		
		continueBtn.click();
		boolean isDisplayedReviewHeading = reviewHeading.isDisplayed();
		log.info("Review heading is displayed: " +isDisplayedReviewHeading);
		
		String payDate = reviewPagePaymentDate.getText();
		log.info("Specified Date is :" +payDate);
		
		String payAmount = reviewPagePaymentAmount.getText();
		log.info("Payment amount is :" +payAmount);

		String payMethod = reviewPagePaymentMethod.getText();
		log.info("Specified Method is: " +payMethod);
		
		String eFee = reviewPageEcomplishFee.getText();
		log.info("E-complish fee is :" +eFee);
		
		String payTotal = reviewPageTotalAmount.getText();
		log.info("Total amount is: " +payTotal);
		
		boolean autorizationHeading = paymentAuthHeading.isDisplayed();
		log.info("Payment autorization is displayed? " +autorizationHeading);
		
		boolean noticeFee = noticeInformation.isDisplayed();
		log.info("Notice information is displayed? " +noticeFee);
		
		boolean postingInfo = paymentPostingInfo.isDisplayed();
		log.info("Payment posting information is displayed? " +postingInfo);
		
		boolean backBtn = backButton.isDisplayed();
		log.info("Back button is displayed? " +backBtn);

		boolean payBtn = payButton.isDisplayed();
		log.info("Payment button is displayed? " +payBtn);
		
		softAssert.assertEquals(payDate, map.get("ReviewPagePaymentDate"),"Actual and expected value is different");
		softAssert.assertEquals(payAmount, map.get("ReviewPagePaymentAmount"),"Actual and expected value is different");
		softAssert.assertEquals(payMethod, map.get("ReviewPagePaymentMethod"),"Actual and expected value is different");
		softAssert.assertEquals(eFee, map.get("ReviewPageEFee"),"Actual and expected value is different");
		softAssert.assertEquals(payTotal, map.get("ReviewPageTotalAmount"),"Actual and expected value is different");

		softAssert.assertTrue(autorizationHeading, "Autorization Heading is not displayed");
		softAssert.assertTrue(noticeFee, "Notice Fee is not displayed");
		softAssert.assertTrue(postingInfo, "Posting information is not displayed");
		softAssert.assertTrue(backBtn, "Back button is not displayed");
		softAssert.assertTrue(payBtn, "Payment button is not displayed");

		softAssert.assertAll();
	}
	
	public void verifyReviewPopUPInfoWithBankInfo(HashMap<String, String> map) throws InterruptedException {
		Waits.explicitWaitForElementVisible(makeAPayment); 
		
		SoftAssert softAssert = new SoftAssert();
		Thread.sleep(5000);
		clickOnMakePayment();
		Thread.sleep(10000);
		
		paymentDate.sendKeys(map.get("PaymenDate"));
		log.info("Specified date is"  +map.get("PaymenDate"));
		
		chooseAmount.click();
		chooseOtherAmountOption.click();
		
		chooseMethodDropdown.click();
		otherPaymentMethodOption.click();
		log.info("Other is selected as payment method");
		
		bankAccountOption.click();
			
		continueBtn.click();
		boolean isDisplayedReviewHeading = reviewHeading.isDisplayed();
		log.info("Review heading is displayed: " +isDisplayedReviewHeading);
		
		String payDate = reviewPagePaymentDate.getText();
		log.info("Specified Date is :" +payDate);
		
		String payAmount = reviewPagePaymentAmount.getText();
		log.info("Payment amount is :" +payAmount);

		String payMethod = reviewPagePaymentMethod.getText();
		log.info("Specified Method is: " +payMethod);
		
		String payTotal = reviewPageTotalAmount.getText();
		log.info("Total amount is: " +payTotal);
		
		String statementInfo = bankAccStatementInfo.getText();
		log.info("Statement information is:" + statementInfo);
		
		boolean autorizationHeading = paymentAuthHeading.isDisplayed();
		log.info("Payment autorization is displayed? " +autorizationHeading);
		
		boolean noticeFee = noticeInformation.isDisplayed();
		log.info("Notice information is displayed? " +noticeFee);
		
		boolean postingInfo = paymentPostingInfo.isDisplayed();
		log.info("Payment posting information is displayed? " +postingInfo);
		
		boolean backBtn = backButton.isDisplayed();
		log.info("Back button is displayed? " +backBtn);

		boolean payBtn = payButton.isDisplayed();
		log.info("Payment button is displayed? " +payBtn);
		
		softAssert.assertEquals(payDate, map.get("ReviewPagePaymentDate"),"Actual and expected value is different");
		softAssert.assertEquals(payAmount, map.get("ReviewPagePaymentAmount"),"Actual and expected value is different");
		softAssert.assertEquals(payMethod, map.get("ReviewPagePaymentMethod"),"Actual and expected value is different");
		softAssert.assertEquals(statementInfo, map.get("StatementMessage"),"Actual and expected value is different");
		softAssert.assertEquals(payTotal, map.get("ReviewPageTotalAmount"),"Actual and expected value is different");

		softAssert.assertTrue(autorizationHeading, "Autorization Heading is not displayed");
		softAssert.assertTrue(noticeFee, "Notice Fee is not displayed");
		softAssert.assertTrue(postingInfo, "Posting information is not displayed");
		softAssert.assertTrue(backBtn, "Back button is not displayed");
		softAssert.assertTrue(payBtn, "Payment button is not displayed");

		softAssert.assertAll();
	}
	
	public void verifyPaymentAuthInfo(HashMap<String, String> map) throws InterruptedException {
		Waits.explicitWaitForElementVisible(makeAPayment); 
		
		SoftAssert softAssert = new SoftAssert();
		Thread.sleep(5000);
		clickOnMakePayment();
		Thread.sleep(10000);
		
		paymentDate.sendKeys(map.get("PaymenDate"));
		log.info("Specified date is"  +map.get("PaymenDate"));
		
		chooseAmount.click();
		chooseOtherAmountOption.click();
			
		customAmount.sendKeys(map.get("OtherAmount"));
		cardNumber.sendKeys(map.get("CardNumber"));
		expirationDate.sendKeys(map.get("ExpiryDate"));
		cvvNumber.sendKeys(map.get("CVV"));
		
		continueBtn.click();
		
		String payAuth1 = paymentAuthInfo1.getText();
		log.info("Payment Authorization info is :" +payAuth1);
		
		String PayAuth2 = paymentAuthInfo2.getText();
		log.info("Payment Authorization message is :"+PayAuth2);
		
		String PayAuthCustName = paymentAuthCustomerName.getText();
		log.info("Payment Authorization Customer name is :"+PayAuthCustName);
		
		String payAmount = paymentAuthAmount.getText();
		log.info("Payment Authorization amount: " +payAmount);
		
		String payMethod = paymentAuthDebit.getText();
		log.info("Payment authorization method: "+payMethod);
		
		String payDate = paymentAuthDate.getText();
		log.info("Payment autorization date is: " +payDate);
		

		softAssert.assertEquals(payAuth1, map.get("PaymentAuthInformation"),"Actual and expected value is different");
		softAssert.assertEquals(PayAuth2, map.get("PaymentAuthInformationMessage"),"Actual and expected value is different");
		softAssert.assertEquals(PayAuthCustName, map.get("PaymentAuthorizationCustomerName"),"Actual and expected value is different");
		softAssert.assertEquals(payAmount, map.get("PaymentAuthorizationPaymentAmount"),"Actual and expected value is different");
		softAssert.assertEquals(payMethod, map.get("PaymentAuthorizationDebitInfo"),"Actual and expected value is different");
		softAssert.assertEquals(payDate, map.get("PaymentAuthorizationPaymentDate"),"Actual and expected value is different");
		softAssert.assertAll();
	}
	
	public void verifyPaymentAuthInfoWithBank(HashMap<String, String> map) throws InterruptedException {
		Waits.explicitWaitForElementVisible(makeAPayment); 
		
		SoftAssert softAssert = new SoftAssert();
		Thread.sleep(5000);
		clickOnMakePayment();
		Thread.sleep(10000);
		
		paymentDate.sendKeys(map.get("PaymenDate"));
		log.info("Specified date is"  +map.get("PaymenDate"));
		
		chooseAmount.click();
		chooseAmountOption.click();
		
		chooseMethodDropdown.click();
		otherPaymentMethodOption.click();
		log.info("Other is selected as payment method");
		
		bankAccountOption.click();
		Thread.sleep(2000);	
		
		continueBtn.click();
		String payAuth = paymentAuthBankInfoMsg.getText();
		log.info("Payment Authorization info is :" +payAuth);
		
		String PayAuthCustName = PayAuthBankCustName.getText();
		log.info("Payment Authorization by bank Customer name is :"+PayAuthCustName);
		
		String payAmount = payAuthBankAmount.getText();
		log.info("Payment Authorization amount: " +payAmount);
		
		String payAccNo = worldAccNumber.getText();
		log.info("Payment Authorization world account number is : " +payAccNo);
		
		String payMethod = bankAccLastDigitNumber.getText();
		log.info("Payment authorization method: "+payMethod);
		
		String payDate = payAuthBankDate.getText();
		log.info("Payment autorization date is: " +payDate);
		

		softAssert.assertEquals(payAuth, map.get("PaymentAuthInformation"),"Actual and expected value is different");
		softAssert.assertEquals(PayAuthCustName, map.get("PaymentAuthorizationCustomerName"),"Actual and expected value is different");
		softAssert.assertEquals(payAmount, map.get("PaymentAuthorizationPaymentAmount"),"Actual and expected value is different");
		softAssert.assertEquals(payAccNo, map.get("WorldAccountNumber"),"Actual and expected value is different");
		softAssert.assertEquals(payMethod, map.get("PaymentAuthorizationDebitInfo"),"Actual and expected value is different");
		softAssert.assertEquals(payDate, map.get("PaymentAuthorizationPaymentDate"),"Actual and expected value is different");
		softAssert.assertAll();
	}
	
	public void verifyNoticeInfo(HashMap<String, String> map) throws InterruptedException {
		Waits.explicitWaitForElementVisible(makeAPayment); 
		
		SoftAssert softAssert = new SoftAssert();
		Thread.sleep(5000);
		clickOnMakePayment();
		Thread.sleep(10000);
		
		paymentDate.sendKeys(map.get("PaymenDate"));
		log.info("Specified date is"  +map.get("PaymenDate"));
		
		chooseAmount.click();
		chooseOtherAmountOption.click();
			
		customAmount.sendKeys(map.get("OtherAmount"));
		cardNumber.sendKeys(map.get("CardNumber"));
		expirationDate.sendKeys(map.get("ExpiryDate"));
		cvvNumber.sendKeys(map.get("CVV"));
		
		continueBtn.click();
		
		String noticeInfo = niticeInfoSection.getText();
		log.info("E-notice info is: " +noticeInfo);
		
		String eNoticeAmount = noticeSection.getText();
		log.info("Total amount is : " +eNoticeAmount);
		
		softAssert.assertEquals(noticeInfo, map.get("NoticeInfo"),"Actual and expected value is different");
		softAssert.assertEquals(eNoticeAmount, map.get("NoticeAmount"),"Actual and expected value is different");
		softAssert.assertAll();
	}
	
	public void verifyNoticeInfoBank(HashMap<String, String> map) throws InterruptedException {
	Waits.explicitWaitForElementVisible(makeAPayment); 
		
		SoftAssert softAssert = new SoftAssert();
		Thread.sleep(5000);
		clickOnMakePayment();
		Thread.sleep(10000);
		
		paymentDate.sendKeys(map.get("PaymenDate"));
		log.info("Specified date is"  +map.get("PaymenDate"));
		
		chooseAmount.click();
		chooseAmountOption.click();
		
		chooseMethodDropdown.click();
		otherPaymentMethodOption.click();
		log.info("Other is selected as payment method");
		
		bankAccountOption.click();
			
		continueBtn.click();
		
		boolean paymentPost = niticeInfoSection.isDisplayed();
		log.info("E-notice info is displayed: " +paymentPost);
		
		softAssert.assertFalse(paymentPost,"Actual and expected value is different");
		softAssert.assertAll();
	}
	
	public void verifyPaymentPostingInfo(HashMap<String, String> map) throws InterruptedException {
		Waits.explicitWaitForElementVisible(makeAPayment); 
		
		SoftAssert softAssert = new SoftAssert();
		Thread.sleep(5000);
		clickOnMakePayment();
		Thread.sleep(10000);
		
		paymentDate.sendKeys(map.get("PaymenDate"));
		log.info("Specified date is"  +map.get("PaymenDate"));
		
		chooseAmount.click();
		chooseOtherAmountOption.click();
			
		customAmount.sendKeys(map.get("OtherAmount"));
		cardNumber.sendKeys(map.get("CardNumber"));
		expirationDate.sendKeys(map.get("ExpiryDate"));
		cvvNumber.sendKeys(map.get("CVV"));
		
		continueBtn.click();
		
		String paymentPostSec = paymentPostingSection.getText();
		log.info("Notice information is :" + paymentPostSec);
		
		softAssert.assertEquals(paymentPostSec, map.get("paymentPostingInfo"),"Actual and expected value is different");
		softAssert.assertAll();
	}
	
	public void verifyCancelButton(HashMap<String, String> map) throws InterruptedException {
		Waits.explicitWaitForElementVisible(makeAPayment); 
		
		SoftAssert softAssert = new SoftAssert();
		Thread.sleep(5000);
		clickOnMakePayment();
		Thread.sleep(10000);
		
		paymentDate.sendKeys(map.get("PaymenDate"));
		log.info("Specified date is"  +map.get("PaymenDate"));
		
		chooseAmount.click();
		chooseOtherAmountOption.click();
			
		customAmount.sendKeys(map.get("OtherAmount"));
		cardNumber.sendKeys(map.get("CardNumber"));
		expirationDate.sendKeys(map.get("ExpiryDate"));
		cvvNumber.sendKeys(map.get("CVV"));
		
		continueBtn.click();
		
		backButton.click();
		boolean modalHeading = makeAPaymentHeading.isDisplayed();
		log.info("Navigate to make a payment page : " +modalHeading);
		
		softAssert.assertTrue(modalHeading, "User is not navigated to make a payment page");
		softAssert.assertAll();
		
	}
	
	public void verifyPyamentAmount(HashMap<String, String> map) throws InterruptedException {
		Waits.explicitWaitForElementVisible(makeAPayment); 
		
		SoftAssert softAssert = new SoftAssert();
		Thread.sleep(5000);
		clickOnMakePayment();
		Thread.sleep(10000);
		
		paymentDate.sendKeys(map.get("PaymenDate"));
		log.info("Specified date is"  +map.get("PaymenDate"));
		
		chooseAmount.click();
		chooseOtherAmountOption.click();
			
		customAmount.sendKeys(map.get("OtherAmount"));
		cardNumber.sendKeys(map.get("CardNumber"));
		expirationDate.sendKeys(map.get("ExpiryDate"));
		cvvNumber.sendKeys(map.get("CVV"));
		
		continueBtn.click();
		
	
		String payButton = payButtonAmount.getText();
		log.info("Amount on Payment button is : " +payButton);
		
		softAssert.assertEquals(payButton, map.get("TotalAmountOnPay"), "User is not navigated to make a payment page");
		softAssert.assertAll();
		
	}
	
	public void verifySubmitPayment(HashMap<String, String> map) throws InterruptedException {
		Waits.explicitWaitForElementVisible(makeAPayment); 
		
		SoftAssert softAssert = new SoftAssert();
		Thread.sleep(5000);
		clickOnMakePayment();
		Thread.sleep(10000);
		
		paymentDate.sendKeys(map.get("PaymenDate"));
		log.info("Specified date is"  +map.get("PaymenDate"));
		
		chooseAmount.click();
		chooseOtherAmountOption.click();
			
		customAmount.sendKeys(map.get("OtherAmount"));
		cardNumber.sendKeys(map.get("CardNumber"));
		expirationDate.sendKeys(map.get("ExpiryDate"));
		cvvNumber.sendKeys(map.get("CVV"));
		
		continueBtn.click();
		payButton.click();
		
		paymentContinue.click();
		log.info("Payment is done successfully");
		softAssert.assertAll();
		
	}
	
	public void verifyPartialPaymentWarningMsg(HashMap<String, String> map) throws InterruptedException {
		Waits.explicitWaitForElementVisible(makeAPayment); 
		
		SoftAssert softAssert = new SoftAssert();
		Thread.sleep(5000);
		clickOnMakePayment();
		Thread.sleep(10000);
		
		paymentDate.sendKeys(map.get("PaymenDate"));
		log.info("Specified date is"  +map.get("PaymenDate"));
		
		chooseAmount.click();
		chooseOtherAmountOption.click();
			
		customAmount.sendKeys(map.get("OtherAmount"));
		
		boolean warningInfo = partialPaymentMsg.isDisplayed();
		log.info("Partial payment info is displayed : " +warningInfo);
		
		String warningInfoText = partialPaymentMsg.getText();
		log.info("Warning message is:" +warningInfoText);
		
		softAssert.assertEquals(warningInfoText, map.get("partialPaymentMsg"), "Actual and expected value is different");
		softAssert.assertTrue(warningInfo, "Partial payment warning message is not displayed");
		softAssert.assertAll();
	}
	
	public void verifyReceiptModal(HashMap<String, String> map) throws InterruptedException {
		Waits.explicitWaitForElementVisible(makeAPayment); 
		
		SoftAssert softAssert = new SoftAssert();
		Thread.sleep(5000);
		clickOnMakePayment();
		Thread.sleep(10000);
		
		paymentDate.sendKeys(map.get("PaymenDate"));
		log.info("Specified date is"  +map.get("PaymenDate"));
		
		chooseAmount.click();
		chooseOtherAmountOption.click();
			
		customAmount.sendKeys(map.get("OtherAmount"));
		cardNumber.sendKeys(map.get("CardNumber"));
		expirationDate.sendKeys(map.get("ExpiryDate"));
		cvvNumber.sendKeys(map.get("CVV"));
		
		continueBtn.click();
		
		payButton.click();
		paymentContinue.click();
		
		
		String payDate = receiptDate.getText();
		log.info("Recipt Payment autorization date is: " +payDate);
		
		String receiptCustName = reciptPaidByName.getText();
		log.info("Recipt Payment Authorization Customer name is :"+receiptCustName);
		
		String receiptCustAddress = receiptAddress.getText();
		log.info("Recipt Payment Authorization Customer Address is :"+receiptCustAddress);
		
		String receiptCustEmail = receiptEmail.getText();
		log.info("Recipt Payment Authorization Customer email is :"+receiptCustEmail);
		
		String status = receiptStatus.getText();
		log.info("Recipt Payment Authorization Customer status is :"+status);
		
		String payAmount = receiptAmount.getText();
		log.info("Recipt Payment Authorization amount: " +payAmount);
		
		String payMethod = receiptDebitMethod.getText();
		log.info("Recipt Payment authorization method: "+payMethod);
	
		String receiptfee = receiptEFee.getText();
		log.info("Recipt Payment E-Complish fee is:  "+receiptfee);
		
		String receiptTotal = receiptTotalAmount.getText();
		log.info("Recipt Payment total amount is:  "+receiptTotal);
		
		boolean receiptTrackNumber = receiptTrackingNumber.isDisplayed();
		log.info("Recipt track number is displayed:  "+receiptTrackNumber);
		
		boolean receiptApprovalNumber = receiptApprovalCode.isDisplayed();
		log.info("Recipt Approval number is displayed :  "+receiptApprovalNumber);
		
		String receiptAuth1 = paymentAuthInfo1.getText();
		log.info("Recipt payment Authorization info is :" +receiptAuth1);
		
		String receiptAuth2 = paymentAuthInfo2.getText();
		log.info("Recipt payment Authorization message is :"+receiptAuth2);
		
		String notice = niticeInfoSection.getText();
		log.info("Notice information on receipt page is: " +notice);
		
		String PaymentPost = paymentPostingSection.getText();
		log.info("Payment posting information on receipt page is : " +PaymentPost);
		
		boolean closeBtn = closeButton.isDisplayed();
		log.info("Close button is displayed: " +closeBtn);
		
		boolean printBtn = printButton.isDisplayed();
		log.info("Print button is displayed: " +printBtn);
		
		
		softAssert.assertEquals(payDate, map.get("PaymentAuthorizationPaymentDate"),"Date Actual and expected value is different");
		softAssert.assertEquals(receiptCustName, map.get("reciptPaidCustomerName"),"Name Actual and expected value is different");
		softAssert.assertEquals(receiptCustAddress, map.get("receiptAddress"),"Address Actual and expected value is different");
		softAssert.assertEquals(receiptCustEmail, map.get("receiptEmail"),"Email Actual and expected value is different");
		softAssert.assertEquals(status, map.get("Status"),"Status Actual and expected value is different");
		softAssert.assertEquals(payAmount, map.get("receiptAmount"),"Amount Actual and expected value is different");
		softAssert.assertEquals(payMethod, map.get("PaymentAuthorizationDebitInfo"),"Method Actual and expected value is different");
		softAssert.assertEquals(receiptfee, map.get("ReceiptEFee"),"Fee Actual and expected value is different");
		softAssert.assertEquals(receiptTotal,map.get("TotalAmountOnPay"),"Total Actual and expected value is different");
		softAssert.assertTrue(receiptTrackNumber, "Track Actual and expected value is different");
		softAssert.assertTrue(receiptApprovalNumber, "Approval Actual and expected value is different");
		softAssert.assertEquals(receiptAuth1, map.get("PaymentAuthInformation"),"Auth1 Actual and expected value is different");
		softAssert.assertEquals(receiptAuth2, map.get("PaymentAuthInformationMessage"),"Auth2 Actual and expected value is different");
		softAssert.assertEquals(notice, map.get("NoticeInfo"),"Notice Actual and expected value is different");
		softAssert.assertEquals(PaymentPost, map.get("paymentPostingInfo"),"Post Actual and expected value is different");
		softAssert.assertTrue(printBtn, "Print button is not displayed");
		softAssert.assertTrue(closeBtn, "Print button is not displayed");

		softAssert.assertTrue(closeBtn);
		softAssert.assertAll();
	}
	
	public void verifyReceiptPopUPInfoWithBankInfo(HashMap<String, String> map) throws InterruptedException {
		Waits.explicitWaitForElementVisible(makeAPayment);
		
		SoftAssert softAssert = new SoftAssert();
		Thread.sleep(5000);
		clickOnMakePayment();
		Thread.sleep(10000);

		paymentDate.sendKeys(map.get("PaymenDate"));
		log.info("Specified date is"  +map.get("PaymenDate"));
		
		boolean chooseAmountDropDown = chooseAmount.isDisplayed();
		log.info("Choose amount dropdown is displayed: " +chooseAmountDropDown);
		
		chooseAmount.click();
		
		chooseOtherAmountOption.click();
		log.info("Amount due options is selected");
		
		customAmount.sendKeys(map.get("OtherAmount"));
		log.info("Specified Amount is"  +map.get("OtherAmount"));

		chooseMethodDropdown.click();
		
		otherPaymentMethodOption.click();
		log.info("Other is selected as payment method");
		
		bankAccountOption.click();
		Thread.sleep(2000);
		continueBtn.click();
		
		payButton.click();
		paymentContinue.click();
		
		
		String payDate = receiptDate.getText();
		log.info("Recipt Payment autorization date is: " +payDate);
		
		String receiptCustName = reciptPaidByName.getText();
		log.info("Recipt Payment Authorization Customer name is :"+receiptCustName);
		
		String receiptCustAddress = receiptAddress.getText();
		log.info("Recipt Payment Authorization Customer Address is :"+receiptCustAddress);
		
		String receiptCustEmail = receiptEmail.getText();
		log.info("Recipt Payment Authorization Customer email is :"+receiptCustEmail);
		
		String status = receiptStatus.getText();
		log.info("Recipt Payment Authorization Customer status is :"+status);
		
		String payAmount = receiptAmount.getText();
		log.info("Recipt Payment Authorization amount: " +payAmount);
		
		String payMethod = receiptDebitMethod.getText();
		log.info("Recipt Payment authorization method: "+payMethod);
		
		String receiptTotal = receiptTotalAmount.getText();
		log.info("Recipt Payment total amount is:  "+receiptTotal);
		
		boolean receiptTrackNumber = receiptTrackingNumber.isDisplayed();
		log.info("Recipt track number is displayed:  "+receiptTrackNumber);
		
		boolean receiptApprovalNumber = receiptApprovalCode.isDisplayed();
		log.info("Recipt Approval number is displayed :  "+receiptApprovalNumber);
		
		String receiptAuth1 = paymentAuthBankInfo.getText();
		log.info("Recipt payment Authorization info is :" +receiptAuth1);
		

		String PaymentPost = paymentPostBanksection.getText();
		log.info("Payment posting information on receipt page is : " +PaymentPost);
		
		boolean closeBtn = closeButton.isDisplayed();
		log.info("Close button is displayed: " +closeBtn);
		
		boolean printBtn = printButton.isDisplayed();
		log.info("Print button is displayed: " +printBtn);
		
		

		
		softAssert.assertEquals(payDate, map.get("PaymentAuthorizationPaymentDate"),"Date Actual and expected value is different");
		softAssert.assertEquals(receiptCustName, map.get("reciptPaidCustomerName"),"Name Actual and expected value is different");
		softAssert.assertEquals(receiptCustAddress, map.get("receiptAddress"),"Address Actual and expected value is different");
		softAssert.assertEquals(receiptCustEmail, map.get("receiptEmail"),"Email Actual and expected value is different");
		softAssert.assertEquals(status, map.get("Status"),"Status Actual and expected value is different");
		softAssert.assertEquals(payAmount, map.get("receiptAmount"),"Amount Actual and expected value is different");
		softAssert.assertEquals(payMethod, map.get("PaymentAuthorizationDebitInfo"),"Method Actual and expected value is different");
		softAssert.assertEquals(receiptTotal,map.get("TotalAmountOnPay"),"Total Actual and expected value is different");
		softAssert.assertTrue(receiptTrackNumber, "Track Actual and expected value is different");
		softAssert.assertTrue(receiptApprovalNumber, "Approval Actual and expected value is different");
		softAssert.assertEquals(receiptAuth1, map.get("PaymentAuthInformation"),"Auth1 Actual and expected value is different");
		softAssert.assertEquals(PaymentPost, map.get("paymentPostingInfo"),"Post Actual and expected value is different");
		softAssert.assertTrue(printBtn, "Print button is not displayed");
		softAssert.assertTrue(closeBtn, "Print button is not displayed");

		softAssert.assertTrue(closeBtn);
		softAssert.assertAll();
	}	
}		