package recipientsTestScripts;



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
public class Recipients_ZOY1169_ValidateRecipientsAppointmentCancel extends LoadPropMac {
	public RecipientPage RecipientPage;
	public TestUtils Browser;	
	public HomePage HomePage;


	@BeforeClass(groups = { "Regression","High" })	
	public void LaunchBrowser() throws Exception {

		LoadBrowserProperties(); // Create driver instance and launch the browser
		Elements_Recipients.Recipients_PageProperties();// loading UI Page Elements / Locators
		RecipientPage = new RecipientPage(driver); // Loading Pages
		HomePage = new HomePage(driver);
		Browser= new TestUtils(driver);        

	} 



	@Test(groups = { "Regression","High" })
	public void validateRecipientsAppointmentCancel() throws Exception {

		//Test Starts-Here
		Browser.openUrl(recipient_url);			
		//Verify Recipient Login with valid details
		RecipientPage.recipientLogin(Recipient_Username, Recipient_Password);
		Thread.sleep(10000);
		RecipientPage.searchInZoyloMAPArea("Hyderabad");
		RecipientPage.clickOnMapICon();
		RecipientPage.searchInZoylodetailMAP(Doctor_Name);
		Browser.waitFortheElementXpath("//div[@class='dctr-desig']");

		String DoctorFullName = driver.findElement(By.xpath("//h1")).getText();
		System.out.println("Doctor is"+DoctorFullName);
		RecipientPage.bookAppointment();
		String clinicAddress= driver.findElement(By.xpath("//h2[@class='addr-ClinicName']/span")).getText();
		System.out.println("Clinic is"+clinicAddress);
		RecipientPage.selectDefaultSlot();
		String DoctorFirstName = driver.findElement(By.xpath("//h2")).getText();
		System.out.println("Doctor is"+DoctorFirstName);
		RecipientPage.confirmAppointment("Test Details");
		RecipientPage.makePayment();
		String SuccessfullMesg = driver.findElement(By.cssSelector("h5")).getText();
		Assert.assertEquals(SuccessfullMesg, "Thank you for booking appointment with "+DoctorFullName+" through Zoylo. Your appointment booking details are below:");
		String AppointmentId = driver.findElement(By.xpath("(//div[@class='book-dtbox']/h3)[1]")).getText();
		driver.get(""+base_url+"myaccount");
		Thread.sleep(5000);
		driver.findElement(By.xpath("//*[@id='tabs']/li[contains(.,'Appointments')]")).click();
		Thread.sleep(2000);
		driver.findElement(By.xpath("//*[@id='myAppointment']//h2[contains(.,'"+DoctorFirstName+"')]")).click();
		Browser.waitTill(60);
		driver.findElement(By.id("cancel")).click();
		Thread.sleep(5000);
		driver.findElement(By.id("confirmYes")).click();
		String cancel_mesg=driver.findElement(By.cssSelector(Elements_Recipients.Recipient_Wrapper)).getText();

		Assert.assertEquals(cancel_mesg, "Appointment has been Cancelled");
		RecipientPage.recipientLogout();

		//Email Verification of recipient
		String RecipientEmail= Browser.emailResponse(Recipient_Username, Recipient_Password, "Zoylo.com | REFUND NOTIFICATION "+AppointmentId+"Doctor appointment.");
		Assert.assertTrue(RecipientEmail.contains("We have received your request for a refund and it is being processed. You will get a confirmation once the transaction is complete. Thank you."));

		//Email verification of Doctor
		String DoctorEmail= Browser.emailResponse(Recipient_DocUsername, Recipient_DocPassword, "Zoylo.com | "+AppointmentId+". APPOINTMENT CANCELLED.");
		Assert.assertTrue(DoctorEmail.contains(""+AppointmentId+"</b> is CANCELLED."));


	}


	@AfterClass(groups = { "Regression","High" })

	public void Exit() {


		driver.close();


	}





}