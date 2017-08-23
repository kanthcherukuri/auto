package doctorsTestScripts;

import org.testng.annotations.AfterClass;
import org.testng.annotations.Test;
import org.testng.annotations.BeforeClass;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import objectRepository.Elements_Doctors;
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
	 		DoctorsPage= new DoctorsPage(driver);	
	 		Browser=new TestUtils(driver);
	 		Browser.openUrl("https://"+Environment_Name+".zoylo.com/login");
	 		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		 	DoctorsPage.SignIn( DoctorsLogin_usernameone, DoctorsLogin_passwordone);
	
		   }     
		 
		 
		 @DataProvider(name = "SendNotification")
		    public Object[][] createData_DP1() throws Exception{
		        Object[][] retObjArr=TestUtils.getTableArray("TestData/DoctorProvider.xls","Doctor", "ZOY808");
		        return(retObjArr);
		    }
	  	
	  		
	 	  @Test(dataProvider="SendNotification")
	 	  public void SendNoficationForTodayTab(String firstname,String lastname,String mobile,String email,String problem) throws Exception{	
	 		
	 		DoctorsPage.DoctorAppointmentBookingForToday(firstname, lastname, mobile, email, problem);
	 		Thread.sleep(1000);
	 		driver.findElement(By.id(Elements_Doctors.patient_id)).click();
			Thread.sleep(3000);	
			driver.findElement(By.id(Elements_Doctors.patient_searchbox)).sendKeys(email);	 
		 	driver.findElement(By.id(Elements_Doctors.patient_searchbox)).sendKeys(Keys.ENTER);
		 	Thread.sleep(1000);
		 	String name=driver.findElement(By.xpath(Elements_Doctors.patient_todaytabname)).getText();
		 	String schedule=driver.findElement(By.xpath(Elements_Doctors.patient_todaytabschedule)).getText();
		 	String fullname=firstname+" "+lastname;
		 	if(name.equalsIgnoreCase(fullname)&&schedule.equalsIgnoreCase("Scheduled")){
		 		driver.findElement(By.xpath(Elements_Doctors.patient_sendnotification)).click();
		 		System.out.println("Sucessfully clicked on Send Notification button");
		 		Browser.CheckNotificationMessage("Email/SMS Notification has been sent to the patient");
		 		Thread.sleep(2000);
		 	}
	 		
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
	 	  
	 
	 
	 
}
