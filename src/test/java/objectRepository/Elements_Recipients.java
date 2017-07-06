package objectRepository;

import java.io.FileInputStream;
import java.util.Properties;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.By;


public class Elements_Recipients  {
	
	public static Properties prop = new Properties();
	public static FileInputStream inStream;

	 public static String Recipient_UserName,Recipient_Password,Recipient_Button_Login,Recipient_Wrapper,Default_Slot,link_myAccountheaderIcon,link_aboutHeaderIndex,link_contactUsIndex,link_termsIndex,link_h2Header,link_header,link_privacyIndex,link_cancellationIndex,link_signinIndex;
	 public static String dcNameHolder, dcHomePickUp, recipient_firstHomeAddress, dcHomeVisitAddressProceed, dcHometestTab, dcHomePkgTab, hWorkingTab;
	 public static WebDriver driver;
	 
	 public static By enrollment1_h5 = By.xpath("//h5");// Another way of initialization to avoid xpath/id by defining in test case
	public static String selectFirstDoctorFromListingPage, selectFirstDoctorBookBtnFromListingPage, mapListingIcon;
	public static String addressAssertion, getDirectionLink, distanceValue, backBtn, getDistanceFromListingForFirstDoctor, doctorNameOnProfile;
	public static String bookAptHeader,paymentPageHeader,cancelPaymentPage, bookAptPageDate, bookAptPageFee, makePaymentBtn, indexHeaderUserIcon;
	
	//Home page elements
	public static String home_PracticeLogin, home_PracticeLogin_PagePlaceHolder, home_customerLogin, home_customerLogin_PagePlaceHolder, home_AppStoreLink, home_AppStore_Page, home_androidLink, home_androidLink_Page;
	public static String home_aboutUs, home_contactUs, home_terms, home_privacy, home_cancelRefund;
	public static String indexLocationName, indexLocationDropDown, indexCurrentLocator, indexLocationContainer;
	public static String dcNameOnProfilePage, dcBookAptPageHeader, dcNameOnThankYouPage, thankYouPageLogo;
	
	public static WebDriver Recipients_PageProperties()throws Exception{
	   // FileInputStream inStream;
		/*
        inStream = new FileInputStream(new File("PageLocators\\DoctorsPageLocators.txt"));     
        prop.load(inStream);  
        inStream = new FileInputStream(new File("PageLocators\\MapPageLocators.txt")); 
         prop.load(inStream);
        */
		thankYouPageLogo="//a[@class='desktop-logo']"; //XPATH
		dcNameOnThankYouPage="(//div[@class='book-dtbox']//h3)[2]"; //XPATH
		dcNameOnProfilePage="//span[@class='zy-rec-diag-m-d-name']"; //XPATH
		dcBookAptPageHeader="//h1[contains(., 'Book Diagnostic Lab Test')]"; //XPATH
		//Index
		indexLocationName="zy-location-right"; //ID
		indexLocationDropDown="(.//*[@id='zy-location-right']/span)[2]"; //XPATH
		indexLocationContainer="//span[@class='autodetcarea']"; //XPATH
		indexCurrentLocator="//span[@class='autodetc-location']"; //XPATH
		
		//HOME PAGE
		home_PracticeLogin="//a[@href='/doctorsignin']"; //XPATH
		home_PracticeLogin_PagePlaceHolder="//input[@placeholder='Zoylo Id']"; //XPATH
		home_customerLogin="//a[@href='/login']"; //XPATH
		home_customerLogin_PagePlaceHolder="//input[@placeholder='Email']"; //XPATH
		home_AppStoreLink="//a[@href='http://m.onelink.me/34dfbfec']"; //XPATH
		home_AppStore_Page="//img[@alt='iTunes']"; //XPATH
		home_androidLink="//a[@href='http://m.onelink.me/7a85373']"; //XPATH
		home_androidLink_Page="//span[@class='gb_Za gb_Xa']"; //XPATH
		home_aboutUs="//a[@href='/aboutus']"; //XPATH
		home_contactUs="//a[@href='contactus']"; //XPATH
		home_terms="//a[@href='/terms']"; //XPATH
		home_privacy="//a[@href='/privacy']"; //XPATH
		home_cancelRefund="//a[@href='/cancellationRefundPolicy']"; //XPATH
		
	    //Recipient Login Page
		indexHeaderUserIcon="//img[@class='indexProfileImg userImgBackground']"; //XPATH
		makePaymentBtn="proceed"; //ID
		bookAptPageFee="providerFees"; //ID
		bookAptPageDate="//div[@class='d-y-t']"; //XPATH
		cancelPaymentPage="cancel"; //ID
		paymentPageHeader="//h4[contains(.,'Review Your Appointment Details')]"; //XPATH
		bookAptHeader="//h1[contains(., 'Book Appointment')]"; //XPATH
		doctorNameOnProfile="//h1[@class='tr-override-dctr-content-h1']"; //XPATH
		mapListingIcon="mapIconMenu"; //ID
		getDistanceFromListingForFirstDoctor="(//div[@class='dctr-exprnce']//span[2])[1]"; //XPATH
		backBtn="backArrow"; //ID
		distanceValue="(//span[@class='zy-ad-leftContent'])[1]"; //XPATH
		getDirectionLink="default_clini_get"; //ID
		addressAssertion="//span[@class='docinfo-address-label']"; //XPATH
         selectFirstDoctorFromListingPage="(.//*[@id='serviceProvider']//h1)[1]"; //XPATH
         selectFirstDoctorBookBtnFromListingPage="(//button[contains(., 'Book')])[1]"; //XPATH
         Recipient_UserName="emailAddress";
         Recipient_Password="password";
         Recipient_Button_Login="//button[text()='Login']";
         Recipient_Wrapper="div.zy-status-wrapper";
         Default_Slot="(//*[@id='apponitmentTime' and @class='sp-available-slots'])[1]";
         link_myAccountheaderIcon="//img[@class='indexProfileImg']";
         link_aboutHeaderIndex="//a[@href='/zyAboutUs']";
         link_contactUsIndex="//a[@href='/zyContactUs']";
         link_termsIndex="//a[@href='/zyTermsConditions']";
         link_h2Header="//h2[@class='page-head']";
         link_header="//h2";
         link_privacyIndex="//a[@href='/zyPrivacyPolicy']";
         link_cancellationIndex="//a[@href='/zyRefundPolicy']";
         link_signinIndex="myAccountLink";
         dcNameHolder="//span[@class='zy-rec-diag-m-d-name']";
         dcHomePickUp="home_pickup";
         recipient_firstHomeAddress="(//div[@class='zy-rec-diag-hm-add-radio']//input[@name='address'])[1]";
         dcHomeVisitAddressProceed="//div[@class='zy-rec-diag-add-confirm-btn']//span";
         dcHometestTab="h_Test_li";
         dcHomePkgTab="h_Package_li";
         hWorkingTab="h_WorkTimings_li";
        
		return driver;	
        
       
}

}
