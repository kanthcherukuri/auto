package diagnosticTestScripts;

import org.testng.annotations.AfterClass;
import org.testng.annotations.Test;
import org.testng.annotations.BeforeClass;
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
		 driver.manage().window().maximize();
		 driver.get(doctors_Url);		 
		 DiagnosticPageZoylo=new DiagnosticPage(driver);
		 Browser=new TestUtils(driver);
		 DiagnosticPageZoylo.SignIn(Diagnostic_username, Diagnostic_password);
		  }
	
	@Test
	public void HomeSampleCollectionSlotdurationlessthan15() throws Exception{
		DiagnosticPageZoylo.ClickonAppointmentMenu();
		Thread.sleep(3000);
		DiagnosticPageZoylo.ClickonToggleButtonForHomeVisit();
		Thread.sleep(2000);
		DiagnosticPageZoylo.BulkCancellationForHomeVisit("07:00","23:00");
		Thread.sleep(2000);
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
