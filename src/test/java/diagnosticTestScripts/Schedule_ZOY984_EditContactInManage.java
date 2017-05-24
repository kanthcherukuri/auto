package diagnosticTestScripts;

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

public class Schedule_ZOY984_EditContactInManage extends LoadPropMac{
	
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
	public void EditContactInManage() throws Exception{
		DiagnosticPageZoylo.ClickOnScheduleMenu();
		DiagnosticPageZoylo.AddContactInSchedule("Roshan", "9988002222", "roshan@gmail.com", "99002266");
		Thread.sleep(1000);
		DiagnosticPageZoylo.EditConatctInSchedule("kiran", "9900662288", "kiran@gmail.com", "126428");
		Thread.sleep(2000);
		DiagnosticPageZoylo.DeleteContactInSchedule();

	}
	
	@AfterClass
	public void CloseBrowser(){
		driver.close();
	}


}
