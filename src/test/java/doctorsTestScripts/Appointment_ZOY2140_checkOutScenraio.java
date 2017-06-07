package doctorsTestScripts;

import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import objectRepository.Elements_Doctors;
import testBase.DoctorsPage;
import testBase.LoadPropMac;
import testBase.TestUtils;

public class Appointment_ZOY2140_checkOutScenraio extends LoadPropMac
{
	public TestUtils Browser;
	public DoctorsPage doctorsPage;
	
	public String firstName="June";
	public String lastName="Sevenone";
	public String Mobile="9870000000";
	public String mail="june7_1@gmail.com";
	public String prob="This is my problem";
	
	@Test()
	public void checkoutScenario() throws Exception
	{
		doctorsPage.SignIn(DoctorsLogin_username, DoctorsLogin_password);
		doctorsPage.DoctorAppointmentBookingForToday(firstName, lastName, Mobile, mail, prob);
		Thread.sleep(2000);
		doctorsPage.CheckPateintScreenForCheckInFunctionality(firstName, lastName, mail);
		driver.findElement(By.id(Elements_Doctors.clickoncheckinbutton)).click();
		Thread.sleep(1000);
		driver.findElement(By.id(Elements_Doctors.clickonstartconsulationbutton)).click();
		Browser.waitFortheID("prognosis");
		driver.findElement(By.id(Elements_Doctors.prognosis)).sendKeys("Normal");
		driver.findElement(By.id(Elements_Doctors.diagnosis)).sendKeys("Done");
		driver.findElement(By.id(Elements_Doctors.saveproblems)).click();
		Browser.CheckNotificationMessage("Saved successfully");
		driver.findElement(By.id(Elements_Doctors.height)).sendKeys("5");
		Thread.sleep(1000);
		driver.findElement(By.id(Elements_Doctors.heightinches)).sendKeys("9");
		Thread.sleep(1000);
		driver.findElement(By.id(Elements_Doctors.weight)).sendKeys("83");
		Thread.sleep(3000);
		driver.findElement(By.id(Elements_Doctors.savevitals)).click();
		Browser.CheckNotificationMessage("Saved successfully");
		driver.findElement(By.id(Elements_Doctors.druginstructions)).sendKeys("Crocin");
		Thread.sleep(1000);
		driver.findElement(By.id(Elements_Doctors.strenght)).sendKeys("2");
		Thread.sleep(1000);
		driver.findElement(By.xpath(Elements_Doctors.medicinetime)).click();
		Thread.sleep(3000);
		driver.findElement(By.id(Elements_Doctors.saveprescription)).click();
		Browser.CheckNotificationMessage("Saved successfully");
		driver.findElement(By.id(Elements_Doctors.consultationnotes)).sendKeys("Normal");
		Thread.sleep(4000);
		driver.findElement(By.id(Elements_Doctors.savenotes)).click();
		Browser.CheckNotificationMessage("Saved successfully");
		Thread.sleep(6000);
		driver.findElement(By.id(Elements_Doctors.generatereciept)).click();
		Browser.CheckNotificationMessage("Bill generated successfully");
		Thread.sleep(2000);
		driver.findElement(By.id("notes")).click();
		Thread.sleep(2000);
		driver.findElement(By.id(Elements_Doctors.consultationnotes)).clear();
		driver.findElement(By.id(Elements_Doctors.consultationnotes)).sendKeys("Normal edit");
		Thread.sleep(3000);
		driver.findElement(By.id(Elements_Doctors.savenotes)).click();
		Thread.sleep(3000);
		if(driver.findElements(By.id(Elements_Doctors.clickoncheckoutbutton)).size()!=0)
		{
			driver.findElement(By.id(Elements_Doctors.clickoncheckoutbutton)).click();
		}
		else
		{
			System.out.println("Check out butotn is not visible");
			Assert.fail("Check out butotn is not visible");
		}
	}
	
	@BeforeClass
	public void launchapp() throws Exception
	{
		LoadBrowserProperties();
		Browser= new TestUtils(driver);
		doctorsPage=new DoctorsPage(driver);
		driver.get(recipient_url);
	}
	
	@AfterClass
	public void closeapp() throws Exception
	{
		driver.close();
	}
}
