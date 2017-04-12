package recipientsTestScripts;



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
		  Browser.openUrl(recipient_url);			
	      //Verify Recipient Login with valid details
		  RecipientPage.recipientLogin(Recipient_Username, Recipient_Password);
		  Thread.sleep(2000);
		  	 
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
    
	 //
	 
	 @Test(groups = { "Regression","High" },priority=2)
	 public void validateApplyFiltersBySpecilization() throws Exception {
	
			//Searching Locality/Area
			RecipientPage.searchInZoyloMAPArea("Miyapur");
			//Verify Specialization Filter Option
			RecipientPage.ApplyFilter("Specialization","specialization", "Ayurveda");
			Thread.sleep(5000);
			Browser.waitFortheElementXpath("//div[@class='dctr-desig']");
			String Doctor_designation=driver.findElement(By.xpath("//div[@class='dctr-desig']")).getText();
			Assert.assertEquals(Doctor_designation, "Ayurveda");
	
	    }
	 
	 @Test(groups = { "Regression","High" },priority=3)
	 public void validateApplyFiltersByLineOfPractice() throws Exception {

			//verifying Line of Practice
		    RecipientPage.clickOnFilterImg();
			//Reset
		    RecipientPage.ClearFilters();
			//SET Filter
			RecipientPage.clickOnFilterImg();
            RecipientPage.ApplyFilter("Line Of Practices","lineOfPractice","Homeopathy");
        	Browser.waitFortheElementXpath("//div[@class='dctr-desig']");
			String LOP_designation=driver.findElement(By.xpath("//div[@class='dctr-desig']")).getText();
			Assert.assertEquals(LOP_designation, "Homeopathy");
	
	    }
	 //
	 @Test(groups = { "Regression","High" },priority=4)
	 public void validateApplyFiltersByFee( ) throws Exception {

			RecipientPage.clickOnFilterImg();
			driver.findElement(By.xpath("//span[contains(.,'Fee')]")).click();
			Thread.sleep(5000);
			driver.findElement(By.xpath("//input[@data-start='300' and @data-end='500']")).click();
			driver.findElement(By.id("applyFilter")).click();
			Thread.sleep(5000);		
        	Browser.waitFortheElementXpath("//div[@class='consultFee']");
        	
			String Fee_Value=driver.findElement(By.xpath("//div[@class='consultFee']")).getText();
			System.out.println("String Fee value is"+Fee_Value);
			int FinalFeeValue = Integer.parseInt(Fee_Value);
			if (FinalFeeValue >= 300 && FinalFeeValue < 500) {
			    System.out.println("Fee value is"+FinalFeeValue);
			}
			else  {
			   Assert.fail("Value is not between Fee");
			}
	
	    }
	 
	 @AfterClass(groups = { "Regression","High" })
	 
	 public void Exit() {

	       
	       driver.close();
	       
	      
	    }
    
	

    
    
}