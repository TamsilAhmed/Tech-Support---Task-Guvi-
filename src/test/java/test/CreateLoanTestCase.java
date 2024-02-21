package test;


import org.testng.annotations.Test;

import page.CreateLoan;
import page.CreatePerson;

public class CreateLoanTestCase extends CreateLoan{
	@Test
	public void TestCase1() throws Exception {
		
		CreatePerson cf = new CreatePerson();
		
		cf.Login("qatest@habile.in", "Qatest123$");
		
		cf.TitleCheck();
		
		cf.CreateClient();
		
		cf.FillForm("Mathan", "Gouri", "7805549150", "19 June 1987", "42,MGR 1st Street");
		
		cf.Details();
		
		cf.ActiveCheck();
		
	}
	
    @Test(dependsOnMethods = {"TestCase1"})
	public void TestCase2() throws Exception  {
    	
    	CreateLoan cf = new CreateLoan();
    	
    	cf.Login("qatest@habile.in", "Qatest123$");
    	
    	cf.switchTab();
    	
    	cf.TitleCheck();
    	
    	cf.ClientsClick();
    	
    	cf.NewLoan();
    	
    	cf.Detailes("21 December 2028");
    	
    	cf.Terms("600000","2","10","2");
    	
    	cf.Lender("Mathan");
    	
    	cf.ChargesAndReview("30000");
    	
	}

}
