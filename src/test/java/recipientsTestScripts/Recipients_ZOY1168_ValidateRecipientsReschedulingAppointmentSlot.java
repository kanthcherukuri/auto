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
			{ "yes","Successfully changed the appointment slot","Deepak" }


		};
	}
	@Test(dataProvider="DP1",groups = { "Regression","High" })
	public void validateRecipientsReschedulingAppointmentSlot(String runmode,String SlotChangeMesg,String Doctor ) throws Exception {

		if(runmode.equals("yes")){

			//Test Starts-Here
			Browser.openUrl(loginPage_Url);			
			//Verify Recipient Login with valid details
			RecipientPage.recipientLogin(Recipient_Username, Recipient_Password);
			Thread.sleep(2000);
			RecipientPage.searchInZoyloMAP(Doctor_Name);
			String DoctorFullName = driver.findElement(By.xpath("//h1")).getText();
			RecipientPage.bookAppointment();
			RecipientPage.selectDefaultSlot();
			RecipientPage.confirmAppointment("Test details");
			RecipientPage.makePayment();
			String SuccessfullMesg = driver.findElement(By.cssSelector("h5")).getText();
			Assert.assertEquals(SuccessfullMesg, "Thank you for booking appointment with "+DoctorFullName+" through Zoylo. Your appointment booking details are below:");




			//Re Scheduling the Apppointment
			Browser.openUrl(loginPage_Url);
			driver.findElement(By.xpath("//li[@id='myaccount']/span/img")).click();
			Browser.waitTill(60);
			driver.findElement(By.xpath("//li[@id='myAppointment']/a/span/i")).click();
			Browser.waitTill(60);
			Thread.sleep(5000);// Added for view
			driver.findElement(By.xpath("//div[@class='apt-dt-chng' and contains(.,'Scheduled')]/div[2]/div[1]")).click();  // Change
			Browser.waitTill(60);
			Thread.sleep(5000);
			Browser.scrollbyxpath("//a[contains(@href, '#sp-nightslots')]");
			driver.findElement(By.xpath("//a[contains(@href, '#sp-nightslots')]")).click();
			Thread.sleep(2000);
			driver.findElement(By.xpath("(//div[@id='sp-nightslots']/ul/li[@class='sp-available-slots']/span)[1]")).click();
			Thread.sleep(2000);
			String RescheduleMesg= driver.findElement(By.cssSelector(Elements_Recipients.Recipient_Wrapper)).getText();
			System.out.println("RescheduleMesg"+RescheduleMesg);
			Assert.assertEquals(RescheduleMesg, SlotChangeMesg);
			Browser.openUrl(loginPage_Url);
			RecipientPage.recipientLogout();


		}else{

			throw new SkipException("RUNMODE IS OFF");

		}


	}

	@AfterClass(groups = { "Regression","High" })
	public void Exit() {
		
		driver.quit();
	} 





}