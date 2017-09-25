

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

public class ZMT_OtherProfile_ZOY2669 extends LoadPropMac {
	
	public TestUtils Browser;
	public ZMTPage zmtUserPage;
	public String emailID="divyasaitwentythiree@gmail.com";
	
	
	@BeforeClass
	public void Browser() throws Exception {	
	LoadBrowserProperties();
	Browser= new TestUtils(driver);
	zmtUserPage= new ZMTPage(driver);
	Browser.openUrl("https://"+Zmt_environmentname+".com");
	}

	@Test(priority=1)
	public void CheckOtherProfile() throws Exception {
		Browser.clickOnTheElementByID(Elements_ZMTusers.zmt_login);
		Browser.clickOnTheElementByXpath(Elements_ZMTusers.zmt_SignUp_Button);
		Thread.sleep(1000);
		zmtUserPage.SignUpForm_Details("DivyaSainineteen", "yarla", emailID,"India", "Hyderabad", "kanth@666", "kanth@666", "9900660008", "Other", "Hi Divya hello");
		Browser.clickOnTheElementByID(Elements_ZMTusers.signUp_submit);
		Browser.zmt_notification("user created successfully");
		String checkfname=Browser.getTextBoxValueByID(Elements_ZMTusers.profile_firstName);
		Assert.assertEquals(checkfname, "DivyaSainineteen");
		String checklastname=Browser.getTextBoxValueByID(Elements_ZMTusers.profile_lastName);
		Assert.assertEquals(checklastname, "yarla");
		String checkphone=Browser.getTextBoxValueByID(Elements_ZMTusers.profile_phNum);
		Assert.assertEquals(checkphone, "9900660008");
		
		
	}
	

	@DataProvider(name="OtherProfileValidation")
	public Object[][] clinicDocInfo() throws Exception
	{
		Object[][] clinicDocInformation=TestUtils.getTableArray("TestData/zmt.xls", "OtherProfile", "ZMT2669");
		return(clinicDocInformation);
	}
	
	
	
	@Test(dataProvider="OtherProfileValidation",priority=2)
	public void CheckOtherProfileValidations(String firstname,String lastname,String phone,String specialities,String yearofest,String ICUB,String Surgeons,
	String designation,String specialization,String listoftreatments,String aboutyourself ,String message,String Afname,String Alname,String Aphnum,
	String Ayearofest,String AICUB,String ASurgeons,String Aaboutyourself,String Amessage) {
		
		driver.findElement(By.id("firstName")).clear();
		driver.findElement(By.id("lastName")).clear();
		driver.findElement(By.id("phone")).clear();
		zmtUserPage.OtherProfile_Details(firstname, lastname, phone, specialities, yearofest, ICUB, Surgeons, designation, specialization, listoftreatments, aboutyourself, message);
		String fname=driver.findElement(By.xpath(Elements_ZMTusers.profile_firstName_Validation)).getText();
		Assert.assertEquals(fname, Afname);
		String lname=driver.findElement(By.xpath(Elements_ZMTusers.profile_lastName_Validation)).getText();
		Assert.assertEquals(lname, Alname);
		String phnum=driver.findElement(By.xpath(Elements_ZMTusers.profile_phNum_Validation)).getText();
		Assert.assertEquals(phnum, Aphnum);
		String establishyear=driver.findElement(By.xpath(Elements_ZMTusers.profile_yearofest_validation)).getText();
		Assert.assertEquals(establishyear, Ayearofest);
		String numICUB=driver.findElement(By.xpath(Elements_ZMTusers.profile_ICUB_validation)).getText();
		Assert.assertEquals(numICUB, AICUB);
		String noofsurgeons=driver.findElement(By.xpath(Elements_ZMTusers.profile_Surgeons_validation)).getText();
		Assert.assertEquals(noofsurgeons, ASurgeons);
		String yourself=driver.findElement(By.xpath(Elements_ZMTusers.profile_aboutYourSelf_validation)).getText();
		Assert.assertEquals(yourself, Aaboutyourself);
		String msg=driver.findElement(By.xpath(Elements_ZMTusers.profile_message_validation)).getText();
		Assert.assertEquals(msg, Amessage);
	}
	
	@DataProvider(name="OtherProfileSave")
	public Object[][] OtherProfile() throws Exception
	{
		Object[][] OtherProfile=TestUtils.getTableArray("TestData/zmt.xls", "OtherProfile", "ZMT2669S");
		return(OtherProfile);
	}
	
	
	@Test(dataProvider="OtherProfileSave",priority=3)
	public void CheckOtherProfileSave(String firstname,String lastname,String phone,String specialities,String yearofest,String ICUB,String Surgeons,
			String designation,String specialization,String listoftreatments,String aboutyourself ,String message) throws Exception {
	zmtUserPage.OtherProfile_Details(firstname, lastname, phone, specialities, yearofest, ICUB, Surgeons, designation, specialization, listoftreatments, aboutyourself, message);
	Browser.zmt_notification("User profile saved successfully");
	Browser.mongoDB_Remove("52.66.101.182", 27219, "zoynpap", "zoylo_zqa", "apz0yl0_321", "zmtusers", "email", emailID);
	}
	
	
}
