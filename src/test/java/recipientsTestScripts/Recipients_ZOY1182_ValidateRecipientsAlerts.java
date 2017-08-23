package recipientsTestScripts;



import org.testng.annotations.AfterClass;
import org.testng.annotations.Test;
import org.testng.annotations.BeforeClass;
import org.openqa.selenium.*;
import org.testng.Assert;
import org.testng.SkipException;
import org.testng.annotations.*;
import testBase.*;
import objectRepository.*;

public class Recipients_ZOY1182_ValidateRecipientsAlerts extends LoadPropMac {
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
					{ "yes","ganeshkumar.m@zoylo.com","Zoylo@123","Ganesh" }

			};
		}
	 @Test(dataProvider="DP1",groups = { "Regression","High" })
	 public void validateRecipientsAlerts(String runmode,String Username,String Password,String Doctor ) throws Exception {
	  
		 if(runmode.equals("yes")){
			 		 
			    //Test Starts-Here
			    Browser.openUrl("https://"+Environment_Name+".zoylo.com/login");			
				//Verify Recipient Login with valid details
				RecipientPage.recipientLogin(Recipient_Username, Recipient_Password);
				RecipientPage.searchInZoyloMAP(Doctor_Name);
				String DoctorFullName = driver.findElement(By.xpath("//h1")).getText();
				System.out.println(DoctorFullName);
				RecipientPage.bookAppointment();
				RecipientPage.selectDefaultSlot();
				RecipientPage.confirmAppointment("Test details");
			    RecipientPage.makePayment();
				String AppointmentId = driver.findElement(By.xpath("(//div[@class='book-dtbox']/h3)[1]")).getText();
				System.out.println("before split id is "+AppointmentId);
				String APID[]=AppointmentId.split(":");
				System.out.println("After split id is "+APID[1]);
				RecipientPage.openMyAccounts("Alerts");				
				String AppointmentIdInAlerts = driver.findElement(By.xpath("(//*[@id='recipientMessage'])[1]")).getText();
				//Verifing appointment id in Alerts
				Assert.assertTrue(AppointmentIdInAlerts.contains(APID[1]));
				//Assert.assertTrue(AppointmentIdInAlerts.contains(Doctor));
				Assert.assertTrue(AppointmentIdInAlerts.contains("has been SCHEDULED"));
			 
		 }else{
			 
			throw new SkipException("RUNMODE IS OFF");
			
		 }
			
			
	    }
    
	 @AfterClass(groups = { "Regression","High" })
		public void Exit() {
			
			driver.quit();
		} 
    
	

    
    
}