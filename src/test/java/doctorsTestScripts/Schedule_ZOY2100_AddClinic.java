package doctorsTestScripts;

import org.testng.annotations.AfterClass;
import org.testng.annotations.Test;
import org.testng.annotations.BeforeClass;
import testBase.AdminPage;
import testBase.DoctorsPage;
import testBase.LoadPropMac;
import testBase.TestUtils;

public class Schedule_ZOY2100_AddClinic extends LoadPropMac
{
	public TestUtils Browser;
	public DoctorsPage doctorsPage;
	public AdminPage admin;
	public String ohrName="Oth Clinic Name";
	public String otrClincFee="20";
	public String othrCliNum="7890000001";
	public String linone="This is address";
	public String otrPin="502345";
	public String lon="70.123";
	public String lat="17.88";
	
	@Test()
	public void addClinic() throws Exception
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
