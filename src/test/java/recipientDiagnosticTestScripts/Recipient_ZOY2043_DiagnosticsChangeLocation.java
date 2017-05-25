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
public class Recipient_ZOY2043_DiagnosticsChangeLocation extends LoadPropMac {
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




	@Test(priority=1)
	public void validateDiagnosticsChangeLocation() throws Exception {
		//Test Starts-Here
		Browser.openUrl(recipient_url);			
		//Verify Recipient Login with valid details
		RecipientPage.recipientLogin(Recipient_DSusername, Recipient_DSpassword);
		RecipientPage.goToDiagnostics();
		RecipientPage.searchInZoyloMAPArea("Hyderabad");
		Assert.assertEquals(driver.findElement(By.id(Elements_Home.map_AreaName)).getText(), "Hyderabad");

	}

	@Test(priority=2)
	public void validateDoctorChangeLocation() throws Exception {
	
		RecipientPage.goToDiagnostics();
		RecipientPage.searchInZoyloMAPArea("Bangalore");
		Assert.assertEquals(driver.findElement(By.id(Elements_Home.map_AreaName)).getText(), "Bangalore");

	}




	@AfterClass(groups = { "Regression","High" })

	public void Exit() {


		driver.close();


	}





}