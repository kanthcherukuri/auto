package recipientsTestScripts;




import org.openqa.selenium.*;
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
public class Recipient_ZOY1189_ValidateRecipientReferFriend extends LoadPropMac {
	public RecipientPage RecipientPage;
	public TestUtils Browser;	

	@BeforeClass(groups = { "Regression","High" })	
	public void LaunchBrowser() throws Exception {

		LoadBrowserProperties(); // Create driver instance and launch the browser
		Elements_Recipients.Recipients_PageProperties();// loading UI Page Elements / Locators
		RecipientPage = new RecipientPage(driver); // Loading Pages
		Browser= new TestUtils(driver);  

	} 

	@Test(groups = { "Regression","Medium" })
	public void validateRecipientReferFriend() throws Exception {

		Browser.openUrl(recipient_url);			
		//Verify Recipient Login with valid details
		RecipientPage.recipientLogin(Recipient_Username, Recipient_Password);
		Thread.sleep(2000);
		RecipientPage.goToMyAccount();
		driver.findElement(By.xpath("//*[@id='tabs']/li[contains(.,'Refer')]")).click();
		Thread.sleep(2000);
		//verify field validations
		driver.findElement(By.id("btnRefer")).click();
		driver.findElement(By.id("refereeMobileNumber")).sendKeys("");
		driver.findElement(By.id("refereeEmail")).sendKeys("");
		driver.findElement(By.id("sendRefer")).click();
		Browser.verifyNotificationMessage("Enter Mobile Number or Email ID to send referral code");
		Thread.sleep(10000);
		//verify Mobile
		driver.findElement(By.id("btnRefer")).click();
		driver.findElement(By.id("refereeMobileNumber")).sendKeys("9912345070");
		driver.findElement(By.id("sendRefer")).click();
		Browser.verifyNotificationMessage("Referral Code send successfully");
		Thread.sleep(10000);
		//verify Mobile
		driver.findElement(By.id("btnRefer")).click();
		driver.findElement(By.id("refereeEmail")).sendKeys("ganesh@in.com");
		driver.findElement(By.id("sendRefer")).click();
		Browser.verifyNotificationMessage("Referral Code send successfully");
		//Verify the Logout from the App
		RecipientPage.recipientLogout();
		Reporter.log("Logged out Successfully");

	}

	@AfterClass(groups = { "Regression","High" })
	public void Exit() {

		driver.close();

	}  

}