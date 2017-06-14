package doctorsTestScripts;

import org.testng.annotations.AfterClass;
import org.testng.annotations.Test;

import objectRepository.Elements_Doctors;

import org.testng.annotations.BeforeClass;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.*;
import org.testng.annotations.DataProvider;
import testBase.DoctorsPage;
import testBase.LoadPropMac;
import testBase.TestUtils;

public class Appointment_ZOY806_Cancel extends LoadPropMac  {

	public DoctorsPage DoctorsPage;
	 public TestUtils exceldata;
	

	 @BeforeClass(groups = { "Regression","High" })	
	 public void LaunchBrowser() throws Exception {
		 LoadBrowserProperties();
		 driver.get(doctors_Url);		 
		 driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		 DoctorsPage= new DoctorsPage(driver);			
		 DoctorsPage.SignIn(DoctorsLogin_usernameone, DoctorsLogin_passwordone);	
		  }
	 
	 @DataProvider(name = "DP1")
	   // public Object[][] createData_DP1() throws Exception{
	  //Object[][] retObjArr=TestUtils.getTableArray("TestData\\DoctorAppointment1.xls", "doc", "TC1");
	    //    return(retObjArr);
	    //}
	 
	 public String[][] createData1() {
			return new String[][] {
					{ "yes","konylabs","K","9999929191","konylabs@gmail.com","Diabetic" }

			};
		}



@Test(dataProvider="DP1",groups = { "Regression","High" })

public void doctorappointment(String RunMode,String firstname,String lastname,String mobile,String email,String problem) throws Exception{
		
		DoctorsPage.DoctorsAppointmentforTomorrow(firstname, lastname, mobile, email, problem);
		Thread.sleep(2000);
		DoctorsPage.Cancel(firstname, lastname, mobile, email, problem);
		Thread.sleep(2000);
		driver.findElement(By.id(Elements_Doctors.patienticonid)).click();
		Thread.sleep(5000);
		WebDriverWait wait = new WebDriverWait(driver, 100);
		wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(By.id(Elements_Doctors.patientsearchbox)));
		driver.findElement(By.id(Elements_Doctors.patientsearchbox)).sendKeys(email);
		driver.findElement(By.id(Elements_Doctors.patientsearchbox)).sendKeys(Keys.ENTER);
		driver.findElement(By.name(Elements_Doctors.patientallmenuname)).click();
		Thread.sleep(5000);
		String name=driver.findElement(By.xpath(Elements_Doctors.alltabname)).getText();
		String status=driver.findElement(By.xpath(Elements_Doctors.alltabschedule)).getText();
		String fullname=firstname+" "+lastname;
		if(name.equalsIgnoreCase(fullname)&&status.equalsIgnoreCase("Cancelled By Provider")){
			System.out.println("Appointment is Sucessfully Cancelled");
		}	
		else{
			System.out.println("Appointment is  Not Sucessfully Cancelled");
			Assert.fail("Appointment is  Not Sucessfully Cancelled");
		}
	
		}


		@AfterMethod
		public void CancelAllAppointments() throws Exception{
			DoctorsPage.BulkCancel();
			DoctorsPage.doctorlogout();	
		}


		@AfterClass
		public void closebrowser(){
			driver.quit();
		}



}
