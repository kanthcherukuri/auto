package NewAdminScripts;
import org.apache.commons.lang3.text.WordUtils;
import org.openqa.selenium.By;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import objectRepository.Elements_NewAdminDoctors;
import objectRepository.Elements_Recipients;
import testBase.LoadPropMac;
import testBase.NewAdminDoctorsPage;
import testBase.RecipientPage;
import testBase.TestUtils;

//@Author: Sagar Sen

public class Admin_ZOY_2441_UserToProvider extends LoadPropMac
{
	public TestUtils Browser;
	public NewAdminDoctorsPage admin;
	public RecipientPage RecipientPage;
	public String emailID, Name, fullName, password, otpValue, verifyNameOnThankyouSignUp;
	public int Phno = (int )(Math.random() *1000000000);
	
	@DataProvider(name="convert")
	public Object[][] clinicDocInfo() throws Exception
	{
		Object[][] clinicDocInformation=TestUtils.getTableArray("TestData/rvmpAdmin_addDoctor.xls", "enroll", "ZOY2441");
		return(clinicDocInformation);
	}
	
	@Test(dataProvider="convert")
	public void UserToProvider(String firstName, String MiddleName, String LastName, String ShortName, String mobileNumber, String genderValue, String DOB, String regNum, String qualification, String tag, String specialization, String practiceLine, String aboutDoc, String defaultClinicName, String defaultClinicFee, String practiceStartDate, String zoyloFacilitationFee, String Country, String State, String City, String completeAddress, String Locality, String pin, String longitude, String latitude, String removeFromDB) throws Exception
	{
		//Pre Requisits
		emailID=Browser.generateEmail(15);
		Name=Browser.generateRandomString(10).toLowerCase();
		fullName=WordUtils.capitalize(Name);
		password="Zoylo@123";
		
		//Recipient don't have an account registration
		RecipientPage.click_DontHaveAnAccount();
		RecipientPage.enter_SignUpDetails(fullName, emailID, Phno, password);
		RecipientPage.click_signUpBtn();
		Thread.sleep(500);
		otpValue=Browser.getOtp(emailID);
		Browser.enterTextByID(Elements_Recipients.recipient_OtpText, otpValue);
		Thread.sleep(500);
		Browser.clickOnTheElementByID(Elements_Recipients.recipient_VerifyOtp);
		verifyNameOnThankyouSignUp=Browser.getTextByXpath(Elements_Recipients.recipient_thankYouSignUpName);
		if(verifyNameOnThankyouSignUp.contains(fullName))
		{
			System.out.println("Recipient registration completed with emailID: "+emailID);
		}
		else
		{
			System.out.println("Recipient registration FAILED with emailID: "+emailID);
		}
		
		//ADMIN ADD DOCTOR
		Browser.openUrl("https://"+Environment_Name+".zoylo.com/login");
		admin.adminSignIn(admin_user, admin_password);
		admin.click_doctorsTab();
		admin.click_addDoctor();
		admin.Enter_doctorGenericDetails(firstName, MiddleName, LastName, ShortName, emailID, mobileNumber, password);
		driver.findElement(By.id(Elements_NewAdminDoctors.Active)).click();
		if(genderValue.equalsIgnoreCase("Male"))
		{
			Browser.actionbyid(Elements_NewAdminDoctors.gender, "Male");
			System.out.println("Gender of the doctor being entered is Male");
		}
		else
		{
			Browser.actionbyid(Elements_NewAdminDoctors.gender, "Female");
			System.out.println("Gender of the doctor being entered is Female");
		}
		Browser.clickOnTheElementByID(Elements_NewAdminDoctors.dateOfBirth);
		driver.findElement(By.id(Elements_NewAdminDoctors.dateOfBirth)).clear();
		Browser.enterTextByID(Elements_NewAdminDoctors.dateOfBirth, DOB); //(MM/DD/YYYY)
		Browser.enterTextByID(Elements_NewAdminDoctors.medicalRegistrationNumber, regNum);
		Browser.selectbyID(Elements_NewAdminDoctors.Qualification, qualification);
		Browser.selectbyID(Elements_NewAdminDoctors.professionalTag, tag);
		Browser.selectbyID(Elements_NewAdminDoctors.areaOfSpecialization, specialization);
		Browser.selectbyID(Elements_NewAdminDoctors.lineOfPractice, practiceLine);
		Browser.enterTextByID(Elements_NewAdminDoctors.aboutDoctor, aboutDoc);
		Browser.clickOnTheElementByID(Elements_NewAdminDoctors.practiceTab);
		admin.Enter_practiceDetails_DefaultClinic(defaultClinicName, defaultClinicFee, practiceStartDate, zoyloFacilitationFee);
		admin.Enter_addressInfo(Country, State, City, completeAddress, Locality, pin, longitude, latitude);
		admin.clickSubmitDoctor();
		Browser.clickOnTheElementByID(Elements_NewAdminDoctors.confirmToChangeToProvider);
		Browser.CheckNotificationMessage("Doctor created successfully");
		System.out.println(emailID+ " converted to doctor and saved successfully");
		if(removeFromDB.equalsIgnoreCase("true"))
		{
			String docID=Browser.mongoDB_getID("52.66.101.182", 27219, "zoynpap", "zoylo_zqa", "apz0yl0_321", "providers", "username", emailID);
			System.out.println("DOC ID retrived is: "+docID);
			Browser.mongoDB_Remove("52.66.101.182", 27219, "zoynpap", "zoylo_zqa", "apz0yl0_321", "zyGlobalGenericSearch", "entityId", docID);
			Browser.mongoDB_Remove("52.66.101.182", 27219, "zoynpap", "zoylo_zqa", "apz0yl0_321", "redisProvidersCache", "providerId", docID);
			Browser.mongoDB_Remove("52.66.101.182", 27219, "zoynpap", "zoylo_zqa", "apz0yl0_321", "providers", "username", emailID);
			Browser.mongoDB_Remove("52.66.101.182", 27219, "zoynpap", "zoylo_zqa", "apz0yl0_321", "users", "username", emailID);
		}
	}
	
	@BeforeClass
	public void launchapp() throws Exception
	{
		LoadBrowserProperties();
		Browser= new TestUtils(driver);
		RecipientPage= new RecipientPage(driver);
		admin=new NewAdminDoctorsPage(driver);
		Elements_NewAdminDoctors.newAdmin_DoctorPageProperties(); // loading the Elements
		Browser.openUrl("https://"+Environment_Name+".zoylo.com/login");
	}
	
	@AfterClass
	public void closeapp()
	{
		driver.quit();
	}
}
