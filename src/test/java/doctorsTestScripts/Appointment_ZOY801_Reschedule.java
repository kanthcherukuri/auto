package doctorsTestScripts;

import org.testng.annotations.AfterClass;
import org.testng.annotations.Test;
import org.testng.annotations.BeforeClass;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.Test;
import org.testng.annotations.BeforeClass;
import org.testng.AssertJUnit;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.Test;

import objectRepository.Elements_Doctors;

import org.testng.annotations.BeforeClass;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
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
	 
	 
	 @DataProvider(name = "DP1")
//	    public Object[][] createData_DP1() throws Exception{
//	  Object[][] retObjArr=TestUtils.getTableArray("TestData/Data.xls","Kanth","ZOY801");
//	        return(retObjArr);
//	    }
	 
	 public String[][] createData1() {
			return new String[][] {
					{ "yes","Yamahasz","Y","9191219191","yamahasz@gmail.com","Diabetic" }

			};
		}

	 
	
	 @Test(dataProvider="DP1",groups = { "Regression","High" })
	public void AppointmentReschedule(String RunMode,String firstname,String lastname,String mobile,String email,String problem) throws Exception{
		 
		 
			 DoctorsPage.DoctorsAppointmentforTomorrow(firstname, lastname, mobile, email, problem);
			 Thread.sleep(1000);
			 DoctorsPage.reschedule(firstname, lastname, mobile, email, problem); 
			 Thread.sleep(2000);
			 driver.findElement(By.id(Elements_Doctors.patient_id)).click();
				WebDriverWait wait = new WebDriverWait(driver, 8000);
				wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(By.id("searchPatientsList")));
				driver.findElement(By.id(Elements_Doctors.patient_searchbox)).sendKeys(email);
				driver.findElement(By.id(Elements_Doctors.patient_searchbox)).sendKeys(Keys.ENTER);
				Thread.sleep(3000);
				driver.findElement(By.name(Elements_Doctors.patientallmenuname)).click();	
				Thread.sleep(3000);
				String name=driver.findElement(By.xpath(Elements_Doctors.patient_alltabfullname)).getText();
				String schedule=driver.findElement(By.xpath(Elements_Doctors.patient_alltabschedule)).getText();
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
		
		
		
		

