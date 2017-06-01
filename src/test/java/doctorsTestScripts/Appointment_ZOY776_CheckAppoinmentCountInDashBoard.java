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
import org.testng.annotations.AfterMethod;
import org.testng.annotations.DataProvider;
import testBase.DoctorsPage;
import testBase.LoadPropMac;
import testBase.TestUtils;

public class Appointment_ZOY776_CheckAppoinmentCountInDashBoard extends LoadPropMac{
	
	public DoctorsPage DoctorsPageOfZoylo;
	public TestUtils exceldata;
	
		@BeforeClass
		public void beforeClass() throws Exception {
			LoadBrowserProperties();
			 driver.get(doctors_Url);		 
			 driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
			 DoctorsPageOfZoylo= new DoctorsPage(driver);			
			 DoctorsPageOfZoylo.SignIn(DoctorsLogin_usernameone, DoctorsLogin_passwordone);
			  } 
		
		@DataProvider(name = "DP1")
		 public String[][] createData1() {
				return new String[][] {
						{ "yes","Hero","Honda","9999995522","Honda@gmail.com","Diabetic" }

				};
			}
		
		@Test(dataProvider="DP1")
		public void AppointmentCountInDashBoard(String RunMode,String firstname,String lastname,String mobile,String email,String problem) throws Exception{
			DoctorsPageOfZoylo.DoctorAppointmentBookingForToday(firstname, lastname, mobile, email, problem);
			Thread.sleep(3000);
			DoctorsPageOfZoylo.ClickingOnEllipse();
			Thread.sleep(2000);
			DoctorsPageOfZoylo.CheckAppointmentsCountinDashboardForToday();
			Thread.sleep(1000);	
			}
		
		@AfterMethod
		public void BulkCancelandLogout() throws Exception{
			DoctorsPageOfZoylo.BulkCancel();
			Thread.sleep(3000);
			DoctorsPageOfZoylo.doctorlogout();
		}
		
		@AfterClass
		public void Closebrowser(){
			driver.close();
		}
}
