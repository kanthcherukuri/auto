package recipientsTestScripts;



import org.testng.annotations.AfterClass;
import org.testng.annotations.Test;
import org.testng.annotations.BeforeClass;
import org.testng.Assert;
import org.openqa.selenium.*;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.SkipException;
import org.testng.annotations.*;
/*
import atu.testng.reports.listeners.ATUReportsListener;
import atu.testng.reports.listeners.ConfigurationListener;
import atu.testng.reports.listeners.MethodListener;
 */
import testBase.*;
import objectRepository.*;


public class Recipient_ZOY1171_ValidateRecipientBookFallowUpApointment extends LoadPropMac {
	public RecipientPage RecipientPage;
	public DoctorsPage DoctorsPage;
	public TestUtils Browser;	




	@BeforeClass(groups = { "Regression","High" })	
	public void launchBrowser() throws Exception {

		LoadBrowserProperties(); // Create driver instance and launch the browser
		Elements_Recipients.Recipients_PageProperties();// loading UI Page Elements / Locators
		RecipientPage = new RecipientPage(driver); // Loading Pages
		DoctorsPage = new DoctorsPage(driver); // Loading Pages
		Browser= new TestUtils(driver);        

	} 

	
	@Test(groups = { "Regression","High" })
	public void validateBookingFallowUpAppointmentForDoctor( ) throws Exception {

			//Test Starts-Here
			Browser.openUrl(loginPage_Url);
			RecipientPage.recipientLogin(Recipient_Username, Recipient_Password);
			RecipientPage.searchInZoyloMAP(Doctor_Name);
			String DoctorFullName = driver.findElement(By.xpath("//h1")).getText();
			RecipientPage.bookAppointment();
			String[] Appointmentdetails = RecipientPage.selectDefaultSlot();
			System.out.println("Clinic Name details"+Appointmentdetails[0]);
			System.out.println("Time Slot"+Appointmentdetails[1]);
			RecipientPage.confirmAppointment("Test details");
			RecipientPage.makePayment();
			String SuccessfullMesg = driver.findElement(By.cssSelector("h5")).getText();
			Assert.assertEquals(SuccessfullMesg, "Thank you for booking appointment with "+DoctorFullName+" through Zoylo. Your appointment booking details are below:");
			String AppointmentId = Browser.getAppointmentID();
			System.out.println(AppointmentId);
			RecipientPage.recipientLogout();				
			//Login as Doctor				
			Browser.openUrl(loginPage_Url);			
			DoctorsPage.SignIn(Recipient_DocUsername, Recipient_DocPassword);
			DoctorsPage.clickOnThePatientFromDashBoard(Appointmentdetails[1]);
			DoctorsPage.doctorCheckinCheckOut();
			DoctorsPage.doctorlogout();				
			//Login as Recipient
			Browser.openUrl(loginPage_Url);			
			RecipientPage.recipientLogin(Recipient_Username, Recipient_Password);
			Thread.sleep(2000);
			driver.navigate().refresh();
			Thread.sleep(5000);
			Browser.scrollbyID("submitReview");
			driver.findElement(By.id("comment")).sendKeys("Review Comments test details Review Comments test details Review Comments test details Review Comment");			
			driver.findElement(By.id("submitReview")).click();
			Browser.CheckNotificationMessage("Review submitted successfully.");
			Thread.sleep(5000);
			//FallowUp the Appointment
			RecipientPage.goToMyAccounts("Appointment");
			Browser.clickOnTheElementByID("hist"); // my History
			driver.findElement(By.id("aptSearch")).click();
			driver.findElement(By.id("aptSearch")).sendKeys(AppointmentId);
			Browser.waitFortheElementXpath("//div[@class='apt-dt-chng' and contains(.,'Completed')]/div[contains(.,'"+AppointmentId+"')]");

			driver.findElement(By.xpath("(//img[@class='followup'])[1]")).click();
			//Book FallowUp Slot
			RecipientPage.selectDefaultSlot();
			Browser.waitFortheID("followUpBookAppointment");
			driver.findElement(By.id("problem")).sendKeys("Health details");
			driver.findElement(By.id("followUpBookAppointment")).click();  // FollowUp Book
			Browser.CheckNotificationMessage("Your Appointment with Dr. "+Doctor_Name+" is confirmed.You will Recieve a confirmation SMS");

			System.out.println("followUpBookAppointment Confirmed");

		
	}

	@AfterClass(groups = { "Regression","High" })

	public void Exit() {

		driver.quit();
	}





}