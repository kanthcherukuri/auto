package diagnosticTestScripts;

import org.testng.annotations.Test;
import objectRepository.Elements_Diagnostics;
import testBase.DiagnosticPage;
import testBase.LoadPropMac;
import testBase.TestUtils;
import org.testng.annotations.BeforeClass;
import java.util.concurrent.TimeUnit;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.Reporter;
import org.testng.annotations.AfterClass;

public class Appointment_ZOY975_CheckIn extends LoadPropMac {
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
	public void DiagnosticLogin() throws Exception {
		driver.manage().timeouts().implicitlyWait(20,TimeUnit.SECONDS) ;
		DiagnosticPageZoylo=new DiagnosticPage(driver);	
		DiagnosticPageZoylo.SignIn(Diagnostic_usernameone, Diagnostic_passwordone);
	}
	
	@Test(priority=2)
	public void VerifyCheckInCheckOut() throws Exception{
	
		DiagnosticPageZoylo.DiagnosticAppointmentForToday("soujanya","k","9988660022","soujanya@gmail.com","Diabetic");
		Thread.sleep(6000);
		DiagnosticPageZoylo.VerifyCheckInCheckoutforAllTab("soujanya","k","soujanya@gmail.com");
		Thread.sleep(3000);
	}
	@Test(priority=3)
	public void DiagnosticBulkCancelAndLogout() throws Exception{
		
		DiagnosticPageZoylo.DiagnosticAppointmentsBulkCancellation();
		Thread.sleep(3000);
		DiagnosticPageZoylo.ClickingOnEllipse();
		DiagnosticPageZoylo.diagnosticlogout();
		
	}
	
	  @AfterClass
	  public void afterClass() {
		driver.close();
	  }
	
	}
