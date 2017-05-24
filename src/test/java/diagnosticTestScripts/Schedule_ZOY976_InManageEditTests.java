package diagnosticTestScripts;

import org.testng.annotations.AfterClass;
import org.testng.annotations.Test;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.AfterClass;
import org.testng.annotations.Test;
import org.testng.annotations.BeforeClass;
import java.util.concurrent.TimeUnit;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import testBase.DiagnosticPage;
import testBase.LoadPropMac;
import testBase.TestUtils;

public class Schedule_ZOY976_InManageEditTests extends LoadPropMac{
	
	public DiagnosticPage DiagnosticPageZoylo;
	public TestUtils Browser;
	
	@BeforeClass
	  public void beforeClass() throws Exception {
		LoadBrowserProperties();
		 driver.manage().window().maximize();
		 driver.get(doctors_Url);		 
		 driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		 DiagnosticPageZoylo=new DiagnosticPage(driver);
		 Browser=new TestUtils(driver);
		 DiagnosticPageZoylo.SignIn(Diagnostic_usernameone, Diagnostic_passwordone);
		  }

	@Test
	public void ScheduleEditTestsInManage() throws Exception{
		DiagnosticPageZoylo.ClickOnScheduleMenu();
		Thread.sleep(2000);
		DiagnosticPageZoylo.ScheduleClickOnDiagnosticManage();
		Thread.sleep(1000);
		DiagnosticPageZoylo.ScheduleDiagnosticManageClickonTestsMenu();
		Thread.sleep(2000);
		DiagnosticPageZoylo.ScheduleDiagnosticManageAddTests("LucidPackage","Full body Test for all ", "2000", "2");
		Thread.sleep(2000);
		DiagnosticPageZoylo.ScheduleInManageEditTests("Konark", "Not Full Body Test", "20000", "2");	
	}
	
	@AfterClass
	  public void afterClass() {
		driver.close();
	  }
}
