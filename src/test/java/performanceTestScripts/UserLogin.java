package performanceTestScripts;



import org.openqa.selenium.*;
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
public class UserLogin extends LoadPropMac {
	public RecipientPage RecipientPage;
	public TestUtils Browser;	




	@BeforeClass(groups = { "Regression","High" })	
	public void Login() throws Exception {

		LoadBrowserProperties(); // Create driver instance and launch the browser
		Elements_Recipients.Recipients_PageProperties();// loading UI Page Elements / Locators
		RecipientPage = new RecipientPage(driver); // Loading Pages
		Browser= new TestUtils(driver);   
		//Test Starts-Here
		Browser.openUrl(loginPage_Url);			
		//Verify Recipient Login with valid details
		Browser.waitFortheID("emailAddress");		
		driver.findElement(By.id(Elements_Recipients.Recipient_UserName)).sendKeys(Recipient_Username);
		driver.findElement(By.id(Elements_Recipients.Recipient_Password)).sendKeys(Recipient_Password);
		

	} 


	@Test(priority=1)
	public void loginUserResponseTime() throws Exception {

		driver.findElement(By.xpath(Elements_Recipients.Recipient_Button_Login)).click();
		 Browser.waitFortheElementXpath("//*[@id='myaccount']/span[2]");

	}

	
	


	@AfterClass(groups = { "Regression","High" })

	public void Exit() {


		driver.close();


	}





}

