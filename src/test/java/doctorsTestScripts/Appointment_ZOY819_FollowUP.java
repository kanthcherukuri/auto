package doctorsTestScripts;

import org.testng.annotations.AfterClass;
import org.testng.annotations.Test;
import org.testng.annotations.BeforeClass;

import org.openqa.selenium.By;


import objectRepository.Elements_Doctors;


import org.testng.annotations.AfterMethod;
import java.util.concurrent.TimeUnit;
import org.testng.annotations.DataProvider;
import testBase.DoctorsPage;
import testBase.LoadPropMac;
import testBase.TestUtils;

public class Appointment_ZOY819_FollowUP extends LoadPropMac {

	public DoctorsPage DoctorsPage;
	 public TestUtils Browser;
	
	
	 @BeforeClass
	  public void beforeClass() throws Exception { 
		  LoadBrowserProperties();
		  driver.get(doctors_Url);		 
		  driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		  DoctorsPage= new DoctorsPage(driver);		
		  Browser=new TestUtils(driver);
		  DoctorsPage.SignIn(DoctorsLogin_usernameone, DoctorsLogin_passwordone);
			  }
		       
	  
	  @DataProvider(name = "DP1")
		 public String[][] createData1() {
				return new String[][] {
						{ "yes","Suryanaryana","V","9933332222","suryanarayana@gmail.com","Diabetic" }

				};
			}
	  
	 
	  
	  @Test(dataProvider="DP1")
	  public void CheckingFollowupFunctionality(String RunMode,String firstname,String lastname,String mobile,String email,String problem) throws Exception{
		  
		  DoctorsPage.DoctorAppointmentBookingForToday(firstname, lastname, mobile, email, problem);
		  Thread.sleep(2000);
		  DoctorsPage.CheckPateintScreenForCheckInFunctionality(firstname, lastname, email);
		  Thread.sleep(1000);
		  DoctorsPage.VerifyCheckINFunctionality();
		  Thread.sleep(2000);
		  driver.findElement(By.xpath(Elements_Doctors.clickonfollowupbutton)).click();
			Thread.sleep(2000);
			driver.findElement(By.xpath(Elements_Doctors.tommorrowmenu)).click();
			Thread.sleep(1000);
			driver.findElement(By.xpath(Elements_Doctors.morning)).click();
			Thread.sleep(1000);
			driver.findElement(By.xpath(Elements_Doctors.noon)).click();
			Thread.sleep(1000);
			driver.findElement(By.xpath(Elements_Doctors.evening)).click();
			Thread.sleep(1000);
			driver.findElement(By.xpath(Elements_Doctors.eveningfirstcell)).click();
			Thread.sleep(1000);
			driver.findElement(By.id(Elements_Doctors.locatorproblem)).sendKeys("Diabetic");
			Thread.sleep(1000);
			driver.findElement(By.id(Elements_Doctors.savefollowupappointment)).click();
			Browser.waitFortheElementXpath(Elements_Doctors.backgoundcolor);
			String fullname=firstname+" "+lastname;
			Browser.CheckNotificationMessage("Follow Up Appointment is confirmed. Patient Name:"+fullname);
			Thread.sleep(2000);
	  		}
	  
		  @AfterMethod
		  public void bulkcancelandlogout() throws Exception{
			  DoctorsPage.BulkCancel();
			  Thread.sleep(2000);
			  DoctorsPage.doctorlogout();
		  }
		  
		@AfterClass
		public void closebrowser(){
			driver.quit();
		}  
		  
	  }
	  
	  
	  
	  
	  
	  
	

			 
	  
	  




