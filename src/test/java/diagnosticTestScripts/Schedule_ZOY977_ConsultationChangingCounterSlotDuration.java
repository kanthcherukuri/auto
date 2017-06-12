package diagnosticTestScripts;

import org.testng.annotations.AfterClass;
import org.testng.annotations.Test;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.AfterClass;
import org.testng.annotations.Test;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.AfterClass;
import org.testng.annotations.Test;
import org.testng.annotations.BeforeClass;
import java.util.concurrent.TimeUnit;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import testBase.DiagnosticPage;
import testBase.LoadPropMac;
import testBase.TestUtils;

public class Schedule_ZOY977_ConsultationChangingCounterSlotDuration  extends LoadPropMac{
	
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
	public void ChangeCounterSlotDuration() throws Exception{
		
		DiagnosticPageZoylo.ClickonAppointmentMenu();
		Thread.sleep(3000);
		DiagnosticPageZoylo.ClickonToggleButtonForHomeVisit();
		Thread.sleep(1000);
		DiagnosticPageZoylo.BulkCancellationForHomeVisit("07:00", "23:00");
		Thread.sleep(1000);
		DiagnosticPageZoylo.ClickonAppointmentMenu();
		Thread.sleep(1000);
		DiagnosticPageZoylo.ClickonToggleButtonForHomeVisit();
		Thread.sleep(1000);
		DiagnosticPageZoylo.BulkCancellationForHomeVisit("07:00", "23:00");
		Thread.sleep(1000);
		driver.findElement(By.id("schedule")).click();
		Thread.sleep(3000);
		 driver.findElement(By.id("clinicSlotDuration")).clear();
		 driver.findElement(By.id("clinicSlotDuration")).sendKeys("20");
		 driver.findElement(By.id("clinicSlotDuration")).sendKeys(Keys.ENTER);
		 Thread.sleep(3000);
		 driver.findElement(By.id("diagnosticClinicTimeSlots")).click();
		 //Browser.CheckNotificationMessage("Diagnostics updated sucessfully");
	}

	@AfterClass
	public void closebrowser(){
		driver.quit();
	}
}
