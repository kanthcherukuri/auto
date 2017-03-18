package objectRepository;

import java.io.File;
import java.io.FileInputStream;
import java.util.Properties;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.By;

import testBase.LoadProp;


public class Elements_Doctors  {
	
	public static Properties prop = new Properties();
	public static FileInputStream inStream;
	
	 public static String driverpath;
	 public static String  enrollment_h5,enrollment_firstname,enrollment_lastname,enrollment_regname ;
	 public static String enrollment_mobile,enrollment_email,enrollment_clinicaddress,enrollment_consultationfee,enrollment_notes,enrollment_doc_fac,enrollment_terms_cond,enrollment_submit;
	 public static String home_city,home_area,home_specialization;
	 public static WebDriver driver;
	 
	 public static By enrollment1_h5 = By.xpath("//h5");// Another way of initialization to avoid xpath/id by defining in test case
		
		
	public static WebDriver Doc_PageProperties()throws Exception{
	   // FileInputStream inStream;
		/*
        inStream = new FileInputStream(new File("PageLocators\\DoctorsPageLocators.txt"));     
        prop.load(inStream);  
        inStream = new FileInputStream(new File("PageLocators\\MapPageLocators.txt")); 
         prop.load(inStream);
        */
		
         // Enrollment page elements 
         enrollment_h5="//h5";         
         enrollment_firstname="fname";
         enrollment_lastname="lname";
         enrollment_regname="zws_reg_no";
         enrollment_mobile="zws_mobile";
         enrollment_email="zws_email";
         enrollment_clinicaddress="clinicAddress";
         enrollment_consultationfee="consultationFee";
         enrollment_notes="zws_notes";
         enrollment_doc_fac="zws_doc_fac";
         enrollment_terms_cond="zws_doc_termsCond";
         enrollment_submit="//button[text()='Submit']";
       
        
		return driver;	
        
       
}

}
