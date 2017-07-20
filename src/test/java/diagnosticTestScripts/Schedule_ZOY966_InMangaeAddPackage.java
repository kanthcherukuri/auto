package diagnosticTestScripts;

import org.testng.annotations.AfterClass;
import org.testng.annotations.Test;
import org.testng.annotations.BeforeClass;
import java.util.concurrent.TimeUnit;
import org.testng.annotations.DataProvider;
import testBase.DiagnosticPage;
import testBase.LoadPropMac;
import testBase.TestUtils;

public class Schedule_ZOY966_InMangaeAddPackage extends LoadPropMac{
	
	public DiagnosticPage DiagnosticPageZoylo;
	public TestUtils Browser;
	
	@BeforeClass
	  public void LaunchBrowser() throws Exception {
		LoadBrowserProperties();
		 DiagnosticPageZoylo=new DiagnosticPage(driver);
		 Browser=new TestUtils(driver);
		 Browser.openUrl(loginPage_Url);
		 driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		 DiagnosticPageZoylo.SignIn(Diagnostic_usernameone, Diagnostic_passwordone);
		  }
	
	@DataProvider(name = "DP1")
	 public String[][] createData1() {
			return new String[][] {
			{ "yes","SamoraiHospital","9000","10","Check to test how your body parts are working","FullBodyTest", "Check to test how your body parts are working"}

			};
		}
	
	
	@Test(dataProvider="DP1")
	public void ScheduleAddPackage(String RunMode,String packagename,String cost,String discount, String description,String testname,String testdescription) throws Exception{
		DiagnosticPageZoylo.ClickOnScheduleMenu();
		DiagnosticPageZoylo.ScheduleInManageAddPackage(packagename, cost, discount, description, testname, testdescription);
		DiagnosticPageZoylo.diagnosticlogout();
	}

	@AfterClass
	  public void CloseBrowser() {
		driver.quit();
	  }
	
}
