package recipientsTestScripts;



import org.testng.annotations.AfterClass;
import org.testng.annotations.Test;
import org.testng.annotations.BeforeClass;
import org.testng.Assert;
import org.testng.Assert;
import org.openqa.selenium.*;
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
public class Recipients_ZOY1066_ValidateMapFilters extends LoadPropMac {
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
		  RecipientPage.searchInZoyloMAPArea("Miyapur");
 } 


	// @Test(groups = { "Regression","High" },priority=1)
	 public void validateApplyFiltersOptions() throws Exception {

			RecipientPage.clickOnFilterImg();
			driver.findElement(By.xpath("//span[contains(.,'Specialization')]")).click();
			driver.findElement(By.linkText("Gender (0)")).click();
			driver.findElement(By.linkText("Home Visits (0)")).click();
			driver.findElement(By.linkText("Line Of Practices (0)")).click();
			driver.findElement(By.linkText("Availability (0)")).click();
			driver.findElement(By.linkText("Fee (0)")).click();
			
	    }
    
	 //
	 
	// @Test(groups = { "Regression","High" },priority=2)
	 public void validateApplyFiltersBySpecilization() throws Exception {
	
			//Searching Locality/Area
			//RecipientPage.searchInZoyloMAPArea("Miyapur");
			//Verify Specialization Filter Option
			RecipientPage.ApplyFilter("Specialization","specialization", "Cardiology","searchSpecialization");
			//Thread.sleep(5000);
			Browser.waitFortheElementXpath("//div[@class='dctr-desig']");
			String Doctor_designation=driver.findElement(By.xpath("//div[@class='dctr-desig']")).getText();
			Assert.assertTrue(Doctor_designation.contains("Cardiology"));
	
	    }
	 
	// @Test(groups = { "Regression","High" },priority=3)
	 public void validateApplylineOfPractice() throws Exception {

			//verifying Line of Practice
		    RecipientPage.clickOnFilterImg();
			//Reset
		    RecipientPage.ClearFilters();
			//SET Filter
			RecipientPage.clickOnFilterImg();
            RecipientPage.ApplyFilter("Line Of Practices","lineOfPractice ","Homeopathy","searchPractices");
        	Browser.waitFortheElementXpath("//div[@class='dctr-desig']");
			String LOP_designation=driver.findElement(By.xpath("//div[@class='dctr-desig']")).getText();
			Assert.assertEquals(LOP_designation, "Skin");
	
	    }
	 //
	 @Test(groups = { "Regression","High" },priority=4)
	 public void validateApplyFiltersByFee( ) throws Exception {

			RecipientPage.clickOnFilterImg();
			driver.findElement(By.xpath("//span[contains(.,'Fee')]")).click();
			// Between 300 to 500
			driver.findElement(By.xpath("//div[@id='500']/span")).click();
			driver.findElement(By.id("applyFilter")).click();
			//Thread.sleep(5000);		
        	Browser.waitFortheElementXpath("//div[@class='consultFee']");
        	
			String Fee_Value=driver.findElement(By.xpath("//div[@class='consultFee']")).getText();
			System.out.println("String Fee value is"+Fee_Value);
			int FinalFeeValue = Integer.parseInt(Fee_Value.replaceAll(" ",""));
			System.out.println("FinalFeeValue="+FinalFeeValue);
			if (FinalFeeValue >= 300 && FinalFeeValue <= 500) {
			    System.out.println("Fee value is"+FinalFeeValue);
			}
			else  {
			   Assert.fail("Value is not between Fee");
			}
	
	    }
	 
	 @Test(groups = { "Regression","High" },priority=5)
	 public void validateApplyFiltersWithinvalidData() throws Exception {

		    RecipientPage.clickOnFilterImg();
			//Reset
		    RecipientPage.ClearFilters();
			//SET Filter
			RecipientPage.clickOnFilterImg();
			RecipientPage.searchInZoyloMAPArea("Miyapur");
			//Verify Specialization Filter Option
			RecipientPage.ApplyFilter("Specialization","specialization", "Trichology","searchSpecialization");
			Thread.sleep(5000);
			String NoDataFound=driver.findElement(By.xpath("//ul[@class='rec-doctorslist rec-doc-list search-result-wrapper']/span")).getText();
			Assert.assertEquals(NoDataFound, "NO results found within 15 kms of range.");
	
	    }
	 
	 @Test(groups = { "Regression","High" },priority=6)
	 public void validateClearFiltersHyperLinkInMapSearch() throws Exception {

		    RecipientPage.clickOnFilterImg();
			//Reset
		    RecipientPage.ClearFilters();
			//SET Filter
			RecipientPage.clickOnFilterImg();
			
			//Verify Specialization Filter Option
			RecipientPage.ApplyFilter("Specialization","specialization", "Cardiology","searchSpecialization");
			Thread.sleep(5000);
			//Verify with Invalid data
			driver.findElement(By.id("searchFilter")).click();
			driver.findElement(By.id("listingSearchTextbox")).sendKeys("xx");
			Browser.waitFortheElementXpath("(//*[@id='clearFilter'])[2]");
			driver.findElement(By.xpath("(//*[@id='clearFilter'])[2]")).click();
			//get filter count and make sure filter count is 0 after clearing the filter
			String FilterCount=driver.findElement(By.xpath("//span[@class='zy-filtercount']")).getText();
			Assert.assertEquals(FilterCount, "0");
			
	    }
	 
	 @AfterClass(groups = { "Regression","High" })
		public void Exit() {
			
			driver.quit();
		} 
    
	

    
    
}