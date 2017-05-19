package diagnosticTestScripts;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import testBase.DiagnosticPage;
import testBase.LoadPropMac;
import testBase.TestUtils;

public class Schedule_ZOY985_MakeToggleInactiveWhenAppointmentNotScheduled extends LoadPropMac {
	
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
		 DiagnosticPageZoylo.SignIn(Diagnostic_usernameone, Diagnostic_passwordone);
		  }
	@Test
	public void MakeToggleInactiveWhenAppointmentNotScheduled() throws Exception{
		
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
		 driver.findElement(By.xpath(".//*[@id='tab-consult']/div[6]/div[3]/div[1]/div/label/span[2]")).click();
    	 Thread.sleep(2000);
    	 driver.findElement(By.id("diagnosticClinicTimeSlots")).click();
	}

}
