package ObjectRepository;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class HomePage {
	WebDriver driver;
	By sign_in=By.xpath("//*[@id=\"MenuContent\"]/a[2]");
	
	public HomePage(WebDriver driver)
	{
		this.driver=driver;
		
	}
	public void signin()
	{
		driver.findElement(sign_in).click();
	}

}
