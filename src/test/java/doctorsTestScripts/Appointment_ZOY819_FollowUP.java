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
	  public void LaunchBrowser() throws Exception { 
		  LoadBrowserProperties();
		  DoctorsPage= new DoctorsPage(driver);		
		  Browser=new TestUtils(driver);
		  Browser.openUrl(loginPage_Url);
		  driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		  DoctorsPage.SignIn(DoctorsLogin_usernameone, DoctorsLogin_passwordone);
			  }
		
	 
	 @DataProvider(name = "FollowUp")
	    public Object[][] createData_DP1() throws Exception{
	        Object[][] retObjArr=TestUtils.getTableArray("TestData/DoctorProvider.xls","Doctor", "ZOY819");
	        return(retObjArr);
	    }
	  
//	  @DataProvider(name = "DP1")
//		 public String[][] createData1() {
//				return new String[][] {
//						{ "yes","Satisha","V","9933662222","satish@gmail.com","Diabetic" }
//
//				};
//			}
	  
	 
	  
	  @Test(dataProvider="FollowUp")
	  public void CheckingFollowupFunctionality(String firstname,String lastname,String mobile,String email,String problem) throws Exception{
		  
		  DoctorsPage.DoctorAppointmentBookingForToday(firstname, lastname, mobile, email, problem);
		  Thread.sleep(2000);
		  DoctorsPage.CheckPateintScreenForCheckInFunctionality(firstname, lastname, email);
		  Thread.sleep(1000);
		  DoctorsPage.VerifyCheckINFunctionality();
		  Thread.sleep(2000);
		  driver.findElement(By.xpath(Elements_Doctors.patient_clickonfollowupbutton)).click();
			Thread.sleep(2000);
			driver.findElement(By.xpath(Elements_Doctors.appointment_tommorrowmenu)).click();
			Thread.sleep(1000);
			driver.findElement(By.xpath(Elements_Doctors.appointment_morning)).click();
			Thread.sleep(1000);
			driver.findElement(By.xpath(Elements_Doctors.appointment_noon)).click();
			Thread.sleep(1000);
			driver.findElement(By.xpath(Elements_Doctors.appointment_eveningtab)).click();
			Thread.sleep(1000);
			driver.findElement(By.xpath(Elements_Doctors.appointment_eveningfirstcell)).click();
			Thread.sleep(1000);
			driver.findElement(By.id(Elements_Doctors.appointment_problem)).sendKeys("Diabetic");
			Thread.sleep(1000);
			driver.findElement(By.id(Elements_Doctors.patient_savefollowupappointment)).click();
			Browser.waitFortheElementXpath(Elements_Doctors.appointment_backgoundcolor);
			String fullname=firstname+" "+lastname;
			Browser.CheckNotificationMessage("Follow-up appointment is confirmed. Patient name: "+fullname);
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
	  
	  
	  
	  
	  
	  
	

			 
	  
	  




