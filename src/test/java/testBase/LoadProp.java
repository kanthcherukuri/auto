package testBase;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;


import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;

public class LoadProp   {
	public static Properties prop = new Properties();
	public static FileInputStream inStream;
	 public static String driverpath;

	 public static String base_url,recipient_url,enrollment_url,doctors_Url,browser_name , login_username,login_password,namespaceurl ;
	public static String DoctorsLogin_username, DoctorsLogin_password;
	 
	 

		public static WebDriver driver;
	public static WebDriver LoadBrowserProperties()throws Exception{
	    FileInputStream inStream;
        inStream = new FileInputStream(new File("ConfigFiles\\Setup-Details.txt"));
        Properties prop = new Properties();
        prop.load(inStream);
        //driverpath=prop.getProperty("driver.path");
        base_url=prop.getProperty("base.url");
        recipient_url=prop.getProperty("recipient.url");
        enrollment_url=prop.getProperty("enrollment.url");
        doctors_Url=prop.getProperty("Doctors.Url");
        login_password=prop.getProperty("login.password");
        browser_name=prop.getProperty("browser.name");
        login_username=prop.getProperty("login.username");
        
        
        
        //Doctors -Login Credentails
        DoctorsLogin_username=prop.getProperty("DoctorsLogin.username");
        DoctorsLogin_password=prop.getProperty("DoctorsLogin.password");
      
        
        
        
       
        
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
