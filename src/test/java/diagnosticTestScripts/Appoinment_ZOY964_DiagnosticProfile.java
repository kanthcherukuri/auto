package diagnosticTestScripts;

import org.testng.annotations.AfterClass;
import org.testng.annotations.Test;
import org.testng.annotations.BeforeClass;
import testBase.DiagnosticPage;
import testBase.LoadPropMac;
import testBase.TestUtils;

public class Appoinment_ZOY964_DiagnosticProfile extends LoadPropMac{

	public DiagnosticPage DiagnosticPageZoylo;
	public TestUtils exceldata;
	
		@BeforeClass
		public void beforeClass() throws Exception {
		LoadBrowserProperties();
		driver.manage().window().maximize();
		driver.get(doctors_Url);		 
		DiagnosticPageZoylo=new DiagnosticPage(driver);	
		DiagnosticPageZoylo.SignIn(Diagnostic_usernameone, Diagnostic_passwordone);
	  	}
		
		@Test()
		public void DiagnosticProfile() throws Exception{
		DiagnosticPageZoylo.ClickingOnEllipse();
		Thread.sleep(1000);
		DiagnosticPageZoylo.EditProfilepage("NTR", "9900006666", "PadmaSri", "1990");
		Thread.sleep(1000);
		DiagnosticPageZoylo.diagnosticslogout();
			
		}
		
		@AfterClass
		public void CloseBrowser(){
			driver.quit();
			
		}
}
