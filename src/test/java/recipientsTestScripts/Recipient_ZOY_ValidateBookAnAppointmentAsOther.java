package recipientsTestScripts;



import org.openqa.selenium.*;
import org.openqa.selenium.interactions.Actions;




import org.testng.Assert;
import org.testng.Reporter;
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


	@DataProvider(name = "DP1")
	public String[][] createData1() {
		return new String[][] {
				{ "yes","Ganesh" }

		};
	}
	
	@Test(dataProvider="DP1",groups = { "Regression","High" })
	public void validateBookingAnAppointment(String runmode,String Doctor ) throws Exception {

		if(runmode.equals("yes")){

			//Test Starts-Here
			Browser.openUrl(recipient_url);			
			//Verify Recipient Login with valid details
			RecipientPage.recipientLogin(Recipient_Username, Recipient_Password);
			Thread.sleep(2000);
			RecipientPage.searchInZoyloMAP(Doctor);
			String DoctorFullName = driver.findElement(By.xpath("//h1")).getText();
			RecipientPage.bookAppointment();
			String[] Appointmentdetails = RecipientPage.selectDefaultSlot();
			System.out.println("App details"+Appointmentdetails[0]);
			System.out.println("App details"+Appointmentdetails[1]);
			RecipientPage.confirmAppointmentAsOthers("Health details","Ganesh","Male","30");
			RecipientPage.makePayment();
			String SuccessfullMesg = driver.findElement(By.cssSelector("h5")).getText();
			String ClinicName = driver.findElement(By.xpath("//div[@class='book-dtbox']/h3[2]")).getText();
			Assert.assertEquals(SuccessfullMesg, "Thank you for booking appointment with "+DoctorFullName+" through Zoylo. Your appointment booking details are below:");
			Assert.assertEquals(ClinicName,"Clinic:"+Appointmentdetails[0]+",");
            

		}else{

			throw new SkipException("RUNMODE IS OFF");

		}


	}






	@AfterClass(groups = { "Regression","High" })

	public void Exit() {


		driver.close();


	}





}