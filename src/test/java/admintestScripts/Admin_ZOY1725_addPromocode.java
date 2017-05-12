package admintestScripts;

import org.testng.annotations.AfterClass;
import org.testng.annotations.Test;
import org.testng.annotations.BeforeClass;
import org.openqa.selenium.By;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import objectRepository.Elements_Admin;
import objectRepository.Elements_Recipients;
import testBase.AdminPage;
import testBase.LoadPropMac;
import testBase.TestUtils;

public class Admin_ZOY1725_addPromocode extends LoadPropMac
{
	public TestUtils Browser;
	public AdminPage admin;
	
	//Global variables for pre condition values
	public String zqa = "https://zoyloqa.zoylo.com/admin/zyProviderPromoCodes";
	public String pit = "https://pit.zoylo.com/admin/zyProviderPromoCodes";
	public String dev = "https://dev.zoylo.com/admin/zyProviderPromoCodes";
	public String promoType = "promotion"; //promotion OR referral ONLY
	public String codeName = "Script3";
	public String desc = "Availe "+codeName+ " promoCode";
	public String refferalValue = "10";
	public String refreValue = "20";
	public String promoValue = "25";
	public String miniAmt = "1";
	public String codeApplyType="automatic"; //automatic OR manual ONLY
	
	
	@Test(priority=1)
	public void addPromo()
	{
		admin.adminSignIn(admin_user, admin_password);
		Browser.waitFortheElementXpath("//span[@class='welcome-admin']");
		//Change environment
		driver.get(zqa);
		Browser.waitforTextbyxpath("//h4[contains(., 'Provider Promotions')]", "Provider Promotions");
		driver.findElement(By.id("add")).click();
		Browser.waitforTextbyxpath("//h4[contains(., 'Provider Promotion Code - Add')]", "Provider Promotion Code - Add");
	} //End of P1
	
	@DataProvider(name="promoDetails")
	public Object[][] datadetails()
	{
		return new Object[][]
				{
					{promoType, codeName, desc, refferalValue, refreValue, promoValue, miniAmt, codeApplyType}
				};
	}
	
	@Test(dataProvider="promoDetails", priority=2)
	public void addPromoDetails(String codeType, String promoName, String dec, String refValue, String refreeValue, String promValue, String minAmt, String applyType) throws InterruptedException
	{
		if(codeType.equalsIgnoreCase("referral"))
		{
			driver.findElement(By.xpath("//label[@class='radio-inline fix-indent']//input[@value='referral']")).click();
		}
		
		Thread.sleep(1500);
		driver.findElement(By.name("code")).sendKeys(promoName);
		
		//Date time increment
	    driver.findElement(By.name("validity.from")).click();
	    driver.findElement(By.name("validity.from")).clear();
	    Browser.dateTimeIncrement(5, "validity.from");
	    
	    driver.findElement(By.name("validity.to")).click();
	    driver.findElement(By.name("validity.to")).clear();
	    Browser.yearIncrement(5, "validity.to");
	    
	    driver.findElement(By.xpath("//textarea[@name='description']")).sendKeys(dec);
	    
	    if(codeType.equalsIgnoreCase("referral"))
		{
	    	Browser.scrollbyxpath("//label[contains(., 'Description')]");
			driver.findElement(By.name("referral.discountValue")).sendKeys(refValue);		
			driver.findElement(By.name("referee.discountValue")).sendKeys(refreeValue);
		} // FOR REFERAL
	    else{
	    	Browser.scrollbyxpath("//label[contains(., 'Percentage/Amount')]");
		    driver.findElement(By.name("discountValue")).sendKeys(promValue);
	    }

	    driver.findElement(By.name("minimumPurchase")).clear();
	    driver.findElement(By.name("minimumPurchase")).sendKeys(minAmt);
	    
	    Browser.scrollbyxpath("//label[contains(., 'To Age')]");
	    driver.findElement(By.id("checkAll")).click();
	    Browser.scrollbyID("submitCancel");
	    
	    if(applyType.equalsIgnoreCase("automatic"))
	    {
	    	driver.findElement(By.xpath("//input[@value='automatic']")).click();
	    }
	    Thread.sleep(1000);
	    driver.findElement(By.xpath("//button[@type='submit']")).click();
	    Browser.waitforTextbyxpath("//h4[contains(., 'Provider Promotions')]", "Provider Promotions");
	    
	}

	@BeforeClass
	public void launchbrowser() throws Exception
	{
		LoadBrowserProperties();
		Elements_Admin.Admin_PageProperties(); // loading the Elements
		Elements_Recipients.Recipients_PageProperties();
		Browser= new TestUtils(driver);
		admin=new AdminPage(driver);
		driver.get(recipient_url);
	}
	
	@AfterClass
	public void closebrowser() throws InterruptedException
	{
		Thread.sleep(5000);
		driver.close();
	}
}
