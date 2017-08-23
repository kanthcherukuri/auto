package recipientsTestScripts;



import org.testng.annotations.AfterClass;
import org.testng.annotations.Test;
import org.testng.annotations.BeforeClass;
import org.testng.Assert;
import org.openqa.selenium.*;

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
			Browser.openUrl("https://"+Environment_Name+".zoylo.com/login");			
			//Verify Recipient Login with valid details
			RecipientPage.recipientLogin(Recipient2_Username, Recipient2_Password);	
			RecipientPage.searchInZoyloMAP("srscript");
			Browser.waitFortheElementXpath("//div[@class='dctr-desig']");
			String DoctorFullName = driver.findElement(By.xpath("//h1")).getText();
			System.out.println("Doctor is"+DoctorFullName);
			RecipientPage.bookAppointment();
			RecipientPage.selectHomeVisitSlot();
			RecipientPage.confirmAppointment("Test Details");
			RecipientPage.makePayment();
			String SuccessfullMesg = driver.findElement(By.cssSelector("h5")).getText();
			Assert.assertEquals(SuccessfullMesg, "Thank you for booking appointment with "+DoctorFullName+" through Zoylo. Your appointment booking details are below:");


		}else{

			throw new SkipException("RUNMODE IS OFF");

		}


	}

	@AfterClass(groups = { "Regression","High" })

	public void Exit() {
		driver.quit();
	}





}