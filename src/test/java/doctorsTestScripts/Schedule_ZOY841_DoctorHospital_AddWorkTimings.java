package doctorsTestScripts;

/*
 * @author-Manraj Bharaj

 * 
 * Description- Test case for "Adding time slots" under HOSPITAL tab for DOCTORS module. 
 * Follow ZOY841 JIRA for understanding the manual test case
 */

import org.testng.annotations.Test;
import org.testng.Assert;
import org.testng.annotations.Test;
import org.testng.AssertJUnit;
import org.testng.annotations.Test;
import org.testng.Assert;
import org.testng.annotations.Test;
import org.testng.AssertJUnit;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import objectRepository.Elements_Doctors;
import testBase.DoctorsPage;
import testBase.LoadProp;
import testBase.LoadPropMac;
import testBase.TestUtils;

import org.testng.annotations.BeforeTest;
import org.testng.annotations.DataProvider;

import java.awt.AWTException;
import java.awt.Robot;
import java.awt.event.KeyEvent;
import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.concurrent.TimeUnit;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeClass;

public class Schedule_ZOY841_DoctorHospital_AddWorkTimings extends LoadPropMac{
	
	public DoctorsPage DoctorsPageOfZoylo;
	 
	 public TestUtils Browser;
	 
	 @BeforeClass
		public void LaunchBrowser() throws Exception {
			LoadBrowserProperties();
			 driver.get(doctors_Url);		 
			 driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
			 DoctorsPageOfZoylo= new DoctorsPage(driver);	
			 Browser=new TestUtils(driver);
			 DoctorsPageOfZoylo.SignIn(DoctorsLogin_usernamefour,  DoctorsLogin_passwordfour);
			  } 
	 
	 @Test
	 public void DoctorHospitalAddWorkTimings() throws Exception{
		 DoctorsPageOfZoylo.BulkCancel();
		 Thread.sleep(2000);
		 driver.findElement(By.id("schedule")).click();
		 Thread.sleep(3000);
		 DoctorsPageOfZoylo.DoctorsHospitalAddWorkTimings("07:00", "23:59");
	 }
	 
	 @AfterMethod
	 public void DeleteAddedWorkTimingsandlogout() throws Exception{
		 driver.findElement(By.xpath(Elements_Doctors.HospitalDeleteWorkTimings)).click();
		 Thread.sleep(1000);
		 driver.findElement(By.xpath("//span[@class='sp-doc-hosp-schd-save']")).click();
		 Thread.sleep(2000);
		 DoctorsPageOfZoylo.doctorlogout();
		 
	 }
	 
	 @AfterClass
		public void Closebrowser(){
			driver.close();
		}
	
	

  }



