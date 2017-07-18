package recipientsTestScripts;



import org.testng.annotations.AfterClass;
import org.testng.annotations.Test;
import org.testng.annotations.BeforeClass;
import org.testng.Assert;
import org.testng.Assert;
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

/*
@Listeners({ ATUReportsListener.class, ConfigurationListener.class,
MethodListener.class })

 */
public class Recipients_ZOY1168_ValidateRecipientsReschedulingAppointmentSlot extends LoadPropMac {
	public RecipientPage RecipientPage;
	public TestUtils Browser;	




	@BeforeClass(groups = { "Regression","High" })	
	public void LaunchBrowser() throws Exception {

		LoadBrowserProperties(); // Create driver instance and launch the browser
		Elements_Recipients.Recipients_PageProperties();// loading UI Page Elements / Locators
		RecipientPage = new RecipientPage(driver); // Loading Pages
		Browser= new TestUtils(driver);        

	} 


	@DataProvider(name = "DP1")
	public String[][] createData1() {
		return new String[][] {
			{ "yes","Your appointment slot has been successfully CHANGED","Deepak" }


		};
	}
	@Test(dataProvider="DP1",groups = { "Regression","High" })
	public void validateRecipientsReschedulingAppointmentSlot(String runmode,String SlotChangeMesg,String Doctor ) throws Exception {

		if(runmode.equals("yes")){

			//Test Starts-Here
			Browser.openUrl(loginPage_Url);			
			//Verify Recipient Login with valid details
			RecipientPage.recipientLogin(Recipient_Username, Recipient_Password);
			RecipientPage.searchInZoyloMAP(Doctor_Name);
			String DoctorFullName = driver.findElement(By.xpath("//h1")).getText();
			RecipientPage.bookAppointment();
			RecipientPage.selectDefaultSlot();
			RecipientPage.confirmAppointment("Test details");
			RecipientPage.makePayment();
			String SuccessfullMesg = driver.findElement(By.cssSelector("h5")).getText();
			Assert.assertEquals(SuccessfullMesg, "Thank you for booking appointment with "+DoctorFullName+" through Zoylo. Your appointment booking details are below:");
			String AppointmentId = Browser.getAppointmentID();
			//Re Scheduling the Apppointment
			RecipientPage.openMyAccounts("Appointments");			
			RecipientPage.UpcomingAppointmentForDoctors(AppointmentId, "Reschedule");		
			Browser.clickOnTheElementByXpath("//li[@id='cd-1']/div"); //Tomarw Slots			
            Browser.clickOnTheElementByXpath("(//div[@class='panel-collapse collapse in']/ul/li[@class='sp-available-slots'])");
            Browser.CheckNotificationMessage(SlotChangeMesg);
            //Verify Reschedule Status 
			RecipientPage.openMyAccounts("Appointments");			
			Browser.waitFortheID("upcmng");
			driver.findElement(By.id("aptSearch")).click();
			driver.findElement(By.id("aptSearch")).sendKeys(AppointmentId);
			Thread.sleep(5000);
			Browser.waitFortheElementXpath("//div[@class='patientApmtStatus' and contains(.,'Rescheduled')]");
			
			
			


		}else{

			throw new SkipException("RUNMODE IS OFF");

		}


	}

	@AfterClass(groups = { "Regression","High" })
	public void Exit() {
		
		driver.quit();
	} 





}