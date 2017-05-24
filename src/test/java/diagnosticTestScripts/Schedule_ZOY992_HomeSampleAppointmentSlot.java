package diagnosticTestScripts;

import org.testng.annotations.AfterClass;
import org.testng.annotations.Test;
import org.testng.annotations.BeforeClass;
import org.testng.AssertJUnit;
import org.testng.annotations.AfterClass;
import org.testng.annotations.Test;

import objectRepository.Elements_Diagnostics;

import org.testng.annotations.BeforeClass;
import org.testng.AssertJUnit;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import testBase.DiagnosticPage;
import testBase.LoadPropMac;
import testBase.TestUtils;

public class Schedule_ZOY992_HomeSampleAppointmentSlot extends LoadPropMac{
	
	public DiagnosticPage DiagnosticPageZoylo;
	public TestUtils Browser;
	
	@BeforeClass
	  public void launchbrowser() throws Exception {
		LoadBrowserProperties();
		 driver.manage().window().maximize();
		 driver.get(doctors_Url);		 
		 driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		 DiagnosticPageZoylo=new DiagnosticPage(driver);
		 Browser=new TestUtils(driver);
		 DiagnosticPageZoylo.SignIn(Diagnostic_username, Diagnostic_password);
		  }
	
	@Test
	public void HomeSampleAppointmentSlotAppointmentScheduled() throws Exception{
		DiagnosticPageZoylo.DiagnosticAppointmentForHomeVisit("kiran", "K", "9922006666","kiran@gmail.com", "Kakatiya Residency", "Diabetic");
		Thread.sleep(2000);
		DiagnosticPageZoylo.ClickOnScheduleMenu();
		Thread.sleep(3000);
		driver.findElement(By.xpath(Elements_Diagnostics.HomeSampleCollectionMenu)).click();
		Thread.sleep(5000);
		driver.findElement(By.id(Elements_Diagnostics.HomeSampleDistance)).clear();
		driver.findElement(By.id(Elements_Diagnostics.HomeSampleDistance)).sendKeys("8");
		Thread.sleep(2000);
		driver.findElement(By.id(Elements_Diagnostics.HomeSampleSave)).click();
//		WebDriverWait wait = (new WebDriverWait(driver, 2000));
//		wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(By.cssSelector("div.zy-status-wrapper")));
//		String Notification= driver.findElement(By.cssSelector("div.zy-status-wrapper")).getText();
//		AssertJUnit.assertTrue(Notification.contains("You can't update home visit Appointments per slot. You have existing appointment on: "));
		DiagnosticPageZoylo.diagnosticlogout();
	}
	
	@AfterClass
	public void closebrowser(){
		driver.close();
	}

}
