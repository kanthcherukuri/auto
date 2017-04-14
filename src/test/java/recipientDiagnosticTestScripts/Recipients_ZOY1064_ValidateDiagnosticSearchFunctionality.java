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
public class Recipients_ZOY1064_ValidateDiagnosticSearchFunctionality extends LoadPropMac {
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
		RecipientPage.recipientLogin(Recipient_DSusername, Recipient_DSpassword);
		Thread.sleep(2000);
		//Searching Locality/Area
		RecipientPage.searchInZoyloMAPArea("Hyderabad");

	} 

	 @DataProvider(name = "DP1")
		public String[][] createData1() {
			return new String[][] {
					{ "yes","Noha Diagnostics","Blood Test","Noha Health Package","abcdefg" }

			};
		}
	@Test(dataProvider="DP1",groups = { "Regression","Medium" },priority=1)
	public void mapSearchByDiagnostics(String runmode,String Diagnostics,String Tests,String Packages,String invalidData ) throws Exception {

		if(runmode.equals("yes")){

			//Verify search with Doctors name
			RecipientPage.searchInZoyloMAP(Diagnostics);
			String Search_Diagnostics = driver.findElement(By.xpath("//h1")).getText();
			Assert.assertEquals(Search_Diagnostics, Diagnostics);

		}else{

			throw new SkipException("RUNMODE IS OFF");

		}

	}

	@Test(dataProvider="DP1",groups = { "Regression","Medium" },priority=2)
	public void ValidateMapSearchByTests(String runmode,String Diagnostics,String Tests,String Packages,String invalidData ) throws Exception {

		if(runmode.equals("yes")){
			RecipientPage.searchInZoyloMAP(Tests);
			driver.findElement(By.id("diagnosticDetails")).click();
			Browser.waitTill(60);
			driver.findElement(By.id("tests_search")).sendKeys(Tests);
			Thread.sleep(2000);
			String Search_tests = driver.findElement(By.xpath("//div[@class='zy-rec-diag-s-apt-g-table-col']")).getText();
			Assert.assertTrue(Search_tests.equals(Tests));



		}else{

			throw new SkipException("RUNMODE IS OFF");

		}	
	}

	@Test(dataProvider="DP1",groups = { "Regression","Medium" },priority=3)
	public void ValidateMapsearchByPackages(String runmode,String Diagnostics,String Tests,String Packages,String invalidData ) throws Exception {

		if(runmode.equals("yes")){
			//Verify search with clinic name
			RecipientPage.searchInZoyloMAP(Packages);
			driver.findElement(By.id("diagnosticDetails")).click();
			Browser.waitTill(80);
			driver.findElement(By.xpath("//*[@id='package-li']/a")).click();
			Thread.sleep(2000);
			driver.findElement(By.id("packages_search")).sendKeys(Packages);
			Thread.sleep(2000);
			String Search_pkg = driver.findElement(By.xpath("//div[@class='zy-rec-diag-s-apt-g-table-col' and contains(.,'"+Packages+"')]")).getText();

			Assert.assertEquals(Search_pkg, Packages);


		}else{

			throw new SkipException("RUNMODE IS OFF");

		}	
	}

	@Test(dataProvider="DP1",groups = { "Regression","Medium" },priority=4)
	public void mapSearchByInvalidData(String runmode,String Doctor,String Specialization,String Clinic,String invalidData ) throws Exception {

		if(runmode.equals("yes")){

			//Verify with Invalid data
			driver.findElement(By.id("search2")).click();
			driver.findElement(By.id("indexSearchTextbox")).sendKeys(invalidData);
			Thread.sleep(10000);
			String OppsContent = driver.findElement(By.cssSelector("div.a-s-w > span")).getText();
			Assert.assertEquals(OppsContent, "Oops! your search for "+invalidData+" did not match any records");


		}else{

			throw new SkipException("RUNMODE IS OFF");

		}	
	}

	@BeforeMethod(groups = { "Regression","Medium" })
	public void Inti( ) throws Exception {

		RecipientPage.goToDiagnostics();		
	}

	@AfterMethod(groups = { "Regression","Medium" })
	public void refresh( ) throws Exception {

		driver.navigate().refresh();
		Thread.sleep(5000);		
	}

	@AfterClass(groups = { "Regression","Medium" })

	public void Exit() {


		driver.close();


	}





}