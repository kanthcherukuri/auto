package diagnosticTestScripts;

import org.testng.annotations.AfterClass;
import org.testng.annotations.Test;
import org.testng.annotations.BeforeClass;
import objectRepository.Elements_Diagnostics;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import testBase.DiagnosticPage;
import testBase.LoadPropMac;
import testBase.TestUtils;

public class Schedule_ZOY992_HomeSampleDistanceCounter extends LoadPropMac{
	
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
		 DiagnosticPageZoylo.SignIn(Diagnostic_usernamethree, Diagnostic_passwordthree);
		  }
	@Test
	public void HomeSampleDistanceCounter() throws Exception{
		

		DiagnosticPageZoylo.ClickonAppointmentMenu();
		Thread.sleep(3000);
		DiagnosticPageZoylo.ClickonToggleButtonForHomeVisit();
		Thread.sleep(1000);
		DiagnosticPageZoylo.BulkCancellationForHomeVisit("07:00", "23:00");
		Thread.sleep(1000);
		DiagnosticPageZoylo.ClickOnScheduleMenu();
		Thread.sleep(3000);
		driver.findElement(By.xpath(Elements_Diagnostics.HomeSampleCollectionMenu)).click();
		Thread.sleep(2000);
		driver.findElement(By.id(Elements_Diagnostics.HomeSampleDistance)).clear();
		driver.findElement(By.id(Elements_Diagnostics.HomeSampleDistance)).sendKeys("8");
		Thread.sleep(2000);
		driver.findElement(By.id(Elements_Diagnostics.HomeSampleSave)).click();
		//Browser.CheckNotificationMessage("Homevisit updated Sucessfully");
	}
	@AfterClass
	public void closebrowser(){
		driver.quit();
	}
}
