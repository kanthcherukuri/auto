package recipientsTestScripts;



import org.testng.annotations.AfterClass;
import org.testng.annotations.Test;
import org.testng.annotations.BeforeClass;
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
public class Recipients_ZOY1180_ValidateRecipientRebookingOfAppointment extends LoadPropMac {
	 public RecipientPage RecipientPage;
	 public TestUtils Browser;	

	
	
		
	 @BeforeClass(groups = { "Regression","High" })	
    public void LaunchBrowser() throws Exception {
  
		  LoadBrowserProperties(); // Create driver instance and launch the browser
		  Elements_Recipients.Recipients_PageProperties();// loading UI Page Elements / Locators
		  RecipientPage = new RecipientPage(driver); // Loading Pages
		  Browser= new TestUtils(driver);        
		  	 
 } 

 
	 @Test(groups = { "Regression","High" })
	 public void validateRecipientRebookingOfAppointment() throws Exception {
	   			 
			 //Test Starts-Here
		     Browser.openUrl("https://"+Environment_Name+".zoylo.com/login");			
			 //Verify Recipient Login with valid details
			 RecipientPage.recipientLogin(Recipient_Username, Recipient_Password);
			 Browser.waitFortheElementXpath("//div[@class='pin bounce ']");
			 RecipientPage.goToMyAccounts("Appointments");
			 Browser.clickOnTheElementByID("hist");
			 Thread.sleep(1000);
			 Browser.scrollbyxpath("//div[@class='call-btn' and contains(.,'Re-Book')]");
			 Browser.clickOnTheElementByXpath("//div[@class='call-btn' and contains(.,'Re-Book')]");						 
			 RecipientPage.selectDefaultSlot();
			 RecipientPage.confirmAppointment("Fever");
			 RecipientPage.makePayment(); 
			 String SuccessfullMesg = Browser.getTextByXpath("//h5");
			 Assert.assertTrue(SuccessfullMesg.contains("Thank you for booking appointment"));

			
	    }

	 @AfterClass(groups = { "Regression","High" })
		public void Exit() {
			
			driver.quit();
		} 
    
	

    
    
}