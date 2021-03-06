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

/*
@Listeners({ ATUReportsListener.class, ConfigurationListener.class,
MethodListener.class })

*/
public class Recipients_ZOY1062_ValidateLoginScreenValidations extends LoadPropMac {
	 public RecipientPage RecipientPage;
	 public TestUtils Browser;	

	
	
		
	 @BeforeClass(groups = { "Regression","High" })	
    public void launchBrowser() throws Exception {
  
		  LoadBrowserProperties(); // Create driver instance and launch the browser
		  Elements_Recipients.Recipients_PageProperties();// loading UI Page Elements / Locators
		  RecipientPage = new RecipientPage(driver); // Loading Pages
		  Browser= new TestUtils(driver);        
		  	 
 } 

 
	 @DataProvider(name = "DP1")
		public String[][] createData1() {
			return new String[][] {
					{ "yes","testemail.com","Invalid email id","ganeshmandala@gmail.com","","Please enter your password.","ganeshmandala@gmail.com","12345","Incorrect password","ganeshmandala@gmail.com","Zoylo@123","Find a Doctor, Book Doctors Appointment Online in India - Zoylo" },
					{ "yes","","Please enter your email.","ganeshmandala@gmail.com","","Please enter your password.","testdata@gmail.com","12345","User not found","ganeshmandala@gmail.com","Zoylo@123","Find a Doctor, Book Doctors Appointment Online in India - Zoylo" }

			};
		}
	 @Test(dataProvider="DP1",groups = { "Regression","High" },priority=1)
	 public void validateLoginScreenValidationsWithInvalidSetOfData(String runmode,String InvalidEmail, String Emailvalidation,String ValidEmail,String BlankPassword,String PassswordValidation,String Username, String InvalidPassword,String ScreenValidation,String ValidUsername,String ValidPassword,String RecipientScreenTitle) throws Exception {
	  
		 if(runmode.equals("yes")){
			 //verifing email validation
			 RecipientPage.recipientLogin(InvalidEmail, BlankPassword);
			 String ActualemailValidation= driver.findElement(By.xpath("(//div[@class='login-error-msg'])[1]")).getText();
			 Assert.assertEquals(ActualemailValidation, Emailvalidation); 
            //verifing password validation
			 RecipientPage.recipientLogin(ValidEmail, BlankPassword);
			 String ActualPasswordValidation= driver.findElement(By.xpath("(//div[@class='login-error-msg'])[2]")).getText();
			 Assert.assertEquals(ActualPasswordValidation, PassswordValidation);
			 //verifing  Screen validations
			 RecipientPage.recipientLogin(Username, InvalidPassword);
			 Thread.sleep(2000);
			 String ActualScreenValidation= driver.findElement(By.cssSelector(Elements_Recipients.Recipient_Wrapper)).getText();
			 Assert.assertEquals(ActualScreenValidation, ScreenValidation);
 
		 }else{
			 
			throw new SkipException("RUNMODE IS OFF");
			
		 }
			
			
	    }
	 
	 @BeforeMethod(groups = { "Regression","High" })
	 public void openUrl() throws Exception {
		 //Test Starts-Here
		 Browser.openUrl("https://"+Environment_Name+".zoylo.com/login");

	    }

	 @Test(groups = { "Regression","High" },priority=2)
	 public void userLoginWithValidData() throws Exception {
 	
			 //Test Starts-Here
		     Browser.waitFortheID("emailAddress");
			 driver.findElement(By.id(Elements_Recipients.Recipient_UserName)).sendKeys(Recipient_Username);
			 driver.findElement(By.id(Elements_Recipients.Recipient_Password)).sendKeys(Recipient_Password);
			 driver.findElement(By.xpath(Elements_Recipients.Recipient_Button_Login)).click();
			// Browser.waitTill(60);
			 Browser.waitFortheElementXpath("//li[@id='myaccount']/span/img");
		     String ActualRecipientTitle = driver.getTitle();
			 Assert.assertEquals(ActualRecipientTitle, "Find a Doctor, Book Doctors Appointment Online in India - Zoylo");

	    }
	 
	 
	 
	 
	 @AfterClass(groups = { "Regression","High" })
		public void Exit() {
			
			driver.quit();
		} 
    
	

    
    
}