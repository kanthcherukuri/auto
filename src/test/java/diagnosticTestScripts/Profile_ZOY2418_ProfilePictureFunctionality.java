package diagnosticTestScripts;
import org.openqa.selenium.By;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import objectRepository.Elements_Diagnostics;
import objectRepository.Elements_Doctors;
import objectRepository.Elements_NewAdminDoctors;
import objectRepository.Elements_Recipients;
import testBase.DiagnosticPage;
import testBase.LoadPropMac;
import testBase.RecipientPage;
import testBase.TestUtils;

//@Author: Sagar Sen

public class Profile_ZOY2418_ProfilePictureFunctionality extends LoadPropMac
{
	public TestUtils Browser;
	public RecipientPage RecipientPage;
	public DiagnosticPage diagnosticPage;
	
	@Test(priority=1)
	public void diagnosticProfileTakePhoto() throws Exception
	{
		Browser.waitFortheID(Elements_Diagnostics.clickondashboardmenu);
		Browser.scrollbyID(Elements_Diagnostics.clickonaccountmenu);
		Browser.clickOnTheElementByID(Elements_Diagnostics.clickonaccountmenu);
		diagnosticPage.goToDcProfilePicture();
		Browser.clickOnTheElementByXpath(Elements_Doctors.doctor_profileTakePhotoBtn);
		if(driver.findElements(By.id(Elements_Doctors.doctor_profileVideoWindow)).size()!=0)
		{
			System.out.println("The video window is available to take a picture");
			Browser.clickOnTheElementByXpath(Elements_Doctors.doctor_profileVideoWindowTakePhotoBtn);
			Browser.clickOnTheElementByXpath(Elements_Doctors.doctor_profileVideoUsePhotoBtn);
		}
		else
		{
			System.out.println("The video window is not available to take a picture");
		}
		Browser.CheckNotificationMessage("Profile photo uploaded successfully");
		Thread.sleep(5000);
	}
	
	@Test(priority=2)
	public void diagnosticProfileUploadPhoto() throws Exception
	{
		driver.navigate().refresh();
		diagnosticPage.goToDcProfilePicture();
		Browser.enterTextByID(Elements_Doctors.doctor_profileUploadInputID, System.getProperty("user.dir")+"/Uploads/d.png");
		Browser.CheckNotificationMessage("Profile photo changed successfully");
		Thread.sleep(5000);
	}
	
	@Test(priority=3)
	public void diagnosticProfileRemovePhoto() throws Exception
	{
		driver.navigate().refresh();
		diagnosticPage.goToDcProfilePicture();
		Browser.clickOnTheElementByXpath(Elements_Diagnostics.dc_profilePictureRemoveBtn);
		Browser.CheckNotificationMessage("Your profile photo has been successfully removed");
		Thread.sleep(5000);
		diagnosticPage.diagnosticslogout(); //logout
	}
	
	@BeforeClass
	public void launchbrowser() throws Exception
	{
		LoadBrowserProperties();
		Elements_NewAdminDoctors.newAdmin_DoctorPageProperties(); // loading the Elements
		Elements_Recipients.Recipients_PageProperties();
		Elements_Doctors.Doc_PageProperties();
		Elements_Diagnostics.Diag_PageProperties();
		Browser= new TestUtils(driver);
		RecipientPage=new RecipientPage(driver);
		diagnosticPage=new DiagnosticPage(driver);
		driver.get(loginPage_Url);
		diagnosticPage.SignIn(Recipient_DiaUsername, Recipient_DiaPassword);
	}
	
	@AfterClass
	public void Exit() 
	{	
		driver.quit();
	} 
}
