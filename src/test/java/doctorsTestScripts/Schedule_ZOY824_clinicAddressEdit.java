package doctorsTestScripts;

import org.apache.commons.lang3.text.WordUtils;
import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.Test;
import objectRepository.Elements_Doctors;
import objectRepository.Elements_Recipients;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.DataProvider;
import testBase.DoctorsPage;
import testBase.LoadPropMac;
import testBase.RecipientPage;
import testBase.TestUtils;

//@Author: Sagar Sen

public class Schedule_ZOY824_clinicAddressEdit extends LoadPropMac
{
	public TestUtils Browser;
	public DoctorsPage doctorsPage;
	public RecipientPage RecipientPage;
	public String othEditNameValue;
	
	@DataProvider(name="addAptdetail")
	  public Object[][] adAptInfo() throws Exception
	  {
		  Object[][] aptdetails=TestUtils.getTableArray("TestData/Doctors_TestData.xls", "Schedule", "ZOY824");
		  return(aptdetails);
	  }
	
	@Test(dataProvider="addAptdetail", priority=1)
	public void testEditAddressAmenitiesServices(String AddLineOne, String CityLocality, String CityPincode) throws Exception
	{
	  doctorsPage.SignIn(DoctorsLogin_usernametwo, DoctorsLogin_passwordtwo);
	  Thread.sleep(1000);
	  doctorsPage.editScheduleDefaultClinicAddress(AddLineOne, CityLocality, CityPincode);
	  Browser.waitforTextbyxpath("//div[@class='zy-status-wrapper']", "Clinic details updated successfully");
	}
	
//	@DataProvider(name="addAptdetails")
//	  public Object[][] adAptdetails() throws Exception
//	  {
//		  Object[][] aptdetails=TestUtils.getTableArray("TestData/Doctors_TestData.xls", "Schedule", "ZOY811");
//		  return(aptdetails);
//	  }
//	
//	@Test(dataProvider="addAptdetails",priority=2)
//	public void Edit_OtherClinicName_ZOY_2495(String firstName, String lastName, String Mobile, String mail, String prob) throws Exception
//	{
//		String radName=Browser.generateRandomString(6).toLowerCase();
//		othEditNameValue=WordUtils.capitalize(radName);
//		doctorsPage.DoctorAppointmentBookingForSunday(firstName, lastName, Mobile, mail, prob);
//		driver.findElement(By.id(Elements_Doctors.schedule)).click();
//		doctorsPage.switchClinicPracticeLoactions();
//		Browser.clickOnTheElementByXpath(Elements_Doctors.otherClinic_InactiveBtn);
//		Browser.waitforTextbyxpath("//div[@class='zy-status-wrapper']", "Conflict");
//		doctorsPage.cancelSundayAppt(); //cancel sunday appointment
//		driver.findElement(By.id(Elements_Doctors.schedule)).click();
//		doctorsPage.switchClinicPracticeLoactions();
//		doctorsPage.Edit_OtherClinicName(othEditNameValue);
//		Browser.waitforTextbyxpath("//div[@class='zy-status-wrapper']", "Clinic details updated successfully");
//		doctorsPage.doctorlogout();
//		RecipientPage.searchInZoyloMAP("Zombidoctor");
//		RecipientPage.bookAppointment();
//		Browser.waitforTextbyxpath(Elements_Recipients.doctorNameOnProfile, "Zombidoctor");
//		Browser.clickOnTheElementByID(Elements_Recipients.doctor_ProfilePlusMore);
//		String OtherClinicOnRecipient=Browser.getTextByXpath(Elements_Recipients.doctor_ProfileOtherClinicDropDown);
//		Assert.assertEquals(OtherClinicOnRecipient, othEditNameValue);
//	}

  @BeforeClass
	public void launchapp() throws Exception
	{
		LoadBrowserProperties();
		Browser= new TestUtils(driver);
		doctorsPage=new DoctorsPage(driver);
		RecipientPage=new RecipientPage(driver);
		driver.get(loginPage_Url);
	}
	
  @AfterClass
	public void closeapp() throws Exception
	{
		driver.quit();
	}
}