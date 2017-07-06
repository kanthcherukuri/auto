package diagnosticTestScripts;

import org.testng.annotations.AfterClass;
import org.testng.annotations.Test;
import org.testng.annotations.BeforeClass;
import java.util.concurrent.TimeUnit;
import org.openqa.selenium.By;
import testBase.DiagnosticPage;
import testBase.LoadPropMac;
import testBase.TestUtils;

public class Schedule_ZOY985_ConsultationSlotTimeAppointmentNotScheduled extends LoadPropMac{
	
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
	public void ChangeSlotTimeWhenAppointmentNotScheduled() throws Exception{
		DiagnosticPageZoylo.ClickonAppointmentMenu();
		DiagnosticPageZoylo.ClickonToggleButtonForHomeVisit();
		DiagnosticPageZoylo.BulkCancellationForHomeVisit("07:00", "23:00");
		DiagnosticPageZoylo.ClickonAppointmentMenu();
		DiagnosticPageZoylo.ClickonToggleButtonForHomeVisit();
		DiagnosticPageZoylo.BulkCancellationForHomeVisit("07:00", "23:00");
		driver.findElement(By.id("schedule")).click();
		Thread.sleep(3000);
		driver.findElement(By.xpath("(//input[@id='Monday'])[2]")).clear();
   	    driver.findElement(By.xpath("(//input[@id='Monday'])[2]")).sendKeys("18:00");
   	    Thread.sleep(2000);
   	    driver.findElement(By.id("diagnosticClinicTimeSlots")).click();
	}
	
	@AfterClass
	public void closebrowser(){
		driver.quit();
	}

}
