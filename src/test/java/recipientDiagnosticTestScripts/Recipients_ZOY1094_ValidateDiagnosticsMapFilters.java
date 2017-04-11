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
public class Recipients_ZOY1094_ValidateDiagnosticsMapFilters extends LoadProp {
	 public RecipientPage RecipientPage;
	 public TestUtils Browser;	

	
	
		
	 @BeforeClass(groups = { "Regression","High" })	
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
		  RecipientPage.goToDiagnostics();
		  	 
 } 

 

	 @Test(groups = { "Regression","High" },priority=1)
	 public void validateApplyFiltersOptions() throws Exception {

			RecipientPage.clickOnFilterImg();
			driver.findElement(By.linkText("Availability (0)")).click();
			driver.findElement(By.linkText("Test(0)")).click();
			driver.findElement(By.linkText("Package(0)")).click();
			driver.findElement(By.linkText("Home PickUp Sample(0)")).click();
			driver.findElement(By.linkText("Price(0)")).click();
			driver.findElement(By.linkText("Distance(0)")).click();
			driver.findElement(By.linkText("Ratings(0)")).click();
			
	    }
    
	 //
	 
	 @Test(groups = { "Regression","High" },priority=2)
	 public void validateApplyFiltersByTests() throws Exception {
	
			//Searching Locality/Area
			RecipientPage.searchInZoyloMAPArea("Miyapur");
			//Verify Specialization Filter Option
			RecipientPage.ApplyFilterInDiagnostics("Test","test", "Blood Test","searchDiagnosticTest");
			Thread.sleep(5000);
			Browser.waitFortheElementXpath("//*[@id='diagnosticDetails']");
			RecipientPage.bookAppointmentOnDiagnostics();
			Browser.waitFortheElementXpath("//*[@id='test-li']/a");
			driver.findElement(By.id("tests_search")).sendKeys("Blood Test");
			Thread.sleep(2000);
			String TestName=driver.findElement(By.xpath("(//div[contains(@class,'zy-rec-diag-s-apt-g-table-col')])[1]")).getText();
			Assert.assertEquals(TestName, "Blood Test");
	
	    }
	 
	 @Test(groups = { "Regression","High" },priority=3)
	 public void validateApplyFiltersByPackages() throws Exception {
		    RecipientPage.goToDiagnostics();
			//verifying Line of Practice
		    RecipientPage.clickOnFilterImg();
			//Reset
		    RecipientPage.ClearFilters();
			//SET Filter
			RecipientPage.clickOnFilterImg();
            RecipientPage.ApplyFilterInDiagnostics("Package","package","Zoylo Health Pkg","searchDiagnosticPackage");
            Browser.waitFortheElementXpath("//*[@id='diagnosticDetails']");
            RecipientPage.bookAppointmentOnDiagnostics();
			Browser.waitFortheElementXpath("//*[@id='package-li']/a");
			driver.findElement(By.id("packages_search")).sendKeys("Zoylo Health Pkg");
			Thread.sleep(2000);
			String PkgName=driver.findElement(By.xpath("(//div[contains(@class,'zy-rec-diag-s-apt-g-table-col')])[1]")).getText();
			Assert.assertEquals(PkgName, "Zoylo Health Pkg");
	
	    }
	 //
	
	 
	 @AfterClass(groups = { "Regression","High" })
	 
	 public void Exit() {

	       
	       driver.close();
	       
	      
	    }
    
	

    
    
}