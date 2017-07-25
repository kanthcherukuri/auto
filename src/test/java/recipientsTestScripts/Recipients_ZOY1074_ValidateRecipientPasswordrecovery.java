package recipientsTestScripts;




import org.testng.annotations.AfterClass;
import org.testng.annotations.Test;
import org.testng.annotations.BeforeClass;
import org.testng.Assert;

import java.net.UnknownHostException;

import org.openqa.selenium.*;
/*
import atu.testng.reports.listeners.ATUReportsListener;
import atu.testng.reports.listeners.ConfigurationListener;
import atu.testng.reports.listeners.MethodListener;
 */
import testBase.*;
import objectRepository.*;


public class Recipients_ZOY1074_ValidateRecipientPasswordrecovery extends LoadPropMac {
	public RecipientPage RecipientPage;
	public TestUtils Browser;	




	@BeforeClass(groups = { "Regression","High" })	
	public void LaunchBrowser() throws Exception {

		LoadBrowserProperties(); // Create driver instance and launch the browser
		Elements_Recipients.Recipients_PageProperties();// loading UI Page Elements / Locators
		RecipientPage = new RecipientPage(driver); // Loading Pages
		Browser= new TestUtils(driver);  
		Browser.mongoDB_isWhiteListHonoured("52.66.101.182", 27219, "zoynpap", "zoylo_zqa", "apz0yl0_321","users", false);


	} 



	//@Test(groups = { "Regression","High" },priority=0)
	public void validateRecipientPasswordValidations() throws Exception {



		//Test Starts-Here
		Browser.openUrl(loginPage_Url);
		//verifing email validation
		driver.findElement(By.id("forgotPassword")).click();
		Browser.waitTill(10);
		driver.findElement(By.id("resetPassword")).click();
		String emialMandatory=driver.findElement(By.xpath("//div[@class='err-msg-mob-email']")).getText();
		Assert.assertEquals(emialMandatory, "Email or Mobile field is mandatory");			 
		//verifying Email with valid data
		driver.findElement(By.id("mobileOrEmail")).sendKeys("ganeshmandala@gmail.com");
		driver.findElement(By.id("resetPassword")).click();
		Browser.waitTill(10);
		//verifying OTP with in valid data
		driver.findElement(By.id("entered-otp")).sendKeys("1234");
		driver.findElement(By.id("verify")).click();
		Thread.sleep(2000);
		String OtpInvalid=driver.findElement(By.cssSelector(Elements_Recipients.Recipient_Wrapper)).getText();
		Assert.assertEquals(OtpInvalid, "OTP is Invalid, enter a correct one or try resend option");


	}

	@Test(groups = { "Regression","High" },priority=1)
	public void validateRecipientPasswordRecovery() throws Exception {



		//Test Starts-Here
		Browser.openUrl(loginPage_Url);
		//verifing email validation
		Browser.clickOnTheElementByID("forgotPassword");
		Browser.waitTill(10);
		driver.findElement(By.id("resetPassword")).click();
		driver.findElement(By.id("mobileOrEmail")).sendKeys("zoylodoctor@gmail.com");
		driver.findElement(By.id("resetPassword")).click();
		Browser.waitTill(30);
		//verifying OTP with in valid data
		//*Getting the OTP password from Gmail
		String CompleteOTPEmail=Browser.emailResponse("zoylodoctor@gmail.com", "Zoylo@123", "Zoylo.com | One Time Password (OTP) to reset your Zoylo account password.");
		System.out.println("CompleteOTPEmail="+CompleteOTPEmail);
		//*TRim OTP from the email 
		String a[] = CompleteOTPEmail.split("Use ");
		System.out.println("split="+a[1]);
		String Finalotp[]=a[1].split(" ");
		System.out.println("OTP="+Finalotp[0]);
		//verifying OTP with in valid data
		driver.findElement(By.id("entered-otp")).sendKeys(Finalotp[0]);
		Browser.clickOnTheElementByID("verify");
		Browser.enterTextByID("newPassword", "Zoylo@123");
		Browser.enterTextByID("confirmPassword", "Zoylo@123");
		Browser.clickOnTheElementByID("resetPassword");

		Browser.CheckNotificationMessage("Your password has been changed");


	}
	@AfterClass(groups = { "Regression","High" })
	public void Exit() throws UnknownHostException  {
		Browser.mongoDB_isWhiteListHonoured("52.66.101.182", 27219, "zoynpap", "zoylo_zqa", "apz0yl0_321","users", true);

		driver.quit();
	} 





}