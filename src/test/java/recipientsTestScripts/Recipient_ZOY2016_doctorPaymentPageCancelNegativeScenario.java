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

public class Recipient_ZOY2016_doctorPaymentPageCancelNegativeScenario extends LoadPropMac
{
	public TestUtils Browser;
	public RecipientPage RecipientPage;
	
	@Test()
	public void docCancelPaymentNegativeScenario() throws InterruptedException
	{
		RecipientPage.recipientLogin(Recipient_Username, Recipient_Password);
		Thread.sleep(2000);
		RecipientPage.searchInZoyloMAP(Doctor_Name);
		RecipientPage.bookAppointment();
		String docName = Browser.getTextByXpath(Elements_Recipients.doctorNameOnProfile);
		RecipientPage.selectDefaultSlot();
		Browser.waitFortheElementXpath(Elements_Recipients.bookAptHeader);
		RecipientPage.bookAppointment();
		Browser.waitFortheElementXpath(Elements_Recipients.paymentPageHeader);
		Browser.scrollbyID(Elements_Recipients.cancelPaymentPage);
		driver.findElement(By.id(Elements_Recipients.cancelPaymentPage)).click();
		Browser.waitforTextbyxpath(Elements_Recipients.doctorNameOnProfile, docName);
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
	public void Exit() {
		
		driver.quit();
	} 
}
