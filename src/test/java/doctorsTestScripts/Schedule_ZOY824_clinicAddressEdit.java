package doctorsTestScripts;

import org.testng.annotations.AfterClass;
import org.testng.annotations.Test;
import org.testng.annotations.BeforeClass;
import testBase.DoctorsPage;
import testBase.LoadPropMac;
import testBase.TestUtils;

public class Schedule_ZOY824_clinicAddressEdit extends LoadPropMac
{
	public TestUtils Browser;
	public DoctorsPage doctorsPage;
	public String AddLineOne="Changed on 31 May 2017";
	public String CityLocality="Thirty One May";
	public String CityPincode="315017";
	
  @Test()
  public void testEditAddressAmenitiesServices() throws Exception
  {
	  doctorsPage.SignIn(DoctorsLogin_username, DoctorsLogin_password);
	  Thread.sleep(1000);
	  doctorsPage.editScheduleDefaultClinicAddress(AddLineOne, CityLocality, CityPincode);
  }

  @BeforeClass
	public void launchapp() throws Exception
	{
		LoadBrowserProperties();
		Browser= new TestUtils(driver);
		doctorsPage=new DoctorsPage(driver);
		driver.get(loginPage_Url);
	}
	
@AfterClass
	public void closeapp() throws Exception
	{
		Thread.sleep(3000);
		driver.close();
	}
}