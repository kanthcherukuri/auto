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
public class Recipient_ZOY1171_ValidateRecipientBookFallowUpApointment extends LoadProp {
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
	    public Object[][] createData_DP1() throws Exception{
	        Object[][] retObjArr=TestUtils.getTableArray("TestData\\Recipients_TestData.xls","Doctor", "ZOY1171");
	        return(retObjArr);
	    }
	 @Test(dataProvider="DP1",groups = { "Regression","High" })
	 public void validateBookingFallowUpAppointmentForDoctor(String runmode,String Username, String Password,String Doctor,String DoctorUserName,String DoctorPassword ) throws Exception {
	  
		 if(runmode.equals("yes")){
			 	
			    //Test Starts-Here
				Browser.openUrl(recipient_url);			
				//Verify Recipient Login with valid details
				RecipientPage.recipientLogin(Username, Password);
				Thread.sleep(2000);
				RecipientPage.searchInZoyloMAP(Doctor);
				String DoctorFullName = driver.findElement(By.xpath("//h1")).getText();
				RecipientPage.bookAppointment();
				Thread.sleep(5000);
				RecipientPage.selectDefaultSlot();
				RecipientPage.confirmAppointment("Test details");
			    RecipientPage.makePayment();
				String SuccessfullMesg = driver.findElement(By.cssSelector("h5")).getText();
				Assert.assertEquals(SuccessfullMesg, "Thank you for booking appointment with "+DoctorFullName+" through Zoylo. Your appointment booking details are below:");
				RecipientPage.recipientLogout();				
				//
				Browser.openUrl(recipient_url);			
				//Verify Doctor Login with valid details
				DoctorsPage.SignIn(DoctorUserName, DoctorPassword);
				Browser.waitTill(60);
				Browser.waitFortheElementXpath("//div[@class='doctor-patientname patientfullName']/span");
				driver.findElement(By.xpath("(//div[@class='doctor-patientname patientfullName']/span)[last()]")).click();  // Recent Appointment
				Browser.waitTill(60);
				driver.findElement(By.xpath("//div[@id='checkIn']/span[2]")).click();
				Thread.sleep(2000);
				driver.findElement(By.id("startConsultation")).click();				
				Thread.sleep(2000);
				driver.findElement(By.id("diagnosis")).sendKeys("Diagonis Details");
				Thread.sleep(2000);
				driver.findElement(By.id("saveProblems")).click();
				Thread.sleep(5000);
				driver.findElement(By.id("saveVitals")).click();
				Thread.sleep(5000);
				driver.findElement(By.id("savePrescription")).click();
				Thread.sleep(5000);
				driver.findElement(By.id("saveNotes")).click();				
				Thread.sleep(5000);
				driver.findElement(By.id("generateReceipt")).click();
				Thread.sleep(5000);
			    Browser.verifyNotificationMessage("Bill generated successfully");
			    Thread.sleep(5000);
				driver.findElement(By.id("checkOut")).click();
				Thread.sleep(2000);
				Browser.verifyNotificationMessage("Appointment checked out successfully");
				DoctorsPage.doctorlogout();
				//Login as Recipient
				Browser.openUrl(recipient_url);			
				//Verify Recipient Login with valid details
				RecipientPage.recipientLogin(Username, Password);
				Thread.sleep(2000);
				driver.findElement(By.id("comment")).sendKeys("Review Comments test details Review Comments test details Review Comments test details Review Comment");
				driver.findElement(By.id("submitReview")).click();
				Browser.verifyNotificationMessage("Review submitted successfully");
	 
		 }else{
			 
			throw new SkipException("RUNMODE IS OFF");
			
		 }
			
			
	    }
    
	 
	 
	 
	 
	 
	 @AfterClass(groups = { "Regression","High" })
	 
	 public void Exit() {

	       
	       driver.close();
	       
	      
	    }
    
	

    
    
}