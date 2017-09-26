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

//@Author: Sagar Sen

public class ZMT_HospitalProfile_ZOY2673 extends LoadPropMac
{
	public TestUtils Browser;
	public ZMTPage zmtUserPage;
	public String password="Zmt@123";
	public String confirmPassword="Zmt@123";
	public Boolean removeFromDB=true;
	public String fname="Hospital";
	public String lname="Profile";
	public String emailID="hospitalprofile@zmt.com";
	public String Country="India";
	public String State="Hyderabad";
	public String address="Hospital address at Hyderabad";
	
	@Test(priority=1)
	public void surgeonSignUp() throws Exception
	{
		String phnum="9"+Browser.generateRandomNumber(9);
		Browser.clickOnTheElementByID(Elements_ZMTusers.zmt_login);
		Browser.clickOnTheElementByXpath(Elements_ZMTusers.zmt_SignUp_Button);
		zmtUserPage.SignUpForm_Details(fname, lname, emailID, Country, State, password, confirmPassword, phnum, "Hospital", address);
		Browser.clickOnTheElementByID(Elements_ZMTusers.signUp_submit);
		Browser.zmt_notification("user created successfully");
	}
	
	@DataProvider(name="zmtValidation")
	public Object[][] hospitalprofile() throws Exception
	{
		Object[][] hospitalProfileDetails=TestUtils.getTableArray("TestData/zmt.xls", "users", "ZMT2673");
		return(hospitalProfileDetails);
	}
	
	@Test(dataProvider="zmtValidation", priority=2)
	public void hospitalDetails_Validation(String Pfname, String Plname, String Pphnum, String Ppicupload, String Paddress, String paccredValue, String phospSpec, String pestYear, String pnumOfBeds, String pICUbeds, String psurgeonTeams, String pfacilities, String pservices, String pabout, String pPName, String pPemail, String pPPhone, String pPAvailabilityFrom, String pPAvailabilityTo, String Pcertificates, String isTopSurgeonTrue, String ptopSurgeonName, String ptopSurgeonExp, String Nfname, String Nlname, String Nphnum, String	Naddress, String NestYear, String NICUbeds, String NsurgeonTeams, String NPName, String	NPemail, String	NPPhone, String	NPAvailabilityFrom, String NPAvailabilityTo, String	NtopSurgeonName, String	NtopSurgeonExp) throws Exception
	{
		zmtUserPage.hospitalProfile_details(Pfname, Plname, Pphnum, Ppicupload, Paddress, paccredValue, phospSpec, pestYear, pnumOfBeds, pICUbeds, psurgeonTeams, pfacilities, pservices, pabout, pPName, pPemail, pPPhone, pPAvailabilityFrom, pPAvailabilityTo, Pcertificates, isTopSurgeonTrue, ptopSurgeonName, ptopSurgeonExp);
		Browser.ScrollDown();
		Browser.clickOnTheElementByID(Elements_ZMTusers.profile_myAccountSave);
		Thread.sleep(500);
		String vfname=driver.findElement(By.xpath(Elements_ZMTusers.profile_firstName_Validation)).getText();
		String vlname=driver.findElement(By.xpath(Elements_ZMTusers.profile_lastName_Validation)).getText();
		String vphNum=driver.findElement(By.xpath(Elements_ZMTusers.profile_phNum_Validation)).getText();
		String vAddress=driver.findElement(By.xpath(Elements_ZMTusers.profile_homeAddress_Validation)).getText();
		String vYearsOfest=driver.findElement(By.xpath(Elements_ZMTusers.profile_yearofest_validation)).getText();
		String vICUbeds=driver.findElement(By.xpath(Elements_ZMTusers.profile_ICUB_validation)).getText();
		String vSurgeonTeam=driver.findElement(By.xpath(Elements_ZMTusers.profile_Surgeons_validation)).getText();
		String vpname=driver.findElement(By.xpath(Elements_ZMTusers.profile_contactperson_name_validation)).getText();
		String vpemail=driver.findElement(By.xpath(Elements_ZMTusers.profile_contactperson_email_validation)).getText();
		String vpnum=driver.findElement(By.xpath(Elements_ZMTusers.profile_contactperson_phone_validation)).getText();
		String vpStart=driver.findElement(By.xpath(Elements_ZMTusers.profile_contactperson_availabityfrom_validation)).getText();
		String vpEnd=driver.findElement(By.xpath(Elements_ZMTusers.profile_contactperson_availabityTo_validation)).getText();
		Assert.assertEquals(Nfname, vfname);
		Assert.assertEquals(Nlname, vlname);
		Assert.assertEquals(Nphnum, vphNum);
		Assert.assertEquals(Naddress, vAddress);
		Assert.assertEquals(NestYear, vYearsOfest);
		Assert.assertEquals(NICUbeds, vICUbeds);
		Assert.assertEquals(NsurgeonTeams, vSurgeonTeam);
		Assert.assertEquals(NPName, vpname);
		Assert.assertEquals(NPemail, vpemail);
		Assert.assertEquals(NPPhone, vpnum);
		Assert.assertEquals(NPAvailabilityFrom, vpStart);
		Assert.assertEquals(NPAvailabilityTo, vpEnd);
		driver.navigate().refresh();
		Thread.sleep(1000);
		Browser.ScrollUp();
		Thread.sleep(500);
	}
	
