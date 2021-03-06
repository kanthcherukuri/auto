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

//@Author: Sagar Sen

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
		Exit();
		launchbrowser();
		//Recipient
		RecipientPage.recipientLogin(Recipient_Username, Recipient_Password);
		Thread.sleep(2000);
		RecipientPage.searchInZoyloMAP("Zombidoctor");
		driver.findElement(By.xpath("//*[@id='bookAppointment']/button")).click();
		Browser.waitforTextbyxpath("//h1[@class='tr-override-dctr-content-h1']", "Zombidoctor");
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
			System.out.println("Home visit fee on Confirm Appointment page is "+bookPageFee);
		}
		//RecipientPage.bookAppointment();
		RecipientPage.confirmAppointment("Home Visit");
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
		Browser.openUrl("https://"+Environment_Name+".zoylo.com/login");
	}
	
	@AfterClass
	public void Exit() {
		
		driver.quit();
	} 
}
