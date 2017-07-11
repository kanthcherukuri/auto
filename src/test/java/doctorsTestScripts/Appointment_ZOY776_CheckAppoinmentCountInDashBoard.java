package doctorsTestScripts;

import org.testng.annotations.AfterClass;
import org.testng.annotations.Test;
import org.testng.annotations.BeforeClass;
import org.testng.Assert;
import org.openqa.selenium.By;
import objectRepository.Elements_Doctors;
import java.util.concurrent.TimeUnit;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.DataProvider;
import testBase.DoctorsPage;
import testBase.LoadPropMac;
import testBase.TestUtils;

public class Appointment_ZOY776_CheckAppoinmentCountInDashBoard extends LoadPropMac{
	
	public DoctorsPage DoctorsPage;
	public TestUtils Browser;
	
		@BeforeClass
		public void LaunchBrowser() throws Exception {
			
			LoadBrowserProperties();	 
			 DoctorsPage= new DoctorsPage(driver);	
			 Browser= new TestUtils(driver);
			 Browser.openUrl(loginPage_Url);
			 driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
			 DoctorsPage.SignIn( DoctorsLogin_usernameone, DoctorsLogin_passwordone);
			  } 
		
		
		@DataProvider(name = "CountInDashBoard")
	    public Object[][] createData_DP1() throws Exception{
	        Object[][] retObjArr=TestUtils.getTableArray("TestData/DoctorProvider.xls","Doctor", "ZOY776");
	        return(retObjArr);
	    }
		

		
		@Test(dataProvider="CountInDashBoard")
		public void AppointmentCountInDashBoard(String firstname,String lastname,String mobile,String email,String problem) throws Exception{
			DoctorsPage.DoctorAppointmentBookingForToday(firstname, lastname, mobile, email, problem);
			Thread.sleep(3000);
			driver.findElement(By.id(Elements_Doctors.dashboard_clickondashboardmenu)).click();
			Thread.sleep(3000);
			int appointmentsavailable=driver.findElements(By.xpath(Elements_Doctors.dashboard_checktodayappointmentssize)).size();
			System.out.println("Appointments avialable : "+appointmentsavailable);
			String count=driver.findElement(By.xpath(Elements_Doctors.dashboard_checktodayappointmentcountfromgraph)).getText();
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
