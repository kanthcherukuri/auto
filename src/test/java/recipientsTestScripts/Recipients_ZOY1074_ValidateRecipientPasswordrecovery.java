package recipientsTestScripts;



import java.util.concurrent.TimeUnit;

import org.openqa.selenium.*;




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
public class Recipients_ZOY1074_ValidateRecipientPasswordrecovery extends LoadProp {
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
	 public void ValidateRecipientPasswordrecovery() throws Exception {
	  
		
			 			 
			 //Test Starts-Here
			 Browser.openUrl(recipient_url);			
		
			 driver.findElement(By.linkText("Forgot Password?")).click();
			 Browser.waitTill(10);
			 
		
			 }
			 
			
	
    
	
	 
	 
	 
	 
	 @AfterClass(groups = { "Regression","High" })
	 
	 public void Exit() {

	       
	       driver.close();
	       
	      
	    }
    
	

    
    
}