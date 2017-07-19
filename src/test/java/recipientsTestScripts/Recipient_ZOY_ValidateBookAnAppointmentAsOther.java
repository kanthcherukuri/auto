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


public class Recipient_ZOY_ValidateBookAnAppointmentAsOther extends LoadPropMac {
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


	@Test(groups = { "Regression","High" })
	public void ValidateBookAnAppointmentAsOther( ) throws Exception {

			//Test Starts-Here
			Browser.openUrl(loginPage_Url);			
			//Verify Recipient Login with valid details
			RecipientPage.recipientLogin(Recipient_Username, Recipient_Password);
			Thread.sleep(2000);
			RecipientPage.searchInZoyloMAP(Doctor_Name);
			String DoctorFullName = driver.findElement(By.xpath("//h1")).getText();
			RecipientPage.bookAppointment();
			String[] Appointmentdetails = RecipientPage.selectDefaultSlot();
			System.out.println("App details"+Appointmentdetails[0]);
			System.out.println("App details"+Appointmentdetails[1]);
			RecipientPage.confirmAppointmentAsOthers("Health details","Ganesh","Kumar","Male","30","O+");
			RecipientPage.makePayment();
			String SuccessfullMesg = driver.findElement(By.cssSelector("h5")).getText();
			String ClinicName = driver.findElement(By.xpath("//div[@class='book-dtbox']/h3[2]")).getText();
			Assert.assertEquals(SuccessfullMesg, "Thank you for booking appointment with "+DoctorFullName+" through Zoylo. Your appointment booking details are below:");
			Assert.assertEquals(ClinicName,"Clinic:"+Appointmentdetails[0]+",");
			String AppointmentId = driver.findElement(By.xpath("(//div[@class='book-dtbox']/h3)[1]")).getText();
			System.out.println(AppointmentId);
			
			
	           //Email Verification of recipient
				String RecipientEmail= Browser.emailResponse(Recipient_Username, Recipient_Password, "Zoylo.com | Your appointment with "+DoctorFullName+" has been confirmed.");
				Assert.assertTrue(RecipientEmail.contains("Your doctor appointment booked on Zoylo.com is CONFIRMED."));
				
				//Email verification of Doctor
				String DoctorEmail= Browser.emailResponse(Recipient_DocUsername, Recipient_DocPassword, "Zoylo.com | "+AppointmentId+".You have a new patient appointment.");
				Assert.assertTrue(DoctorEmail.contains("You have a new patient appointment booked"));
				
            

	}



	@AfterClass(groups = { "Regression","High" })

	public void Exit() throws UnknownHostException {
		// Email trigger Off
		Browser.mongoDB_isWhiteListHonoured("52.66.101.182", 27219, "zoynpap", "zoylo_zqa", "apz0yl0_321","users", true);
		driver.quit();
	}





}