//@author:Ch.Lakshmi kanth

package NewAdminScripts;

import org.testng.annotations.Test;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;

import java.util.concurrent.TimeUnit;
import org.openqa.selenium.By;
import org.testng.annotations.DataProvider;
import objectRepository.Elements_NewAdminDiagnostic;
import testBase.DiagnosticPage;
import testBase.LoadPropMac;
import testBase.NewAdminDiagnosticPage;
import testBase.TestUtils;

public class Admin_ZOY2268_DiagnosticCheckStatusChangeRescheduleByPatientAndDiagnostic extends LoadPropMac{
	
	public NewAdminDiagnosticPage AdminDiagnostic;
	public TestUtils Browser;
	public DiagnosticPage DiagnosticPage;
	
	@BeforeClass	 
	 public void launchbrowser() throws Exception {		
	 LoadBrowserProperties();
	 AdminDiagnostic=new NewAdminDiagnosticPage(driver);	
	 Browser= new TestUtils(driver);
	 DiagnosticPage=new DiagnosticPage(driver);
	 Browser.openUrl(loginPage_Url);	 
	 driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
	 DiagnosticPage.SignIn(Diagnostic_usernameone, Diagnostic_passwordone);
	}
	
	@DataProvider(name = "SatuscheckReschedule")
    public Object[][] createData_DP1() throws Exception{
        Object[][] retObjArr=TestUtils.getTableArray("TestData/NewAdmin.xls","StatusChange", "ZOY2268");
        return(retObjArr);
    }
	
	@Test(dataProvider="SatuscheckReschedule")
	public void DiagnosticCheckStatusChangeReschedule(String firstname,String lastname,String mobile,String email,String problem) throws Exception{
		DiagnosticPage.DiagnosticAppointmentForToday(firstname, lastname, mobile, email, problem);
		DiagnosticPage.diagnosticlogout();
		Browser.openUrl(loginPage_Url);
		DiagnosticPage.SignIn("kanthl@zoylo.com", "Zoylo@123");
		Browser.waitFortheElementXpath(Elements_NewAdminDiagnostic.Diagnostic_Menu);
		Browser.clickOnTheElementByXpath(Elements_NewAdminDiagnostic.Diagnostic_Menu);
		Browser.clickOnTheElementByXpath(Elements_NewAdminDiagnostic.Diagnostic_AppointmentMenu);
		Browser.clickOnTheElementByXpath(Elements_NewAdminDiagnostic.Diagnostic_AppointmentMenu_Complete);
		Browser.waitFortheElementXpath(Elements_NewAdminDiagnostic.Diagnostic_SearchBox);
		driver.findElement(By.xpath(Elements_NewAdminDiagnostic.Diagnostic_SearchBox)).sendKeys(firstname);
		Browser.waitFortheElementXpath(Elements_NewAdminDiagnostic.Diagnostic_StatusChange);
		Browser.selectbyXpath(Elements_NewAdminDiagnostic.Diagnostic_StatusChange, "Reschedule By Patient");
		Browser.waitFortheElementXpath(Elements_NewAdminDiagnostic.Reschedule_SelectTommorowMenu);
		Browser.clickOnTheElementByXpath(Elements_NewAdminDiagnostic.Reschedule_SelectTommorowMenu);
		//driver.findElement(By.xpath(Elements_NewAdminDiagnostic.Reschedule_SelectTommorowMenu)).click();
		Browser.clickOnTheElementByXpath(Elements_NewAdminDiagnostic.Reschedule_SelectAvailableSlot);
		Browser.waitFortheElementXpath(Elements_NewAdminDiagnostic.Reschedule_ClosePopup);
		Browser.clickOnTheElementByXpath(Elements_NewAdminDiagnostic.Reschedule_ClosePopup);
		Thread.sleep(6000);
		Browser.waitFortheElementXpath(Elements_NewAdminDiagnostic.Diagnostic_StatusChange);
		Browser.selectbyXpath(Elements_NewAdminDiagnostic.Diagnostic_StatusChange, "Reschedule By Diagnostic Center");
		Browser.clickOnTheElementByXpath(Elements_NewAdminDiagnostic.Reschedule_SelectNextDay);
		Browser.clickOnTheElementByXpath(Elements_NewAdminDiagnostic.Reschedule_SelectAvailableSlot);
		Browser.CheckNotificationMessage("Appointment is rescheduled successfully");
		Thread.sleep(2000);
		
	}
	
	@AfterClass
	public void CloseBrowser(){
		driver.quit();
	}

}
