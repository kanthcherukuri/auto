package doctorsTestScripts;
import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import objectRepository.Elements_Doctors;
import objectRepository.Elements_NewAdminDoctors;
import objectRepository.Elements_Recipients;
import testBase.DoctorsPage;
import testBase.LoadPropMac;
import testBase.RecipientPage;
import testBase.TestUtils;

//@Author: Sagar Sen

public class Profile_ZOY2416_ProfilePictureFunctionality extends LoadPropMac
{
	public TestUtils Browser;
	public RecipientPage RecipientPage;
	public DoctorsPage doctorsPage;
	
	@Test(priority=1)
	public void doctorProfilePictureTakePhoto() throws Exception
	{
		//Doctor Application
		launchDoctorLogin();
		doctorsPage.goToDoctorProfilePicture();
		Browser.clickOnTheElementByXpath(Elements_Doctors.doctor_profileTakePhotoBtn);
		//Thread.sleep(6000);
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
		Thread.sleep(5000);
		String srcOnDocProfile=Browser.getImageSrc(Elements_Doctors.doctor_profilePicture);
		doctorsPage.doctorlogout();
		
		//Recipient Application
		Browser.waitFortheElementXpath(Elements_NewAdminDoctors.recipient_IndexAccountIcon);
		RecipientPage.searchInZoyloMAP(Doctor_Name);
		Browser.waitFortheElementXpath(Elements_Recipients.recipient_DoctorListProfilePic);
		String srcOnRecList=Browser.getImageSrc(Elements_Recipients.recipient_DoctorListProfilePic);
		Assert.assertEquals(srcOnDocProfile.replaceAll(" ", ""), srcOnRecList.replaceAll(" ", ""));
		RecipientPage.bookAppointment();
		Browser.waitFortheElementXpath(Elements_Recipients.recipient_docProfilePageImg);
		String srcOnRecDocProfile=Browser.getImageSrc(Elements_Recipients.recipient_docProfilePageImg);
		Assert.assertEquals(srcOnDocProfile.replaceAll(" ", ""), srcOnRecDocProfile.replaceAll(" ", ""));
	}
	
	@Test(priority=2)
	public void doctorProfilePictureUploadPhoto() throws Exception
	{
		//Doctor Application
		launchDoctorLogin();
		doctorsPage.goToDoctorProfilePicture();
		Browser.enterTextByID(Elements_Doctors.doctor_profileUploadInputID, System.getProperty("user.dir")+"/Uploads/d.png");
		Thread.sleep(5000);
		String srcOnDocProfile1=Browser.getImageSrc(Elements_Doctors.doctor_profilePicture);
		doctorsPage.doctorlogout();
		
		//Recipient Application
		Browser.waitFortheElementXpath(Elements_NewAdminDoctors.recipient_IndexAccountIcon);
		RecipientPage.searchInZoyloMAP(Doctor_Name);
		Browser.waitFortheElementXpath(Elements_Recipients.recipient_DoctorListProfilePic);
		String srcOnRecList1=Browser.getImageSrc(Elements_Recipients.recipient_DoctorListProfilePic);
		Assert.assertEquals(srcOnDocProfile1.replaceAll(" ", ""), srcOnRecList1.replaceAll(" ", ""));
		RecipientPage.bookAppointment();
		Browser.waitFortheElementXpath(Elements_Recipients.recipient_docProfilePageImg);
		String srcOnRecDocProfile1=Browser.getImageSrc(Elements_Recipients.recipient_docProfilePageImg);
		Assert.assertEquals(srcOnDocProfile1.replaceAll(" ", ""), srcOnRecDocProfile1.replaceAll(" ", ""));
	}
		
	@Test(priority=3)
	public void doctorProfilePictureRemovePhoto() throws Exception
	{
		//Doctor Application
		launchDoctorLogin();
		doctorsPage.goToDoctorProfilePicture();
		Browser.clickOnTheElementByXpath(Elements_Doctors.doctor_profilePictureRemoveBtn);
		Thread.sleep(5000);
		String srcOnDocProfile2=Browser.getImageSrc(Elements_Doctors.doctor_profilePicture);
		doctorsPage.doctorlogout();
		
		//Recipient Application
		Browser.waitFortheElementXpath(Elements_NewAdminDoctors.recipient_IndexAccountIcon);
		RecipientPage.searchInZoyloMAP(Doctor_Name);
		Browser.waitFortheElementXpath(Elements_Recipients.recipient_DoctorListProfilePic);
		String srcOnRecList2=Browser.getImageSrc(Elements_Recipients.recipient_DoctorListProfilePic);
		Assert.assertEquals(srcOnDocProfile2.replaceAll(" ", ""), srcOnRecList2.replaceAll(" ", ""));
		RecipientPage.bookAppointment();
		Browser.waitFortheElementXpath(Elements_Recipients.recipient_docProfilePageImg);
		String srcOnRecDocProfile2=Browser.getImageSrc(Elements_Recipients.recipient_docProfilePageImg);
		Assert.assertEquals(srcOnDocProfile2.replaceAll(" ", ""), srcOnRecDocProfile2.replaceAll(" ", ""));
	}

	public void launchDoctorLogin() throws Exception
	{
		driver.get("https://"+Environment_Name+".zoylo.com/login");
		doctorsPage.SignIn(Recipient_DocUsername, Recipient_DocPassword);
	}
	
	@BeforeClass
	public void launchbrowser() throws Exception
	{
		LoadBrowserProperties();
		Elements_NewAdminDoctors.newAdmin_DoctorPageProperties(); // loading the Elements
		Elements_Recipients.Recipients_PageProperties();
		Elements_Doctors.Doc_PageProperties();
		Browser= new TestUtils(driver);
		RecipientPage=new RecipientPage(driver);
		doctorsPage=new DoctorsPage(driver);
	}
	
	@AfterClass
	public void Exit() 
	{	
		driver.quit();
	} 
}
