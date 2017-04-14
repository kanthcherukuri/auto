package performanceTestScripts;



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
public class UserLogout extends LoadPropMac {
	public RecipientPage RecipientPage;
	public TestUtils Browser;	




	@BeforeClass
	public void LaunchBrowser() throws Exception {

		LoadBrowserProperties(); // Create driver instance and launch the browser
		Elements_Recipients.Recipients_PageProperties();// loading UI Page Elements / Locators
		RecipientPage = new RecipientPage(driver); // Loading Pages
		Browser= new TestUtils(driver);        
		//Test Starts-Here
		Browser.openUrl(recipient_url);			
		//Verify Recipient Login with valid details
		RecipientPage.recipientLogin(Recipient_Username, Recipient_Password);
		Thread.sleep(2000);
		driver.get(""+base_url+"myaccount");
		Thread.sleep(5000);
		driver.findElement(By.xpath("//a[@id='logout_1']/span/i")).click();
		Thread.sleep(2000);
		
		
	} 

	@Test(priority=1)
	public void logoutOfTheUser( ) throws Exception {

		driver.findElement(By.id("logout")).click();
		Browser.waitFortheID("emailAddress");
	}
	
	
	@AfterClass

	public void Exit() {


		driver.close();


	}





}

