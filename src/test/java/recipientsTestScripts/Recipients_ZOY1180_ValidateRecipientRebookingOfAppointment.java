package recipientsTestScripts;



import org.openqa.selenium.*;
import org.testng.Assert;
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
			 Browser.openUrl(recipient_url);			
			 //Verify Recipient Login with valid details
			 RecipientPage.recipientLogin(Recipient_Username, Recipient_Password);
			 Thread.sleep(2000);
			 RecipientPage.goToMyAccounts("Appointments");
			 Thread.sleep(5000);// Added for view
			 driver.findElement(By.id("hist")).click();  // my History
			 Thread.sleep(5000);
			 driver.findElement(By.cssSelector("a.callLink > div.call-btn")).click();
			 Thread.sleep(5000);
			 RecipientPage.selectDefaultSlot();
			 RecipientPage.confirmAppointment("Fever");
			 RecipientPage.makePayment(); 
			 String SuccessfullMesg = driver.findElement(By.xpath("//h5")).getText();
			 Assert.assertTrue(SuccessfullMesg.contains("Thank you for booking appointment"));
			 Browser.openUrl(recipient_url);
		     RecipientPage.recipientLogout();

			
	    }

	 @AfterClass(groups = { "Regression","High" })
	 
	 public void Exit() {

	       
	       driver.close();
	       
	      
	    }
    
	

    
    
}