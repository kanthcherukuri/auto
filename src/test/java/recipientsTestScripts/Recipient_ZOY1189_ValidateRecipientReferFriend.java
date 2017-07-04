package recipientsTestScripts;

import org.testng.annotations.AfterClass;
import org.testng.annotations.Test;
import org.testng.annotations.BeforeClass;
import org.openqa.selenium.*;
import org.testng.Reporter;
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

		Browser.openUrl(loginPage_Url);			
		//Verify Recipient Login with valid details
		RecipientPage.recipientLogin(Recipient_Username, Recipient_Password);
		Thread.sleep(2000);
		RecipientPage.openMyAccounts("Refer");
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
		Browser.verifyNotificationMessage("Referral code sent successfully");
		Thread.sleep(10000);
		//verify Mobile
		driver.findElement(By.id("btnRefer")).click();
		driver.findElement(By.id("refereeEmail")).sendKeys("ganesh@in.com");
		driver.findElement(By.id("sendRefer")).click();
		Browser.verifyNotificationMessage("Referral code sent successfully");


	}

	@AfterClass(groups = { "Regression","High" })
	public void Exit() {
		driver.quit();
	}  

}