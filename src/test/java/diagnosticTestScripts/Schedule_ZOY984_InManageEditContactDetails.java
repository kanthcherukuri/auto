package diagnosticTestScripts;

import org.testng.annotations.AfterClass;
import org.testng.annotations.Test;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.DataProvider;
import java.util.concurrent.TimeUnit;
import testBase.DiagnosticPage;
import testBase.LoadPropMac;
import testBase.TestUtils;

public class Schedule_ZOY984_InManageEditContactDetails extends LoadPropMac{
	public DiagnosticPage DiagnosticPageZoylo;
	public TestUtils Browser;
	
	
	@BeforeClass
	  public void LaunchBrowser() throws Exception {
		LoadBrowserProperties();
		 driver.manage().window().maximize();
		 driver.get(doctors_Url);		 
		 driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		 DiagnosticPageZoylo=new DiagnosticPage(driver);
		 Browser=new TestUtils(driver);
		 DiagnosticPageZoylo.SignIn(Diagnostic_usernameone, Diagnostic_passwordone);
		  }
	
	 @DataProvider(name = "DP1")
	    public Object[][] createData_DP1() throws Exception{
	  Object[][] retObjArr=TestUtils.getTableArray("TestData/Diagnostics_TestData.xls","DiagnosticSchedule","ZOY984");
	        return(retObjArr);
	    }
	
	
	@Test(dataProvider="DP1")
	public void ScheduleEditInManager(String RunMode,String name,String phone,String email,String fax,String editedname,String editedphone,String editedemail,String editedfax) throws Exception{
		DiagnosticPageZoylo.ClickOnScheduleMenu();
		DiagnosticPageZoylo.AddContactInSchedule(name, phone, email, fax);
		DiagnosticPageZoylo.EditConatctInSchedule(editedname, editedphone, editedemail, editedfax);
	
		
	}

	@AfterMethod
	public void deletecontactandlogout() throws Exception{
		DiagnosticPageZoylo.DeleteContactInSchedule();
		DiagnosticPageZoylo.diagnosticlogout();
	}
	
	@AfterClass
	  public void afterClass() {
		 driver.quit();
	  }
}
