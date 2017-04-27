package doctorsTestScripts;

import org.testng.annotations.AfterClass;
import org.testng.annotations.Test;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.Test;
import org.testng.annotations.BeforeClass;
import java.util.concurrent.TimeUnit;
import org.testng.annotations.DataProvider;
import testBase.DoctorsPage;
import testBase.LoadPropMac;
import testBase.TestUtils;

public class Appointments_ZOY808_SendNotification extends LoadPropMac{
	
public DoctorsPage DoctorsPageOfZoylo;
	 
 public TestUtils exceldata;
 
	 
		 @BeforeClass 
		public void beforeClass() throws Exception {  	 
		LoadBrowserProperties();
		  }
  
 		@DataProvider(name = "DP1")
		 public String[][] createData1() {
				return new String[][] {
						{ "yes","Dheera","Sameera","9969393322","dheera@gmail.com","Diabetic" }

				};
			}
 		
 		
	  @Test(dataProvider="DP1")
	  public void SendNoficationForAllTab(String RunMode,String firstname,String lastname,String mobile,String email,String problem) throws Exception{	
		  driver.get(doctors_Url);		 
		  driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		  DoctorsPageOfZoylo= new DoctorsPage(driver);			
		  DoctorsPageOfZoylo.SignIn( DoctorsLogin_usernameone, DoctorsLogin_passwordone);
		  DoctorsPageOfZoylo.DoctorsAppointmentforTomorrow(firstname, lastname, mobile, email, problem); 
		  Thread.sleep(2000);
		  DoctorsPageOfZoylo.CheckPatientScreenSendNotificationOfAllTab(firstname, lastname, email);
		  Thread.sleep(3000);
	  	}
		  
		@AfterMethod
		public void AppointmentBulkCancellationAndLogout() throws Exception{
			DoctorsPageOfZoylo.BulkCancel();
			Thread.sleep(2000);
			DoctorsPageOfZoylo.doctorlogout();
			
		}
	  @AfterClass
	  public void Closebrowser(){
		  driver.close();
	  }
	  
	  
	  

}//Main Class
	  





