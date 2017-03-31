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
public class Recipients_ZOY1182_ValidateRecipientsAlerts extends LoadProp {
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
	 public void ValidateDoctorEnrollment(String runmode,String Username, String Password,String SlotChangeMesg,String Doctor ) throws Exception {
	  
		 if(runmode.equals("yes")){
			 		 
			    //Test Starts-Here
				Browser.openUrl(recipient_url);			
				//Verify Recipient Login with valid details
				RecipientPage.recipientLogin(Username, Password);
				Thread.sleep(2000);
				RecipientPage.searchInZoyloMAP(Doctor);
				String DoctorFullName = driver.findElement(By.xpath("//h1")).getText();
				RecipientPage.bookAppointment();
				RecipientPage.selectDefaultSlot();
				RecipientPage.confirmAppointment("Test details");
			    RecipientPage.makePayment();
				String AppointmentId = driver.findElement(By.xpath("(//div[@class='book-dtbox']/h3)[1]")).getText();
				System.out.println("before split id is "+AppointmentId);
				String APID[]=AppointmentId.split(":");
				System.out.println("After split id is "+APID[1]);
				RecipientPage.openRecipientsMyAccounts();
				driver.findElement(By.xpath("//*[@id='tabs']/li[contains(.,'Alerts')]")).click();
				Thread.sleep(2000);
				String AppointmentIdInAlerts = driver.findElement(By.xpath("(//*[@id='recipientMessage'])[1]")).getText();
				//Verifing appointment id in Alerts
				Assert.assertTrue(AppointmentIdInAlerts.contains(APID[1]));
				Assert.assertTrue(AppointmentIdInAlerts.contains(DoctorFullName));
			 
		 }else{
			 
			throw new SkipException("RUNMODE IS OFF");
			
		 }
			
			
	    }
    
	 
	 
	 
	 
	 
	 @AfterClass(groups = { "Regression","High" })
	 
	 public void Exit() {

	       
	       driver.close();
	       
	      
	    }
    
	

    
    
}