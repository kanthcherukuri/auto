package objectRepository;

import java.io.FileInputStream;
import java.util.Properties;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.By;




public class Elements_Diagnostics  {
	
	public static Properties prop = new Properties();
	public static FileInputStream inStream;

	 public static String home_city,home_area,home_specialization,map_AreaName,searchIcon,link_customerlogin,link_practicelogin,link_contactus,link_aboutus,link_diagnostics,link_termsconditions,link_privacypolicy,link_cancellationrefundpolicy,button_forandroid,button_forios;
	 public static WebDriver driver;
	 
	 public static By enrollment1_h5 = By.xpath("//h5");// Another way of initialization to avoid xpath/id by defining in test case
	 
	 //Diagonistic Login page Locators variables
	    public static String username;
		public static String password;
		public static String loginbutton;
		
		//Diagnostic Home visit appointment locators variables
		public static String clickonappointmentsmenu;
		public static String clickontoggle;
		public static String tommorowmenu;
		public static String morninghomevisit;
		public static String noonhomevisit;
		public static String eveninghomevisit;
		public static String eveningfirstcell;
		public static String detailsfirstname;
		public static String detailslastname;
		public static String detailsmobile;
		public static String detailsemail;
		public static String detailsaddress;
		public static String detailsproblem;
		public static String packagetab;
		public static String packagecheckbox;
		public static String windowsavebutton;
		
		//notification variable
		public static String notification;
		
		//Ellipse locator Variables
		public static String ellipse;
		
		//Diagnostics logout locator variables
		public static String clickonmyaccountmenu;
		public static String clickonsignout;
		public static String confirmsignout;
		
		//Appointments Reschedule Variables
		public static String clickonmore;
		public static String clickonchange;
		public static String nextdaymenu;
		public static String topnotification;
		
		//Cancel Appointment Variables
		public static String clickoncancel;
		public static String selectbox;
		public static String submitbutton;
		
		//Bulk Cancel Locator Variables
		public static String fromtime;
		public static String totime;
		public static String bulksubmitbutton;
		public static String fromcanceldate;
		public static String tocanceldate;
		
		//Diagnostic Appointment Creation Variables
		public static String morningmenu;
		public static String noonmenu;
		public static String eveningmenu;
		
		//View Diagnostic Appointment Variables
		public static String calltext;
		public static String changetext;
		public static String canceltext;
		
