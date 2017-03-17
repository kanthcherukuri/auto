package testBase;

import java.io.File;
import java.io.FileInputStream;
import java.util.Properties;

import objectRepository.PageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class LoadProp   {
	 public static String driverpath;
	 public static String base_url,enrollment_url,browser_name , login_username,login_password,namespaceurl ;
	
		public static WebDriver driver;
	public static WebDriver LoadBrowserProperties()throws Exception{
	    FileInputStream inStream;
        inStream = new FileInputStream(new File("ConfigFiles\\Setup-Details.txt"));
        Properties prop = new Properties();
        prop.load(inStream);
        //driverpath=prop.getProperty("driver.path");
        base_url=prop.getProperty("base.url");
        enrollment_url=prop.getProperty("enrollment.url");
        browser_name=prop.getProperty("browser.name");
        login_username=prop.getProperty("login.username");
        login_password=prop.getProperty("login.password");	
        
        
        
       
        
        if(browser_name.equals("chrome")){
			System.out.println("launching chrome browser");
			System.setProperty("webdriver.chrome.driver", "BrowserDrivers\\chromedriver.exe");
			driver = new ChromeDriver();
		}else if(browser_name.equals("firefox")){
			System.out.println("launching Firefox browser");
			//driver = new FirefoxDriver();	
		}
		return driver;
}

}
