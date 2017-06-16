package testBase;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import objectRepository.Elements_NewAdminDoctors;
import objectRepository.Elements_Recipients;

public class NewAdminDoctorsPage extends LoadPropMac
{
	public WebDriver driver;
	public TestUtils Browser;
	
	public NewAdminDoctorsPage(WebDriver driver)
	{
		this.driver=driver;
		Browser=new TestUtils(driver);
		Elements_NewAdminDoctors.newAdmin_DoctorPageProperties();
	}
	
	//Methods from here
	/*
	 * @ Authour		: Sagar Sen
	 * @ Description	: This method is used to signIn as an admin
	 * @ Param			: username and password
	 * @ return			: NA
	 */
	public void adminSignIn (String username, String password)
	{
		Browser.waitFortheID("emailAddress");
		driver.findElement(By.id(Elements_Recipients.Recipient_UserName)).sendKeys(admin_user);
		driver.findElement(By.id(Elements_Recipients.Recipient_Password)).sendKeys(admin_password);
		driver.findElement(By.xpath(Elements_Recipients.Recipient_Button_Login)).click();	
	}
	
	/*
	 * @ Authour		: Sagar Sen
	 * @ Description	: This method is used to signIn as an admin user with restricted permissions
	 * @ Param			: username and password
	 * @ return			: NA
	 */
	public void adminUserSignIn(String adminUserName, String adminUserPassword)
	{
		Browser.waitFortheID("emailAddress");
		driver.findElement(By.id(Elements_Recipients.Recipient_UserName)).sendKeys(adminuser_user);
		driver.findElement(By.id(Elements_Recipients.Recipient_Password)).sendKeys(adminuser_password);
		driver.findElement(By.xpath(Elements_Recipients.Recipient_Button_Login)).click();
	}
	
	/*
	 * @ Authour		: Sagar Sen
	 * @ Description	: This method is used to click doctors tab on admin webmodule
	 * @ Param			: NA
	 * @ return			: NA
	 */
	public void doctorsTab_click()
	{
		driver.findElement(By.xpath(Elements_NewAdminDoctors.doctorLabel)).click();
	}
	
	/*
	 * @ Authour		: Sagar Sen
	 * @ Description	: This method is used to click ADD doctor button on admin webmodule
	 * @ Param			: NA
	 * @ return			: NA
	 */
	public void addDoctor_click()
	{
		driver.findElement(By.id(Elements_NewAdminDoctors.addDoctorButton)).click();
		Browser.waitFortheID(Elements_NewAdminDoctors.firstName);
	}
	
	/*
	 * @ Authour		: Sagar Sen
	 * @ Description	: This method is used to enter generic details of doctor on admin add doctor screen
	 * @ Param			: First, middle and last names, short name, email ID, mobile Number, password
	 * @ return			: NA
	 */
	public void doctorGenericDetails_Enter(String firstName, String MiddleName, String LastName, String ShortName, String emailID, String mobileNumber, String password)
	{
		driver.findElement(By.id(Elements_NewAdminDoctors.firstName)).sendKeys(firstName);
		driver.findElement(By.id(Elements_NewAdminDoctors.middleName)).sendKeys(MiddleName);
		driver.findElement(By.id(Elements_NewAdminDoctors.lastName)).sendKeys(LastName);
		driver.findElement(By.id(Elements_NewAdminDoctors.shortName)).sendKeys(ShortName);
		driver.findElement(By.id(Elements_NewAdminDoctors.emailID)).sendKeys(emailID);
		driver.findElement(By.id(Elements_NewAdminDoctors.mobileNumber)).sendKeys(mobileNumber);
		driver.findElement(By.id(Elements_NewAdminDoctors.password)).sendKeys(password);
	}
	
	/*
	 * @ Authour		: Sagar Sen
	 * @ Description	: This method is used to enter primary information tab details of doctor on admin add doctor screen
	 * @ Param			: is doctor Active, doctor workType, doctor housecall status, doc housecall fee, doctor's gender, doctors DOB, doctor's reg Num, doctors qualification, doctors prof tag, doctors specialization, doctor's practice line, about the doctor
	 * @ return			: NA
	 */
	public void primaryInfoDetails_Enter(String isActiveValue, String workTypeValue, String houseCallStatus, String houseCallFee, String genderValue, String DOB, String regNum, String qualification, String tag, String specialization, String practiceLine, String aboutDoc)
	{
		if(isActiveValue.equalsIgnoreCase("true"))
		{
			driver.findElement(By.id(Elements_NewAdminDoctors.Active)).click();
		}
		else
		{
			System.out.println("Doctor isActive is marked as false");
		}
		if(workTypeValue.equalsIgnoreCase("Hospital"))
		{
			driver.findElement(By.xpath(Elements_NewAdminDoctors.workTypeHospital)).click();
		}
		else
		{
			System.out.println("Work type is marked as hospital clinic");
		}
		if(houseCallStatus.equalsIgnoreCase("true"))
		{
			driver.findElement(By.id(Elements_NewAdminDoctors.houseCallActiveCheckBox)).click();
			driver.findElement(By.id(Elements_NewAdminDoctors.houseCallServiceFee)).sendKeys(houseCallFee);
		}
		else
		{
			System.out.println("House call is marked as false");
		}
		if(genderValue.equalsIgnoreCase("Male"))
		{
			Browser.actionbyid(Elements_NewAdminDoctors.gender, "Male");
			System.out.println("Gender of the doctor being entered is Male");
		}
		else
		{
			Browser.actionbyid(Elements_NewAdminDoctors.gender, "Female");
			System.out.println("Gender of the doctor being entered is Female");
		}
		driver.findElement(By.id(Elements_NewAdminDoctors.dateOfBirth)).sendKeys(DOB); //(MM/DD/YYYY)
		driver.findElement(By.id(Elements_NewAdminDoctors.medicalRegistrationNumber)).sendKeys(regNum);
		Browser.selectbyXpath(Elements_NewAdminDoctors.Qualification, qualification);
		Browser.selectbyXpath(Elements_NewAdminDoctors.professionalTag, tag);
		Browser.selectbyXpath(Elements_NewAdminDoctors.areaOfSpecialization, specialization);
		Browser.selectbyXpath(Elements_NewAdminDoctors.lineOfPractice, practiceLine);
		driver.findElement(By.id(Elements_NewAdminDoctors.aboutDoctor)).sendKeys(aboutDoc);
	}
} //End of class
