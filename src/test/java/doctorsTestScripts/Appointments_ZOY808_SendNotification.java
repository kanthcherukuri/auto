package doctorsTestScripts;

import java.util.concurrent.TimeUnit;

import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import testBase.DoctorsPage;
import testBase.LoadProp;
import testBase.TestUtils;

public class Appointments_ZOY808_SendNotification extends LoadProp{
	
	public DoctorsPage DoctorsPageOfZoylo;
	 
	 public TestUtils exceldata;
	 
	 @BeforeClass
	  public void beforeClass() throws Exception {
		  
		  
		  LoadBrowserProperties();
			 driver.manage().window().maximize();
			 driver.get(doctors_Url);		 
			 driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		
			  }
		  
		     
	  @Test
	  public  void SignIntoDoctorLogin() throws Exception {
			
			 DoctorsPageOfZoylo= new DoctorsPage(driver);			
			DoctorsPageOfZoylo.SignIn( DoctorsLogin_usernameone, DoctorsLogin_passwordone);
					
			  }
	  
	  
	  @Test
	  public void nofication() throws Exception{
		  
		 
		  DoctorsPageOfZoylo.patientsendnotification();
	  
			 }
	  
	  
	  
	  
	  
	  

}
	  





