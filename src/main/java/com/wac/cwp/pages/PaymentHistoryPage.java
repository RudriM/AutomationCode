package com.wac.cwp.pages;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertFalse;

import java.util.HashMap;
import java.util.List;
import java.util.concurrent.TimeUnit;
import java.util.stream.Collector;
import java.util.stream.Collectors;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;
import org.python.antlr.PythonParser.return_stmt_return;
import org.python.antlr.ast.Assert;
import org.python.compiler.Filename;
import org.testng.asserts.SoftAssert;

import com.wac.cwp.base.TestBase;
import com.wac.cwp.helper.Waits;

public class PaymentHistoryPage extends TestBase{
	
	//Payment History Top navigation
	@FindBy(xpath = "//a[@class = 'menuItem']/span[text() = 'PAYMENT HISTORY']")
	WebElement paymentHistoryLink;
	
	//Payment History header
	@FindBy(xpath = "//div[text() = 'Payment History']")
	WebElement paymentHistoryPageHeading;
	
	//----------------------------------------------- Make a payment ---------------------------------------------------
		
	//make a payment button
	@FindBy(xpath = "//button[text() = 'Make a Payment']")
	WebElement makePaymentBtn;
	
	@FindBy(xpath = "//div[@class='modal-dialog paymentModal modal-lg modal-dialog-centered modal-dialog-scrollable']")
	WebElement makePaymentmodalWindowOpen;
	
	//Loan drop down
	@FindBy(xpath = "//div[@id = 'loan']")
	WebElement makePaymentloanDropDown;
	
	//loan drop down value selection
	@FindBy(xpath = "//ul[@role = 'listbox']/li")
	List<WebElement> makePaymentloandropdownValue;
	
	@FindBy(xpath="//input[@id='paymentDate']")
    WebElement modalPaymentDate;
		
	@FindBy(xpath = "//div[@id='select_payment_amount']")
	WebElement openSelectPaymentDropDown;
		
	@FindBy(xpath = "//ul[@Class='MuiList-root MuiList-padding MuiMenu-list css-r8u8y9']/li[1]")
	WebElement chooseAmount;
	
	@FindBy(xpath = "//ul[@Class='MuiList-root MuiList-padding MuiMenu-list css-r8u8y9']/li[2]")
	WebElement otherAmount;
		 
	@FindBy(xpath = "//input[@id = 'amount']")
	WebElement otherAmountTextBox;
	
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
	
	//----------------------------------------------- Filter Heading ----------------------------------------------------
	//Date Heading
	@FindBy(xpath = "//div[@class = 'row-payment']/div[1]/div/div/h6")
	WebElement dateFilterHeader;
	
	//Loan Header
	@FindBy(xpath = "//div[@class = 'row-payment']/div[2]/div/div/h6")
	WebElement loanFilterHeader;
	
	//Source Header
	@FindBy(xpath = "//div[@class = 'row-payment']/div[3]/div/div/h6")
	WebElement sourceFilterHeader;
	
	//Payment Method header
	@FindBy(xpath = "//div[@class = 'row-payment']/div[5]/div/div/h6")
	WebElement paymentMethodFilterHeader;

	@FindBy(xpath = "//div[@class = 'row-payment']/div[6]/div/div/h6")
	WebElement statusFilterHeader;
	
	//---------------------------------------------- Filter Drop Down -------------------------------------------------
	// Date Drop down
	@FindBy(xpath = "//div[@id = 'filter-date']")
	WebElement dateFilterDropdown;
		
	// Loan Drop down
	@FindBy(xpath = "//div[@id = 'filter-loan']")
	WebElement loanFilterDropdown;
		
	// Source Drop down
	@FindBy(xpath = "//div[@id = 'filter-source']")
	WebElement sourceFilterDropdown;
		
	// payment Method Drop down
	@FindBy(xpath = "//div[@id = 'filter-paidBy']")
	WebElement paymentMethodFilterDropdown;
	
