package recipientsTestScripts;



import org.testng.annotations.AfterClass;
import org.testng.annotations.Test;
import org.testng.annotations.BeforeClass;
import org.testng.AssertJUnit;
import org.openqa.selenium.*;
import org.testng.Assert;
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
public class Recipients_ZOY1188_ValidateBookingAnInActiveDoctor extends LoadPropMac {
	 public RecipientPage RecipientPage;
	 public TestUtils Browser;	

	 @BeforeClass(groups = { "Regression","High" })	
    public void launchBrowser() throws Exception {
  
		  LoadBrowserProperties(); // Create driver instance and launch the browser
		  Elements_Recipients.Recipients_PageProperties();// loading UI Page Elements / Locators
		  RecipientPage = new RecipientPage(driver); // Loading Pages
		  Browser= new TestUtils(driver);   
		
		  System.out.println("Executing Before Class");
		// Note: Make sure  doctor is inactive and add him to recipient fav list 	 
 } 

 
	 @DataProvider(name = "DP1")
		public String[][] createData1() {
			return new String[][] {
					{ "yes","ganeshkumar.m@zoylo.com","Zoylo@123","Avinash" }

			};
		}
	 @Test(dataProvider="DP1",groups = { "Regression","Medium" })
	 public void validateBookingAnInActiveDoctor(String runmode,String Username,String Password,String Doctor ) throws Exception {
	  
		 if(runmode.equals("yes")){
			 			 
			  //Test Starts-Here
			  Browser.openUrl(loginPage_Url);			
		      //Verify Recipient Login with valid details
			  RecipientPage.recipientLogin(Username, Password);
			  Thread.sleep(2000);
			  RecipientPage.goToMyAccounts("My Favourites");
			  driver.findElement(By.xpath("//*[@id='bookAppointment']/button")).click(); 
			  String Notification = RecipientPage.getNotificationMesssage();
			  AssertJUnit.assertEquals(Notification, "Doctor is not working");
	 
		 }else{
			 
			throw new SkipException("RUNMODE IS OFF");
			
		 }
			
			
	    }
    
	 @AfterClass(groups = { "Regression","High" })
		public void Exit() {
			
			driver.quit();
		} 
    
	

    
    
}