package recipientsTestScripts;

import org.testng.annotations.AfterClass;
import org.testng.annotations.Test;
import org.testng.annotations.BeforeClass;
import org.openqa.selenium.*;
import org.testng.Assert;
import org.testng.SkipException;
import org.testng.annotations.*;
/*
import atu.testng.reports.listeners.ATUReportsListener;
import atu.testng.reports.listeners.ConfigurationListener;
import atu.testng.reports.listeners.MethodListener;
 */
import testBase.*;
import objectRepository.*;

public class Recipients_ZOY1091_ValidateBookingAnAppointmentWithoutLogin extends LoadPropMac {
	public RecipientPage RecipientPage;
	public TestUtils Browser;	
	public HomePage HomePage;

	@BeforeClass(groups = { "Regression","High" })	
	public void LaunchBrowser() throws Exception {

		LoadBrowserProperties();                        // Create driver instance and launch the browser
		Elements_Recipients.Recipients_PageProperties();// loading UI Page Elements / Locators
		RecipientPage = new RecipientPage(driver);      // Loading Pages
		HomePage = new HomePage(driver);
		Browser= new TestUtils(driver);        

	} 


	@Test(groups = { "Regression","High" })
	public void validateBookingAnAppointmentWithoutLogin( ) throws Exception {

			//Test Starts - Here
		    Browser.openUrl("https://"+Environment_Name+".zoylo.com/index");
			RecipientPage.searchInZoyloMAP(Doctor_Name);
			Browser.waitFortheElementXpath("//div[@class='dctr-desig']");
			String DoctorFullName = driver.findElement(By.xpath("//h1")).getText();
			System.out.println("Doctor is"+DoctorFullName);
			RecipientPage.bookAppointment();
			RecipientPage.selectDefaultSlot();
			RecipientPage.recipientLogin(Recipient_Username, Recipient_Password);
			RecipientPage.confirmAppointment("Test Details");
			RecipientPage.makePayment();
			String SuccessfullMesg = driver.findElement(By.cssSelector("h5")).getText();
			Assert.assertEquals(SuccessfullMesg, "Thank you for booking appointment with "+DoctorFullName+" through Zoylo. Your appointment booking details are below:");

		
	}
	
	 @AfterClass(groups = { "Regression","High" })
		public void Exit() {
			
			driver.quit();
		} 





}