	// status Drop down
	@FindBy(xpath = "//div[@id = 'filter-status']")
	WebElement statusFilterDropdown;
	
	//------------------------------------------------ Filter Drop down value ------------------------------------------
	
	//Date filter value
	@FindBy(xpath = "//div[@id = 'menu-filter-date']/div/ul/li")
	List<WebElement> dateFilterOption;
	
	//Loan Filter value
	@FindBy(xpath = "//div[@id = 'menu-filter-loan']/div/ul/li")
	List<WebElement> loanFilterOption;
	
	//Source Filter value
	@FindBy(xpath = "//div[@id = 'menu-filter-source']/div/ul/li")
	List<WebElement> sourceFilterOption;
	
	//Payment Method filter value
	@FindBy(xpath = "//div[@id = 'menu-filter-paidBy']/div/ul/li")
	List<WebElement> paymentMethodFilterOption;
	
	//Payment Method filter value
	@FindBy(xpath = "//div[@id = 'menu-filter-status']/div/ul/li")
	List<WebElement> statusFilterOption;
	
	//------------------------------------------------  Recent Payment section -----------------------------------------
	
	//recent payment 
	@FindBy(xpath = "//div[@class = 'list-group-item']")
	List<WebElement> recentPayments;

	
	@FindBy(xpath = "//div[text()= 'No payment history to display.']")
	WebElement noRecords;
	
	@FindBy(xpath = "(//*[local-name() ='svg'])[3]")
	WebElement loanLastUpdateToolkitIcon;
	
	@FindBy(xpath = "//div[@id = 'dataUpdate']")
	WebElement loanLastUpdatedToolkitIconMessgae;
	
	@FindBy(xpath = "//div[@class = 'list-group']//div[@class = 'card-info']/div/div/h6")
	List<WebElement> recentPaymentsDates;
	
	@FindBy(xpath = "//div[@class = 'list-group']//div[@class = 'card-info']/div/div/p")
	List<WebElement> recentpaymentsLoanNumber;
	
	@FindBy(xpath = "//div[@class = 'list-group']//div[@class = 'card-info mobile-noshow']/div/div/h6")
	List<WebElement> recentpaymentsSource;
	
	@FindBy(xpath = "//div[@class = 'list-group']//div[@class = 'card-info mobile-noshow']/div/div/p")
	List<WebElement> recentpaymentsMethod;
	
	@FindBy(xpath = "//div[@class = 'btnViewRecipt-container']/h6")
	List<WebElement> recentpaymentsStatus;
	
	@FindBy(xpath = "//div[@class = 'btnViewRecipt-container']/p")
	List<WebElement> recentpaymentsAmount;
	
	//------------------------------------------------------------------------------------------------------------------
	
	public PaymentHistoryPage() {
		PageFactory.initElements(driver, this);
	}
	
	
	//Click on PaymentHistory page
	public PaymentHistoryPage clickPaymentHistory() {
		paymentHistoryLink.click();
		log.info("Click on payment history page");
		return new PaymentHistoryPage();
	}

	//Payment History page is displayed
	public boolean isDisplayedHeading() {
		Waits.explicitWaitForElementVisible(paymentHistoryPageHeading);
		boolean pageHeading = paymentHistoryPageHeading.isDisplayed();
		return pageHeading;
	}
	
	//Make a payment button is displayed
	public boolean isDisplayedMakePaymentBtn() {
		Waits.explicitWaitForElementVisible(makePaymentBtn);
		boolean makePayment = makePaymentBtn.isDisplayed();
		return makePayment;
	}
	
