package diagnosticTestScripts;

import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.Test;
import org.testng.annotations.BeforeClass;
import org.openqa.selenium.By;
import objectRepository.Elements_Diagnostics;
import java.util.concurrent.TimeUnit;
import testBase.DiagnosticPage;
import testBase.LoadPropMac;
import testBase.TestUtils;

public class Schedule_ZOY968_InManageSubmitTestsForApproval extends LoadPropMac {
	
	public DiagnosticPage DiagnosticPageZoylo;
	public TestUtils Browser;
	
	@BeforeClass
	  public void LaunchBrowser() throws Exception {
		LoadBrowserProperties();
		 driver.manage().window().maximize();
		 driver.get(doctors_Url);		 
		 driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		 DiagnosticPageZoylo=new DiagnosticPage(driver);
		 Browser=new TestUtils(driver);
		 DiagnosticPageZoylo.SignIn(Diagnostic_usernameone, Diagnostic_passwordone);
		  }

	@Test
	public void ScheduleSubmitTestsForApproval() throws Exception{
		
		DiagnosticPageZoylo.ClickOnScheduleMenu();
		DiagnosticPageZoylo.ScheduleClickOnDiagnosticManage();
		DiagnosticPageZoylo.ScheduleDiagnosticManageClickonTestsMenu();
	    DiagnosticPageZoylo.ScheduleDiagnosticManageAddTests("Sulochanaytest","Full body Test for all ", "2000", "2");
		Thread.sleep(2000);
		DiagnosticPageZoylo.ClickOnToggletoSubmitTestsForApproval();
		String ActualNotification=driver.findElement(By.xpath(Elements_Diagnostics.ManageTestSubmitNotification)).getText();
		Assert.assertEquals(ActualNotification,"Approval is pending");

		DiagnosticPageZoylo.diagnosticlogout();
	}
	
	@AfterClass
	  public void CloaseBrowser() {
		driver.quit();
	  }
}
