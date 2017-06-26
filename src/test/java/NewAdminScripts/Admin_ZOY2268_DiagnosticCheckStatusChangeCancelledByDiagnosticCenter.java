package NewAdminScripts;

import java.util.Iterator;
import java.util.Set;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import objectRepository.Elements_NewAdminDiagnostic;
import testBase.DiagnosticPage;
import testBase.LoadPropMac;
import testBase.NewAdminDiagnosticPage;
import testBase.TestUtils;

public class Admin_ZOY2268_DiagnosticCheckStatusChangeCancelledByDiagnosticCenter extends LoadPropMac {
	
	public NewAdminDiagnosticPage AdminDiagnostic;
	public TestUtils Browser;
	public DiagnosticPage DiagnosticPage;
	
	@BeforeClass	 
	 public void launchbrowser() throws Exception {		
	 LoadBrowserProperties();
	 driver.get(doctors_Url);		 
	 driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
	 AdminDiagnostic=new NewAdminDiagnosticPage(driver);	
	 Browser= new TestUtils(driver);
	 DiagnosticPage=new DiagnosticPage(driver);
	 DiagnosticPage.SignIn(Diagnostic_usernameone, Diagnostic_passwordone);
	}
	

	@DataProvider(name = "StatusCheckByDiagnostic")
    public Object[][] createData_DP1() throws Exception{
        Object[][] retObjArr=TestUtils.getTableArray("TestData/NewAdmin.xls","StatusChange", "ZOY2268Diagnostic");
        return(retObjArr);
    }
	
	@Test(dataProvider="StatusCheckByDiagnostic")
	public void CheckStatusChangeCancelledByDiagnosticCenter(String firstname,String lastname,String mobile,String email,String problem) throws Exception{
		
		DiagnosticPage.DiagnosticAppointmentForToday(firstname, lastname, mobile, email, problem);
		DiagnosticPage.diagnosticlogout();
		Browser.openUrl(doctors_Url);
		DiagnosticPage.SignIn("kanthl@zoylo.com", "Zoylo@123");
		Browser.clickOnTheElementByXpath(Elements_NewAdminDiagnostic.Diagnostic_Menu);
		driver.get(Elements_NewAdminDiagnostic.Diagnostic_AppointmentsUrl);
		Browser.waitFortheElementXpath(Elements_NewAdminDiagnostic.Diagnostic_SearchBox);
		driver.findElement(By.xpath(Elements_NewAdminDiagnostic.Diagnostic_SearchBox)).sendKeys(firstname);
		Browser.waitFortheElementXpath(Elements_NewAdminDiagnostic.Diagnostic_StatusChange);
		Browser.selectbyXpath(Elements_NewAdminDiagnostic.Diagnostic_StatusChange, "Cancelled By Diagnostic Center");
		Thread.sleep(1000);
		String parentWindowHandler = driver.getWindowHandle(); // Store your parent window
		String subWindowHandler = null;
		Set<String> handles = driver.getWindowHandles(); // get all window handles
		Iterator<String> iterator = handles.iterator();
		while (iterator.hasNext())
		{
		subWindowHandler = iterator.next();
		}
		driver.switchTo().window(subWindowHandler); // switch to popup window
		Thread.sleep(2000);                         // perform operations on popup
		Browser.clickOnTheElementByID(Elements_NewAdminDiagnostic.StatusChange_SubmitCancelledByDoctor);
		driver.switchTo().window(parentWindowHandler);
		Browser.CheckNotificationMessage("Appointment has been Cancelled");
	}
	}


