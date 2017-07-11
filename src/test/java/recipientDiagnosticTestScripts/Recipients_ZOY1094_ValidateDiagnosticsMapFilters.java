package recipientDiagnosticTestScripts;



import org.testng.Assert;
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
public class Recipients_ZOY1094_ValidateDiagnosticsMapFilters extends LoadPropMac {
	 public RecipientPage RecipientPage;
	 public TestUtils Browser;	

	
	
		
	 @BeforeClass(groups = { "Regression","High" })	
    public void LaunchBrowser() throws Exception {
  
		  LoadBrowserProperties(); // Create driver instance and launch the browser
		  Elements_Recipients.Recipients_PageProperties();// loading UI Page Elements / Locators
		  RecipientPage = new RecipientPage(driver); // Loading Pages
		  Browser= new TestUtils(driver);   
		  //Test Starts-Here
		  Browser.openUrl(index_url);			
		  RecipientPage.goToDiagnostics();
		  RecipientPage.searchInZoyloMAPArea("Miyapur");
		  	 
 } 

	 @AfterMethod
	 public void AfterFiters() throws Exception {

		  Browser.openUrl(index_url);			
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
			//driver.findElement(By.linkText("Ratings(0)")).click();
			
	    }

	 @Test(groups = { "Regression","High" },priority=2)
	 public void validateApplyFiltersByTests() throws Exception {

			//Verify Specialization Filter Option
		    RecipientPage.clickOnFilterImg();
			RecipientPage.ApplyFilterInDiagnostics("Test","test", "Vitamins D3","searchDiagnosticTest");
			Thread.sleep(5000);
			Browser.waitFortheElementXpath("//*[@id='diagnosticDetails']");
			RecipientPage.bookAppointmentOnDiagnostics();
			Browser.waitFortheElementXpath("//*[@id='test-li']/a");
			driver.findElement(By.id("tests_search")).sendKeys("Vitamins D3");
			Thread.sleep(2000);
			String TestName=driver.findElement(By.xpath("(//div[contains(@class,'zy-rec-diag-s-apt-g-table-col')])[1]")).getText();
			Assert.assertEquals(TestName, "Vitamins D3");
			Browser.clickOnTheElementByID("backArrow");
	
	    }
	 
	 @Test(groups = { "Regression","High" },priority=3)
	 public void validateApplyFiltersByPackages() throws Exception {
		    
			RecipientPage.clickOnFilterImg();
            RecipientPage.ApplyFilterInDiagnostics("Package","package","Zoylo Health Pkg","searchDiagnosticPackage");
            Browser.waitFortheElementXpath("//*[@id='diagnosticDetails']");
            RecipientPage.bookAppointmentOnDiagnostics();
			Browser.waitFortheElementXpath("//*[@id='package-li']/a");
			driver.findElement(By.xpath("//*[@id='package-li']/a")).click();
			driver.findElement(By.id("packages_search")).sendKeys("Zoylo Health Pkg");
			Thread.sleep(2000);
			String PkgName=driver.findElement(By.xpath("//div[@class='zy-rec-diag-s-apt-g-table-col' and contains(.,'Zoylo Health Pkg')]")).getText();
			Assert.assertEquals(PkgName, "Zoylo Health Pkg");
			Browser.clickOnTheElementByID("backArrow");
	
	    }
	 //
	 @Test(groups = { "Regression","High" },priority=6)
	 public void validateClearFiltersHyperLinkInMapSearch() throws Exception {

			//Verify Specialization Filter Option
		    RecipientPage.clickOnFilterImg();
			RecipientPage.ApplyFilterInDiagnostics("Package","package","Zoylo Health Pkg","searchDiagnosticPackage");
			Thread.sleep(5000);
			//Verify with Invalid data
			driver.findElement(By.id("searchFilter")).click();
			driver.findElement(By.id("listingSearchTextbox")).sendKeys("sdf12345df");
			Browser.clickOnTheElementByXpath("(//*[@id='clearFilter'])[3]");
			//get filter count and make sure filter count is 0 after clearing the filter
			String FilterCount=driver.findElement(By.xpath("//span[@class='zy-filtercount']")).getText();
			Assert.assertEquals(FilterCount, "0");
			
	    }
	
	 
	 @AfterClass(groups = { "Regression","High" })
	 
	 public void Exit() {

		 driver.quit();
	      
	    }
    
	

    
    
}