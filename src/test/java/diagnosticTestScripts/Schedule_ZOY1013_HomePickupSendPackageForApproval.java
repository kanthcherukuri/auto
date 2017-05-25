package diagnosticTestScripts;

import org.testng.annotations.AfterClass;
import org.testng.annotations.Test;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.AfterClass;
import org.testng.annotations.Test;
import org.testng.annotations.BeforeClass;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import testBase.DiagnosticPage;
import testBase.LoadPropMac;
import testBase.TestUtils;

public class Schedule_ZOY1013_HomePickupSendPackageForApproval extends LoadPropMac {
	
	public DiagnosticPage DiagnosticPageZoylo;
	public TestUtils Browser;
	
	@BeforeClass
	public void beforeClass() throws Exception {
	LoadBrowserProperties();
	 driver.manage().window().maximize();
	 driver.get(doctors_Url);		 
	 driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
	 DiagnosticPageZoylo=new DiagnosticPage(driver);
	 Browser=new TestUtils(driver);
	 DiagnosticPageZoylo.SignIn(Diagnostic_usernameone, Diagnostic_passwordone);
	  }
	
	@Test
	public void ScheduleHomeVistPackageForApproval() throws Exception{
		DiagnosticPageZoylo.ClickOnScheduleMenu();
		DiagnosticPageZoylo.clickonhomevisitmenu();
		DiagnosticPageZoylo.ClickOnSchedulePackageHomePickUp();
		DiagnosticPageZoylo.ScheduleHomePickUpAddPackage("konarkpackage", "Full body Examination", "20000", "2","konarttest", "Full body Examination");
		Thread.sleep(5000);
		DiagnosticPageZoylo.ScheduleHomePickUpPackageSendforApproval();
		Thread.sleep(2000);
		DiagnosticPageZoylo.diagnosticlogout();
		
	}
	
	@AfterClass
	  public void afterClass() {
		driver.close();
	  }
	

}