package recipientDiagnosticTestScripts;



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


public class Recipient_ZOY_ValidateDianosticsBookingAnAppointmentForOthers extends LoadPropMac {
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
	 public void validateBookingAnAppointment(String runmode,String Tests,String Pkg,String DiagnosticName ) throws Exception {
	  
		 if(runmode.equals("yes")){
			 		 
			    //Test Starts-Here
			    Browser.openUrl("https://"+Environment_Name+".zoylo.com/login");			
				//Verify Recipient Login with valid details
				RecipientPage.recipientLogin(Recipient_DSusername, Recipient_DSpassword);
				RecipientPage.goToDiagnostics();
				RecipientPage.searchDCInZoyloMAP(DiagnosticName);
				String DiagonosticsFullName = driver.findElement(By.xpath("//h1")).getText();
				System.out.println("DiagonosticsFullName"+DiagonosticsFullName);
				RecipientPage.bookAppointmentOnDiagnostics();
				RecipientPage.selectAvailableSlotInDiagnostics(Tests, Pkg);
				RecipientPage.confirmAppointmentOnDiagnosticsAsOthers("Health details","Ganesh","Kumar","Male","30","O+");
			    RecipientPage.makePayment();
				String SuccessfullMesg = driver.findElement(By.cssSelector("h5")).getText();
				System.out.println("h5"+SuccessfullMesg);
				Assert.assertEquals(SuccessfullMesg, "Thank you for booking appointment at "+DiagonosticsFullName+" through Zoylo. Your appointment booking details are below:");

	 
		 }else{
			 
			throw new SkipException("RUNMODE IS OFF");
			
		 }
			
			
	    }

	 @AfterClass(groups = { "Regression","High" })
	 
	 public void Exit() {
		 driver.quit();
	    }
    
	

    
    
}