	//Verify Loan Last Updated Toolkit message
	public boolean isDisplayedHistoryLoanDataToolkit() {
		SoftAssert softAssert = new SoftAssert();
		Actions a = new Actions(driver);
		a.moveToElement(loanLastUpdateToolkitIcon).perform();
		driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
		boolean loanUpdateToolkitMessage = loanLastUpdatedToolkitIconMessgae.isDisplayed();
		softAssert.assertTrue(loanUpdateToolkitMessage);
		return loanUpdateToolkitMessage;
	}
		
		
	//Verify Payment History Page
	public void verifyPaymentHistoryPage(HashMap<String, String> map) {
		Waits.explicitWaitForElementVisible(paymentHistoryLink);

		SoftAssert softAssert = new SoftAssert();
		paymentHistoryLink.click();
		Waits.explicitWaitForElementVisible(paymentHistoryPageHeading);

		boolean makePaymentBtnDisplayed = makePaymentBtn.isDisplayed();
		log.info("Make a payment button is displayed?" +makePaymentBtnDisplayed);
		
		boolean dateFilter = dateFilterHeader.isDisplayed();
		log.info("Date filter is displayed?" +dateFilter);

		boolean loanFilter = loanFilterHeader.isDisplayed();
		log.info("Loan filter is displayed?" +loanFilter);
		
		boolean sourceFilter = sourceFilterHeader.isDisplayed();
		log.info("Source filter is displayed?" +sourceFilter);
		
		boolean paymentMethodFilter = paymentMethodFilterHeader.isDisplayed();
		log.info("Payment method filter is displayed?" +paymentMethodFilter);
		
		boolean statusFilter = statusFilterHeader.isDisplayed();
		log.info("status filter is displayed?" +statusFilter);
		
		softAssert.assertTrue(makePaymentBtnDisplayed, "Make a payment button is not displayed");
		softAssert.assertTrue(dateFilter, "Date filter is not displayed");
		softAssert.assertTrue(loanFilter, "Loan filter is not displayed");
		softAssert.assertTrue(sourceFilter, "Source filter is not displayed");
		softAssert.assertTrue(paymentMethodFilter, "Payment method filter is not displayed");
		softAssert.assertTrue(statusFilter, "status filter is not displayed");		
	}
	
	public void verifyMakePayment(HashMap<String, String> map) {
		Waits.explicitWaitForElementVisible(paymentHistoryLink);

		SoftAssert softAssert = new SoftAssert();
		paymentHistoryLink.click();
		
		makePaymentBtn.click();
		makePaymentloanDropDown.click();
		for(WebElement webEl : makePaymentloandropdownValue) {
			if(webEl.getText().equals(map.get("LoanNumber"))) {
				webEl.click();
				log.info("Selected loan number is: " +webEl.getText());
				break;
			}
			driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		}
		
		String payDate = modalPaymentDate.getText();
		log.info("Today's date is displayed: " +payDate);
		
		openSelectPaymentDropDown.click();
		otherAmount.click();
		
		otherAmountTextBox.sendKeys(map.get("Amount"));
		log.info("Other Payment amount is: " +map.get("Amount"));
		
		creditCardNumber.sendKeys(map.get("CardNumber"));
		log.info("Card number is: " +map.get("CardNumber"));
		
		expDate.sendKeys(map.get("ExpDate"));
		log.info("Expiry date is: " +map.get("ExpDate"));
		
		cvvNumber.sendKeys(map.get("CVVNumber"));
		log.info("CVV number is: " +map.get("CVVNumber"));
		
		continuePaymentBtn.click();
		Waits.explicitWaitForElementVisible(payNowBtn);
		payNowBtn.click();
		softAssert.assertAll();
	}
	
	public void verifyDateFilter(HashMap<String, String> map) {
		Waits.explicitWaitForElementVisible(paymentHistoryLink);

		SoftAssert softAssert = new SoftAssert();
		paymentHistoryLink.click();
		Waits.explicitWaitForElementVisible(paymentHistoryPageHeading);
		dateFilterDropdown.click();
		
		boolean dateHeading = dateFilterHeader.isDisplayed();
		log.info("Date Filter heading is displayed: " +dateHeading);
		
		for(WebElement dateEle : dateFilterOption) {
			System.out.println(dateEle.getText());
		
		}
		softAssert.assertAll();
	}
	
