package doctorsTestScripts;

import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.Test;

import objectRepository.Elements_Doctors;

import org.testng.annotations.BeforeClass;
import org.testng.annotations.AfterMethod;
import java.util.concurrent.TimeUnit;
import org.testng.annotations.DataProvider;
import testBase.DoctorsPage;
import testBase.LoadPropMac;
import testBase.TestUtils;

public class Appointment_ZOY814_ScheduleCheckIn extends LoadPropMac  {
	
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
	 
  @DataProvider(name = "CheckIn")
  public Object[][] createData_DP1() throws Exception{
      Object[][] retObjArr=TestUtils.getTableArray("TestData/DoctorProvider.xls","Doctor", "ZOY814");
      return(retObjArr);
  }
  
  
  @Test(dataProvider="CheckIn")
  public void CheckingCheckInFunctionality(String firstname,String lastname,String mobile,String email,String problem,
		  String prognosis,String diagnosis,String height,String inches, String weight,
			String drug,String strenght,String notes) throws Exception{
	  					
		DoctorsPage.DoctorAppointmentBookingForToday(firstname, lastname, mobile, email, problem);
		Thread.sleep(2000);
		DoctorsPage.CheckPateintScreenForCheckInFunctionality(firstname, lastname, email);
		DoctorsPage.VerifyCheckINFunctionality(prognosis, diagnosis, height, inches, weight, drug, strenght, notes);
		Browser.clickOnTheElementByXpath(Elements_Doctors.patient_clickonrecieptdownload);		
		System.out.println("click on the download Receipt icon");	
		Browser.waitFortheElementXpath(Elements_Doctors.patient_selectreciepttodownload);
		Browser.clickOnTheElementByXpath(Elements_Doctors.patient_selectreciepttodownload);
		Thread.sleep(1000);
		String verifyfile=Browser.readPDF("/Users/lakshmikanth/Downloads/file.pdf");
		Assert.assertTrue(verifyfile.contains("Dr.Kanth Doctor"));
		Browser.waitFortheElementXpath(Elements_Doctors.patient_clickonprescription);
		Browser.clickOnTheElementByXpath(Elements_Doctors.patient_clickonprescription);
		Thread.sleep(2000);
		Browser.clickOnTheElementByXpath(Elements_Doctors.patient_selectprescription);	
		Browser.waitFortheID("Email-share");
		Browser.clickOnTheElementByID("Email-share");
		Browser.CheckNotificationMessage("Your email has been sent successfully");
	 }
  
	  @AfterMethod
	  public void bulkcancelandlogout() throws Exception{
		  DoctorsPage.BulkCancel();
	  }
	  
	  @AfterClass
	  public void closebrowser(){
		  driver.quit();
	  }
	
	  
  
  
  
  
  

}
	 

