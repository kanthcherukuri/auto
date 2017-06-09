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

public class Recipient_ZOY2023_homeVisitwithoutLoginNegativeScenario extends LoadPropMac
{
	public TestUtils Browser;
	public RecipientPage RecipientPage;
	
	@Test()
	public void homeVisitWithoutLogin() throws InterruptedException
	{
		RecipientPage.searchInZoyloMAP("srscript");
		driver.findElement(By.xpath("//*[@id='bookAppointment']/button")).click();
		Browser.waitforTextbyxpath("//h1[@class='tr-override-dctr-content-h1']", "Srscript");
		String checkHomeFee = driver.findElement(By.xpath("(//div[@class='zy-homevisitfee']//span)[2]")).getText();
		String checkHomeTime=RecipientPage.selectHomeVisitSlot();
		Browser.waitFortheID("emailAddress");
		RecipientPage.recipientLogin(Recipient_Username, Recipient_Password);
		String checkonBookPayFee = driver.findElement(By.id("providerFees")).getText();
		if(checkHomeFee.contains(checkonBookPayFee))
		{
			System.out.println("Home visit fee on provider details page is "+checkHomeFee);
		}
		
		//System.out.println("The home visit time selected is "+checkHomeTime);
		Browser.waitFortheElementXpath("//div[@class='d-y-t']");
		String verifyTime=driver.findElement(By.xpath("//div[@class='d-y-t']")).getText();
		if(verifyTime.contains(checkHomeTime))
		{
			System.out.println("The home visit time selected is "+verifyTime);
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
		//driver.get(loginPage_Url);
		driver.get(index_url);
	}
	
	@AfterClass
	public void Exit() {
		
		driver.quit();
	} 
}
