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

public class ZMT_patientProfile_ZOY2668 extends LoadPropMac
{
	public TestUtils Browser;
	public ZMTPage zmtUserPage;
	public String password="Zmt@123";
	public String confirmPassword="Zmt@123";
	public Boolean removeFromDB=true;
	public String fname="Patient";
	public String lname="Profile";
	public String emailID="patientprofile@zmt.com";
	public String Country="India";
	public String State="Hyderabad";
	public String address="Patient address at Hyderabad";
	
	@Test(priority=1)
	public void patientSignUp() throws Exception
	{
		String phnum="9"+Browser.generateRandomNumber(9);
		Browser.clickOnTheElementByID(Elements_ZMTusers.zmt_login);
		Browser.clickOnTheElementByXpath(Elements_ZMTusers.zmt_SignUp_Button);
		zmtUserPage.SignUpForm_Details(fname, lname, emailID, Country, State, password, confirmPassword, phnum, "Patient", address);
		Browser.clickOnTheElementByID(Elements_ZMTusers.signUp_submit);
		Browser.zmt_notification("user created successfully");
	}
	
	@DataProvider(name="zmt")
	public Object[][] patientprofile() throws Exception
	{
		Object[][] patientProfileDetails=TestUtils.getTableArray("TestData/zmt.xls", "users", "ZMT2668");
		return(patientProfileDetails);
	}
	
	@Test(dataProvider="zmt", priority=2)
	public void patientProfile_Validation(String Pfname, String	Plname, String Pgender, String Page, String	Pphnum, String Ppicupload, String Paddress, String Pmedcondition, String Prefdoc, String Pcertificates, String Vfname, String Vlname, String Vage, String Vphnum, String Vaddress, String Vmedcondition, String	Vrefdoc) throws Exception
	{
		zmtUserPage.patientProfile_details(Pfname, Plname, Pgender, Page, Pphnum, Ppicupload, Paddress, Pmedcondition, Prefdoc, Pcertificates, Vfname, Vlname, Vage, Vphnum, Vaddress, Vmedcondition, Vrefdoc);
		Thread.sleep(500);
		String nfname=driver.findElement(By.xpath(Elements_ZMTusers.profile_firstName_Validation)).getText();
		String nlname=driver.findElement(By.xpath(Elements_ZMTusers.profile_lastName_Validation)).getText();
		String nage=driver.findElement(By.xpath(Elements_ZMTusers.profile_age_Validation)).getText();
		String nphNum=driver.findElement(By.xpath(Elements_ZMTusers.profile_phNum_Validation)).getText();
		String nAddress=driver.findElement(By.xpath(Elements_ZMTusers.profile_homeAddress_Validation)).getText();
		String nmedcondition=driver.findElement(By.xpath(Elements_ZMTusers.profile_medicalCondition_Validation)).getText();
		String nrefdoc=driver.findElement(By.xpath(Elements_ZMTusers.profile_referalPhysician_Validation)).getText();
		Assert.assertEquals(Vfname, nfname);
		Assert.assertEquals(Vlname, nlname);
		Assert.assertEquals(Vage, nage);
		Assert.assertEquals(Vphnum, nphNum);
		Assert.assertEquals(Vaddress, nAddress);
		Assert.assertEquals(Vmedcondition, nmedcondition);
		Assert.assertEquals(Vrefdoc, nrefdoc);
		driver.navigate().refresh();
		Thread.sleep(1000);
	}
	
	@Test(priority=3)
	public void clearData() throws Exception
	{
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