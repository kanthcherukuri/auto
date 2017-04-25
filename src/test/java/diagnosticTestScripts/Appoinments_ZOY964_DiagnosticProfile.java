package diagnosticTestScripts;

import java.util.concurrent.TimeUnit;

import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import testBase.DiagnosticPage;
import testBase.LoadPropMac;
import testBase.TestUtils;

public class Appoinments_ZOY964_DiagnosticProfile extends LoadPropMac{

	public DiagnosticPage DiagnosticPageZoylo;
	public TestUtils exceldata;
	
		@BeforeClass
		public void beforeClass() throws Exception {
		LoadBrowserProperties();
		driver.manage().window().maximize();
		driver.get(doctors_Url);		 
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
	  	}
		
	  
	
		@Test(priority=1)
		public void DiagnosticLogin() throws Exception {
		driver.manage().timeouts().implicitlyWait(20,TimeUnit.SECONDS) ;
		DiagnosticPageZoylo=new DiagnosticPage(driver);	
		DiagnosticPageZoylo.SignIn(Diagnostic_usernameone, Diagnostic_passwordone);
			
		}
	
		@Test(priority=2)
		public void DiagnosticProfile() throws Exception{
		DiagnosticPageZoylo.ClickingOnEllipse();
		Thread.sleep(1000);
		DiagnosticPageZoylo.EditProfilepage();
			
		}
		
		@AfterClass
		public void CloseBrowser(){
			driver.close();
		}
}
