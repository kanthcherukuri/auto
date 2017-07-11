package recipientDiagnosticTestScripts;



import org.testng.annotations.AfterClass;
import org.testng.annotations.Test;
import org.testng.annotations.BeforeClass;
import org.testng.Assert;

import java.text.SimpleDateFormat;
import java.util.Date;

import org.openqa.selenium.*;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.SkipException;
import org.testng.annotations.*;
/*
import atu.testng.reports.listeners.ATUReportsListener;
import atu.testng.reports.listeners.ConfigurationListener;
import atu.testng.reports.listeners.MethodListener;
*/
import testBase.*;
import objectRepository.*;


public class Recipient_ZOY_DiagnosticsBookingAndFallowUp extends LoadPropMac {
	 public RecipientPage RecipientPage;
	 public TestUtils Browser;	
	 public DiagnosticPage DiagnosticPage;
	
	
		
	 @BeforeClass(groups = { "Regression","High" })	
    public void LaunchBrowser() throws Exception {
  
		  LoadBrowserProperties(); // Create driver instance and launch the browser
		  Elements_Recipients.Recipients_PageProperties();// loading UI Page Elements / Locators
		  RecipientPage = new RecipientPage(driver); // Loading Pages
		  DiagnosticPage = new DiagnosticPage(driver); // Loading Pages
		  Browser= new TestUtils(driver);        
		  	 
 } 

 
	 @DataProvider(name = "DP1")
		public String[][] createData1() {
			return new String[][] {
					{ "yes","Sugar Test","Zoylo Health Pkg",Diagnostic_Name }

			};
		}
	 @Test(dataProvider="DP1",groups = { "Regression","High" })
	 public void DiagnosticsBookingAndFallowUp(String runmode,String Tests,String Pkg,String DiagnosticName ) throws Exception {
	  
		 if(runmode.equals("yes")){

			 
			    //Test Starts-Here
				Browser.openUrl(loginPage_Url);			
				//Verify Recipient Login with valid details
				RecipientPage.recipientLogin(Recipient_DSusername, Recipient_DSpassword);
				RecipientPage.goToDiagnostics();
				RecipientPage.searchDCInZoyloMAP(DiagnosticName);
				String DiagonosticsFullName = driver.findElement(By.xpath("//h1")).getText();
				System.out.println("DiagonosticsFullName"+DiagonosticsFullName);
				RecipientPage.bookAppointmentOnDiagnostics();
				String[] Appointmentdetails = RecipientPage.selectAvailableSlotInDiagnostics(Tests, Pkg);
				
				System.out.println("Clinic Name details"+Appointmentdetails[0]);
				System.out.println("Time Slot"+Appointmentdetails[1]);
				
				RecipientPage.confirmAppointmentOnDiagnostics();
			    RecipientPage.makePayment();
				String SuccessfullMesg = driver.findElement(By.cssSelector("h5")).getText();
				System.out.println("h5"+SuccessfullMesg);
				Assert.assertEquals(SuccessfullMesg, "Thank you for booking appointment at "+DiagonosticsFullName+" through Zoylo. Your appointment booking details are below:");
				String APID=Browser.getAppointmentID();
				RecipientPage.recipientLogout();
			
				//Verify Doctor Login with valid details
				DiagnosticPage.SignIn(Recipient_DiaUsername, Recipient_DiaPassword);
				DiagnosticPage.clickOnThePatientFromDashBoardInDiagnostics(Appointmentdetails[1]);
				DiagnosticPage.diagnosticsCheckinCheckOut();
				DiagnosticPage.diagnosticslogout();
				
				
				//Login as Recipient
				Browser.openUrl(loginPage_Url);			
				RecipientPage.recipientLogin(Recipient_DSusername, Recipient_DSpassword);
                Thread.sleep(20000);				
				driver.findElement(By.id("comment")).sendKeys("Review Comments test details Review Comments test details Review Comments test details Review Comment");
				Browser.scrollbyID("submitReview");				
				driver.findElement(By.id("skipForLater")).click();
				Thread.sleep(5000);
				RecipientPage.openMyAccounts("Appointments");
				driver.findElement(By.id("hist")).click();  // my History
				Thread.sleep(2000);
				String Appointment_Status_Completed=driver.findElement(By.xpath("//div[contains(.,'"+APID+"')]/preceding-sibling::div[@class='paddingl0 apt-dt-chng']")).getText();
	            Assert.assertEquals(Appointment_Status_Completed, "Completed");
	 
		 }else{
			 
			throw new SkipException("RUNMODE IS OFF");
			
		 }
			
			
	    }

	 @AfterClass(groups = { "Regression","High" })	 
	 public void closeBrowser() {

	       driver.quit();
  
	    }
    
	

    
    
}