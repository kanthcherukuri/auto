package NewAdminScripts;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import objectRepository.Elements_NewAdminDoctors;
import testBase.LoadPropMac;
import testBase.NewAdminDoctorsPage;
import testBase.TestUtils;

//@Authour: Sagar Sen

public class ZOY2220_newAdmin_addHospitalDoctor extends LoadPropMac
{
	public TestUtils Browser;
	public NewAdminDoctorsPage admin;
	
	@DataProvider(name="clinicDoctorDetails")
	public Object[][] clinicDocInfo() throws Exception
	{
		Object[][] clinicDocInformation=TestUtils.getTableArray("TestData/rvmpAdmin_addDoctor.xls", "hospitalDoctor", "ZOY2220");
		return(clinicDocInformation);
	}
	
	@Test(dataProvider="clinicDoctorDetails")
	public void addHospitalDoctor(String firstName, String MiddleName, String	LastName, String ShortName, String emailID, String mobileNumber, String	password, String isActiveValue,	String genderValue, String	DOB, String	regNum, String	qualification, String tag, String specialization, String practiceLine, String aboutDoc, String practiceStartDate, String vacationStatus, String	vacationStartDate, String vacationEndDate, String hospitalWorkTypeStatus, String hospitalName, String hospitalFee, String zfcForHospital, String imageURL, String mondayStatus, String	mondayHospitalName, String	mondayStartTime, String	mondayEndTime, String tuesdayStatus, String	tuesdayHospitalName, String	tuesdayStartTime, String tuesdayEndTime, String	wednesdayStatus, String	wednesdayHospitalName, String	wednesdayStartTime, String	wednesdayEndTime, String thursdayStatus, String	thursdayHospitalName, String thursdayStartTime, String thursdayEndTime, String	fridayStatus, String fridayHospitalName, String	fridayStartTime, String	fridayEndTime) throws Exception
	{
		admin.doctorsTab_click();
		admin.addDoctor_click();
		admin.clickHospitalWorkType();
		admin.doctorGenericDetails_Enter(firstName, MiddleName, LastName, ShortName, emailID, mobileNumber, password);
		admin.hospitalDoctorPrimaryInfoDetails_Enter(isActiveValue, genderValue, DOB, regNum, qualification, tag, specialization, practiceLine, aboutDoc);
		admin.HospitalpracticeGenericDetails_DefaultClinic_Enter(practiceStartDate);
		admin.practiceDetails_Vacation_Enter(vacationStatus, vacationStartDate, vacationEndDate);
		admin.hospitalDoctorpracticeDetails_HospitalInfo_Enter(hospitalWorkTypeStatus, hospitalName, hospitalFee, zfcForHospital);
		if(hospitalWorkTypeStatus.equalsIgnoreCase("true"))
		{
			String verifyHospitalName=driver.findElement(By.xpath(Elements_NewAdminDoctors.hospitalTable_hospitalName)).getText();
			Assert.assertEquals(verifyHospitalName, hospitalName, "Hospital add verification");
		}
		admin.practiceDetails_GalleryInfo_Enter(imageURL);
		admin.hospitalDoctorworkDaysInfo_Enter(mondayStatus, mondayHospitalName, mondayStartTime, mondayEndTime, tuesdayStatus, tuesdayHospitalName, tuesdayStartTime, tuesdayEndTime, wednesdayStatus, wednesdayHospitalName, wednesdayStartTime, wednesdayEndTime, thursdayStatus, thursdayHospitalName, thursdayStartTime, thursdayEndTime, fridayStatus, fridayHospitalName, fridayStartTime, fridayEndTime);
		admin.clickSubmitDoctor();
		Browser.CheckNotificationMessage("Doctor created successfully");
		Thread.sleep(5000);
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
