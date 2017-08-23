package doctorsTestScripts;

import org.testng.annotations.AfterClass;
import org.testng.annotations.Test;
import org.testng.annotations.BeforeClass;
import org.testng.Assert;
import org.openqa.selenium.By;
import org.testng.annotations.DataProvider;
import objectRepository.Elements_Doctors;
import testBase.DoctorsPage;
import testBase.LoadPropMac;
import testBase.TestUtils;

public class Appointment_ZOY2140_checkOutScenraio extends LoadPropMac
{
	public TestUtils Browser;
	public DoctorsPage doctorsPage;
	
	@DataProvider(name="Dataname")
	public Object[][] docapt() throws Exception
	{
		Object[][] datacells=TestUtils.getTableArray("TestData/Doctors_TestData.xls","docApt", "ZOY2140");
		return(datacells);
	}
	@Test(dataProvider="Dataname")
	public void checkoutScenario(String firstName, String lastName, String Mobile, String mail, String prob) throws Exception
	{
		doctorsPage.SignIn(DoctorsLogin_username, DoctorsLogin_password);
		doctorsPage.DoctorAppointmentBookingForToday(firstName, lastName, Mobile, mail, prob);
		Thread.sleep(2000);
		doctorsPage.CheckPateintScreenForCheckInFunctionality(firstName, lastName, mail);
		driver.findElement(By.id(Elements_Doctors.patient_clickoncheckinbutton)).click();
		Thread.sleep(1000);
		driver.findElement(By.id(Elements_Doctors.patient_clickonstartconsulationbutton)).click();
		Browser.waitFortheID("prognosis");
		driver.findElement(By.id(Elements_Doctors.patient_prognosis)).sendKeys("Normal");
		driver.findElement(By.id(Elements_Doctors.patient_diagnosis)).sendKeys("Done");
		driver.findElement(By.id(Elements_Doctors.patient_saveproblems)).click();
		Browser.CheckNotificationMessage("Saved successfully");
		driver.findElement(By.id(Elements_Doctors.patient_height)).sendKeys("5");
		Thread.sleep(1000);
		driver.findElement(By.id(Elements_Doctors.patient_heightinches)).sendKeys("9");
		Thread.sleep(1000);
		driver.findElement(By.id(Elements_Doctors.patient_weight)).sendKeys("83");
		Thread.sleep(3000);
		driver.findElement(By.id(Elements_Doctors.patient_savevitals)).click();
		Browser.CheckNotificationMessage("Saved successfully");
		driver.findElement(By.id(Elements_Doctors.patient_druginstructions)).sendKeys("Crocin");
		Thread.sleep(1000);
		driver.findElement(By.id(Elements_Doctors.patient_strenght)).sendKeys("2");
		Thread.sleep(1000);
		driver.findElement(By.xpath(Elements_Doctors.patient_medicinetime)).click();
		Thread.sleep(3000);
		driver.findElement(By.id(Elements_Doctors.patient_saveprescription)).click();
		Browser.CheckNotificationMessage("Saved successfully");
		driver.findElement(By.id(Elements_Doctors.patient_consultationnotes)).sendKeys("Normal");
		Thread.sleep(4000);
		driver.findElement(By.id(Elements_Doctors.patient_savenotes)).click();
		Browser.CheckNotificationMessage("Saved successfully");
		Thread.sleep(6000);
		driver.findElement(By.id(Elements_Doctors.patient_generatereciept)).click();
		Browser.CheckNotificationMessage("Bill generated successfully");
		Thread.sleep(2000);
		driver.findElement(By.id("notes")).click();
		Thread.sleep(2000);
		driver.findElement(By.id(Elements_Doctors.patient_consultationnotes)).clear();
		driver.findElement(By.id(Elements_Doctors.patient_consultationnotes)).sendKeys("Normal edit");
		Thread.sleep(3000);
		driver.findElement(By.id(Elements_Doctors.patient_savenotes)).click();
		Thread.sleep(3000);
		if(driver.findElements(By.id(Elements_Doctors.patient_clickoncheckoutbutton)).size()!=0)
		{
			driver.findElement(By.id(Elements_Doctors.patient_clickoncheckoutbutton)).click();
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
		driver.get("https://"+Environment_Name+".zoylo.com/login");
	}
	
	@AfterClass
	public void closeapp() throws Exception
	{
		driver.quit();
	}
}
