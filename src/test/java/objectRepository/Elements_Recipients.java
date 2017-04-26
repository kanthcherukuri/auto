package objectRepository;

import java.io.File;
import java.io.FileInputStream;
import java.util.Properties;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.By;

import testBase.LoadProp;
import testBase.LoadPropMac;


public class Elements_Recipients  {
	
	public static Properties prop = new Properties();
	public static FileInputStream inStream;

	 public static String Recipient_UserName,Recipient_Password,Recipient_Button_Login,Recipient_Wrapper,Default_Slot,link_myAccountheaderIcon,link_aboutHeaderIndex,link_contactUsIndex,link_termsIndex,link_privacyIndex,link_cancellationIndex,link_signinIndex;
	 public static WebDriver driver;
	 
	 public static By enrollment1_h5 = By.xpath("//h5");// Another way of initialization to avoid xpath/id by defining in test case
		
		
	public static WebDriver Recipients_PageProperties()throws Exception{
	   // FileInputStream inStream;
		/*
        inStream = new FileInputStream(new File("PageLocators\\DoctorsPageLocators.txt"));     
        prop.load(inStream);  
        inStream = new FileInputStream(new File("PageLocators\\MapPageLocators.txt")); 
         prop.load(inStream);
        */
	    //Recipient Login Page
         
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
        
		return driver;	
        
       
}

}
