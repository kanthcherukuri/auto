package recipientsTestScripts;



import org.testng.annotations.AfterClass;
import org.testng.annotations.Test;
import org.testng.annotations.BeforeClass;
import org.testng.AssertJUnit;
import org.openqa.selenium.*;

import org.testng.Assert;

import org.testng.annotations.*;
/*
import atu.testng.reports.listeners.ATUReportsListener;
import atu.testng.reports.listeners.ConfigurationListener;
import atu.testng.reports.listeners.MethodListener;
 */
import testBase.*;
import objectRepository.*;

/*
@Listeners({ ATUReportsListener.class, ConfigurationListener.class,
MethodListener.class })

 */
public class Recipient_ZOY_ValidateBookAnAppointmentAsOther extends LoadPropMac {
	public RecipientPage RecipientPage;
	public TestUtils Browser;	




	@BeforeClass(groups = { "Regression","High" })	
	public void LaunchBrowser() throws Exception {

		LoadBrowserProperties(); // Create driver instance and launch the browser
		Elements_Recipients.Recipients_PageProperties();// loading UI Page Elements / Locators
		RecipientPage = new RecipientPage(driver); // Loading Pages
		Browser= new TestUtils(driver);        

	} 


	@Test(groups = { "Regression","High" })
	public void ValidateBookAnAppointmentAsOther( ) throws Exception {

			//Test Starts-Here
			Browser.openUrl(recipient_url);			
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
			AssertJUnit.assertEquals(SuccessfullMesg, "Thank you for booking appointment with "+DoctorFullName+" through Zoylo. Your appointment booking details are below:");
			AssertJUnit.assertEquals(ClinicName,"Clinic:"+Appointmentdetails[0]+",");
            

	}






	@AfterClass(groups = { "Regression","High" })

	public void Exit() {


		driver.close();


	}





}