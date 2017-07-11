package doctorsTestScripts;

import org.testng.annotations.AfterClass;
import org.testng.annotations.Test;
import org.testng.annotations.BeforeClass;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import objectRepository.Elements_Doctors;
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
		  driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		  DoctorsPage= new DoctorsPage(driver);	
		  Browser=new TestUtils(driver);
		  Browser.openUrl(loginPage_Url);
		  driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		  DoctorsPage.SignIn( DoctorsLogin_usernameone, DoctorsLogin_passwordone);
		  }
		 
		 @DataProvider(name = "Notification")
		    public Object[][] createData_DP1() throws Exception{
		        Object[][] retObjArr=TestUtils.getTableArray("TestData/DoctorProvider.xls","Doctor", "ZOY808Notification");
		        return(retObjArr);
		    }
  		
 		
	  @Test(dataProvider="Notification")
	  public void SendNoficationForAllTab(String firstname,String lastname,String mobile,String email,String problem) throws Exception{	
		  
		  DoctorsPage.DoctorsAppointmentforTomorrow(firstname, lastname, mobile, email, problem); 
		  Thread.sleep(2000);
		  driver.findElement(By.id(Elements_Doctors.patient_id)).click();
			Thread.sleep(5000);
			driver.findElement(By.xpath(Elements_Doctors.patient_alltab)).click();
			System.out.println("Clicked on all tab");
			Thread.sleep(3000);
			driver.findElement(By.id(Elements_Doctors.patient_searchbox)).sendKeys(email);	 
		 	driver.findElement(By.id(Elements_Doctors.patient_searchbox)).sendKeys(Keys.ENTER);
			String name=driver.findElement(By.xpath(Elements_Doctors.patient_alltabfullname)).getText();
			String schedule=driver.findElement(By.xpath(Elements_Doctors.patient_alltabschedule)).getText();
			String fullname=firstname+" "+lastname;
			if(name.equalsIgnoreCase(fullname)&&schedule.equalsIgnoreCase("Scheduled")){
			driver.findElement(By.xpath(Elements_Doctors.patient_sendnotification)).click();
			System.out.println("Sucessfully clicked on Send Notification button");
			Browser.CheckNotificationMessage("Email/SMS Notification has been sent to the patient");

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
	  
	  
	  

}//Main Class
	  





