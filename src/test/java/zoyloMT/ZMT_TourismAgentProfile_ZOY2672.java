

//@Author:Ch.LakshmiKanth
package zoyloMT;

import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import objectRepository.Elements_ZMTusers;
import testBase.LoadPropMac;
import testBase.TestUtils;
import testBase.ZMTPage;

public class ZMT_TourismAgentProfile_ZOY2672 extends LoadPropMac{
	
	public TestUtils Browser;
	public ZMTPage zmtUserPage;
	public String emailID="rollsroyceninethree@gmail.com";
	
	
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
		zmtUserPage.SignUpForm_Details("Rollsroyce", "RR", emailID, "India", "Hyderabad", "kanth@666", "kanth@666", "9966002200", "Tourism Agent", "North Bethesda");
		Browser.clickOnTheElementByID(Elements_ZMTusers.signUp_submit);
		Browser.zmt_notification("user created successfully");
		String checkfname=Browser.getTextBoxValueByID(Elements_ZMTusers.profile_firstName);
		Assert.assertEquals(checkfname, "Rollsroyce");
		String checklastname=Browser.getTextBoxValueByID(Elements_ZMTusers.profile_lastName);
		Assert.assertEquals(checklastname, "RR");
		String checkphone=Browser.getTextBoxValueByID(Elements_ZMTusers.profile_phNum);
		Assert.assertEquals(checkphone, "9966002200");
		String checkaddress=Browser.getTextBoxValueByID(Elements_ZMTusers.profile_homeAddress);
		Assert.assertEquals(checkaddress, "North Bethesda");
	}
	
	@DataProvider(name="TourismAgentProfileValidation")
	public Object[][] TourismAgent() throws Exception
	{
		Object[][] TourismAgentInformation=TestUtils.getTableArray("TestData/zmt.xls", "OtherProfile", "ZMT2672");
		return(TourismAgentInformation);
	}
	
	
	
	@Test(dataProvider="TourismAgentProfileValidation",priority=2)
	public void CheckTourismAgentValidation(String TAFirstName,String TALastName,String TAPhone,String TAaddress ,String TAaccreditation,
		String TAServices,String TAPersonName,String TAPersonPhone,String TAPersonAvailabilityFrom,String TAPersonAvailabilityTo,String Afname,
		String Alname,String Aphnum,String Aaddress,String Acontactname,String Acontactphone,String AavailabilityFrom,String AavailabilityTo) throws Exception {
		
		driver.findElement(By.id(Elements_ZMTusers.profile_firstName)).clear();
		driver.findElement(By.id(Elements_ZMTusers.profile_lastName)).clear();
		driver.findElement(By.id(Elements_ZMTusers.profile_phNum)).clear();
		driver.findElement(By.id(Elements_ZMTusers.profile_homeAddress)).clear();
		zmtUserPage.TourismAgentProfile_Details(TAFirstName, TALastName, TAPhone, TAaddress, TAaccreditation, TAServices, TAPersonName, TAPersonPhone, TAPersonAvailabilityFrom, TAPersonAvailabilityTo);
		String fname=driver.findElement(By.xpath(Elements_ZMTusers.profile_firstName_Validation)).getText();
		Assert.assertEquals(fname, Afname);
		String lname=driver.findElement(By.xpath(Elements_ZMTusers.profile_lastName_Validation)).getText();
		Assert.assertEquals(lname, Alname);
		String phnum=driver.findElement(By.xpath(Elements_ZMTusers.profile_phNum_Validation)).getText();
		Assert.assertEquals(phnum, Aphnum);
		String contactname=driver.findElement(By.xpath(Elements_ZMTusers.profile_contactperson_name_validation)).getText();
		Assert.assertEquals(contactname, Acontactname);
		String contactphone=driver.findElement(By.xpath(Elements_ZMTusers.profile_contactperson_phone_validation)).getText();
		Assert.assertEquals(contactphone, Acontactphone);
		String availabilityFrom=driver.findElement(By.xpath(Elements_ZMTusers.profile_contactperson_availabityfrom_validation)).getText();
		Assert.assertEquals(availabilityFrom, AavailabilityFrom);
		String availabilityTo=driver.findElement(By.xpath(Elements_ZMTusers.profile_contactperson_availabityTo_validation)).getText();
		Assert.assertEquals(availabilityTo, AavailabilityTo);
		
	}
	
	
	@DataProvider(name="TourismAgentProfileSave")
	public Object[][] OtherProfile() throws Exception
	{
		Object[][] TourismProfile=TestUtils.getTableArray("TestData/zmt.xls", "OtherProfile", "ZMT2672S");
		return(TourismProfile);
	}
	
	
	@Test(dataProvider="TourismAgentProfileSave",priority=3)
	public void CheckTourismAgentProfileSaving(String TAFirstName,String TALastName,String TAPhone,String TAaddress ,String TAaccreditation,
			String TAServices,String TAPersonName,String TAPersonPhone,String TAPersonAvailabilityFrom,String TAPersonAvailabilityTo) throws Exception {
		
		zmtUserPage.TourismAgentProfile_Details(TAFirstName, TALastName, TAPhone, TAaddress, TAaccreditation, TAServices, TAPersonName, TAPersonPhone, TAPersonAvailabilityFrom, 
				TAPersonAvailabilityTo);
		Browser.zmt_notification("User profile saved successfully");
		Browser.mongoDB_Remove("52.66.101.182", 27219, "zoynpap", "zoylo_zqa", "apz0yl0_321", "zmtusers", "email", emailID);
	}
	

}
