package recipientsTestScripts;

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

public class Recipient_ZOY2019_updateHomeVisitFeeNegativeScenario extends LoadPropMac
{
	public TestUtils Browser;
	public RecipientPage RecipientPage;
	public testBase.DoctorsPage DoctorsPage;
	String homeFee="333";
	
	@Test()
	public void homeFeeUpdateScenario() throws Exception
	{
		//Doctor
		DoctorsPage.SignIn(DoctorsLogin_usernametwo, DoctorsLogin_passwordtwo);
		DoctorsPage.goToScheduleHomeVisit();
		driver.findElement(By.id("houseCallServiceFee")).clear();
		driver.findElement(By.id("houseCallServiceFee")).sendKeys(homeFee);
		Browser.scrollbyxpath("(//div[@class='sp-doc-clinic-schd-save-btn'])[2]");
		driver.findElement(By.xpath("(//div[@class='sp-doc-clinic-schd-save-btn'])[2]")).click();
		Browser.CheckNotificationMessage("Schedule Updated Successfully");
		closebrowser();
		launchbrowser();
		//Recipient
		RecipientPage.recipientLogin(Recipient_Username, Recipient_Password);
		Thread.sleep(2000);
		RecipientPage.searchInZoyloMAP("srscript");
		driver.findElement(By.xpath("//*[@id='bookAppointment']/button")).click();
		Browser.waitforTextbyxpath("//h1[@class='tr-override-dctr-content-h1']", "Srscript");
		String checkHomeFee = driver.findElement(By.xpath("(//div[@class='zy-homevisitfee']//span)[2]")).getText();
		if(checkHomeFee.contains(homeFee))
		{
			System.out.println("Home visit fee on provider details page is "+checkHomeFee);
		}
		RecipientPage.selectHomeVisitSlot();
		Browser.waitforTextbyxpath("//div[@class='back-Heading']", "Book Appointment");
		String bookPageFee = driver.findElement(By.id("providerFees")).getText();
		if(bookPageFee.contains(homeFee))
		{
			System.out.println("Home visit fee on book apt page is "+bookPageFee);
		}
		RecipientPage.bookAppointment();
		Browser.waitforTextbyxpath("//h4[contains(.,'Review Your Appointment Details')]", "Review Your Appointment Details");
		String pmtPageFee = driver.findElement(By.xpath("(//div[@class='zy-sp-payment-values'])[1]")).getText();
		if(pmtPageFee.contains(homeFee))
		{
			System.out.println("Home visit fee on book apt page is "+pmtPageFee);
		}
		RecipientPage.makePayment();
		Browser.waitforTextbyxpath("(//div[@class='book-dtbox']//p)[2]", homeFee);
		String thanksPageFee = driver.findElement(By.xpath("(//div[@class='book-dtbox']//p)[2]")).getText();
		if(thanksPageFee.contains(homeFee))
		{
			System.out.println("Home visit fee on thank you page is "+thanksPageFee);
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
		DoctorsPage=new testBase.DoctorsPage(driver);
		driver.get(recipient_url);
	}
	
	@AfterClass
     public void closebrowser() {
		
		driver.close();

	}
}
