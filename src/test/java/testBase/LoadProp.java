package testBase;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;


import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;

public class LoadProp   {
	public static Properties prop = new Properties();
	public static FileInputStream inStream;
	 public static String driverpath;

	 public static String base_url,recipient_url,enrollment_url,doctors_Url,browser_name , login_username,login_password,namespaceurl ;
	public static String DoctorsLogin_username, DoctorsLogin_password;
	public static String Recipient_Username, Recipient_Password;
	public static String DoctorsLogin_usernameone,DoctorsLogin_passwordone,DoctorsLogin_usernametwo,DoctorsLogin_passwordtwo,DiagnosticLogin_usernameone,DiagnosticLogin_passwordone;
	 

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
        
        DoctorsLogin_usernameone=prop.getProperty("DoctorsLogin.usernameone");
        DoctorsLogin_passwordone=prop.getProperty("DoctorsLogin.passwordone");
        
        DoctorsLogin_usernametwo=prop.getProperty("DoctorsLogin.usernametwo");
        DoctorsLogin_passwordtwo=prop.getProperty("DoctorsLogin.passwordtwo");
      
       //Recipients -Login Credentails
        Recipient_Username=prop.getProperty("Recipient.Username");
        Recipient_Password=prop.getProperty("Recipient.Password");
        
        //Diagnostic Centre login credentials
        
        
        DiagnosticLogin_usernameone=prop.getProperty("DiagnosticLogin.usernameone");
        DiagnosticLogin_passwordone=prop.getProperty("DiagnosticLogin.passwordone");
       
        
        if(browser_name.equals("chrome")){
			System.out.println("launching chrome browser");
			System.setProperty("webdriver.chrome.driver", "BrowserDrivers\\chromedriver.exe");
			ChromeOptions options = new ChromeOptions(); // Added to remove new chrome warning message
			options.addArguments("disable-infobars");   // Added to remove new chrome warning message
			driver = new ChromeDriver(options);
			driver.manage().window().maximize();
		}else if(browser_name.equals("firefox")){
			System.out.println("launching Firefox browser");
			//driver = new FirefoxDriver();	
		}
		return driver;
}
	
	
	public static WebElement isElementPresnt(WebDriver driver,String xpath,int time)
	{ 
	 
	WebElement ele = null;
	 
	for(int i=0;i<time;i++)
	{
	try{
	ele=driver.findElement(By.xpath(xpath));
	break;
	}
	catch(Exception e)
	{
	try 
	{
	Thread.sleep(1000);
	} catch (InterruptedException e1) 
	{
	System.out.println("Waiting for element to appear on DOM");
	}
	}
	 
	}
	return ele;
	 
	}
	
	


}
