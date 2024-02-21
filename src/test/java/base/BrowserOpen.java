package base;


import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

import utility.UtilityClass;

public class BrowserOpen extends UtilityClass{
	
	
	
	
	@BeforeMethod
	public void suiteInitializer() {
		browserLaunch(getpropvalue("browser"));
		launchUrl(getpropvalue("url"));
		
	}
	

	
	@AfterMethod
	public void BrowserClose() {
		driver.quit();
	}

}
