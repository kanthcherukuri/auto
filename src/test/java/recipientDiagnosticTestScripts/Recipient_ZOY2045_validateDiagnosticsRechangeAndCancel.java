package recipientDiagnosticTestScripts;



import org.testng.annotations.AfterClass;
import org.testng.annotations.Test;
import org.testng.annotations.BeforeClass;
import org.testng.AssertJUnit;
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
			    RecipientPage.makePaymentforDC();
				String SuccessfullMesg = driver.findElement(By.cssSelector("h5")).getText();
				System.out.println("h5"+SuccessfullMesg);
				AssertJUnit.assertEquals(SuccessfullMesg, "Thank you for booking appointment at "+DiagonosticsFullName+" through Zoylo. Your appointment booking details are below:");

				//Re Scheduling the Apppointment
				Browser.openUrl(loginPage_Url);
				//RecipientPage.recipientLogin(Recipient_DSusername, Recipient_DSpassword);
				RecipientPage.goToAppointments();
				//Browser.scrollbyxpath("(//div/span[@class='zy-diagno-doc-revw change-DcApt apt-doc-col'])[last()]");
				Thread.sleep(2000);
				driver.findElement(By.xpath("(//div/span[@class='zy-diagno-doc-revw change-DcApt apt-doc-col'])[last()]")).click();
				Thread.sleep(5000);
				driver.findElement(By.xpath("//a[contains(@href, '#sp-nightslots')]")).click();
				Thread.sleep(2000);
				driver.findElement(By.xpath("(//div[@id='sp-nightslots']/ul/li[contains(@class,'sp-available-slots')])[1]")).click();
				Thread.sleep(2000);
				String RerechangeMesg= driver.findElement(By.cssSelector(Elements_Recipients.Recipient_Wrapper)).getText();
				System.out.println("RescheduleMesg"+RerechangeMesg);
				Assert.assertEquals(RerechangeMesg, "Successfully changed the appointment slot");
				//Canceling the appointment
				driver.findElement(By.xpath("//div[@class='menu_links appt-cancel apt-doc-col']")).click();
				Thread.sleep(5000);
				driver.findElement(By.xpath("//*[@id='cancelYes']")).click();
				Thread.sleep(2000);
				String Appointment_Cancelled_Mesg= driver.findElement(By.cssSelector(Elements_Recipients.Recipient_Wrapper)).getText();
				System.out.println("Appointment_Cancelled_Mesg"+Appointment_Cancelled_Mesg);
				Assert.assertEquals(Appointment_Cancelled_Mesg, "Appointment has been Cancelled");
				
		 }else{
			 
			throw new SkipException("RUNMODE IS OFF");
			
		 }
			
			
	    }

	 @AfterClass(groups = { "Regression","High" })
	 
	 public void Exit() {

	       
	       driver.close();
	       
	      
	    }
    
	

    
    
}