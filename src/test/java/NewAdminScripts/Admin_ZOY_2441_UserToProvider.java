package NewAdminScripts;
import java.util.concurrent.TimeUnit;

import org.apache.commons.lang3.text.WordUtils;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
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
	
	@Test()
	public void UserToProvider() throws Exception
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
		otpValue=getOtp();
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
	}
	
	@BeforeClass
	public void launchapp() throws Exception
	{
		LoadBrowserProperties();
		driver.get(loginPage_Url);
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		Elements_NewAdminDoctors.newAdmin_DoctorPageProperties(); // loading the Elements
		Browser= new TestUtils(driver);
		RecipientPage= new RecipientPage(driver);
		admin=new NewAdminDoctorsPage(driver);
		//admin.adminSignIn(admin_user, admin_password);
	}
	
	@AfterClass
	public void closeapp()
	{
		driver.quit();
	}
	
	public String getOtp() throws Exception
	{
		String x=Browser.mongoDB_Response("52.66.101.182", 27219, "zoynpap", "zoylo_zqa", "apz0yl0_321", "users", "username", emailID);
		String[] y=x.split("num\" : \"");
		//System.out.println("otpString="+y[1]);		
		String[] otp=y[1].split("\" , \"");		
		System.out.println("otp="+otp[0]);
		return otp[0];
	}
}
