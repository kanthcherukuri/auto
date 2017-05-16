package diagnosticTestScripts;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import testBase.DiagnosticPage;
import testBase.LoadPropMac;
import testBase.TestUtils;

public class Schedule_ZOY_984_EditContactDetails extends LoadPropMac{
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
	public void ScheduleEditInManager() throws Exception{
		DiagnosticPageZoylo.ClickOnScheduleMenu();
		DiagnosticPageZoylo.AddContactInSchedule("Roshan", "9988002222", "roshan@gmail.com", "99002266");
		DiagnosticPageZoylo.EditConatctInSchedule("kiran", "9988002220", "kiran@gmail.com","99001266");
		
	}

	@AfterMethod
	public void deletecontactandlogout() throws Exception{
		DiagnosticPageZoylo.DeleteContactInSchedule();
		Thread.sleep(3000);
		DiagnosticPageZoylo.diagnosticlogout();
	}
	
	@AfterClass
	  public void afterClass() {
		 driver.close();
	  }
}
