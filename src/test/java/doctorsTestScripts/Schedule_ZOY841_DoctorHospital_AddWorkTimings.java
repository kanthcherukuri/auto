package doctorsTestScripts;



import org.testng.annotations.AfterClass;
import org.testng.annotations.Test;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.AfterClass;
import org.testng.annotations.Test;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.Test;
import org.testng.annotations.BeforeClass;
import objectRepository.Elements_Doctors;
import testBase.DoctorsPage;
import testBase.LoadPropMac;
import testBase.TestUtils;
import java.util.concurrent.TimeUnit;
import org.openqa.selenium.By;


public class Schedule_ZOY841_DoctorHospital_AddWorkTimings extends LoadPropMac{
	
	public DoctorsPage DoctorsPage;
	 
	 public TestUtils Browser;
	 
	 @BeforeClass
		public void LaunchBrowser() throws Exception {
			LoadBrowserProperties();
			 driver.get(doctors_Url);		 
			 driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
			 DoctorsPage= new DoctorsPage(driver);	
			 Browser=new TestUtils(driver);
			 DoctorsPage.SignIn(DoctorsLogin_usernamefour,  DoctorsLogin_passwordfour);
			  } 
	 
	 @Test
	 public void DoctorHospitalAddWorkTimings() throws Exception{
		 DoctorsPage.BulkCancel();
		 Thread.sleep(2000);
		 driver.findElement(By.id("schedule")).click();
		 Thread.sleep(3000);
		 DoctorsPage.DoctorsHospitalAddWorkTimings("07:00", "23:59");
	 }
	 
	 @AfterMethod
	 public void DeleteAddedWorkTimingsandlogout() throws Exception{
		 driver.findElement(By.xpath(Elements_Doctors.HospitalDeleteWorkTimings)).click();
		 Thread.sleep(1000);
		 driver.findElement(By.xpath("//span[@class='sp-doc-hosp-schd-save']")).click();
		 Thread.sleep(2000);
		 DoctorsPage.doctorlogout();
		 
	 }
	 
	 @AfterClass
		public void Closebrowser(){
			driver.close();
		}
	
	

  }



