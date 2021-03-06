package diagnosticTestScripts;

import org.testng.annotations.AfterClass;
import org.testng.annotations.Test;
import org.testng.annotations.BeforeClass;
import java.util.concurrent.TimeUnit;
import testBase.DiagnosticPage;
import testBase.LoadPropMac;
import testBase.TestUtils;

public class Schedule_ZOY982_InManageEditPackage extends LoadPropMac{
	
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
	public void ScheduleEditPackageInManage() throws Exception{
		
		DiagnosticPageZoylo.ClickOnScheduleMenu();
		DiagnosticPageZoylo.ScheduleInManageAddPackage("SnehaUllalPackage", "30000", "2", "Full Body Test For Diabetic", "SnehaUllalTest", "Full Body Test For Diseases");	
		DiagnosticPageZoylo.SchecduleEditPackageInManage("PrabhasHealthCard", "25000", "2", "Full Body Test For Diabetic", "Prabhastest", "Full Body Test For Diseases");
	}

	@AfterClass
	public void CloseBrowser(){
		driver.quit();
	}
}
