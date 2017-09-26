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

public class ZMT_InsurancecompanyProfile_ZOY2674  extends LoadPropMac {
	
	public TestUtils Browser;
	public ZMTPage zmtUserPage;
	public String emailID="starhealthinsurone@gmail.com";
	
	
	@BeforeClass
	public void Browser() throws Exception {	
	LoadBrowserProperties();
	Browser= new TestUtils(driver);
	zmtUserPage= new ZMTPage(driver);
	Browser.openUrl("https://"+Zmt_environmentname+".com");
	}
	
	@Test(priority=1)
	public void CheckTourismAgentProfile() throws Exception {
		Browser.clickOnTheElementByID(Elements_ZMTusers.zmt_login);
		Browser.clickOnTheElementByXpath(Elements_ZMTusers.zmt_SignUp_Button);
		Thread.sleep(1000);
		zmtUserPage.SignUpForm_Details("HDFCERGO", "HDFC", emailID, "India", "Hyderabad", "kanth@666", "kanth@666", "9966002222", "Insurance Company", "Mumbai");
		Browser.clickOnTheElementByID(Elements_ZMTusers.signUp_submit);
		Browser.zmt_notification("user created successfully");
		String checkfname=Browser.getTextBoxValueByID(Elements_ZMTusers.profile_firstName);
		Assert.assertEquals(checkfname, "HDFCERGO");
		String checklastname=Browser.getTextBoxValueByID(Elements_ZMTusers.profile_lastName);
		Assert.assertEquals(checklastname, "HDFC");
		String checkphone=Browser.getTextBoxValueByID(Elements_ZMTusers.profile_phNum);
		Assert.assertEquals(checkphone, "9966002222");
		String checkaddress=Browser.getTextBoxValueByID(Elements_ZMTusers.profile_homeAddress);
		Assert.assertEquals(checkaddress, "Mumbai");
		
	}
	
	
	@DataProvider(name="InsuranceProfileValidation")
	public Object[][] insurance() throws Exception
	{
		Object[][] InsuranceInformation=TestUtils.getTableArray("TestData/zmt.xls", "OtherProfile", "ZMT2674");
		return(InsuranceInformation);
	}
	
	
	
	@Test(dataProvider="InsuranceProfileValidation",priority=2)
	public void CheckInsuranceCompanyProfileValidation(String ICFirstName,String ICLastName,String ICPhone,String ICaddress, String ICServices,
	String ICPersonName,String ICPersonemail,String ICPersonPhone,String ICPersonAvailabilityFrom,String ICPersonAvailabilityTo,String Afname,
	String Alname,String Aphnum,String Aaddress,String Acontactname,String Acontactemail,String Acontactphone,String AavailabilityFrom,String AavailabilityTo) throws Exception {
		
		
		zmtUserPage.InsuranceCompanyProfile_Details(ICFirstName, ICLastName, ICPhone, ICaddress, ICServices, ICPersonName, ICPersonemail, ICPersonPhone, ICPersonAvailabilityFrom, ICPersonAvailabilityTo);
		Browser.clickOnTheElementByID(Elements_ZMTusers.profile_myAccountSave);
		String fname=driver.findElement(By.xpath(Elements_ZMTusers.profile_firstName_Validation)).getText();
		Assert.assertEquals(fname, Afname);
		String lname=driver.findElement(By.xpath(Elements_ZMTusers.profile_lastName_Validation)).getText();
		Assert.assertEquals(lname, Alname);
		String phnum=driver.findElement(By.xpath(Elements_ZMTusers.profile_phNum_Validation)).getText();
		Assert.assertEquals(phnum, Aphnum);
		String contactname=driver.findElement(By.xpath(Elements_ZMTusers.profile_contactperson_name_validation)).getText();
		Assert.assertEquals(contactname, Acontactname);
		String contactemail=driver.findElement(By.xpath("(//input[@id='email']//following-sibling::ul)[2]")).getText();
		Assert.assertEquals(contactemail, Acontactemail);
		String contactphone=driver.findElement(By.xpath(Elements_ZMTusers.profile_contactperson_phone_validation)).getText();
		Assert.assertEquals(contactphone, Acontactphone);
		String availabilityFrom=driver.findElement(By.xpath(Elements_ZMTusers.profile_contactperson_availabityfrom_validation)).getText();
		Assert.assertEquals(availabilityFrom, AavailabilityFrom);
		String availabilityTo=driver.findElement(By.xpath(Elements_ZMTusers.profile_contactperson_availabityTo_validation)).getText();
		Assert.assertEquals(availabilityTo, AavailabilityTo);
		
	}
	
	@DataProvider(name="InsuranceProfileSave")
	public Object[][] insurancesave() throws Exception
	{
		Object[][] Insurancesave=TestUtils.getTableArray("TestData/zmt.xls", "OtherProfile", "ZMT2674S");
		return(Insurancesave);
	}
	
	@Test(dataProvider="InsuranceProfileSave",priority=3)
	public void CheckInsuranceProfileSave(String ICFirstName,String ICLastName,String ICPhone,String ICaddress, String ICServices,
			String ICPersonName,String ICPersonemail,String ICPersonPhone,String ICPersonAvailabilityFrom,String ICPersonAvailabilityTo) throws Exception {
		
		zmtUserPage.InsuranceCompanyProfile_Details(ICFirstName, ICLastName, ICPhone, ICaddress, ICServices, ICPersonName, ICPersonemail, ICPersonPhone, ICPersonAvailabilityFrom, ICPersonAvailabilityTo);
		Browser.clickOnTheElementByID(Elements_ZMTusers.profile_myAccountSave);
		Browser.zmt_notification("User profile saved successfully");
		Browser.mongoDB_Remove("52.66.101.182", 27219, "zoynpap", "zoylo_zqa", "apz0yl0_321", "zmtusers", "email", emailID);
	}
	
	@AfterClass
	public void CloseBrowser() {
		driver.quit();
	}

}
