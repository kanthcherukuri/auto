package diagnosticTestScripts;

import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.Test;
import org.testng.annotations.BeforeClass;
import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

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
		 DiagnosticPageZoylo=new DiagnosticPage(driver);
		 Browser=new TestUtils(driver);
		 Browser.openUrl("https://"+Environment_Name+".zoylo.com/login");
		 driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
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
		WebDriverWait wait = (new WebDriverWait(driver, 90));
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(Elements_Diagnostics.ManageTestSubmitNotification)));
		String ActualNotification=Browser.getTextByXpath(Elements_Diagnostics.ManageTestSubmitNotification);
		Assert.assertEquals(ActualNotification,"Approval is pending");

		DiagnosticPageZoylo.diagnosticlogout();
	}
	
	@AfterClass
	  public void CloaseBrowser() {
		driver.quit();
	  }
}
