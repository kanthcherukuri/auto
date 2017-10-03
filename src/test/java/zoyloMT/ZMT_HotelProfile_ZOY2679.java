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

public class ZMT_HotelProfile_ZOY2679  extends LoadPropMac {
	
	public TestUtils Browser;
	public ZMTPage zmtUserPage;
	public String emailID="hotelthree@gmail.com";
	
	@BeforeClass
	public void Browser() throws Exception {	
	LoadBrowserProperties();
	Browser= new TestUtils(driver);
	zmtUserPage= new ZMTPage(driver);
	Browser.openUrl("https://"+Zmt_environmentname+".com");
	}
	
	
	@Test(priority=1)
	public void CheckHotelProfile() throws Exception {
		Browser.clickOnTheElementByID(Elements_ZMTusers.zmt_login);
		Browser.clickOnTheElementByXpath(Elements_ZMTusers.zmt_SignUp_Button);
		Thread.sleep(1000);
		zmtUserPage.SignUpForm_Details("kakatiya", "itc", emailID, "India", "Hyderabad", "kanth@666", "kanth@666", "9966002222", "Hotel","Mumbai");
		Browser.clickOnTheElementByID(Elements_ZMTusers.signUp_submit);
		Browser.zmt_notification("user created successfully");
		String checkfname=Browser.getTextBoxValueByID(Elements_ZMTusers.profile_firstName);
		Assert.assertEquals(checkfname, "kakatiya");
		String checklastname=Browser.getTextBoxValueByID(Elements_ZMTusers.profile_lastName);
		Assert.assertEquals(checklastname, "itc");
		String checkphone=Browser.getTextBoxValueByID(Elements_ZMTusers.profile_phNum);
		Assert.assertEquals(checkphone, "9966002222");
		String checkaddress=Browser.getTextBoxValueByID(Elements_ZMTusers.profile_homeAddress);
		Assert.assertEquals(checkaddress, "Mumbai");
	}
	
	@DataProvider(name="HotelProfileValidation")
	public Object[][] insurance() throws Exception
	{
		Object[][] HotelInformation=TestUtils.getTableArray("TestData/zmt.xls", "OtherProfile", "ZMT2679");
		return(HotelInformation);
	}
	
	
	
	@Test(dataProvider="HotelProfileValidation",priority=2)
	public void CheckHotelProfileValidation(String TFirstName, String TLastName, String TPhone, String Taddress, String TRooms, String TFacilities,
		String TPersonName,String TPersonemail,String TPersonPhone,String TPersonAvailabilityFrom,String TPersonAvailabilityTo,String Afname,
		String Alname,String Aphnum,String Acontactname,String Acontactemail,String Acontactphone,String AavailabilityFrom,String AavailabilityTo) throws Exception {
		
		zmtUserPage.HotelProfile_Details(TFirstName, TLastName, TPhone, Taddress, TRooms, TFacilities, TPersonName, TPersonemail, TPersonPhone, TPersonAvailabilityFrom, TPersonAvailabilityTo);
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
	
	@DataProvider(name="HotelProfileSave")
	public Object[][] HotelProfile() throws Exception
	{
		Object[][] Hotelsave=TestUtils.getTableArray("TestData/zmt.xls", "OtherProfile", "ZMT2679S");
		return(Hotelsave);
	}
	
	
	
	@Test(dataProvider="HotelProfileSave",priority=3)
	public void CheckHotelProfileSave(String TFirstName, String TLastName, String TPhone, String Taddress, String TRooms, String TFacilities,
			String TPersonName,String TPersonemail,String TPersonPhone,String TPersonAvailabilityFrom,String TPersonAvailabilityTo) throws Exception {
		
		zmtUserPage.HotelProfile_Details(TFirstName, TLastName, TPhone, Taddress, TRooms, TFacilities, TPersonName, TPersonemail, TPersonPhone, TPersonAvailabilityFrom, TPersonAvailabilityTo);
		Browser.clickOnTheElementByID(Elements_ZMTusers.profile_myAccountSave);
		Browser.zmt_notification("User profile saved successfully");
		Browser.mongoDB_Remove("52.66.101.182", 27219, "zoynpap", "zoylo_zqa", "apz0yl0_321", "zmtusers", "email", emailID);
	}
	
	@AfterClass
	public void CloseBrowser() {
		driver.quit();
	}

}
