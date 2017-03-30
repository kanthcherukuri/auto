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
				String SuccessfullMesg = driver.findElement(By.cssSelector("h5")).getText();
				Assert.assertEquals(SuccessfullMesg, "Thank you for booking appointment with "+DoctorFullName+" through Zoylo. Your appointment booking details are below:");

		
			 
			 
			//Re Scheduling the Apppointment
			 Browser.openUrl(recipient_url);
			 driver.findElement(By.xpath("//li[@id='myaccount']/span/img")).click();
			 Browser.waitTill(60);
			 driver.findElement(By.xpath("//li[@id='myAppointment']/a/span/i")).click();
			 Browser.waitTill(60);
			 Thread.sleep(5000);// Added for view
			 driver.findElement(By.xpath("//div[@class='apt-dt-chng' and contains(.,'Scheduled')]/div[2]/div[2]")).click();
			 Browser.waitTill(60);
			 Thread.sleep(5000);
			 driver.findElement(By.xpath("//a[contains(@href, '#sp-nightslots')]")).click();
			 Thread.sleep(2000);
		     driver.findElement(By.xpath("(//div[@id='sp-nightslots']/ul/li[@class='sp-available-slots']/span)[1]")).click();
		     Thread.sleep(2000);
		     String RescheduleMesg= driver.findElement(By.cssSelector(Elements_Recipients.Recipient_Wrapper)).getText();
			 System.out.println("RescheduleMesg"+RescheduleMesg);
		     Assert.assertEquals(RescheduleMesg, SlotChangeMesg);
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