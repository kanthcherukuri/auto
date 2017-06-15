package testBase;

import org.openqa.selenium.WebDriver;

import objectRepository.Elements_NewAdminDoctors;

public class NewAdminDoctorsPage {
	
	public WebDriver driver;
	public TestUtils Browser;
	
	public NewAdminDoctorsPage(WebDriver driver)
	{
		this.driver=driver;
		Browser=new TestUtils(driver);
		Elements_NewAdminDoctors.newAdmin_DoctorPageProperties();
	}
	
	//Methods from here

}
