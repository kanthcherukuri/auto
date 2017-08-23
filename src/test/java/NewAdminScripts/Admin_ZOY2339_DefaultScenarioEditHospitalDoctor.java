package NewAdminScripts;

import java.util.concurrent.TimeUnit;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import objectRepository.Elements_NewAdminDoctors;
import testBase.LoadPropMac;
import testBase.NewAdminDoctorsPage;
import testBase.TestUtils;

public class Admin_ZOY2339_DefaultScenarioEditHospitalDoctor extends LoadPropMac
{
	public TestUtils Browser;
	public NewAdminDoctorsPage admin;
	public String emailID="excel6@zoy.com";
	public String hospitalEditBtns="(//i[@class='fa fa-pencil zoyEditHospitalBtn'])";
	
	@Test()
	public void DefaultCheckBoxEditHospitalDoctor() throws Exception
	{
		admin.click_doctorsTab();
		//driver.get("https://zoyloqa.zoylo.com/admin/serviceProvidersEdit/abtqiELRhNQetTHDQ");
		admin.searchDoctorbyEmailID(emailID);
		admin.clickEditbutton();
		Browser.clickOnTheElementByID(Elements_NewAdminDoctors.practiceTab);
		Browser.clickOnTheElementByXpath(Elements_NewAdminDoctors.HospitalTab);
		if(driver.findElements(By.xpath(hospitalEditBtns)).size()>0)
		{
			int getCount=driver.findElements(By.xpath(hospitalEditBtns)).size();
			System.out.println("No of hositals mapped to doctor are "+getCount);
			for(int i=1;i<=getCount;i++)
			{
				Browser.clickOnTheElementByXpath("(//i[@class='fa fa-pencil zoyEditHospitalBtn'])["+i+"]");
				Browser.waitFortheID(Elements_NewAdminDoctors.hospitalpopUpName);
				if(driver.findElements(By.id(Elements_NewAdminDoctors.hospitalpopUpDefaultCheckBox)).isEmpty())
				{
					Assert.fail();
					System.out.println("IsDefault checkBox is not displaying for hospital "+i+" out of "+getCount+" hospitals");
				}
				else
				{
					System.out.println("IsDefault checkBox is displaying for hospital "+i+" out of "+getCount+" hospitals");
				}
				Browser.clickOnTheElementByID(Elements_NewAdminDoctors.hospitalpopUpCancelButton);
				Thread.sleep(500);
			}
		}
		else
		{
			System.out.println("There are no hospitals mapped to this doctor");
		}
		Browser.clickOnTheElementByID(Elements_NewAdminDoctors.doctorCancel);
	}
	
	@BeforeClass
	public void launchapp() throws Exception
	{
		LoadBrowserProperties();
		driver.get("https://"+Environment_Name+".zoylo.com/login");
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
