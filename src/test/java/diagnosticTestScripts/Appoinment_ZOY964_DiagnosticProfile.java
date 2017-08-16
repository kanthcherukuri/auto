package diagnosticTestScripts;

import org.testng.annotations.AfterClass;
import org.testng.annotations.Test;
import org.testng.annotations.BeforeClass;
import java.util.concurrent.TimeUnit;
import testBase.DiagnosticPage;
import testBase.LoadPropMac;
import testBase.TestUtils;

public class Appoinment_ZOY964_DiagnosticProfile extends LoadPropMac{

	public DiagnosticPage DiagnosticPageZoylo;
	public TestUtils Browser;
	
		@BeforeClass
		public void beforeClass() throws Exception {
			LoadBrowserProperties();
			 DiagnosticPageZoylo=new DiagnosticPage(driver);
			 Browser=new TestUtils(driver);
			 Browser.openUrl(loginPage_Url);
			 driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);	
			 DiagnosticPageZoylo.SignIn(Diagnostic_usernameone, Diagnostic_passwordone);
	  	}
		
		@Test()
		public void DiagnosticProfile() throws Exception{
		DiagnosticPageZoylo.ClickingOnEllipse();
		DiagnosticPageZoylo.EditProfilepage("Louisee", "9900006666", "PadmaSri", "1990");
		Thread.sleep(1000);
		DiagnosticPageZoylo.diagnosticslogout();
			
		}
		
		@AfterClass
		public void CloseBrowser(){
			driver.quit();
			
		}
}
