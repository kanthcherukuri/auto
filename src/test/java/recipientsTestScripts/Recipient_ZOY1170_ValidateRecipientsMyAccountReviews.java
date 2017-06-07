package recipientsTestScripts;



import org.testng.annotations.AfterClass;
import org.testng.annotations.Test;
import org.testng.annotations.BeforeClass;
import org.testng.AssertJUnit;
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
public class Recipient_ZOY1170_ValidateRecipientsMyAccountReviews extends LoadPropMac {
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
			{ "yes","Deepak" }

		};
	}
	@Test(dataProvider="DP1",groups = { "Regression","High" })
	public void validateRecipientsMyAccountReviews(String runmode,String Doctor ) throws Exception {

		if(runmode.equals("yes")){

			//Test Starts-Here
			Browser.openUrl(recipient_url);			
			//Verify Recipient Login with valid details
			RecipientPage.recipientLogin(Recipient_Username, Recipient_Password);
			Thread.sleep(2000);
			RecipientPage.searchInZoyloMAP(Doctor_Name);
			String DoctorFullName = driver.findElement(By.xpath("//h1")).getText();
			
			System.out.println("Doctor name is "+DoctorFullName);
			RecipientPage.bookAppointment();
			RecipientPage.selectDefaultSlot();
			RecipientPage.confirmAppointment("Test details");
			RecipientPage.makePayment();
			String SuccessfullMesg = driver.findElement(By.cssSelector("h5")).getText();
			AssertJUnit.assertEquals(SuccessfullMesg, "Thank you for booking appointment with "+DoctorFullName+" through Zoylo. Your appointment booking details are below:");
			                                    
			//Review the Appointment
			RecipientPage.openMyAccounts();
			driver.findElement(By.xpath("//li[@id='myAppointment']/a/span/i")).click();
			Browser.waitTill(60);
			Thread.sleep(5000);// Added for view
			driver.findElement(By.id("hist")).click();  // my History
			Thread.sleep(5000);

			driver.findElement(By.id("reviewIcon")).click();
			Browser.waitTill(60);
			Browser.scrollbyID("comment");
			driver.findElement(By.id("comment")).sendKeys("Review Comments test details Review Comments test details Review Comments test details Review Comment");
			driver.findElement(By.id("submitReview")).click();
			Browser.waitTill(60);
			Thread.sleep(2000);
			String ReviewMesg= driver.findElement(By.cssSelector(Elements_Recipients.Recipient_Wrapper)).getText();
			System.out.println("Review mesg"+ReviewMesg);
			AssertJUnit.assertEquals(ReviewMesg, "Review submitted successfully.");
			Browser.openUrl(recipient_url);
			RecipientPage.recipientLogout();


		}else{

			throw new SkipException("RUNMODE IS OFF");

		}


	}






	@AfterClass(groups = { "Regression","High" })

	public void Exit() {


		driver.close();


	}





}