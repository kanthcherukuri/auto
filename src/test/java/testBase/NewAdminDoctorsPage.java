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
} //End of class
