package recipientsTestScripts;



import org.testng.annotations.AfterClass;
import org.testng.annotations.Test;
import org.testng.annotations.BeforeClass;
import org.testng.AssertJUnit;
import org.openqa.selenium.*;

import org.testng.Assert;

import org.testng.SkipException;
import org.testng.annotations.*;

import testBase.*;
import objectRepository.*;

public class Recipient_ZOY1089_ValidateRecipientsBookingAnHomeVisitForDoctor extends LoadPropMac {
	public RecipientPage RecipientPage;
	public TestUtils Browser;	
	public HomePage HomePage;




	@BeforeClass(groups = { "Regression","High" })	
	public void LaunchBrowser() throws Exception {

		LoadBrowserProperties(); // Create driver instance and launch the browser
		Elements_Recipients.Recipients_PageProperties();// loading UI Page Elements / Locators
		RecipientPage = new RecipientPage(driver); // Loading Pages
		HomePage = new HomePage(driver);
		Browser= new TestUtils(driver);        

	} 


	@DataProvider(name = "DP1")
	public String[][] createData1() {
		return new String[][] {
			{ "yes","Hyderabad" }

		};
	}
	@Test(dataProvider="DP1",groups = { "Regression","High" })
	public void validateRecipientsBookingAnHomeVisitForDoctor(String runmode,String City ) throws Exception {

		if(runmode.equals("yes")){



			//Test Starts-Here
			Browser.openUrl(recipient_url);			
			//Verify Recipient Login with valid details
			RecipientPage.recipientLogin(Recipient_Username, Recipient_Password);
			Thread.sleep(10000);
			//Searching Locality/Area
			RecipientPage.searchInZoyloMAPArea(City);
			RecipientPage.clickOnFilterImg();
			//Verify Specialization Filter Option
			RecipientPage.ApplyFilter("Home Visits","homeVisit", "doesHouseCalls","");
			Thread.sleep(5000);
			RecipientPage.searchInZoylodetailMAP("srscript");
			Browser.waitFortheElementXpath("//div[@class='dctr-desig']");
			String DoctorFullName = driver.findElement(By.xpath("//h1")).getText();
			System.out.println("Doctor is"+DoctorFullName);
			RecipientPage.bookAppointment();
			RecipientPage.selectDefaultSlot();
			RecipientPage.confirmAppointment("Test Details");
			RecipientPage.makePayment();
			String SuccessfullMesg = driver.findElement(By.cssSelector("h5")).getText();
			AssertJUnit.assertEquals(SuccessfullMesg, "Thank you for booking appointment with "+DoctorFullName+" through Zoylo. Your appointment booking details are below:");
			RecipientPage.recipientLogout();


		}else{

			throw new SkipException("RUNMODE IS OFF");

		}


	}






	@AfterClass(groups = { "Regression","High" })

	public void Exit() {


		driver.close();


	}





}