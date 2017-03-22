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
		
			 //verifing email validation
			 driver.findElement(By.id("forgotPassword")).click();
			 Browser.waitTill(10);
			 driver.findElement(By.id("resetPassword")).click();
			 String emialMandatory=driver.findElement(By.id("email-err")).getText();
			 Assert.assertEquals(emialMandatory, "Email or Mobile field is mandatory");
			 
			 //verifying Email with valid data
			 driver.findElement(By.id("mobileOrEmail")).sendKeys("ganeshmandala@gmail.com");
			 driver.findElement(By.id("resetPassword")).click();
			 Browser.waitTill(10);
			//verifying OTP with in valid data
			 driver.findElement(By.id("entered-otp")).sendKeys("1234");
			 driver.findElement(By.id("verify")).click();
			 Thread.sleep(2000);
			 String OtpInvalid=driver.findElement(By.cssSelector(Elements_Recipients.Recipient_Wrapper)).getText();
			 Assert.assertEquals(OtpInvalid, "OTP is Invalid, enter a correct one or try resend option");
			 
		
			 }
			 
			
	
    
	
	 
	 
	 
	 
	 @AfterClass(groups = { "Regression","High" })
	 
	 public void Exit() {

	       
	       driver.close();
	       
	      
	    }
    
	

    
    
}