	public void verifySetDateFilter(HashMap<String, String> map) {
		Waits.explicitWaitForElementVisible(paymentHistoryLink);

		SoftAssert softAssert = new SoftAssert();
		paymentHistoryLink.click();
		Waits.explicitWaitForElementVisible(paymentHistoryPageHeading);
		dateFilterDropdown.click();
		
		List<String> originalList = recentPayments.stream().map(d -> d.getText()).collect(Collectors.toList());
		for(WebElement dateValueEl : dateFilterOption) {
			if(dateValueEl.getText().equals(map.get("DateFilterValue"))) {
				dateValueEl.click();
				List<String> recentPaymentSortedList = recentPayments.stream().map(d -> d.getText()).collect(Collectors.toList());
				System.out.println(recentPaymentSortedList);
				softAssert.assertTrue(originalList.equals(recentPaymentSortedList));
			}
		}
	}
	
	public void verifyLoanFilter(HashMap<String, String> map) {
		Waits.explicitWaitForElementVisible(paymentHistoryLink);

		SoftAssert softAssert = new SoftAssert();
		paymentHistoryLink.click();
		Waits.explicitWaitForElementVisible(paymentHistoryPageHeading);
		loanFilterDropdown.click();
		
		boolean loanHeading = loanFilterHeader.isDisplayed();
		log.info("Loan Filter heading is displayed: " +loanHeading);
		
		for(WebElement loanEle : loanFilterOption) {
			System.out.println(loanEle.getText());
		}
	}
	
	public void verifySetLoanFilter(HashMap<String, String> map) {
		Waits.explicitWaitForElementVisible(paymentHistoryLink);

		SoftAssert softAssert = new SoftAssert();
		paymentHistoryLink.click();
		loanFilterDropdown.click();

		List<String> originalList = recentPayments.stream().map(d -> d.getText()).collect(Collectors.toList());
		for(WebElement loanEl : loanFilterOption) {
			if(loanEl.getText().equals(map.get("LoanFilterValue"))) {
				loanEl.click();
				List<String> recentPaymentSortedList = recentPayments.stream().map(d -> d.getText()).collect(Collectors.toList());
				System.out.println(recentPaymentSortedList);
				softAssert.assertTrue(originalList.equals(recentPaymentSortedList));
				if(recentPaymentSortedList == null) {
					System.out.println("No data");
				}
			}
		}
	}
	
	public void verifySourceFilter(HashMap<String, String> map) {
		Waits.explicitWaitForElementVisible(paymentHistoryLink);
		SoftAssert softAssert = new SoftAssert();
		paymentHistoryLink.click();
		sourceFilterDropdown.click();
		
		boolean sourceHeading = sourceFilterHeader.isDisplayed();
		log.info("Source Filter heading is displayed: " +sourceHeading);
		
		for(WebElement sourceEl : sourceFilterOption) {
			System.out.println(sourceEl.getText());
		}		
	}
	
	public void verifySetSourceFilter(HashMap<String, String> map) {
		Waits.explicitWaitForElementVisible(paymentHistoryLink);
		SoftAssert softAssert = new SoftAssert();
		paymentHistoryLink.click();
		sourceFilterDropdown.click();
		
		boolean sourceHeading = sourceFilterHeader.isDisplayed();
		log.info("Source Filter heading is displayed: " +sourceHeading);

		List<String> originalList = recentPayments.stream().map(d -> d.getText()).collect(Collectors.toList());
		for(WebElement sourceEl : sourceFilterOption) {
			if(sourceEl.getText().equals(map.get("SourceFilterValue"))) {
				sourceEl.click();
				List<String> recentPaymentSortedList = recentPayments.stream().map(d -> d.getText()).collect(Collectors.toList());
				System.out.println(recentPaymentSortedList);
				softAssert.assertTrue(originalList.equals(recentPaymentSortedList));
			}				
		}
	}
	
