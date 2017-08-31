package diagnosticTestScripts;

import org.testng.annotations.AfterClass;
import org.testng.annotations.Test;

import objectRepository.Elements_Diagnostics;

import org.testng.annotations.BeforeClass;
import java.util.concurrent.TimeUnit;
import testBase.DiagnosticPage;
import testBase.LoadPropMac;
import testBase.TestUtils;

public class Schedule_ZOY986_InMangeDeleteContact extends LoadPropMac{
	
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
	public void ScheuleDeleteContactInManger() throws Exception{
		
		Browser.clickOnTheElementByXpath(Elements_Diagnostics.ellipse);
		Browser.clickOnTheElementByID(Elements_Diagnostics.clickonmyaccountmenu);
		Browser.waitFortheID("myTabs");
		DiagnosticPageZoylo.AddContactInSchedule("Roshan", "9988002222", "roshan@gmail.com", "99002266");
		DiagnosticPageZoylo.DeleteContactInSchedule();
		Thread.sleep(3000);
		DiagnosticPageZoylo.diagnosticlogout();
	}
	
	@AfterClass
	  public void CloseBrowser() {
		  driver.quit();
	  }

}
