package doctorsTestScripts;

import org.testng.annotations.AfterClass;
import org.testng.annotations.Test;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import objectRepository.Elements_Doctors;

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
		
		
		@BeforeMethod
		public void CreateAppointmentsForshowmore() throws Exception{
			driver.findElement(By.id(Elements_Doctors.appointments_doctortab)).click();	
			driver.findElement(By.xpath(Elements_Doctors.appointment_todaymenu)).click();
			driver.findElement(By.xpath(Elements_Doctors.appointment_morning)).click();
			driver.findElement(By.xpath(Elements_Doctors.appointment_noon)).click();
			driver.findElement(By.xpath(Elements_Doctors.appointment_eveningtab)).click();
			int slotsize = driver.findElements(By.xpath(Elements_Doctors.appointment_eveningfirstcellsize)).size();
			 if(slotsize>0)
			 {
			for( slotsize=1;slotsize<=6; slotsize++) {	
				
			 WebElement  elementtoclick= driver.findElement(By.xpath("//*[@id='tab-3']/ul/li["+slotsize+"]/div[2]"));
			 ((JavascriptExecutor)driver).executeScript("window.scrollTo(0,"+ elementtoclick.getLocation().x+")");
			 elementtoclick.click();
			Thread.sleep(1000);	 
			driver.findElement(By.xpath(Elements_Doctors.appointment_firstname)).sendKeys("Anji"+Browser.randomalphabets());
			Thread.sleep(1000);
			driver.findElement(By.id(Elements_Doctors.appointment_lsatname)).sendKeys("R");
			Thread.sleep(2000);
			driver.findElement(By.id(Elements_Doctors.appointment_mobile)).sendKeys("9988664422");
			Thread.sleep(1000);
			driver.findElement(By.id(Elements_Doctors.appointment_email)).sendKeys("anji@gmail.com");
			Thread.sleep(1000);
			driver.findElement(By.id(Elements_Doctors.appointment_problem)).sendKeys("diabetic");
			Thread.sleep(1000);	
			driver.findElement(By.id(Elements_Doctors.appointment_save)).click();	
			Browser.waitFortheElementXpath("//*[@id='tab-3']/ul/li["+slotsize+"][@class='bg-red']");
			Thread.sleep(1000);
			}	 
			 }
		}

		@Test
		public void CheckingDashBoradShowMore() throws Exception{
			
			
			Thread.sleep(3000);
			DoctorsPage.ClickingOnDashboard();
			Thread.sleep(5000);
			System.out.println(driver.manage().window().getSize());
			Dimension d= new Dimension(1920, 1080);
			driver.manage().window().setSize(d);		
			Thread.sleep(5000);		        	
			if(driver.findElements(By.id(Elements_Doctors.dashboard_showmorebutton)).isEmpty()){
			Assert.fail("Show More Button is not avaiable");		
			}	
			else{
			driver.findElement(By.id(Elements_Doctors.dashboard_showmorebutton)).click();
			System.out.println("show More Button is present");
			System.out.println("show More Button is Clicked");
			Thread.sleep(2000);	  		
			((JavascriptExecutor)driver).executeScript("scroll(0,400)");
			Thread.sleep(2000);
			System.out.println("Scroll Button is Available");
			driver.findElement(By.id(Elements_Doctors.dashboard_showlessbutton)).click();
			System.out.println("Show Less Button is Present");	  	
			System.out.println("Show Less Button is Clicked");	  				
			}
			//DoctorsPage.CheckShowMore();
			Thread.sleep(2000);
			
		}
		
		@AfterMethod
		public void AppointmentBulkCancelandLogout() throws Exception{
			DoctorsPage.BulkCancel();
			DoctorsPage.doctorlogout();
		}
 
		@AfterClass
		public void CloseBrowser(){
			driver.quit();
		}
}
