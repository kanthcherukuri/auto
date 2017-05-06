package testBase;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;


import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.safari.SafariDriver;

public class LoadPropMac   {
	public static Properties prop = new Properties();
	public static FileInputStream inStream;
	 public static String driverpath;

	 public static String base_url, dev_url, recipient_url,index_url,enrollment_url,doctors_Url,browser_name , login_username,login_password,namespaceurl ;


	public static String diagnostic_url;
	
	//Diagnostic Variables
	public static String Diagnostic_usernameone,Diagnostic_passwordone;

	public static String DoctorsLogin_username, DoctorsLogin_password,Doctor_Name,Diagnostic_Name;
	public static String Recipient_Username, Recipient_Password,Recipient_DSusername,
	Recipient_DSpassword,Recipient_DocUsername,Recipient_DocPassword,Recipient_DiaUsername,Recipient_DiaPassword;
	public static String DoctorsLogin_usernameone,DoctorsLogin_passwordone,Environment;
	public static String admin_user,admin_password,doc_image, dc_image;

		public static WebDriver driver;
	public static WebDriver LoadBrowserProperties()throws Exception{
	    FileInputStream inStream;
        inStream = new FileInputStream(new File("ConfigFiles/Setup-Details.txt"));
        Properties prop = new Properties();
        prop.load(inStream);
        //driverpath=prop.getProperty("driver.path");
        base_url=prop.getProperty("base.url");
        recipient_url=prop.getProperty("recipient.url");
        dev_url=prop.getProperty("dev.url");
        enrollment_url=prop.getProperty("enrollment.url");
        doctors_Url=prop.getProperty("Doctors.Url");
        login_password=prop.getProperty("login.password");
        browser_name=prop.getProperty("browser.name");
        login_username=prop.getProperty("login.username");
        Doctor_Name=prop.getProperty("Doctor.Name");
        Diagnostic_Name=prop.getProperty("Diagnostic.Name");
        index_url=prop.getProperty("index.url");
        doc_image=prop.getProperty("doctor.image");
        dc_image=prop.getProperty("dc.image");
        
        
        
        //Doctors -Login Credentails
        DoctorsLogin_username=prop.getProperty("DoctorsLogin.username");
        DoctorsLogin_password=prop.getProperty("DoctorsLogin.password");
        
        DoctorsLogin_usernameone=prop.getProperty("DoctorsLogin.usernameone");
        DoctorsLogin_passwordone=prop.getProperty("DoctorsLogin.passwordone");
      
       //Recipients -Login Credentails
        Recipient_Username=prop.getProperty("Recipient.Username");
        Recipient_Password=prop.getProperty("Recipient.Password");
        

        //Diagnostic- Login Credentials
        
        Diagnostic_usernameone=prop.getProperty("DiagnosticLogin.usernameone");
        Diagnostic_passwordone=prop.getProperty("DiagnosticLogin.passwordone");
        diagnostic_url =prop.getProperty("diagnostic_url");
        
      
        

        Recipient_DSusername=prop.getProperty("Recipient.DSusername");
        Recipient_DSpassword=prop.getProperty("Recipient.DSpassword");

        Recipient_DocUsername=prop.getProperty("Recipient.DocUsername");
        Recipient_DocPassword=prop.getProperty("Recipient.DocPassword");
        Recipient_DiaUsername=prop.getProperty("Recipient.DiaUsername");
        Recipient_DiaPassword=prop.getProperty("Recipient.DiaPassword");
        
        Environment=prop.getProperty("Environment.name");
        
        //Admin - Login credentials
        admin_user=prop.getProperty("admin.user");
        admin_password=prop.getProperty("admin.password");
       
        
        if(browser_name.equals("chrome")){
			System.out.println("launching chrome browser");
			System.setProperty("webdriver.chrome.driver", "BrowserDrivers/chromedriver");
			ChromeOptions options = new ChromeOptions(); // Added to remove new chrome warning message
			options.addArguments("disable-infobars");   // Added to remove new chrome warning message
			driver = new ChromeDriver(options);
			driver.manage().window().maximize();
		}else if(browser_name.equals("firefox")){
			System.out.println("launching Firefox browser");
			System.setProperty("webdriver.firefox.marionette","BrowserDrivers/geckodriver");
			driver=new FirefoxDriver();
			driver.manage().window().maximize();
			//driver = new FirefoxDriver();	
		}else if(browser_name.equals("safari")){
			System.out.println("launching Safari browser");
			driver=new SafariDriver();
			driver.manage().window().maximize();
			
		}
		return driver;
}
	
	
	


}
