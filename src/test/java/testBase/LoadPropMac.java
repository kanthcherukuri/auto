package testBase;

import java.io.File;
import java.io.FileInputStream;
import java.net.URL;
import java.util.Properties;


import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.safari.SafariDriver;
import org.testng.ITestResult;

public class LoadPropMac   {
	public static Properties prop = new Properties();
	public static FileInputStream inStream;
	public static String driverpath;
	public static String base_url, dev_url, loginPage_Url,index_url,enrollment_url,doctors_Url,browser_name , login_username,login_password,namespaceurl ;
	public static String diagnostic_url;
	
	//To Run On Cloud - Sauce Labs
	public static final String USERNAME = "ganeshmandala123";
 	public static final String ACCESS_KEY = "54f5beb0-8191-4184-9094-ec209f9b300c";
 	public static final String URL = "https://" + USERNAME + ":" + ACCESS_KEY + "@ondemand.saucelabs.com:443/wd/hub";

	//Diagnostic Variables
	public static String Diagnostic_usernameone,Diagnostic_passwordone;
	public static String DoctorsLogin_username, DoctorsLogin_password,Doctor_Name,Diagnostic_Name, recipient_myaccount, DoctorsLogin_usernametwo, DoctorsLogin_passwordtwo;
	public static String Recipient_Username, Recipient_Password,Recipient_DSusername,
	Recipient_DSpassword,Recipient_DocUsername,Recipient_DocPassword,Recipient_DiaUsername,Recipient_DiaPassword;
	public static String DoctorsLogin_usernameone,DoctorsLogin_passwordone,Environment_Name, recipientDC_User, recipientDC_Password;
	public static String admin_user,admin_password,doc_image, dc_image, adminuser_user, adminuser_password, Diagnostic_username, Diagnostic_password;
    public static String Diagnostic_usernamethree, Diagnostic_passwordthree, DoctorsLogin_usernamefour, DoctorsLogin_passwordfour;
    
	public static WebDriver driver;

	public static WebDriver LoadBrowserProperties()throws Exception{
	    FileInputStream inStream;
        inStream = new FileInputStream(new File("ConfigFiles/Setup-Details.txt"));
        Properties prop = new Properties();
        prop.load(inStream);
        base_url=prop.getProperty("base.url");
        recipient_myaccount=prop.getProperty("recipient.myaccount");
        loginPage_Url=prop.getProperty("loginPage.url");
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
        adminuser_user=prop.getProperty("adminuser.user");
        adminuser_password=prop.getProperty("adminuser.password");
        recipientDC_User=prop.getProperty("recipientDC.username");
        recipientDC_Password=prop.getProperty("recipientDC.password");
        
        
        
        //Doctors -Login Credentails
        DoctorsLogin_username=prop.getProperty("DoctorsLogin.username");
        DoctorsLogin_password=prop.getProperty("DoctorsLogin.password");
        
        DoctorsLogin_usernameone=prop.getProperty("DoctorsLogin.usernameone");
        DoctorsLogin_passwordone=prop.getProperty("DoctorsLogin.passwordone");
        
        DoctorsLogin_usernametwo=prop.getProperty("DoctorLogin.usernamethree");
        DoctorsLogin_passwordtwo=prop.getProperty("DoctorLogin.passwordthree");
        
        DoctorsLogin_usernamefour=prop.getProperty("DoctorsLogin.usernamefour");
        DoctorsLogin_passwordfour=prop.getProperty("DoctorsLogin.passwordfour");
      
       //Recipients -Login Credentails
        Recipient_Username=prop.getProperty("Recipient.Username");
        Recipient_Password=prop.getProperty("Recipient.Password");
        

        //Diagnostic- Login Credentials
        
        Diagnostic_usernameone=prop.getProperty("DiagnosticLogin.usernameone");
        Diagnostic_passwordone=prop.getProperty("DiagnosticLogin.passwordone");
        diagnostic_url =prop.getProperty("diagnostic_url");
        
        Diagnostic_username=prop.getProperty("DiagonsticLogin.username");
        Diagnostic_password=prop.getProperty("DiagnosticLogin.password");
        
        Diagnostic_usernamethree=prop.getProperty("DiagnosticLogin.usernamethree");
        Diagnostic_passwordthree=prop.getProperty("DiagnosticLogin.passwordthree");

        Recipient_DSusername=prop.getProperty("Recipient.DSusername");
        Recipient_DSpassword=prop.getProperty("Recipient.DSpassword");

        Recipient_DocUsername=prop.getProperty("Recipient.DocUsername");
        Recipient_DocPassword=prop.getProperty("Recipient.DocPassword");
        Recipient_DiaUsername=prop.getProperty("Recipient.DiaUsername");
        Recipient_DiaPassword=prop.getProperty("Recipient.DiaPassword");
        
        Environment_Name=prop.getProperty("Environment.name");
        
        //Admin - Login credentials
        admin_user=prop.getProperty("admin.user");
        admin_password=prop.getProperty("admin.password");
        
        
        //Sauce Labs - Capabilities
        
      /*  DesiredCapabilities caps = DesiredCapabilities.chrome();
        caps.setCapability("platform", "macOS 10.12");
        caps.setCapability("version", "58.0");
        driver = new RemoteWebDriver(new URL(URL), caps);
       
        */
      
      
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
