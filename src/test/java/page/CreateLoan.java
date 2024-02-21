package page;



import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import base.BrowserOpen;

public class CreateLoan extends BrowserOpen{
	
	@FindBy(xpath = "(//input[@name='username'])[1]")
	WebElement Username;
	
	@FindBy(xpath="//input[@name='password']")
	WebElement Password;
	
	@FindBy(xpath = "(//button[@id='login-button'])[1]")
	WebElement Signin;
	
	@FindBy(xpath = "//a[@id='client-dropdown']")
	WebElement Clientdropdown;
	
	@FindBy(xpath = "//a[@href='#/clients']")
	WebElement Clients;
	
	@FindBy(xpath = "(//td[@class='pointer ng-binding'])[1]")
	WebElement ClientLoan;
	
	@FindBy(xpath = "//a[@has-permission='CREATE_LOAN']")
	WebElement NewloanButton;
	
	@FindBy(xpath="(//select[contains(@class,'form-control w-298px')])[1]")
	WebElement ProductId;
	
	@FindBy(xpath = "//option[@label='F1QZZ8HU6RQDUGXC']")
	WebElement productIdLoan;
	
	@FindBy(xpath = "(//a[@class='chosen-single'])[2]")
	WebElement AccountType;
	
	@FindBy(xpath = "(//li[@class='active-result'])[18]")
	WebElement ChooseLoan;
	
	@FindBy(xpath = "(//a[@class='chosen-single'])[3]")
	WebElement RePaymentMethod;
	
	@FindBy(xpath="//*[@id=\"repaymentModeId_chosen\"]/div/ul/li[2]")
	WebElement ChoosePaymentMethod;
	
	@FindBy(xpath="//input[@id='expectedDisbursementDate']")
	WebElement DisbursementDate;
	
	@FindBy(xpath = "(//button[@class='btn btn-default pull-right'])[1]")
	WebElement NextButton;
	
	@FindBy(xpath = "(//button[@class='btn btn-default pull-right'])[2]")
	WebElement NextButtonInTerms;
	
	@FindBy(xpath = "//input[@id='new-lender']")
	WebElement NewLender;
	
	@FindBy(xpath="(//button[@class='btn btn-default pull-right'])[3]")
	WebElement NextButtonInLenders;
	
	@FindBy(xpath="(//button[@class='btn btn-default pull-right'])[4]")
	WebElement NextButtonInCharges;
	
	@FindBy(xpath="//input[@id='principal']")
	WebElement Principal;
	
	@FindBy(xpath="//input[@id='numberOfRepayments']")
	WebElement numberOfRepayments;
	
	@FindBy(xpath="//input[@id='interestRatePerPeriod']")
	WebElement interestRatePerPeriod;
	
	@FindBy(xpath = "//input[@id='loanTermFrequency']")
	WebElement loanTermFrequency;
	
	@FindBy(xpath = "//select[@id='interestCalculationPeriodType']")
	WebElement interestCalculationPeriodType;
	
	@FindBy(xpath = "//select[@id='repaymentFrequencyNthDayType']")
	WebElement repaymentFrequencyNthDayType;
	
	@FindBy(xpath = "//select[@id='repaymentFrequencyDayOfWeekType']")
	WebElement repaymentFrequencyDayOfWeekType;
	
	@FindBy(xpath = "//button[@id='save']")
	WebElement SubmitButton;
	
	@FindBy(xpath="(//span[@class='btn btn-primary ng-binding ng-scope'])[2]")
	WebElement ApproveButton;
	
	@FindBy(xpath="(//input[@id='approvedAmount'])")
	WebElement ApproveAmount;
	
	@FindBy(xpath= "//span[@class='user-status ng-binding']")
	WebElement Status;
	
	public CreateLoan(){
		
		PageFactory.initElements(driver, this);
		
	}
	
	public void Login(String username,String password) {
		
		Username.sendKeys(username);
		Password.sendKeys(password);
		Signin.click();
		
	
	}
	
	public void ClientsClick() {
		waitforme(Clientdropdown);
		mouseOver(Clientdropdown);
		waitforme(Clients);
		mouseOver(Clients);
		Clients.click();
		
	}
	
	public void NewLoan() {
		
		ClientLoan.click();
		waitforme(NewloanButton);
		NewloanButton.click();
		
	}
public void Detailes(String date) {
	
	waitforme(ProductId);
	ProductId.click();
	productIdLoan.click();
	AccountType.click();
	ChooseLoan.click();
	RePaymentMethod.click();
	ChoosePaymentMethod.click();
	DisbursementDate.sendKeys(date);
	NextButton.click();
	
}

public void Terms(String num1,String num2,String num3,String num4) {
	
	Principal.clear();
	Principal.sendKeys(num1);
	numberOfRepayments.clear();
	waitforme(numberOfRepayments);
	numberOfRepayments.sendKeys(num2);
	interestRatePerPeriod.clear();
	interestRatePerPeriod.sendKeys(num3);
	loanTermFrequency.clear();
	loanTermFrequency.sendKeys(num4);
	Dropdown1(interestCalculationPeriodType);
	Dropdown2(repaymentFrequencyNthDayType);
	Dropdown2(repaymentFrequencyDayOfWeekType);
	waitforme(NextButtonInTerms);
	ScrollDown();
	NextButtonInTerms.click();
	
	
}

public void Lender(String name) {
	
	NewLender.sendKeys(name);
	NextButtonInLenders.click();
	
	
	
}

public void ChargesAndReview(String num) throws Exception {
	
	NextButtonInCharges.click();
	
	waitforme(SubmitButton);
	
	SubmitButton.click();
	
	ApproveButton.click();
	
	ApproveAmount.clear();
	
	ApproveAmount.sendKeys(num);
	
	SubmitButton.click();
	
	waitforme(Status);
	
	confirmation(Status);	
	
}



}
