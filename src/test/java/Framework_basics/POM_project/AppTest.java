package Framework_basics.POM_project;

import java.io.IOException;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.Test;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;

import ObjectRepository.HomePage;
import ObjectRepository.LogIn;
import Utilities.CrossBrowser;
import Utilities.Exceldata;


/**
 * Unit test for simple App.
 */
public class AppTest 
{
    WebDriver driver;
    String data[];
	
	@Test
	public void valid_application() throws IOException, InterruptedException
	{
		ExtentReports report=new ExtentReports();
		ExtentSparkReporter sparkreport=new ExtentSparkReporter("C:\\Users\\owner\\Selenium_webdriver_nexxvali\\POM_project\\target\\report.html");
		ExtentTest test=report.createTest("Login Application");
		report.attachReporter(sparkreport);
		
		data=new String[5];
		test.log(Status.PASS, "user launched the browser");
		CrossBrowser br=new CrossBrowser();
		driver=br.browser_initiate();
		HomePage h=new HomePage(driver);
		h.signin();
		test.log(Status.PASS, "user has clicked on sign in");
		Exceldata d=new Exceldata();
		data=d.readExcel();
		String user=data[0];
		String pass=data[1];
		
		LogIn l=new LogIn(driver);
		l.login_credentials(user,pass);
		Thread.sleep(5000);
		test.log(Status.PASS, "user has entered valid credentials");
		report.flush();
		driver.close();;
		
	}
}
