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
		RecipientPage.bookAppointment();
		RecipientPage.selectDefaultSlot();
		Browser.waitFortheElementXpath(Elements_Recipients.bookAptHeader);
		String verifyDT= Browser.getTextByXpath(Elements_Recipients.bookAptPageDate);
		String verifyFee=Browser.getTextByID(Elements_Recipients.bookAptPageFee);
		RecipientPage.bookAppointment();
	   
		Browser.waitFortheID(Elements_Recipients.makePaymentBtn);
		Browser.scrollbyID(Elements_Recipients.makePaymentBtn);
		driver.findElement(By.id(Elements_Recipients.makePaymentBtn)).click();     //Make payment
		Browser.waitFortheID("merchantlogo");
		driver.navigate().back();
		Browser.waitFortheElementXpath(Elements_Recipients.paymentPageHeader);
		//Browser.waitforTextbyxpath("//div[@class='zy-sp-payment-values'])[6]", verifyTobePaid);
		driver.navigate().back();
		Browser.waitFortheElementXpath(Elements_Recipients.bookAptHeader);
		Browser.waitforTextbyxpath(Elements_Recipients.bookAptPageDate, verifyDT);
		Browser.waitforTextbyID(Elements_Recipients.bookAptPageFee, verifyFee);
		driver.navigate().back();
		Browser.waitforTextbyxpath(Elements_Recipients.doctorNameOnProfile, Doctor_Name);
		driver.navigate().back();
		Browser.waitFortheElementXpath(Elements_Recipients.indexHeaderUserIcon);
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
	
	@AfterClass()
	public void Exit() {
		
		driver.quit();
	} 
}
