package ObjectRepository;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class LogIn {
	WebDriver driver;
	By username=By.name("username");
	By password=By.name("password");
	By login_button=By.name("signon");
	
	public LogIn(WebDriver driver)
	{
		this.driver=driver;
	}
	public void login_credentials(String u1,String p1)
	{
		driver.findElement(username).sendKeys(u1);
		driver.findElement(password).clear();
		driver.findElement(password).sendKeys(p1);
		driver.findElement(login_button).click();
	}
	

}
