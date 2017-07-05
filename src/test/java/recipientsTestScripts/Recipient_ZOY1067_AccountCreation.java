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
	public void validateRecipientAccountCreationValidations(String runmode,String FullName,String Email,String Password,String ConfirmPassword,String RefCode) throws Exception {

		if(runmode.equals("yes")){

			//Test Starts-Here
			Browser.openUrl(loginPage_Url);				
			driver.findElement(By.linkText("Don't have an account?")).click();
			Browser.waitTill(10);
			//*Creating the Recipient 
			driver.findElement(By.id("fullName")).sendKeys(FullName);
			driver.findElement(By.id("emailAddress")).sendKeys(Email);
			int Phno = (int )(Math.random() *1000000000);
			driver.findElement(By.id("mobileNumber")).sendKeys(String.valueOf("9"+Phno));
			driver.findElement(By.id("password")).sendKeys(Password);
			driver.findElement(By.xpath("//button[text()='Sign Up']")).click();
			Thread.sleep(10000);
			//*Getting the OTP password from Gmail
			String CompleteOTPEmail=Browser.emailResponse("doctorzoylo@gmail.com", "Zoylo@123", "	Zoylo.com | One Time Password (OTP) to activate your Zoylo account..");
			System.out.println("CompleteOTPEmail="+CompleteOTPEmail);
			//*TRim OTP from the email 
			String a[] = CompleteOTPEmail.split("Use ");
			System.out.println("split="+a[1]);
			String Finalotp[]=a[1].split(" ");
			System.out.println("OTP="+Finalotp[0]);
			//*Entering the OTP Value
			driver.findElement(By.id("entered-otp")).sendKeys(Finalotp[0]);
			driver.findElement(By.id("verify-otp-btn")).click();
			Thread.sleep(10000);
			//*Confirming Thank you page
			String SuccessfullMesg = driver.findElement(By.cssSelector("h5")).getText();
			Assert.assertEquals(SuccessfullMesg, "Please login to your email and proceed for verification to confirm your enrollment with us.");
			//*Removing Created User from the data Base Mongo 
			Browser.mongoDB_Remove("52.66.101.182", 27219, "zoynpap", "zoylo_zqa", "apz0yl0_321","users", "username", "doctorzoylo@gmail.com");


		}else{

			throw new SkipException("RUNMODE IS OFF");

		}

	}






	@AfterClass(groups = { "Regression","High" })

	public void Exit() throws UnknownHostException {

		// Email trigger Off
		Browser.mongoDB_isWhiteListHonoured("52.66.101.182", 27219, "zoynpap", "zoylo_zqa", "apz0yl0_321","users", true);

		driver.quit();


	}





}