

//@author:Ch.Lakshmi kanth

package NewAdminScripts;

import org.testng.annotations.Test;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.openqa.selenium.By;
import org.testng.annotations.DataProvider;
import objectRepository.Elements_NewAdminDiagnostic;
import testBase.DiagnosticPage;
import testBase.LoadPropMac;
import testBase.NewAdminDiagnosticPage;
import testBase.TestUtils;

public class Admin_ZOY2268_DiagnosticCheckStatusChangeCompleted extends LoadPropMac {
	
	public NewAdminDiagnosticPage AdminDiagnostic;
	public TestUtils Browser;
	public DiagnosticPage DiagnosticPage;
	
	@BeforeClass	 
	 public void launchbrowser() throws Exception {		
	 LoadBrowserProperties();
	 AdminDiagnostic=new NewAdminDiagnosticPage(driver);	
	 Browser= new TestUtils(driver);
	 DiagnosticPage=new DiagnosticPage(driver);
	 Browser.openUrl("https://"+Environment_Name+".zoylo.com/login");
	 DiagnosticPage.SignIn(Diagnostic_usernameone, Diagnostic_passwordone);
	}
	
	@DataProvider(name = "StatusCheckByCompleted")
    public Object[][] createData_DP1() throws Exception{
        Object[][] retObjArr=TestUtils.getTableArray("TestData/NewAdmin.xls","StatusChange", "ZOY2268Completed");
        return(retObjArr);
    }
	
	@Test(dataProvider="StatusCheckByCompleted")
	public void CheckStatusChangeCompleted(String firstname,String lastname,String mobile,String email,String problem) throws Exception{
		
		DiagnosticPage.DiagnosticAppointmentForToday(firstname, lastname, mobile, email, problem);
		Thread.sleep(1000);
		Browser.clickOnTheElementByXpath("//a[@class='list-more']");
		Browser.waitFortheElementXpath("(//span[@class='zy-sp-diag-m-p-uname'])[2]");
		String getId=driver.findElement(By.xpath("(//span[@class='zy-sp-diag-m-p-uname'])[2]")).getText();
		System.out.println("Appointment ID :"+getId);
		DiagnosticPage.diagnosticlogout();
		Browser.openUrl("https://"+Environment_Name+".zoylo.com/login");
		DiagnosticPage.SignIn("kanthl@zoylo.com", "Zoylo@123");
		Browser.clickOnTheElementByXpath(Elements_NewAdminDiagnostic.Diagnostic_Menu);
		//driver.get(Elements_NewAdminDiagnostic.Diagnostic_AppointmentsUrl);
		Browser.clickOnTheElementByXpath(Elements_NewAdminDiagnostic.Diagnostic_AppointmentMenu);
		Browser.clickOnTheElementByXpath(Elements_NewAdminDiagnostic.Diagnostic_AppointmentMenu_Complete);
		Browser.waitFortheElementXpath(Elements_NewAdminDiagnostic.Diagnostic_SearchBox);
		driver.findElement(By.xpath(Elements_NewAdminDiagnostic.Diagnostic_SearchBox)).sendKeys(getId);
		Browser.waitFortheElementXpath(Elements_NewAdminDiagnostic.Diagnostic_StatusChange);
		Browser.selectbyXpath(Elements_NewAdminDiagnostic.Diagnostic_StatusChange, "Completed");
		Thread.sleep(2000);                       
		Browser.clickOnTheElementByID(Elements_NewAdminDiagnostic.StatusChange_SubmitCompleted);
		Browser.CheckNotificationMessage("Appointment checked out successfully");
	}
	
	@AfterClass
	public void CloseBrowser(){
		driver.quit();
	}
	
	}


