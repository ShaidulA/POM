package Utilities;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;

public class CrossBrowser {
	WebDriver driver;
	String FilePath="C:\\Users\\owner\\Selenium_webdriver_nexxvali\\POM_project\\src\\test\\resource\\Config.properties";
	
	public WebDriver browser_initiate() throws IOException 
	{

		
		FileInputStream fis=new FileInputStream(FilePath);
		
		Properties p=new Properties();
		p.load(fis);
		String browsername=p.getProperty("browser");
		switch(browsername)
		{
		case "chrome":
		{
			driver=new ChromeDriver();
			driver.get(p.getProperty("url"));
			driver.manage().window().maximize();
			break;
		}
		
		case "edge":
		{
			driver=new EdgeDriver();
			driver.get(p.getProperty("url"));
			driver.manage().window().maximize();
			break;
		}
		
		}
		return driver;
}

}
