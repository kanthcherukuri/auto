package recipientDiagnosticTestScripts;



import org.testng.annotations.AfterClass;
import org.testng.annotations.Test;
import org.testng.annotations.BeforeClass;
import org.testng.AssertJUnit;
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
public class Recipient_ZOY1399_ValidateDianosticsRebook extends LoadPropMac {
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
			 RecipientPage.recipientLogin(Recipient_DSusername, Recipient_DSpassword);
			 Thread.sleep(2000);
			 RecipientPage.goToMyAccounts("Appointments");
			 Thread.sleep(5000);// Added for view
			 driver.findElement(By.id("hist")).click();  // my History
			 Thread.sleep(2000);
			 driver.findElement(By.xpath("(//button[contains(text(),'Re-Book')])[1]")).click();
			 Thread.sleep(5000);
			 RecipientPage.selectAvailableSlotInDiagnostics("Sugar Test", "Zoylo Health Pkg");
			 RecipientPage.confirmAppointmentOnDiagnostics();
			 RecipientPage.makePayment(); 
			 String SuccessfullMesg = driver.findElement(By.xpath("//h5")).getText();
			 AssertJUnit.assertTrue(SuccessfullMesg.contains("Thank you for booking appointment"));
			 Browser.openUrl(recipient_url);
			 //driver.findElement(By.id("skipForLater")).click();
		     RecipientPage.recipientLogout();

			
	    }

	 @AfterClass(groups = { "Regression","High" })
	 
	 public void Exit() {

	       
	       driver.close();
	       
	      
	    }
    
	

    
    
}