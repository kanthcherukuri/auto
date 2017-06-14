package doctorsTestScripts;

import org.openqa.selenium.By;
import org.testng.Assert;
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

public class Appointment_ZOY776_CheckAppoinmentCountInDashBoard extends LoadPropMac{
	
	public DoctorsPage DoctorsPage;
	public TestUtils exceldata;
	
		@BeforeClass
		public void beforeClass() throws Exception {
			LoadBrowserProperties();
			 driver.get(doctors_Url);		 
			 driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
			 DoctorsPage= new DoctorsPage(driver);			
			 DoctorsPage.SignIn(DoctorsLogin_usernameone, DoctorsLogin_passwordone);
			  } 
		
		@DataProvider(name = "DP1")
		 public String[][] createData1() {
				return new String[][] {
						{ "yes","Haritha","H","9999999922","Haritha@gmail.com","Diabetic" }

				};
			}
		
		@Test(dataProvider="DP1")
		public void AppointmentCountInDashBoard(String RunMode,String firstname,String lastname,String mobile,String email,String problem) throws Exception{
			DoctorsPage.DoctorAppointmentBookingForToday(firstname, lastname, mobile, email, problem);
			Thread.sleep(3000);
			driver.findElement(By.id(Elements_Doctors.clickondashboardmenu)).click();
			Thread.sleep(3000);
			int appointmentsavailable=driver.findElements(By.xpath(Elements_Doctors.checktodayappointmentssize)).size();
			System.out.println("Appointments avialable : "+appointmentsavailable);
			String count=driver.findElement(By.xpath(Elements_Doctors.checktodayappointmentcountfromgraph)).getText();
			if(count.equalsIgnoreCase(Integer.toString(appointmentsavailable))){
				System.out.println("Appointment Count for Today is"+appointmentsavailable+"Sucessfully Verified");
			}else{
				
				Assert.fail("Appointment Count Verification for Today is UnSucess");
			}
		}
			
			
			
			
		
		@AfterMethod
		public void BulkCancelandLogout() throws Exception{
			DoctorsPage.BulkCancel();
			DoctorsPage.doctorlogout();
		}
		
		@AfterClass
		public void Closebrowser(){
			driver.quit();
		}
}
