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
public class Recipient_ZOY1086_ValidateDianosticsBookingAnAppointmentWithoutLogin extends LoadProp {
	public RecipientPage RecipientPage;
	public HomePage HomePage;
	public TestUtils Browser;	




	@BeforeClass(groups = { "Regression","High" })	
	public void LaunchBrowser() throws Exception {

		LoadBrowserProperties(); // Create driver instance and launch the browser
		Elements_Recipients.Recipients_PageProperties();// loading UI Page Elements / Locators
		HomePage = new HomePage(driver); // Loading Pages
		RecipientPage = new RecipientPage(driver); // Loading Pages
		Browser= new TestUtils(driver);        

	} 


	@DataProvider(name = "DP1")
	public String[][] createData1() {
		return new String[][] {

				{ "yes","ganeshmandala@gmail.com","Zoylo@123","Sugar Test","Zoylo Health Pkg","Srdcscript" }


		};
	}



	@Test(dataProvider="DP1",groups = { "Regression","High" })
	public void validateBookingAnAppointment(String runmode,String Username, String Password,String Tests,String Pkg,String Diagonostics ) throws Exception {

		if(runmode.equals("yes")){

			//Test Starts-Here
			Browser.openUrl(base_url);
			HomePage.searchZoylo("Hyderabad","","");
			Browser.waitFortheID(Elements_Home.map_AreaName);
			Thread.sleep(10000);
			RecipientPage.goToDiagnostics();
			RecipientPage.searchInZoyloMAP(Diagonostics);
			String DiagonosticsFullName = driver.findElement(By.xpath("//h1")).getText();
			System.out.println("DiagonosticsFullName"+DiagonosticsFullName);
			RecipientPage.bookAppointmentOnDiagnostics();
			RecipientPage.selectAvailableSlotInDiagnostics(Tests, Pkg);
			RecipientPage.recipientLogin(Username, Password);
			Thread.sleep(5000);
			RecipientPage.confirmAppointmentOnDiagnostics();
			RecipientPage.makePayment();
			String SuccessfullMesg = driver.findElement(By.cssSelector("h5")).getText();
			System.out.println("h5"+SuccessfullMesg);
			Assert.assertEquals(SuccessfullMesg, "Thank you for booking appointment at "+DiagonosticsFullName+" through Zoylo. Your appointment booking details are below:");


		}else{

			throw new SkipException("RUNMODE IS OFF");

		}


	}






	@AfterClass(groups = { "Regression","High" })

	public void Exit() {


		driver.close();


	}





}