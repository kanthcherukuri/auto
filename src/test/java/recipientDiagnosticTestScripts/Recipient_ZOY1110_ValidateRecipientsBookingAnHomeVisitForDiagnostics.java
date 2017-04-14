package recipientDiagnosticTestScripts;



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
public class Recipient_ZOY1110_ValidateRecipientsBookingAnHomeVisitForDiagnostics extends LoadPropMac {
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


	@DataProvider(name = "DP1")
	public String[][] createData1() {
		return new String[][] {
			{ "yes","Hyderabad","Sugar Test","Zoylo Health Pkg", }

		};
	}
	@Test(dataProvider="DP1",groups = { "Regression","High" })
	public void validateRecipientsBookingAnHomeVisitForDoctor(String runmode,String City,String Tests, String Pkg ) throws Exception {

		if(runmode.equals("yes")){



			//Test Starts-Here
			Browser.openUrl(recipient_url);			
			//Verify Recipient Login with valid details
			RecipientPage.recipientLogin(Recipient_Username, Recipient_Password);
			Thread.sleep(10000);
			RecipientPage.goToDiagnostics();
			RecipientPage.searchInZoyloMAPArea(City);
			RecipientPage.clickOnFilterImg();
			//Verify Specialization Filter Option
			RecipientPage.ApplyFilterInDiagnostics("Home PickUp","homeVisit","doesHomeVisit","");
	        Browser.waitFortheElementXpath("//*[@id='diagnosticDetails']");
			RecipientPage.searchInZoylodetailMAP(Diagnostic_Name);
			Browser.waitFortheElementXpath("//*[@id='diagnosticDetails']");
			String DiagnosticsName = driver.findElement(By.xpath("//h1")).getText();
			System.out.println("Doctor is"+DiagnosticsName);
			RecipientPage.bookAppointmentOnDiagnostics();
			RecipientPage.selectAvailableSlotInDiagnostics(Tests, Pkg);
			RecipientPage.confirmAppointmentOnDiagnostics();
		    RecipientPage.makePayment();
			String SuccessfullMesg = driver.findElement(By.cssSelector("h5")).getText();
			System.out.println("h5"+SuccessfullMesg);
			Assert.assertEquals(SuccessfullMesg, "Thank you for booking appointment with "+DiagnosticsName+" through Zoylo. Your appointment booking details are below:");
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