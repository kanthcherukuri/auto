
//Author:Ch.LakshmiKanth

package zoyloMT;

import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import objectRepository.Elements_ZMTusers;
import testBase.LoadPropMac;
import testBase.TestUtils;
import testBase.ZMTPage;

public class ZMT_Careers_ZOY2660 extends LoadPropMac
{
	public TestUtils Browser;
	public ZMTPage zmtUserPage;
	
		@BeforeClass
		public void Browser() throws Exception {	
		LoadBrowserProperties();
		Browser= new TestUtils(driver);
		zmtUserPage= new ZMTPage(driver);
		Browser.openUrl("https://qa.zoylomt.com");
		Browser.clickOnTheElementByID(Elements_ZMTusers.zmt_career_menuTab);
	}
	
	@Test(priority=1)
	public void CheckCareersPage() throws Exception {
		String email="kanth"+Browser.randomalphabets()+"@gmail.com" ;
		String mobile="9"+Browser.generateRandomNumber(9);
		zmtUserPage.Details_Careers("LakshmiKanth", email, mobile, "10", "5", "Cognizant", "Senior", "500000");
		Browser.zmt_notification("Your profile is submitted successfully");
		driver.navigate().refresh();
	}
	
	
	@DataProvider(name="Careervalidation")
	public Object[][] clinicDocInfo() throws Exception
	{
		Object[][] clinicDocInformation=TestUtils.getTableArray("TestData/zmt.xls", "validation", "ZMT2660");
		return(clinicDocInformation);
	}
	
	@Test(dataProvider="Careervalidation",priority=2)
	public void CheckCareersValidation(String fullname,String email,String mobile,String expinyears,String expinmonths,String currentemployee,String applyingfor,String currentctc,
			String Afullname,String Aemail,String Amobile,String Aexpinyears,String Aexpinmonths,String Acurrentemployee,String Aapplyingfor,String Acurrentctc) {
		
		Browser.clickOnTheElementByID(Elements_ZMTusers.zmt_career_menuTab);
		zmtUserPage.Details_Careers(fullname, email, mobile, expinyears, expinmonths, currentemployee, applyingfor, currentctc);
		String name= driver.findElement(By.xpath(Elements_ZMTusers.careers_fullnamevalidationtext)).getText();
		Assert.assertEquals(name, Afullname);
		String mail=driver.findElement(By.xpath(Elements_ZMTusers.careers_emailvalidationtext)).getText();
		Assert.assertEquals(mail, Aemail);
		String phno=driver.findElement(By.xpath(Elements_ZMTusers.careers_mobilevalidationtext)).getText();
		Assert.assertEquals(phno, Amobile);
		String years=driver.findElement(By.xpath(Elements_ZMTusers.careers_yearsofexperiencevalidationtext)).getText();
		Assert.assertEquals(years, Aexpinyears);
		String months=driver.findElement(By.xpath(Elements_ZMTusers.careers_monthsofexperirncevalidationtext)).getText();
		Assert.assertEquals(months, Aexpinmonths);
		String currentemp=driver.findElement(By.xpath(Elements_ZMTusers.careers_currentemployeevalidationtext)).getText();
		Assert.assertEquals(currentemp, Acurrentemployee);
		String position=driver.findElement(By.xpath(Elements_ZMTusers.careers_applyingforvalidationtext)).getText();
		Assert.assertEquals(position, Aapplyingfor);
		String ctc=driver.findElement(By.xpath(Elements_ZMTusers.careers_currentctcvalidationtext)).getText();
		Assert.assertEquals(ctc, Acurrentctc);
		driver.navigate().refresh();
	}
	
	@AfterClass
	public void CloseBrowser() {
		driver.quit();
	}

}
