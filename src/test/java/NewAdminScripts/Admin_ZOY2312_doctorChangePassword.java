package NewAdminScripts;
import org.testng.annotations.AfterClass;
import org.testng.annotations.Test;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.DataProvider;
import objectRepository.Elements_NewAdminDoctors;
import testBase.DoctorsPage;
import testBase.LoadPropMac;
import testBase.NewAdminDoctorsPage;
import testBase.TestUtils;

//@Authour: Sagar Sen

public class Admin_ZOY2312_doctorChangePassword extends LoadPropMac
{
	public TestUtils Browser;
	public NewAdminDoctorsPage admin;
	public DoctorsPage doctorPage;
	public String changedPassword;
	
	@DataProvider(name="clinicDoctorDetails")
	public Object[][] clinicDocInfo() throws Exception
	{
		Object[][] clinicDocInformation=TestUtils.getTableArray("TestData/rvmpAdmin_addDoctor.xls", "clinicDoctor", "ZOY2234PW");
		return(clinicDocInformation);
	}
	
	@Test(dataProvider="clinicDoctorDetails")
	public void editClinicDoctor(String emailID) throws Exception
	{
		admin.adminSignIn(admin_user, admin_password);
		changedPassword="Zoy12@"+Browser.randomalphabets();
		System.out.println("New password generated is "+changedPassword);
		admin.click_doctorsTab();
		admin.searchDoctorbyEmailID(emailID);
		admin.clickEditbutton();
		Browser.waitFortheID(Elements_NewAdminDoctors.firstName);
		admin.doctorChangePassword(changedPassword);
		closeapp();
		launchapp();
		doctorPage.SignIn(emailID, changedPassword);
		Browser.waitFortheID("dashBoard");
		System.out.println(emailID+" has been logged in with new changed password "+changedPassword);
		closeapp();
		launchapp();
		admin.adminSignIn(admin_user, admin_password);
		admin.click_doctorsTab();
		admin.searchDoctorbyEmailID(emailID);
		admin.clickEditbutton();
		Browser.waitFortheID(Elements_NewAdminDoctors.firstName);
		admin.doctorChangePassword("Zoylo@123");
		System.out.println(emailID+" password has been changed to Zoylo@123");
	}
	
	@BeforeClass
	public void launchapp() throws Exception
	{
		LoadBrowserProperties();
		Elements_NewAdminDoctors.newAdmin_DoctorPageProperties(); // loading the Elements
		Browser= new TestUtils(driver);
		admin=new NewAdminDoctorsPage(driver);
		doctorPage=new DoctorsPage(driver);
		Browser.openUrl("https://"+Environment_Name+".zoylo.com/login");
	}
	
	@AfterClass
	public void closeapp()
	{
		driver.quit();
	}
}
