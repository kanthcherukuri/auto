package doctorsTestScripts;

import java.util.concurrent.TimeUnit;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
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
			((JavascriptExecutor)driver).executeScript("scroll(0,400)");
			driver.findElement(By.id(Elements_Doctors.doctor_profileEdit)).click();
			Browser.waitFortheID("doctorQualification");
			driver.findElement(By.xpath("//li[@title='WCLI (LASER)']/span")).click();
			Thread.sleep(1000);
			driver.findElement(By.xpath("//a[@href='#about']")).click();
			driver.findElement(By.xpath("//li[@title='BOT']/span")).click();
			Thread.sleep(1000);
			driver.findElement(By.xpath("//a[@href='#about']")).click();
			driver.findElement(By.xpath("//li[@title='VLCC']/span")).click();
			Browser.waitFortheID(Elements_Doctors.doctor_qualification);
			WebElement element=driver.findElement(By.id(Elements_Doctors.doctor_qualification)); 
			Select se= new Select(element);
			se.selectByValue("WCLI (LASER)");
			Thread.sleep(1000);
			WebElement elementone=driver.findElement(By.id(Elements_Doctors.doctor_qualification)); 
			Select seone= new Select(elementone);
			seone.selectByValue("BOT");
			Thread.sleep(1000);
			WebElement elementtwo=driver.findElement(By.id(Elements_Doctors.doctor_qualification)); 
			Select seotwo= new Select(elementtwo);
			seotwo.selectByValue("VLCC");
			Browser.waitFortheID(Elements_Doctors.doctor_profileSaveInfo);
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
			if(check.equals("WCLI (LASER)")&&(checkpartone.equals("BOT")&&(checkparttwo.equals("VLCC")))) {
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
