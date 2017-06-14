package doctorsTestScripts;

import org.testng.annotations.AfterClass;
import org.testng.annotations.Test;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.AfterClass;
import org.testng.annotations.Test;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.AfterClass;
import org.testng.annotations.Test;
import org.testng.annotations.BeforeClass;
import java.util.concurrent.TimeUnit;
import testBase.DoctorsPage;
import testBase.LoadPropMac;
import testBase.TestUtils;

public class Appointment_ZOY769_doctorprofile extends LoadPropMac{
	
	public DoctorsPage DoctorsPage;
	public TestUtils Browser;
	
		@BeforeClass
		public void beforeClass() throws Exception {
		LoadBrowserProperties();
		 driver.manage().window().maximize();
		 driver.get(doctors_Url);		 
		 driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		 DoctorsPage= new DoctorsPage(driver);
		 Browser= new TestUtils(driver);  
		 DoctorsPage.SignIn(DoctorsLogin_usernameone, DoctorsLogin_passwordone);
		  }  

	@Test
	public void doctorprofileverification() throws Exception{
	DoctorsPage.ClickingOnEllipse();
	Thread.sleep(2000);
	DoctorsPage.doctorprofileEditing();
	DoctorsPage.doctorlogout();
	

	
	//String DoctorEmail= Browser.emailResponse("kanthzoylo@gmail.com", "zoylo@123", "Zoylo.com | Your profile is successfully updated.");	
	//Assert.assertTrue(DoctorEmail.contains("Your profile on Zoylo.com is successfully updated."));
	
	}
	
	
	@AfterClass
	public void closebrowser(){
		driver.quit();
	}
	}
