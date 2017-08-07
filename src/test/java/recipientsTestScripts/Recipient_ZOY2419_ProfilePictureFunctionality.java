package recipientsTestScripts;
import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import objectRepository.Elements_Doctors;
import objectRepository.Elements_Recipients;
import testBase.LoadPropMac;
import testBase.RecipientPage;
import testBase.TestUtils;

//@Author: Sagar Sen

public class Recipient_ZOY2419_ProfilePictureFunctionality extends LoadPropMac
{
	public TestUtils Browser;
	public RecipientPage RecipientPage;
	
	@Test(priority=1)
	public void userTakePhoto() throws Exception
	{
		Browser.waitFortheElementXpath(Elements_Recipients.recipient_DoctorClusters);
		Browser.clickOnTheElementByID(Elements_Recipients.Recipient_MyAccountTab);
		RecipientPage.goToRecipientProfilePic();
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
		Browser.CheckNotificationMessage("Your profile photo has been successfully updated");
		Thread.sleep(2000);
	}
	
	@Test(priority=2)
	public void userBrowsePhoto() throws Exception
	{
		driver.navigate().refresh();
		RecipientPage.goToRecipientProfilePic();
		Browser.enterTextByID(Elements_Recipients.Recipient_ProfileUploadInputID, System.getProperty("user.dir")+"/Uploads/d.png");
		Browser.CheckNotificationMessage("Your profile photo has been successfully updated");
		Thread.sleep(2000);
	}
	
	@Test(priority=3)
	public void userRemovePhoto() throws Exception
	{
		driver.navigate().refresh();
		RecipientPage.goToRecipientProfilePic();
		Browser.clickOnTheElementByXpath(Elements_Recipients.Recipient_ProfileRemoveBtn);
		String srcOnRecProfile=Browser.getImageSrc(Elements_Recipients.Recipient_ProfileGetSrc);
		Assert.assertTrue(srcOnRecProfile.contains("defaultUserImage180x180"));
	}
	
	@BeforeClass
	public void launchbrowser() throws Exception
	{
		LoadBrowserProperties();
		Elements_Recipients.Recipients_PageProperties();
		Elements_Doctors.Doc_PageProperties();
		Browser= new TestUtils(driver);
		RecipientPage=new RecipientPage(driver);
		driver.get(loginPage_Url);
		RecipientPage.recipientLogin(Recipient_Username, Recipient_Password);
	}
	
	@AfterClass
	public void Exit() {
		
		driver.quit();
	}
}
