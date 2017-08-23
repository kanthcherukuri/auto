package diagnosticTestScripts;

import org.testng.annotations.AfterClass;
import org.testng.annotations.Test;
import org.testng.annotations.BeforeClass;
import java.util.concurrent.TimeUnit;
import org.openqa.selenium.By;
import testBase.DiagnosticPage;
import testBase.LoadPropMac;
import testBase.TestUtils;

public class Schedule_ZOY996_HomeSampleChangeSlotTimeAppointmentNotScheduled extends LoadPropMac{
	
	public DiagnosticPage DiagnosticPageZoylo;
	public TestUtils Browser;
	
	@BeforeClass
	  public void launchbrowser() throws Exception {
		LoadBrowserProperties();
		 DiagnosticPageZoylo=new DiagnosticPage(driver);
		 Browser=new TestUtils(driver);
		 Browser.openUrl("https://"+Environment_Name+".zoylo.com/login");
		 driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		 DiagnosticPageZoylo.SignIn(Diagnostic_usernamethree, Diagnostic_passwordthree);
		  }
	
	@Test
	public void HomeSampleChangeSlotTimeAppointmentNotScheduled() throws Exception{
		
		DiagnosticPageZoylo.ClickonAppointmentMenu();
		DiagnosticPageZoylo.ClickonToggleButtonForHomeVisit();
		DiagnosticPageZoylo.BulkCancellationForHomeVisit("07:00", "23:00");
		driver.findElement(By.id("schedule")).click();
		Thread.sleep(3000);
		driver.findElement(By.xpath("//*[@id='cd-11']/div")).click();
		Thread.sleep(2000);
		driver.findElement(By.xpath("//*[@id='Monday'][@class='hvEndTime1 MondayHE']")).clear();
   	 	driver.findElement(By.xpath("//*[@id='Monday'][@class='hvEndTime1 MondayHE']")).sendKeys("20:00");
   	 	Thread.sleep(2000);
   	 	driver.findElement(By.id("diagnosticHomeVisitTimeSlots")).click();
	}
	
	@AfterClass
	public void closebrowser(){
		driver.quit();
	}

}
