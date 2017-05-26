package doctorsTestScripts;



import org.testng.annotations.Test;
import org.testng.AssertJUnit;
import org.testng.annotations.Test;
import org.testng.Assert;
import org.testng.annotations.Test;
import org.testng.AssertJUnit;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import objectRepository.Elements_Admin;
import objectRepository.Elements_Recipients;
import testBase.AdminPage;
import testBase.DoctorsPage;
import testBase.LoadProp;
import testBase.LoadPropMac;
import testBase.TestUtils;

import org.testng.annotations.BeforeTest;

import java.awt.AWTException;
import java.awt.Robot;
import java.awt.event.KeyEvent;
import java.io.IOException;
import java.text.ParseException;
import java.util.concurrent.TimeUnit;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Point;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeClass;

public class Schedule_ZOY1004_Doctor_ConsultDurationCannotupdateWithExistingApp extends LoadPropMac
{
	public TestUtils Browser;
	public DoctorsPage docpage;
	public String duration="30";
	
	@Test()
	public void consultationDurationUpdate() throws Exception
	{
		docpage.SignIn(DoctorsLogin_usernameone, DoctorsLogin_passwordone);
		docpage.DoctorAppointmentBookingForToday("Saatwika", "Swathi", "7829292920", "adf@fd.com", "dfsdf");
		Thread.sleep(2000);
		driver.findElement(By.id("schedule")).click();
		Browser.waitforTextbyxpath("(//div[@class='day-title'])[1]", "Consultation");
		driver.findElement(By.id("consultation-min")).clear();
		Thread.sleep(3000);
		driver.findElement(By.id("consultation-min")).sendKeys(duration);
		//driver.findElement(By.xpath("sp-doc-conc-duration-label")).click();
		Browser.scrollbyxpath("//div[@class='sp-doc-clinic-schd-save-btn menu_links']");
		driver.findElement(By.xpath("//div[@class='sp-doc-clinic-schd-save-btn menu_links']")).click();
		Thread.sleep(3000);
		Browser.CheckNotificationMessage("Conflict with existing appointments, please cancel the appointments to change consultation duration.");	
	}
	
	@BeforeClass
	public void launchapp() throws Exception
	{
		LoadBrowserProperties();
		Elements_Admin.Admin_PageProperties(); // loading the Elements
		Elements_Recipients.Recipients_PageProperties();
		Browser= new TestUtils(driver);
		docpage=new DoctorsPage(driver);
		driver.get(recipient_url);
	}
	
	@AfterClass
	public void closeapp() throws InterruptedException
	{
		Thread.sleep(3000);
		driver.close();
	}
}
	