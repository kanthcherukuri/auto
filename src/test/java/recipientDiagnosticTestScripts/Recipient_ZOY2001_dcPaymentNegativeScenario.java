package recipientDiagnosticTestScripts;

import org.testng.annotations.AfterClass;
import org.testng.annotations.Test;
import org.testng.annotations.BeforeClass;
import org.openqa.selenium.By;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import objectRepository.Elements_Admin;
import objectRepository.Elements_Recipients;
import testBase.LoadPropMac;
import testBase.RecipientPage;
import testBase.TestUtils;

public class Recipient_ZOY2001_dcPaymentNegativeScenario extends LoadPropMac
{
	public TestUtils Browser;
	public RecipientPage RecipientPage;
	
	@Test()
	public void dcpaymentNegativeScenario() throws InterruptedException
	{
		RecipientPage.recipientLogin(Recipient_Username, Recipient_Password);
		Thread.sleep(2000);
		RecipientPage.goToDiagnostics();
		RecipientPage.searchInZoyloMAP(Diagnostic_Name);
		RecipientPage.bookAppointmentOnDiagnostics();
		String dcName=driver.findElement(By.xpath("//span[@class='zy-rec-diag-m-d-name']")).getText();
		RecipientPage.selectAvailableSlotInDiagnostics("Cbt", "Zoylo Health Pkg");
		RecipientPage.confirmAppointmentOnDiagnostics();
		RecipientPage.paymentOptions(1);
		Browser.waitFortheID("merchantlogo");
		driver.navigate().back();
		Browser.waitFortheElementXpath("//span[contains(., 'Payment Options')]");
		driver.navigate().back();
		Browser.waitforTextbyxpath("//h1[contains(., 'Book Diagnostic Lab Test')]", "Book Diagnostic Lab Test");
		driver.navigate().back();
		Browser.waitforTextbyxpath("//span[@class='zy-rec-diag-m-d-name']", dcName);
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
	public void closeBrowser() {

	       driver.close();

	    }
}
