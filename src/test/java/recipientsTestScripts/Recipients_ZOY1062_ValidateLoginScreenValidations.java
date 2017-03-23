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
public class Recipients_ZOY1062_ValidateLoginScreenValidations extends LoadProp {
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
	        Object[][] retObjArr=TestUtils.getTableArray("TestData\\Recipients_TestData.xls","Login", "ZOY1062");
	        return(retObjArr);
	    }
	 @Test(dataProvider="DP1",groups = { "Regression","High" })
	 public void ValidateDoctorEnrollment(String runmode,String InvalidEmail, String Emailvalidation,String ValidEmail,String BlankPassword,String PassswordValidation,String Username, String InvalidPassword,String ScreenValidation,String ValidUsername,String ValidPassword,String RecipientScreenTitle) throws Exception {
	  
		 if(runmode.equals("yes")){
			 			 
			 //Test Starts-Here
			 Browser.openUrl(recipient_url);			
		
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
			  
			 
			 //Verify Recipient Login with valid details
			 
			 RecipientPage.recipientLogin(ValidUsername, ValidPassword);
			 Thread.sleep(2000);
		     String ActualRecipientTitle = driver.getTitle();
			 Assert.assertEquals(ActualRecipientTitle, RecipientScreenTitle);
		     
		     //Logout from Recipient
		     
		     RecipientPage.recipientLogout();
	
			 
		 }else{
			 
			throw new SkipException("RUNMODE IS OFF");
			
		 }
			
			
	    }
    
	 
	 
	 
	 
	 
	 @AfterClass(groups = { "Regression","High" })
	 
	 public void Exit() {

	       
	       driver.close();
	       
	      
	    }
    
	

    
    
}