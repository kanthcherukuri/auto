package diagnosticTestScripts;

import org.testng.annotations.AfterClass;
import org.testng.annotations.Test;
import org.testng.annotations.BeforeClass;
import java.util.concurrent.TimeUnit;

import testBase.DiagnosticPage;
import testBase.LoadPropMac;
import testBase.TestUtils;

public class Schedule_ZOY981_InManageAddContact extends LoadPropMac {
	
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
	public void ScheduleAddContact() throws Exception{
		
		DiagnosticPageZoylo.ClickOnScheduleMenu();
		DiagnosticPageZoylo.AddContactInSchedule("Roshan", "9988002222", "roshan@gmail.com", "99002266");
		Thread.sleep(3000);
		DiagnosticPageZoylo.DeleteContactInSchedule();
		Thread.sleep(3000);
		DiagnosticPageZoylo.diagnosticlogout();
	    
	}

	@AfterClass
	  public void closebrowser() {
		  driver.close();
	  }
	
	
}