	public void verifyPaymentFilter(HashMap<String, String> map) {
		Waits.explicitWaitForElementVisible(paymentHistoryLink);
		SoftAssert softAssert = new SoftAssert();
		paymentHistoryLink.click();
		paymentMethodFilterDropdown.click();
		
		boolean paymentHeading = paymentMethodFilterHeader.isDisplayed();
		log.info("Payment method Filter heading is displayed: " +paymentHeading);
		
		for(WebElement payEl : paymentMethodFilterOption) {
			System.out.println(payEl.getText());
			softAssert.assertEquals(payEl, map.get("PaymentMethodValue"), "Actual value is different from expected");
		}	

	}
	
	public void verifySetPaymentMethodFilter(HashMap<String, String> map) {
		Waits.explicitWaitForElementVisible(paymentHistoryLink);
		SoftAssert softAssert = new SoftAssert();
		paymentHistoryLink.click();
		paymentMethodFilterDropdown.click();
	
		List<String> originalList = recentPayments.stream().map(d -> d.getText()).collect(Collectors.toList());
		for(WebElement payEl : paymentMethodFilterOption) {
			if(payEl.getText().equals(map.get("PaymentMethodValue"))) {
				payEl.click();
				List<String> recentPaymentSortedList = recentPayments.stream().map(d -> d.getText()).collect(Collectors.toList());
				System.out.println(recentPaymentSortedList);
				softAssert.assertTrue(originalList.equals(recentPaymentSortedList));

			}
		}
	}
	
	public void verifyStatusFilter(HashMap<String, String> map) {
		Waits.explicitWaitForElementVisible(paymentHistoryLink);
		SoftAssert softAssert = new SoftAssert();
		paymentHistoryLink.click();
		statusFilterDropdown.click();
		
		boolean statusHeading = statusFilterHeader.isDisplayed();
		log.info("Status Filter heading is displayed: " +statusHeading);
		
		for(WebElement statusEl : statusFilterOption) {
			System.out.println(statusEl.getText());
		}	
	}
	
	public void verifySetStatusMethodFilter(HashMap<String, String> map) {
		Waits.explicitWaitForElementVisible(paymentHistoryLink);
		SoftAssert softAssert = new SoftAssert();
		paymentHistoryLink.click();
		statusFilterDropdown.click();
		
		List<String> originalList = recentPayments.stream().map(d -> d.getText()).collect(Collectors.toList());
		for(WebElement statusEl : statusFilterOption) {
			if(statusEl.getText().equals(map.get("StatusValue"))) {
				statusEl.click();
					List<String> recentPaymentSortedList = recentPayments.stream().map(st -> st.getText()).collect(Collectors.toList());
					System.out.println(recentPaymentSortedList);
					softAssert.assertTrue(originalList.equals(recentPaymentSortedList));					
			}
		}
	}
	
