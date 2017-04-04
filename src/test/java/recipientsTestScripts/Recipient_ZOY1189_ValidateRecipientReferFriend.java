package recipientsTestScripts;




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
public class Recipient_ZOY1189_ValidateRecipientReferFriend extends LoadProp {
	 public RecipientPage RecipientPage;
	 public TestUtils Browser;	

	
	
		
	 @BeforeClass(groups = { "Regression","High" })	
    public void LaunchBrowser() throws Exception {
  
		  LoadBrowserProperties(); // Create driver instance and launch the browser
		  Elements_Recipients.Recipients_PageProperties();// loading UI Page Elements / Locators
		  RecipientPage = new RecipientPage(driver); // Loading Pages
		  Browser= new TestUtils(driver);  
		
		  	 
 } 

 

	 @Test(groups = { "Regression","Medium" })
	 public void validateRecipientReferFriend() throws Exception {
	  
		
			 			 
		  Browser.openUrl(recipient_url);			
	      //Verify Recipient Login with valid details
		  RecipientPage.recipientLogin(Recipient_Username, Recipient_Password);
		  Thread.sleep(2000);
		  RecipientPage.goToMyAccount();
		  driver.findElement(By.xpath("//*[@id='tabs']/li[contains(.,'Refer')]")).click();
		  Thread.sleep(2000);
		 //verify field validations
		  driver.findElement(By.id("btnRefer")).click();
		  driver.findElement(By.id("refereeMobileNumber")).sendKeys("");
		  driver.findElement(By.id("refereeEmail")).sendKeys("");
		  driver.findElement(By.id("sendRefer")).click();
		  String fld_Validation=driver.findElement(By.xpath("//*[@id='referfrnds']//span")).getText();
		  Assert.assertEquals(fld_Validation, "Mobile number or Email is required");
		  
		  //verify Mobile
		  driver.findElement(By.id("btnRefer")).click();
		  driver.findElement(By.id("refereeMobileNumber")).sendKeys("9912345070");
		  driver.findElement(By.id("sendRefer")).click();
		  String phone_code_mesg=driver.findElement(By.cssSelector(Elements_Recipients.Recipient_Wrapper)).getText();
		  Assert.assertEquals(phone_code_mesg, "Referral Code send successfully");
		  
		  //verify Mobile
		  driver.findElement(By.id("btnRefer")).click();
		  driver.findElement(By.id("refereeEmail")).sendKeys("ganesh@in.com");
		  driver.findElement(By.id("sendRefer")).click();
		  String Email_code_mesg=driver.findElement(By.cssSelector(Elements_Recipients.Recipient_Wrapper)).getText();
		  Assert.assertEquals(Email_code_mesg, "Referral Code send successfully");
		  RecipientPage.recipientLogout();
		  Reporter.log("Logged out Successfully");
			 
		
			 }
			 
			
	
    
	
	 
	 
	 
	 
	 @AfterClass(groups = { "Regression","High" })
	 
	 public void Exit() {

	       
	       driver.close();
	       
	      
	    }
    
	

    
    
}