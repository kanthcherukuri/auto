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
public class Recipients_ZOY1092_SearchBySpecialization extends LoadPropMac {
	public RecipientPage RecipientPage;
	public TestUtils Browser;	




	@BeforeClass(groups = { "Regression","High" })	
	public void launchBrowser() throws Exception {

		LoadBrowserProperties(); // Create driver instance and launch the browser
		Elements_Recipients.Recipients_PageProperties();// loading UI Page Elements / Locators
		RecipientPage = new RecipientPage(driver); // Loading Pages
		Browser= new TestUtils(driver);   
		//Test Starts-Here
		Browser.openUrl(recipient_url);			
		//Verify Recipient Login with valid details
		RecipientPage.recipientLogin(Recipient_Username, Recipient_Password);
		Thread.sleep(2000);
		//Searching Locality/Area
		RecipientPage.searchInZoyloMAPArea("Hyderabad");
		//Verify search with Doctors name
		driver.findElement(By.id("search2")).click();
		driver.findElement(By.id("indexSearchTextbox")).sendKeys("Cardiology");
		Thread.sleep(2000);
	} 


	@Test(groups = { "Regression","Medium" },priority=3)
	public void searchBySpecialization() throws Exception {

		driver.findElement(By.cssSelector("div.a-s-w > span")).click();
		Browser.waitFortheElementXpath("//div[@class='dctr-desig']");	
		//String Search_Doctor = driver.findElement(By.xpath("//h1")).getText();
		//Assert.assertTrue(Search_Doctor.contains(Doctor_Name));

	}

	


	@AfterClass(groups = { "Regression","High" })

	public void Exit() {


		driver.close();


	}





}

