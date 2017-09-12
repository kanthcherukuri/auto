package NewAdminScripts;
import org.openqa.selenium.By;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import objectRepository.Elements_NewAdminDiagnostic;
import objectRepository.Elements_NewAdminDoctors;
import testBase.LoadPropMac;
import testBase.NewAdminDiagnosticPage;
import testBase.NewAdminDoctorsPage;
import testBase.TestUtils;

//@ Author: Sagar Sen

public class Admin_ZOY2655_InactiveLoginVerification extends LoadPropMac
{
	public TestUtils Browser;
	public NewAdminDoctorsPage adminDOC;
	public NewAdminDiagnosticPage adminDC;
	public String email="sagarsen.c@zoylo.com";
	public String docEmail="giridharbl@zoylo.in";
	public String dcEmail="mahesh.seropathlab@zoylo.com";
	
	@Test(priority=1)
	public void inactiveUserLogin() throws Exception
	{
		adminDOC.activateDeactivateUser(email);
		Thread.sleep(1000);
		driver.navigate().refresh();
		Browser.openUrl("https://"+Environment_Name+".zoylo.com/login");
		//RECIPIENT LOGIN VERIFICATION
		adminDOC.checkNotActiveNotification(email);
		Browser.CheckNotificationMessage("User is not active");
		//RESET USER TO ACTIVE
		driver.findElement(By.id(Elements_NewAdminDoctors.loginemail)).clear();
		driver.findElement(By.id(Elements_NewAdminDoctors.loginpassword)).clear();
		adminDOC.adminSignIn(admin_user, admin_password);
		adminDOC.activateDeactivateUser(email);
	}
	
	@Test(priority=2)
	public void inactiveDoctorLogin() throws Exception
	{
		driver.navigate().refresh();
		Browser.openUrl("https://"+Environment_Name+".zoylo.com/login");
		adminDOC.adminSignIn(admin_user, admin_password);
		adminDOC.click_doctorsTab();
		adminDOC.searchDoctorbyEmailID(docEmail);
		boolean isChecked = driver.findElement(By.xpath(Elements_NewAdminDoctors.doctorActiveCheckBox)).isSelected();
		System.out.println(docEmail + " " + isChecked);
		if(isChecked==true)
		{
			Browser.clickOnTheElementByXpath(Elements_NewAdminDoctors.doctorActiveCheckBox);
			adminDOC.click_Profile_Options("Logout");
		}
		else{
			adminDOC.click_Profile_Options("Logout");
		}
		driver.navigate().refresh();
		Browser.openUrl("https://"+Environment_Name+".zoylo.com/login");
		adminDOC.checkNotActiveNotification(docEmail);
		Browser.CheckNotificationMessage("User is not active");
	}
	
	@Test(priority=3)
	public void inactiveDiagnosticLogin() throws Exception
	{
		Browser.openUrl("https://"+Environment_Name+".zoylo.com/login");
		adminDOC.adminSignIn(admin_user, admin_password);
		adminDC.ClickOnDiagnosticMenu();
		driver.navigate().refresh();
		Browser.enterTextByXpath(Elements_NewAdminDoctors.SearchTab, dcEmail);
		Browser.waitforTextbyxpath(".//*[@id='DataTables_Table_0']/tbody/tr/td[3]", dcEmail);
		boolean isChecked = driver.findElement(By.xpath(Elements_NewAdminDiagnostic.Diagnostic_ActiveCheckBoxList)).isSelected();
		System.out.println(dcEmail + " " + isChecked);
		if(isChecked==true)
		{
			Browser.clickOnTheElementByXpath(Elements_NewAdminDiagnostic.Diagnostic_ActiveCheckBoxList);
			adminDOC.click_Profile_Options("Logout");
		}
		else{
			adminDOC.click_Profile_Options("Logout");
		}
		driver.navigate().refresh();
		Browser.openUrl("https://"+Environment_Name+".zoylo.com/login");
		adminDOC.checkNotActiveNotification(dcEmail);
		Browser.CheckNotificationMessage("Diagnostic Center is not active");
	}
	
	@BeforeClass
	public void launchapp() throws Exception
	{
		LoadBrowserProperties();
		Elements_NewAdminDoctors.newAdmin_DoctorPageProperties(); // loading the Elements
		Browser= new TestUtils(driver);
		adminDOC=new NewAdminDoctorsPage(driver);
		adminDC=new NewAdminDiagnosticPage(driver);
		Browser.openUrl("https://"+Environment_Name+".zoylo.com/login");
		adminDOC.adminSignIn(admin_user, admin_password);
	}
	
	@AfterClass
	public void closeapp()
	{
		driver.quit();
	}
}
