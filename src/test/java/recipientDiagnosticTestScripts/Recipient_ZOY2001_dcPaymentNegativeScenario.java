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
		RecipientPage.searchDCInZoyloMAP(Diagnostic_Name);
		RecipientPage.bookAppointmentOnDiagnostics();
		String dcName=Browser.getTextByXpath(Elements_Recipients.dcNameOnProfilePage);
		RecipientPage.selectAvailableSlotInDiagnostics("Cbt", "Zoylo Health Pkg");
		RecipientPage.confirmAppointmentOnDiagnostics();
		Browser.clickOnTheElementByID("proceed");
		Browser.waitFortheID("merchantlogo");
		driver.navigate().back();
		Browser.waitFortheID("proceed");
		driver.navigate().back();
		Browser.waitforTextbyxpath("//h2[contains(., '"+Diagnostic_Name+"')]", Diagnostic_Name);

	}
	
	@BeforeClass
	public void launchbrowser() throws Exception
	{
		LoadBrowserProperties();
		Elements_Admin.Admin_PageProperties(); // loading the Elements
		Elements_Recipients.Recipients_PageProperties();
		Browser= new TestUtils(driver);
		RecipientPage=new RecipientPage(driver);
		driver.get(loginPage_Url);
	}
	
	@AfterClass
	public void closeBrowser() {

		driver.quit();
	    }
}
