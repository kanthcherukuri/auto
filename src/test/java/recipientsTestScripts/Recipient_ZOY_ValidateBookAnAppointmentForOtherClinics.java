package recipientsTestScripts;



import org.testng.annotations.AfterClass;
import org.testng.annotations.Test;
import org.testng.annotations.BeforeClass;
import org.testng.Assert;
import org.openqa.selenium.*;

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
public class Recipient_ZOY_ValidateBookAnAppointmentForOtherClinics extends LoadPropMac {
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
					{ "yes","Xyz Clinic","Your appointment slot has been successfully CHANGED" }

			};
		}

	 @Test(dataProvider="DP1",groups = { "Regression","High" })
	 public void ValidateBookAnAppointmentForOtherClinics(String runmode,String ClinicName,String slotchangemesg ) throws Exception {
	  
		 if(runmode.equals("yes")){
			 		 
			    //Test Starts-Here
			    Browser.openUrl("https://"+Environment_Name+".zoylo.com/login");			
				//Verify Recipient Login with valid details
				RecipientPage.recipientLogin(Recipient_Username, Recipient_Password);
				RecipientPage.searchInZoyloMAP(Doctor_Name);
				String DoctorFullName = driver.findElement(By.xpath("//h1")).getText();
				RecipientPage.bookAppointment();
				driver.findElement(By.id("manage-flip")).click();
				driver.findElement(By.linkText(ClinicName)).click();
				Thread.sleep(2000);
				driver.findElement(By.xpath("(//div[@class='panel-collapse collapse in']/ul/li[contains(@class,'sp-available-slots')])[1]")).click();
				RecipientPage.confirmAppointment("Test details");
			    RecipientPage.makePayment();
				String SuccessfullMesg = driver.findElement(By.cssSelector("h5")).getText();
				Assert.assertEquals(SuccessfullMesg, "Thank you for booking appointment with "+DoctorFullName+" through Zoylo. Your appointment booking details are below:");
				String AppointmentId = Browser.getAppointmentID();
				//Re Scheduling the Apppointment
				RecipientPage.openMyAccounts("Appointments");			
				RecipientPage.UpcomingAppointmentForDoctors(AppointmentId, "Reschedule");	
				// ZOY-2515 - verify the reschedule doctor 
				String ResheduleDefaultClinic = Browser.getTextByXpath("//div[contains(@id,'other-clinics-section') and @style='display: block;']//div[@class='clinic_details']//div[@class='address']");
				Assert.assertEquals(ClinicName, ResheduleDefaultClinic);
				//Browser.clickOnTheElementByXpath("//li[@id='cd-1']/div"); //Tomarw Slots			
	            Browser.clickOnTheElementByXpath("(//div[@class='panel-collapse collapse in']/ul/li[@class='sp-available-slots'])[2]");
	            Browser.CheckNotificationMessage(slotchangemesg);
	            //Verify Reschedule Status 
				RecipientPage.openMyAccounts("Appointments");			
				Browser.waitFortheID("upcmng");
				driver.findElement(By.id("aptSearch")).click();
				driver.findElement(By.id("aptSearch")).sendKeys(AppointmentId);
				Thread.sleep(5000);
				Browser.waitFortheElementXpath("//div[@class='patientApmtStatus' and contains(.,'Rescheduled')]");
				
	 
		 }else{
			 
			throw new SkipException("RUNMODE IS OFF");
			
		 }
			
			
	    }
	  

	 @AfterClass(groups = { "Regression","High" })
	 
	 public void Exit() {

	       
		 driver.quit();
	       
	      
	    }
    
	

    
    
}