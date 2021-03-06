package zoyloMT;
import org.testng.annotations.AfterClass;
import org.testng.annotations.Test;
import org.testng.annotations.BeforeClass;
import org.testng.AssertJUnit;
import org.openqa.selenium.By;
import org.testng.annotations.DataProvider;
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
		Browser.openUrl("https://"+Zmt_environmentname+".com/contact-us");
		zmtUserPage.contactUs_Details(Name, Gender, Age, Country, City, email, phone, message);
		Browser.scrollbyID(Elements_ZMTusers.contactUs_submitButton);
		Thread.sleep(400);
		Browser.clickOnTheElementByID(Elements_ZMTusers.contactUs_submitButton);
		String nameValidation=driver.findElement(By.xpath(Elements_ZMTusers.contactUs_name_validation)).getText();
		String genderValidation=driver.findElement(By.xpath(Elements_ZMTusers.contactUs_gender_validation)).getText();
		String ageValidation=driver.findElement(By.xpath(Elements_ZMTusers.contactUs_age_validation)).getText();
		String countryValidation=driver.findElement(By.xpath(Elements_ZMTusers.contactUs_country_validation)).getText();
		String cityValidation=driver.findElement(By.xpath(Elements_ZMTusers.contactUs_city_validation)).getText();
		String emailValidation=driver.findElement(By.xpath(Elements_ZMTusers.contactUs_email_validation)).getText();
		String phoneValidation=driver.findElement(By.xpath(Elements_ZMTusers.contactUs_phone_validation)).getText();
		String messageValidation=driver.findElement(By.xpath(Elements_ZMTusers.contactUs_message_validation)).getText();
		AssertJUnit.assertEquals(AName, nameValidation);
		AssertJUnit.assertEquals(AGender, genderValidation);
		AssertJUnit.assertEquals(AAge, ageValidation);
		AssertJUnit.assertEquals(ACountry, countryValidation);
		AssertJUnit.assertEquals(ACity, cityValidation);
		AssertJUnit.assertEquals(Aemail, emailValidation);
		AssertJUnit.assertEquals(Aphone, phoneValidation);
		AssertJUnit.assertEquals(Amessage, messageValidation);
	}
	
	@BeforeClass
	public void launchapp() throws Exception
	{
		LoadBrowserProperties();
		Browser= new TestUtils(driver);
		zmtUserPage= new ZMTPage(driver);
		Browser.openUrl("https://"+Zmt_environmentname+".com/contact-us");
	}
	
	@AfterClass
	public void closeapp()
	{
		driver.quit();
	}
}