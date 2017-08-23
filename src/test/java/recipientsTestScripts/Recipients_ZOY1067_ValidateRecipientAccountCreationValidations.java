package recipientsTestScripts;


import org.testng.annotations.AfterClass;
import org.testng.annotations.Test;
import org.testng.annotations.BeforeClass;
import org.testng.Assert;
import org.openqa.selenium.*;
import org.testng.SkipException;
import org.testng.annotations.*;
/*
import atu.testng.reports.listeners.ATUReportsListener;
import atu.testng.reports.listeners.ConfigurationListener;
import atu.testng.reports.listeners.MethodListener;
*/
import testBase.*;
import objectRepository.*;


public class Recipients_ZOY1067_ValidateRecipientAccountCreationValidations extends LoadPropMac {
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
		public String[][] createData1() {
			return new String[][] {
					{ "yes","test","Enter only alphabets of minimum 5 characters","zyz@gmail.com","","Zoylo@123","","Zoylo@123","","9912345070","","123","no",""},
					{ "yes","testName","","zyz@gmail","Invalid email id","Zoylo@123","","Zoylo@123","","9912345070","","123","no",""},
					{ "yes","testName","","zyz@gmail.com","","Zoylo@123","","Zoylo@123","","ab123","Phone number should only have numeric value","123","no",""},
					{ "yes","testName","","zyz@gmail.com","","Zoylo@123","","Zoylo@123","","99123","Mobile number should contains 10 digits","123","no",""},
					{ "yes","testName","","ganeshmandala@gmail.com","","Zoylo@123","","Zoylo@123","","9912345070","","123","yes","This email id is already registered"},
					{ "yes","testName","","zyz@gmail.com","","Zoylo@123","","Zoylo@123","","9912345070","","123","yes","Mobile Number +919912345070 is already in use with Zoylo App"},
			};
		}
	 @DataProvider(name = "DP2")
		public String[][] createData2() {
			return new String[][] {
					{ "yes","","Full name is mandatory","","Email address is mandatory","","Password is mandatory","","Confirm password is mandatory","","Number is mandatory","123","no",""},
					
			};
		}
	 @Test(dataProvider="DP1",groups = { "Regression","High" })
	 public void validateRecipientAccountCreationValidations(String runmode,String FullName, String FullNameValidation,String Email,String EmailValidation,String Password,String PasswordValidation, String ConfirmPassword,String ConfirmPasswordValidation,String Mobile,String MobileValidation,String RefCode,String ScreenValidationTab,String ScreenValidation) throws Exception {
	  
		 if(runmode.equals("yes")){
			 			 
			 //Test Starts-Here
			 Browser.openUrl("https://"+Environment_Name+".zoylo.com/login");
		
			 driver.findElement(By.linkText("Don't have an account?")).click();
			 Browser.waitTill(10);
			 driver.findElement(By.id("fullName")).sendKeys(FullName);
			 driver.findElement(By.id("emailAddress")).sendKeys(Email);
			 driver.findElement(By.id("mobileNumber")).sendKeys(Mobile);
			 driver.findElement(By.id("password")).sendKeys(Password);
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
			 String ActualPasswordValidattion =driver.findElement(By.xpath("//div[@class='signup-error-msg signup-error-msg-bottom']")).getText();		 
			 Assert.assertEquals(ActualPasswordValidattion, PasswordValidation);
			//Verifying screen validation			 
			 if (ScreenValidationTab.equals("yes")){
				String ActualscreenValidattion =driver.findElement(By.cssSelector(Elements_Recipients.Recipient_Wrapper)).getText();		 
			    Assert.assertEquals(ActualscreenValidattion, ScreenValidation);
			 }
			 
			
			 
			 
		 }else{
			 
			throw new SkipException("RUNMODE IS OFF");
			
		 }
			
			
	    }
	 
	 @Test(dataProvider="DP2",groups = { "Regression","High" })
	 public void validateRecipientAccountCreationValidations2(String runmode,String FullName, String FullNameValidation,String Email,String EmailValidation,String Password,String PasswordValidation, String ConfirmPassword,String ConfirmPasswordValidation,String Mobile,String MobileValidation,String RefCode,String ScreenValidationTab,String ScreenValidation) throws Exception {
	  
		 if(runmode.equals("yes")){
			 			 
			 //Test Starts-Here
			 Browser.openUrl("https://"+Environment_Name+".zoylo.com/login");
		
			 driver.findElement(By.linkText("Don't have an account?")).click();
			 Browser.waitTill(10);
			 driver.findElement(By.id("fullName")).sendKeys(FullName);
			 driver.findElement(By.id("emailAddress")).sendKeys(Email);
			 driver.findElement(By.id("mobileNumber")).sendKeys(Mobile);
			 driver.findElement(By.id("password")).sendKeys(Password);
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
			 String ActualPasswordValidattion =driver.findElement(By.xpath("//*[@id='passEmpty']")).getText();		 
			 Assert.assertEquals(ActualPasswordValidattion, PasswordValidation);
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
			
			driver.quit();
		} 
    
	

    
    
}