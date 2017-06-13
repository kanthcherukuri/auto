
package doctorsTestScripts;

import org.testng.annotations.AfterClass;
import org.testng.annotations.Test;
import org.testng.annotations.BeforeClass;
import java.util.concurrent.TimeUnit;
import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import testBase.DoctorsPage;
import testBase.LoadPropMac;
import testBase.TestUtils;

public class Appointment_ZOY_ValidateBulkCancelAlert extends LoadPropMac{
	public DoctorsPage DoctorsPageOfZoylo;
	public TestUtils exceldata;
	
	@BeforeClass
	public void beforeClass() throws Exception {
	LoadBrowserProperties();
	
	 driver.manage().window().maximize();
	 driver.get(doctors_Url);		 
	 driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
	 DoctorsPageOfZoylo= new DoctorsPage(driver);			
	 DoctorsPageOfZoylo.SignIn(DoctorsLogin_usernameone, DoctorsLogin_passwordone);
	  } 
	
	
	@Test()
	public void CheckAlertforBulkCancel() throws Exception{
		DoctorsPageOfZoylo.DoctorAppointmentBookingForToday("Koneru", "K", "9900664422", "koneru@gmail.com", "Diabetic");
		Thread.sleep(2000);
		DoctorsPageOfZoylo.BulkCancel();
		DoctorsPageOfZoylo.ClickonAlertmenu();
		String alert=driver.findElement(By.xpath("(//span[@id='message'])[1]")).getText();
		System.out.println(alert);
		Assert.assertTrue(alert.contains("Bulk Cancellation by the Doctor"));
		//Assert.assertTrue(alert.contains("Bulk Cancellation by the Doctor"));	
		
	}
	
	@AfterMethod
	public void bulkCancelandlogout() throws Exception{
		DoctorsPageOfZoylo.doctorlogout();
	}
	
	@AfterClass
	public void closebrowser(){
		driver.close();
	}
}
