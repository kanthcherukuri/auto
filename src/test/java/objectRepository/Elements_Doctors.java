package objectRepository;

import java.io.FileInputStream;
import java.util.Properties;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.By;


public class Elements_Doctors  {
	
	public static Properties prop = new Properties();
	public static FileInputStream inStream;
	
	
	 public static String driverpath;
	 public static String  enrollment_h5,enrollment_firstname,enrollment_lastname,enrollment_regname ;
	 public static String enrollment_mobile,enrollment_email,enrollment_clinicaddress,enrollment_consultationfee,enrollment_notes,enrollment_doc_fac,enrollment_terms_cond,enrollment_submit;
	 public static String home_city,home_area,home_specialization;
	 public static WebDriver driver;
	 
	 
	 // Doctor login page Locators(xpath,id etc)
	   public static String username;
		public static String password;
		public static String loginbutton;
		
		
		//Doctor Appointment & Reschedule Locators
		
				public static String doctortab;
				public static String tommorrowmenu;
				public static String morning;
				public static String noon;
				public static String evening;
				public static String eveningfirstcell;
				public static String locatorfirstname;
				public static String locatorlsatname;
				public static String locatormobile;
				public static String locatoremail;
				public static String locatorproblem;
				public static String backgoundcolor;
				public static String changeicon;
				public static String nextmenu;
				public static String morningfirstcell;
				public static String changeslot;
				public static String topnotification;
				public static String patienticon;
				public static String patientsearchbox;
				public static String patientallmenu;
				
				
				//Patients screen 
				
				public static String patienticonid;
				public static String alltab;
				public static String alltabdivsize;
				public static String sendnotficationbutton;
				public static String sendnotification;
				
				
				
				
				
		
	 
	 public static By enrollment1_h5 = By.xpath("//h5");// Another way of initialization to avoid xpath/id by defining in test case
		
		
	public static  WebDriver Doc_PageProperties()throws Exception{
	   
	
		
		
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
                  
         //doctors Login Page Locators         
    	 username="emailAddress";
		 password="password";
		 loginbutton="//*[@id='zoyloCustLogin-form']/div/div[2]/div/div/div/div[1]/button";
		 
		 
			//Doctor Appointment & Reschedule Locators
			 
			 doctortab="appointment_appointmentCalendar";
			 tommorrowmenu="//*[@id='cd-1']";
			 morning="//*[@id='patient-apmt-tabs']/li[1]/div/center/span[1]";
			 noon="//*[@id='patient-apmt-tabs']/li[2]/div/center/span[1]";
			 evening="//*[@id='patient-apmt-tabs']/li[3]/div/center/span[1]";
			 eveningfirstcell="//div[@id='tab-3']/ul/li[1]/div[2]";
			 locatorfirstname="//*[@id='firstName']";
			 locatorlsatname="lastName";
			 locatormobile="mobileNumber";
			 locatoremail="email";
			 locatorproblem="problem";
			 backgoundcolor="//*[@id='tab-3']/ul/li[1][@class='bg-red']";
			 changeicon="//*[@id='change']";
			 nextmenu="//*[@id='cd-2']";
			 morningfirstcell="//*[@id='tab-1']/ul/li[1]";
			 changeslot="//*[@id='confrimSlotChange']";
			 topnotification="html/body/div[6]/div";
			 patienticon="patients_patientsIcon";
			 patientsearchbox="searchPatientsList";
			 patientallmenu=" html/body/div[9]/div[3]/div[2]/div/ul/li[2]";
			 
			 //Patient screen send notification
		 
			 patienticonid="patients";
			 
			 alltab="html/body/div[9]/div[3]/div[2]/div/ul/li[2]";
			 
			 alltabdivsize="//*[@id='all']/div";
			 
			 sendnotficationbutton="//button[text()='Send Notification']";
       
			sendnotification="//*[@id='resendNotification']/button";
		return driver;	
        
       
}
	

	

	
	
	
	
	
	
	
}
