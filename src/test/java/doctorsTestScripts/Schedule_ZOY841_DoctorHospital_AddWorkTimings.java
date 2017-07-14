//@author:Ch.Lakshmi Kanth
package doctorsTestScripts;



import org.testng.annotations.AfterClass;
import org.testng.annotations.Test;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.AfterMethod;
import objectRepository.Elements_Doctors;
import testBase.DoctorsPage;
import testBase.LoadPropMac;
import testBase.TestUtils;
import java.util.concurrent.TimeUnit;


public class Schedule_ZOY841_DoctorHospital_AddWorkTimings extends LoadPropMac{
	
	public DoctorsPage DoctorsPage;
	 
	 public TestUtils Browser;
	 
	 @BeforeClass
		public void LaunchBrowser() throws Exception {
			LoadBrowserProperties();		 
			 driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
			 DoctorsPage= new DoctorsPage(driver);	
			 Browser=new TestUtils(driver);
			 Browser.openUrl(loginPage_Url);
			 driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
			 DoctorsPage.SignIn(DoctorsLogin_usernamefour,  DoctorsLogin_passwordfour);
			  } 
	 
	 @Test
	 public void DoctorHospitalAddWorkTimings() throws Exception{
		 DoctorsPage.BulkCancel();
		 Browser.waitTill(2000);
		 Browser.clickOnTheElementByID("schedule");
		 Browser.waitTill(3000);
		 DoctorsPage.DoctorsHospitalAddWorkTimings("07:00", "23:59");
	 }
	 
	 @AfterMethod
	 public void DeleteAddedWorkTimingsandlogout() throws Exception{
		 Browser.clickOnTheElementByXpath(Elements_Doctors.Schedule_Hospital_DeleteWorkTimings);
		 Browser.waitFortheElementXpath("//span[@class='sp-doc-hosp-schd-save']");
		 Browser.clickOnTheElementByXpath("//span[@class='sp-doc-hosp-schd-save']");
		 Thread.sleep(2000);
		 DoctorsPage.doctorlogout();
		 
	 }
	 
	 @AfterClass
		public void Closebrowser(){
			driver.quit();
		}
	
	

  }



