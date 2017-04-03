package recipientsTestScripts;



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
public class Recipients_ZOY1188_ValidateBookingAnInActiveDoctor extends LoadProp {
	 public RecipientPage RecipientPage;
	 public TestUtils Browser;	

	
	
		
	 @BeforeClass(groups = { "Regression","High" })	
    public void LaunchBrowser() throws Exception {
  
		  LoadBrowserProperties(); // Create driver instance and launch the browser
		  Elements_Recipients.Recipients_PageProperties();// loading UI Page Elements / Locators
		  RecipientPage = new RecipientPage(driver); // Loading Pages
		  Browser= new TestUtils(driver);   
		
		// Note: Make sure  doctor is inactive and added him recipient fav list 	 
 } 

 
	 @DataProvider(name = "DP1")
	    public Object[][] createData_DP1() throws Exception{
	        Object[][] retObjArr=TestUtils.getTableArray("TestData\\Recipients_TestData.xls","Doctor", "ZOY1188");
	        return(retObjArr);
	    }
	 @Test(dataProvider="DP1",groups = { "Regression","Medium" })
	 public void validateBookingAnInActiveDoctor(String runmode,String Username, String Password,String Doctor ) throws Exception {
	  
		 if(runmode.equals("yes")){
			 			 
			  //Test Starts-Here
			  Browser.openUrl(recipient_url);			
		      //Verify Recipient Login with valid details
			  RecipientPage.recipientLogin(Username, Password);
			  Thread.sleep(2000);
			  RecipientPage.goToMyAccounts("My Favourites");
			  driver.findElement(By.xpath("//*[@id='bookAppointment']/button")).click(); 
			  String Notification = RecipientPage.getNotificationMesssage();
			  Assert.assertEquals(Notification, "Doctor is not working");
			
			 
		 }else{
			 
			throw new SkipException("RUNMODE IS OFF");
			
		 }
			
			
	    }
    
 
	 
	 @AfterClass(groups = { "Regression","High" })
	 
	 public void Exit() {

	       
	       driver.close();
	       
	      
	    }
    
	

    
    
}