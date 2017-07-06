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

public class Recipient_ZOY2032_14dayNegativeScenario extends LoadPropMac
{
	public TestUtils Browser;
	public RecipientPage RecipientPage;
	
	@Test()
	public void daysNegativeScenraio() throws InterruptedException
	{
		RecipientPage.recipientLogin(Recipient_Username, Recipient_Password);
		Thread.sleep(2000);
		RecipientPage.goToDiagnostics();
		RecipientPage.searchDCInZoyloMAP(Diagnostic_Name);
		RecipientPage.bookAppointmentOnDiagnostics();
		String dcName=Browser.getTextByXpath(Elements_Recipients.dcNameOnProfilePage);
		RecipientPage.selectAvailableSlotInDiagnostics("Cbt", "Zoylo Health Pkg");
		RecipientPage.confirmAppointmentOnDiagnostics();
		RecipientPage.makePayment();
		String checkdcName=Browser.getTextByXpath(Elements_Recipients.dcNameOnThankYouPage);
		if(checkdcName.contains(dcName))
		{
			System.out.println("DC appointment thank you page rendered");
		}
		//Browser.scrollbyxpath("//a[@class='desktop-logo']");
		driver.get(index_url);
		RecipientPage.goToDiagnostics();
		Browser.clickOnTheElementByID(Elements_Recipients.mapListingIcon);
		RecipientPage.searchInZoylodetailMAP(Diagnostic_Name);
		RecipientPage.bookAppointmentOnDiagnostics();
		Browser.waitFortheID("schedule-li");
		driver.findElement(By.id("schedule-li")).click();
		if(driver.findElements(By.xpath("//div[@class='zy-sap-calderThumb']")).size()>0)
		{
			System.out.println("14 day calendar is visible");
		}
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
