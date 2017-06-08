package doctorsTestScripts;

import org.testng.annotations.AfterClass;
import org.testng.annotations.Test;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.DataProvider;

import testBase.AdminPage;
import testBase.DoctorsPage;
import testBase.LoadPropMac;
import testBase.TestUtils;

public class Schedule_ZOY2100_AddClinic extends LoadPropMac
{
	public TestUtils Browser;
	public DoctorsPage doctorsPage;
	public AdminPage admin;
	
	@DataProvider(name="clinicdata")
	public Object[][] clinicdetails() throws Exception
	{
		Object[][] clinicinfo=TestUtils.getTableArray("TestData/Doctors_TestData.xls", "Schedule", "ZOY2100");
		return(clinicinfo);
	}
	
	@Test(dataProvider="clinicdata")
	public void addClinic(String ohrName, String otrClincFee, String othrCliNum, String linone, String otrPin, String lon, String lat) throws Exception
	{
		doctorsPage.SignIn(DoctorsLogin_username, DoctorsLogin_password);
		Thread.sleep(2000);
		doctorsPage.addclinicSchedule(ohrName, otrClincFee, othrCliNum, linone, otrPin, lon, lat);
		closeapp();
		launchapp();
		admin.adminSignIn(admin_user, admin_password);
		doctorsPage.deleteOtherClinicFromAdmin(DoctorsLogin_username);
	}
	
	@BeforeClass
	public void launchapp() throws Exception
	{
		LoadBrowserProperties();
		Browser= new TestUtils(driver);
		doctorsPage=new DoctorsPage(driver);
		admin=new AdminPage(driver);
		driver.get(loginPage_Url);
	}
	
	@AfterClass
	public void closeapp() throws Exception
	{
		driver.close();
	}
}
