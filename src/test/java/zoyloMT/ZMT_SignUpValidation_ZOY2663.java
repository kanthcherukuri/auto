
//Author:Ch.LakshmiKanth
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

public class ZMT_SignUpValidation_ZOY2663 extends LoadPropMac
{
	public TestUtils Browser;
	public ZMTPage zmtUserPage;
	
	
	@BeforeClass
	public void LaunchBrowser() throws Exception {
		LoadBrowserProperties();
		Browser= new TestUtils(driver);
		zmtUserPage= new ZMTPage(driver);
		Browser.openUrl("https://qa.zoylomt.com");
	}
	
	@DataProvider(name="zmtvalidation")
	public Object[][] clinicDocInfo() throws Exception
	{
		Object[][] clinicDocInformation=TestUtils.getTableArray("TestData/zmt.xls", "validation", "ZMT2663");
		return(clinicDocInformation);
	}
	
	
	
	
	
	@Test(dataProvider="zmtvalidation")
	public void CheckingSignupValidations(String fname, String lname, String email, String country, String state, String password, String confirmPassword, String phnum, String functionalArea, String address,
			String Afname, String Alname, String Aemail, String Acountry, String Astate, String Apassword,String AconfirmPassword,String Aphnum, String AfunctionalArea, String Aaddress) throws Exception {
		
		Browser.clickOnTheElementByID(Elements_ZMTusers.zmt_login);
		Browser.clickOnTheElementByXpath(Elements_ZMTusers.zmt_SignUp_Button);
		Thread.sleep(1000);
		zmtUserPage.SignUpForm_Details(fname, lname, email, country, state, password, confirmPassword, phnum, functionalArea, address);
		Browser.clickOnTheElementByID(Elements_ZMTusers.signUp_submit);
		String firstname=driver.findElement(By.xpath("//input[@id='signUpFirstName']//following-sibling::ul")).getText();
		System.out.println("firts name is : "+firstname);
		Assert.assertEquals(firstname, Afname);
		String lastname=driver.findElement(By.xpath("//input[@id='signUpLastName']//following-sibling::ul")).getText();
		Assert.assertEquals(lastname, Alname);
		String emailone= driver.findElement(By.xpath("//input[@id='signUpEmail']//following-sibling::ul")).getText();
		Assert.assertEquals(emailone, Aemail);
		String count= driver.findElement(By.xpath("//select[@id='signUpCountry']//following-sibling::ul")).getText();
		Assert.assertEquals(count, Acountry);
		String stateone= driver.findElement(By.xpath("//select[@id='signUpCity']//following-sibling::ul")).getText();
		Assert.assertEquals(stateone, Astate);
		String passw= driver.findElement(By.xpath("//input[@id='signUpPassword']//following-sibling::ul")).getText();
		Assert.assertEquals(passw, Apassword);
		String confirmpass= driver.findElement(By.xpath("//input[@id='signUpConfirmPassword']//following-sibling::ul")).getText();
		System.out.println("Matching text:"+confirmpass);
		Assert.assertEquals(confirmpass, AconfirmPassword);
		System.out.println("Password:"+ AconfirmPassword);
		if (password!=confirmPassword) {
			
			String notmathching= driver.findElement(By.xpath("//span[@id='passwordMatchErr']")).getText();
			System.out.println("Not Mached Text:"+notmathching);
			Assert.assertEquals(notmathching, "Password and Confirm Password does not match");	
		}
		String phno= driver.findElement(By.xpath("//input[@id='signUpPhone']//following-sibling::ul")).getText();
		Assert.assertEquals(phno, Aphnum);
		String area= driver.findElement(By.xpath("//select[@id='signUpFunctional']//following-sibling::ul")).getText();
		Assert.assertEquals(area, AfunctionalArea);
		String addres= driver.findElement(By.xpath("//textarea[@id='signUpAddress']//following-sibling::ul")).getText();
		Assert.assertEquals(addres, Aaddress);
		Thread.sleep(1000);
		driver.findElement(By.xpath("//div[@id='signupForm']//button")).click();
		driver.navigate().refresh();
		Thread.sleep(1000);
		
	}
	
	@AfterClass
	public void CloseBrowser() {
		driver.quit();
	}

}
