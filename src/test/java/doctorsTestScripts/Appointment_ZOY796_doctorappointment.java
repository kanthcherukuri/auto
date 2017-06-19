package doctorsTestScripts;

import org.testng.annotations.AfterClass;
import org.testng.annotations.Test;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.AfterClass;
import org.testng.annotations.Test;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.AfterClass;
import org.testng.annotations.Test;

import objectRepository.Elements_Doctors;

import org.testng.annotations.BeforeClass;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.*;
import org.testng.annotations.DataProvider;
import testBase.DoctorsPage;
import testBase.LoadPropMac;
import testBase.TestUtils;

public class Appointment_ZOY796_doctorappointment extends LoadPropMac {
	
		public DoctorsPage DoctorsPage;
		public TestUtils Browser;
		
	 @BeforeClass(groups = { "Regression","High" })	
	 public void beforeClass() throws Exception {
		 LoadBrowserProperties();
		 driver.get(doctors_Url);		 
		 driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		 DoctorsPage= new DoctorsPage(driver);	
		 Browser=new TestUtils(driver);
		 DoctorsPage.SignIn(DoctorsLogin_usernameone, DoctorsLogin_passwordone);	
		  }



	@DataProvider(name = "DP1")
	//public Object[][] createData_DP1() throws Exception{
	//Object[][] retObjArr=TestUtils.getTableArray("TestData\\Doctors_TestData.xls", "Doctor", "ZOY796");
	  //  return(retObjArr);
	//}
	public String[][] createData1() {
		return new String[][] {
		{ "yes","09:00","Skoda","Kanth","9491219191","skoda@gmail.com","Diabetic"}

		};
	}
	
	@Test(dataProvider="DP1",groups = { "Regression","High" })
public void doctorappointmentcreation(String RunMode,String timeslot,String firstname,String lastname,String mobile,String email,String problem) throws Exception{

		 driver.findElement(By.id(Elements_Doctors.appointments_doctortab)) .click();	
		 driver.findElement(By.xpath(Elements_Doctors.appointment_tommorrowmenu)).click();
		 driver.findElement(By.xpath(Elements_Doctors.appointment_morning)).click();
		 driver.findElement(By.xpath(Elements_Doctors.appointment_noon)).click();
		 driver.findElement(By.xpath(Elements_Doctors.appointment_eveningtab)).click();
		 driver.findElement(By.xpath("//*[@id='tab-3']/ul/li[1]/div[2]")).click();
		 Thread.sleep(2000);
		 driver.findElement(By.xpath(Elements_Doctors.appointment_firstname)).sendKeys(firstname);
		 Thread.sleep(1000);
		 driver.findElement(By.id(Elements_Doctors.appointment_lsatname)).sendKeys(lastname);
		 Thread.sleep(1000);
		 driver.findElement(By.id(Elements_Doctors.appointment_mobile)).sendKeys(mobile);
		 Thread.sleep(1000);
		 driver.findElement(By.id(Elements_Doctors.appointment_email)).sendKeys(email);
		 Thread.sleep(1000);
		 driver.findElement(By.id(Elements_Doctors.appointment_problem)).sendKeys(problem);
		 Thread.sleep(1000);
		 driver.findElement(By.id(Elements_Doctors.appointment_save)).click();
		 WebDriverWait wait = (new WebDriverWait(driver, 2000));
		 wait.until(ExpectedConditions.elementToBeClickable(By.xpath(Elements_Doctors.appointment_backgoundcolor)));
		 String fullname=firstname+" "+lastname;
		 Browser.CheckNotificationMessage("Appointment is confirmed. Patient Name:"+fullname);	
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