	public void verifySetAllFilter(HashMap<String, String> map) {
		Waits.explicitWaitForElementVisible(paymentHistoryLink);
		SoftAssert softAssert = new SoftAssert();
		paymentHistoryLink.click();
		
		dateFilterDropdown.click();
		
		List<String> originalList = recentPayments.stream().map(d -> d.getText()).collect(Collectors.toList());
		for(WebElement loanEl : dateFilterOption) {
			if(loanEl.getText().equals(map.get("DateFilterValue"))) {
				loanEl.click();
			}
		}
		
		loanFilterDropdown.click();
		for(WebElement loanEl : loanFilterOption) {
			if(loanEl.getText().equals(map.get("LoanFilterValue"))) {
				loanEl.click();
			}
		}
		
		sourceFilterDropdown.click();
		for(WebElement sourceEl : sourceFilterOption) {
			if(sourceEl.getText().equals(map.get("SourceFilterValue"))) {
				sourceEl.click();
			}
		}
		
		paymentMethodFilterDropdown.click();
		for(WebElement payEl : paymentMethodFilterOption) {
			if(payEl.getText().equals(map.get("PaymentMethodValue"))) {
				payEl.click();
			}
		}
		
		statusFilterDropdown.click();
		for(WebElement statusEl : statusFilterOption) {
			if(statusEl.getText().equals(map.get("StatusValue"))) {
				statusEl.click();
			}
		}
		
		List<String> recentPaymentSortedList = recentPayments.stream().map(st -> st.getText()).collect(Collectors.toList());
		System.out.println(recentPaymentSortedList);
		softAssert.assertTrue(originalList.equals(recentPaymentSortedList));
	}
	
	public void recentPaymentDetails(HashMap<String, String> map) {
		Waits.explicitWaitForElementVisible(paymentHistoryLink);
		SoftAssert softAssert = new SoftAssert();
		paymentHistoryLink.click();
		
		int noOfPayments = recentPayments.size();
		log.info("No of Recent Payments listed are: " +noOfPayments);
		log.info("Expected number of recent payments are: " +map.get("NumOfRecentPayments"));
		
		for(int i = 0; i < noOfPayments; i++) {
			
			driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
			WebElement rPaymentDate = recentPaymentsDates.get(i);
			String rPayDates = rPaymentDate.getText();
			log.info("The actual payment Date is: "+rPaymentDate);
			log.info("The expected payment Date is: "+map.get("RecentPaymentDates"+i));
			softAssert.assertEquals(rPayDates, map.get("RecentPaymentDates"+i), "Actual and Expected Payment dates does not match");		
			
			WebElement rPaymentLoan = recentpaymentsLoanNumber.get(i);
			String rPayLoan= rPaymentLoan.getText();
			log.info("The actual Loan number is: "+rPayLoan);
			log.info("The expected Loan number is: "+map.get("RecentPaymentLoanNo"+i));
			softAssert.assertEquals(rPayLoan, map.get("RecentPaymentLoanNo"+i), "Actual and Expected loan number does not match");
			
			WebElement rPaymentSource = recentpaymentsSource.get(i);
			String rPaySource = rPaymentSource.getText();
			log.info("The actual Source is: "+rPaySource);
			log.info("The expected Source is: "+map.get("RecentPaymentSource"+i));
			softAssert.assertEquals(rPaySource, map.get("RecentPaymentSource"+i), "Actual and Expected Source does not match");
			
			WebElement rPaymentMethod = recentpaymentsMethod.get(i);
			String rPayMethod = rPaymentMethod.getText();
			log.info("The actual Method is: "+rPayMethod);
			log.info("The expected Method is: "+map.get("RecentPaymentMethod"+i));
			softAssert.assertEquals(rPayMethod, map.get("RecentPaymentMethod"+i), "Actual and Expected Method does not match");
			
			WebElement rPaymentStatus = recentpaymentsStatus.get(i);
			String rPayStatus = rPaymentStatus.getText();
			log.info("The actual Status is: "+rPayStatus);
			log.info("The expected Status is: "+map.get("RecentPaymentStatus"+i));
			softAssert.assertEquals(rPayStatus, map.get("RecentPaymentStatus"+i), "Actual and Expected Status does not match");
			
			WebElement rPaymentAmount = recentpaymentsAmount.get(i);
			String rPayAmount = rPaymentAmount.getText();
			log.info("The actual Amount is: "+rPayAmount);
			log.info("The expected Amount is: "+map.get("RecentPaymentAmount"+i));
			softAssert.assertEquals(rPayAmount, map.get("RecentPaymentAmount"+i), "Actual and Expected Amount does not match");
			
		}
		softAssert.assertAll();

	}
	
	
	}
