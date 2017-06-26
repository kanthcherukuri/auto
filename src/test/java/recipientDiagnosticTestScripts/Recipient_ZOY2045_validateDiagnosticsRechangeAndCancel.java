package recipientDiagnosticTestScripts;



import org.testng.annotations.AfterClass;
import org.testng.annotations.Test;
import org.testng.annotations.BeforeClass;
import org.testng.Assert;
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
public class Recipient_ZOY2045_validateDiagnosticsRechangeAndCancel extends LoadPropMac {
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
					{ "yes","Sugar Test","Zoylo Health Pkg",Diagnostic_Name }

			};
		}
	 @Test(dataProvider="DP1",groups = { "Regression","High" })
	 public void validateDiagnosticsRechangeAndCancel(String runmode,String Tests,String Pkg,String DiagnosticName ) throws Exception {
	  
		 if(runmode.equals("yes")){
			 		 
			// /*
			    //Test Starts-Here
				Browser.openUrl(loginPage_Url);			
				//Verify Recipient Login with valid details
         		RecipientPage.recipientLogin(Recipient_DSusername, Recipient_DSpassword);
				RecipientPage.goToDiagnostics();
				RecipientPage.searchInZoyloMAP(DiagnosticName);
				String DiagonosticsFullName = driver.findElement(By.xpath("//h1")).getText();
				System.out.println("DiagonosticsFullName"+DiagonosticsFullName);
				RecipientPage.bookAppointmentOnDiagnostics();
				RecipientPage.selectAvailableSlotInDiagnostics(Tests, Pkg);
				RecipientPage.confirmAppointmentOnDiagnostics();
			    RecipientPage.makePayment();
				String SuccessfullMesg = driver.findElement(By.cssSelector("h5")).getText();
				System.out.println("h5"+SuccessfullMesg);
				Assert.assertEquals(SuccessfullMesg, "Thank you for booking appointment at "+DiagonosticsFullName+" through Zoylo. Your appointment booking details are below:");
                //Get Appointment ID
				String APID = Browser.getAppointmentID();
				//Re Scheduling the Apppointment
				Browser.openUrl(loginPage_Url);
				//RecipientPage.recipientLogin(Recipient_DSusername, Recipient_DSpassword);
				RecipientPage.goToAppointments();
				//Rescheduling the appointment	
				RecipientPage.UpcomingAppointment(APID, "Reschedule");
				Browser.clickOnTheElementByXpath("(//div[@class='panel-collapse collapse in']/ul/li[@class='timeSlot sp-available-slots'])[2]");							 
				Browser.verifyNotificationMessage("Your appointment slot has been successfully CHANGED");
				//Verifying Reshedule label in appointments
				String Appointment_Status_Reshedule=driver.findElement(By.xpath("//div[contains(.,'"+APID+"')]/preceding-sibling::div[@class='patientApmtStatus']")).getText();
	            Assert.assertEquals(Appointment_Status_Reshedule, "Rescheduled");
				//Canceling the appointment			
	            RecipientPage.UpcomingAppointment(APID, "Cancel");	   
	            Browser.verifyNotificationMessage("Appointment has been Cancelled");
				driver.findElement(By.id("hist")).click();  // my History
				Thread.sleep(2000);
				String Appointment_Status_cancelled=driver.findElement(By.xpath("//div[contains(.,'"+APID+"')]/preceding-sibling::div[@class='paddingl0 apt-dt-chng']")).getText();
	            Assert.assertEquals(Appointment_Status_cancelled, "Cancelled");
				
		 }else{
			 
			throw new SkipException("RUNMODE IS OFF");
			
		 }
			
			
	    }

	 @AfterClass(groups = { "Regression","High" })
	 
	 public void Exit() {

	       
	       driver.close();
	       
	      
	    }
    
	

    
    
}