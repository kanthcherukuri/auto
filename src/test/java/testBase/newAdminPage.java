package testBase;

import org.openqa.selenium.WebDriver;

import objectRepository.Elements_NewAdmin;

public class newAdminPage 
{
	public WebDriver driver;
	public TestUtils Browser;
	
	public newAdminPage(WebDriver driver)
	{
		this.driver=driver;
		Browser=new TestUtils(driver);
		Elements_NewAdmin.newAdmin_PageProperties();
	}
	
	//Methods from here
}