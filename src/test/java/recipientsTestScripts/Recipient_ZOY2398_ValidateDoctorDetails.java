package recipientsTestScripts;
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

//@Authour: Sagar Sen

public class Recipient_ZOY2398_ValidateDoctorDetails extends LoadPropMac
{
	public TestUtils Browser;
	public RecipientPage RecipientPage;
	public DoctorsPage doctorsPage;
	public String aboutData="Doctorzoylo has good experience.";
	
	@Test()
	public void validateDoctorDetails() throws Exception
	{
		//Doctor profile
		doctorsPage.SignIn(Recipient_DocUsername, Recipient_DocPassword);
		driver.get("https://"+LoadPropMac.Environment_Name+".zoylo.com/providerAccount");
		Browser.waitFortheID(Elements_Doctors.doctor_profileEdit);
		Browser.scrollbyID(Elements_Doctors.doctor_profileEdit);
		Browser.clickOnTheElementByID(Elements_Doctors.doctor_profileEdit);
		Browser.scrollbyID(Elements_Doctors.doctor_ProfileAbout);
		Browser.clickOnTheElementByID(Elements_Doctors.doctor_ProfileAbout);
		driver.findElement(By.id(Elements_Doctors.doctor_ProfileAbout)).clear();
		driver.findElement(By.id(Elements_Doctors.doctor_ProfileAbout)).sendKeys(aboutData);
		Thread.sleep(400);
		Browser.scrollbyID(Elements_Doctors.doctor_profileSaveInfo);
		String regNum=Browser.getTextByXpath(Elements_Doctors.doctor_profileRegistrationNum);
		String RegNumSplit[]=regNum.split("\\.");
		String actualRegNum=RegNumSplit[1].replaceAll("\n", "");
		System.out.println("Final registration no: "+actualRegNum);
		Browser.clickOnTheElementByID(Elements_Doctors.doctor_profileSaveInfo);
		Browser.waitFortheID(Elements_Doctors.doctor_profileEdit);
		driver.findElement(By.xpath(Elements_Doctors.doctor_ProfilePaymentTab)).click();
		Browser.clickOnTheElementByID(Elements_Doctors.doctor_Profile_PaymentCash);
		Browser.clickOnTheElementByID(Elements_Doctors.doctor_Profile_PaymentSave);
		Browser.CheckNotificationMessage("Information Updated Successfully");
		Thread.sleep(5000);
		Browser.waitFortheElementXpath("//a[@data-target='#logoutModal1']");
		driver.findElement(By.cssSelector("span.icon-diag-cen > i.fa.fa-sign-out"))	.click();
		Thread.sleep(2000);
		driver.findElement(By.id("logout")).click();
		Thread.sleep(5000);
		System.out.println("Doctor Logged Out");
		
		//Recipient asserts
		Browser.waitFortheElementXpath(Elements_NewAdminDoctors.recipient_IndexAccountIcon);
		RecipientPage.searchInZoyloMAP(Doctor_Name);
		RecipientPage.bookAppointment();
		Browser.waitforTextbyxpath(Elements_Recipients.doctorNameOnProfile, Doctor_Name);
		Browser.clickOnTheElementByID(Elements_Recipients.recipient_DocProfile_About);
		String docAbout=Browser.getTextByXpath("(//div[@class='zy-rec-hosp-lbl'])[2]");
		Assert.assertEquals(docAbout, aboutData);
		String docRegNum=Browser.getTextByXpath("(//div[@class='zy-rec-hosp-lbl'])[4]");
		Assert.assertEquals(docRegNum, actualRegNum);
		String lang=Browser.getTextByXpath("(//div[@class='zy-rec-hosp-lbl'])[6]");
		Assert.assertEquals(lang, "ENGLISH");
		String paymentType=Browser.getTextByXpath("((//div[@class='zy-rec-hosp-lbl'])[8]//div)[2]");
		Assert.assertEquals(paymentType, "Cash");
		
		//Doctor reset data
		driver.get(loginPage_Url);
		doctorsPage.SignIn(Recipient_DocUsername, Recipient_DocPassword);
		driver.get("https://"+LoadPropMac.Environment_Name+".zoylo.com/providerAccount");
		Browser.waitFortheID(Elements_Doctors.doctor_profileEdit);
		driver.findElement(By.xpath(Elements_Doctors.doctor_ProfilePaymentTab)).click();
		Browser.clickOnTheElementByID(Elements_Doctors.doctor_Profile_PaymentCash);
		Browser.clickOnTheElementByID(Elements_Doctors.doctor_Profile_PaymentSave);
		Browser.CheckNotificationMessage("Information Updated Successfully");
		Thread.sleep(5000);
		Browser.waitFortheElementXpath("//a[@data-target='#logoutModal1']");
		driver.findElement(By.cssSelector("span.icon-diag-cen > i.fa.fa-sign-out"))	.click();
		Thread.sleep(2000);
		driver.findElement(By.id("logout")).click();
		Thread.sleep(5000);
		System.out.println("Doctor Logged Out");
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
		driver.get(loginPage_Url);
		//driver.get(index_url);
	}
	
	@AfterClass
	public void Exit() 
	{	
		driver.quit();
	}
}
