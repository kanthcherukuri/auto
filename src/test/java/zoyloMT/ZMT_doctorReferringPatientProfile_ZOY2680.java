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

public class ZMT_doctorReferringPatientProfile_ZOY2680 extends LoadPropMac
{
	public TestUtils Browser;
	public ZMTPage zmtUserPage;
	public String password="Zmt@123";
	public String confirmPassword="Zmt@123";
	public Boolean removeFromDB=true;
	public String fname="Docrefpatient";
	public String lname="Profile";
	public String emailID="docrefpatprofile@zmt.com";
	public String Country="India";
	public String State="Hyderabad";
	public String address="Doc patient address at Hyderabad";
	
	@Test(priority=1)
	public void surgeonSignUp() throws Exception
	{
		String phnum="9"+Browser.generateRandomNumber(9);
		Browser.clickOnTheElementByID(Elements_ZMTusers.zmt_login);
		Browser.clickOnTheElementByXpath(Elements_ZMTusers.zmt_SignUp_Button);
		zmtUserPage.SignUpForm_Details(fname, lname, emailID, Country, State, password, confirmPassword, phnum, "Doctor Referring a Patient", address);
		Browser.clickOnTheElementByID(Elements_ZMTusers.signUp_submit);
		Browser.zmt_notification("user created successfully");
	}
	
	@DataProvider(name="zmtDRPValidation")
	public Object[][] drpvalidation() throws Exception
	{
		Object[][] drpProfilePage=TestUtils.getTableArray("TestData/zmt.xls", "users", "ZMT2680");
		return(drpProfilePage);
	}
	
	@Test(dataProvider="zmtDRPValidation", priority=2)
	public void drpProfileValidation(String Pfname, String Plname, String Pphnum, String Ppicupload, String ismoreAddressTrue, String pmoreAddress, String phospSpec, String pestYear, String pICUbeds, String psurgeonTeams, String isTopSurgeonTrue, String ptopSurgeonName, String ptopSurgeonExp, String pdesignation, String pspecialization, String plistoftreatments, String pabout, String Pcertificates, String nfname, String nlname, String nphNum, String nYearsOfest, String nICUbeds, String nSurgeonTeam, String nabout) throws Exception
	{
		zmtUserPage.docRefPatProfile_details(Pfname, Plname, Pphnum, Ppicupload, ismoreAddressTrue, pmoreAddress, phospSpec, pestYear, pICUbeds, psurgeonTeams, isTopSurgeonTrue, ptopSurgeonName, ptopSurgeonExp, pdesignation, pspecialization, plistoftreatments, pabout, Pcertificates);
		Browser.ScrollDown();
		Browser.clickOnTheElementByID(Elements_ZMTusers.profile_myAccountSave);
		Thread.sleep(500);
		String vfname=driver.findElement(By.xpath(Elements_ZMTusers.profile_firstName_Validation)).getText();
		String vlname=driver.findElement(By.xpath(Elements_ZMTusers.profile_lastName_Validation)).getText();
		String vphNum=driver.findElement(By.xpath(Elements_ZMTusers.profile_phNum_Validation)).getText();
		String vYearsOfest=driver.findElement(By.xpath(Elements_ZMTusers.profile_yearofest_validation)).getText();
		String vICUbeds=driver.findElement(By.xpath(Elements_ZMTusers.profile_ICUB_validation)).getText();
		String vSurgeonTeam=driver.findElement(By.xpath(Elements_ZMTusers.profile_Surgeons_validation)).getText();
		String vabout=driver.findElement(By.xpath(Elements_ZMTusers.profile_aboutYourSelf_validation)).getText();
		Assert.assertEquals(nfname, vfname);
		Assert.assertEquals(nlname, vlname);
		Assert.assertEquals(nphNum, vphNum);
		Assert.assertEquals(nYearsOfest, vYearsOfest);
		Assert.assertEquals(nICUbeds, vICUbeds);
		Assert.assertEquals(nSurgeonTeam, vSurgeonTeam);
		Assert.assertEquals(nabout, vabout);
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
	public Object[][] surgeonprofileSave() throws Exception
	{
		Object[][] surgeonProfileDetailsSave=TestUtils.getTableArray("TestData/zmt.xls", "users", "ZMT2680S");
		return(surgeonProfileDetailsSave);
	}
	
	@Test(dataProvider="zmtSave", priority=4)
	public void surgeonProfile_Save(String Pfname, String Plname, String Pphnum, String Ppicupload, String ismoreAddressTrue, String pmoreAddress, String phospSpec, String pestYear, String pICUbeds, String psurgeonTeams, String isTopSurgeonTrue, String ptopSurgeonName, String ptopSurgeonExp, String pdesignation, String pspecialization, String plistoftreatments, String pabout, String Pcertificates) throws Exception
	{
		Thread.sleep(800);
		driver.navigate().refresh();
		zmtUserPage.docRefPatProfile_details(Pfname, Plname, Pphnum, Ppicupload, ismoreAddressTrue, pmoreAddress, phospSpec, pestYear, pICUbeds, psurgeonTeams, isTopSurgeonTrue, ptopSurgeonName, ptopSurgeonExp, pdesignation, pspecialization, plistoftreatments, pabout, Pcertificates);
		Browser.clickOnTheElementByID(Elements_ZMTusers.profile_myAccountSave);
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