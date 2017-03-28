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
public class Recipients_ZOY1176_ValidateRecipientsPasswordChange extends LoadProp {
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
	        Object[][] retObjArr=TestUtils.getTableArray("TestData\\Recipients_TestData.xls","Doctor", "ZOY1176");
	        return(retObjArr);
	    }
	 @Test(dataProvider="DP1",groups = { "Regression","High" })
	 public void ValidatePasswordChange(String runmode,String username,String password,String currentPassword,String newPassword,String confirmPassword,String notifiMesg,String newPasswordMesg,String confirmPasswordMesg) throws Exception {
	  
		if(runmode.equals("yes")) {
			 			 
		  Browser.openUrl(recipient_url);			
	      //Verify Recipient Login with valid details
		  RecipientPage.recipientLogin(username, password);
		  Thread.sleep(2000);
		  RecipientPage.goToMyAccount();
		  driver.findElement(By.xpath("//*[@id='tabs']/li[contains(.,'Change Password')]")).click();
		  Thread.sleep(2000);
		  driver.findElement(By.id("currentPassword")).sendKeys(currentPassword);
		  driver.findElement(By.id("newPassword")).sendKeys(newPassword);
		  driver.findElement(By.id("confirmPassword")).sendKeys(confirmPassword);
		  
		  driver.findElement(By.id("changePassword")).click();
		  Thread.sleep(2000);
		  //Verify new password validation
		  String ActualnewPassMesg=driver.findElement(By.xpath("(//div[@class='change-pwd-fields'])[2]/span[2]")).getText();
		  Assert.assertEquals(ActualnewPassMesg, newPasswordMesg);
		  //Verify confirm password validation
		  String ActualconfirmPassMesg=driver.findElement(By.xpath("(//div[@class='change-pwd-fields'])[3]/span[2]")).getText();
		  Assert.assertEquals(ActualconfirmPassMesg, confirmPasswordMesg);
		//Verify Notification validation
		  if(notifiMesg.isEmpty()){
			 System.out.println("notifi is empty");
		  }else{
			  System.out.println("notifi is true");
			  String NotificationMesg=driver.findElement(By.cssSelector(Elements_Recipients.Recipient_Wrapper)).getText();
			  Assert.assertEquals(NotificationMesg, notifiMesg);
				  
		  }
		  
		  
		  RecipientPage.recipientLogout();
		  Reporter.log("Logged out Successfully");
			 
		
			 }
		
		else{
			 
			throw new SkipException("RUNMODE IS OFF");
			
		 }
			 
	 }
	
    
	
	 
	 
	 
	 
	 @AfterClass(groups = { "Regression","High" })
	 
	 public void Exit() {

	       
	       driver.close();
	       
	      
	    }
    
	

    
    
}