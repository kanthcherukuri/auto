package recipientsTestScripts;

import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.Test;

import org.testng.annotations.BeforeClass;
import org.openqa.selenium.By;
import objectRepository.Elements_Admin;
import objectRepository.Elements_Recipients;
import testBase.LoadPropMac;
import testBase.RecipientPage;
import testBase.TestUtils;

//@ Author: Sagar Sen

public class Recipient_ZOY1977_ValidateDirectionsNegativeScenario extends LoadPropMac
{
	public TestUtils Browser;
	public RecipientPage RecipientPage;
	
	@Test(priority=1,enabled=false)
	public void validateDirectionsnegativeScenario() throws InterruptedException
	{
		RecipientPage.recipientLogin(Recipient_Username, Recipient_Password);
		Thread.sleep(2000);
		RecipientPage.searchInZoyloMAP(Doctor_Name);
		RecipientPage.bookAppointment();
		String distance = RecipientPage.addressAssertion();
		String distanceOnProfile[]=distance.split("\\.");
		System.out.println("Actual distance on profile is is "+distanceOnProfile[0]);
		Thread.sleep(1000);
		Browser.clickOnTheElementByID(Elements_Recipients.backBtn);
		Browser.waitforTextbyxpath(Elements_Recipients.selectFirstDoctorFromListingPage, "Doctorzoylo");
		String distanceListing=Browser.getTextByXpath(Elements_Recipients.getDistanceFromListingForFirstDoctor);
		String actualDistance[]=distanceListing.split("\\.");
		System.out.println("Actual distance is "+actualDistance[0]);
		Assert.assertEquals(distanceOnProfile[0].replaceAll(" ", ""), actualDistance[0].replaceAll(" ", ""));
		RecipientPage.bookAppointment();
		//driver.findElement(By.id("session4")).click();
		//Thread.sleep(1000);
		RecipientPage.selectDefaultSlot();
		Browser.waitforTextbyxpath("//h1[contains(., 'Book Appointment')]", "Book Appointment");
		driver.navigate().refresh();
		driver.findElement(By.xpath("//a[@class='cancel']")).click();
		RecipientPage.addressAssertion();
	}
	
	//@Author:Ch.LakshmiKanth
	@Test(priority=2)
	public void CompareOfDefaultClinicDiatanceAndHospitalDistance() throws Exception {
	
		driver.get(index_url);
		RecipientPage.searchInZoyloMAP("kanth doctor");
		RecipientPage.bookAppointment();
		Browser.waitFortheElementXpath(Elements_Recipients.addressAssertion);
		driver.findElement(By.xpath(Elements_Recipients.addressAssertion)).click();
		Thread.sleep(1000);
		String currentavailableclinic=driver.findElement(By.xpath("//span[@class='icon-distance']/following-sibling::*")).getText();
		System.out.println("Available:"+currentavailableclinic);
		Thread.sleep(2000);
		String[] available=currentavailableclinic.split(" kms");
		String defaultclinic=available[0];
		System.out.println("Printing Available Clinic After Split:"+defaultclinic);
		double AvailableDefaultClinic=Double.parseDouble(defaultclinic);
		System.out.println("Double value of available:"+AvailableDefaultClinic);
		driver.findElement(By.xpath("//i[@class='fa fa-plus']/following-sibling::*")).click();
		System.out.println("Clicked on Plus Symbol");
		Browser.clickOnTheElementByXpath("//div[@class='sp-moreclinic-address sp-clinic-address']//h5//a");
		Browser.clickOnTheElementByXpath(" (//span[@class='docinfo-address-label'])[2]");
		System.out.println("clicked on second time Address");
		Thread.sleep(1000);
		String Hospital=driver.findElement(By.xpath("(//span[@class='icon-distance']/following-sibling::*)[2]")).getText();
		System.out.println("AvailableHospital:"+Hospital);
		String[] other=Hospital.split(" kms");
		String otherlocation=other[0];
		System.out.println("Other location after Split:"+otherlocation);
		double OtherClinic=Double.parseDouble(otherlocation);
		System.out.println("Other loctaion after Double:"+OtherClinic);
		Assert.assertTrue(AvailableDefaultClinic<OtherClinic);
		
	}
	
	@BeforeClass
	public void launchbrowser() throws Exception
	{
		LoadBrowserProperties();
		Elements_Admin.Admin_PageProperties(); // loading the Elements
		Elements_Recipients.Recipients_PageProperties();
		Browser= new TestUtils(driver);
		RecipientPage=new RecipientPage(driver);
		driver.get(loginPage_Url);
	}
	
	@AfterClass()
	public void Exit() {
		
		driver.quit();
	} 
}
