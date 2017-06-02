package doctorsTestScripts;

import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.Test;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.DataProvider;
import org.testng.AssertJUnit;
import java.util.concurrent.TimeUnit;
import org.openqa.selenium.By;
import testBase.DoctorsPage;
import testBase.LoadPropMac;
import testBase.TestUtils;

public class Appointment_ZOY_ValidateRescheduleAlert extends LoadPropMac{
	
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
	
	@DataProvider(name = "DP1")
	 public String[][] createData1() {
			return new String[][] {
					{ "yes","Southkorea","S","9655559923","southko@gmail.com","Diabetic" }
	
			};
		}

	
	@Test(dataProvider="DP1")
	public void CheckAlertforAppointmentReschedule(String RunMode,String firstname,String lastname,String mobile,String email,String problem) throws Exception{
	
		DoctorsPageOfZoylo.DoctorsAppointmentforTomorrow(firstname, lastname, mobile, email, problem);
		DoctorsPageOfZoylo.ClickView();
		String id=DoctorsPageOfZoylo.getappointmentid();
		DoctorsPageOfZoylo.reschedule(firstname, lastname, mobile, email, problem);
		DoctorsPageOfZoylo.ClickonAlertmenu();
		//driver.findElement(By.id("alerts")).click();
		//Thread.sleep(8000);
		System.out.println("value:"+id);
		String alert=driver.findElement(By.xpath("(//span[@id='message'])[1]")).getText();
		System.out.println(alert);
		AssertJUnit.assertTrue(alert.contains("has been rescheduled"));
		Thread.sleep(1000);
		AssertJUnit.assertTrue(alert.contains(id));
		
	}
	
	@AfterMethod
	public void bulkCancelandlogout() throws Exception{
		DoctorsPageOfZoylo.BulkCancel();
		Thread.sleep(3000);
		DoctorsPageOfZoylo.doctorlogout();
	}
	
	@AfterClass
	public void closebrowser(){
		driver.close();
	}
}
