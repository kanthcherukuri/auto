package recipientsTestScripts;



import org.testng.annotations.AfterClass;
import org.testng.annotations.Test;
import org.testng.annotations.BeforeClass;
import org.testng.Assert;
import org.testng.Assert;
import org.openqa.selenium.*;
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
		Browser.openUrl("https://"+Environment_Name+".zoylo.com/login");			
		//Verify Recipient Login with valid details
		RecipientPage.recipientLogin(Recipient_Username, Recipient_Password);
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
		String AppointmentId = Browser.getAppointmentID();
		System.out.println(AppointmentId);
		
		//Verify Canceling of appointment
		RecipientPage.openMyAccounts("Appointments");	
		//Thread.sleep(5000);  // added this to view Apid in upcoming
		RecipientPage.UpcomingAppointmentForDoctors(AppointmentId, "Cancel");		
		String cancel_mesg=driver.findElement(By.cssSelector(Elements_Recipients.Recipient_Wrapper)).getText();
		Assert.assertEquals(cancel_mesg, "Appointment has been CANCELLED");
		//Verify Canceling Status in History
		Thread.sleep(5000);  // added this to view Apid in Hist
		Browser.clickOnTheElementByID("hist");
		driver.findElement(By.id("aptSearch")).click();
		driver.findElement(By.id("aptSearch")).sendKeys(AppointmentId);
		Browser.waitFortheElementXpath("//div[@class='apt-dt-chng' and contains(.,'Cancelled')]//div/span[contains(.,'"+AppointmentId+"')]");
		
			
		/*
		
		//Email Verification of recipient
		String RecipientEmail= Browser.emailResponse(Recipient_Username, Recipient_Password, "Zoylo.com | REFUND NOTIFICATION "+AppointmentId+"Doctor appointment.");
		Assert.assertTrue(RecipientEmail.contains("We have received your request for a refund and it is being processed. You will get a confirmation once the transaction is complete. Thank you."));

		//Email verification of Doctor
		String DoctorEmail= Browser.emailResponse(Recipient_DocUsername, Recipient_DocPassword, "Zoylo.com | "+AppointmentId+". APPOINTMENT CANCELLED.");
		Assert.assertTrue(DoctorEmail.contains(""+AppointmentId+"</b> is CANCELLED."));
*/

	}
	
	@AfterClass(groups = { "Regression","High" })
	public void Exit() {
		
		driver.quit();
	} 





}