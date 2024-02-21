package page;


import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import base.BrowserOpen;

public class CreatePerson extends BrowserOpen{
	
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
	
	@FindBy(xpath ="(//a[@href='#/createclient'])[2]")
	WebElement CreateButton;
	
	@FindBy(xpath="(//input[@id='firstname'])")
	WebElement Fname;
	
	@FindBy(xpath="(//input[@id='lastname'])")
	WebElement Lname;
	
	@FindBy(xpath="(//input[@id='dateofbirth'])")
	WebElement DOB;
	
	@FindBy(xpath="(//button[@class='btn-silver'])[16]")
	WebElement DOBSelect;
	
	@FindBy(xpath="(//a[@class='chosen-single'])[5]")
	WebElement ClientType;
	
	@FindBy(xpath="//*[@id=\"clienttypeId_chosen\"]/div/ul/li[2]")
	WebElement ClientsTypeChoose;
	
	@FindBy(xpath="(//a[@class='chosen-single'])[4]")
	WebElement Gender;
	
	@FindBy(xpath="//*[@id=\"genderId_chosen\"]/div/ul/li[2]")
	WebElement GenderSelect;
	
	@FindBy(xpath="(//input[@id='mobileNo'])")
	WebElement Mnum;
	
	@FindBy(xpath="(//input[@id='activeCheckbox'])")
	WebElement Active;
	
	@FindBy(xpath="(//button[@ng-click='addAddress()'])")
	WebElement AddressPlus;
	
	@FindBy(xpath="//span[normalize-space()='Select Address Type']")
	WebElement AddressType;
	
	@FindBy(xpath="//li[normalize-space()='Permanent']")
	WebElement AddressTypeSelect;
	
	@FindBy(xpath="(//input[@name='street0'])")
	WebElement Street;
	
	@FindBy(xpath ="//span[text()='Select Country']")
	WebElement Country;
	@FindBy(xpath = "(//label[text()='Country']/following::input)[1]")
	WebElement CountrySearch;
	
	@FindBy(xpath="//a[@ng-href='#/clients']/following-sibling::button[1]")
	WebElement Submit;
	
	@FindBy(xpath = "//a[.='Select State']")
	WebElement State;
	
	@FindBy(xpath = "(//label[text()='State / Province']/following::input)[1]")
	WebElement StateSearch;
	
	@FindBy(xpath="//span[text()='Select District']")
	WebElement District;
	
	@FindBy(xpath = "(//label[text()='District']/following::input)[1]")
	WebElement DistrictSearch;
	
	@FindBy(xpath = "//strong[@class='fs-3 ng-binding']")
	WebElement ClientName;
	
	@FindBy(xpath = "//i[@uib-tooltip='Active']")
	WebElement ClientActive;
	
	public CreatePerson() {
		PageFactory.initElements(driver, this);
	}
	
public void Login(String username,String password) {
		
		Username.sendKeys(username);
		Password.sendKeys(password);
		Signin.click();
		
	
	}
public  void CreateClient() {
	
	waitforme(Clientdropdown);
	mouseOver(Clientdropdown);
	waitforme(Clients);
	mouseOver(Clients);
	Clients.click();
	CreateButton.click();
}

public void FillForm(String fname,String lname,String num,String dob,String street) {
	
	Fname.sendKeys(fname);
	Lname.sendKeys(lname);
	Mnum.sendKeys(num);
	DOB.sendKeys(dob);
	DOBSelect.click();
	ClientType.click();
	ClientsTypeChoose.click();
	Gender.click();
	GenderSelect.click();
	Active.click();
	AddressPlus.click();
	waitforme(AddressPlus);
	ScrollDown1(AddressPlus);
	switchTab();
	waitforme(AddressType);
	AddressType.click();
	AddressTypeSelect.click();
	waitforme(AddressTypeSelect);
	Street.sendKeys(street);
	waitforme(Country);
	
}

public void Details() throws Exception {
	
	Country.click();
    CountrySearch.sendKeys("India");
    CountrySearch.sendKeys(Keys.ENTER);
    waitforme(State);
	State.click();
	StateSearch.sendKeys("Tamil Nadu");
	StateSearch.sendKeys(Keys.ENTER);
	waitforme(District);
	District.click();
	DistrictSearch.sendKeys("Chennai");
	DistrictSearch.sendKeys(Keys.ENTER);
	waitforme(Submit);
	Submit.click();
	waitforme(ClientName);
	ClientConformation(ClientName);
	waitforme(ClientActive);
	
}


}
