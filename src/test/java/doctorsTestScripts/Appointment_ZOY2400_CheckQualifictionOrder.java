package doctorsTestScripts;

import java.util.concurrent.TimeUnit;
import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import objectRepository.Elements_Doctors;
import testBase.DoctorsPage;
import testBase.LoadPropMac;
import testBase.TestUtils;

public class Appointment_ZOY2400_CheckQualifictionOrder extends LoadPropMac{
	
	public DoctorsPage DoctorsPage;
	public TestUtils Browser;
	
		@BeforeClass
		public void beforeClass() throws Exception {
		LoadBrowserProperties(); 
		 DoctorsPage= new DoctorsPage(driver);
		 Browser= new TestUtils(driver); 
		 Browser.openUrl(loginPage_Url);
		 driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		 DoctorsPage.SignIn(DoctorsLogin_usernamefour, DoctorsLogin_passwordfour);
		  }  
		
		@Test
		public void checkqualificationorder() throws Exception {
			
			DoctorsPage.ClickingOnEllipse();
			Thread.sleep(1000);
			Browser.clickOnTheElementByID(Elements_Doctors.doctor_profilemenu);
			Browser.waitTill(3000);
			Browser.scrollbyID(Elements_Doctors.doctor_profileEdit);
			Thread.sleep(1000);
			Browser.clickOnTheElementByID(Elements_Doctors.doctor_profileEdit);
			Browser.waitFortheID("doctorQualification");
			driver.findElement(By.xpath(Elements_Doctors.doctor_ProfileRemoveQualificationFCLI)).click();
			Thread.sleep(1000);
			driver.findElement(By.xpath(Elements_Doctors.Profile_AboutMenu)).click();
			driver.findElement(By.xpath(Elements_Doctors.doctor_ProfileRemoveQualificationBOT)).click();
			Thread.sleep(1000);
			driver.findElement(By.xpath(Elements_Doctors.Profile_AboutMenu)).click();
			driver.findElement(By.xpath(Elements_Doctors.doctor_ProfileRemoveQualificationVLCC)).click();
			Thread.sleep(1000);
			driver.findElement(By.xpath(Elements_Doctors.Profile_AboutMenu)).click();
			Browser.waitFortheElementXpath(Elements_Doctors.Profile_Qualification);
			Browser.actionbyXpath(Elements_Doctors.Profile_Qualification, "FCLI");
			Thread.sleep(2000);
			Browser.actionbyXpath(Elements_Doctors.Profile_Qualification, "BOT");
			Thread.sleep(1000);
			Browser.actionbyXpath(Elements_Doctors.Profile_Qualification, "VLCC");
			Browser.clickOnTheElementByID(Elements_Doctors.doctor_profileSaveInfo);
			Thread.sleep(5000);
			String ele= driver.findElement(By.id("doctorQualification_def")).getText();
			System.out.println("Qualification is:"+ele);
			String[] order=ele.split(",");
			String check=order[0];
			System.out.println("Split one value:"+check);
			String checkpartone=order[1];
			System.out.println("Split two value:"+checkpartone);
			String checkparttwo=order[2];
			System.out.println("Split three value:"+checkparttwo);
			if(check.equals("FCLI")&&(checkpartone.equals("BOT")&&(checkparttwo.equals("VLCC")))) {
				System.out.println("Qualification Values are in Inserted Order");
			}else {
				Assert.fail("Qualification Values are Not in Inserted Order");
			}
			
		} 
		
		
   
    
    @AfterClass
    public void CloseBrowser() {
    	driver.quit();
    }
		
}
