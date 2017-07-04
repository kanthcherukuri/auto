package objectRepository;

import java.io.FileInputStream;
import java.util.Properties;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.By;


public class Elements_Recipients  {
	
	public static Properties prop = new Properties();
	public static FileInputStream inStream;

	 public static String Recipient_UserName,Recipient_Password,Recipient_Button_Login,Recipient_Wrapper,Default_Slot,link_myAccountheaderIcon,link_aboutHeaderIndex,link_contactUsIndex,link_termsIndex,link_privacyIndex,link_cancellationIndex,link_signinIndex;
	 public static String dcNameHolder, dcHomePickUp, recipient_firstHomeAddress, dcHomeVisitAddressProceed, dcHometestTab, dcHomePkgTab, hWorkingTab;
	 public static WebDriver driver;
	 
	 public static By enrollment1_h5 = By.xpath("//h5");// Another way of initialization to avoid xpath/id by defining in test case
	public static String selectFirstDoctorFromListingPage, selectFirstDoctorBookBtnFromListingPage, mapListingIcon;
	public static String addressAssertion, getDirectionLink, distanceValue, backBtn, getDistanceFromListingForFirstDoctor;
		
	public static WebDriver Recipients_PageProperties()throws Exception{
	   // FileInputStream inStream;
		/*
        inStream = new FileInputStream(new File("PageLocators\\DoctorsPageLocators.txt"));     
        prop.load(inStream);  
        inStream = new FileInputStream(new File("PageLocators\\MapPageLocators.txt")); 
         prop.load(inStream);
        */
	    //Recipient Login Page
		mapListingIcon="mapIconMenu"; //ID
		getDistanceFromListingForFirstDoctor="(//div[@class='dctr-exprnce']//span[2])[1]"; //XPATH
		backBtn="backArrow"; //ID
		distanceValue="(//span[@class='zy-ad-leftContent'])[1]"; //XPATH
		getDirectionLink="default_clini_get"; //ID
		addressAssertion="//h4[@class='accordion-toggle']"; //XPATH
         selectFirstDoctorFromListingPage="(.//*[@id='serviceProvider']//h1)[1]"; //XPATH
         selectFirstDoctorBookBtnFromListingPage="(//button[contains(., 'Book')])[1]"; //XPATH
         Recipient_UserName="emailAddress";
         Recipient_Password="password";
         Recipient_Button_Login="//button[text()='Login']";
         Recipient_Wrapper="div.zy-status-wrapper";
         Default_Slot="(//*[@id='apponitmentTime' and @class='sp-available-slots'])[1]";
         link_myAccountheaderIcon="//img[@class='indexProfileImg']";
         link_aboutHeaderIndex="aboutOption_Index";
         link_contactUsIndex="contactOption_Index";
         link_termsIndex="termsOption_Index";
         link_privacyIndex="privacy_Index";
         link_cancellationIndex="cancellationOption_Index";
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
