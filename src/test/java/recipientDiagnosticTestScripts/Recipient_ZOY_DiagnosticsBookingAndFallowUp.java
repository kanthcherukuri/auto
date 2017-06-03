package recipientDiagnosticTestScripts;



import org.testng.annotations.AfterClass;
import org.testng.annotations.Test;
import org.testng.annotations.BeforeClass;
import org.testng.AssertJUnit;
import org.openqa.selenium.*;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
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
				Browser.openUrl(recipient_url);			
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
				AssertJUnit.assertEquals(SuccessfullMesg, "Thank you for booking appointment at "+DiagonosticsFullName+" through Zoylo. Your appointment booking details are below:");
				RecipientPage.recipientLogout();
				

				Browser.openUrl(recipient_url);			
				//Verify Doctor Login with valid details
				Thread.sleep(5000);
				DiagnosticPage.SignIn(Recipient_DiaUsername, Recipient_DiaPassword);
				//Browser.waitTill(60);
				DiagnosticPage.clickOnTheRecentPatientFromDashBoardInDiagnostics();
				DiagnosticPage.diagnosticsCheckinCheckOut();
				DiagnosticPage.diagnosticslogout();
				
				
				//Login as Recipient
				Browser.openUrl(recipient_url);			
				//Verify Recipient Login with valid details
				RecipientPage.recipientLogin(Recipient_DSusername, Recipient_DSpassword);
				Thread.sleep(2000);
				driver.findElement(By.id("comment")).sendKeys("Review Comments test details Review Comments test details Review Comments test details Review Comment");
				Browser.scrollbyID("submitReview");
				//driver.findElement(By.id("submitReview")).click();
				driver.findElement(By.id("skipForLater")).click();
				//Browser.verifyNotificationMessage("Review submitted successfully.");
				Thread.sleep(5000);
				 //FallowUp the Appointment
				/* RecipientPage.goToMyAccounts("Appointment");
				 Thread.sleep(2000);// Added for view
				 driver.findElement(By.id("hist")).click();  // my History
				 Thread.sleep(5000);
				 driver.findElement(By.xpath("(//img[@class='followup'])[1]")).click();
				 Browser.waitTill(60);
				 //Book FallowUp Slot
				 RecipientPage.selectDefaultSlot();
				 Browser.waitFortheID("followUpBookAppointment");
				 driver.findElement(By.id("problem")).sendKeys("Health details");
				 driver.findElement(By.id("followUpBookAppointment")).click();  // FollowUp Book
				 WebDriverWait wait = (new WebDriverWait(driver, 60));
				 wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(By.cssSelector(Elements_Recipients.Recipient_Wrapper)));
				 String ActualError= driver.findElement(By.cssSelector(Elements_Recipients.Recipient_Wrapper)).getText();
				 ActualError.contains("You will Recieve a confirmation SMS");
				 System.out.println("followUpBookAppointment Confirmed");
				*/
	 
		 }else{
			 
			throw new SkipException("RUNMODE IS OFF");
			
		 }
			
			
	    }

	 @AfterClass(groups = { "Regression","High" })
	 
	 public void Exit() {

	       
	       driver.close();
	       
	      
	    }
    
	

    
    
}