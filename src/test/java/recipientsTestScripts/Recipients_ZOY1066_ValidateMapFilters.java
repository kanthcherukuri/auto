package recipientsTestScripts;



import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.Test;
import org.testng.annotations.BeforeClass;
import org.testng.Assert;
import org.testng.Assert;
import org.openqa.selenium.*;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

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
	 @Test(groups = { "Regression","High" },priority=1)
	 public void validateApplyFiltersOptions() throws Exception {
			RecipientPage.clickOnFilterImg();
			driver.findElement(By.xpath("//span[contains(.,'Specialization')]")).click();
			driver.findElement(By.linkText("Gender (0)")).click();
			driver.findElement(By.linkText("Home Visits (0)")).click();
			driver.findElement(By.linkText("Line Of Practices (0)")).click();
			driver.findElement(By.linkText("Availability (0)")).click();
			driver.findElement(By.linkText("Fee (0)")).click();
			
	    }
    
	 
	 @Test(groups = { "Regression","High" },priority=2)
	 public void validateAvailabilityFilter() throws Exception {

		    //verifying Home Visit Filter
		    RecipientPage.clickOnFilterImg();
		    driver.findElement(By.xpath("//span[contains(.,'Availability')]")).click();
		    Browser.clickOnTheElementByID("Sunday");
		    Browser.clickOnTheElementByID("applyFilter");
     	    Browser.clickOnTheElementByXpath("//div[@class='dctr-desig']");
     	    Browser.clickOnTheElementByXpath("//div[@class='day-title' and contains(text(),'Sunday')]");
			Browser.clickOnTheElementByXpath("//li[@id='apponitmentTime' and @class='sp-available-slots']");
			
	
	    }
	

	
	 //
	 @AfterMethod
	 public void AfterFiters() throws Exception {
		 Browser.openUrl(index_url);
		 Thread.sleep(3000);
		 WebDriverWait wait = (new WebDriverWait(driver, 60));
		 wait.until(ExpectedConditions.invisibilityOfElementLocated(By.xpath("//html/body/div[8]/div/img")));
		
	    }
	 
	 @Test(groups = { "Regression","High" },priority=3)
	 public void validateApplyFiltersBySpecilization() throws Exception {

			//Verify Specialization Filter Option
		    RecipientPage.clickOnFilterImg();
			RecipientPage.ApplyFilter("Specialization","specialization", "Cardiology","searchSpecialization");
			//Thread.sleep(5000);
			Browser.waitFortheElementXpath("//div[@class='dctr-desig']");
			String Doctor_designation=driver.findElement(By.xpath("//div[@class='dctr-desig']")).getText();
			Assert.assertTrue(Doctor_designation.contains("Cardiology"));
	
	    }
	 
	 @Test(groups = { "Regression","High" },priority=4)
	 public void validateApplylineOfPractice() throws Exception {

			//verifying Line of Practice
		    RecipientPage.clickOnFilterImg();
            RecipientPage.ApplyFilter("Line Of Practices","lineOfPractice","Homeopathy","searchPractices");
        	Browser.waitFortheElementXpath("//div[@class='dctr-desig']");
			String LOP_designation=driver.findElement(By.xpath("//div[@class='dctr-desig']")).getText();
			Assert.assertEquals(LOP_designation, "Homeopathy");
	
	    }
	 
	 @Test(groups = { "Regression","High" },priority=5)
	 public void validateHomeVisitFilter() throws Exception {

		    //verifying Home Visit Filter
		    RecipientPage.clickOnFilterImg();
		    driver.findElement(By.xpath("//span[contains(.,'Home Visits')]")).click();
		    Browser.clickOnTheElementByID("doesHouseCalls");
		    Browser.clickOnTheElementByID("applyFilter");
     	    Browser.clickOnTheElementByXpath("//div[@class='dctr-desig']");
			Boolean HomeVisitExisit=driver.findElements(By.xpath("//*[@id='myclinics-section']//span/strike")).isEmpty();
			Assert.assertTrue(HomeVisitExisit);
			
	
	    }
	 
	 //
	 @Test(groups = { "Regression","High" },priority=6)
	 public void validateApplyFiltersByFee( ) throws Exception {

			RecipientPage.clickOnFilterImg();
			driver.findElement(By.xpath("//span[contains(.,'Fee')]")).click();
			// Between 300 to 500
			Browser.clickOnTheElementByID("500");
			driver.findElement(By.id("applyFilter")).click();
			String Fee_Value=Browser.getTextByXpath("//div[@class='consultFee']");			
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
	 
	@Test(groups = { "Regression","High" },priority=7)
	 public void validateApplyFiltersWithinvalidData() throws Exception {

		    RecipientPage.clickOnFilterImg();

			RecipientPage.ApplyFilter("Specialization","specialization", "Trichology","searchSpecialization");
			Thread.sleep(5000);
			String NoDataFound=driver.findElement(By.xpath("//ul[@class='rec-doctorslist rec-doc-list search-result-wrapper']/span")).getText();
			Assert.assertEquals(NoDataFound, "Oops your Search did not match any records. Why don't you try searching after clearing the filter. ... Clear Filter");
	
	    }
	 
	 @Test(groups = { "Regression","High" },priority=8)
	 public void validateClearFiltersHyperLinkInMapSearch() throws Exception {

		    RecipientPage.clickOnFilterImg();
			
			//Verify Specialization Filter Option
			RecipientPage.ApplyFilter("Specialization","specialization", "Cardiology","searchSpecialization");
			Thread.sleep(5000);
			//Verify with Invalid data
			driver.findElement(By.id("searchFilter")).click();
			driver.findElement(By.id("listingSearchTextbox")).sendKeys("xx12345");
			Browser.waitFortheElementXpath("(//*[@id='clearFilter'])[2]");
			driver.findElement(By.xpath("(//*[@id='clearFilter'])[3]")).click();
			//get filter count and make sure filter count is 0 after clearing the filter
			String FilterCount=driver.findElement(By.xpath("//span[@class='zy-filtercount']")).getText();
			Assert.assertEquals(FilterCount, "0");
			
	    }
	 
	 @AfterClass(groups = { "Regression","High" })
		public void Exit() {
			
			driver.quit();
		} 
    
	

    
    
}