		//patient tab Variables
		public static String clickonpatientmenu;
		public static String clickonsearchicon;
		public static String todaytabsize;
		public static String clickonalltab;
		public static String serachtextbox;
		public static String alltabsize;
		
	 
		
		
	public static WebDriver Diag_PageProperties()throws Exception{
	   // FileInputStream inStream;
		/*
        inStream = new FileInputStream(new File("PageLocators\\DoctorsPageLocators.txt"));     
        prop.load(inStream);  
        inStream = new FileInputStream(new File("PageLocators\\MapPageLocators.txt")); 
         prop.load(inStream);
        */
		
         // Home page elements 
         home_city="search-city";         
         home_area="search-area";
         home_specialization="name";
         map_AreaName="zy-location-right";
         searchIcon="search-icon";
         link_customerlogin="//a[contains(.,'Customer Login')]";
         link_practicelogin="//a[contains(.,'Practice Login')]";
         link_contactus="//a[contains(.,'Contact us')]";
         link_aboutus="//a[contains(.,'About us')]";
         link_diagnostics="//a[contains(.,'Diagnostics')]";
         link_termsconditions="//a[contains(.,'Terms & Conditions')]";
         link_privacypolicy="//a[contains(.,'Privacy Policy')]";
         link_cancellationrefundpolicy="//a[contains(.,'Cancellation & Refund Policy')]";
         button_forandroid="//img[@src='https://d130z5wnxdwqwr.cloudfront.net/images/homePage/app-android.gif']";
         button_forios="//img[@src='https://d130z5wnxdwqwr.cloudfront.net/images/homePage/app-ios.gif']";
         
         
         
       //doctors Login Page Locators         
    	 username="emailAddress";
		 password="password";
		 loginbutton="//*[@id='zoyloCustLogin-form']/div/div[2]/div/div/div/div[1]/button";
		 
		 //Diagnostic Home visit appointment locators	 
		 
		 clickonappointmentsmenu ="appointments";
		 clickontoggle = ".//label[@for='someSwitchOptionDefault']";
		 tommorowmenu = "//*[@id='cd-1']";
		 morninghomevisit="//*[@id='diag-home-samples']/div[3]/ul/li[1]/div/div";
		 noonhomevisit="//*[@id='diag-home-samples']/div[3]/ul/li[2]/div/div";
		 eveninghomevisit="//*[@id='diag-home-samples']/div[3]/ul/li[3]/div/div";
		 eveningfirstcell="//*[@id='myTab-3']/ul/li[1]/div[3]";
		 detailsfirstname="apt_fname";
		 detailslastname="apt_lname";
		 detailsmobile="apt_mobile";
		 detailsemail="apt_email";
		 detailsaddress="apt_address";
		 detailsproblem="apt_problem";
		 packagetab="//li[2]//a[@data-toggle='tab']";
		 packagecheckbox="//input[@class='pack_select_checkbox']";
		 windowsavebutton="diagServiceAptms_save";
		 
		//notification locator
		 
		 notification="html/body/div[6]/div";
		 
		//Diagnostics logout locator 
		 clickonmyaccountmenu="account";	
		 clickonsignout="//*[@id='myTabs']/li[6]/a/span[1]/i";
		 confirmsignout="logout";
		 
		 ellipse="//span//i[@class='fa fa-ellipsis-v footer-relipse']";
		 
		 //Reschedule Locators
		 clickonmore="//*[@id='myTab-3']/ul/li[1]/div[2]/a";
		 clickonchange=".//*[@id='zy-spdg-view0']/div/div[4]/div[2]/span[1]/button";
		 nextdaymenu="//*[@id='cd-2']/div[1]";
		 topnotification= "div[class='zy-status-wrapper']";
		 
		 //Cancel Locators
		 
		 clickoncancel="//*[@id='zy-spdg-view0']/div/div[4]/div[2]/span[2]/button";
		 selectbox="cancel_reason_select";
		 submitbutton=".//*[@id='submitCancelApt']/button";
		 
		 //bulk Cancel Locators
		 fromtime="//*[@id='bulk_cancel_fromTime']";
		 totime="//*[@id='bulk_cancel_toTime']";
		 bulksubmitbutton="//*[@id='bulkCancel_submit']";
		 fromcanceldate="//*[@id='bulk_cancel_fromDate']";
		 tocanceldate="//*[@id='bulk_cancel_toDate']";
		 
		 //Diagnostic Appointment Creation Locators
		 
		 morningmenu="//*[@id='diag-home-samples']/div[3]/ul/li[1]/div/div";
		 noonmenu="//*[@id='diag-home-samples']/div[3]/ul/li[2]/div/div";
		 eveningmenu="//*[@id='diag-home-samples']/div[3]/ul/li[3]/div/div";
		 
		 //View Diagnostic Locators
		 calltext="//span[@class='zy-sp-diag-m-p-text']";
		 changetext="//span[@class='zy-sp-diag-m-p-chng-btn change_apt']";
		 canceltext="//span[@class='zy-sp-diag-m-p-cancel-btn cancel_appointment']";
		 
		 //Patient Screen Locators
		 
		 clickonpatientmenu="patients";
		 clickonsearchicon="//*[@id='search-bar']";
		 todaytabsize="//*[@id='sp-diagno-tab-1']/div";
		 clickonalltab="all";
		 serachtextbox="apt-search";
		 alltabsize="//*[@id='sp-diagno-tab-2']/div";
		return driver;	
        
       
}

}
