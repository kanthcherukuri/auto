package diagnosticTestScripts;

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
		 DiagnosticPageZoylo=new DiagnosticPage(driver);
		 Browser=new TestUtils(driver);
		 Browser.openUrl("https://"+Environment_Name+".zoylo.com/login");
		 driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		 DiagnosticPageZoylo.SignIn(Diagnostic_username, Diagnostic_password);
		  }
	
	@Test
	public void ChangeCounterSlotDuration() throws Exception{
		
		DiagnosticPageZoylo.ClickonAppointmentMenu();
		DiagnosticPageZoylo.ClickonToggleButtonForHomeVisit();
		DiagnosticPageZoylo.BulkCancellationForHomeVisit("07:00", "23:00");
		DiagnosticPageZoylo.ClickonAppointmentMenu();
		DiagnosticPageZoylo.ClickonToggleButtonForHomeVisit();
		DiagnosticPageZoylo.BulkCancellationForHomeVisit("07:00", "23:00");
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
