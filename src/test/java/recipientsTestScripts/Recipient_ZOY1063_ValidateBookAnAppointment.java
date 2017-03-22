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
public class Recipient_ZOY1063_ValidateBookAnAppointment extends LoadProp {
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
	        Object[][] retObjArr=TestUtils.getTableArray("TestData\\Recipients_TestData.xls","Doctor", "ZOY1063");
	        return(retObjArr);
	    }
	 @Test(dataProvider="DP1",groups = { "Regression","High" })
	 public void ValidateDoctorEnrollment(String runmode,String Username, String Password,String RecipientScreenTitle,String Doctor ) throws Exception {
	  
		 if(runmode.equals("yes")){
			 			 
			 //Test Starts-Here
			 Browser.openUrl(recipient_url);			
		
			 
			 //Verify Recipient Login with valid details
			 RecipientPage.recipientLogin(Username, Password);
			 Thread.sleep(2000);
		     String ActualRecipientTitle = driver.getTitle();
			 Assert.assertEquals(ActualRecipientTitle, RecipientScreenTitle);
			 Thread.sleep(2000);
			 RecipientPage.searchInZoyloMAP(Doctor);
			String DoctorFullName = driver.findElement(By.xpath("//h1")).getText();
			driver.findElement(By.xpath("(//button[@type='button'])[2]")).click();  // book
			Thread.sleep(2000);
			driver.findElement(By.xpath("//a[contains(@href, '#sp-nightslots')]")).click();
			Thread.sleep(2000);
			driver.findElement(By.xpath("(//div[@id='sp-nightslots']/ul/li/span)[1]")).click();
			Thread.sleep(2000);
			driver.findElement(By.xpath("//div[text()='Confirm Appointment']")).click();  //Confirm Appointment
			Browser.waitTill(10);
			driver.findElement(By.id("applyPromocode")).click();
			driver.findElement(By.xpath("(//input[@name='paymentOption'])[3]")).click();
			driver.findElement(By.id("termsAndConditions")).click();
			driver.findElement(By.xpath("//button[text()='Make Payment ']")).click();     //Make payment
			Browser.waitTill(10);
			String SuccessfullMesg = driver.findElement(By.cssSelector("h5")).getText();
			Assert.assertEquals(SuccessfullMesg, "Thank you for booking appointment with "+DoctorFullName+" through Zoylo. Your appointment booking details are below:");
			
			//Logout from Recipient
			 Browser.openUrl(recipient_url);
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