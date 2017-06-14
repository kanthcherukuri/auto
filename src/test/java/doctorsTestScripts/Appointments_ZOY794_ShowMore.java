package doctorsTestScripts;

import org.openqa.selenium.By;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.JavascriptExecutor;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.Test;

import objectRepository.Elements_Doctors;

import org.testng.annotations.BeforeClass;
import org.testng.annotations.AfterMethod;
import java.util.concurrent.TimeUnit;
import testBase.DoctorsPage;
import testBase.LoadPropMac;
import testBase.TestUtils;

public class Appointments_ZOY794_ShowMore extends LoadPropMac {
	
		public DoctorsPage DoctorsPage;
		public TestUtils Browser;



		@BeforeClass
		public void beforeClass() throws Exception {
		  		LoadBrowserProperties();
		  		driver.manage().window().maximize();
				 driver.get(doctors_Url);		 
				 driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
				 DoctorsPage= new DoctorsPage(driver);	
				 Browser=new TestUtils(driver);
				 DoctorsPage.SignIn(DoctorsLogin_usernameone, DoctorsLogin_passwordone);
				 
				  }	  

		@Test
		public void CheckingDashBoradShowMore() throws Exception{
			
			DoctorsPage.DoctorAppointmentForShowMore();
			Thread.sleep(3000);
			DoctorsPage.ClickingOnDashboard();
			Thread.sleep(5000);
			System.out.println(driver.manage().window().getSize());
			Dimension d= new Dimension(1920, 1080);
			driver.manage().window().setSize(d);		
			Thread.sleep(5000);		        	
			if(driver.findElements(By.id(Elements_Doctors.showmorebutton)).isEmpty()){
			Assert.fail("Show More Button is not avaiable");		
			}	
			else{
			driver.findElement(By.id(Elements_Doctors.showmorebutton)).click();
			System.out.println("show More Button is present");
			System.out.println("show More Button is Clicked");
			Thread.sleep(2000);	  		
			((JavascriptExecutor)driver).executeScript("scroll(0,400)");
			Thread.sleep(2000);
			System.out.println("Scroll Button is Available");
			driver.findElement(By.id(Elements_Doctors.showlessbutton)).click();
			System.out.println("Show Less Button is Present");	  	
			System.out.println("Show Less Button is Clicked");	  				
			}
			//DoctorsPage.CheckShowMore();
			Thread.sleep(2000);
			
		}
		
		@AfterMethod
		public void AppointmentBulkCancelandLogout() throws Exception{
			DoctorsPage.BulkCancel();
			Thread.sleep(3000);
			DoctorsPage.doctorlogout();
		}
 
		@AfterClass
		public void CloseBrowser(){
			driver.quit();
		}
}
