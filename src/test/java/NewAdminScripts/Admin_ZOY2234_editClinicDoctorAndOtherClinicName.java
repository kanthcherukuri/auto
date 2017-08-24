package NewAdminScripts;
import org.apache.commons.lang3.text.WordUtils;
import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.Test;
import org.testng.annotations.BeforeClass;
import java.util.concurrent.TimeUnit;
import org.testng.annotations.DataProvider;
import objectRepository.Elements_NewAdminDoctors;
import objectRepository.Elements_Recipients;
import testBase.LoadPropMac;
import testBase.NewAdminDoctorsPage;
import testBase.RecipientPage;
import testBase.TestUtils;

//@Authour: Sagar Sen

public class Admin_ZOY2234_editClinicDoctorAndOtherClinicName extends LoadPropMac
{
	public TestUtils Browser;
	public NewAdminDoctorsPage admin;
	public RecipientPage RecipientPage;
	
	@DataProvider(name="clinicDoctorDetails")
	public Object[][] clinicDocInfo() throws Exception
	{
		Object[][] clinicDocInformation=TestUtils.getTableArray("TestData/rvmpAdmin_addDoctor.xls", "clinicDoctor", "ZOY2234");
		return(clinicDocInformation);
	}
	
	@Test(dataProvider="clinicDoctorDetails")
	public void editClinicDoctor(String emailID, String docName) throws Exception
	{
		String editClinicName=Browser.generateRandomString(5).toLowerCase();
		String editedOtherClinicName=WordUtils.capitalize(editClinicName);
		admin.click_doctorsTab();
		admin.searchDoctorbyEmailID(emailID);
		admin.clickEditbutton();
		//Edit other clinic Name - To test ZOY-2453
		Browser.clickOnTheElementByID(Elements_NewAdminDoctors.practiceTab);
		Browser.waitFortheID(Elements_NewAdminDoctors.addOtherClinic);
		Browser.clickOnTheElementByXpath(Elements_NewAdminDoctors.otherClinicEditBtn);
		Browser.waitFortheID(Elements_NewAdminDoctors.otherClinicName);
		driver.findElement(By.id(Elements_NewAdminDoctors.otherClinicName)).clear();
		driver.findElement(By.id(Elements_NewAdminDoctors.otherClinicName)).sendKeys(editedOtherClinicName);
		Thread.sleep(1000);
		driver.findElement(By.id(Elements_NewAdminDoctors.otherClinicSave)).click();
		String verifyClinicName=Browser.getTextByXpath(Elements_NewAdminDoctors.otherClinicTable_ClinicName);
		Assert.assertEquals(verifyClinicName, editedOtherClinicName);
		Thread.sleep(1000);
		admin.clickSubmitDoctor();
		//Thread.sleep(10000);
		Browser.CheckNotificationMessage("Doctor Updated Successfully");
		Thread.sleep(2000);
		admin.click_Profile_Options("Logout");
		
		//Recipient check for edited other clinic name - To test ZOY-2453
		Browser.waitFortheElementXpath(Elements_Recipients.link_myAccountheaderIcon);
		driver.navigate().refresh();
		RecipientPage.searchInZoyloMAP(docName);
		RecipientPage.bookAppointment();
		Browser.waitforTextbyxpath(Elements_Recipients.doctorNameOnProfile, docName);
		Browser.clickOnTheElementByID(Elements_Recipients.doctor_ProfilePlusMore);
		String OtherClinicOnRecipient=Browser.getTextByXpath(Elements_Recipients.doctor_ProfileOtherClinicDropDown);
		Assert.assertEquals(OtherClinicOnRecipient, editedOtherClinicName);
	}
	
	@BeforeClass
	public void launchapp() throws Exception
	{
		LoadBrowserProperties();
		Browser.openUrl("https://"+Environment_Name+".zoylo.com/login");
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		Elements_NewAdminDoctors.newAdmin_DoctorPageProperties(); // loading the Elements
		Browser= new TestUtils(driver);
		admin=new NewAdminDoctorsPage(driver);
		RecipientPage=new RecipientPage(driver);
		admin.adminSignIn(admin_user, admin_password);
	}
	
	@AfterClass
	public void closeapp()
	{
		driver.quit();
	}
}
