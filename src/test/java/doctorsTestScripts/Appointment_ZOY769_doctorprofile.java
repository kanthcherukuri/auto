package doctorsTestScripts;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.AfterClass;
import org.testng.annotations.Test;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.DataProvider;

import java.util.concurrent.TimeUnit;
import testBase.DoctorsPage;
import testBase.LoadPropMac;
import testBase.TestUtils;

public class Appointment_ZOY769_doctorprofile extends LoadPropMac{
	
	public DoctorsPage DoctorsPage;
	public TestUtils Browser;
	
		@BeforeClass
		public void beforeClass() throws Exception {
		LoadBrowserProperties(); 
		 DoctorsPage= new DoctorsPage(driver);
		 Browser= new TestUtils(driver); 
		 Browser.openUrl(loginPage_Url);
		 driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		 DoctorsPage.SignIn(DoctorsLogin_usernameone, DoctorsLogin_passwordone);
		  }  
		
		@DataProvider(name = "Profile")
		  public Object[][] createData_DP1() throws Exception{
		      Object[][] retObjArr=TestUtils.getTableArray("TestData/DoctorProvider.xls","Doctor", "ZOY769");
		      return(retObjArr);
		  }

	@Test(dataProvider="Profile")
	public void doctorprofileverification(String qualification,String Specialisation,String lineofPractice,String about,
	String membership,String certification,String website,String journal,String books) throws Exception{
	DoctorsPage.ClickingOnEllipse();
	Thread.sleep(2000);
	Browser.clickOnTheElementByID("account_accountIcon");
	Browser.waitTill(3000);
	((JavascriptExecutor)driver).executeScript("scroll(0,400)");
	driver.findElement(By.id("editAboutInfo")).click();
	Browser.waitFortheID("doctorQualification");
	WebElement element=driver.findElement(By.id("doctorQualification")); 
	Select se= new Select(element);
	se.selectByValue(qualification);
	Browser.waitFortheElementXpath(".//*[@id='areaOfSpecialisations']/div[2]/span/span[1]/span/ul");
	 Browser.actionbyXpath(".//*[@id='areaOfSpecialisations']/div[2]/span/span[1]/span/ul", Specialisation);
	 Browser.waitFortheElementXpath(".//*[@id='lineOfPractice']/div[2]/span/span[1]/span/ul");
	 Browser.actionbyXpath(".//*[@id='lineOfPractice']/div[2]/span/span[1]/span/ul", lineofPractice);
	 Browser.waitFortheID("aboutField");
	 driver.findElement(By.id("aboutField")).clear();
	 Browser.enterTextByID("aboutField", about);
	 Browser.clickOnTheElementByID("saveAboutInfo");
	 Thread.sleep(2000);
	 Browser.waitFortheElementXpath("//*[@id='myTabs']/li[2]/a");
	 Browser.clickOnTheElementByXpath("//*[@id='myTabs']/li[2]/a");
	 Browser.waitFortheID("editProfileAwards");
	 Browser.clickOnTheElementByID("editProfileAwards");
	 Browser.waitFortheID("membership");
	 driver.findElement(By.id("membership")).clear();
	 Browser.enterTextByID("membership", membership);
	 Browser.waitFortheID("certifications");
	 driver.findElement(By.id("certifications")).clear();
	 Browser.enterTextByID("certifications", certification);
	 Browser.waitFortheID("saveAwards");
	 Browser.clickOnTheElementByID("saveAwards");
	 Thread.sleep(2000);
	 Browser.waitFortheElementXpath("//*[@id='myTabs']/li[3]/a/span[2]");
	 Browser.clickOnTheElementByXpath("//*[@id='myTabs']/li[3]/a/span[2]");
	 Browser.clickOnTheElementByID("online");
	 Browser.clickOnTheElementByID("cheque");
	 Browser.clickOnTheElementByID("debitCard");
	 Browser.clickOnTheElementByID("creditCard");
	 Browser.clickOnTheElementByID("cash");
	 Browser.clickOnTheElementByID("doctor_edit_save");
	 Thread.sleep(2000);
	 Browser.waitFortheElementXpath("//*[@id='myTabs']/li[4]/a");
	 Browser.clickOnTheElementByXpath("//*[@id='myTabs']/li[4]/a");
	 Browser.waitFortheID("editAddInfo");
	 Browser.clickOnTheElementByID("editAddInfo");
	 Browser.waitFortheID("website");
	 driver.findElement(By.id("website")).clear();
	 Browser.enterTextByID("website", website);
	 Browser.waitFortheID("twitter");
	driver.findElement(By.id("twitter")).clear();
	Browser.enterTextByID("twitter", journal);
	Browser.waitFortheID("books");
	driver.findElement(By.id("books")).clear();
	Browser.enterTextByID("books", books);
	Thread.sleep(2000);
	Browser.clickOnTheElementByID("saveAddInfo");
	Thread.sleep(3000);
	DoctorsPage.doctorlogout();
	

	
	//String DoctorEmail= Browser.emailResponse("kanthzoylo@gmail.com", "zoylo@123", "Zoylo.com | Your profile is successfully updated.");	
	//Assert.assertTrue(DoctorEmail.contains("Your profile on Zoylo.com is successfully updated."));
	
	}
	
	
	@AfterClass
	public void closebrowser(){
		driver.quit();
	}
	}
