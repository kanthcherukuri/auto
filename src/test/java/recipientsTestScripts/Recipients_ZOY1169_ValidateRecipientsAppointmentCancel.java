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
public class Recipients_ZOY1169_ValidateRecipientsAppointmentCancel extends LoadProp {
	 public RecipientPage RecipientPage;
	 public TestUtils Browser;	
	 public HomePage HomePage;

	
	
		
	 @BeforeClass(groups = { "Regression","High" })	
    public void LaunchBrowser() throws Exception {
  
		  LoadBrowserProperties(); // Create driver instance and launch the browser
		  Elements_Recipients.Recipients_PageProperties();// loading UI Page Elements / Locators
		  RecipientPage = new RecipientPage(driver); // Loading Pages
		  HomePage = new HomePage(driver);
		  Browser= new TestUtils(driver);        
		  	 
 } 

 
	 @DataProvider(name = "DP1")
	    public Object[][] createData_DP1() throws Exception{
	        Object[][] retObjArr=TestUtils.getTableArray("TestData\\Recipients_TestData.xls","Doctor", "ZOY1169");
	        return(retObjArr);
	    }
	 @Test(dataProvider="DP1",groups = { "Regression","High" })
	 public void ValidateRecipientsAppointmentCancel(String runmode,String Username, String Password,String City ) throws Exception {
	  
		 if(runmode.equals("yes")){
 
			//Test Starts-Here
			Browser.openUrl(recipient_url);			
			//Verify Recipient Login with valid details
			RecipientPage.recipientLogin(Username, Password);
			Thread.sleep(10000);
			RecipientPage.searchInZoyloMAPArea(City);
			RecipientPage.clickOnMapICon();
			Browser.waitFortheElementXpath("//div[@class='dctr-desig']");
			 String DoctorFullName = driver.findElement(By.xpath("//h1")).getText();
			 System.out.println("Doctor is"+DoctorFullName);
			 RecipientPage.bookAppointment();
			 String clinicAddress= driver.findElement(By.xpath("//h2[@class='addr-ClinicName']/span")).getText();
			 System.out.println("Clinic is"+clinicAddress);
			 RecipientPage.selectDefaultSlot();
			 String DoctorFirstName = driver.findElement(By.xpath("//h2")).getText();
			 System.out.println("Doctor is"+DoctorFirstName);
			 RecipientPage.confirmAppointment("Test Details");
			 RecipientPage.makePayment();
			 String SuccessfullMesg = driver.findElement(By.cssSelector("h5")).getText();
			 Assert.assertEquals(SuccessfullMesg, "Thank you for booking appointment with "+DoctorFullName+" through Zoylo. Your appointment booking details are below:");
			 driver.get(""+base_url+"myaccount");
			 Thread.sleep(5000);
			 driver.findElement(By.xpath("//*[@id='tabs']/li[contains(.,'Appointments')]")).click();
			 Thread.sleep(2000);
			 driver.findElement(By.xpath("//*[@id='myAppointment']//h2[contains(.,'"+DoctorFirstName+"')]")).click();
			 Browser.waitTill(60);
			 driver.findElement(By.id("cancel")).click();
			 Thread.sleep(5000);
			 driver.findElement(By.id("confirmYes")).click();
			 String cancel_mesg=driver.findElement(By.cssSelector(Elements_Recipients.Recipient_Wrapper)).getText();
			 
			 Assert.assertEquals(cancel_mesg, "Appointment has been Cancelled");
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