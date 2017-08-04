package recipientsTestScripts;


import org.testng.annotations.AfterClass;
import org.testng.annotations.Test;
import org.testng.annotations.BeforeClass;
import org.testng.Assert;

import java.net.UnknownHostException;

import org.openqa.selenium.*;

import org.testng.SkipException;
import org.testng.annotations.*;
/*
import atu.testng.reports.listeners.ATUReportsListener;
import atu.testng.reports.listeners.ConfigurationListener;
import atu.testng.reports.listeners.MethodListener;
 */
import testBase.*;
import objectRepository.*;


public class Recipient_ZOY1067_AccountCreation extends LoadPropMac {
	public RecipientPage RecipientPage;
	public TestUtils Browser;	




	@BeforeClass(groups = { "Regression","High" })	
	public void LaunchBrowser() throws Exception {

		LoadBrowserProperties(); // Create driver instance and launch the browser
		Elements_Recipients.Recipients_PageProperties();// loading UI Page Elements / Locators
		RecipientPage = new RecipientPage(driver); // Loading Pages
		Browser= new TestUtils(driver);        
       // Email trigger ON
		Browser.mongoDB_isWhiteListHonoured("52.66.101.182", 27219, "zoynpap", "zoylo_zqa", "apz0yl0_321","users", false);

	} 


	@DataProvider(name = "DP1")
	public String[][] createData1() {
		return new String[][] {

			{ "yes","SignupZoylo","doctorzoylo@gmail.com","Zoylo@123","Zoylo@123",""},
		};
	}
	@Test(dataProvider="DP1",groups = { "Regression","High" })
	public void validateRecipientAccountCreation(String runmode,String FullName,String ResipientEmail,String ResipientPassword,String ConfirmPassword,String RefCode) throws Exception {

		if(runmode.equals("yes")){

			//Test Starts-Here
			Browser.openUrl(loginPage_Url);				
			driver.findElement(By.linkText("Don't have an account?")).click();
			//*************Creating New Recipient***********//
			Browser.enterTextByID("fullName", FullName);
			driver.findElement(By.id("emailAddress")).sendKeys(ResipientEmail);
			int Phno = (int )(Math.random() *1000000000);
			driver.findElement(By.id("mobileNumber")).sendKeys(String.valueOf("9"+Phno));
			driver.findElement(By.id("password")).sendKeys(ResipientPassword);
			driver.findElement(By.xpath("//button[text()='Sign Up']")).click();
			Thread.sleep(10000);
			//*Getting the OTP password from Gmail
			String CompleteOTPEmail=Browser.emailResponse(ResipientEmail, ResipientPassword, "	Zoylo.com | One Time Password (OTP) to activate your Zoylo account..");
			System.out.println("CompleteOTPEmail="+CompleteOTPEmail);
			//*TRim OTP from the email 
			String a[] = CompleteOTPEmail.split("Use ");
			System.out.println("split="+a[1]);
			String Finalotp[]=a[1].split(" ");
			System.out.println("OTP="+Finalotp[0]);
			//*Entering the OTP Value
			driver.findElement(By.id("entered-otp")).sendKeys(Finalotp[0]);
			Browser.clickOnTheElementByID("verify-otp-btn");
			//*Confirming Thank you page
			String SuccessfullMesg =Browser.getTextByXpath("//h5");
			//String SuccessfullMesg = driver.findElement(By.cssSelector("h5")).getText();
			Assert.assertEquals(SuccessfullMesg, "Please login to your email and proceed for verification to confirm your enrollment with us.");
			
			//********Booking Appointment with newly created User**********//
			
			Browser.openUrl(loginPage_Url);			
			RecipientPage.recipientLogin(ResipientEmail, ResipientPassword);
			RecipientPage.searchInZoyloMAP(Doctor_Name);
			String DoctorFullName = Browser.getTextByXpath("//h1");
			String Fee = Browser.getTextByXpath("//div[@class='consultFee']");
			RecipientPage.bookAppointment();
			String[] Appointmentdetails = RecipientPage.selectDefaultSlot();
			System.out.println("Clinic Name details"+Appointmentdetails[0]);
			System.out.println("Time details"+Appointmentdetails[1]);
			RecipientPage.confirmAppointment("Patient details");
		    RecipientPage.makePayment();
			//Verifying Thank you Message in Thank you Page
			Assert.assertEquals(Browser.getTextByXpath("//h5"), "Thank you for booking appointment with "+DoctorFullName+" through Zoylo. Your appointment booking details are below:");

		}else{

			throw new SkipException("RUNMODE IS OFF");

		}

	}






	@AfterClass(groups = { "Regression","High" })

	public void Exit() throws UnknownHostException {
		//*Removing Created User from the data Base Mongo 
		Browser.mongoDB_Remove("52.66.101.182", 27219, "zoynpap", "zoylo_zqa", "apz0yl0_321","users", "username", "doctorzoylo@gmail.com");
		// Email trigger Off
		Browser.mongoDB_isWhiteListHonoured("52.66.101.182", 27219, "zoynpap", "zoylo_zqa", "apz0yl0_321","users", true);

		driver.quit();


	}





}