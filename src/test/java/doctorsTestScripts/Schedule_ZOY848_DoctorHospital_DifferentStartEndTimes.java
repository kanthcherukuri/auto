//@author:Ch.Lakshmi Kanth
package doctorsTestScripts;


import org.testng.annotations.AfterClass;
import org.testng.annotations.Test;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.AfterMethod;
import objectRepository.Elements_Doctors;
import java.util.concurrent.TimeUnit;
import testBase.DoctorsPage;
import testBase.LoadPropMac;
import testBase.TestUtils;

public class Schedule_ZOY848_DoctorHospital_DifferentStartEndTimes extends LoadPropMac{
	
	public DoctorsPage DoctorsPage;
	 public TestUtils Browser;

	 @BeforeClass
		public void LaunchBrowser() throws Exception {
			LoadBrowserProperties();
			 DoctorsPage= new DoctorsPage(driver);	
			 Browser=new TestUtils(driver);
			 Browser.openUrl(loginPage_Url);
			 driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
			 DoctorsPage.SignIn(DoctorsLogin_usernamefour,  DoctorsLogin_passwordfour);
			  } 
	 
	 @Test
	 public void DoctorHospitalsSameStartEndTimes() throws Exception{
		 DoctorsPage.BulkCancel();
		 Thread.sleep(2000);
		 Browser.clickOnTheElementByID("schedule");
		 Thread.sleep(3000);
		 Browser.waitTill(3000);
		 DoctorsPage.DoctorsHospitalAddWorkTimings("10:00", "10:00");
		 Browser.CheckNotificationMessage("Hospital Time Slot overlaps with Other Working Time Slot");
		 Thread.sleep(3000);
	 }
	 
	 @AfterMethod
	 public void DeleteAddedWorkTimingsandlogout() throws Exception{
		 Browser.clickOnTheElementByXpath(Elements_Doctors.Schedule_Hospital_DeleteWorkTimings);
		 Browser.waitFortheElementXpath(Elements_Doctors.Schedule_Hospital_SaveWorkTimings);
		 Browser.clickOnTheElementByXpath(Elements_Doctors.Schedule_Hospital_SaveWorkTimings);
		 Thread.sleep(2000);
		 DoctorsPage.doctorlogout();
		 
	 }
	 
	 @AfterClass
		public void Closebrowser(){
			driver.close();
		}

	
}


