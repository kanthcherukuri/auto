package diagnosticTestScripts;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.Reporter;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import objectRepository.Elements_Diagnostics;
import testBase.DiagnosticPage;
import testBase.LoadPropMac;
import testBase.TestUtils;

public class Appointment_ZOY1036_CancelAppointHomeVisit extends LoadPropMac{
	public DiagnosticPage DiagnosticPageZoylo;
	public TestUtils exceldata;
	
	
	@BeforeClass	 
	 public void beforeClass() throws Exception {	
		
	 LoadBrowserProperties();
	 driver.manage().window().maximize();
	 driver.get(doctors_Url);		 
	 driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
	  }
	
	@Test(priority=1)
	public void DiagnosticLogin() throws Exception{
		
		DiagnosticPageZoylo=new DiagnosticPage(driver);	
		DiagnosticPageZoylo.SignIn(Diagnostic_usernameone, Diagnostic_passwordone);
		
		}
	@Test(priority=2)
	public void HomeVisitAppointmentCancel() throws Exception{
		DiagnosticPageZoylo.DiagnosticAppointmentForHomeVisit();
		Thread.sleep(3000);
		DiagnosticPageZoylo.clickingonappointmentmodification();
		Thread.sleep(5000);
		DiagnosticPageZoylo.CancelAppointmentOfHomeVisit();
		Thread.sleep(2000);
		DiagnosticPageZoylo.ClickingOnEllipse();
		Thread.sleep(2000);
		DiagnosticPageZoylo.diagnosticlogout();
		
	}
	
	
	@AfterClass()
	public void closebrowser(){
		driver.close();
	}
	
	

}
