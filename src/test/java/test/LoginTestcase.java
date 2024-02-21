package test;

import org.testng.annotations.Test;

import page.CreatePerson;


public class LoginTestcase extends CreatePerson{
    
	@Test
	public void PositiveTest() throws Exception {
		CreatePerson lp = new CreatePerson();
		
		lp.Login("qatest@habile.in", "Qatest123$");
		
		lp.TitleCheck();
	}
	
	@Test
     public void NegativeTest() throws Exception {
		
		CreatePerson lp = new CreatePerson();
		
		lp.Login("qat@habile.com", "qat@123");
		
		lp.ErrorMsg();
	
}

}
