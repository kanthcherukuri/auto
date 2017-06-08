package doctorsTestScripts;

import org.testng.annotations.AfterClass;
import org.testng.annotations.Test;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.DataProvider;

import testBase.DoctorsPage;
import testBase.LoadPropMac;
import testBase.TestUtils;

public class Schedule_ZOY824_clinicAddressEdit extends LoadPropMac
{
	public TestUtils Browser;
	public DoctorsPage doctorsPage;
	@DataProvider(name="addAptdetail")
	  public Object[][] adAptInfo() throws Exception
	  {
		  Object[][] aptdetails=TestUtils.getTableArray("TestData/Doctors_TestData.xls", "Schedule", "ZOY824");
		  return(aptdetails);
	  }
	
	@Test(dataProvider="addAptdetail")
  public void testEditAddressAmenitiesServices(String AddLineOne, String CityLocality, String CityPincode) throws Exception
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