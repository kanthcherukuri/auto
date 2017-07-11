package NewAdminScripts;

import org.testng.annotations.AfterClass;
import org.testng.annotations.Test;
import org.testng.annotations.BeforeClass;
import java.util.concurrent.TimeUnit;
import org.testng.annotations.DataProvider;
import objectRepository.Elements_NewAdminDoctors;
import testBase.LoadPropMac;
import testBase.NewAdminDoctorsPage;
import testBase.TestUtils;

//@Authour: Sagar Sen

public class Admin_ZOY2238_editHospitalDoctor extends LoadPropMac
{
	public TestUtils Browser;
	public NewAdminDoctorsPage admin;
	
	@DataProvider(name="clinicDoctorDetails")
	public Object[][] clinicDocInfo() throws Exception
	{
		Object[][] clinicDocInformation=TestUtils.getTableArray("TestData/rvmpAdmin_addDoctor.xls", "hospitalDoctor", "ZOY2238");
		return(clinicDocInformation);
	}
	
	@Test(dataProvider="clinicDoctorDetails")
	public void editHospitalDoctor(String emailID, String isSEOInfoTrue, String metaTitle) throws Exception
	{
		admin.click_doctorsTab();
		admin.searchDoctorbyEmailID(emailID);
		admin.clickEditbutton();
		admin.seoInfoEdit(isSEOInfoTrue, metaTitle);
		admin.clickSubmitDoctor();
		Browser.CheckNotificationMessage("Doctor Updated Successfully");
	}
	
	@BeforeClass
	public void launchapp() throws Exception
	{
		LoadBrowserProperties();
		driver.get(loginPage_Url);
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		Elements_NewAdminDoctors.newAdmin_DoctorPageProperties(); // loading the Elements
		Browser= new TestUtils(driver);
		admin=new NewAdminDoctorsPage(driver);
		admin.adminSignIn(admin_user, admin_password);
	}
	
	@AfterClass
	public void closeapp()
	{
		driver.quit();
	}
}
