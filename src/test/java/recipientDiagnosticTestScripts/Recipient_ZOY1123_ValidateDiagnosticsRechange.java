package recipientDiagnosticTestScripts;



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
public class Recipient_ZOY1123_ValidateDiagnosticsRechange extends LoadPropMac {
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
			 		 
			// /*
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
				Assert.assertEquals(SuccessfullMesg, "Thank you for booking appointment at "+DiagonosticsFullName+" through Zoylo. Your appointment booking details are below:");

				//Re Scheduling the Apppointment
				Browser.openUrl(recipient_url);
				//RecipientPage.recipientLogin(Recipient_Username, Recipient_Password);
				RecipientPage.goToAppointments();
				Browser.scrollbyxpath("(//div[@class='zy-diagno-zy-day-change'])[last()]");
				Thread.sleep(2000);
				driver.findElement(By.xpath("(//div[@class='zy-diagno-zy-day-change']/div/span)[last()]")).click();
				Browser.waitTill(60);
				Thread.sleep(5000);
				driver.findElement(By.xpath("//a[contains(@href, '#sp-nightslots')]")).click();
				Thread.sleep(2000);
				driver.findElement(By.xpath("(//div[@id='sp-nightslots']/ul/li[contains(@class,'sp-available-slots')]/span)[1]")).click();
				Thread.sleep(2000);
				String RerechangeMesg= driver.findElement(By.cssSelector(Elements_Recipients.Recipient_Wrapper)).getText();
				System.out.println("RescheduleMesg"+RerechangeMesg);
				Assert.assertEquals(RerechangeMesg, "Successfully changed the appointment slot");
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