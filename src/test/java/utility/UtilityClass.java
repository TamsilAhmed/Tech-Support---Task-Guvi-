package utility;

import java.io.File;
import java.io.FileInputStream;
import java.time.Duration;
import java.util.Properties;
import java.util.Set;
import java.util.concurrent.TimeUnit;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;


import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;

import io.github.bonigarcia.wdm.WebDriverManager;


public class UtilityClass {
	
	protected static WebDriver driver;
	public static ExtentReports extent;
	public static ExtentTest test;
	
	
	public static void browserLaunch(String name) {

		switch (name) {
		case "Edge":
			WebDriverManager.chromedriver().setup();
			driver = new EdgeDriver();
			break;
		case "FireFox":
			WebDriverManager.firefoxdriver().setup();
			driver = new FirefoxDriver();
			break;
		default:
			System.out.println("No valid options given choosing the default browser");
			driver = new ChromeDriver();
		}
		driver.manage().timeouts().implicitlyWait(7, TimeUnit.SECONDS);
		driver.manage().window().maximize();
	}
	
	public static String getpropvalue(String key) {
		String value = null;
		try {
			Properties prop = new Properties();
			FileInputStream ip = new FileInputStream(System.getProperty("user.dir") + "//config.properties");
			prop.load(ip);
			value = prop.getProperty(key);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return value;
	}
	
	public static void launchUrl(String url) {
		driver.get(url);
		
		System.out.println("Status : Site Successfully Opened");
	}
	
	public static boolean getUrl(String url) {
		boolean flag = false;
		try {
			driver.get(url);
			test.log(LogStatus.PASS, "URL Launched Successfully : " + url);
			flag = true;
		} catch (Exception e) {

			System.out.println("Error in GetUrl : " + e.getMessage());
			test.log(LogStatus.FAIL, "Error in GetUrl : " + e.getMessage());

		}
		return flag;
	}
	
	public void mouseOver(WebElement ele) {
		
		Actions action = new Actions(driver);


		action.moveToElement(ele).build().perform();
		
		
	}
	
public boolean switchTab() {
		
		String parentwindow = driver.getWindowHandle();
		
		Set<String>windowhandles = driver.getWindowHandles();
		
		
		for(String address:windowhandles) {
			if(!address.contentEquals(parentwindow)) {
				System.out.println("The child window address is :" +address );
				driver.switchTo().window(address);
				break;
			}
		}
		return false;
	}

public void waitforme(WebElement element) {

	WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(15));
    wait.until(ExpectedConditions.elementToBeClickable(element));
    driver.manage().logs();
}

public void TitleCheck() throws Exception {
	extent = new ExtentReports("report.html", false);

	test = extent.startTest("Title Check", "Visibility Check");
	
	test.log(LogStatus.INFO, "Checking for the Title");
	
	driver.getTitle();
	
		
	
	if(driver.getTitle()!= null) {
		System.out.println("Status :  Login Successfull");
	test.log(LogStatus.PASS, "The Title is Shown");
	TakesScreenshot ts = (TakesScreenshot) driver;
	File source = ts.getScreenshotAs(OutputType.FILE);
	FileUtils.copyFile(source, new File("./screenshot/Title.png"));
	String img = test.addScreenCapture("./screenshot/Title.png");
	}
	
	else {
	test.log(LogStatus.FAIL, "The Title is not Shown"); 
	System.out.println("Status :  Login Failed");
	TakesScreenshot ts = (TakesScreenshot) driver;
	File source = ts.getScreenshotAs(OutputType.FILE);
	FileUtils.copyFile(source, new File("./screenshot/TitleNotShown.png"));
	String img = test.addScreenCapture("./screenshot/TitleNotShown.png");
}
	extent.endTest(test);

	extent.flush();
}

public void ActiveCheck() throws Exception {
	extent = new ExtentReports("report.html", false);

	test = extent.startTest("Client Active", "Status Check");
	
	test.log(LogStatus.INFO, "Client Active Status");
	
	String Title = driver.findElement(By.xpath("//i[@uib-tooltip='Active']")).getText();
	
	
	
	if(Title.contentEquals(Title)) {
		System.out.println("Status : Client Activated");
	test.log(LogStatus.PASS, "Client is Active");
	TakesScreenshot ts = (TakesScreenshot) driver;
	File source = ts.getScreenshotAs(OutputType.FILE);
	FileUtils.copyFile(source, new File("./screenshot/ClientActive.png"));
	String img = test.addScreenCapture("./screenshot/ClientActive.png");
	}
	
	else {
		System.out.println("Status : Client is not Activated");
	test.log(LogStatus.FAIL, "Client is not Active"); 
	
	TakesScreenshot ts = (TakesScreenshot) driver;
	File source = ts.getScreenshotAs(OutputType.FILE);
	FileUtils.copyFile(source, new File("./screenshot/ClientNotActive.png"));
	String img = test.addScreenCapture("./screenshot/ClientNotActive.png");
}
	extent.endTest(test);

	extent.flush();
}

public void confirmation(WebElement ele) throws Exception {
	
	extent = new ExtentReports("report.html", false);

	test = extent.startTest("Loan Amount", "Checking Status");
	
	test.log(LogStatus.INFO, "Status Confirming");
	
	
	String title = ele.getText();
	
	
	
	
	if(title.contentEquals(title)) {
		System.out.println("Status: Client Loan Approved");
		test.log(LogStatus.PASS, "Loan Amount Approved");
		TakesScreenshot ts = (TakesScreenshot) driver;
		File source = ts.getScreenshotAs(OutputType.FILE);
		FileUtils.copyFile(source, new File("./screenshot/AmountDetails.png"));
		String img = test.addScreenCapture("./screenshot/AmountDetails.png");
	}else {
		
		System.out.println("Status: Client Loan is not Approved");
		test.log(LogStatus.FAIL, "Loan Amount Approve Pending"); 
		
		TakesScreenshot ts = (TakesScreenshot) driver;
		File source = ts.getScreenshotAs(OutputType.FILE);
		FileUtils.copyFile(source, new File("./screenshot/PendingStatus.png"));
		String img = test.addScreenCapture("./screenshot/PendingStatus.png");
	}
		extent.endTest(test);

		extent.flush();
	
	
}

public void ClientConformation(WebElement ele) throws Exception {
	
	extent = new ExtentReports("report.html", false);

	test = extent.startTest("Client Creation", "Checking Status");
	
	test.log(LogStatus.INFO, "Status Confirming");
	
	
	String title = ele.getText();
	
	
	
	
	if(title.contentEquals(title)) {
		System.out.println("Status : Client Successfully Created");
		test.log(LogStatus.PASS, "Client Created Successfully");
		TakesScreenshot ts = (TakesScreenshot) driver;
		File source = ts.getScreenshotAs(OutputType.FILE);
		FileUtils.copyFile(source, new File("./screenshot/Client.png"));
		String img = test.addScreenCapture("./screenshot/Client.png");
	}else {
		test.log(LogStatus.FAIL, "Client Creation Failed"); 
		System.out.println("Status : Client not Created");
		TakesScreenshot ts = (TakesScreenshot) driver;
		File source = ts.getScreenshotAs(OutputType.FILE);
		FileUtils.copyFile(source, new File("./screenshot/CreationError.png"));
		String img = test.addScreenCapture("./screenshot/CreationError.png");
	}
		extent.endTest(test);

		extent.flush();
	
	
}
public void ScrollDown() {
	
	JavascriptExecutor js = (JavascriptExecutor) driver;
	js.executeScript("window.scrollBy(0,300)", "");
}

public void ScrollDown1(WebElement Element) {
	
	JavascriptExecutor js = (JavascriptExecutor) driver;
	js.executeScript("arguments[0].scrollIntoView();",Element );
}

public void ScrollDown2() {
	
	JavascriptExecutor js = (JavascriptExecutor) driver;
	js.executeScript("window.scrollTo(0, document.body.scrollHeight)");
}

public void Dropdown1(WebElement ele) {
	
	Select sel = new Select(ele);
	
	sel.selectByIndex(1);
}
public void Dropdown2(WebElement ele) {
	
	Select sel = new Select(ele);
	
	sel.selectByIndex(3);
}

public void Person() throws Exception {
	extent = new ExtentReports("report.html", false);

	test = extent.startTest("Client Creation", "Checking Status");
	
	test.log(LogStatus.INFO, "Status Confirming");
	
	
	String title = driver.findElement(By.xpath("//strong[@class='fs-3 ng-binding']")).getText();
	
	
	
	
	if(title.contentEquals(title)) {
		System.out.println(title);
		test.log(LogStatus.PASS, "Client Is created Successfully");
		TakesScreenshot ts = (TakesScreenshot) driver;
		File source = ts.getScreenshotAs(OutputType.FILE);
		FileUtils.copyFile(source, new File("./screenshot/Person.png"));
		String img = test.addScreenCapture("./screenshot/Person.png");
	}else {
		test.log(LogStatus.FAIL, "Client Creation is Failed"); 
		System.out.println("Client creation failed");
		TakesScreenshot ts = (TakesScreenshot) driver;
		File source = ts.getScreenshotAs(OutputType.FILE);
		FileUtils.copyFile(source, new File("./screenshot/Error.png"));
		String img = test.addScreenCapture("./screenshot/Error.png");
	}
		extent.endTest(test);

		extent.flush();
	
	

}	


public void ErrorMsg() throws Exception {
	
	extent = new ExtentReports("report.html", false);

	test = extent.startTest("Login Funtionality", "Checking Status");
	
	test.log(LogStatus.INFO, "Status Confirming");
	
	
	String title = driver.findElement(By.xpath("(//div[contains(@class,'alert alert-danger')])[1]")).getText();
	
	
	
	
	if(title.contentEquals("Please try again, your credentials are not valid.")) {
		System.out.println("Status : " + title);
		test.log(LogStatus.PASS, "Login is Failed");
		TakesScreenshot ts = (TakesScreenshot) driver;
		File source = ts.getScreenshotAs(OutputType.FILE);
		FileUtils.copyFile(source, new File("./screenshot/LoginError.png"));
		String img = test.addScreenCapture("./screenshot/LoginError.png");
	}else {
		test.log(LogStatus.FAIL, "Login is Success"); 
		System.out.println("Status : Login successfull");
		TakesScreenshot ts = (TakesScreenshot) driver;
		File source = ts.getScreenshotAs(OutputType.FILE);
		FileUtils.copyFile(source, new File("./screenshot/Login.png"));
		String img = test.addScreenCapture("./screenshot/Login.png");
	}
		extent.endTest(test);

		extent.flush();
	
	

}	

}

