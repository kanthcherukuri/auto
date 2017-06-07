package recipientsTestScripts;

import org.testng.annotations.AfterClass;
import org.testng.annotations.Test;
import org.testng.annotations.BeforeClass;
import org.openqa.selenium.By;
import objectRepository.Elements_Admin;
import objectRepository.Elements_Recipients;
import testBase.LoadPropMac;
import testBase.RecipientPage;
import testBase.TestUtils;

public class Recipient_ZOY1986_PaymentPageNegativeScenario extends LoadPropMac
{
	public TestUtils Browser;
	public RecipientPage RecipientPage;
	
	@Test()
	public void paymentPageNegativeScenario() throws InterruptedException
	{
		RecipientPage.recipientLogin(Recipient_Username, Recipient_Password);
		Thread.sleep(2000);
		RecipientPage.searchInZoyloMAP(Doctor_Name);
		driver.findElement(By.xpath("//*[@id='bookAppointment']/button")).click();
		Browser.waitforTextbyxpath("//h1[contains(., 'Doctorzoylo')]", "Doctorzoylo");
		RecipientPage.selectDefaultSlot();
		Browser.waitforTextbyxpath("//h1[contains(., 'Book Appointment')]", "Book Appointment");
		String verifyDT=driver.findElement(By.xpath("//div[@class='d-y-t']")).getText();
		String verifyFee=driver.findElement(By.id("providerFees")).getText();
		RecipientPage.bookAppointment();
		RecipientPage.paymentOptions(3);
		Browser.waitFortheID("merchantlogo");
		driver.navigate().back();
		Browser.waitFortheElementXpath("//h4[contains(.,'Review Your Appointment Details')]");
		//Browser.waitforTextbyxpath("//div[@class='zy-sp-payment-values'])[6]", verifyTobePaid);
		driver.navigate().back();
		Browser.waitforTextbyxpath("//h1[contains(., 'Book Appointment')]", "Book Appointment");
		Browser.waitforTextbyxpath("//div[@class='d-y-t']", verifyDT);
		Browser.waitforTextbyID("providerFees", verifyFee);
		driver.navigate().back();
		Browser.waitforTextbyxpath("//h1[contains(., 'Doctorzoylo')]", "Doctorzoylo");
		driver.navigate().back();
		Browser.waitFortheElementXpath("//img[@class='indexProfileImg userImgBackground']");
	}
	
	@BeforeClass
	public void launchbrowser() throws Exception
	{
		LoadBrowserProperties();
		Elements_Admin.Admin_PageProperties(); // loading the Elements
		Elements_Recipients.Recipients_PageProperties();
		Browser= new TestUtils(driver);
		RecipientPage=new RecipientPage(driver);
		driver.get(recipient_url);
	}
	
	@AfterClass
     public void Exit() {
		
		driver.close();

	}
}
