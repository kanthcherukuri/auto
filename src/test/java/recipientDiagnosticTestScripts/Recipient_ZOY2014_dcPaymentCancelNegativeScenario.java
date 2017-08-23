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

public class Recipient_ZOY2014_dcPaymentCancelNegativeScenario extends LoadPropMac
{
	public TestUtils Browser;
	public RecipientPage RecipientPage;
	
	@Test()
	public void DCpaymentCancel() throws InterruptedException
	{
		RecipientPage.recipientLogin(Recipient_Username, Recipient_Password);
		RecipientPage.goToDiagnostics();
		RecipientPage.searchDCInZoyloMAP(Diagnostic_Name);
		RecipientPage.bookAppointmentOnDiagnostics();
		String dcName=driver.findElement(By.xpath("//span[@class='zy-rec-diag-m-d-name']")).getText();
		RecipientPage.selectAvailableSlotInDiagnostics("Cbt", "Zoylo Health Pkg");
		RecipientPage.confirmAppointmentOnDiagnostics();
		Browser.waitFortheElementXpath("//*[@id='proceed']");
		Browser.scrollbyID("cancel");
		driver.findElement(By.id("cancel")).click();
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
		Browser.openUrl("https://"+Environment_Name+".zoylo.com/login");
	}
	
	@AfterClass
	public void closeBrowser() {

		driver.quit();
	    }
}
