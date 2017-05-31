package recipientsTestScripts;



import org.openqa.selenium.*;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
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
public class Recipient_ZOY1171_ValidateRecipientBookFallowUpApointment extends LoadPropMac {
	 public RecipientPage RecipientPage;
	 public DoctorsPage DoctorsPage;
	 public TestUtils Browser;	

	
	
		
	 @BeforeClass(groups = { "Regression","High" })	
    public void launchBrowser() throws Exception {
  
		  LoadBrowserProperties(); // Create driver instance and launch the browser
		  Elements_Recipients.Recipients_PageProperties();// loading UI Page Elements / Locators
		  RecipientPage = new RecipientPage(driver); // Loading Pages
		  DoctorsPage = new DoctorsPage(driver); // Loading Pages
		  Browser= new TestUtils(driver);        
		  	 
 } 

	 @DataProvider(name = "DP1")
		public String[][] createData1() {
			return new String[][] {
				{ "yes","Deepak","dr1130@gmail.com","Zoylo@123" }

			};
		}
	 @Test(dataProvider="DP1",groups = { "Regression","High" })
	 public void validateBookingFallowUpAppointmentForDoctor(String runmode,String Doctor,String DoctorUserName,String DoctorPassword ) throws Exception {
	  
		 if(runmode.equals("yes")){
			    //Test Starts-Here
				Browser.openUrl(recipient_url);			
				//Verify Recipient Login with valid details
				RecipientPage.recipientLogin(Recipient_Username, Recipient_Password);
				Thread.sleep(2000);
				RecipientPage.searchInZoyloMAP(Doctor_Name);
				String DoctorFullName = driver.findElement(By.xpath("//h1")).getText();
				RecipientPage.bookAppointment();
				RecipientPage.selectDefaultSlot();
				RecipientPage.confirmAppointment("Test details");
			    RecipientPage.makePayment();
				String SuccessfullMesg = driver.findElement(By.cssSelector("h5")).getText();
				Assert.assertEquals(SuccessfullMesg, "Thank you for booking appointment with "+DoctorFullName+" through Zoylo. Your appointment booking details are below:");
				RecipientPage.recipientLogout();				
				//Login as Doctor
				
				Browser.openUrl(recipient_url);			
				DoctorsPage.SignIn(Recipient_DocUsername, Recipient_DocPassword);
				//Browser.waitTill(60);
				DoctorsPage.clickOnTheRecentPatientFromDashBoard();
				DoctorsPage.doctorCheckinCheckOut();
				DoctorsPage.doctorlogout();
				
				//Login as Recipient
				Browser.openUrl(recipient_url);			
				//Verify Recipient Login with valid details
				RecipientPage.recipientLogin(Recipient_Username, Recipient_Password);
				Thread.sleep(2000);
				driver.findElement(By.id("comment")).sendKeys("Review Comments test details Review Comments test details Review Comments test details Review Comment");
				Browser.scrollbyID("submitReview");
				driver.findElement(By.id("submitReview")).click();
				Browser.verifyNotificationMessage("Review submitted successfully.");
				Thread.sleep(5000);
				 //FallowUp the Appointment
				 RecipientPage.goToMyAccounts("Appointment");
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
	 
		 }else{
			 
			throw new SkipException("RUNMODE IS OFF");
			
		 }
			
			
	    }

	 @AfterClass(groups = { "Regression","High" })
	 
	 public void Exit() {
 
	       driver.close();

	    }
    
	

    
    
}