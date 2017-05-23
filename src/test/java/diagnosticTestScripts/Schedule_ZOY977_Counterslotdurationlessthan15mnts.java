package diagnosticTestScripts;

import org.testng.annotations.AfterClass;
import org.testng.annotations.Test;
import org.testng.annotations.BeforeClass;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import testBase.DiagnosticPage;
import testBase.LoadPropMac;
import testBase.TestUtils;

public class Schedule_ZOY977_Counterslotdurationlessthan15mnts extends LoadPropMac {

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
	public void slotdurationlessthan15mnts() throws Exception{
		driver.findElement(By.id("schedule")).click();
		 Thread.sleep(3000);
		 driver.findElement(By.id("clinicSlotDuration")).clear();
		 driver.findElement(By.id("clinicSlotDuration")).sendKeys("10");
		 driver.findElement(By.id("clinicSlotDuration")).sendKeys(Keys.ENTER);
		 Thread.sleep(3000);
		 driver.findElement(By.id("diagnosticClinicTimeSlots")).click();
		 Browser.CheckNotificationMessage("Select Slot Duration in between 15 to 600");
	}
	
	@AfterClass
	public void closebrowser(){
		driver.close();
	}
}
