package doctorsTestScripts;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.testng.annotations.AfterClass;
import org.testng.annotations.Test;

import objectRepository.Elements_Doctors;

import org.testng.annotations.BeforeClass;
import org.testng.annotations.AfterMethod;
import java.util.concurrent.TimeUnit;
import org.testng.annotations.DataProvider;
import testBase.DoctorsPage;
import testBase.LoadPropMac;
import testBase.TestUtils;

public class Appointments_ZOY808_SendNotification extends LoadPropMac{
	
public DoctorsPage DoctorsPage;
	 
 public TestUtils Browser;
 
	 
		 @BeforeClass 
		public void beforeClass() throws Exception {  	 
			 LoadBrowserProperties();
			driver.get(doctors_Url);		 
		  driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		  DoctorsPage= new DoctorsPage(driver);	
		  Browser=new TestUtils(driver);
		  DoctorsPage.SignIn( DoctorsLogin_usernameone, DoctorsLogin_passwordone);
		  }
  
 		@DataProvider(name = "DP1")
		 public String[][] createData1() {
				return new String[][] {
						{ "yes","Dharmaraju","Sameera","9999393322","dharma@gmail.com","Diabetic" }

				};
			}
 		
 		
	  @Test(dataProvider="DP1")
	  public void SendNoficationForAllTab(String RunMode,String firstname,String lastname,String mobile,String email,String problem) throws Exception{	
		  
		  DoctorsPage.DoctorsAppointmentforTomorrow(firstname, lastname, mobile, email, problem); 
		  Thread.sleep(2000);
		  driver.findElement(By.id(Elements_Doctors.patienticonid)).click();
			Thread.sleep(5000);
			driver.findElement(By.xpath(Elements_Doctors.alltab)).click();
			System.out.println("Clicked on all tab");
			Thread.sleep(3000);
			driver.findElement(By.id(Elements_Doctors.patientsearchbox)).sendKeys(email);	 
		 	driver.findElement(By.id(Elements_Doctors.patientsearchbox)).sendKeys(Keys.ENTER);
			String name=driver.findElement(By.xpath(Elements_Doctors.alltabname)).getText();
			String schedule=driver.findElement(By.xpath(Elements_Doctors.alltabschedule)).getText();
			String fullname=firstname+" "+lastname;
			if(name.equalsIgnoreCase(fullname)&&schedule.equalsIgnoreCase("Scheduled")){
			driver.findElement(By.xpath(Elements_Doctors.sendnotification)).click();
			System.out.println("Sucessfully clicked on Send Notification button");
			Browser.CheckNotificationMessage("Email/SMS Notification sent to the Patient");

			}
		 // DoctorsPage.CheckPatientScreenSendNotificationOfAllTab(firstname, lastname, email);
		  Thread.sleep(3000);
	  	}
		  
		@AfterMethod
		public void AppointmentBulkCancellationAndLogout() throws Exception{
			DoctorsPage.BulkCancel();
			DoctorsPage.doctorlogout();
			
		}
	  @AfterClass
	  public void Closebrowser(){
		  driver.quit();
	  }
	  
	  
	  

}//Main Class
	  





