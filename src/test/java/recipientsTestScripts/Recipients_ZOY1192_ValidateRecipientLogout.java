package recipientsTestScripts;




import org.testng.annotations.AfterClass;
import org.testng.annotations.Test;
import org.testng.annotations.BeforeClass;
import org.testng.Reporter;
import testBase.*;
import objectRepository.*;

public class Recipients_ZOY1192_ValidateRecipientLogout extends LoadPropMac {
	public RecipientPage RecipientPage;
	public TestUtils Browser;	

	@BeforeClass(groups = { "Regression","High" })	
	public void LaunchBrowser() throws Exception {

		LoadBrowserProperties(); // Create driver instance and launch the browser
		Elements_Recipients.Recipients_PageProperties();// loading UI Page Elements / Locators
		RecipientPage = new RecipientPage(driver); // Loading Pages
		Browser= new TestUtils(driver);  

	} 

	@Test(groups = { "Regression","High" })
	public void validateRecipientlogout() throws Exception {

		
		Browser.openUrl(loginPage_Url);			
		//Verify Recipient Login with valid details
		RecipientPage.recipientLogin(Recipient_Username, Recipient_Password);
		Thread.sleep(2000);
		RecipientPage.recipientLogout();
		Reporter.log("Logged out Successfully");
		//JavascriptExecutor jse = (JavascriptExecutor)driver;
		//jse.executeScript("scroll(0, 250)"); // if the element is on bottom. 
	
		
		/*String Email= Browser.emailResponse("ganeshzoylo@gmail.com", "Zoylo@123", "Zoylo.com | Your appointment with Dr.Doctorzoylo has been confirmed.");
		System.out.println("Email_response="+Email);
		Assert.assertTrue(Email.contains("Your doctor appointment booked on Zoylo.com is CONFIRMED."));
        */
	}
	
	@AfterClass(groups = { "Regression","High" })
	public void Exit() {
		
		driver.quit();
	} 





}