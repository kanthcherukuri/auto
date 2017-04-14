package doctorsTestScripts;

import java.util.concurrent.TimeUnit;

import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import testBase.DoctorsPage;
import testBase.LoadProp;
import testBase.LoadPropMac;
import testBase.TestUtils;

public class Appointments_ZOY808_SendNotification extends LoadPropMac{
	
public DoctorsPage DoctorsPageOfZoylo;
	 
 public TestUtils exceldata;
 
	 
 @BeforeClass
 
public void beforeClass() throws Exception {  	 
LoadBrowserProperties();
driver.manage().window().maximize();
driver.get(doctors_Url);		 
driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);

  }
		  
		     
  @Test(priority=1)
  
public  void SignIntoDoctorLogin() throws Exception {
DoctorsPageOfZoylo= new DoctorsPage(driver);			
DoctorsPageOfZoylo.SignIn( DoctorsLogin_usernameone, DoctorsLogin_passwordone);
}
  
  
  @Test(priority=2)
  
public void nofication() throws Exception{	  
	 
DoctorsPageOfZoylo.patientsendnotification();
  
}
	  
	  
  @AfterClass
  public void closebrowser(){
	  driver.close();
  }
	  
	  
	  

}//Main Class
	  





