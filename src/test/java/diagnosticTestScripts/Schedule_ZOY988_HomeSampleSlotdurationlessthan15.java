package diagnosticTestScripts;

import org.testng.annotations.AfterClass;
import org.testng.annotations.Test;
import org.testng.annotations.BeforeClass;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import testBase.DiagnosticPage;
import testBase.LoadPropMac;
import testBase.TestUtils;

public class Schedule_ZOY988_HomeSampleSlotdurationlessthan15  extends LoadPropMac{
	
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
	public void HomeSampleCollectionSlotdurationlessthan15() throws Exception{
		DiagnosticPageZoylo.ClickonAppointmentMenu();
		DiagnosticPageZoylo.ClickonToggleButtonForHomeVisit();
		DiagnosticPageZoylo.BulkCancellationForHomeVisit("07:00","23:00");
		DiagnosticPageZoylo.ClickOnScheduleMenu();
		Thread.sleep(3000);
		driver.findElement(By.xpath("//*[@id='cd-11']/div")).click();
		Thread.sleep(2000);
		driver.findElement(By.id("homeVisitSlotDuration")).clear();
		driver.findElement(By.id("homeVisitSlotDuration")).sendKeys("10");
		Thread.sleep(2000);
		driver.findElement(By.id("diagnosticHomeVisitTimeSlots")).click();
		Browser.CheckNotificationMessage("Select Slot Duration in between 15 to 600");
		Thread.sleep(3000);
	}

	@AfterClass
	public void closebrowser(){
		driver.quit();
	}
}
