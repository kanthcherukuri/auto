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
public class Recipients_ZOY1067_ValidateRecipientAccountCreationValidations extends LoadProp {
	 public RecipientPage RecipientPage;
	 public TestUtils Browser;	

	
	
		
	 @BeforeClass(groups = { "Regression","High" })	
    public void LaunchBrowser() throws Exception {
  
		  LoadBrowserProperties(); // Create driver instance and launch the browser
		  Elements_Recipients.Recipients_PageProperties();// loading UI Page Elements / Locators
		  RecipientPage = new RecipientPage(driver); // Loading Pages
		  Browser= new TestUtils(driver);        
		  	 
 } 

 
	 @DataProvider(name = "DP1")
	    public Object[][] createData_DP1() throws Exception{
	        Object[][] retObjArr=TestUtils.getTableArray("TestData\\Recipients_TestData.xls","Login", "ZOY1067");
	        return(retObjArr);
	    }
	 @Test(dataProvider="DP1",groups = { "Regression","High" })
	 public void validateRecipientAccountCreationValidations(String runmode,String FullName, String FullNameValidation,String Email,String EmailValidation,String Password,String PasswordValidation, String ConfirmPassword,String ConfirmPasswordValidation,String Mobile,String MobileValidation,String RefCode,String ScreenValidationTab,String ScreenValidation) throws Exception {
	  
		 if(runmode.equals("yes")){
			 			 
			 //Test Starts-Here
			 Browser.openUrl(recipient_url);			
		
			 driver.findElement(By.linkText("Don't have an account?")).click();
			 Browser.waitTill(10);
			 driver.findElement(By.id("fullName")).sendKeys(FullName);
			 driver.findElement(By.id("emailAddress")).sendKeys(Email);
			 driver.findElement(By.id("mobileNumber")).sendKeys(Mobile);
			 driver.findElement(By.id("password")).sendKeys(Password);
			 driver.findElement(By.id("confirm_password")).sendKeys(ConfirmPassword);
			 driver.findElement(By.id("referralCode")).sendKeys(RefCode);
			 driver.findElement(By.xpath("//button[text()='Sign Up']")).click();
			 Thread.sleep(5000);
			 
			 //Validation Of Full Name
			 String ActualFullNameValidattion =driver.findElement(By.xpath("(//div[@class='signup-error-msg'])[1]")).getText();		 
			 Assert.assertEquals(ActualFullNameValidattion, FullNameValidation);
			//Validation Of Email
			 String ActualEmailValidattion =driver.findElement(By.xpath("(//div[@class='signup-error-msg'])[2]")).getText();		 
			 Assert.assertEquals(ActualEmailValidattion, EmailValidation);
			//Validation Of Mobile
			 String ActualMobileValidattion =driver.findElement(By.xpath("//div[@class='signup-error-msg mn']")).getText();		 
			 Assert.assertEquals(ActualMobileValidattion, MobileValidation);
			//Validation Of Password
			 String ActualPasswordValidattion =driver.findElement(By.xpath("(//div[@class='signup-error-msg signup-error-msg-bottom'])[1]")).getText();		 
			 Assert.assertEquals(ActualPasswordValidattion, PasswordValidation);
			//Validation Of confirm Password
			 String ActualConfirmPasswordValidattion =driver.findElement(By.xpath("(//div[@class='signup-error-msg signup-error-msg-bottom'])[2]")).getText();		 
			 Assert.assertEquals(ActualConfirmPasswordValidattion, ConfirmPasswordValidation);
			//Verifying screen validation			 
			 if (ScreenValidationTab.equals("yes")){
				String ActualscreenValidattion =driver.findElement(By.cssSelector(Elements_Recipients.Recipient_Wrapper)).getText();		 
			    Assert.assertEquals(ActualscreenValidattion, ScreenValidation);
			 }
			 
			
			 
			 
		 }else{
			 
			throw new SkipException("RUNMODE IS OFF");
			
		 }
			
			
	    }
    
	
	 
	 
	 
	 
	 @AfterClass(groups = { "Regression","High" })
	 
	 public void Exit() {

	       
	       driver.close();
	       
	      
	    }
    
	

    
    
}