	@DataProvider(name="zmtSurgeonValidation")
	public Object[][] hospitalSurgeonprofile() throws Exception
	{
		Object[][] hospitalSurgeonProfileDetails=TestUtils.getTableArray("TestData/zmt.xls", "users", "ZMT2673SRG");
		return(hospitalSurgeonProfileDetails);
	}
	
	@Test(dataProvider="zmtSurgeonValidation", priority=3)
	public void hospitalSurgeonDetails_Validation(String ptopSurgeonName, String ptopSurgeonExp, String NtopSurgeonName, String NtopSurgeonExp) throws Exception
	{
		Browser.scrollbyID(Elements_ZMTusers.profile_Surgeons);
		Browser.clickOnTheElementByID(Elements_ZMTusers.profile_addTopSurgeon);
		Browser.enterTextByID(Elements_ZMTusers.profile_addNewSurgeon_Name, ptopSurgeonName);
		Browser.enterTextByID(Elements_ZMTusers.profile_addNewSurgeon_Exp, ptopSurgeonExp);
		Browser.clickOnTheElementByID(Elements_ZMTusers.profile_addNewSurgeon_Submit);
		Thread.sleep(800);
		driver.navigate().refresh();
		Thread.sleep(1000);
	}
	
	@DataProvider(name="zmtSave")
	public Object[][] hospitalprofileSave() throws Exception
	{
		Object[][] hospitalprofileSave=TestUtils.getTableArray("TestData/zmt.xls", "users", "ZMT2673S");
		return(hospitalprofileSave);
	}
	
	@Test(dataProvider="zmtSave", priority=4)
	public void hospitalDetails_Save(String Pfname, String Plname, String Pphnum, String Ppicupload, String Paddress, String paccredValue, String phospSpec, String pestYear, String pnumOfBeds, String pICUbeds, String psurgeonTeams, String pfacilities, String pservices, String pabout, String pPName, String pPemail, String pPPhone, String pPAvailabilityFrom, String pPAvailabilityTo, String Pcertificates, String isTopSurgeonTrue, String ptopSurgeonName, String ptopSurgeonExp) throws Exception
	{
		driver.navigate().refresh();
		zmtUserPage.hospitalProfile_details(Pfname, Plname, Pphnum, Ppicupload, Paddress, paccredValue, phospSpec, pestYear, pnumOfBeds, pICUbeds, psurgeonTeams, pfacilities, pservices, pabout, pPName, pPemail, pPPhone, pPAvailabilityFrom, pPAvailabilityTo, Pcertificates, isTopSurgeonTrue, ptopSurgeonName, ptopSurgeonExp);
		Browser.ScrollDown();
		Browser.clickOnTheElementByID(Elements_ZMTusers.profile_myAccountSave);
		Thread.sleep(500);
		Browser.zmt_notification("User profile saved successfully");
		Browser.mongoDB_Remove("52.66.101.182", 27219, "zoynpap", "zoylo_zqa", "apz0yl0_321", "zmtusers", "email", emailID);
	}
	
	@BeforeClass
	public void launchapp() throws Exception
	{
		LoadBrowserProperties();
		Browser= new TestUtils(driver);
		zmtUserPage= new ZMTPage(driver);
		Browser.openUrl("https://"+Zmt_environmentname+".com");
	}
	
	@AfterClass
	public void closeapp()
	{
		driver.quit();
	}
}