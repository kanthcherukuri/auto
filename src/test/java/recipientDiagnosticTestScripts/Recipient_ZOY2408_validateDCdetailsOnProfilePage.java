package recipientDiagnosticTestScripts;
import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import objectRepository.Elements_Diagnostics;
import objectRepository.Elements_NewAdminDoctors;
import objectRepository.Elements_Recipients;
import testBase.DiagnosticPage;
import testBase.LoadPropMac;
import testBase.RecipientPage;
import testBase.TestUtils;

//@Authout: Sagar Sen

public class Recipient_ZOY2408_validateDCdetailsOnProfilePage extends LoadPropMac
{
	public TestUtils Browser;
	public RecipientPage RecipientPage;
	public DiagnosticPage DiagnosticPage;
	public String aboutData="This is about dc.";
	
	@Test()
	public void validateDCdetails() throws Exception
	{
		//Diagnostic profile
		DiagnosticPage.SignIn("indiandc@zoy.com", "Zoylo@123");
		Browser.waitFortheID(Elements_Diagnostics.clickondashboardmenu);
		driver.get("https://"+LoadPropMac.Environment_Name+".zoylo.com/zyDiagnosticCenterAccount");
		Browser.clickOnTheElementByID(Elements_Diagnostics.dc_ProfileEditBtn);
		Browser.clickOnTheElementByID(Elements_Diagnostics.dc_ProfileAboutTxt);
		driver.findElement(By.id(Elements_Diagnostics.dc_ProfileAboutTxt)).clear();
		driver.findElement(By.id(Elements_Diagnostics.dc_ProfileAboutTxt)).sendKeys(aboutData);
		Browser.clickOnTheElementByID(Elements_Diagnostics.aboutsave);
		Browser.CheckNotificationMessage("Your profile updated successfully");
		Thread.sleep(2000);
		String profileRegNum=Browser.getTextByXpath(Elements_Diagnostics.dc_ProfileRegNum);
		String profileLanguage=Browser.getTextByID(Elements_Diagnostics.dc_ProfileLanguage);
		String profileEstablishedValue=Browser.getTextByXpath(Elements_Diagnostics.dc_ProfileEstablishedVaue);
		//DC Payment accepted
		Browser.clickOnTheElementByXpath(Elements_Diagnostics.dc_ProfilePaymentTab);
		Browser.clickOnTheElementByID(Elements_Diagnostics.dc_ProfilePaymentCash);
		Browser.clickOnTheElementByID(Elements_Diagnostics.dc_ProfilePaymentSave);
		Browser.CheckNotificationMessage("Payment information updated successfully");
		Thread.sleep(2000);
		DiagnosticPage.diagnosticslogout(); //logout
		
		//Recipient assert
		Browser.waitFortheElementXpath(Elements_NewAdminDoctors.recipient_IndexAccountIcon);
		RecipientPage.goToDiagnostics();
		RecipientPage.searchDCInZoyloMAP("Petroliumdc");
		RecipientPage.bookAppointmentOnDiagnostics();
		Browser.clickOnTheElementByXpath(Elements_Recipients.recipient_DCProfileAbout);
		Thread.sleep(300);
		String dcabout=Browser.getTextByXpath(Elements_Recipients.recipient_DCProfileABoutText);
		Assert.assertEquals(dcabout, aboutData);
		String dcRegNum=Browser.getTextByXpath(Elements_Recipients.recipient_DCProfileRegNum);
		Assert.assertEquals(dcRegNum, profileRegNum);
		String dcEstablishedYear=Browser.getTextByXpath(Elements_Recipients.recipient_DCEstablishedYear);
		Assert.assertEquals(dcEstablishedYear, profileEstablishedValue);
		String dcLanguage=Browser.getTextByXpath(Elements_Recipients.recipient_DCLanguage);
		Assert.assertEquals(dcLanguage, profileLanguage);
		String dcPaymentOption=Browser.getTextByXpath(Elements_Recipients.recipient_DCPayment);
		Assert.assertEquals(dcPaymentOption, "Cash");
		
		//DC reset value
		Browser.openUrl("https://"+Environment_Name+".zoylo.com/login");
		DiagnosticPage.SignIn("indiandc@zoy.com", "Zoylo@123");
		Browser.waitFortheID(Elements_Diagnostics.clickondashboardmenu);
		driver.get("https://"+LoadPropMac.Environment_Name+".zoylo.com/zyDiagnosticCenterAccount");
		Browser.clickOnTheElementByXpath(Elements_Diagnostics.dc_ProfilePaymentTab);
		Browser.clickOnTheElementByID(Elements_Diagnostics.dc_ProfilePaymentCash);
		Browser.clickOnTheElementByID(Elements_Diagnostics.dc_ProfilePaymentSave);
		Browser.CheckNotificationMessage("Payment information updated successfully");
		Thread.sleep(6000);
		DiagnosticPage.diagnosticslogout(); //logout
	}
	
	@BeforeClass
	public void launchbrowser() throws Exception
	{
		LoadBrowserProperties();
		Elements_NewAdminDoctors.newAdmin_DoctorPageProperties(); // loading the Elements
		Elements_Recipients.Recipients_PageProperties();
		Elements_Diagnostics.Diag_PageProperties();
		Browser= new TestUtils(driver);
		RecipientPage=new RecipientPage(driver);
		DiagnosticPage=new DiagnosticPage(driver);
		Browser.openUrl("https://"+Environment_Name+".zoylo.com/login");
	}
	
	@AfterClass
	public void closeBrowser() 
	{
		driver.quit();
	}
}
