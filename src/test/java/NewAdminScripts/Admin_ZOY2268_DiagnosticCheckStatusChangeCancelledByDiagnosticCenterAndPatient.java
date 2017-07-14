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

public class Admin_ZOY2268_DiagnosticCheckStatusChangeCancelledByDiagnosticCenterAndPatient extends LoadPropMac {
	
	public NewAdminDiagnosticPage AdminDiagnostic;
	public TestUtils Browser;
	public DiagnosticPage DiagnosticPage;
	
	@BeforeClass	 
	 public void launchbrowser() throws Exception {		
	 LoadBrowserProperties();
	 		 
	 
	 AdminDiagnostic=new NewAdminDiagnosticPage(driver);	
	 Browser= new TestUtils(driver);
	 DiagnosticPage=new DiagnosticPage(driver);
	 
	}
	

	@DataProvider(name = "StatusCheckByDiagnostic")
    public Object[][] createData_DP1() throws Exception{
        Object[][] retObjArr=TestUtils.getTableArray("TestData/NewAdmin.xls","StatusChange", "ZOY2268Patient");
        return(retObjArr);
    }
	
	@Test(dataProvider="StatusCheckByDiagnostic")
	public void CheckStatusChangeCancelledByDiagnosticCenter(String firstname,String lastname,String mobile,String email,String problem,
			String status) throws Exception{
		
		Browser.openUrl( loginPage_Url);
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		DiagnosticPage.SignIn(Diagnostic_usernameone, Diagnostic_passwordone);
		DiagnosticPage.DiagnosticAppointmentForToday(firstname, lastname, mobile, email, problem);
		Thread.sleep(1000);
		Browser.clickOnTheElementByXpath("//a[@class='list-more']");
		Browser.waitFortheElementXpath("(//span[@class='zy-sp-diag-m-p-uname'])[2]");
		String getId=driver.findElement(By.xpath("(//span[@class='zy-sp-diag-m-p-uname'])[2]")).getText();
		System.out.println("Appointment ID :"+getId);
		DiagnosticPage.diagnosticlogout();
		Browser.openUrl( loginPage_Url);
		AdminDiagnostic.SignIn(Admin_Username, Admin_Password);
		Browser.clickOnTheElementByXpath(Elements_NewAdminDiagnostic.Diagnostic_Menu);
		//driver.get(Elements_NewAdminDiagnostic.Diagnostic_AppointmentsUrl);
		Browser.clickOnTheElementByXpath(Elements_NewAdminDiagnostic.Diagnostic_AppointmentMenu);
		Browser.clickOnTheElementByXpath(Elements_NewAdminDiagnostic.Diagnostic_AppointmentMenu_Complete);
		Thread.sleep(2000);
		Browser.waitFortheElementXpath(Elements_NewAdminDiagnostic.Diagnostic_SearchBox);
		driver.findElement(By.xpath(Elements_NewAdminDiagnostic.Diagnostic_SearchBox)).sendKeys(getId);
		Browser.waitFortheElementXpath(Elements_NewAdminDiagnostic.Diagnostic_StatusChange);
		Browser.selectbyXpath(Elements_NewAdminDiagnostic.Diagnostic_StatusChange, status);
		Thread.sleep(5000);
		if(status.equalsIgnoreCase("Cancelled By Diagnostic Center")){
			Browser.clickOnTheElementByID(Elements_NewAdminDiagnostic.StatusChange_SubmitCancelledByDoctor);
		}else{
			Browser.clickOnTheElementByID(Elements_NewAdminDiagnostic.StatusChange_SubmitCancelledByPatient);
		}
		
		Browser.CheckNotificationMessage("Appointment has been Cancelled");
		Browser.waitFortheElementXpath(Elements_NewAdminDiagnostic.Diagnostic_ClickOnLoginUser);
		Browser.clickOnTheElementByXpath(Elements_NewAdminDiagnostic.Diagnostic_ClickOnLoginUser);
		Browser.clickOnTheElementByID(Elements_NewAdminDiagnostic.Diagnostic_Logout);
		Thread.sleep(5000);
		
	}
	@AfterClass
	public void CloseBrowser(){
		driver.quit();
	}
	
	
	}


