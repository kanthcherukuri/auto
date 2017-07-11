package doctorsTestScripts;

import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.Test;
import org.testng.annotations.BeforeClass;
import org.testng.Assert;

import objectRepository.Elements_Doctors;


import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import org.testng.annotations.DataProvider;
import testBase.DoctorsPage;
import testBase.LoadPropMac;
import testBase.TestUtils;

public class Appointment_ZOY801_Reschedule extends LoadPropMac{
	
	public DoctorsPage DoctorsPage;
	 
	 public TestUtils Browser;
	

	 @BeforeClass(groups = { "Regression","High" })	
	 public void LaunchBrowser() throws Exception {
		 LoadBrowserProperties();
		 driver.get(doctors_Url);		 
		 driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		 DoctorsPage= new DoctorsPage(driver);
		 Browser= new TestUtils(driver); 
		 DoctorsPage.SignIn(DoctorsLogin_usernameone, DoctorsLogin_passwordone);
		  }
	 
	 
	 @DataProvider(name = "Reschedule")
	    public Object[][] createData_DP1() throws Exception{
	  Object[][] retObjArr=TestUtils.getTableArray("TestData/DoctorProvider.xls","Doctor", "ZOY801");
	        return(retObjArr);
	    }
	 
 	
	 @Test(dataProvider="Reschedule")
	public void AppointmentReschedule(String firstname,String lastname,String mobile,String email,String problem) throws Exception{
		 
		 
			 DoctorsPage.DoctorsAppointmentforTomorrow(firstname, lastname, mobile, email, problem);
			 Thread.sleep(5000);
			 DoctorsPage.reschedule(firstname, lastname, mobile, email, problem); 
			 //Browser.CheckNotificationMessage("Your appointment slot has been successfully CHANGED");
			 	Browser.waitFortheID(Elements_Doctors.patient_id);
			 	Browser.clickOnTheElementByID(Elements_Doctors.patient_id);
				WebDriverWait wait = new WebDriverWait(driver, 5000);
				wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(By.id("searchPatientsList")));
				driver.findElement(By.id(Elements_Doctors.patient_searchbox)).sendKeys(email);
				driver.findElement(By.id(Elements_Doctors.patient_searchbox)).sendKeys(Keys.ENTER);
				Browser.clickOnTheElementByXpath(Elements_Doctors.patient_alltab);
				Thread.sleep(1000);
				Browser.waitFortheElementXpath(Elements_Doctors.patient_alltabfullname);
				String name=driver.findElement(By.xpath(Elements_Doctors.patient_alltabfullname)).getText();
				System.out.println("Name : "+name);
				String schedule=driver.findElement(By.xpath(Elements_Doctors.patient_alltabschedule)).getText();
				System.out.println("Schedule is : "+schedule);
				String fullname=firstname+" "+lastname;
				if(name.equalsIgnoreCase(fullname)&&schedule.equalsIgnoreCase("Rescheduled")){
					System.out.println("Appointment Rescheduled Is Sucessfully Verified");
				}else{
					Assert.fail();
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
		
		
		
		

