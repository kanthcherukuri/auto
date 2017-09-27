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

//@ Author: Sagar Sen

public class ZMT_surgeonProfile_ZOY2671 extends LoadPropMac
{
	public TestUtils Browser;
	public ZMTPage zmtUserPage;
	public String password="Zmt@123";
	public String confirmPassword="Zmt@123";
	public Boolean removeFromDB=true;
	public String fname="Surgeon";
	public String lname="Profile";
	public String emailID="surgeonprofile@zmt.com";
	public String Country="India";
	public String State="Hyderabad";
	public String address="Surgeon address at Hyderabad";
	
	@Test(priority=1)
	public void surgeonSignUp() throws Exception
	{
		String phnum="9"+Browser.generateRandomNumber(9);
		Browser.clickOnTheElementByID(Elements_ZMTusers.zmt_login);
		Browser.clickOnTheElementByXpath(Elements_ZMTusers.zmt_SignUp_Button);
		zmtUserPage.SignUpForm_Details(fname, lname, emailID, Country, State, password, confirmPassword, phnum, "Surgeon", address);
		Browser.clickOnTheElementByID(Elements_ZMTusers.signUp_submit);
		Browser.zmt_notification("user created successfully");
	}
	
	@DataProvider(name="zmt")
	public Object[][] surgeonprofile() throws Exception
	{
		Object[][] surgeonProfileDetails=TestUtils.getTableArray("TestData/zmt.xls", "users", "ZMT2671");
		return(surgeonProfileDetails);
	}
	
	@Test(dataProvider="zmt", priority=2)
	public void surgeonProfile_Validation(String Pfname, String	Plname, String Pgender, String	Pphnum, String Ppicupload, String Paddress, String psurgeonSpec, String surgeonDesignation, String surgeonQualification, String pfexp, String isHospitalTrue, String psurgeonHospitalName, String psurgeonHospitalAddress, String potherSpecialization, String plistTreatments, String pabout, String pcertificates, String Nfname, String Nlname, String Nphnum, String Naddress, String NurgeonQualification, String Nfexp, String NsurgeonHospitalName, String	NsurgeonHospitalAddress, String	Nabout) throws Exception
	{
		zmtUserPage.surgeonProfile_details(Pfname, Plname, Pgender, Pphnum, Ppicupload, Paddress, psurgeonSpec, surgeonDesignation, surgeonQualification, pfexp, isHospitalTrue, psurgeonHospitalName, psurgeonHospitalAddress, potherSpecialization, plistTreatments, pabout, pcertificates);
		Browser.clickOnTheElementByID(Elements_ZMTusers.profile_myAccountSave);
		Thread.sleep(500);
		String vfname=driver.findElement(By.xpath(Elements_ZMTusers.profile_firstName_Validation)).getText();
		String vlname=driver.findElement(By.xpath(Elements_ZMTusers.profile_lastName_Validation)).getText();
		String vphNum=driver.findElement(By.xpath(Elements_ZMTusers.profile_phNum_Validation)).getText();
		String vAddress=driver.findElement(By.xpath(Elements_ZMTusers.profile_homeAddress_Validation)).getText();
		String vQualification=driver.findElement(By.xpath(Elements_ZMTusers.profile_qualification_Validation)).getText();
		String vExp=driver.findElement(By.xpath(Elements_ZMTusers.profile_experience_validation)).getText();
		String vabout=driver.findElement(By.xpath(Elements_ZMTusers.profile_aboutYourSelf_validation)).getText();
		Assert.assertEquals(Nfname, vfname);
		Assert.assertEquals(Nlname, vlname);
		Assert.assertEquals(Nphnum, vphNum);
		Assert.assertEquals(Naddress, vAddress);
		Assert.assertEquals(NurgeonQualification, vQualification);
		Assert.assertEquals(Nfexp, vExp);
		Assert.assertEquals(Nabout, vabout);
		driver.navigate().refresh();
		Thread.sleep(1000);
		Browser.ScrollUp();
		Thread.sleep(500);
	}
	
	@Test(priority=3)
	public void surgeon_HospitalAssociated_Validation() throws Exception
	{
		String notify="This value is required.";
		Browser.clickOnTheElementByID(Elements_ZMTusers.profile_surgeonHospitalCheckBox);
		Browser.clickOnTheElementByID(Elements_ZMTusers.profile_surgeonHospitalAddLink);
		Browser.enterTextByID(Elements_ZMTusers.profile_surgeonHospitalName, "");
		Browser.enterTextByID(Elements_ZMTusers.profile_surgeonHospitalAddress, "");
		Browser.clickOnTheElementByID(Elements_ZMTusers.profile_surgeonHospitalAddSaveBtn);
		String vhname=driver.findElement(By.xpath(Elements_ZMTusers.profile_surgeonHospitalName_validation)).getText();
		String vhadd=driver.findElement(By.xpath(Elements_ZMTusers.profile_surgeonHospitalAddress_validation)).getText();
		Assert.assertEquals(vhname, notify);
		Assert.assertEquals(vhadd, notify);
		Browser.clickOnTheElementByXpath("//div[@id='addHospitalAssociatedWith']//button[@class='close']");
		driver.navigate().refresh();
	}
	
	@DataProvider(name="zmtSave")
	public Object[][] surgeonprofileSave() throws Exception
	{
		Object[][] surgeonProfileDetailsSave=TestUtils.getTableArray("TestData/zmt.xls", "users", "ZMT2671S");
		return(surgeonProfileDetailsSave);
	}
	
	@Test(dataProvider="zmtSave", priority=4)
	public void surgeonProfile_Save(String Pfname, String	Plname, String Pgender, String	Pphnum, String Ppicupload, String Paddress, String psurgeonSpec, String surgeonDesignation, String surgeonQualification, String pfexp, String isHospitalTrue, String psurgeonHospitalName, String psurgeonHospitalAddress, String potherSpecialization, String plistTreatments, String pabout, String pcertificates) throws Exception
	{
		Thread.sleep(800);
		zmtUserPage.surgeonProfile_details(Pfname, Plname, Pgender, Pphnum, Ppicupload, Paddress, psurgeonSpec, surgeonDesignation, surgeonQualification, pfexp, isHospitalTrue, psurgeonHospitalName, psurgeonHospitalAddress, potherSpecialization, plistTreatments, pabout, pcertificates);
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