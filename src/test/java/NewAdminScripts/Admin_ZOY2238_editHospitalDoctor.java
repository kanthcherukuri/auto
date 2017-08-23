package NewAdminScripts;

import org.openqa.selenium.By;
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
	public String mandateSpec="Unani";
	public String nonmandateSpec="Regnotreq";
	
	@DataProvider(name="clinicDoctorDetails")
	public Object[][] clinicDocInfo() throws Exception
	{
		Object[][] clinicDocInformation=TestUtils.getTableArray("TestData/rvmpAdmin_addDoctor.xls", "hospitalDoctor", "ZOY2238");
		return(clinicDocInformation);
	}
	
	@Test(dataProvider="clinicDoctorDetails")
	public void editHospitalDoctorANDZOY_2442_validateMedRegNumNotMandatory(String emailID) throws Exception
	{
		String alfamed=Browser.generateRandomAlphaNumeric(5).toLowerCase();
		String intt=Browser.generateRandomNumber(3);
		String medNum=intt+alfamed;
		admin.click_doctorsTab();
		admin.searchDoctorbyEmailID(emailID);
		admin.clickEditbutton();
		admin.Validate_RegNumNotMandatory(mandateSpec, nonmandateSpec);
		driver.navigate().refresh();
		admin.click_doctorsTab();
		admin.searchDoctorbyEmailID(emailID);
		admin.clickEditbutton();
		Browser.waitFortheID(Elements_NewAdminDoctors.medicalRegistrationNumber);
		driver.findElement(By.id(Elements_NewAdminDoctors.medicalRegistrationNumber)).clear();
		Browser.enterTextByID(Elements_NewAdminDoctors.medicalRegistrationNumber, medNum);
		Browser.clickOnTheElementByXpath("//li[@title='"+nonmandateSpec+"']//span[@class='select2-selection__choice__remove']");
		Browser.selectbyID(Elements_NewAdminDoctors.areaOfSpecialization, mandateSpec);
		System.out.println("Added "+mandateSpec+ " as specialization");
		admin.clickSubmitDoctor();
		Browser.CheckNotificationMessage("Doctor Updated Successfully");
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
