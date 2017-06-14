package doctorsTestScripts;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.testng.annotations.AfterClass;
import org.testng.annotations.Test;

import objectRepository.Elements_Doctors;

import org.testng.annotations.BeforeClass;
import java.util.concurrent.TimeUnit;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.DataProvider;
import testBase.DoctorsPage;
import testBase.LoadPropMac;
import testBase.TestUtils;

public class Appointment_ZOY808_SendNoficationOfTodayTab extends LoadPropMac {
	
	public DoctorsPage DoctorsPage;
	 public TestUtils Browser;
	 
		 @BeforeClass
		 public void LaunchBrowser() throws Exception {  	 
		 LoadBrowserProperties();
		 driver.manage().window().maximize();
	 		driver.get(doctors_Url);		 
	 		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
	 		DoctorsPage= new DoctorsPage(driver);	
	 		Browser=new TestUtils(driver);
		 	DoctorsPage.SignIn( DoctorsLogin_usernameone, DoctorsLogin_passwordone);
	
		   }       
	  		
  		@DataProvider(name = "DP1")
 		 public String[][] createData1() {
 				return new String[][] {
 						{ "yes","Raviashwin","R","99666623322","raviashwin@gmail.com","Diabetic" }

 				};
 			}
	  		
	  		
	 	  @Test(dataProvider="DP1")
	 	  public void SendNoficationForTodayTab(String RunMode,String firstname,String lastname,String mobile,String email,String problem) throws Exception{	
	 		
	 		DoctorsPage.DoctorAppointmentBookingForToday(firstname, lastname, mobile, email, problem);
	 		Thread.sleep(1000);
	 		driver.findElement(By.id(Elements_Doctors.patienticonid)).click();
			Thread.sleep(3000);	
			driver.findElement(By.id(Elements_Doctors.patientsearchbox)).sendKeys(email);	 
		 	driver.findElement(By.id(Elements_Doctors.patientsearchbox)).sendKeys(Keys.ENTER);
		 	Thread.sleep(1000);
		 	String name=driver.findElement(By.xpath(Elements_Doctors.todaytabname)).getText();
		 	String schedule=driver.findElement(By.xpath(Elements_Doctors.todaytabschedule)).getText();
		 	String fullname=firstname+" "+lastname;
		 	if(name.equalsIgnoreCase(fullname)&&schedule.equalsIgnoreCase("Scheduled")){
		 		driver.findElement(By.xpath(Elements_Doctors.sendnotification)).click();
		 		System.out.println("Sucessfully clicked on Send Notification button");
		 		Browser.CheckNotificationMessage("Email/SMS Notification sent to the Patient");
		 		Thread.sleep(2000);
		 	}
	 		//DoctorsPage.CheckPatientScreenSendNotificationOfTodayTab(firstname, lastname, email);
	 		
	 	  	}
	 		  
	 		@AfterMethod
	 		public void AppointmentBulkCancellationAndLogout() throws Exception{
	 			DoctorsPage.BulkCancel();
	 			Thread.sleep(2000);
	 			DoctorsPage.doctorlogout();
	 			
	 		}
	 	  @AfterClass
	 	  public void Closebrowser(){
	 		  driver.quit();
	 	  }
	 	  
	 
	 
	 
}
