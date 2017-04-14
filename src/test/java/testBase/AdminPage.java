package testBase;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import objectRepository.*;

public class AdminPage extends LoadPropMac
{
	public WebDriver driver;
	public TestUtils Browser;
	
	public AdminPage(WebDriver driver) throws Exception {
		this.driver=driver;
		Browser = new TestUtils(driver);
		Elements_Recipients.Recipients_PageProperties();
	}
	
	

	public void adminSignIn (String username, String password)
	{
		Browser.waitFortheID("emailAddress");
		driver.findElement(By.id(Elements_Recipients.Recipient_UserName)).sendKeys(admin_user);
		driver.findElement(By.id(Elements_Recipients.Recipient_Password)).sendKeys(admin_password);
		driver.findElement(By.xpath(Elements_Recipients.Recipient_Button_Login)).click();
		
		
	}
}
