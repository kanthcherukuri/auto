package diagnosticTestScripts;

import org.testng.annotations.AfterClass;
import org.testng.annotations.Test;
import org.testng.annotations.BeforeClass;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import objectRepository.Elements_Diagnostics;
import testBase.DiagnosticPage;
import testBase.LoadPropMac;
import testBase.TestUtils;

public class Schedule_ZOY992_HomeSampleDistanceAppointmentScheduled  extends LoadPropMac{

	
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
	public void CheckHomeSampleDistanceAppointmentScheduled() throws Exception{
		
		DiagnosticPageZoylo.DiagnosticAppointmentForHomeVisit("Kumaran", "K", "9900442266", "kumaran@gmail.com", "Kakatiya Residency", "Diabetic");
		Thread.sleep(2000);
		DiagnosticPageZoylo.ClickOnScheduleMenu();
		Thread.sleep(2000);
		driver.findElement(By.xpath(Elements_Diagnostics.HomeSampleCollectionMenu)).click();
		Thread.sleep(2000);
		driver.findElement(By.id(Elements_Diagnostics.HomeSampleDistance)).clear();
		driver.findElement(By.id(Elements_Diagnostics.HomeSampleDistance)).sendKeys("20");
		Thread.sleep(2000);
		driver.findElement(By.id(Elements_Diagnostics.HomeSampleSave)).click();
	}

	@AfterClass
	public void closebrowser(){
		driver.close();
	}
}