package doctorsTestScripts;

import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import testBase.DoctorsPage;
import testBase.LoadPropMac;
import testBase.TestUtils;

public class Schedule_ZOY824_ZOY827_ZOY829_Doctor_Edit extends LoadPropMac
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
		driver.get(recipient_url);
	}
	
@AfterClass
	public void closeapp() throws Exception
	{
		Thread.sleep(3000);
		driver.close();
	}
}