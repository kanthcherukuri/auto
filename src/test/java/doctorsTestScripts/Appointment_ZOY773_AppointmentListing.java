package doctorsTestScripts;

import org.testng.annotations.AfterClass;
import org.testng.annotations.Test;
import org.testng.annotations.BeforeClass;
import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import objectRepository.Elements_Doctors;
import java.util.concurrent.TimeUnit;
import org.testng.annotations.DataProvider;
import testBase.DoctorsPage;
import testBase.LoadPropMac;
import testBase.TestUtils;

public class Appointment_ZOY773_AppointmentListing extends LoadPropMac {
	
	
	public DoctorsPage DoctorsPage;
	 public TestUtils Browser;
	 
	@BeforeClass	 
	 public void beforeClass() throws Exception {		
	 LoadBrowserProperties();
	 driver.get(doctors_Url);		 
	 driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
	 DoctorsPage= new DoctorsPage(driver);	
	 Browser= new TestUtils(driver);
	 DoctorsPage.SignIn( DoctorsLogin_usernameone, DoctorsLogin_passwordone);
	  }
	
	 @DataProvider(name = "DP1")
	 public String[][] createData1() {
			return new String[][] {
					{ "yes","Jhansirani","K","9966995511","jhansirani@gmail.com","Diabetic" }
	
			};
		}
 
  
@Test(dataProvider="DP1",priority=1)
public void appListing(String RunMode,String firstname,String lastname,String mobile,String email,String problem) throws Exception{
		 
		 DoctorsPage.DoctorAppointmentBookingForToday(firstname, lastname, mobile, email, problem);
		 DoctorsPage.ClickingOnDashboard();
		 Thread.sleep(3000);
		 int appointmentlisting= driver.findElements(By.xpath(Elements_Doctors.dashboard_getappointmentlistingsize)).size();
			System.out.println(appointmentlisting);
			for(int i=1;i<=appointmentlisting; i++)
			{
			String name=driver.findElement(By.xpath("//*[@id='scrolls']/div/div["+i+"]/div[2]/span")).getText();
			String fullname=firstname+" "+lastname;
			System.out.println(name);
			if(name.equalsIgnoreCase(fullname))
			{
			System.out.println("User Name Matched");
			System.out.println("The appointment created from Doctors login is Listed");
			driver.findElement(By.xpath("//*[@id='scrolls']/div/div["+i+"]/div[2]/span")).click();	
			WebDriverWait wait = new WebDriverWait(driver, 2000);
			wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(By.xpath(Elements_Doctors.dashboard_waitfornextpage)));
			String validation=driver.findElement(By.xpath(Elements_Doctors.dashboard_getnameforpage)).getText();
			System.out.println(validation);
			Assert.assertEquals(validation,fullname);
			break;
			}
			else{
			
				System.out.println("User Name Not Matched");
				}
			}
			
			}
			
	@AfterMethod
	public void bulkCancelandlogout() throws Exception{
		DoctorsPage.BulkCancel();
		DoctorsPage.doctorlogout();
	}
	
	
	@AfterClass
	public void closebrowser(){
		driver.close();
	}

}//main Class
