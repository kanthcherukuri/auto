package zoyloMT;
import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import objectRepository.Elements_ZMTusers;
import testBase.LoadPropMac;
import testBase.TestUtils;
import testBase.ZMTPage;

//@Author: Sagar Sen

public class ZMT_contactUs_ZOY2658 extends LoadPropMac
{
	public TestUtils Browser;
	public ZMTPage zmtUserPage;
	public String gender="Male";
	public String age="25";
	public String country="India";
	public String city="Hyderabad";
	public String email="gurucharan.a@zoylo.com";
	public String number="9999999999";
	public String message="Contactus message";
	
	@Test(priority=1)
	public void zmtContactUs() throws Exception
	{
		String email1=Browser.generateRandomString(6);
		String fname="A"+email1.toLowerCase();
		zmtUserPage.contactUs_Details(fname, gender, age, country, city, email, number, message);
		Browser.clickOnTheElementByID(Elements_ZMTusers.contactUs_submitButton);
		Browser.zmt_notification("Thank you for your interest, our customer care team will get back to you soon");
	}
	
	@DataProvider(name="zmt")
	public Object[][] contactUs() throws Exception
	{
		Object[][] contactUsinfo=TestUtils.getTableArray("TestData/zmt.xls", "users", "ZMT2664");
		return(contactUsinfo);
	}
	
	@Test(priority=2, dataProvider="zmt")
	public void zmtContactUs_Validation_ZOY2664(String Name, String Gender, String Age, String Country, String City, String email, String phone, String message, String AName, String AGender, String AAge, String ACountry, String	ACity, String Aemail, String Aphone, String	Amessage) throws Exception
	{
		Browser.openUrl("https://qa.zoylomt.com/contact-us");
		zmtUserPage.contactUs_Details(Name, Gender, Age, Country, City, email, phone, message);
		Browser.clickOnTheElementByID(Elements_ZMTusers.contactUs_submitButton);
		String nameValidation=driver.findElement(By.xpath("//input[@id='contactUsName']/following-sibling::ul")).getText();
		String genderValidation=driver.findElement(By.xpath("//select[@id='contactUsGender']/following-sibling::ul")).getText();
		String ageValidation=driver.findElement(By.xpath("//input[@id='contactUsAge']/following-sibling::ul")).getText();
		String countryValidation=driver.findElement(By.xpath("//select[@id='searchCountry']/following-sibling::ul")).getText();
		String cityValidation=driver.findElement(By.xpath("//select[@id='searchCity']/following-sibling::ul")).getText();
		String emailValidation=driver.findElement(By.xpath("//input[@id='contactUsEmail']/following-sibling::ul")).getText();
		String phoneValidation=driver.findElement(By.xpath("//input[@id='contactUsPhone']/following-sibling::ul")).getText();
		String messageValidation=driver.findElement(By.xpath("//textarea[@id='contactUsMessage']/following-sibling::ul")).getText();
		Assert.assertEquals(AName, nameValidation);
		Assert.assertEquals(AGender, genderValidation);
		Assert.assertEquals(AAge, ageValidation);
		Assert.assertEquals(ACountry, countryValidation);
		Assert.assertEquals(ACity, cityValidation);
		Assert.assertEquals(Aemail, emailValidation);
		Assert.assertEquals(Aphone, phoneValidation);
		Assert.assertEquals(Amessage, messageValidation);
	}
	
	@BeforeClass
	public void launchapp() throws Exception
	{
		LoadBrowserProperties();
		Browser= new TestUtils(driver);
		zmtUserPage= new ZMTPage(driver);
		Browser.openUrl("https://qa.zoylomt.com/contact-us");
	}
	
	@AfterClass
	public void closeapp()
	{
		driver.quit();
	}
}