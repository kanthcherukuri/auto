package doctorsTestScripts;

import org.testng.annotations.AfterClass;
import org.testng.annotations.Test;
import org.testng.annotations.BeforeClass;




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
		  Browser.openUrl("https://"+Environment_Name+".zoylo.com/login");
		  driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		  DoctorsPage.SignIn(DoctorsLogin_usernameone, DoctorsLogin_passwordone);
			  }
		
	 
	 @DataProvider(name = "FollowUp")
	    public Object[][] createData_DP1() throws Exception{
	        Object[][] retObjArr=TestUtils.getTableArray("TestData/DoctorProvider.xls","Doctor", "ZOY819");
	        return(retObjArr);
	    }
	  
	 
	  
	  @Test(dataProvider="FollowUp")
	  public void CheckingFollowupFunctionality(String firstname,String lastname,String mobile,String email,String problem,
			  String prognosis,String diagnosis,String height,String inches, String weight,
				String drug,String strenght,String notes) throws Exception{
		  
		  DoctorsPage.DoctorAppointmentBookingForToday(firstname, lastname, mobile, email, problem);
		  Thread.sleep(2000);
		  DoctorsPage.CheckPateintScreenForCheckInFunctionality(firstname, lastname, email);
		  Thread.sleep(1000);
		  DoctorsPage.VerifyCheckINFunctionality(prognosis, diagnosis, height, inches, weight, drug, strenght, notes);
		  Thread.sleep(2000);
		  Browser.clickOnTheElementByXpath(Elements_Doctors.patient_clickonfollowupbutton);
		  Browser.waitFortheElementXpath(Elements_Doctors.appointment_tommorrowmenu);
		  Browser.clickOnTheElementByXpath(Elements_Doctors.appointment_tommorrowmenu);
		  Browser.waitFortheElementXpath(Elements_Doctors.appointment_morning);
		  Browser.clickOnTheElementByXpath(Elements_Doctors.appointment_morning);
		  Browser.waitFortheElementXpath(Elements_Doctors.appointment_noon);
		  Browser.clickOnTheElementByXpath(Elements_Doctors.appointment_noon);
		  Browser.waitFortheElementXpath(Elements_Doctors.appointment_eveningtab);
		  Browser.clickOnTheElementByXpath(Elements_Doctors.appointment_eveningtab);
		  Browser.waitFortheElementXpath(Elements_Doctors.appointment_eveningfirstcell);
		  Browser.clickOnTheElementByXpath(Elements_Doctors.appointment_eveningfirstcell);
		  Thread.sleep(1000);
		  Browser.waitFortheID(Elements_Doctors.appointment_problem);
		  Browser.enterTextByID(Elements_Doctors.appointment_problem, "Diabetic");
		  Browser.waitFortheID(Elements_Doctors.patient_savefollowupappointment);
		  Browser.clickOnTheElementByID(Elements_Doctors.patient_savefollowupappointment);
		  Browser.waitFortheElementXpath(Elements_Doctors.appointment_backgoundcolor);
			String fullname=firstname+" "+lastname;
			Browser.CheckNotificationMessage("Follow-up appointment is confirmed. Patient name: "+fullname);
			Thread.sleep(2000);
	  		}
	  
		  @AfterMethod
		  public void bulkcancelandlogout() throws Exception{
			  DoctorsPage.BulkCancel();
			  DoctorsPage.doctorlogout();
		  }
		  
		@AfterClass
		public void closebrowser(){
			driver.quit();
		}  
		  
	  }
	  
	  
	  
	  
	  
	  
	

			 
	  
	  




