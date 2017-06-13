package doctorsTestScripts;

import org.testng.annotations.AfterClass;
import org.testng.annotations.Test;
import org.testng.annotations.BeforeClass;
import java.util.concurrent.TimeUnit;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.DataProvider;
import testBase.DoctorsPage;
import testBase.LoadPropMac;
import testBase.TestUtils;

public class Appointment_ZOY_ValidateAppointmentCancelAlert extends LoadPropMac{
	
	public DoctorsPage DoctorsPage;
	public TestUtils exceldata;
	
	@BeforeClass
	public void beforeClass() throws Exception {
	
		LoadBrowserProperties();
	 driver.manage().window().maximize();
	 driver.get(doctors_Url);		 
	 driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
	 DoctorsPage= new DoctorsPage(driver);			
	 DoctorsPage.SignIn(DoctorsLogin_usernameone, DoctorsLogin_passwordone);
	  } 
	
	@DataProvider(name = "DP1")
	 public String[][] createData1() {
			return new String[][] {
					{ "yes","Sreyzero","S","9955559923","sreyzero@gmail.com","Diabetic" }
	
			};
		}

	@Test(dataProvider="DP1")
	public void CheckAlertforAppointmentCancel(String RunMode,String firstname,String lastname,String mobile,String email,String problem) throws Exception{
		
		DoctorsPage.DoctorsAppointmentforTomorrow(firstname, lastname, mobile, email, problem);
		DoctorsPage.ClickView();
		String id=DoctorsPage.getappointmentid();
		DoctorsPage.Cancel(firstname, lastname, mobile, email, problem);
		DoctorsPage.ClickonAlertmenu();
		System.out.println("value:"+id);
		String alert=driver.findElement(By.xpath("(//span[@id='message'])[1]")).getText();
		System.out.println(alert);
		Assert.assertTrue(alert.contains("You have cancelled Appointment:"));
		Thread.sleep(1000);
		Assert.assertTrue(alert.contains(id));
		
		
		}
	
	@AfterMethod
	public void bulkCancelandlogout() throws Exception{
		DoctorsPage.BulkCancel();
		Thread.sleep(3000);
		DoctorsPage.doctorlogout();
	}
	
	
	@AfterClass
	public void closebrowser(){
		driver.quit();
	}
}
