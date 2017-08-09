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
	public void CompareOfHospitalDistanceLessThanDefaultClinicDistance() throws Exception {
	
		driver.get(index_url);
		RecipientPage.searchInZoyloMAP("doctor honey");
		RecipientPage.bookAppointment();	
		Browser.clickOnTheElementByXpath("//div[@style='display: block;']//span[@class='docinfo-address-label']");
		System.out.println("Clicked on Default avialable Clinic Address Button");
		Thread.sleep(2000);
		String availableclinicdistance=driver.findElement(By.xpath("//div[@style='display: block;']//span[@class='icon-distance']/following-sibling::*")).getText();
		System.out.println("Got Availableclinic diatance:"+availableclinicdistance);
		Thread.sleep(2000);
		String[] available=availableclinicdistance.split(" kms");
		String defaultclinic=available[0];
		double AvailableDefaultClinic=Double.parseDouble(defaultclinic);
		System.out.println("Printing Available Clinic After Split:"+AvailableDefaultClinic);
		Browser.clickOnTheElementByXpath("//div[@style='display: block;']//span[@style='padding-left: 10px;']");
		//Browser.clickOnTheElementByID("manage-flip");
		System.out.println("Clicked on Plus Symbol");
		Browser.waitFortheElementXpath("//div[@style='display: block;']//h5//a");
		int size=driver.findElements(By.xpath("//div[@style='display: block;']//h5//a")).size();
		System.out.println("Size of Other Clinics:"+size);
		Thread.sleep(1000);
		for(int i=1;i<=size;i++) {
			driver.findElement(By.xpath("(//div[@style='display: block;']//h5//a)["+i+"]")).click();
			Browser.clickOnTheElementByXpath("//div[@style='display: block;']//span[@class='docinfo-address-label']");
	String 	otherClinic=	Browser.getTextByXpath("//div[@style='display: block;']//span[@class='icon-distance']/following-sibling::*");
			System.out.println("Other Clinic:"+otherClinic);
			String[] Hospital =otherClinic.split(" kms");
			String otherlocation=Hospital[0];
			double OtherClinic=Double.parseDouble(otherlocation);
			System.out.println("After Spliting of Hospital:"+OtherClinic);
			Assert.assertTrue(AvailableDefaultClinic<OtherClinic);
			Browser.clickOnTheElementByXpath("//div[@style='display: block;']//span[@style='padding-left: 10px;']");
			Thread.sleep(1000);
			}	
			}
		
	//@Author:Ch.LakshmiKanth
	@Test(priority=3)
	public void CompareOfDefaultClinicDiatanceLessThanHospitalDistance() throws Exception {
		driver.get(index_url);
		RecipientPage.searchInZoyloMAP("kanth doctor");
		RecipientPage.bookAppointment();	
		Browser.clickOnTheElementByXpath("//div[@style='display: block;']//span[@class='docinfo-address-label']");
		System.out.println("Clicked on Default avialable Clinic Address Button");
		Thread.sleep(2000);
		String availableclinicdistance=driver.findElement(By.xpath("//div[@style='display: block;']//span[@class='icon-distance']/following-sibling::*")).getText();
		System.out.println("Got Availableclinic diatance:"+availableclinicdistance);
		Thread.sleep(2000);
		String[] available=availableclinicdistance.split(" kms");
		String defaultclinic=available[0];
		double AvailableDefaultClinic=Double.parseDouble(defaultclinic);
		System.out.println("Printing Available Clinic After Split:"+AvailableDefaultClinic);
		Browser.clickOnTheElementByXpath("//div[@style='display: block;']//span[@style='padding-left: 10px;']");
		//Browser.clickOnTheElementByID("manage-flip");
		System.out.println("Clicked on Plus Symbol");
		Browser.waitFortheElementXpath("//div[@style='display: block;']//h5//a");
		int size=driver.findElements(By.xpath("//div[@style='display: block;']//h5//a")).size();
		System.out.println("Size of Other Clinics:"+size);
		Thread.sleep(1000);
		for(int i=1;i<=size;i++) {
			driver.findElement(By.xpath("(//div[@style='display: block;']//h5//a)["+i+"]")).click();
			Browser.clickOnTheElementByXpath("//div[@style='display: block;']//span[@class='docinfo-address-label']");
	String 	otherClinic=	Browser.getTextByXpath("//div[@style='display: block;']//span[@class='icon-distance']/following-sibling::*");
			System.out.println("Other Clinic:"+otherClinic);
			String[] Hospital =otherClinic.split(" kms");
			String otherlocation=Hospital[0];
			double OtherClinic=Double.parseDouble(otherlocation);
			System.out.println("After Spliting of Hospital:"+OtherClinic);
			Assert.assertTrue(AvailableDefaultClinic<OtherClinic);
			Browser.clickOnTheElementByXpath("//div[@style='display: block;']//span[@style='padding-left: 10px;']");
			Thread.sleep(1000);
			}	
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
	
//	@AfterClass()
//	public void Exit() {
//		
//		driver.quit();
//	} 
}
