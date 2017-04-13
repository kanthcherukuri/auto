package performanceTestScripts;



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
public class Recipient_ZOY1063_BookAnAppointment extends LoadPropMac {
	public RecipientPage RecipientPage;
	public TestUtils Browser;	




	@BeforeClass
	public void LaunchBrowser() throws Exception {

		LoadBrowserProperties(); // Create driver instance and launch the browser
		Elements_Recipients.Recipients_PageProperties();// loading UI Page Elements / Locators
		RecipientPage = new RecipientPage(driver); // Loading Pages
		Browser= new TestUtils(driver);        
		//Test Starts-Here
		Browser.openUrl(recipient_url);			
		//Verify Recipient Login with valid details
		RecipientPage.recipientLogin(Recipient_Username, Recipient_Password);
		Thread.sleep(2000);
		RecipientPage.searchInZoyloMAP(Doctor_Name);
	} 

	@Test(priority=1)
	public void bookADoctor( ) throws Exception {

		driver.findElement(By.xpath("//*[@id='bookAppointment']/button")).click(); 
		Browser.waitFortheElementXpath("(//*[@id='apponitmentTime' and @class='sp-available-slots'])[1]");
	}
	
	@Test(priority=2)
	public void selectASlot( ) throws Exception {
		
		driver.findElement(By.xpath("(//*[@id='apponitmentTime' and @class='sp-available-slots'])[1]")).click(); 
		Browser.waitFortheElementXpath("//div[text()='Confirm Appointment']");
	}

	@Test(priority=3)
	public void confirmAppointment( ) throws Exception {
		driver.findElement(By.id("problem")).sendKeys("Health Details");
		driver.findElement(By.xpath("//input[@value='self']")).click();
		driver.findElement(By.xpath("//div[text()='Confirm Appointment']")).click();
		Browser.waitFortheID("proceed");	
	}
	
	@Test(priority=4)
	public void ZPaymentDetails() throws Exception {
		Thread.sleep(5000);
		Browser.waitFortheID("applyPromocode");
		driver.findElement(By.id("applyPromocode")).click();
		driver.findElement(By.xpath("(//input[@name='paymentOption'])[3]")).click();
		driver.findElement(By.id("termsAndConditions")).click();
		
		
	}
	@Test(priority=5)
	public void makePayment() throws Exception {

		driver.findElement(By.id("proceed")).click(); 
		Browser.waitFortheElementXpath("(//img[@class='img-responsive'])[3]");
		String ThankUpPage = driver.findElement(By.xpath("//h5")).getText();
       Assert.assertTrue(ThankUpPage.contains("Thank you for booking appointment"));
		
		
	}
	@AfterClass

	public void Exit() {
		driver.close();

	}





}